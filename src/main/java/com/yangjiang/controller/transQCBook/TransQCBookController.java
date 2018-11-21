package com.yangjiang.controller.transQCBook;

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

import com.yangjiang.controller.checkzgtransportplan.CheckZgTransportPlanController;
@Controller
@RequestMapping("/TransQCBookController")
public class TransQCBookController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckZgTransportPlanController.class);
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params="datagrid")
	@ResponseBody
	public Map planDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		StringBuffer cdt =  new StringBuffer();
		
		String chukudanid = request.getParameter("chukudanid");	
		if(StringUtil.isNotEmpty(chukudanid)){			
			System.out.println(chukudanid);
			cdt.append(" and a.chukudanid = '"+chukudanid+"'");
		}	
		//String sendCarNo = request.getParameter("sendCarNo");	
		
			//cdt.append(" and 核减短倒 !=0 ");
			
		StringBuffer dataSql = new StringBuffer("select a.chukudanid,convert(nvarchar(100),a.riqi,102) as riqi," +
												"a.org_name,a.bill_notice_no,c.SALE_PERSON_NAME,"+
												"c.MOBILE_PHONE,a.store_name,a.carry_company_name,a.car_no,a.driver_tel," +
												"a.consign_cname,a.delivy_place_name,a.baoguanyuan,c.REC_PERSON,c.REC_TEL," +
												"d.PRODUCT_CTGR_MAJOR_DT_DESC,d.LENGTH_DESC,sum(b.pipenum) as totalnum" +
												"from T_ZGK_PIPE_CKM a inner join T_ZGK_PIPE_CKD b on a.chukudanid=b.chukudanid" +
												"inner join T_MYJK_FYJH c on a.bill_notice_no=c.BILL_NOTICE_NO" +
												"inner join V_MYBM_ZG_CPBM d on c.ITEM_CODE=d.ITEM_CODE"+
												"group by "+
												"a.chukudanid,a.riqi,a.org_name,a.bill_notice_no,c.SALE_PERSON_NAME," +
												"c.MOBILE_PHONE,a.store_name,a.carry_company_name,a.car_no,a.driver_tel," +
												"a.consign_cname,a.delivy_place_name,a.baoguanyuan,c.REC_PERSON,c.REC_TEL," +
												"d.PRODUCT_CTGR_MAJOR_DT_DESC,d.LENGTH_DESC,b.pipenum" );
		System.out.println(cdt.length());		
		if(cdt.length()>3){
			dataSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}		
		//System.out.println("字串："+dataSql.substring(dataSql.indexOf("FROM"), dataSql.length()));
		System.out.println("dataSql:"+dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		
		System.out.println("dataSql.length:"+dataSql.length());
		//StringBuffer totalSql = new StringBuffer("select count(1) from V_ZGK_FYJH_ZXJD_HC" );
		//System.out.println("totalSql："+totalSql.toString());
		//if(cdt.length()>3){
			//totalSql.append(" where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		//}	
		//Long total= systemService.getCountForJdbc(totalSql.toString());
		//String totalSql = "select count(1)  "+num;
		//System.out.println("totalSql："+totalSql.toString());
		//Long total= systemService.getCountForJdbc(totalSql);	
//		组织datagrid 数据格式
		Map oderData = new HashMap();
		//oderData.put("total", total);
		oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}

}
