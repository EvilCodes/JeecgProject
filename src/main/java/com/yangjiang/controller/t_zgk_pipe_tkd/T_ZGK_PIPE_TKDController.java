package com.yangjiang.controller.t_zgk_pipe_tkd;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.entity.t_zgk_pipe_tkd.T_ZGK_PIPE_TKDEntity;
import com.yangjiang.service.t_zgk_pipe_tkd.T_ZGK_PIPE_TKDServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 退库子表
 * @author zhangdaihao
 * @date 2016-11-25 18:01:23
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_TKDController")
public class T_ZGK_PIPE_TKDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_TKDController.class);

	@Autowired
	private T_ZGK_PIPE_TKDServiceI t_ZGK_PIPE_TKDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 退库子表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_tkd/t_ZGK_PIPE_TKDList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(T_ZGK_PIPE_TKDEntity t_ZGK_PIPE_TKD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_TKDEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_TKD, request.getParameterMap());
		this.t_ZGK_PIPE_TKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除退库子表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_TKDEntity t_ZGK_PIPE_TKD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_TKD = systemService.getEntity(T_ZGK_PIPE_TKDEntity.class, t_ZGK_PIPE_TKD.getId());
		message = "退库子表删除成功";
		t_ZGK_PIPE_TKDService.delete(t_ZGK_PIPE_TKD);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加退库子表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_TKDEntity t_ZGK_PIPE_TKD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		try{
			String jsondata=request.getParameter("data");	
			String tuikudanid=request.getParameter("tuikudanid");	
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);						
				for(int i=0;i<dataArr.size();i++){
					System.out.println("dataArr.size():"+dataArr.size());
					System.out.println("i:"+i);
					JSONObject dataObj = dataArr.getJSONObject(i);
					T_ZGK_PIPE_TKDEntity pipe = (T_ZGK_PIPE_TKDEntity) JSONHelper.json2Object(dataObj.toString(), T_ZGK_PIPE_TKDEntity.class);	
					if(pipe.getCengci()==null){
						pipe.setCengci(dataObj.getInt("cengci"));
					}
					if(pipe.getPipenum()==null){
						pipe.setPipenum(dataObj.getInt("pipenum"));
					}
					System.out.println(pipe.getCengneixuhao());
					if(pipe.getTuikudanid()==null){
						pipe.setTuikudanid(tuikudanid);
					}
					//pipe.setExpFlag(00);
					t_ZGK_PIPE_TKDService.save(pipe);
				}
			}else{
				message="参数错误！请检查参数信息";
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setMsg(message);
		}catch (Exception e) {
			e.printStackTrace();
			message="添加失败，"+e;
		}
		return j;
	}

	/**
	 * 退库子表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_TKDEntity t_ZGK_PIPE_TKD, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_TKD.getId())) {
			t_ZGK_PIPE_TKD = t_ZGK_PIPE_TKDService.getEntity(T_ZGK_PIPE_TKDEntity.class, t_ZGK_PIPE_TKD.getId());
			req.setAttribute("t_ZGK_PIPE_TKDPage", t_ZGK_PIPE_TKD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_tkd/t_ZGK_PIPE_TKD");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_TKDEntity> list() {
		List<T_ZGK_PIPE_TKDEntity> listT_ZGK_PIPE_TKDs=t_ZGK_PIPE_TKDService.getList(T_ZGK_PIPE_TKDEntity.class);
		return listT_ZGK_PIPE_TKDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_TKDEntity task = t_ZGK_PIPE_TKDService.get(T_ZGK_PIPE_TKDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_TKDEntity t_ZGK_PIPE_TKD, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_TKDEntity>> failures = validator.validate(t_ZGK_PIPE_TKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_TKDService.save(t_ZGK_PIPE_TKD);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_TKD.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_TKDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_TKDEntity t_ZGK_PIPE_TKD) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_TKDEntity>> failures = validator.validate(t_ZGK_PIPE_TKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_TKDService.saveOrUpdate(t_ZGK_PIPE_TKD);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_TKDService.deleteEntityById(T_ZGK_PIPE_TKDEntity.class, id);
	}
}
