package com.yangjiang.controller.batch;
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

import com.yangjiang.entity.batch.t_zg_batchEntity;
import com.yangjiang.service.batch.t_zg_batchServiceI;

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
 * @Description: 批号
 * @author zhangdaihao
 * @date 2016-10-09 15:41:46
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_zg_batchController")
public class t_zg_batchController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(t_zg_batchController.class);

	@Autowired
	private t_zg_batchServiceI t_zg_batchService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	

	
	/**
	 * 批号列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/batch/t_zg_batchList");
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
	public void datagrid(t_zg_batchEntity t_zg_batch,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(t_zg_batchEntity.class, dataGrid);
		//查询条件组装器
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_zg_batch, request.getParameterMap());
		this.t_zg_batchService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除批号
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(t_zg_batchEntity t_zg_batch, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_zg_batch = systemService.getEntity(t_zg_batchEntity.class, t_zg_batch.getId());
		message = "批号删除成功";
		t_zg_batchService.delete(t_zg_batch);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加批号
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(t_zg_batchEntity t_zg_batch, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_zg_batch.getId())) {
			message = "批号更新成功";
			t_zg_batchEntity t = t_zg_batchService.get(t_zg_batchEntity.class, t_zg_batch.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_zg_batch, t);
				t_zg_batchService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "批号更新失败";
			}
		} else {
			message = "批号添加成功";
			//String dn=t_zg_batch.getDn();
			t_zg_batchService.save(t_zg_batch);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批号列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(t_zg_batchEntity t_zg_batch, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_zg_batch.getId())) {
			t_zg_batch = t_zg_batchService.getEntity(t_zg_batchEntity.class, t_zg_batch.getId());
			req.setAttribute("t_zg_batchPage", t_zg_batch);
		}
		return new ModelAndView("com/yangjiang/batch/t_zg_batch");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<t_zg_batchEntity> list() {
		List<t_zg_batchEntity> listt_zg_batchs=t_zg_batchService.getList(t_zg_batchEntity.class);
		return listt_zg_batchs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		t_zg_batchEntity task = t_zg_batchService.get(t_zg_batchEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody t_zg_batchEntity t_zg_batch, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<t_zg_batchEntity>> failures = validator.validate(t_zg_batch);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_zg_batchService.save(t_zg_batch);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_zg_batch.getId();
		URI uri = uriBuilder.path("/rest/t_zg_batchController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody t_zg_batchEntity t_zg_batch) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<t_zg_batchEntity>> failures = validator.validate(t_zg_batch);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_zg_batchService.saveOrUpdate(t_zg_batch);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_zg_batchService.deleteEntityById(t_zg_batchEntity.class, id);
	}
}
