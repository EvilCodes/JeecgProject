package com.yangjiang.controller.checkpcd;

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

import com.yangjiang.controller.oder.MyjkscjhController;
@Controller
@RequestMapping("/CheckPCDController")
public class CheckPCDController extends BaseController {
	private static final Logger logger = Logger.getLogger(MyjkscjhController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="checkPCDGrid")
	@ResponseBody
	public Map checkPCDGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		StringBuffer cdt =  new StringBuffer();
		String pdate = request.getParameter("pdate");
		if(StringUtil.isNotEmpty(pdate)){
			cdt.append("and SUBSTRING(a.send_car_no, 3, 8)= '"+pdate+"'");
		}
		
		String send_car_no = request.getParameter("send_car_no");
		if(StringUtil.isNotEmpty(send_car_no)){
			cdt.append(" and a.send_car_no= '"+send_car_no+"'");
		}	
		 cdt.append(" and carry_num>0 ");
		StringBuffer dataSql = new StringBuffer("select a.carry_company_code as carry_company_code,a.id_number as id_number,a.driver_name as driver_name,a.driver_tel as driver_tel,a.expFlag as expFlag,a.specialDesc as specialDesc," +
				"a.org_name as org_name,a.consign_cname as consign_cname,a.rec_add as rec_add, a.item_code as item_code,  a.carry_no as carry_no,a.number as number,a.carry_company_name as carry_company_name,a.carry_num as carry_num,a.carry_wt as carry_wt,a.item_name as item_name,a.car_no as car_no,a.out_storehouse_name as out_storehouse_name,a.bill_notice_no as bill_notice_no,a.bill_notice_no_item as bill_notice_no_item,a.send_car_no as send_car_no,a.trnp_mode as trnp_mode from vm_T_ZGK_FYJH_PCD a  ");
		//System.out.println(dataSql);
		System.out.println(cdt.length());
		
		if(cdt.length()>3){
			dataSql.append("  where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}
		
		System.out.println("字串："+dataSql.substring(dataSql.indexOf("FROM")+1, dataSql.length()));
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		String totalSql = "select count(1)  from ("+dataSql.substring(dataSql.indexOf("FROM")+1, dataSql.length()) +") a";
		System.out.println("totalSql："+"select count(1)  "+dataSql.substring(dataSql.indexOf("FROM")+1, dataSql.length()));
		
		Long total= systemService.getCountForJdbc(totalSql);	
//		组织datagrid 数据格式
		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}
}
