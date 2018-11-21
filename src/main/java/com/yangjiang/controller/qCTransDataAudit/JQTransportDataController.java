package com.yangjiang.controller.qCTransDataAudit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yangjiang.controller.pipeup.PipeUpcontroller;
@Controller
@RequestMapping("/JQTransportDataController")
public class JQTransportDataController extends BaseController {
	private static final Logger logger = Logger.getLogger(PipeUpcontroller.class);
	//汽车抛数审核
	@Autowired
	private SystemService systemService;
	@RequestMapping(params = "list")
	public ModelAndView SCJHDList(HttpServletRequest request){
		 return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/t_ZGK_PIPE_JQCKMList");
	}
	
	@RequestMapping(params="PipeUpDataGrid")
	@ResponseBody
	public Map PipeUpDataGrid(HttpServletRequest request,HttpServletResponse response){
		Integer page = StringUtil.isEmpty(request.getParameter("page")) ? 1: Integer.parseInt(request.getParameter("page"));
		Integer rows = StringUtil.isEmpty(request.getParameter("rows")) ? 10:Integer.parseInt(request.getParameter("rows"));
		
		//参数条件
		
		StringBuffer cdt =  new StringBuffer();
		//String chukudanid = request.getParameter("chukudanid");
		//if(StringUtil.isNotEmpty(chukudanid)){
		//	cdt.append(" and m.chukudanid='"+chukudanid+"'");
		//}else{
		//	cdt.append(" and m.chukudanid=null");
		//}
		String riqi = request.getParameter("riqi");
				if(StringUtil.isNotEmpty(riqi)){
					cdt.append(" and m.riqi>='"+riqi+"'");
				}else{
					cdt.append(" and m.riqi=null");
				}
		//cdt.append(" (m.trnp_mode = '自提汽运' )  or  (m.trnp_mode = '代办汽运') ");
		System.out.println("cdt.toString:"+cdt.toString());
		StringBuffer dataSql = new StringBuffer("SELECT c.id,m.chukudanid, m.store_name, m.carry_company_code,c.itemCode,c.itemName,c.sendNum,c.sendWeight,"+
                "m.carry_company_name, m.car_no, m.driver_name, m.driver_tel, m.id_number, m.baoguanyuan, m.BLOCK_SIZE,"+
                "m.BLOCK_SIZE_NAME, m.BLOCK_NO, m.NO_SAME_MARK, m.SAMPLE, m.BOX_NO, c.SHR, c.SHSJ, c.SHBZ, "+
                "m.REMARK, m.riqi, m.org_name, m.consign_cname, m.delivy_place_name, m.private_route_name, d.bill_notice_no,"+
                "m.send_car_no, m.trnp_mode, m.READ_FLAG,d.bill_notice_no_item  "+
				  "FROM T_ZGK_PIPE_CKD_JQ AS c INNER JOIN  "+
                 "T_ZGK_PIPE_CKM m on m.chukudanid = c.chukudanid "+
				 "inner join T_ZGK_FYJH_PCD d on c.pcdId=d.send_car_no");
		if(cdt.length()>0){
			dataSql.append("  where "+cdt.substring(cdt.indexOf("and")+3, cdt.length()));
		}
		System.out.println("cdt:-------------------------------------------------");
		System.out.println("cdt:-------------------------"+cdt.indexOf("and")+2);		
		System.out.println("dataSql.toString:"+dataSql.toString());
		List<Map<String, Object>> dataResult=systemService.findForJdbc(dataSql.toString(), page,rows);
		String totalSql = "select count(1)   "+dataSql.substring(dataSql.indexOf("FROM"), dataSql.length());
		System.out.println("totalSql："+"select count(1)  "+dataSql.substring(dataSql.indexOf("FROM"), dataSql.length()));
		
		Long total= systemService.getCountForJdbc(totalSql);	
//		组织datagrid 数据格式
		Map oderData = new HashMap();
		oderData.put("total", total);
		oderData.put("rows", dataResult);
		//Map oderData = new HashMap();
		//oderData.put("total", total);
		//oderData.put("rows", dataResult);
		System.out.println(JSONHelper.bean2json(oderData)); 
		return oderData;
	}
}
