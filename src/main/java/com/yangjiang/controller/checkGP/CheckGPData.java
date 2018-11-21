package com.yangjiang.controller.checkGP;

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

import com.yangjiang.controller.fyjhCheck.CheckFYJHJQController;
@Controller
@RequestMapping("/CheckGPData")
public class CheckGPData extends BaseController {
	//private static final Logger logger = Logger.getLogger(CheckFYJHJQController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/checkGP/CheckGPData");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		StringBuffer cdt =  new StringBuffer();
		String sriqi = request.getParameter("sriqi");
		String eriqi = request.getParameter("eriqi");
		if(StringUtil.isNotEmpty(sriqi)){
			cdt.append(" and convert(varchar(50),analyDate,23)>= '"+sriqi+"'");
		}
		if(StringUtil.isNotEmpty(eriqi)){
			cdt.append(" and convert(varchar(50),analyDate,23)<= '"+eriqi+"'");
		}
		String sampleNo = request.getParameter("sampleNo");
		if(StringUtil.isNotEmpty(sampleNo)){
			cdt.append(" and sampleNo= '"+sampleNo+"'");
		}
		StringBuffer dataSql = new StringBuffer("select convert(varchar(50),analyDate,20) as rq ,* from T_ZG_HY_GP ");
		System.out.println("cdt.length:"+cdt.length());
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
		}
	
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);	
		@SuppressWarnings("unchecked")
		String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
		
		Long total= systemService.getCountForJdbc(totalSql);	

		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}

}
