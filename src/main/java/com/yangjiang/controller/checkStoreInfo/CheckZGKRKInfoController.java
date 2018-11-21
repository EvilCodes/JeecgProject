package com.yangjiang.controller.checkStoreInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
@RequestMapping("/CheckZGKRKInfoController")
public class CheckZGKRKInfoController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckFYJHJQController.class);

	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/checkstoreInfo/CheckZGKRKDayInfo");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		StringBuffer cdt =  new StringBuffer();
		String sriqi = request.getParameter("sriqi");
		String eriqi = request.getParameter("eriqi");
		if(StringUtil.isNotEmpty(sriqi)){
			cdt.append(" and inStoreDay>= '"+sriqi+"'");
		}else{
			cdt.append(" and inStoreDay= '"+null+"'");
		}
		if(StringUtil.isNotEmpty(eriqi)){
			cdt.append(" and inStoreDay<= '"+eriqi+"'");
		}else{
			cdt.append(" and inStoreDay= '"+null+"'");
		}
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and SPEC_DESC= '"+dn+"'");
		}
		StringBuffer dataSql = new StringBuffer("select * from V_ZGK_PIPE_CX_RK ");
		System.out.println("cdt.length:"+cdt.length());
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
		}
//	    dataSql.append(" order by item_code asc");
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);	
		Collections.sort(dataResult,new Comparator<Map>() {

			@Override
			public int compare(Map o1, Map o2) {
				String pipeDesc1=(String) o1.get("SPEC_DESC");
				pipeDesc1=pipeDesc1.substring(2, pipeDesc1.length());
				int dn1=Integer.parseInt(pipeDesc1);
				
				String pipeDesc2=(String) o2.get("SPEC_DESC");
				pipeDesc2=pipeDesc2.substring(2, pipeDesc2.length());
				int dn2=Integer.parseInt(pipeDesc2);
				if (dn1>dn2) {
					return 1;
					
				}else{
					
					return -1;
				}
				
			}
		});
		
		
		
		@SuppressWarnings("unchecked")
		String totalSql = "select count(1)  "+dataSql.substring(dataSql.indexOf("from"), dataSql.length());
		
		Long total= systemService.getCountForJdbc(totalSql);	

		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}

}
