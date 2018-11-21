package com.yangjiang.controller.t_zgk_pipe_hckd;
import java.util.Date;
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
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zgk_pipe_ck_hcz.T_ZGK_PIPE_CK_HCZEntity;
import com.yangjiang.entity.t_zgk_pipe_ckd.T_ZGK_PIPE_CKDEntity;
import com.yangjiang.entity.t_zgk_pipe_hckd.T_ZGK_PIPE_HCKDEntity;
import com.yangjiang.service.t_zgk_pipe_ckd.T_ZGK_PIPE_CKDServiceI;
import com.yangjiang.service.t_zgk_pipe_hckd.T_ZGK_PIPE_HCKDServiceI;

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
 * @Description: 火车装车
 * @author zhangdaihao
 * @date 2017-03-28 17:32:24
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_HCKDController")
public class T_ZGK_PIPE_HCKDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_HCKDController.class);

	@Autowired
	private T_ZGK_PIPE_HCKDServiceI t_ZGK_PIPE_HCKDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private T_ZGK_PIPE_CKDServiceI ckdService;
	


	/**
	 * 火车装车列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_hckd/t_ZGK_PIPE_HCKDList");
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
	public void datagrid(T_ZGK_PIPE_HCKDEntity t_ZGK_PIPE_HCKD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_HCKDEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_HCKD, request.getParameterMap());
		this.t_ZGK_PIPE_HCKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除火车装车
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_HCKDEntity t_ZGK_PIPE_HCKD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_HCKD = systemService.getEntity(T_ZGK_PIPE_HCKDEntity.class, t_ZGK_PIPE_HCKD.getId());
		message = "火车装车删除成功";
		t_ZGK_PIPE_HCKDService.delete(t_ZGK_PIPE_HCKD);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加火车装车
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_HCKDEntity t_ZGK_PIPE_HCKD, HttpServletRequest request) {
		String message = "装车成功！！！";
		AjaxJson j = new AjaxJson();
		try{
			String jsondata=request.getParameter("data");
			String sendNo=request.getParameter("sendNo");
			if(StringUtil.isNotEmpty(jsondata)){																			
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);
				System.out.println("dataArr.size():"+dataArr.size());
				for(int i=0;i<dataArr.size();i++){
					//生成火车装车单号：生成规则--》年月日+YT+顺序号;	
					
					JSONObject dataObj = dataArr.getJSONObject(i);
					
					T_ZGK_PIPE_HCKDEntity pcd = new T_ZGK_PIPE_HCKDEntity();					
					pcd.setChukudanid(sendNo);
					pcd.setBatchFull(dataObj.getString("batch_full"));
					pcd.setDn(dataObj.getString("dn"));
					pcd.setExpFlag(dataObj.getString("exp_flag"));
					pcd.setItemCname(dataObj.getString("item_cname"));
					pcd.setItemCode(dataObj.getString("item_code"));
					pcd.setPackageid(dataObj.getString("packageid"));
					pcd.setPipenum(dataObj.getInt("pipenum"));
					pcd.setPipeSerial(dataObj.getString("pipe_serial"));
					pcd.setProductLine(dataObj.getString("product_line"));
					pcd.setSpecialDesc(dataObj.getString("special_desc"));																				
					t_ZGK_PIPE_HCKDService.save(pcd);
					String id=dataObj.getString("id");
					T_ZGK_PIPE_CKDEntity ckd=ckdService.get(T_ZGK_PIPE_CKDEntity.class, id);
					ckd.setStatus("2");
					ckdService.save(ckd);
					System.out.println("BatchFull:"+pcd.getBatchFull());
					
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
	 * 火车装车列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_HCKDEntity t_ZGK_PIPE_HCKD, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_HCKD.getId())) {
			t_ZGK_PIPE_HCKD = t_ZGK_PIPE_HCKDService.getEntity(T_ZGK_PIPE_HCKDEntity.class, t_ZGK_PIPE_HCKD.getId());
			req.setAttribute("t_ZGK_PIPE_HCKDPage", t_ZGK_PIPE_HCKD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_hckd/t_ZGK_PIPE_HCKD");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_HCKDEntity> list() {
		List<T_ZGK_PIPE_HCKDEntity> listT_ZGK_PIPE_HCKDs=t_ZGK_PIPE_HCKDService.getList(T_ZGK_PIPE_HCKDEntity.class);
		return listT_ZGK_PIPE_HCKDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_HCKDEntity task = t_ZGK_PIPE_HCKDService.get(T_ZGK_PIPE_HCKDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_HCKDEntity t_ZGK_PIPE_HCKD, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_HCKDEntity>> failures = validator.validate(t_ZGK_PIPE_HCKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_HCKDService.save(t_ZGK_PIPE_HCKD);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_HCKD.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_HCKDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_HCKDEntity t_ZGK_PIPE_HCKD) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_HCKDEntity>> failures = validator.validate(t_ZGK_PIPE_HCKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_HCKDService.saveOrUpdate(t_ZGK_PIPE_HCKD);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_HCKDService.deleteEntityById(T_ZGK_PIPE_HCKDEntity.class, id);
	}
}
