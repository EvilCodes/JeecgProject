package com.yangjiang.controller.pipeup;
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

import com.yangjiang.controller.batch.t_zg_batchController;
import com.yangjiang.service.batch.t_zg_batchServiceI;
@Controller
@RequestMapping("/PipeUpcontroller")
public class PipeUpcontroller extends BaseController{
	
	//myjkscjhController.do?orderDataGrid
	
		private static final Logger logger = Logger.getLogger(PipeUpcontroller.class);

		@Autowired
		private SystemService systemService;
		
		@RequestMapping(params="PipeUpDataGrid")
		@ResponseBody
		public Map PipeUpDataGrid(HttpServletRequest request,HttpServletResponse response){
			Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
			Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
			
			//参数条件
			String rukudanid = request.getParameter("rukudanid");
			StringBuffer cdt =  new StringBuffer();
			if(StringUtil.isNotEmpty(rukudanid)){
				cdt.append(" and a.rukudanid='"+rukudanid+"'");
			}				
			StringBuffer dataSql = new StringBuffer("select a.rukudanid as rukudanid,b.pipe_code as pipe_code,b.packageid as packageid,b.exp_flag as exp_flag,b.pipenum as pipenum,b.suit_way as suit_way,b.huowei as huowei,b.cengci as cengci,b.cengneixuhao as cengneixuhao,b.item_cname as item_cname from t_zgk_pipe_rkm a inner join t_zgk_pipe_rkd b on a.rukudanid=b.rukudanid");
			if(cdt.length()>0){
				dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
			}
		
			System.out.println(dataSql.toString());
			List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		//
			String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
			
			Long total= systemService.getCountForJdbc(totalSql);	
			//注意用JEECG 工具类
//			组织datagrid 数据格式
			Map oderData = new HashMap();
			oderData.put("total", total);
			oderData.put("rows", dataResult);
			System.out.println(JSONHelper.bean2json(oderData)); 
			return oderData;
		}

}
