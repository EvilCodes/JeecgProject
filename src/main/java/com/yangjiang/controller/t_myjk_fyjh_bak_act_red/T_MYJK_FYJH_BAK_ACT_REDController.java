package com.yangjiang.controller.t_myjk_fyjh_bak_act_red;
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
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_myjk_fyjh.T_MYJK_FYJHEntity;
import com.yangjiang.entity.t_myjk_fyjh_bak_act_red.T_MYJK_FYJH_BAK_ACT_REDEntity;
import com.yangjiang.entity.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMEntity;
import com.yangjiang.service.t_myjk_fyjh_bak_act_red.T_MYJK_FYJH_BAK_ACT_REDServiceI;
import com.yangjiang.service.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMServiceI;

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
 * @Description: 数据红冲
 * @author zhangdaihao
 * @date 2017-03-09 16:28:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_MYJK_FYJH_BAK_ACT_REDController")
public class T_MYJK_FYJH_BAK_ACT_REDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_MYJK_FYJH_BAK_ACT_REDController.class);

	@Autowired
	private T_MYJK_FYJH_BAK_ACT_REDServiceI t_MYJK_FYJH_BAK_ACT_REDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private T_ZGK_PIPE_CKMServiceI t_ZGK_PIPE_CKMService;
	


	/**
	 * 数据红冲列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_fyjh_bak_act_red/t_MYJK_FYJH_BAK_ACT_REDList");
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
	public void datagrid(T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_FYJH_BAK_ACT_REDEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_FYJH_BAK_ACT_RED, request.getParameterMap());
		this.t_MYJK_FYJH_BAK_ACT_REDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除数据红冲
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_MYJK_FYJH_BAK_ACT_RED = systemService.getEntity(T_MYJK_FYJH_BAK_ACT_REDEntity.class, t_MYJK_FYJH_BAK_ACT_RED.getId());
		if(t_MYJK_FYJH_BAK_ACT_RED.getReadFlag()=="1"){
			message = "恭喜您，数据红冲已经成功，该条记录不能删除，请进行下一步操作！！！";
			j.setMsg(message);
			return j;
		}else{
			t_MYJK_FYJH_BAK_ACT_REDService.delete(t_MYJK_FYJH_BAK_ACT_RED);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			message = "删除成功！！！";
			j.setMsg(message);
			return j;
		}
		
		
		
		
	}


	/**
	 * 添加数据红冲
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		
		String jsondata1=request.getParameter("data");
		JSONArray dataArr1=JSONHelper.toJSONArray(jsondata1);
		JSONObject dataObj1 = dataArr1.getJSONObject(0);
		//String trnMode=dataObj1.getString("billNoticeNo");
		t_MYJK_FYJH_BAK_ACT_RED.setBillNoticeNo(dataObj1.getString("billNoticeNo"));
		t_MYJK_FYJH_BAK_ACT_RED.setSendNo(dataObj1.getString("sendNo"));
		t_MYJK_FYJH_BAK_ACT_RED.setBillLadingNoItem(dataObj1.getString("billLadingNoItem"));
		t_MYJK_FYJH_BAK_ACT_RED.setInsertDate(new Date());
		t_MYJK_FYJH_BAK_ACT_RED.setReadFlag("0");
		String username=ResourceUtil.getSessionUserName().getUserName();
		t_MYJK_FYJH_BAK_ACT_RED.setLrr(username);		
		t_MYJK_FYJH_BAK_ACT_REDService.save(t_MYJK_FYJH_BAK_ACT_RED);
		message="恭喜您，保存成功！！！";
		j.setMsg(message);
		return j;
	}

	/**
	 * 数据红冲列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_MYJK_FYJH_BAK_ACT_RED.getId())) {
			t_MYJK_FYJH_BAK_ACT_RED = t_MYJK_FYJH_BAK_ACT_REDService.getEntity(T_MYJK_FYJH_BAK_ACT_REDEntity.class, t_MYJK_FYJH_BAK_ACT_RED.getId());
			req.setAttribute("t_MYJK_FYJH_BAK_ACT_REDPage", t_MYJK_FYJH_BAK_ACT_RED);
		}
		return new ModelAndView("com/yangjiang/t_myjk_fyjh_bak_act_red/t_MYJK_FYJH_BAK_ACT_RED");
	}
	@RequestMapping(params = "addorupdate2")
	public ModelAndView addorupdate2(T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_MYJK_FYJH_BAK_ACT_RED.getId())) {
			t_MYJK_FYJH_BAK_ACT_RED = t_MYJK_FYJH_BAK_ACT_REDService.getEntity(T_MYJK_FYJH_BAK_ACT_REDEntity.class, t_MYJK_FYJH_BAK_ACT_RED.getId());
			req.setAttribute("t_MYJK_FYJH_BAK_ACT_REDPage", t_MYJK_FYJH_BAK_ACT_RED);
		}
		return new ModelAndView("com/yangjiang/t_myjk_fyjh_bak_act_red/t_MYJK_FYJH_BAK_ACT_RED_HC");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_MYJK_FYJH_BAK_ACT_REDEntity> list() {
		List<T_MYJK_FYJH_BAK_ACT_REDEntity> listT_MYJK_FYJH_BAK_ACT_REDs=t_MYJK_FYJH_BAK_ACT_REDService.getList(T_MYJK_FYJH_BAK_ACT_REDEntity.class);
		return listT_MYJK_FYJH_BAK_ACT_REDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_MYJK_FYJH_BAK_ACT_REDEntity task = t_MYJK_FYJH_BAK_ACT_REDService.get(T_MYJK_FYJH_BAK_ACT_REDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_FYJH_BAK_ACT_REDEntity>> failures = validator.validate(t_MYJK_FYJH_BAK_ACT_RED);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_FYJH_BAK_ACT_REDService.save(t_MYJK_FYJH_BAK_ACT_RED);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_MYJK_FYJH_BAK_ACT_RED.getId();
		URI uri = uriBuilder.path("/rest/t_MYJK_FYJH_BAK_ACT_REDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_MYJK_FYJH_BAK_ACT_REDEntity t_MYJK_FYJH_BAK_ACT_RED) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_FYJH_BAK_ACT_REDEntity>> failures = validator.validate(t_MYJK_FYJH_BAK_ACT_RED);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_FYJH_BAK_ACT_REDService.saveOrUpdate(t_MYJK_FYJH_BAK_ACT_RED);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		
		t_MYJK_FYJH_BAK_ACT_REDService.deleteEntityById(T_MYJK_FYJH_BAK_ACT_REDEntity.class, id);
	}
}
