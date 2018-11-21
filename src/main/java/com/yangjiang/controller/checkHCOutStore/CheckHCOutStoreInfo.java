package com.yangjiang.controller.checkHCOutStore;

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
@RequestMapping("/CheckHCOutStoreInfo")
public class CheckHCOutStoreInfo extends BaseController {
	private static final Logger logger = Logger.getLogger(MyjkscjhController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		String chukudanid = request.getParameter("chukudanid");
		String BILL_NOTICE_NO=request.getParameter("BILL_NOTICE_NO");
		StringBuffer cdt =  new StringBuffer();
		if(StringUtil.isNotEmpty(chukudanid)){
			cdt.append(" and a.SEND_NO='"+chukudanid+"'");
		}else{
			cdt.append(" and a.SEND_NO='"+null+"'");
		}if(StringUtil.isNotEmpty(BILL_NOTICE_NO)){
			cdt.append(" and a.BILL_NOTICE_NO='"+BILL_NOTICE_NO+"'");
		}
		StringBuffer dataSql = new StringBuffer(" select a.BILL_NOTICE_NO,a.BILL_LADING_NO_ITEM,a.BLOCK_NO,a.PLAN_NUM,a.PLAN_WT,a.SEND_NO,a.CONSIGN_CNAME,a.DELIVY_PLACE_NAME from T_ZGK_PIPE_CK_HCZ a");
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
