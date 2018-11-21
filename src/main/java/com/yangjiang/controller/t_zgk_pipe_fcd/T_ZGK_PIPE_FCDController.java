package com.yangjiang.controller.t_zgk_pipe_fcd;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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

import com.yangjiang.entity.t_zgk_pipe_fcd.T_ZGK_PIPE_FCDEntity;
import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.service.t_zgk_pipe_fcd.T_ZGK_PIPE_FCDServiceI;

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
 * @Description: 返厂子表
 * @author zhangdaihao
 * @date 2016-12-06 11:30:11
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_FCDController")
public class T_ZGK_PIPE_FCDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_FCDController.class);

	@Autowired
	private T_ZGK_PIPE_FCDServiceI t_ZGK_PIPE_FCDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 返厂子表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_fcd/t_ZGK_PIPE_FCDList");
	}
	@RequestMapping(params = "list3")
	public ModelAndView list3(HttpServletRequest request) {
		request.setAttribute("fankudanid", request.getParameter("fankudanid"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_fcd/t_ZGK_PIPE_FCDList3");
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
	public void datagrid(T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_FCDEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_FCD, request.getParameterMap());
		this.t_ZGK_PIPE_FCDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	//@RequestMapping(params = "datagrid4")
	//public void datagrid4(T_ZGK_PIPE_RKDEntity rkd,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	//	CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKDEntity.class, dataGrid);
	//	String rukudanid=rkd.getRukudanid();
	//	cq.eq("rukudanid", rukudanid);
	//	cq.add();
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_RKM, request.getParameterMap());
		//this.t_ZGK_PIPE_RKDService.getDataGridReturn(cq, true);
	//	TagUtil.datagrid(response, dataGrid);
	//}
	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_FCDEntity.class, dataGrid);
		//查询条件组装器
		String rukudanid=t_ZGK_PIPE_FCD.getFankudanid();
		cq.eq("fankudanid", rukudanid);
		cq.add();
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_FCD, request.getParameterMap());
		this.t_ZGK_PIPE_FCDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除返厂子表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_FCD = systemService.getEntity(T_ZGK_PIPE_FCDEntity.class, t_ZGK_PIPE_FCD.getId());
		message = "返厂子表删除成功";
		t_ZGK_PIPE_FCDService.delete(t_ZGK_PIPE_FCD);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加返厂子表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD, HttpServletRequest request) {
		String message = "保存成功";
		AjaxJson j = new AjaxJson();
		String jsondata=request.getParameter("data");
		@SuppressWarnings("unused")
		String fankudanid=request.getParameter("fankudanid");
		try{
			System.out.println("jsondata:"+jsondata);
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);						
				for(int i=0;i<dataArr.size();i++){
					System.out.println("dataArr.size():"+dataArr.size());
					//System.out.println("i:"+i);
					net.sf.json.JSONObject dataObj = dataArr.getJSONObject(i);					
					T_ZGK_PIPE_FCDEntity pipe =new T_ZGK_PIPE_FCDEntity();
					pipe.setFankudanid(fankudanid);
					pipe.setBatchFull(dataObj.getString("batchFull"));	
					pipe.setDn(dataObj.getString("dn"));
					pipe.setPipeSerial(dataObj.getString("pipeSerial"));
					pipe.setPackageid(dataObj.getString("packageid"));
					pipe.setItemCode(dataObj.getString("itemCode"));
					pipe.setItemCname(dataObj.getString("itemCname"));
					pipe.setExpFlag(dataObj.getString("expFlag"));
					pipe.setSpecialDesc(dataObj.getString("specialDesc"));
					pipe.setPipenum(dataObj.getInt("pipenum"));
					pipe.setSuitWay("返厂");
					pipe.setHuowei(dataObj.getString("huowei"));
					pipe.setCengci(dataObj.getInt("cengci"));
					pipe.setCengneixuhao(dataObj.getInt("cengneixuhao"));
					t_ZGK_PIPE_FCDService.save(pipe);
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
	 * 返厂子表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_FCD.getId())) {
			t_ZGK_PIPE_FCD = t_ZGK_PIPE_FCDService.getEntity(T_ZGK_PIPE_FCDEntity.class, t_ZGK_PIPE_FCD.getId());
			req.setAttribute("t_ZGK_PIPE_FCDPage", t_ZGK_PIPE_FCD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_fcd/t_ZGK_PIPE_FCD");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_FCDEntity> list() {
		List<T_ZGK_PIPE_FCDEntity> listT_ZGK_PIPE_FCDs=t_ZGK_PIPE_FCDService.getList(T_ZGK_PIPE_FCDEntity.class);
		return listT_ZGK_PIPE_FCDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_FCDEntity task = t_ZGK_PIPE_FCDService.get(T_ZGK_PIPE_FCDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_FCDEntity>> failures = validator.validate(t_ZGK_PIPE_FCD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_FCDService.save(t_ZGK_PIPE_FCD);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_FCD.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_FCDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_FCDEntity t_ZGK_PIPE_FCD) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_FCDEntity>> failures = validator.validate(t_ZGK_PIPE_FCD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_FCDService.saveOrUpdate(t_ZGK_PIPE_FCD);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_FCDService.deleteEntityById(T_ZGK_PIPE_FCDEntity.class, id);
	}
}
