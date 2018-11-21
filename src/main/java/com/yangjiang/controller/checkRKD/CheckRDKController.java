package com.yangjiang.controller.checkRKD;

import java.text.SimpleDateFormat;
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

import com.yangjiang.controller.scjhdetail.CheckSCJHDetailController;
@Controller
@RequestMapping("/CheckRDKController")
public class CheckRDKController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckRDKController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKDList2");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));				
		//参数条件
		StringBuffer cdt =  new StringBuffer();
		String rukudanid = request.getParameter("rukudanid");
		if(StringUtil.isNotEmpty(rukudanid)){
			cdt.append(" and rukudanid='"+rukudanid+"'");
		}
		StringBuffer dataSql = new StringBuffer("select * from t_zgk_pipe_rkd");
		System.out.println("cdt.length:"+cdt.length());
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
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
		//ModelAndView mav = new ModelAndView("com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKD3List");
		//mav.addAllObjects(oderData);
		//mav.addObject("t_ZG_PIPEList", oderData);
		return oderData;
	}
}
