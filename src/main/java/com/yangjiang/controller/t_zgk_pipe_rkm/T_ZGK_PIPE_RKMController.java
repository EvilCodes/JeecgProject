package com.yangjiang.controller.t_zgk_pipe_rkm;
import java.text.SimpleDateFormat;
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
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.entity.t_zgk_pipe_rkm.T_ZGK_PIPE_RKMEntity;
import com.yangjiang.service.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDServiceI;
import com.yangjiang.service.t_zgk_pipe_rkm.T_ZGK_PIPE_RKMServiceI;

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
 * @Description: 管材入库主表信息
 * @author zhangdaihao
 * @date 2016-10-27 14:46:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_RKMController")
public class T_ZGK_PIPE_RKMController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_RKMController.class);

	@Autowired
	private T_ZGK_PIPE_RKMServiceI t_ZGK_PIPE_RKMService;
	@Autowired
	private T_ZGK_PIPE_RKDServiceI t_ZGK_PIPE_RKDService;
	
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 管材入库主表信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkm/t_ZGK_PIPE_RKMList");
	}
	/**
	 * 管材入库主表信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkm/t_ZGK_PIPE_RKMList2");
	}
	/**
	 * 管材入库主表信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list3")
	public ModelAndView list3(HttpServletRequest request) {
		request.setAttribute("rukudanid", request.getParameter("rukudanid"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKDList2");
	}
	
	@RequestMapping(params = "datagrid3")
	public void datagrid3(T_ZGK_PIPE_RKDEntity rkd,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKDEntity.class, dataGrid);
		String rukudanid=rkd.getRukudanid();
		cq.eq("rukudanid", rukudanid);
		cq.add();
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_RKM, request.getParameterMap());
		this.t_ZGK_PIPE_RKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 管材手工入库主表信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list4")
	public ModelAndView list4(HttpServletRequest request) {
		request.setAttribute("rukudanid", request.getParameter("rukudanid"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKDList3");
	}
	
	@RequestMapping(params = "datagrid4")
	public void datagrid4(T_ZGK_PIPE_RKDEntity rkd,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKDEntity.class, dataGrid);
		String rukudanid=rkd.getRukudanid();
		cq.eq("rukudanid", rukudanid);
		cq.add();
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_RKM, request.getParameterMap());
		this.t_ZGK_PIPE_RKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
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
	public void datagrid(T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKMEntity.class, dataGrid);
		//查询条件组装器
		if(t_ZGK_PIPE_RKM.getRiqi()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("riqi", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_ZGK_PIPE_RKM.getRiqi();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("riqi", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		String rukudanid=t_ZGK_PIPE_RKM.getRukudanid();
		if(StringUtil.isNotEmpty(rukudanid)){
		String sign=rukudanid.substring(1, 1);
		System.out.println("rukudanid："+rukudanid);
		cq.notEq(sign, "L");
		}		
		cq.add();
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_RKM, request.getParameterMap());
		this.t_ZGK_PIPE_RKMService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKMEntity.class, dataGrid);
		//查询条件组装器
		if(t_ZGK_PIPE_RKM.getRiqi()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("riqi", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_ZGK_PIPE_RKM.getRiqi();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("riqi", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		String rukudanid=t_ZGK_PIPE_RKM.getRukudanid();
		String sign=rukudanid.substring(1, 1);
		System.out.println("sign："+sign);
		if(StringUtil.equals(sign, "L")){
			cq.eq("rukudanid", rukudanid);
		}
		cq.add();
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_RKM, request.getParameterMap());
		this.t_ZGK_PIPE_RKMService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除管材入库主表信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_RKM = systemService.getEntity(T_ZGK_PIPE_RKMEntity.class, t_ZGK_PIPE_RKM.getId());
		message = "管材入库主表信息删除成功"+t_ZGK_PIPE_RKM.getRukudanid();
		t_ZGK_PIPE_RKMService.delete(t_ZGK_PIPE_RKM);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加管材入库主表信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();		
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_RKM.getId())) {
			message = "管材入库主表信息更新成功";
			T_ZGK_PIPE_RKMEntity t = t_ZGK_PIPE_RKMService.get(T_ZGK_PIPE_RKMEntity.class, t_ZGK_PIPE_RKM.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_ZGK_PIPE_RKM, t);
				t_ZGK_PIPE_RKMService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "管材入库主表信息更新失败";
			}
		} else {
			message = "管材入库主表信息添加成功";
			t_ZGK_PIPE_RKMService.save(t_ZGK_PIPE_RKM);
			systemService.addLog(message+t_ZGK_PIPE_RKM.getRukudanid(), Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 管材入库主表信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_RKM.getId())) {
			t_ZGK_PIPE_RKM = t_ZGK_PIPE_RKMService.getEntity(T_ZGK_PIPE_RKMEntity.class, t_ZGK_PIPE_RKM.getId());
			req.setAttribute("t_ZGK_PIPE_RKMPage", t_ZGK_PIPE_RKM);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkm/t_ZGK_PIPE_RKM");
	}
	
	/**
	 * 管材入库主表信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate2")
	public ModelAndView addorupdate2(T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_RKM.getId())) {
			t_ZGK_PIPE_RKM = t_ZGK_PIPE_RKMService.getEntity(T_ZGK_PIPE_RKMEntity.class, t_ZGK_PIPE_RKM.getId());
			req.setAttribute("t_ZGK_PIPE_RKMPage", t_ZGK_PIPE_RKM);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkm/t_ZGK_PIPE_RKM2");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_RKMEntity> list() {
		List<T_ZGK_PIPE_RKMEntity> listT_ZGK_PIPE_RKMs=t_ZGK_PIPE_RKMService.getList(T_ZGK_PIPE_RKMEntity.class);
		return listT_ZGK_PIPE_RKMs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_RKMEntity task = t_ZGK_PIPE_RKMService.get(T_ZGK_PIPE_RKMEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_RKMEntity>> failures = validator.validate(t_ZGK_PIPE_RKM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_RKMService.save(t_ZGK_PIPE_RKM);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_RKM.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_RKMController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_RKMEntity t_ZGK_PIPE_RKM) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_RKMEntity>> failures = validator.validate(t_ZGK_PIPE_RKM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_RKMService.saveOrUpdate(t_ZGK_PIPE_RKM);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_RKMService.deleteEntityById(T_ZGK_PIPE_RKMEntity.class, id);
	}
}
