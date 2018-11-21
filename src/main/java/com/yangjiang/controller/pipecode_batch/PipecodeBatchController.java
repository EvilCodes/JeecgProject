package com.yangjiang.controller.pipecode_batch;

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
import com.yangjiang.controller.oder.MyjkscjhController;
import com.yangjiang.service.batch.t_zg_batchServiceI;

@Controller
@RequestMapping("/pipecodebatchController")
public class PipecodeBatchController extends BaseController {
	private static final Logger logger = Logger.getLogger(PipecodeBatchController.class);

	@Autowired
	private SystemService systemService;
	@RequestMapping(params="pipecodeDataGrid")
	@ResponseBody
	public Map pipecodeDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		StringBuffer cdt =  new StringBuffer();
		String pYear = request.getParameter("pYear");
		if(StringUtil.isNotEmpty(pYear)){
			cdt.append(" and pYear='"+pYear+"'");
		}
		//System.out.println(pMonth.length());
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and dn='"+dn+"'");
		}
		String grade = request.getParameter("grade");
		if(StringUtil.isNotEmpty(grade)){
			cdt.append(" and grade='"+grade+"'");
		}
		String interface_desc = request.getParameter("interface_desc");
		if(StringUtil.isNotEmpty(interface_desc)){
			cdt.append(" and interface_desc='"+interface_desc+"'");
		}
		String length = request.getParameter("length");
		if(StringUtil.isNotEmpty(length)){
			cdt.append(" and length='"+length+"'");
		}
		String pipetype = request.getParameter("pipetype");
		if(StringUtil.isNotEmpty(pipetype)){
			cdt.append(" and pipetype='"+pipetype+"'");
		}
		StringBuffer dataSql = new StringBuffer("select batch_full,pipe_code,pipe_serial,batch,pYear,dn from pipe_batch");
		if(cdt.length()>3){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}
	
		System.out.println("dataSql:"+dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
	//
		String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
		
		Long total= systemService.getCountForJdbc(totalSql);	
		//注意用JEECG 工具类
//		组织datagrid 数据格式
		Map pipecodeData = new HashMap();
		pipecodeData.put("total", total);
		pipecodeData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(pipecodeData)); 
		
		return pipecodeData;
	}
}
