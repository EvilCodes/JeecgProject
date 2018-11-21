package com.yangjiang.controller.t_zgk_fyjh_pcd;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.entity.t_zgk_fyjh_pcd.T_ZGK_FYJH_PCDEntity;
import com.yangjiang.service.t_zgk_fyjh_pcd.T_ZGK_FYJH_PCDServiceI;

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
 * @Description: 派车单
 * @author zhangdaihao
 * @date 2016-11-01 09:36:22
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_FYJH_PCDController")
public class T_ZGK_FYJH_PCDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_FYJH_PCDController.class);

	@Autowired
	private T_ZGK_FYJH_PCDServiceI t_ZGK_FYJH_PCDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 派车单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_fyjh_pcd/t_ZGK_FYJH_PCDList");
	}
	/**
	 * 派车单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_fyjh_pcd/t_ZGK_FYJH_PCDTruckList");
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
	public void datagrid(T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_FYJH_PCDEntity.class, dataGrid);
		//查询条件组装器
		String sendCarNo=t_ZGK_FYJH_PCD.getSendCarNo();
		if(StringUtil.isNotEmpty(sendCarNo)){
			cq.eq("sendCarNo", sendCarNo);
		}
		String billNoticeNo=t_ZGK_FYJH_PCD.getBillNoticeNo();
		if(StringUtil.isNotEmpty(billNoticeNo)){
			cq.eq("billNoticeNo", billNoticeNo);
		}
		String carno=t_ZGK_FYJH_PCD.getCarNo();
		if(StringUtil.isNotEmpty(carno)){
			//cq.eq("carNo", carno);
			cq.like("carNo", "%"+carno+"%");
		}
		if(t_ZGK_FYJH_PCD.getEdittime()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("edittime", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_ZGK_FYJH_PCD.getEdittime();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("edittime", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_FYJH_PCD, request.getParameterMap());
		
		cq.add();
		this.t_ZGK_FYJH_PCDService.getDataGridReturn(cq, true);
		System.out.println("dataGrid="+dataGrid);
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

	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_FYJH_PCDEntity.class, dataGrid);
		//查询条件组装器
		String sendCarNo=t_ZGK_FYJH_PCD.getSendCarNo();
		if(StringUtil.isNotEmpty(sendCarNo)){
			cq.eq("sendCarNo", sendCarNo);
		}
		String billNoticeNo=t_ZGK_FYJH_PCD.getBillNoticeNo();
		if(StringUtil.isNotEmpty(billNoticeNo)){
			cq.eq("billNoticeNo", billNoticeNo);
		}
		String carno=t_ZGK_FYJH_PCD.getCarNo();
		if(StringUtil.isNotEmpty(carno)){
			//cq.eq("carNo", carno);
			cq.like("carNo", "%"+carno+"%");
		}
		if(StringUtil.isNotEmpty(t_ZGK_FYJH_PCD.getEdittime())){
			Date bT = t_ZGK_FYJH_PCD.getEdittime();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("edittime", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("edittime", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_FYJH_PCD, request.getParameterMap());
		cq.add();
		this.t_ZGK_FYJH_PCDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除派车单
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_FYJH_PCD = systemService.getEntity(T_ZGK_FYJH_PCDEntity.class, t_ZGK_FYJH_PCD.getId());
		String sql="select count(*) from [DataCenter].[dbo].[T_ZGK_PIPE_CKM] where  send_car_no in (SELECT [send_car_no]   FROM [DataCenter].[dbo].[T_ZGK_FYJH_PCD] where id='"+t_ZGK_FYJH_PCD.getId()+"') and  conceal is null";
		long total=systemService.getCountForJdbc(sql);								
		System.out.println("total:"+total);	
		
		//System.out.println("sequence:"+sequence);
		if(StringUtil.isNotEmpty(total)){					
			if(total>0)
			{
				message = "派车单已出库,无法删除";							
				j.setMsg(message);
				return j;
			}
		}	
		message =t_ZGK_FYJH_PCD.getSendCarNo()+","+IpUtil.getIpAddr(request)+ ",派车单删除成功";
		t_ZGK_FYJH_PCDService.delete(t_ZGK_FYJH_PCD);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加派车单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD, HttpServletRequest request,Class<T_ZGK_FYJH_PCDEntity> T_ZGK_FYJH_PCDEntity) {
		String message = "铸管部派车单详单添加成功";
		Date d=new Date();
		String seqDate=DateUtils.formatDate(d,"yyyyMMdd").toString();
		//String edttime=DateUtils.formatTime();
		java.sql.Date edttime=new java.sql.Date(d.getTime());
		System.out.println("格式化后的日期："+DateUtils.formatDate(d,"yyyy-MM-dd"));																						
		String sql="select isnull(max(SUBSTRING(send_car_no, 10, 12)),0)  from T_ZGK_FYJH_PCD where CONVERT(varchar(100),edittime,23)=CONVERT(varchar(100),'"+DateUtils.formatDate(d,"yyyy-MM-dd")+"',23)";
		long total=systemService.getCountForJdbc(sql)+1;								
		System.out.println("total:"+total);	
		String sequence="";
		//System.out.println("sequence:"+sequence);
		//派车单限制数量修改
		if(StringUtil.isNotEmpty(total)){					
			if(total<10)
			{
				sequence="00"+total;
			}else if(total<100) 
			{
				sequence="0"+total;
			}else {
				sequence=""+total;
			}
		}	
		//根据运输方式不同给send_car_no前边添加不同字符进行区分；
		String jsondata1=request.getParameter("data");
		JSONArray dataArr1=JSONHelper.toJSONArray(jsondata1);
		JSONObject dataObj1 = dataArr1.getJSONObject(0);
		String trnMode=dataObj1.getString("trnMode");
		System.out.println("trnMode:"+trnMode);
		String realTrnMode=trnMode.substring(2, trnMode.length());
		System.out.println("realTrnMode:"+realTrnMode);
		String send_car_no=null;
		if(realTrnMode.equals("铁运"))
		{
			send_car_no="T"+seqDate.toString()+sequence;	}
		else{
			 send_car_no="C"+seqDate.toString()+sequence;	
		}
		System.out.println("send_car_no:"+send_car_no);		
		AjaxJson j = new AjaxJson();
		try{
			String jsondata=request.getParameter("data");	
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);
				System.out.println("dataArr.size():"+dataArr.size());
				for(int i=0;i<dataArr.size();i++){
					JSONObject dataObj = dataArr.getJSONObject(i);
					T_ZGK_FYJH_PCDEntity pcd = (T_ZGK_FYJH_PCDEntity) JSONHelper.json2Object(dataObj.toString(), T_ZGK_FYJH_PCDEntity.class);
					pcd.getBillNoticeNo();
					//System.out.println("pcd:"+pcd.getOrgName());	
					//System.out.println("RecAdd:"+pcd.getRecAdd());	
					//System.out.println("ConsignCname:"+pcd.getConsignCname());	
					pcd.setSendCarNo(send_car_no);
					pcd.setOutStorehouseName(dataObj.getString("storeName"));
					pcd.setTrnpMode(dataObj.getString("trnMode"));
					pcd.setEdittime(edttime);
					pcd.setEdittime(new Date());
					String editip=IpUtil.getIpAddr(request);
					pcd.setEditip(editip);
					String edituser=ResourceUtil.getSessionUserName().getUserName();
					pcd.setEdituser(edituser);
					t_ZGK_FYJH_PCDService.save(pcd);
				}
			}else{
				message="参数错误！请检查参数信息";
			}
			systemService.addLog(message+send_car_no, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setMsg(message);
		}catch (Exception e) {
			e.printStackTrace();
			message="添加失败，"+e;
		}
		return j;
	}

	/**
	 * 派车单列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_FYJH_PCD.getId())) {
			t_ZGK_FYJH_PCD = t_ZGK_FYJH_PCDService.getEntity(T_ZGK_FYJH_PCDEntity.class, t_ZGK_FYJH_PCD.getId());
			req.setAttribute("t_ZGK_FYJH_PCDPage", t_ZGK_FYJH_PCD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_fyjh_pcd/t_ZGK_FYJH_PCD");
	}
	/**
	 * 派车单列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate2")
	public ModelAndView addorupdate2(T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_FYJH_PCD.getId())) {
			t_ZGK_FYJH_PCD = t_ZGK_FYJH_PCDService.getEntity(T_ZGK_FYJH_PCDEntity.class, t_ZGK_FYJH_PCD.getId());
			req.setAttribute("t_ZGK_FYJH_PCDPage", t_ZGK_FYJH_PCD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_fyjh_pcd/t_ZGK_FYJH_PCDTruck");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_FYJH_PCDEntity> list() {
		List<T_ZGK_FYJH_PCDEntity> listT_ZGK_FYJH_PCDs=t_ZGK_FYJH_PCDService.getList(T_ZGK_FYJH_PCDEntity.class);
		return listT_ZGK_FYJH_PCDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_FYJH_PCDEntity task = t_ZGK_FYJH_PCDService.get(T_ZGK_FYJH_PCDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_FYJH_PCDEntity>> failures = validator.validate(t_ZGK_FYJH_PCD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_FYJH_PCDService.save(t_ZGK_FYJH_PCD);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_FYJH_PCD.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_FYJH_PCDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_FYJH_PCDEntity t_ZGK_FYJH_PCD) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_FYJH_PCDEntity>> failures = validator.validate(t_ZGK_FYJH_PCD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_FYJH_PCDService.saveOrUpdate(t_ZGK_FYJH_PCD);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_FYJH_PCDService.deleteEntityById(T_ZGK_FYJH_PCDEntity.class, id);
	}
}
