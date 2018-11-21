package com.yangjiang.controller.checkZGKOutStoreInfo;

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

import com.yangjiang.controller.checkzgtransportplan.CheckZgTransportPlanController;
@Controller
@RequestMapping("/CheckZGKOutStoreInfo")
public class CheckZGKOutStoreInfo extends BaseController {
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
		
		String chukudanid = request.getParameter("chukudanid");	
		if(StringUtil.isNotEmpty(chukudanid)){			
			System.out.println(chukudanid);
			cdt.append(" and 发货通知单号='"+chukudanid+"'");
		}	
		//String sendCarNo = request.getParameter("sendCarNo");	
		
			//cdt.append(" and 核减短倒 !=0 ");
			
		StringBuffer dataSql = new StringBuffer("SELECT 发货通知单号, 发货通知单明细号, 运输方式名称, 计划状态, 计划状态名称, 产品代码, 产品中文名称,"+ 
                					"未派支数,短倒支数, 发出支数, 核减短倒, 交货日期, 交货地点名称, 专用线名称, 收货地点, 收货单位, 收货人, 收货电话, 备注, "+ 
                					"销售公司, 销售人员, 手机, 下达时间, 特殊合同描述, 内外销标识, 套装要求, 包装方式, 单重, 发货库房名称"+ 
                					" FROM  V_ZGK_FYJH_ZXJD_HC  " );
		System.out.println(cdt.length());		
		if(cdt.length()>3){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}		
		//System.out.println("字串："+dataSql.substring(dataSql.indexOf("FROM"), dataSql.length()));
		System.out.println("dataSql:"+dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		
		System.out.println("dataSql.length:"+dataSql.length());
		StringBuffer totalSql = new StringBuffer("select count(1) from V_ZGK_FYJH_ZXJD_HC  " );
		System.out.println("totalSql："+totalSql.toString());
		if(cdt.length()>3){
			totalSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
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
