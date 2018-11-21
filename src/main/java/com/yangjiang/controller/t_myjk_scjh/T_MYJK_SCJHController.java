package com.yangjiang.controller.t_myjk_scjh;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.yangjiang.entity.t_myjk_scjh.T_MYJK_SCJHEntity;
import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.service.t_myjk_scjh.T_MYJK_SCJHServiceI;

import freemarker.template.utility.DateUtil;

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

import java.math.BigDecimal;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 生产计划
 * @author zhangdaihao
 * @date 2017-01-16 17:03:54
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_MYJK_SCJHController")
public class T_MYJK_SCJHController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_MYJK_SCJHController.class);

	@Autowired
	private T_MYJK_SCJHServiceI t_MYJK_SCJHService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 生产计划列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_scjh/t_MYJK_SCJHList");
	}

	
	/**
	 *函数你后面自己命名。。。
	 * 
	 * @return
	 */
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_scjh/t_MYJK_SCJHList2");
	}
	/**
	 *函数你后面自己命名。。。
	 * 
	 * @return
	 */
	@RequestMapping(params = "list3")
	public ModelAndView list3(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_myjk_scjh/t_MYJK_SCJHList3");
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
	public void datagrid(T_MYJK_SCJHEntity t_MYJK_SCJH,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_SCJHEntity.class, dataGrid);
		//查询条件组装器
		//
		if(t_MYJK_SCJH.getInsertDate()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("insertDate", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_MYJK_SCJH.getInsertDate();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("insertDate", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		
		cq.add();
		
		this.t_MYJK_SCJHService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_MYJK_SCJHEntity t_MYJK_SCJH,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_SCJHEntity.class, dataGrid);
		//查询条件组装器
		//
		if(t_MYJK_SCJH.getInsertDate()!=null){
			//
			Date bT = t_MYJK_SCJH.getInsertDate();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("insertDate", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			//Date endStr= DateUtils.str2Date(bTStr, new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("insertDate", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		
		cq.add();
		
		this.t_MYJK_SCJHService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "datagrid3")
	public void datagrid3(T_MYJK_SCJHEntity t_MYJK_SCJH,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_SCJHEntity.class, dataGrid);
		//查询条件组装器
		//
		if(t_MYJK_SCJH.getInsertDate()!=null){
			//
			Date bT = t_MYJK_SCJH.getInsertDate();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("insertDate", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			//Date endStr= DateUtils.str2Date(bTStr, new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("insertDate", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}		
		cq.add();		
		this.t_MYJK_SCJHService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 
	 */
	@RequestMapping(params = "check")
	public void check(T_MYJK_SCJHEntity t_MYJK_SCJH,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_MYJK_SCJHEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
		this.t_MYJK_SCJHService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 批量审核操作
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doCheck")
	@ResponseBody
	public AjaxJson doCheck(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				T_MYJK_SCJHEntity myjk_SCJH =t_MYJK_SCJHService.get(T_MYJK_SCJHEntity.class, idsAttr[i]);
				myjk_SCJH.setShsj(new Date());
				myjk_SCJH.setScdw("广东新兴铸管");
				myjk_SCJH.setShbm("生产组织中心");
				myjk_SCJH.setShr("王金龙");
				myjk_SCJH.setAuditresult("审核通过");
				t_MYJK_SCJHService.saveOrUpdate(myjk_SCJH);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_MYJK_SCJHController.do?doCheck>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	
	/**
	 * 批量作废操作
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doTrash")
	@ResponseBody
	public AjaxJson doTrash(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功！");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				T_MYJK_SCJHEntity myjk_SCJH =t_MYJK_SCJHService.get(T_MYJK_SCJHEntity.class, idsAttr[i]);
				myjk_SCJH.setShsj(new Date());
				myjk_SCJH.setScdw("广东新兴铸管");
				myjk_SCJH.setShbm("生产组织中心");
				myjk_SCJH.setShr("王金龙");
				myjk_SCJH.setAuditresult("作废");
				t_MYJK_SCJHService.saveOrUpdate(myjk_SCJH);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_MYJK_SCJHController.do?doTrash>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	
	/**
	 * 批量计划移转
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doMove")
	@ResponseBody
	public AjaxJson doMove(T_MYJK_SCJHEntity t_MYJK_SCJH,HttpServletRequest request){ 
		String message = null;
		AjaxJson j = new AjaxJson();
		Date currentTime = new Date();
		
		Calendar calendar=Calendar.getInstance();  
        calendar.setTime(currentTime);  
        calendar.set(Calendar.HOUR,0);//小时设置为0  
        calendar.set(Calendar.MINUTE, 0);//分钟设置为0  
        calendar.set(Calendar.SECOND, 0);//秒设置为0  
        Date startDate=calendar.getTime();//获取时间：'2014-07-08 00:00:00' 
        calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");	
		String dateString = formatter.format(currentTime);
		String checkdateSql="select * from T_XXZG_RQ where CONVERT(varchar(100),日期,23)='"+dateString+"'";
		List<Map<String, Object>> tt=systemService.findForJdbc(checkdateSql);				
		System.out.println("riqi:"+tt);
		//当前日期是当月的第几天
		String ri=tt.get(0).get("日").toString();
		//获取当月天数
		String curmonthDaynum=tt.get(0).get("当月天数").toString();
		System.out.println("ri:"+ri);
		System.out.println("curmonthDaynum:"+curmonthDaynum);
		int riqi=Integer.parseInt(ri);
		int numday=Integer.parseInt(curmonthDaynum);
		//校验日期是否是结转日			
		System.out.println(riqi==numday);
		if(riqi==1||riqi==2||riqi==6){				
			String jsondata=request.getParameter("data");	
			System.out.println("data:"+jsondata);
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);
				for(int i=0;i<dataArr.size();i++){
					
					JSONObject dataObj = dataArr.getJSONObject(i);
					int curYear= calendar.get(Calendar.YEAR);
					int preYear=calendar.get(Calendar.YEAR)-1;
					int curMonth = calendar.get(Calendar.MONTH);
					
					String curmonth = String.format("%2d", curMonth).replace(" ", "0");
					String nextmonth = String.format("%2d", curMonth+1).replace(" ", "0");
					String curyear = String.format("%4d", curYear).replace(" ", "0");
					String preyear = String.format("%4d", preYear).replace(" ", "0");
					
					String myear=dataObj.getString("myear");
					String mmonth=dataObj.getString("mmonth");
					System.out.println("curYear:"+curYear+"; curmonth:"+curmonth);
					System.out.println("myear:"+myear+"; mmonth:"+mmonth);
					if((StringUtil.equals(mmonth, curmonth)&&StringUtil.equals(myear, curyear))||(StringUtil.equals(myear, preyear)&&StringUtil.equals(curmonth, "12"))){
						System.out.println("dataObj:"+dataObj.toString());
						T_MYJK_SCJHEntity sc = new T_MYJK_SCJHEntity() ;
						
						String pno=dataObj.getString("product_plan_no");
						System.out.println("pno:"+pno);
						sc.setProductPlanNo(dataObj.getString("product_plan_no")+"Y1");
						sc.setYear(curyear);
						sc.setMonth(nextmonth);
						sc.setItemCode(dataObj.getString("item_code"));
						sc.setItemCname(dataObj.getString("item_cname"));
						sc.setExpFlag(dataObj.getString("exp_flag"));
						sc.setSpecialDesc(dataObj.getString("special_desc"));
						if(dataObj.getString("synum")==null){
							sc.setLaunchCount(0);
						}else{
							sc.setLaunchCount(dataObj.getInt("synum"));
						}
						String sysweight=dataObj.getString("syweight");
						BigDecimal bd=new BigDecimal(sysweight);
						//java.math.BigDecimal sysweight1=BigDecimal.valueOf(sysweight).doubleValue();
						sc.setLaunchWeight(bd);
						sc.setPlanLaunchDate(dateString);
						sc.setPlanCerateDate(dateString);
						
						t_MYJK_SCJHService.save(sc);
					}else{
						message="不是结算日，请检查日期";
					}
					
					
				}
			}else{
				message="参数错误！请检查参数信息";
			}
		}else{
			message="不是转算日，请在结转日结转";
			j.setMsg(message);
			//System.out.println("store_name222：");
			
		}
		return j;
	}
	
	
	
	/**
	 * 删除生产计划
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_MYJK_SCJHEntity t_MYJK_SCJH, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_MYJK_SCJH = systemService.getEntity(T_MYJK_SCJHEntity.class, t_MYJK_SCJH.getId());
		message = "生产计划删除成功";
		t_MYJK_SCJHService.delete(t_MYJK_SCJH);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加生产计划
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_MYJK_SCJHEntity t_MYJK_SCJH, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_MYJK_SCJH.getId())) {
			message = "生产计划更新成功";
			T_MYJK_SCJHEntity t = t_MYJK_SCJHService.get(T_MYJK_SCJHEntity.class, t_MYJK_SCJH.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_MYJK_SCJH, t);
				t_MYJK_SCJHService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "生产计划更新失败";
			}
		} else {
			message = "生产计划添加成功";
			t_MYJK_SCJHService.save(t_MYJK_SCJH);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 生产计划列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_MYJK_SCJHEntity t_MYJK_SCJH, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_MYJK_SCJH.getId())) {
			t_MYJK_SCJH = t_MYJK_SCJHService.getEntity(T_MYJK_SCJHEntity.class, t_MYJK_SCJH.getId());
			req.setAttribute("t_MYJK_SCJHPage", t_MYJK_SCJH);
		}
		return new ModelAndView("com/yangjiang/t_myjk_scjh/t_MYJK_SCJH");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_MYJK_SCJHEntity> list() {
		List<T_MYJK_SCJHEntity> listT_MYJK_SCJHs=t_MYJK_SCJHService.getList(T_MYJK_SCJHEntity.class);
		return listT_MYJK_SCJHs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_MYJK_SCJHEntity task = t_MYJK_SCJHService.get(T_MYJK_SCJHEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_MYJK_SCJHEntity t_MYJK_SCJH, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_SCJHEntity>> failures = validator.validate(t_MYJK_SCJH);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_SCJHService.save(t_MYJK_SCJH);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_MYJK_SCJH.getId();
		URI uri = uriBuilder.path("/rest/t_MYJK_SCJHController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_MYJK_SCJHEntity t_MYJK_SCJH) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_MYJK_SCJHEntity>> failures = validator.validate(t_MYJK_SCJH);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_MYJK_SCJHService.saveOrUpdate(t_MYJK_SCJH);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_MYJK_SCJHService.deleteEntityById(T_MYJK_SCJHEntity.class, id);
	}
}
