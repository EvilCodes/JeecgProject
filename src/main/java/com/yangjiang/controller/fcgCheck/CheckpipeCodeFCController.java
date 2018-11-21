package com.yangjiang.controller.fcgCheck;

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

import com.yangjiang.controller.CheckCKMList.CheckCKMController;
@Controller
@RequestMapping("/CheckpipeCodeFCController")
public class CheckpipeCodeFCController extends BaseController {
	
	private static final Logger logger = Logger.getLogger(CheckpipeCodeFCController.class);
	@Autowired
	private SystemService systemService;	
	@RequestMapping(params="pipecodedatagrid")
	@ResponseBody
	public Map pipecodedatagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		StringBuffer cdt =  new StringBuffer();
		String chukudanid = request.getParameter("chukudanid");				
		if(StringUtil.isNotEmpty(chukudanid)){
			cdt.append(" and a.chukudanid='"+chukudanid+"'");
		}		
		String org_name = request.getParameter("org_name");
		if(StringUtil.isNotEmpty(org_name)){
			cdt.append(" and a.org_name='"+org_name+"'");
		}		
		String consign_cname = request.getParameter("consign_cname");
		if(StringUtil.isNotEmpty(consign_cname)){
			cdt.append(" and a.consign_cname='"+consign_cname+"'");
		}		
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and b.dn='"+dn+"'");
		}		
		String batchfull = request.getParameter("batchfull");
		if(StringUtil.isNotEmpty(batchfull)){
			cdt.append(" and b.batchfull='"+batchfull+"'");
		}		
		String pipeSerial = request.getParameter("pipeSerial");
		if(StringUtil.isNotEmpty(pipeSerial)){
			cdt.append(" and b.pipeSerial='"+pipeSerial+"'");
		}		
		StringBuffer dataSql = new StringBuffer("select b.id as id, b.pipe_serial as pipe_serial,a.bill_lading_no_item,a.bill_notice_no,a.chukudanid as chukudanid,a.consign_cname as consign_cname,a.delivy_place_name as delivy_place_name,a.org_name as org_name,a.riqi as riqi,b.batch_full as batch_full,b.dn as dn,b.exp_flag as exp_flag,b.item_cname as item_cname,b.item_code as item_code,b.packageid as packageid,b.pipenum as pipenum,b.special_desc as special_desc,b.product_line as product_line,b.suit_way as suit_way,b.huowei as huowei,b.cengci as cengci,b.cengneixuhao as cengneixuhao from T_ZGK_PIPE_CKM a inner join T_ZGK_PIPE_CKD b on a.chukudanid=b.chukudanid");
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
