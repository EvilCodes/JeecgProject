package com.yangjiang.controller.t_zg_pipe;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.service.t_zg_pipe.T_ZG_PIPEServiceI;

/**   
 * @Title: Controller
 * @Description: 铸管部入库详单
 * @author zhangdaihao
 * @date 2016-10-14 09:23:44
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZG_PIPEController")
public class T_ZG_PIPEController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZG_PIPEController.class);

	@Autowired
	private T_ZG_PIPEServiceI t_ZG_PIPEService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 铸管部入库详单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zg_pipe/t_ZG_PIPEList");
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
	public void datagrid(T_ZG_PIPEEntity t_ZG_PIPE,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZG_PIPEEntity.class, dataGrid);
		//查询条件组装器
		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZG_PIPE, request.getParameterMap());
		this.t_ZG_PIPEService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除铸管部入库详单
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZG_PIPEEntity t_ZG_PIPE, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZG_PIPE = systemService.getEntity(T_ZG_PIPEEntity.class, t_ZG_PIPE.getId());
		message = "铸管部入库详单删除成功";
		t_ZG_PIPEService.delete(t_ZG_PIPE);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}
	/**
	 * 添加铸管部入库详单
	 * @param T_ZG_PIPEEntity 
	 * 
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZG_PIPEEntity t_ZG_PIPE, HttpServletRequest request, Class T_ZG_PIPEEntity) {						
		String message = "铸管部入库详单添加成功";
		AjaxJson j = new AjaxJson();
		try{
			String jsondata=request.getParameter("data");	
			System.out.println("data:"+jsondata);
			
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);
				for(int i=0;i<dataArr.size();i++){
					JSONObject dataObj = dataArr.getJSONObject(i);
					String pyear=dataObj.getString("pyear");
					String batch=dataObj.getString("batch");
					String pipeserial=dataObj.getString("pipeserial");
					String packid=dataObj.getString("packid");
					String pipenum=dataObj.getString("pipenum");
					String dn=dataObj.getString("dn");
					String batchfull=pyear+"-"+batch;
					String pipecode=dn+"-"+pyear+"-"+batch+"-"+pipeserial;
					String rukudanid=dataObj.getString("rukudanid");
					//String specialDesc=dataObj.getString("specialDesc");
					String productLine=dataObj.getString("productLine");
					T_ZG_PIPEEntity pipe = (T_ZG_PIPEEntity) JSONHelper.json2Object(dataObj.toString(), T_ZG_PIPEEntity.class);
					if(pipe.getPYear()==null){
						pipe.setPYear(pyear);
					}
					if(pipe.getBatch()==null){
						pipe.setBatch(batch);
					}
					if(pipe.getBatchFull()==null){
						pipe.setBatchFull(batchfull);
					}
					if(pipe.getPipeCode()==null){
						pipe.setPipeCode(pipecode);
					}
					if(pipe.getMainId()==null){
						pipe.setMainId(rukudanid);
					}
					if(pipe.getPackageid()==null){
						pipe.setPackageid(packid);
					}
					if(pipe.getPipenum()==null){
						pipe.setPipenum(pipenum);
					}
					if(pipe.getPipeSerial()==null){
						pipe.setPipeSerial(pipeserial);
					}
					if(pipe.getProductLine()==null){
						pipe.setProductLine(productLine);
					}
					pipe.setItemCode(dataObj.getString("itemCode"));
					pipe.setEdittime(new Date());
					String editip=IpUtil.getIpAddr(request);
					pipe.setEditip(editip);
					//这里可以拿真是姓名
					String edituser=ResourceUtil.getSessionUserName().getUserName();
					pipe.setEdituser(edituser);
					T_ZG_PIPEEntity t =	t_ZG_PIPEService.findUniqueByProperty(T_ZG_PIPEEntity.class, "pipeCode", pipe.getPipeCode());
					if(t==null){
						t_ZG_PIPEService.save(pipe);
					}else{
						message +="管号"+pipe.getPipeCode()+"已存在";
					}
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
	 * 铸管部入库详单列表页面跳转
	 *没有耳机
	 *
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZG_PIPEEntity t_ZG_PIPE, HttpServletRequest req) {
		
		//
		if (StringUtil.isNotEmpty(t_ZG_PIPE.getId())) {
			//这里这样搞不对吧 你传过来的是主表ID 根据主表ID去查子表、、、
			t_ZG_PIPE = t_ZG_PIPEService.getEntity(T_ZG_PIPEEntity.class, t_ZG_PIPE.getId());
			req.setAttribute("t_ZG_PIPEPage", t_ZG_PIPE);
		}
		return new ModelAndView("com/yangjiang/t_zg_pipe/t_ZG_PIPE");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZG_PIPEEntity> list() {
		List<T_ZG_PIPEEntity> listT_ZG_PIPEs=t_ZG_PIPEService.getList(T_ZG_PIPEEntity.class);
		return listT_ZG_PIPEs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZG_PIPEEntity task = t_ZG_PIPEService.get(T_ZG_PIPEEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZG_PIPEEntity t_ZG_PIPE, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZG_PIPEEntity>> failures = validator.validate(t_ZG_PIPE);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZG_PIPEService.save(t_ZG_PIPE);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZG_PIPE.getId();
		URI uri = uriBuilder.path("/rest/t_ZG_PIPEController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZG_PIPEEntity t_ZG_PIPE) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZG_PIPEEntity>> failures = validator.validate(t_ZG_PIPE);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZG_PIPEService.saveOrUpdate(t_ZG_PIPE);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZG_PIPEService.deleteEntityById(T_ZG_PIPEEntity.class, id);
	}
}
