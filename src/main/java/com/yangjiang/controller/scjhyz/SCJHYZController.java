package com.yangjiang.controller.scjhyz;

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

import com.yangjiang.controller.oder.MyjkscjhController;
@Controller
@RequestMapping("/SCJHYZController")
public class SCJHYZController extends BaseController {
	private static final Logger logger = Logger.getLogger(SCJHYZController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/t_myjk_scjh/scjhyz");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		//String product_plan_no = request.getParameter("product_plan_no");
		StringBuffer cdt =  new StringBuffer();
		String product_plan_no = request.getParameter("product_plan_no");
		if(StringUtil.isNotEmpty(product_plan_no)){
			cdt.append(" and a.product_plan_no='"+product_plan_no+"'");
		}	
		String myear = request.getParameter("myear");
		if(StringUtil.isNotEmpty(myear)){
			cdt.append(" and a.myear='"+myear+"'");
		}	
		String mmonth = request.getParameter("mmonth");
		if(StringUtil.isNotEmpty(mmonth)){
			cdt.append(" and a.mmonth='"+mmonth+"'");
		}	
		StringBuffer dataSql = new StringBuffer("select * from V_MYJH_SCJH_JHYZ_WXJD a ");
		if(cdt.length()>3){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}
	
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
	//
		String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
		
		Long total= systemService.getCountForJdbc(totalSql);	
		//注意用JEECG 工具类
//		组织datagrid 数据格式
		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}
}
