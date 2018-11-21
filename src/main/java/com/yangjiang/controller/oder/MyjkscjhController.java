package com.yangjiang.controller.oder;

import java.text.DateFormat;
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

import com.yangjiang.controller.batch.t_zg_batchController;
import com.yangjiang.service.batch.t_zg_batchServiceI;
//myjkscjhController.do?orderDataGrid
@Controller
@RequestMapping("/myjkscjhController")
public class MyjkscjhController  extends BaseController{
	private static final Logger logger = Logger.getLogger(MyjkscjhController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="orderDataGrid")
	@ResponseBody
	public Map orderDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		DateFormat format1 = new SimpleDateFormat("yyyy");         
		DateFormat format2= new SimpleDateFormat("MM");
		Date currentTime = new Date();
		String mYear=format1.format(currentTime);
		String mMonth=format2.format(currentTime);
		//参数条件
		String pYear = request.getParameter("pYear");
		StringBuffer cdt =  new StringBuffer();
		
		if(StringUtil.isNotEmpty(pYear)){
			cdt.append(" and 年='"+pYear+"'");
		}else{
			cdt.append(" and 年='"+mYear+"'");
		}
		String pMonth = request.getParameter("pMonth");		
		if(StringUtil.isNotEmpty(pMonth)){
			cdt.append(" and 月='"+pMonth+"'");
		}else{
			cdt.append(" and 月='"+mMonth+"'");
		}
		//System.out.println(pMonth.length());
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and 规格='"+dn+"'");
		}
		String grade = request.getParameter("grade");
		if(StringUtil.isNotEmpty(grade)){
			cdt.append(" and 等级='"+grade+"'");
		}
		String interface_desc = request.getParameter("interface_desc");
		if(StringUtil.isNotEmpty(interface_desc)){
			cdt.append(" and 接口='"+interface_desc+"'");
		}
		String my_length = request.getParameter("my_length");
		if(StringUtil.isNotEmpty(my_length)){
			cdt.append(" and 长度='"+my_length+"'");
		}
		String pipetype = request.getParameter("pipetype");
		if(StringUtil.isNotEmpty(pipetype)){
			cdt.append(" and 品种='"+pipetype+"'");
		}
		String expflag = request.getParameter("expflag");
		if(StringUtil.isNotEmpty(expflag)){
			cdt.append(" and 内外销标记='"+expflag+"'");
		}
		StringBuffer dataSql = new StringBuffer("select 规格 as dn,等级 as grade,接口 as interface_desc,长度 as my_length,品种 as pipetype,合约简称 as contract_desc,  " +
				"产品中文名称 as item_cname, 产品代码 as item_code, 特殊合同描述 as special_desc,生产计划号 as product_plan_no,年 as pYear,月 as pMonth,内外销标记 as expFlag from V_MYJK_SCJH");
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
