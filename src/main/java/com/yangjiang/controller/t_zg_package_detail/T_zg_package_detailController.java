package com.yangjiang.controller.t_zg_package_detail;
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

import com.yangjiang.entity.t_zg_package_detail.T_zg_package_detailEntity;
import com.yangjiang.service.t_zg_package_detail.T_zg_package_detailServiceI;

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
 * @Description: 打包子表
 * @author zhangdaihao
 * @date 2016-12-20 14:12:41
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_zg_package_detailController")
public class T_zg_package_detailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_zg_package_detailController.class);

	@Autowired
	private T_zg_package_detailServiceI t_zg_package_detailService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 打包子表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zg_package_detail/t_zg_package_detailList");
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
	public void datagrid(T_zg_package_detailEntity t_zg_package_detail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_zg_package_detailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_zg_package_detail, request.getParameterMap());
		this.t_zg_package_detailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除打包子表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_zg_package_detailEntity t_zg_package_detail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_zg_package_detail = systemService.getEntity(T_zg_package_detailEntity.class, t_zg_package_detail.getId());
		message = "打包子表删除成功";
		t_zg_package_detailService.delete(t_zg_package_detail);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加打包子表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_zg_package_detailEntity t_zg_package_detail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_zg_package_detail.getId())) {
			message = "打包子表更新成功";
			T_zg_package_detailEntity t = t_zg_package_detailService.get(T_zg_package_detailEntity.class, t_zg_package_detail.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_zg_package_detail, t);
				t_zg_package_detailService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "打包子表更新失败";
			}
		} else {
			message = "打包子表添加成功";
			t_zg_package_detailService.save(t_zg_package_detail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 打包子表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_zg_package_detailEntity t_zg_package_detail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_zg_package_detail.getId())) {
			t_zg_package_detail = t_zg_package_detailService.getEntity(T_zg_package_detailEntity.class, t_zg_package_detail.getId());
			req.setAttribute("t_zg_package_detailPage", t_zg_package_detail);
		}
		return new ModelAndView("com/yangjiang/t_zg_package_detail/t_zg_package_detail");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_zg_package_detailEntity> list() {
		List<T_zg_package_detailEntity> listt_zg_package_details=t_zg_package_detailService.getList(T_zg_package_detailEntity.class);
		return listt_zg_package_details;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_zg_package_detailEntity task = t_zg_package_detailService.get(T_zg_package_detailEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_zg_package_detailEntity t_zg_package_detail, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_zg_package_detailEntity>> failures = validator.validate(t_zg_package_detail);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_zg_package_detailService.save(t_zg_package_detail);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_zg_package_detail.getId();
		URI uri = uriBuilder.path("/rest/t_zg_package_detailController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_zg_package_detailEntity t_zg_package_detail) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_zg_package_detailEntity>> failures = validator.validate(t_zg_package_detail);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_zg_package_detailService.saveOrUpdate(t_zg_package_detail);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_zg_package_detailService.deleteEntityById(T_zg_package_detailEntity.class, id);
	}
}
