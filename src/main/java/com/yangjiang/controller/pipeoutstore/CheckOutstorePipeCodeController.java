package com.yangjiang.controller.pipeoutstore;

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
@RequestMapping("/CheckOutstorePipeCodeController")
public class CheckOutstorePipeCodeController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckOutstorePipeCodeController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="pipecodeDataGrid")
	@ResponseBody
	public Map planDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 100:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		StringBuffer cdt =  new StringBuffer();
		String item_code = request.getParameter("item_code");		
		if(StringUtil.isNotEmpty(item_code)){
			cdt.append(" and a.item_code='"+item_code+"'");
		}
		String batchfull = request.getParameter("batchfull");		
		if(StringUtil.isNotEmpty(batchfull)){
			cdt.append(" and a.batch_full='"+batchfull+"'");
		}
		String dn = request.getParameter("dn");		
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and a.dn='"+dn+"'");
		}
		String huowei = request.getParameter("huowei");		
		if(StringUtil.isNotEmpty(huowei)){
			cdt.append(" and a.huowei='"+huowei+"'");
		}
		String cengci = request.getParameter("cengci");		
		if(StringUtil.isNotEmpty(cengci)){
			cdt.append(" and a.cengci='"+cengci+"'");
		}
		String cengneixuhao = request.getParameter("cengneixuhao");		
		if(StringUtil.isNotEmpty(cengneixuhao)){
			cdt.append(" and a.cengneixuhao='"+cengneixuhao+"'");
		}
		String pipeserial = request.getParameter("pipeserial");		
		if(StringUtil.isNotEmpty(pipeserial)){
			cdt.append(" and a.pipe_serial='"+pipeserial+"'");
		}
		String store_name = request.getParameter("store_name");		
		if(StringUtil.isNotEmpty(store_name)){
			cdt.append(" and a.store_name='"+store_name+"'");
		}
		String specialDesc = request.getParameter("specialDesc");		
		if(StringUtil.isNotEmpty(specialDesc)){
			cdt.append(" and a.special_desc='"+specialDesc+"'");
		}
		String expFlag = request.getParameter("expFlag");		
		if(StringUtil.isNotEmpty(expFlag)){
			cdt.append(" and a.exp_flag='"+expFlag+"'");
		}
		String packageid = request.getParameter("packageid");		
		if(StringUtil.isNotEmpty(packageid)){
			cdt.append(" and a.packageid='"+packageid+"'");
		}
		StringBuffer dataSql = new StringBuffer("select a.id as id,a.store_name as store_name, a.packageid as packageid, a.product_plan_no as productPlanNo, a.item_code as itemCode,a.item_cname as itemCname,a.special_desc as specialDesc,a.dn as dn,a.batch_full as batchFull,a.pipe_serial as pipeSerial," +
				"a.cengci as cengci,a.product_line as productLine,a.suit_way as suitWay,a.pipenum as pipenum,a.exp_flag as expFlag,a.cengneixuhao as cengneixuhao,a.huowei as huowei from T_ZGK_PIPE_KC a");
		System.out.println(cdt.length());
		
		if(cdt.length()>3){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}
		
		System.out.println("字串："+dataSql.substring(dataSql.indexOf("FROM")+1, dataSql.length()));
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		String totalSql = "select count(1)  from ("+dataSql.substring(dataSql.indexOf("FROM")+1, dataSql.length())+" ) a";
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
