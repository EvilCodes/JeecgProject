package com.yangjiang.controller.checkpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangjiang.controller.oder.MyjkscjhController;
@Controller
@RequestMapping("/CheckPackageController")
public class CheckPackageController {
	private static final Logger logger = Logger.getLogger(CheckPackageController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="instoreDataGrid")
	@ResponseBody
	public Map instoreDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		StringBuffer cdt =  new StringBuffer();
		String packid = request.getParameter("packid");
		if(StringUtil.isNotEmpty(packid)){
			cdt.append(" and a.packid='"+packid+"'");
		}	
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and a.dn='"+dn+"'");
		}	
		String batchfull = request.getParameter("batchfull");
		if(StringUtil.isNotEmpty(batchfull)){
			cdt.append(" and a.batchfull='"+batchfull+"'");
		}	
		StringBuffer dataSql = new StringBuffer("select * from T_ZG_PACKAGE a ");
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
