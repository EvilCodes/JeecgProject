package com.yangjiang.controller.CheckCKMList;

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
@Controller
@RequestMapping("/CheckCKMController")
public class CheckCKMController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckCKMController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		StringBuffer cdt =  new StringBuffer();
		String riqi = request.getParameter("riqi");
		String store_name = request.getParameter("store_name");
		String startTime=riqi+"00:00:00";
		String endTime=riqi+"23:59:59";
		if(StringUtil.isNotEmpty(riqi)){
			cdt.append(" and a.riqi>'"+startTime+"' and a.riqi<= '"+endTime+"'");
		}		
		if(StringUtil.isNotEmpty(store_name)){
			cdt.append(" and store_name='"+store_name+"'");
		}		
		StringBuffer dataSql = new StringBuffer("select a.baoguanyuan,a.bill_notice_no,a.carry_company_code,a.carry_company_name,a.car_no,a.chukudanid,a.consign_cname,a.delivy_place_name,a.driver_name,a.driver_tel,a.id,a.id_number,a.org_name,a.riqi,a.send_car_no,a.store_name,a.trnp_mode from T_ZGK_PIPE_CKM a");
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
