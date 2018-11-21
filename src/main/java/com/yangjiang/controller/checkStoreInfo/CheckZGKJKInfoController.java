package com.yangjiang.controller.checkStoreInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.yangjiang.controller.checkrukuid.CheckrukuidController;
import com.yangjiang.controller.fyjhCheck.CheckFYJHJQController;
@Controller
@RequestMapping("/CheckZGKJKInfoController")
public class CheckZGKJKInfoController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckZGKJKInfoController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/checkstoreInfo/CheckZGKJKDayInfo");
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
			cdt.append(" and riqi>= '"+sriqi+"'");
		}else{
			cdt.append(" and riqi= '"+null+"'");
		}
		if(StringUtil.isNotEmpty(eriqi)){
			cdt.append(" and riqi<= '"+eriqi+"'");
		}else{
			cdt.append(" and riqi= '"+null+"'");
		}
		String packid = request.getParameter("packid");
		if(StringUtil.isNotEmpty(packid)){
			cdt.append(" and packageid= '"+packid+"'");
		}
		String batchfull = request.getParameter("batchfull");
		if(StringUtil.isNotEmpty(batchfull)){
			cdt.append(" and batch_full= '"+batchfull+"'");
		}
		String pipeserial = request.getParameter("pipeserial");
		if(StringUtil.isNotEmpty(pipeserial)){
			cdt.append(" and a.pipe_serial= '"+pipeserial+"'");
		}
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and dn= '"+dn+"'");
		}
		String ruikudanid = request.getParameter("ruikudanid");
		if(StringUtil.isNotEmpty(ruikudanid)){
			cdt.append(" and ruikudanid= '"+ruikudanid+"'");
		}
		StringBuffer dataSql = new StringBuffer("select * from v_zg_pipe_rk ");
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
