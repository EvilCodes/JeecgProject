package com.yangjiang.controller.t_myjk_fyjh_bak_red;
import java.util.Date;
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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_myjk_fyjh_bak_red.T_MYJK_FYJH_BAK_REDEntity;
import com.yangjiang.entity.t_zgk_pipe_ck_hcz.T_ZGK_PIPE_CK_HCZEntity;
import com.yangjiang.service.t_myjk_fyjh_bak_red.T_MYJK_FYJH_BAK_REDServiceI;

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
 * @Description: 被动红冲
 * @author zhangdaihao
 * @date 2017-03-14 17:33:01
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_MYJK_FYJH_BAK_REDController")
public class T_MYJK_FYJH_BAK_REDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_MYJK_FYJH_BAK_REDController.class);

	@Autowired
	private T_MYJK_FYJH_BAK_REDServiceI t_MYJK_FYJH_BAK_REDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 被动红冲列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_fyjh_bak_red/t_MYJK_FYJH_BAK_REDList");
	}

	@RequestMapping(params="doCheck")
	@ResponseBody
	public AjaxJson doCheck(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				T_MYJK_FYJH_BAK_REDEntity act =t_MYJK_FYJH_BAK_REDService.get(T_MYJK_FYJH_BAK_REDEntity.class, idsAttr[i]);
				
				act.setShsj(new Date());
				act.setShbz("1");
				String edituser=ResourceUtil.getSessionUserName().getUserName();
				act.setShr(edituser);
				
				
				t_MYJK_FYJH_BAK_REDService.saveOrUpdate(act);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_MYJK_FYJH_BAK_REDService.do?doCheck>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
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
	public void datagrid(T_MYJK_FYJH_BAK_REDEntity t_MYJK_FYJH_BAK_RED,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_FYJH_BAK_REDEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_FYJH_BAK_RED, request.getParameterMap());
		this.t_MYJK_FYJH_BAK_REDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除被动红冲
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_MYJK_FYJH_BAK_REDEntity t_MYJK_FYJH_BAK_RED, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_MYJK_FYJH_BAK_RED = systemService.getEntity(T_MYJK_FYJH_BAK_REDEntity.class, t_MYJK_FYJH_BAK_RED.getId());
		message = "被动红冲删除成功";
		t_MYJK_FYJH_BAK_REDService.delete(t_MYJK_FYJH_BAK_RED);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加被动红冲
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_MYJK_FYJH_BAK_REDEntity t_MYJK_FYJH_BAK_RED, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_MYJK_FYJH_BAK_RED.getId())) {
			message = "被动红冲更新成功";
			T_MYJK_FYJH_BAK_REDEntity t = t_MYJK_FYJH_BAK_REDService.get(T_MYJK_FYJH_BAK_REDEntity.class, t_MYJK_FYJH_BAK_RED.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_MYJK_FYJH_BAK_RED, t);
				t_MYJK_FYJH_BAK_REDService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "被动红冲更新失败";
			}
		} else {
			message = "被动红冲添加成功";
			t_MYJK_FYJH_BAK_REDService.save(t_MYJK_FYJH_BAK_RED);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 被动红冲列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_MYJK_FYJH_BAK_REDEntity t_MYJK_FYJH_BAK_RED, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_MYJK_FYJH_BAK_RED.getId())) {
			t_MYJK_FYJH_BAK_RED = t_MYJK_FYJH_BAK_REDService.getEntity(T_MYJK_FYJH_BAK_REDEntity.class, t_MYJK_FYJH_BAK_RED.getId());
			req.setAttribute("t_MYJK_FYJH_BAK_REDPage", t_MYJK_FYJH_BAK_RED);
		}
		return new ModelAndView("com/yangjiang/t_myjk_fyjh_bak_red/t_MYJK_FYJH_BAK_RED");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_MYJK_FYJH_BAK_REDEntity> list() {
		List<T_MYJK_FYJH_BAK_REDEntity> listT_MYJK_FYJH_BAK_REDs=t_MYJK_FYJH_BAK_REDService.getList(T_MYJK_FYJH_BAK_REDEntity.class);
		return listT_MYJK_FYJH_BAK_REDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_MYJK_FYJH_BAK_REDEntity task = t_MYJK_FYJH_BAK_REDService.get(T_MYJK_FYJH_BAK_REDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_MYJK_FYJH_BAK_REDEntity t_MYJK_FYJH_BAK_RED, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_FYJH_BAK_REDEntity>> failures = validator.validate(t_MYJK_FYJH_BAK_RED);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_FYJH_BAK_REDService.save(t_MYJK_FYJH_BAK_RED);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_MYJK_FYJH_BAK_RED.getId();
		URI uri = uriBuilder.path("/rest/t_MYJK_FYJH_BAK_REDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_MYJK_FYJH_BAK_REDEntity t_MYJK_FYJH_BAK_RED) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_FYJH_BAK_REDEntity>> failures = validator.validate(t_MYJK_FYJH_BAK_RED);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_FYJH_BAK_REDService.saveOrUpdate(t_MYJK_FYJH_BAK_RED);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_MYJK_FYJH_BAK_REDService.deleteEntityById(T_MYJK_FYJH_BAK_REDEntity.class, id);
	}
}
