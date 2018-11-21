package com.yangjiang.controller.fyjhCheck;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/CheckFYJHController")
public class CheckFYJHController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckFYJHController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/t_myjk_fyjh/t_MYJK_FYJHListMonth");
	}
	@RequestMapping(params="CheckFYJHMonthDataGrid")
	@ResponseBody
	public Map CheckFYJHMonthDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		//上个月最后一天
		java.util.Date date=new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        //Date theDate = calendar.getTime();
        
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -4);    //再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last).append(" 00:00:00");
        day_last = endStr.toString();
        System.out.println("day_last:"+day_last);
        
		SimpleDateFormat my_end=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");						
		String endDay=my_end.format(date);
		System.out.println("endDay:"+endDay);
		//参数条件
		StringBuffer cdt =  new StringBuffer();
		String startDate = request.getParameter("startDate");
		String start = startDate+" 00:00:00";
		if(StringUtil.isNotEmpty(startDate)){
			cdt.append(" and 下达时间 > ='"+start+"'");
		}else{
			cdt.append(" and 下达时间 >= '"+day_last+"'");
		}
		String endDate = request.getParameter("endDate");
		String end=endDate+" 11:59:59";
		if(StringUtil.isNotEmpty(endDate)){
			cdt.append(" and 下达时间< ='"+end+"'");
		}else{
			cdt.append(" and 下达时间< ='"+endDay+"'");
		}
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and 规格 ='"+dn+"'");
		}
		
		String BILL_NOTICE_NO = request.getParameter("BILL_NOTICE_NO");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and 发货通知单号 ='"+BILL_NOTICE_NO+"'");
		}
		StringBuffer dataSql = new StringBuffer("select * from V_MYJK_FYJH_ZG");
		System.out.println("cdt.length:"+cdt.length());
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
		}
	
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);	
		String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
		
		Long total= systemService.getCountForJdbc(totalSql);	

		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}
	
	

}
