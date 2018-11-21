package com.yangjiang.controller.checkzgtransportplan;

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
@RequestMapping("/CheckZgTransportPlanController")
public class CheckZgTransportPlanController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckZgTransportPlanController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="planDataGrid")
	@ResponseBody
	public Map planDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		StringBuffer cdt =  new StringBuffer();
		String BILL_NOTICE_NO = request.getParameter("BILL_NOTICE_NO");
		String BILL_LADING_NO_ITEM = request.getParameter("BILL_LADING_NO_ITEM");	
		if(StringUtil.isNotEmpty(BILL_NOTICE_NO)){			
			System.out.println(BILL_NOTICE_NO);
			cdt.append(" and 发货通知单号='"+BILL_NOTICE_NO+"'");
		}					
		if(StringUtil.isNotEmpty(BILL_LADING_NO_ITEM)){
			cdt.append(" and 发货通知单明细号='"+BILL_LADING_NO_ITEM+"'");
		}			
		StringBuffer dataSql = new StringBuffer("select * from V_ZGK_FYJH_ZXJD_HC where 未派支数>0 " );
		System.out.println(cdt.length());		
		if(cdt.length()>3){
			dataSql.append(" and "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}		
		//System.out.println("字串："+dataSql.substring(dataSql.indexOf("FROM"), dataSql.length()));
		System.out.println("dataSql:"+dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		
		System.out.println("dataSql.length:"+dataSql.length());
		StringBuffer totalSql = new StringBuffer("select count(1) from V_ZGK_FYJH_ZXJD_HC where 未派支数>0" );
		System.out.println("totalSql："+totalSql.toString());
		if(cdt.length()>3){
			totalSql.append(" and "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}	
		Long total= systemService.getCountForJdbc(totalSql.toString());
		//String totalSql = "select count(1)  "+num;
		System.out.println("totalSql："+totalSql.toString());
		//Long total= systemService.getCountForJdbc(totalSql);	
//		组织datagrid 数据格式
		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}
}
