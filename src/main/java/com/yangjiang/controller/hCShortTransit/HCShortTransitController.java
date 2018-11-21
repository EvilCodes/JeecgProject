package com.yangjiang.controller.hCShortTransit;

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

import com.yangjiang.controller.pipeup.PipeUpcontroller;
@Controller
@RequestMapping("/HCShortTransitController")
public class HCShortTransitController extends BaseController {
	private static final Logger logger = Logger.getLogger(PipeUpcontroller.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map PipeUpDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		StringBuffer cdt =  new StringBuffer();
		String chukudanid = request.getParameter("chukudanid");
		if(StringUtil.isNotEmpty(chukudanid)){
			cdt.append(" and a.chukudanid='"+chukudanid+"'");
		}else{
			cdt.append(" and a.chukudanid='"+null+"'");
		}
		//String mystatus="已装火车";
		//cdt.append("and status is null");
		//StringBuffer dataSql = new StringBuffer("select * from t_zgk_pipe_ckd");
		String carno = request.getParameter("carno");
		if(StringUtil.isNotEmpty(carno)){
			cdt.append(" and a.car_no='"+carno+"'");
		}
		String mystatus="2";
		cdt.append("and status is null");
		StringBuffer dataSql = new StringBuffer("select a.chukudanid, b.dn, b.batch_full, b.pipe_serial, b.packageid, b.product_plan_no, b.item_code, b.item_cname, b.exp_flag, "+ 
						"b.special_desc, b.pipenum, b.suit_way, b.huowei, b.cengci, b.cengneixuhao, b.product_line, b.bill_lading_no_item, b.id, b.status  "+
					"from  t_zgk_pipe_ckm a inner join t_zgk_pipe_ckd b on a.chukudanid=b.chukudanid");
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}
	
		System.out.println("SQL:"+dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
	//
		String totalSql = "select count(1) "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
		System.out.println("SQL:"+totalSql.toString());
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
