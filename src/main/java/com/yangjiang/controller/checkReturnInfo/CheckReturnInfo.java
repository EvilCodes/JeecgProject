package com.yangjiang.controller.checkReturnInfo;

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

import com.yangjiang.controller.oder.MyjkscjhController;
@Controller
@RequestMapping("/CheckReturnInfo")
public class CheckReturnInfo extends BaseController {
	private static final Logger logger = Logger.getLogger(MyjkscjhController.class);
	@Autowired
	private SystemService systemService;
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/t_myjk_fyjh/checkReturnInfo");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		String riqi=request.getParameter("riqi");
		StringBuffer cdt =  new StringBuffer();
		if(StringUtil.isNotEmpty(riqi)){
			cdt.append(" and convert(varchar(50),a.返回日期,23)='"+riqi+"'");
		}else{
			cdt.append(" and convert(varchar(50),a.返回日期,23)='"+null+"'");
		}
		StringBuffer dataSql = new StringBuffer("select a.接口代码,a.接口名称, a.返回标识,convert(varchar(50),a.返回日期,23) as riqi,a.返回信息 from T_MYJK_EVENTLOG a");
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
