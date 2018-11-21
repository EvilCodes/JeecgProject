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
@RequestMapping("/CheckZGKTKInfoController")
public class CheckZGKTKInfoController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckZGKTKInfoController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/checkstoreInfo/CheckZGKTKDayInfo");
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
			cdt.append(" and convert(varchar(50),a.riqi,23)>= '"+sriqi+"'");
		}else{
			cdt.append(" and convert(varchar(50),a.riqi,23)= '"+null+"'");
		}
		if(StringUtil.isNotEmpty(eriqi)){
			cdt.append(" and convert(varchar(50),a.riqi,23)<= '"+eriqi+"'");
		}else{
			cdt.append(" and convert(varchar(50),a.riqi,23)= '"+null+"'");
		}
		String packid = request.getParameter("packid");
		if(StringUtil.isNotEmpty(packid)){
			cdt.append(" and b.packageid= '"+packid+"'");
		}
		String batchfull = request.getParameter("batchfull");
		if(StringUtil.isNotEmpty(batchfull)){
			cdt.append(" and b.batch_full= '"+batchfull+"'");
		}
		String pipeserial = request.getParameter("pipeserial");
		if(StringUtil.isNotEmpty(pipeserial)){
			cdt.append(" and b.a.pipe_serial= '"+pipeserial+"'");
		}
		String huowei = request.getParameter("huowei");
		if(StringUtil.isNotEmpty(huowei)){
			cdt.append(" and b.huowei= '"+huowei+"'");
		}
		String cengci = request.getParameter("cengci");
		if(StringUtil.isNotEmpty(cengci)){
			cdt.append(" and b.cengci= '"+cengci+"'");
		}
		String cengneixuhao = request.getParameter("cengneixuhao");
		if(StringUtil.isNotEmpty(cengneixuhao)){
			cdt.append(" and b.cengneixuhao= '"+cengneixuhao+"'");
		}
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and b.dn= '"+dn+"'");
		}
		String tuikudanid = request.getParameter("tuikudanid");
		if(StringUtil.isNotEmpty(tuikudanid)){
			cdt.append(" and tuikudanid= '"+tuikudanid+"'");
		}
		StringBuffer dataSql = new StringBuffer("select a.tuikudanid,convert(varchar(50),a.riqi,23) as riqi,b.pipenum,a.store_name,a.consignee,b.dn, "+
													"b.batch_full,b.packageid,b.pipe_serial,b.item_cname,b.huowei,b.cengci,b.cengneixuhao  "+
													 "from T_ZGK_PIPE_TKM a inner join T_ZGK_PIPE_TKD b on a.tuikudanid=b.tuikudanid ");
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
