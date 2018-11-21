package com.yangjiang.controller.checkinstore;

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
@RequestMapping("/CheckInstorePipeCodeController")
public class CheckInstorePipeCodeController {
	private static final Logger logger = Logger.getLogger(MyjkscjhController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="instoreDataGrid")
	@ResponseBody
	public Map instoreDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		String rukudanid = request.getParameter("rukudanid");
		StringBuffer cdt =  new StringBuffer();
		if(StringUtil.isNotEmpty(rukudanid)){
			cdt.append(" and a.rukudanid='"+rukudanid+"'");
		}else{
			cdt.append(" and a.rukudanid='"+null+"'");
		}
		StringBuffer dataSql = new StringBuffer("select a.rukudanid as rukudanid,b.pipe_code as pipe_code,b.dn as dn,b.batch_full as batch_full,b.pipe_serial as pipe_serial,b.packageid as packageid,b.product_plan_no as product_plan_no,b.item_code as item_code,b.item_cname as item_cname,b.exp_flag as exp_flag,b.special_desc as special_desc,b.pipenum as pipenum from t_zg_pipe_rk a inner join T_ZG_PIPE b on a.rukudanid=b.main_ID");
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
