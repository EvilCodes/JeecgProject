package com.yangjiang.controller.checkStoreInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.yangjiang.controller.checkrukuid.CheckrukuidController;
import com.yangjiang.controller.fyjhCheck.CheckFYJHJQController;
@Controller
@RequestMapping("/CheckZGKKCInfoController")
public class CheckZGKKCInfoController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckFYJHJQController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/checkstoreInfo/CheckZGKKCDayInfo");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		StringBuffer cdt =  new StringBuffer();
		String packid = request.getParameter("packid");
		if(StringUtil.isNotEmpty(packid)){
			cdt.append(" and a.packageid= '"+packid+"'");
		}
		String batchfull = request.getParameter("batchfull");
		if(StringUtil.isNotEmpty(batchfull)){
			cdt.append(" and a.batch_full= '"+batchfull+"'");
		}
		String pipeserial = request.getParameter("pipeserial");
		if(StringUtil.isNotEmpty(pipeserial)){
			cdt.append(" and a.a.pipe_serial= '"+pipeserial+"'");
		}
		String huowei = request.getParameter("huowei");
		if(StringUtil.isNotEmpty(huowei)){
			cdt.append(" and a.huowei= '"+huowei+"'");
		}
		String cengci = request.getParameter("cengci");
		if(StringUtil.isNotEmpty(cengci)){
			cdt.append(" and a.cengci= '"+cengci+"'");
		}
		String cengneixuhao = request.getParameter("cengneixuhao");
		if(StringUtil.isNotEmpty(cengneixuhao)){
			cdt.append(" and a.cengneixuhao= '"+cengneixuhao+"'");
		}
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and SPEC_DESC= '"+dn+"'");
		}
		StringBuffer dataSql = new StringBuffer("SELECT a.store_name,a.pipe_serial, a.dn, a.pipenum,a.huowei, a.packageid, a.batch_full, a.cengci, a.cengneixuhao, b.PROD_GRADE_DESC, "+ 
                				"b.INTERFACE_DESC, b.LENGTH_DESC, b.ZN_THICK_DESC, b.PIECE_WT "+
                				"FROM  T_ZGK_PIPE_KC AS a INNER JOIN  V_MYBM_ZG_CPBM AS b ON a.item_code = b.ITEM_CODE ");
		System.out.println("cdt.length:"+cdt.length());
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
		}
	
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);	
		System.out.println("--------------------------------------------------------");
		//System.out.println("dataSql.append:::"+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
		//String totalSql="select sum(a.pipenum) as totalNum from ('"+dataSql.toString()+"') t"
		@SuppressWarnings("unchecked")
		String totalSql = "select sum(pipenum) as totalNum from ("+dataSql+") t ";
		System.out.println("totalSql："+totalSql);
		Long total= systemService.getCountForJdbc(totalSql);	

		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData));
		request.setAttribute("total", total);
		return oderData;
	}

}
