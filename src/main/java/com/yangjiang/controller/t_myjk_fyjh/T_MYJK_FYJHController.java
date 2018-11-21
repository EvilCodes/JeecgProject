package com.yangjiang.controller.t_myjk_fyjh;


import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.MyBeanUtils;
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

import com.yangjiang.entity.t_myjk_fyjh.T_MYJK_FYJHEntity;
import com.yangjiang.entity.t_myjk_scjh.T_MYJK_SCJHEntity;
import com.yangjiang.service.t_myjk_fyjh.T_MYJK_FYJHServiceI;

/**   
 * @Title: Controller
 * @Description: 发运计划审核
 * @author zhangdaihao
 * @date 2016-11-03 16:48:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_MYJK_FYJHController")
public class T_MYJK_FYJHController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_MYJK_FYJHController.class);

	@Autowired
	private T_MYJK_FYJHServiceI t_MYJK_FYJHService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	//private T_XXZG_RQEntity tt;
	

	/**
	 * 发运计划审核列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_fyjh/t_MYJK_FYJHList");
	}
	
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_fyjh/t_MYJK_FYJHListCheck");
	}
	
	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_MYJK_FYJHEntity t_MYJK_FYJH,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_FYJHEntity.class, dataGrid);
	//查询条件组装器
	//
		if(t_MYJK_FYJH.getInsertDate()!=null){
			//
			Date bT = t_MYJK_FYJH.getInsertDate();
		String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
		endStr = endStr+" 23:59:59";
		cq.between("insertDate", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
	}else{
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));			
			String endStr = bTStr+" 23:59:59";
		cq.between("insertDate", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		//String itemcode="D9"+"*";
	//cq.notEq(t_MYJK_FYJH.getItemCode(), itemcode);
		cq.add();		
		this.t_MYJK_FYJHService.getDataGridReturn(cq, true);
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

	@RequestMapping(params = "dataGrid")
	public void datagrid(T_MYJK_FYJHEntity t_MYJK_FYJH,HttpServletRequest request, HttpServletResponse response,DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_FYJHEntity.class, dataGrid);		
		String plan_year =request.getParameter("plan_year");
		String plan_month =request.getParameter("plan_month");
		if(StringUtil.isNotEmpty(plan_year)&&StringUtil.isNotEmpty(plan_month)){
			String beginStr =plan_year+"-"+plan_month+"-01 00:00:00";
			Date beginTm =DateUtils.str2Date(beginStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(beginTm);
			calendar.set(Calendar.DATE, 1);  
			calendar.roll(Calendar.DATE, -1);
			int maxDay = calendar.get(Calendar.DATE);
			Date endTm =DateUtils.str2Date(plan_year+"-"+plan_month+"-"+maxDay+" 23:59:59", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			cq.between("insertDate",beginTm, endTm);
		}else{
			if(t_MYJK_FYJH.getInsertDate()!=null){
				Date bgTm=  t_MYJK_FYJH.getInsertDate();
				String beginDateStr  = DateUtils.date2Str(bgTm,new SimpleDateFormat("yyyy-MM-dd"))+" 00:00:00";
				String endDateStr  = DateUtils.date2Str(bgTm,new SimpleDateFormat("yyyy-MM-dd"))+" 23:59:59";
				Date endTm =DateUtils.str2Date(endDateStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				System.out.println(beginDateStr+";"+endDateStr+";"+beginDateStr);
				cq.between("insertDate", bgTm, endTm);
			}else{
				//默认当月
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.DATE, 1);  
				calendar.roll(Calendar.DATE, -1);
				int maxDay = calendar.get(Calendar.DATE);
				int month = calendar.get(Calendar.MONTH)+1;
				int year = calendar.get(Calendar.YEAR);
				Date beginTm =DateUtils.str2Date(year+"-"+month+"-01 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				Date endTm =DateUtils.str2Date(year+"-"+month+"-"+maxDay+" 23:59:59", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				cq.between("insertDate",beginTm, endTm);
			}
		}
		System.out.println(t_MYJK_FYJH.getAuditflag());
		if(StringUtil.isNotEmpty(t_MYJK_FYJH.getAuditflag())){
			String auditflag=t_MYJK_FYJH.getAuditflag();
			cq.eq("auditflag", auditflag);
		}
		
		if(StringUtil.isNotEmpty(t_MYJK_FYJH.getExpFlag())){
			String expFlag=t_MYJK_FYJH.getExpFlag();
			cq.eq("expFlag", expFlag);
		}
		if(StringUtil.isNotEmpty(t_MYJK_FYJH.getTrnpMode())){
			String trnpMode=t_MYJK_FYJH.getTrnpMode();
			cq.eq("trnpMode", trnpMode);		
		}
		if(StringUtil.isNotEmpty(t_MYJK_FYJH.getOrgName())){
			String orgName=t_MYJK_FYJH.getOrgName();
			cq.eq("orgName", orgName);		
		}
		if(StringUtil.isNotEmpty(t_MYJK_FYJH.getSpecialDesc())){
			String specialDesc=t_MYJK_FYJH.getSpecialDesc();
			System.out.println(specialDesc+";");
			cq.eq("specialDesc", specialDesc);		
		}
		if(StringUtil.isNotEmpty(t_MYJK_FYJH.getBillNoticeNo())){
			String billNoticeNo=t_MYJK_FYJH.getBillNoticeNo();
			System.out.println(billNoticeNo+";");
			cq.eq("billNoticeNo", billNoticeNo);		
		}
		cq.add();
		
		this.t_MYJK_FYJHService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
		
		//实现默认显示当日计划
		
		/*Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		//查询条件组装器
		String insertDate=request.getParameter("insertDate");
		System.out.println(insertDate);
		String sql="";
		if(StringUtil.isNotEmpty(insertDate)){
			
			sql="select * from T_MYJK_FYJH where CONVERT(varchar(100),INSERT_DATE,23)='"+insertDate+"'";
		}else{
			insertDate=DateUtils.formatDate(new Date(),"yyyy-MM-dd").toString();
			sql="select * from T_MYJK_FYJH where CONVERT(varchar(100),INSERT_DATE,23)='"+insertDate+"'";
			
		}	
		@SuppressWarnings("unused")
		List<Map<String, Object>> dataResult=systemService.findForJdbc(sql, page,rows);
		String totalSql = "select count(1)  "+sql.substring(sql.indexOf("from"), sql.length());
		long total=systemService.getCountForJdbc(totalSql);
		
		dataGrid.setTotal((int)total);
		dataGrid.setResults(dataResult);	
		
		System.out.println(JSONHelper.bean2json(dataResult)); 
		
		
		//System.out.println(dataResult);
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_FYJH, request.getParameterMap());
		//this.t_MYJK_FYJHService.getDataGridReturn(cq, true);
*/		
	}

	/**
	 * 删除发运计划审核
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_MYJK_FYJHEntity t_MYJK_FYJH, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_MYJK_FYJH = systemService.getEntity(T_MYJK_FYJHEntity.class, t_MYJK_FYJH.getId());
		message = "发运计划审核删除成功";
		t_MYJK_FYJHService.delete(t_MYJK_FYJH);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发运计划审核
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_MYJK_FYJHEntity t_MYJK_FYJH, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		String plan_year= request.getParameter("plan_year");
		String plan_month=request.getParameter("plan_month");
		if (StringUtil.isNotEmpty(t_MYJK_FYJH.getId())) {
			message = "发运计划审核更新成功";
			T_MYJK_FYJHEntity t = t_MYJK_FYJHService.get(T_MYJK_FYJHEntity.class, t_MYJK_FYJH.getId());
			try {
				//根据业务，需要获取到所选行的四个字段：到站，收货单位，销售公司，专线，运输方式，以及前台获取到的年份和月份。
				MyBeanUtils.copyBeanNotNull2Bean(t_MYJK_FYJH, t);	
				//System.out.println(DateUtils.getDate().toString());
				System.out.println(t.getBillLadingNoItem());
				Date d=new Date();
				String seqDate=DateUtils.formatDate(d,"yyyyMM").toString();				
				System.out.println("格式化后的日期："+DateUtils.formatDate(d,"yyyyMM"));				
				//t.setAuditflag("已审核");
				String RecAdd=t.getRecAdd();
				String ConsignCname=t.getConsignCname();
				String PrivateRouteName=t.getPrivateRouteName();
				String TrnpMode=t.getTrnpMode();
				String OrgName=t.getOrgName();
				String insertDate=DateUtils.formatDate(t.getInsertDate()).toString();
				insertDate=DateUtils.dateformat(insertDate, "yyyy-MM");
				String select_date=request.getParameter("insertDate");
				select_date=DateUtils.dateformat(select_date, "yyyy-MM-dd");
				String select_month=DateUtils.dateformat(select_date, "yyyy-MM");
				//根据用户选择的日期检索结算日前
				String checkdateSql="select * from T_XXZG_RQ where CONVERT(varchar(100),日期,23)=CONVERT(varchar(100),'"+select_date+"',23)";
				List<Map<String, Object>> tt=systemService.findForJdbc(checkdateSql);				
				String transmode=t.getTrnpMode().substring(2);
				System.out.println("tt:"+tt);	
				String mode="";
				if(transmode.equals("铁运")){					
					mode="B";
					System.out.println("new transmode:"+mode);	
				}
				System.out.println("new transmode:"+mode);	
				String sql="select count(*) from T_MYJK_FYJH where SUBSTRING(carry_no,5,2)=MONTH(GETDATE())";	
				long total=systemService.getCountForJdbc(sql)+1;								
				System.out.println("total:"+total);	
				String sequence="";
				//System.out.println("sequence:"+sequence);
				if(StringUtil.isNotEmpty(total)){					
					if(total<10)
					{
						sequence="00"+total;
					}else if(total<100) 
					{
						sequence="0"+total;
					}
				}
				
				
				System.out.println("plan_year:"+plan_year);
				//System.out.println("plan_month:"+request.getParameter("plan_month"));
				String carry_no="";
				if(StringUtil.isNotEmpty(plan_year)&&StringUtil.isNotEmpty(plan_month)){
					carry_no=plan_year+plan_month+mode+sequence;
				}
				System.out.println("carry_no:"+carry_no);
				t.setAuditflag("已审核");
				t.setCarryNo(carry_no);
				//生成新的运号；
				//String carry_no=t_year+t_month+mode+sequence;
				//将运号写入满足要求的所有计划中；
				//1.根据要求查询数据；
				String checktotaldata="select BILL_NOTICE_NO as billNoticeNo,BILL_LADING_NO_ITEM as billLadingNoItem,PLAN_STATUS as planStatus, EXP_FLAG as expFlag,carry_no as carryNo,CONTRACT_NO as contractNo,ORDER_NO as orderNo,SCHEDULING_NO as schedulingNo,DELIVY_DATE as delivyDate,DELIVY_PLACE_CODE as delivyPlaceCode,DELIVY_PLACE_NAME as delivyPlaceName,PRIVATE_ROUTE_CODE as privateRouteCode,PRIVATE_ROUTE_NAME as privateRouteName,TRNP_MODE_CODE as trnpModeCode,TRNP_MODE as trnpMode,OUT_ORG_CODE as outOrgCode,OUT_ORG_NAME as outOrgName,OUT_STOREHOUSE_CODE as outStorehouseCode,OUT_STOREHOUSE_NAME as outStorehouseName,IN_ORG_CODE as inOrgCode,IN_ORG_NAME as inOrgName,IN_WHOUSE_CODE as inWhouseCode,IN_WHOUSE_NAME as inWhouseName,REC_ADD as recAdd,REC_PERSON as recPerson,REC_TEL as recTel,ORG_NAME as orgName,CONSIGN_CNAME as consignCname,SALE_PERSON_NAME as salePersonName,MOBILE_PHONE as mobilePhone,REMARK as remark,SUIT_FLAG as suitFlag,ITEM_CODE as itemCode,ITEM_CNAME as itemCname,PLAN_NUM as planNum,PLAN_WT as  planWt ,PACKAGE_WAY as packageWay,SPECIAL_DESC as specialDesc,ITEM_FACTORY_CODE as itemFactoryCode,ITEM_FACTORY_NAME as itemFactoryName,READ_FLAG as readFlag,INSERT_DATE as insertDate,UpdateFlag as updateflag,carry_no as carryNo,id as id,totalTransportNum as totalTransportNum,totalTransportWt as totaltransportwt,auditFlag as auditflag from T_MYJK_FYJH where TRNP_MODE_CODE='"+transmode+"' and REC_ADD='"+RecAdd+"' and  CONSIGN_CNAME='"+ConsignCname+"' and ORG_NAME='"+OrgName+"' " +
						"and PRIVATE_ROUTE_NAME='"+PrivateRouteName+"' and TRNP_MODE='"+TrnpMode+"' and convert(char(7),INSERT_DATE,20)=CONVERT(varchar(100),'"+select_month+"',23)";
				@SuppressWarnings("unused")
				List<Map<String, Object>> list_data=systemService.findForJdbc(checktotaldata);				
				if(StringUtil.isNotEmpty(list_data)){
					for(int i=0;i<list_data.size();i++){
						T_MYJK_FYJHEntity ts=JSONHelper.toBean(list_data.get(i), T_MYJK_FYJHEntity.class);																		
						String id=ts.getId();
						t_MYJK_FYJH = t_MYJK_FYJHService.getEntity(T_MYJK_FYJHEntity.class, ts.getId());
						System.out.println(ts.getCarryNo());
						System.out.println(carry_no);
						if(StringUtil.isNotEmpty(ts.getCarryNo())&&StringUtil.isNotEmpty(ts.getAuditflag())){
							ts.setAuditflag("已审核");
							t_MYJK_FYJH.setCarryNo(carry_no);
							t_MYJK_FYJHService.updateEntitie(t_MYJK_FYJH);
							t_MYJK_FYJHService.getSession().clear();
						}				
						
					}
				}
				
				
				
				//t.setCarryNo(carry_no);
				System.out.println("new carry_no:"+carry_no);
				//t_MYJK_FYJHService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "发运计划审核更新失败";
			}
		} else {
			message = "发运计划审核添加成功";
			t_MYJK_FYJHService.save(t_MYJK_FYJH);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 发运计划审核列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_MYJK_FYJHEntity t_MYJK_FYJH, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_MYJK_FYJH.getId())) {
			@SuppressWarnings("unused")
			String queryString = req.getQueryString();			
			t_MYJK_FYJH = t_MYJK_FYJHService.getEntity(T_MYJK_FYJHEntity.class, t_MYJK_FYJH.getId());
			req.setAttribute("t_MYJK_FYJHPage", t_MYJK_FYJH);
		}
		return new ModelAndView("com/yangjiang/t_myjk_fyjh/t_MYJK_FYJH");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_MYJK_FYJHEntity> list() {
		List<T_MYJK_FYJHEntity> listT_MYJK_FYJHs=t_MYJK_FYJHService.getList(T_MYJK_FYJHEntity.class);
		return listT_MYJK_FYJHs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_MYJK_FYJHEntity task = t_MYJK_FYJHService.get(T_MYJK_FYJHEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_MYJK_FYJHEntity t_MYJK_FYJH, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_FYJHEntity>> failures = validator.validate(t_MYJK_FYJH);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_FYJHService.save(t_MYJK_FYJH);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_MYJK_FYJH.getId();
		URI uri = uriBuilder.path("/rest/t_MYJK_FYJHController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_MYJK_FYJHEntity t_MYJK_FYJH) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_FYJHEntity>> failures = validator.validate(t_MYJK_FYJH);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_FYJHService.saveOrUpdate(t_MYJK_FYJH);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_MYJK_FYJHService.deleteEntityById(T_MYJK_FYJHEntity.class, id);
	}
}
