package com.yangjiang.controller.t_zgk_pipe_fcm;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zgk_pipe_fcm.T_ZGK_PIPE_FCMEntity;
import com.yangjiang.service.t_zgk_pipe_fcm.T_ZGK_PIPE_FCMServiceI;

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
 * @Description: 返厂主表
 * @author zhangdaihao
 * @date 2016-12-06 11:29:36
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_FCMController")
public class T_ZGK_PIPE_FCMController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_FCMController.class);

	@Autowired
	private T_ZGK_PIPE_FCMServiceI t_ZGK_PIPE_FCMService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 返厂主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_fcm/t_ZGK_PIPE_FCMList");
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
	public void datagrid(T_ZGK_PIPE_FCMEntity t_ZGK_PIPE_FCM,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_FCMEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_FCM, request.getParameterMap());
		this.t_ZGK_PIPE_FCMService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除返厂主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_FCMEntity t_ZGK_PIPE_FCM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_FCM = systemService.getEntity(T_ZGK_PIPE_FCMEntity.class, t_ZGK_PIPE_FCM.getId());
		message = "返厂主表删除成功";
		t_ZGK_PIPE_FCMService.delete(t_ZGK_PIPE_FCM);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加返厂主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_FCMEntity t_ZGK_PIPE_FCM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_FCM.getId())) {
			message = "返厂主表更新成功";
			T_ZGK_PIPE_FCMEntity t = t_ZGK_PIPE_FCMService.get(T_ZGK_PIPE_FCMEntity.class, t_ZGK_PIPE_FCM.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_ZGK_PIPE_FCM, t);
				t_ZGK_PIPE_FCMService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "返厂主表更新失败";
			}
		} else {
			message = "返厂主表添加成功";
			t_ZGK_PIPE_FCMService.save(t_ZGK_PIPE_FCM);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 返厂主表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_FCMEntity t_ZGK_PIPE_FCM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_FCM.getId())) {
			t_ZGK_PIPE_FCM = t_ZGK_PIPE_FCMService.getEntity(T_ZGK_PIPE_FCMEntity.class, t_ZGK_PIPE_FCM.getId());
			req.setAttribute("t_ZGK_PIPE_FCMPage", t_ZGK_PIPE_FCM);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_fcm/t_ZGK_PIPE_FCM");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_FCMEntity> list() {
		List<T_ZGK_PIPE_FCMEntity> listT_ZGK_PIPE_FCMs=t_ZGK_PIPE_FCMService.getList(T_ZGK_PIPE_FCMEntity.class);
		return listT_ZGK_PIPE_FCMs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_FCMEntity task = t_ZGK_PIPE_FCMService.get(T_ZGK_PIPE_FCMEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_FCMEntity t_ZGK_PIPE_FCM, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_FCMEntity>> failures = validator.validate(t_ZGK_PIPE_FCM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_FCMService.save(t_ZGK_PIPE_FCM);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_FCM.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_FCMController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_FCMEntity t_ZGK_PIPE_FCM) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_FCMEntity>> failures = validator.validate(t_ZGK_PIPE_FCM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_FCMService.saveOrUpdate(t_ZGK_PIPE_FCM);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_FCMService.deleteEntityById(T_ZGK_PIPE_FCMEntity.class, id);
	}
}
