package com.yangjiang.controller.t_zgk_pipe_ckd_jq;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.yangjiang.entity.t_zgk_pipe_ckd_jq.T_ZGK_PIPE_CKD_JQEntity;
import com.yangjiang.entity.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMEntity;
import com.yangjiang.entity.t_zgk_fyjh_pcd.T_ZGK_FYJH_PCDEntity;
import com.yangjiang.service.t_zgk_pipe_ckd_jq.T_ZGK_PIPE_CKD_JQServiceI;

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
 * @Description: 随车胶圈
 * @author zhangdaihao
 * @date 2017-04-07 16:46:22
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_CKD_JQController")
public class T_ZGK_PIPE_CKD_JQController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_CKD_JQController.class);

	@Autowired
	private T_ZGK_PIPE_CKD_JQServiceI t_ZGK_PIPE_CKD_JQService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(params="doCheck")
	@ResponseBody
	public AjaxJson doCheck(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				//List<T_ZGK_PIPE_CKMEntity> ckm =systemService.findByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", idsAttr[i]);
				//T_ZGK_PIPE_CKD_JQEntity ckm=systemService.findUniqueByProperty(T_ZGK_PIPE_CKD_JQEntity.class, "chukudanid", idsAttr[i]);
				T_ZGK_PIPE_CKD_JQEntity ckm=t_ZGK_PIPE_CKD_JQService.get(T_ZGK_PIPE_CKD_JQEntity.class, idsAttr[i]);
				
				if(ckm.getReadflag()=="1" || ckm.getReadflag()=="2" ){
					j.setMsg("该条信息已经抛送给贸易公司，不能再审，请联系管理员修改！！！！");
					return j;
				}else if(ckm.getShbz()=="1"){
					j.setMsg("该条信息已经审核通过，无需再审，请联系管理员修改！！！！");
					return j;
				}else{
					//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date d=new Date();
					
					ckm.setShsj(d);
					ckm.setShbz("1");
				String edituser=ResourceUtil.getSessionUserName().getUserName();
				ckm.setShr(edituser);
				}
				
				t_ZGK_PIPE_CKD_JQService.saveOrUpdate(ckm);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doCheck>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}

	/**
	 * 随车胶圈列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String chukudanid=request.getParameter("chukudanid");
		System.out.println(chukudanid);
		request.setAttribute("chukudanid", request.getParameter("chukudanid"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd_jq/t_ZGK_PIPE_CKD_JQList");
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
	public void datagrid(T_ZGK_PIPE_CKD_JQEntity t_ZGK_PIPE_CKD_JQ,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_CKD_JQEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_CKD_JQ, request.getParameterMap());
		this.t_ZGK_PIPE_CKD_JQService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除随车胶圈
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_CKD_JQEntity t_ZGK_PIPE_CKD_JQ, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_CKD_JQ = systemService.getEntity(T_ZGK_PIPE_CKD_JQEntity.class, t_ZGK_PIPE_CKD_JQ.getId());
		message = "随车胶圈删除成功";
		t_ZGK_PIPE_CKD_JQService.delete(t_ZGK_PIPE_CKD_JQ);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加随车胶圈
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_CKD_JQEntity T_ZGK_PIPE_CKD_JQEntity, HttpServletRequest request) {
		
		AjaxJson j = new AjaxJson();
		String message = "恭喜恭喜，保存成功！！";
		j.setMsg("恭喜，操作成功");
		String jsondata=request.getParameter("data");
		String chukudanid=request.getParameter("chukudanid");
		System.out.println("chukudanid:"+chukudanid);
		System.out.println("data:"+jsondata.length());
		if(StringUtil.isNotEmpty(jsondata)){
			JSONArray dataArr=JSONHelper.toJSONArray(jsondata);			
			//JSONObject dataObj = dataArr.getJSONObject(0);
			for(int i=0;i<dataArr.size();i++){
				net.sf.json.JSONObject dataObj = dataArr.getJSONObject(i);
				T_ZGK_PIPE_CKD_JQEntity jq=new T_ZGK_PIPE_CKD_JQEntity();
				jq.setChukudanid(chukudanid);
				jq.setPcdid(dataObj.getString("sendCarNo"));
				jq.setFactory(dataObj.getString("factory"));
				jq.setFactoryCode(dataObj.getString("factoryCode"));
				jq.setItemcode(dataObj.getString("itemCode"));
				jq.setItemname(dataObj.getString("itemName"));
				jq.setSendnum(dataObj.getInt("carryNum"));
				//String weight=dataObj.getString("carryWt");
				jq.setSendweight(dataObj.getString("carryWt"));
				jq.setName("胶圈");
				jq.setReadflag("0");
				T_ZGK_PIPE_CKMEntity ckm=systemService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class,"chukudanid",chukudanid);
				T_ZGK_FYJH_PCDEntity pcd=systemService.findUniqueByProperty(T_ZGK_FYJH_PCDEntity.class,"sendCarNo",jq.getPcdid());
				if(ckm.getCarNo()!=null && pcd.getCarNo() !=null && ckm.getCarNo().toString().trim().equals(pcd.getCarNo().toString().trim()))
				{
					t_ZGK_PIPE_CKD_JQService.save(jq);
				}
				else
				{
					j.setMsg("派车单车号:"+pcd.getCarNo()+",出库单车号:"+ckm.getCarNo()+",两车不一致,无法进行装胶圈!");
					return j;
				}
				
				
			}
			
			//jq.setFactory(factory)
		}
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 随车胶圈列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_CKD_JQEntity t_ZGK_PIPE_CKD_JQ, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CKD_JQ.getId())) {
			t_ZGK_PIPE_CKD_JQ = t_ZGK_PIPE_CKD_JQService.getEntity(T_ZGK_PIPE_CKD_JQEntity.class, t_ZGK_PIPE_CKD_JQ.getId());
			req.setAttribute("t_ZGK_PIPE_CKD_JQPage", t_ZGK_PIPE_CKD_JQ);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd_jq/t_ZGK_PIPE_CKD_JQ");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_CKD_JQEntity> list() {
		List<T_ZGK_PIPE_CKD_JQEntity> listT_ZGK_PIPE_CKD_JQs=t_ZGK_PIPE_CKD_JQService.getList(T_ZGK_PIPE_CKD_JQEntity.class);
		return listT_ZGK_PIPE_CKD_JQs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_CKD_JQEntity task = t_ZGK_PIPE_CKD_JQService.get(T_ZGK_PIPE_CKD_JQEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_CKD_JQEntity t_ZGK_PIPE_CKD_JQ, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CKD_JQEntity>> failures = validator.validate(t_ZGK_PIPE_CKD_JQ);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CKD_JQService.save(t_ZGK_PIPE_CKD_JQ);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_CKD_JQ.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_CKD_JQController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_CKD_JQEntity t_ZGK_PIPE_CKD_JQ) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CKD_JQEntity>> failures = validator.validate(t_ZGK_PIPE_CKD_JQ);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CKD_JQService.saveOrUpdate(t_ZGK_PIPE_CKD_JQ);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_CKD_JQService.deleteEntityById(T_ZGK_PIPE_CKD_JQEntity.class, id);
	}
}
