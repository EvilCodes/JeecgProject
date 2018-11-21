package com.yangjiang.controller.scjhdetail;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yangjiang.controller.batch.t_zg_batchController;
import com.yangjiang.service.batch.t_zg_batchServiceI;

import freemarker.template.utility.DateUtil;
@Controller
@RequestMapping("/CheckSCJHMonthSumController")
public class CheckSCJHMonthController extends BaseController{	
	//myjkscjhController.do?orderDataGrid	
		private static final Logger logger = Logger.getLogger(CheckSCJHMonthController.class);

		@Autowired
		private SystemService systemService;
		
		@RequestMapping(params = "list")
		public ModelAndView SCJHDList(HttpServletRequest request){
			 return new ModelAndView("com/yangjiang/t_myjk_scjh/t_MYJK_SCJHcheck");
		}
		@RequestMapping(params="CheckSCJHMonthSumDataGrid")
		@ResponseBody
		public Map CheckSCJHMonthSumDataGrid(HttpServletRequest request,HttpServletResponse response){
			Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
			Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
			
			SimpleDateFormat cyear=new SimpleDateFormat("yyyy"); 
			SimpleDateFormat cmonth=new SimpleDateFormat("MM");
			java.util.Date date=new java.util.Date();
			
			String cYear=cyear.format(date);
			String cMonth=cmonth.format(date); 			
			//参数条件
			StringBuffer cdt =  new StringBuffer();
			String pYear = request.getParameter("pYear");
			if(StringUtil.isEmpty(pYear)){
				cdt.append(" and 年='"+cYear+"'");
			}else
			{
				cdt.append(" and 年='"+pYear+"'");
			}
			String pMonth = request.getParameter("pMonth");			
			if(StringUtil.isEmpty(pMonth)){
				cdt.append(" and 月='"+cMonth+"'");
			}else{
				cdt.append(" and 月='"+pMonth+"'");
			}			
			StringBuffer dataSql = new StringBuffer("select * from V_MYJK_SCJH_YHZ");
			System.out.println("cdt.length:"+cdt.length());
			if(cdt.length()>0){
				dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
			}
		
			System.out.println(dataSql.toString());
			List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		//
			String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
			
			Long total= systemService.getCountForJdbc(totalSql);	
			//注意用JEECG 工具类
//			组织datagrid 数据格式
			Map oderData = new HashMap();
			oderData.put("total", total);
			oderData.put("rows", dataResult);
			System.out.println(JSONHelper.bean2json(oderData)); 
			return oderData;
		}

}
