package com.yangjiang.controller.checkStoreInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.demo.service.test.JeecgProcedureServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yangjiang.controller.checkrukuid.CheckrukuidController;
import com.yangjiang.controller.fyjhCheck.CheckFYJHJQController;
@Controller
@RequestMapping("/CheckZGKACCInfoController")
public class CheckZGKACCInfoController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckZGKACCInfoController.class);

	@Autowired
	private SystemService systemService;
	
	
	@RequestMapping(params = "list")
	public ModelAndView FYJHList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/checkstoreInfo/CheckZGKAccInfo");
	}
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map datagrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		Date mydate=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(mydate);  
	    
		StringBuffer cdt =  new StringBuffer();
		String sriqi = request.getParameter("sriqi");
		if(StringUtil.isNotEmpty(sriqi)){	 
			try {
				Date indate = (Date)sdf.parse(sriqi.toString());			 				
				 
				 systemService.executeProcedure("P_ZGK_JHZX", indate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		if(StringUtil.isNotEmpty(sriqi)){
			 System.out.println("3333333333");
			cdt.append(" and convert(varchar(50),rq,23) = '"+sriqi+"'");
		}else{
			systemService.executeProcedure("exec P_ZGK_JHZX",mydate);
			cdt.append(" and convert(varchar(50),rq,23) = '"+sdate+"'");
		}
		String dn = request.getParameter("dn");
		if(StringUtil.isNotEmpty(dn)){
			cdt.append(" and SPEC_DESC = '"+dn+"'");
		}
		
		//systemService.executeProcedure("exec P_ZGK_JHZX indate");
		
		StringBuffer dataSql = new StringBuffer("select a.rq,a.SPEC_DESC,a.INTERFACE_DESC,a.PROD_GRADE_DESC,a.exp_flag,a.PIECE_WT,a.ycnum,"+
												"a.ycnum*a.PIECE_WT as ycWeight,"+
												 "a.rknum,a.rknum*a.PIECE_WT as rkWeight,a.rklnum,a.rklnum*a.PIECE_WT as rklWeight,"+
												 "a.cknum,a.cknum*a.PIECE_WT as ckWeight,a.cklnum,a.cklnum*a.PIECE_WT as cklWeight,"+
												 "a.tknum,a.tknum*a.PIECE_WT as tkWeight,a.tklnum,a.tklnum*a.PIECE_WT as tklWeight,"+
												 "a.jhnum,a.jhnum*a.PIECE_WT as jhWeight,(a.ycnum+a.rknum-a.cknum+a.tknum) as endNum,(a.ycnum+a.rknum-a.cknum+a.tknum)*a.PIECE_WT as endWeight "+
												 "from  V_ZGK_JHZX a ");
		System.out.println("cdt.length:"+cdt.length());
		if(cdt.length()>0){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+4,cdt.length()));
		}
	
		System.out.println(dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);	
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
