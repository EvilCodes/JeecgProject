package com.yangjiang.controller.t_zgk_pipe_kc_ls;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import org.jeecgframework.web.system.service.impl.SystemServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.batch.t_zg_batchEntity;
import com.yangjiang.entity.t_zgk_fyjh_pcd.T_ZGK_FYJH_PCDEntity;
import com.yangjiang.entity.t_zgk_pipe_kc.T_ZGK_PIPE_KCEntity;
import com.yangjiang.entity.t_zgk_pipe_kc_ls.T_ZGK_PIPE_KC_LSEntity;
import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.service.impl.t_zgk_pipe_ls_flag.T_ZGK_PIPE_KC_LS_FLAGServiceImpl;
import com.yangjiang.service.t_zgk_pipe_kc.T_ZGK_PIPE_KCServiceI;
import com.yangjiang.service.t_zgk_pipe_kc_ls.T_ZGK_PIPE_KC_LSServiceI;
import com.yangjiang.service.t_zgk_pipe_ls_flag.T_ZGK_PIPE_KC_LS_FLAGServiceI;
import com.yangjiang.entity.t_zgk_pipe_kc_ls.*;
import com.yangjiang.entity.t_zgk_pipe_ls_flag.T_ZGK_PIPE_KC_LS_FLAGEntity;

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

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 月底库存结转
 * @author zhangdaihao
 * @date 2016-12-05 11:11:52
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_KC_LSController")
public class T_ZGK_PIPE_KC_LSController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_KC_LSController.class);
	@Autowired
	private T_ZGK_PIPE_KC_LSServiceI t_ZGK_PIPE_KC_LSService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	private T_ZGK_PIPE_KC_LS_FLAGEntity myflag=new T_ZGK_PIPE_KC_LS_FLAGEntity();
	
	@Autowired
	private T_ZGK_PIPE_KC_LS_FLAGServiceI ls;
	@Autowired
	private T_ZGK_PIPE_KCServiceI kcService;
	/**
	 * 月底库存结转列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_kc_ls/t_ZGK_PIPE_KC_LSList");
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
	public void datagrid(T_ZGK_PIPE_KC_LSEntity t_ZGK_PIPE_KC_LS,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_KC_LSEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_KC_LS, request.getParameterMap());
		this.t_ZGK_PIPE_KC_LSService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除月底库存结转
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_KC_LSEntity t_ZGK_PIPE_KC_LS, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_KC_LS = systemService.getEntity(T_ZGK_PIPE_KC_LSEntity.class, t_ZGK_PIPE_KC_LS.getId());
		message = "月底库存结转删除成功";
		t_ZGK_PIPE_KC_LSService.delete(t_ZGK_PIPE_KC_LS);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加月底库存结转
	 * 
	 * @param ids
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_KC_LSEntity t_ZGK_PIPE_KC_LS, HttpServletRequest request) throws ParseException {
		String message = null;
		AjaxJson j = new AjaxJson();
		
		try{	
			message="数据添加成功";
			Date currentTime = new Date();
			Calendar calendar=Calendar.getInstance();  
	        calendar.setTime(currentTime);  
	        calendar.set(Calendar.HOUR,0);//小时设置为0  
	        calendar.set(Calendar.MINUTE, 0);//分钟设置为0  
	        calendar.set(Calendar.SECOND, 0);//秒设置为0  
	        Date startDate=calendar.getTime();//获取时间：'2014-07-08 00:00:00' 
	        calendar.add(Calendar.DAY_OF_MONTH, -1);
	        Date endDate=calendar.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);	
			String dateString2 = formatter2.format(endDate);
			Date useDate=formatter2.parse(dateString2);
			System.out.println("endDate:"+endDate);
			String jsondata=request.getParameter("data");							
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
			if(riqi==1){				
				System.out.println("store_name1111：");
			}else{
				System.out.println("不是转算日，请在结转日结转");
				message="不是转算日，请在结转日结转";
				j.setMsg(message);
				System.out.println("store_name222：");
				return j;
			}
			//保存标志表
			if(StringUtil.isNotEmpty(jsondata))
			{							
			myflag.setStoreName(jsondata);
			System.out.println("store_name："+jsondata);
			//这里设置日期
			myflag.setRiqi(useDate);
			System.out.println("currentTime_2："+useDate);
			String editip=IpUtil.getIpAddr(request);
			System.out.println("editip："+editip);
			//这里设置ip地址
			myflag.setJiesuanIp(editip);			
			//这里可以拿真是姓名
			String edituser=ResourceUtil.getSessionUserName().getUserName();
			System.out.println("edituser："+edituser);
			myflag.setJiesuanRen(edituser);	
			myflag.setFlag("1");
			System.out.println("myflag："+myflag);
			ls.save(myflag);
			System.out.println("标志表保存成功");
			}
			//保存库存
			String checkKCData="select * from T_ZGK_PIPE_KC where store_name= '"+jsondata+"'";
			//List<T_ZGK_PIPE_KCEntity> kcdata=systemService.findListbySql(checkKCData);
			List<T_ZGK_PIPE_KCEntity> kcdata=kcService.findByProperty(T_ZGK_PIPE_KCEntity.class, "storeName", jsondata);
			String bf=kcdata.get(0).getBatchFull();
			if(StringUtil.isNotEmpty(kcdata)){	
				System.out.println("kcdata:"+kcdata.size());
				for(int i=0;i<kcdata.size();i++){	
					//System.out.println("store_name:"+kcdata.get(i).getBatchFull());
					System.out.println("dn:"+kcdata.get(i).getDn());
					T_ZGK_PIPE_KCEntity kc=kcService.getEntity(T_ZGK_PIPE_KCEntity.class, kcdata.get(i).getId());
					T_ZGK_PIPE_KC_LSEntity ls = new T_ZGK_PIPE_KC_LSEntity();
					ls.setBatchFull(kc.getBatchFull());
					ls.setCengci(kc.getCengci());
					ls.setCengneixuhao(kc.getCengneixuhao());
					ls.setDn(kc.getDn());
					ls.setExpFlag(kc.getExpFlag());
					ls.setHuowei(kc.getHuowei());
					ls.setId(kc.getId());
					ls.setItemCname(kc.getItemCname());
					ls.setItemCode(kc.getItemCode());
					ls.setPackageid(kc.getPackageid());
					ls.setPipenum(kc.getPipenum());
					ls.setPipeSerial(kc.getPipeSerial());
					ls.setProductLine(kc.getProductLine());
					ls.setSpecialDesc(kc.getSpecialDesc());
					ls.setStoreName(kc.getStoreName());
					ls.setSuitWay(kc.getSuitWay());
					ls.setRiqi(new Date());
					
					
					t_ZGK_PIPE_KC_LSService.save(ls);
				}
				
				System.out.println("仓库名称："+myflag.getStoreName());
			}else{
				message="参数错误！请检查参数信息";
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setMsg(message);
		}catch (Exception e) {
			e.printStackTrace();
			message="添加失败，"+e;
		}
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 月底库存结转列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_KC_LSEntity t_ZGK_PIPE_KC_LS, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_KC_LS.getId())) {
			t_ZGK_PIPE_KC_LS = t_ZGK_PIPE_KC_LSService.getEntity(T_ZGK_PIPE_KC_LSEntity.class, t_ZGK_PIPE_KC_LS.getId());
			req.setAttribute("t_ZGK_PIPE_KC_LSPage", t_ZGK_PIPE_KC_LS);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_kc_ls/t_ZGK_PIPE_KC_LS");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_KC_LSEntity> list() {
		List<T_ZGK_PIPE_KC_LSEntity> listT_ZGK_PIPE_KC_LSs=t_ZGK_PIPE_KC_LSService.getList(T_ZGK_PIPE_KC_LSEntity.class);
		return listT_ZGK_PIPE_KC_LSs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_KC_LSEntity task = t_ZGK_PIPE_KC_LSService.get(T_ZGK_PIPE_KC_LSEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_KC_LSEntity t_ZGK_PIPE_KC_LS, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_KC_LSEntity>> failures = validator.validate(t_ZGK_PIPE_KC_LS);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_KC_LSService.save(t_ZGK_PIPE_KC_LS);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_KC_LS.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_KC_LSController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_KC_LSEntity t_ZGK_PIPE_KC_LS) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_KC_LSEntity>> failures = validator.validate(t_ZGK_PIPE_KC_LS);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_KC_LSService.saveOrUpdate(t_ZGK_PIPE_KC_LS);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_KC_LSService.deleteEntityById(T_ZGK_PIPE_KC_LSEntity.class, id);
	}
}
