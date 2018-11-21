package com.yangjiang.controller.t_zgk_pipe_ckm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_myjk_scjh.T_MYJK_SCJHEntity;
import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.entity.t_zg_pipe_rk.T_zg_pipe_rkEntity;
import com.yangjiang.entity.t_zgk_pipe_ck_hcz.T_ZGK_PIPE_CK_HCZEntity;
import com.yangjiang.entity.t_zgk_pipe_ckd.T_ZGK_PIPE_CKDEntity;
import com.yangjiang.entity.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMEntity;
import com.yangjiang.entity.t_zgk_pipe_ckd_jq.T_ZGK_PIPE_CKD_JQEntity;
import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.entity.t_zgk_pipe_rkm.T_ZGK_PIPE_RKMEntity;
import com.yangjiang.service.t_zgk_pipe_ckd.T_ZGK_PIPE_CKDServiceI;
import com.yangjiang.service.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMServiceI;
import com.yangjiang.service.t_zgk_pipe_ckd_jq.T_ZGK_PIPE_CKD_JQServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 出库单主表
 * @author zhangdaihao
 * @date 2016-10-31 09:51:55
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_CKMController")
public class T_ZGK_PIPE_CKMController extends BaseController {
	/**
	 * Logger for this class
	 */
	//@Autowired //当时没有加这个注解，自动装配Bean
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_CKMController.class);

	@Autowired
	private T_ZGK_PIPE_CKMServiceI t_ZGK_PIPE_CKMService;
	@Autowired
	private T_ZGK_PIPE_CKDServiceI t_ZGK_PIPE_CKDService;
	@Autowired
	private T_ZGK_PIPE_CKD_JQServiceI t_ZGK_PIPE_CKD_JQService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(params = "ckViewPrint")
	public ModelAndView ckViewPrint(T_ZGK_PIPE_CKMEntity t_zg_pipe_ckm,HttpServletRequest request){	
		if(StringUtil.isNotEmpty(t_zg_pipe_ckm.getChukudanid())){
			t_zg_pipe_ckm = t_ZGK_PIPE_CKMService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", t_zg_pipe_ckm.getChukudanid());
			request.setAttribute("t_zg_pipe_ckm", t_zg_pipe_ckm);
			String sql ="SELECT  b.batch_full,b.dn,c.GROSS_WT,c.ZN_THICK_DESC, a.store_name,a.baoguanyuan," +
					"a.carry_company_name,a.trnp_mode,a.consign_cname,a.org_name,d.delivy_place_name,a.car_no,a.riqi,a" +
					".chukudanid,b.dn,b.batch_full,b.exp_flag,c.PROD_GRADE_DESC,c.INTERFACE_DESC,c.OUTER_COATING_DESC," +
					"c.INNER_LINING_DESC,b.special_desc,c.LENGTH_DESC,c.PIECE_WT,sum(b.pipenum) as pipenum " +
					"FROM T_ZGK_PIPE_CKM as a INNER JOIN T_ZGK_PIPE_CKD as b ON " +
					"a.chukudanid = b.chukudanid INNER JOIN V_MYBM_CPBM as " +
					"c ON b.item_code = c.ITEM_CODE inner join T_MYJK_FYJH d on a.bill_notice_no=d.BILL_NOTICE_NO and a.bill_lading_no_item=d.BILL_LADING_NO_ITEM where a.chukudanid=? "+
					" group by "+
					" b.batch_full,b.dn,c.GROSS_WT,c.ZN_THICK_DESC, a.store_name,a.baoguanyuan, "+
					"a.carry_company_name,a.trnp_mode,a.consign_cname,a.org_name,a.delivy_place_name,a.car_no,a.riqi,a" +
					".chukudanid,b.dn,b.batch_full,b.exp_flag,c.PROD_GRADE_DESC,c.INTERFACE_DESC,c.OUTER_COATING_DESC," +
					"c.INNER_LINING_DESC,b.special_desc,c.LENGTH_DESC,c.PIECE_WT,d.delivy_place_name";
			System.out.println("getChukudanid:"+t_zg_pipe_ckm.getChukudanid());
			List<Map<String, Object>>  printData= t_ZGK_PIPE_CKMService.findForJdbc(sql,t_zg_pipe_ckm.getChukudanid());
			int rows =0;
			int total = printData.size();
			String chukudanid=t_zg_pipe_ckm.getChukudanid();
			System.out.println("chukudanid:"+chukudanid);
			String sqlTotal="SELECT a.chukudanid,sum(c.PIECE_WT*b.pipenum) as totalWeight,sum(b.pipenum) as totalPipeNum FROM T_ZGK_PIPE_CKM as a INNER JOIN T_ZGK_PIPE_CKD as b ON a.chukudanid = b.chukudanid INNER JOIN V_MYBM_CPBM as c ON b.item_code = c.ITEM_CODE  where a.chukudanid= '"+chukudanid+"'  group by a.chukudanid" ;
			Map<String, Object> TotalData= t_ZGK_PIPE_CKMService.findOneForJdbc(sqlTotal);
			String jqSql="select a.name,b.SPEC_DESC,a.sendNum,a.factory,a.sendWeight,a.remark  "+ 
							"from T_ZGK_PIPE_CKD_JQ a inner join V_MYBM_CPBM b on a.itemCode=b.ITEM_CODE where a.chukudanid='"+chukudanid+"' ";
			List<Map<String, Object>>  jqprintData= t_ZGK_PIPE_CKMService.findForJdbc(jqSql);
			request.setAttribute("TotalData", TotalData);
			//System.out.println(TotalData.get("TotalData")+";;;"+TotalData.get("totalPipeNum"));
//			request.setAttribute("totalWeight", TotalData.get("TotalData"));
//			request.setAttribute("totalPipeNum", TotalData.get("totalPipeNum"));
			
			System.out.println("TotalData:"+total);
			
			request.setAttribute("rows", rows);
			request.setAttribute("total", total);//这里就是合计了啊
			//不对
			request.setAttribute("jqprintData", jqprintData);
			request.setAttribute("printData", printData);
			//request.setAttribute("TotalData", TotalData);	
			
			System.out.println("------------------------------------------------");
			System.out.println("printData:"+printData);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/ckViewPrint");
	}
	//打印跟踪卡
	@RequestMapping(params = "gzViewPrint")
	public ModelAndView gzViewPrint(T_ZGK_PIPE_CKMEntity t_zg_pipe_ckm,HttpServletRequest request){	
		if(StringUtil.isNotEmpty(t_zg_pipe_ckm.getChukudanid())){
			t_zg_pipe_ckm = t_ZGK_PIPE_CKMService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", t_zg_pipe_ckm.getChukudanid());
			request.setAttribute("t_zg_pipe_ckm", t_zg_pipe_ckm);
			String sql ="SELECT CONVERT(varchar(100), a.riqi, 102) as mday,CONVERT(varchar(100), a.riqi, 108) as mtime,dbo.f_RemoveChinese(b.SPECIAL_DESC) as ddh,a.*,b.* from T_ZGK_PIPE_CKM a inner join T_MYJK_FYJH b on a.bill_notice_no=b.BILL_NOTICE_NO and a.bill_lading_no_item=b.BILL_LADING_NO_ITEM where a.chukudanid=?";
			System.out.println("getChukudanid:"+t_zg_pipe_ckm.getChukudanid());
			List<Map<String, Object>>  printData= t_ZGK_PIPE_CKMService.findForJdbc(sql,t_zg_pipe_ckm.getChukudanid());
			//查询管材出库信息
			String pipeSql="select a.baoguanyuan,a.chukudanid,b.dn,'' special_desc,c.LENGTH_DESC,sum(b.pipenum) as numpipe from T_ZGK_PIPE_CKM as a inner join T_ZGK_PIPE_CKD as b on a.chukudanid=b.chukudanid inner join V_MYBM_CPBM c on b.item_code=c.ITEM_CODE where a.chukudanid=? group by a.chukudanid,b.dn,c.LENGTH_DESC,a.baoguanyuan";
			List<Map<String, Object>>  printPipeData= t_ZGK_PIPE_CKMService.findForJdbc(pipeSql,t_zg_pipe_ckm.getChukudanid());
			String jqSql="select a.name,b.SPEC_DESC,a.sendNum,a.factory,a.sendWeight,a.remark  "+ 
					"from T_ZGK_PIPE_CKD_JQ a inner join V_MYBM_CPBM b on a.itemCode=b.ITEM_CODE where a.chukudanid='"+t_zg_pipe_ckm.getChukudanid()+"' ";
	         List<Map<String, Object>>  jqprintData= t_ZGK_PIPE_CKMService.findForJdbc(jqSql);
	         String jqSql1="select ' ' name, ' ' SPEC_DESC, ' ' sendNum union all select ' ' name, ' ' SPEC_DESC, ' ' sendNum";
		      List<Map<String, Object>>  jqprintData1= t_ZGK_PIPE_CKMService.findForJdbc(jqSql1);
			int total = printPipeData.size();
			if(jqprintData.size()>1)
			{
				request.setAttribute("jqprintData1", jqprintData);
		  }else 
			{
			  request.setAttribute("jqprintData1", jqprintData1);
			}
				
			//jqprintData total_num=sum(pipe_num);
			//int rows =0;
			//if(total>0){
				//rows = (int)Math.ceil(total/2d);
			//}
			//request.setAttribute("rows", rows);
			request.setAttribute("total", total);
			request.setAttribute("printData", printData);
			request.setAttribute("printPipeData", printPipeData);
			request.setAttribute("jqprintData", jqprintData);
			System.out.println("------------------------------------------------");
			System.out.println("printData:"+printData);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/gzViewPrint");
	}
	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/t_zgk_pipe_ckm1");
		//return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/t_ZGK_PIPE_CKMList");
	}
	/**
	 * 出库单主表列表 页面跳转
	 * 
	 * @return
	 
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		System.out.print("111111111111111111111111");
		//return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/t_ZGK_PIPE_CKMList");
		return new ModelAndView("com/yangjiang/t_zgk_pipe_tkm/t_ZGK_PIPE_TKMList");
		//return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/t_ZGK_PIPE_QCCKMList");
	}*/
	/**
	 * 管材手工入库主表信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list4")
	public ModelAndView list4(HttpServletRequest request) {
		request.setAttribute("chukudanid", request.getParameter("chukudanid"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd/t_ZGK_PIPE_CKDList3");
	}
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "datagrid4")
	public void datagrid4(T_ZGK_PIPE_CKDEntity ckd,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_CKDEntity.class, dataGrid);
		String chukudanid=ckd.getChukudanid();
		cq.eq("chukudanid", chukudanid);
		cq.add();
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_RKM, request.getParameterMap());
		this.t_ZGK_PIPE_CKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid")
	public void datagrid(T_ZGK_PIPE_CKMEntity t_ZGK_PIPE_CKM,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_CKMEntity.class, dataGrid);
		//查询条件组装器
		//String conceal=t_ZGK_PIPE_CKM.getConceal();
		
		if(t_ZGK_PIPE_CKM.getRiqi()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("riqi", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_ZGK_PIPE_CKM.getRiqi();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			//cq.notEq("conceal", "作废");
			
			cq.between("riqi", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_CKM, request.getParameterMap());
		cq.add();
		this.t_ZGK_PIPE_CKMService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除出库单主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_CKMEntity t_ZGK_PIPE_CKM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_CKM = systemService.getEntity(T_ZGK_PIPE_CKMEntity.class, t_ZGK_PIPE_CKM.getId());
		message = "出库单主表删除成功";
		t_ZGK_PIPE_CKMService.delete(t_ZGK_PIPE_CKM);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 作废出库单
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doConceal")
	@ResponseBody
	public AjaxJson doConceal(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
	
			//String ids=request.getParameter("id");
			T_ZGK_PIPE_CKMEntity ckm = systemService.getEntity(T_ZGK_PIPE_CKMEntity.class, ids);
			//System.out.print("duqubiaozhi"+ckm.getReadFlag());
				//List<T_ZGK_PIPE_CKMEntity> ckm =systemService.findByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", idsAttr[i]);
				//T_ZGK_PIPE_CKMEntity ckm=systemService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", idsAttr[i]);
				if(ckm.getReadFlag().equals("1") || ckm.getReadFlag().equals("2") ){
					j.setMsg("该条信息已经抛送给贸易公司，不能作废，请联系管理员修改！！！！");
					return j;
				}else if(ckm.getShbz().equals("1")){
					j.setMsg("该条信息已经审核通过，不能作废，请联系管理员修改！！！！");
					return j;
				}else{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date d=new Date();
					String sdate = sdf.format(d);
					ckm.setShsj(sdate);
					ckm.setShbz("0");
					ckm.setConceal("作废");
				    String edituser=ResourceUtil.getSessionUserName().getUserName();
				   ckm.setShr(edituser);
				   j.setMsg("恭喜，操作成功");
				}
				
				t_ZGK_PIPE_CKMService.saveOrUpdate(ckm);
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doConceal>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	/**
	 * 作废出库单
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doConcealJQ")
	@ResponseBody
	public AjaxJson doConcealJQ(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			// System.out.print("duqubiaozhi11"+request.getParameter("ids"));
			
			T_ZGK_PIPE_CKMEntity ckm = systemService.getEntity(T_ZGK_PIPE_CKMEntity.class, request.getParameter("ids"));
		
			T_ZGK_PIPE_CKD_JQEntity jq=systemService.findUniqueByProperty(T_ZGK_PIPE_CKD_JQEntity.class,"chukudanid",ckm.getChukudanid());
			    //System.out.print("duqubiaozhi"+ckm.getReadflag());"chukudanid", idsAttr[i]
			System.out.print("************id:"+jq.getId()+","+jq.getReadflag()+","+jq.getShbz());
			/*if(planStatus.values().toString()=="[00]"||planStatus.values().toString()=="[35]"){
				message="该计划已经强制结案或者终结，请联系贸易公司"	;
				j.setMsg(message);
				//j.setSuccess(false); 
				return j;
			}*/
				if(jq.getReadflag().equals("1") || jq.getReadflag().equals("2") ){
					j.setMsg("该条信息已经抛送给贸易公司，不能作废，请联系管理员修改！！！！");
					return j;
				}
				//else if(jq.getShbz() !=null && jq.getShbz().equals("1")){
				//	j.setMsg("该条信息已经审核通过，不能作废，请联系管理员修改！！！！");
					//return j;
				//}
				else
				{
				//	T_ZGK_PIPE_CKD_JQEntity	t_ZGK_PIPE_CKD_JQ = systemService.getEntity(T_ZGK_PIPE_CKD_JQEntity.class, jq.getId());
					String message = "随车胶圈删除成功";
					//System.out.print("************id:"+jq.getId());
					t_ZGK_PIPE_CKD_JQService.delete(jq);
					systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
					
					j.setMsg(message);
					return j;
				}
				
	
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doConceal>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	/**
	 * 出库单保存后再单独添加管号时的坚持
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "check")
	@ResponseBody
	public String check(HttpServletResponse response, HttpServletRequest request) {
		String seq=request.getParameter("chukudanid");
		String Result="";
		T_ZGK_PIPE_CKMEntity ckm=systemService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class,"chukudanid",seq);
		if(ckm.getReadFlag().equals("1") || ckm.getReadFlag().equals("2") ){
			//j.setMsg("该条信息已经抛送给贸易公司，不能作废，请联系管理员修改！！！！");
			//return j;
			Result= "已抛数";
		}
		else if(ckm.getShbz() !=null && ckm.getShbz().equals("1")){
			//j.setMsg("该条信息已经审核通过，不能作废，请联系管理员修改！！！！");
			//return j;
			Result= "已审核";
		}
		else 
		{
			 String checkSql="select count(*) from t_zgk_pipe_ckd where chukudanid='"+seq+"'";
			 long count=systemService.getCountForJdbc(checkSql);
			 String checkSql1="select isnull(carry_num,0) from T_ZGK_FYJH_PCD where number=1 and send_car_no='"+ckm.getSendCarNo()+"'";
			 long count1=systemService.getCountForJdbc(checkSql);
			 if (count1>count && count>0)
			 {
				 Result= "OK"; 
			 }
			 
			 else if (count<=0)
			 {
				 Result= "请先出库";
			 }
			 else if (count==count1)
			 {
				 Result="出库数和派车数一致,无法添加";
			 }
			 
		}
		//String sql="select isnull(max(SUBSTRING(chukudanid, 11, 3)),0)+1  from T_ZGK_PIPE_CKM where SUBSTRING(chukudanid, 1, 8)='"+seq+"'";
		//System.out.println("sql:"+sql);
		//Long total= systemService.getCountForJdbc(sql);
		System.out.println("total:"+Result);
		//return total.toString();
		return Result.toString();
	}
	
	
	@RequestMapping(params="doCheck")
	@ResponseBody
	public AjaxJson doCheck(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				//List<T_ZGK_PIPE_CKMEntity> ckm =systemService.findByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", idsAttr[i]);
				T_ZGK_PIPE_CKMEntity ckm=systemService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", idsAttr[i]);
				if(ckm.getReadFlag()=="1" || ckm.getReadFlag()=="2" ){
					j.setMsg("该条信息已经抛送给贸易公司，不能再审，请联系管理员修改！！！！");
					return j;
				}else if(ckm.getShbz()=="1"){
					j.setMsg("该条信息已经审核通过，无需再审，请联系管理员修改！！！！");
					return j;
				}else{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date d=new Date();
					String sdate = sdf.format(d);
					ckm.setShsj(sdate);
					ckm.setShbz("1");
				String edituser=ResourceUtil.getSessionUserName().getUserName();
				ckm.setShr(edituser);
				}
				
				t_ZGK_PIPE_CKMService.saveOrUpdate(ckm);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doCheck>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	
	
	/**
	 * 批量作废操作
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doTrash")
	@ResponseBody
	public AjaxJson doTrash(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功！");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				
				T_ZGK_PIPE_CKMEntity ckm =t_ZGK_PIPE_CKMService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class, "chukudanid", idsAttr[i]);
				//System.out.println("data:"+ckm.getReadFlag());
				//System.out.println("data1:"+ckm.getShbz());
				if(ckm.getReadFlag().equals("1") || ckm.getReadFlag().equals("2")){
					j.setMsg("该条信息已经抛送给贸易公司，不能废除，请联系管理员修改！！！！");
					return j;
				}else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date d=new Date();
					String sdate = sdf.format(d);
					ckm.setShsj(sdate);
					ckm.setShbz("0");
				   String edituser=ResourceUtil.getSessionUserName().getUserName();
				   ckm.setShr(edituser);
				   t_ZGK_PIPE_CKMService.saveOrUpdate(ckm);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doTrash>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	
	/**
	 * 添加出库单主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_CKMEntity t_ZGK_PIPE_CKM, HttpServletRequest request) {
		String message = "铸管库出库成功";
		AjaxJson j = new AjaxJson();
		
		try{
			String jsondata=request.getParameter("data");	
			System.out.println("data:"+jsondata);
			System.out.println("data:"+jsondata.length());
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);
				JSONObject dataObj = dataArr.getJSONObject(0);
				String bill_lading_no_item=dataObj.getString("bill_lading_no_item");
				String bill_notice_no=dataObj.getString("bill_notice_no");
				String queryFYJHSql="select a.PLAN_STATUS from T_MYJK_FYJH a where a.BILL_LADING_NO_ITEM='"+bill_lading_no_item+"' and a.BILL_NOTICE_NO='"+bill_notice_no+"' ";
				Map<String, Object> planStatus=systemService.findOneForJdbc(queryFYJHSql);
				System.out.println("planStatus:"+planStatus.values().toString());
				if(planStatus.values().toString()=="[00]"||planStatus.values().toString()=="[35]"){
					message="该计划已经强制结案或者终结，请联系贸易公司"	;
					j.setMsg(message);
					//j.setSuccess(false); 
					return j;
				}
				//新建出库单主表实体，手工用前台传来的数据给实体每一个属性赋值
				T_ZGK_PIPE_CKMEntity pipe =new T_ZGK_PIPE_CKMEntity();
				
				//System.out.println("setChukudanid:"+pipe.getChukudanid());
				String riqi=dataObj.getString("riqi");					
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		        Date dateriqi=dateFormat.parse(riqi);
		        System.out.println("rec_add:"+dataObj.getString("rec_add"));
		        pipe.setRiqi(dateriqi);
		        String store_name=dataObj.getString("store_name");
		        String store_seq=store_name.substring(6,7);
		        System.out.println("store_seq:"+store_seq);
		        String chukudanid=dataObj.getString("chukudanid");
		        String start=chukudanid.substring(0,8);//20170429Y1001
		        String end=chukudanid.substring(10,13);
		        System.out.println("start:"+start);
		        System.out.println("end:"+end);
		        if(store_seq.equals("一")){
		        	 pipe.setStoreName(dataObj.getString("store_name"));
		        	 String mychukudanid=start+"Y1"+end;
		        	 String checkSql="select count(*) from t_zgk_pipe_ckm where chukudanid='"+mychukudanid+"'";
					 long count=systemService.getCountForJdbc(checkSql);
					 System.out.println("count："+count);
					 if(count>=1){
						 	String msg="opps,出库单编号已经存在，请修改出库单号！！！'"+mychukudanid+"'";
						 	 System.out.println("msg："+msg);
						    message=msg;
						    System.out.println("message："+message);
							j.setMsg(message);
						//	j.setSuccess(false); 
							System.out.println("jjjjjjjjjj："+j.getMsg());
							return j;
					 }
		        	 chukudanid=start+"Y1"+end;
		        	 pipe.setChukudanid(start+"Y1"+end);		        	 
		        	 System.out.println("chukudanid:"+pipe.getChukudanid());
		        	 
		        	 
		        }else if(store_seq.equals("二")){
		        	pipe.setStoreName(dataObj.getString("store_name"));
		        	 chukudanid=start+"Y2"+end;
		        	 pipe.setChukudanid(start+"Y2"+end);
		        	 System.out.println("chukudanid:"+pipe.getChukudanid());
		        }else{
		        	pipe.setStoreName(dataObj.getString("store_name"));
		        	 chukudanid=start+"Y3"+end;
		        	 pipe.setChukudanid(start+"Y3"+end);
		        }
		        System.out.println("baoguanyan:"+dataObj.getString("baoguanyuan"));
		        pipe.setBaoguanyuan(dataObj.getString("baoguanyuan"));
		        pipe.setSendCarNo(dataObj.getString("send_car_no"));
		        pipe.setBillNoticeNo(dataObj.getString("bill_notice_no"));
		        pipe.setCarryCompanyCode(dataObj.getString("carry_company_code"));
		        pipe.setCarryCompanyName(dataObj.getString("carry_company_name"));
				pipe.setTrnpMode(dataObj.getString("trnp_mode"));
				pipe.setCarNo(dataObj.getString("car_no"));
				pipe.setDriverName(dataObj.getString("driver_name"));
				pipe.setDriverTel(dataObj.getString("driver_tel"));
				pipe.setIdNumber(dataObj.getString("id_number"));
				pipe.setOrgName(dataObj.getString("org_name"));
				pipe.setConsignCname(dataObj.getString("consign_cname"));
				pipe.setDelivyPlaceName(dataObj.getString("rec_add"));				
				pipe.setId(dataObj.getString("id"));
				pipe.setPrivateRouteName(dataObj.getString("bill_lading_no_item"));
				//pipe.setb(dataObj.getString("bill_lading_no_item"));
				pipe.setBillLadingNoItem(dataObj.getString("bill_lading_no_item"));
				pipe.setReadFlag("0");
				pipe.setShbz("0");
		        t_ZGK_PIPE_CKMService.save(pipe);
				
				for(int i=0;i<dataArr.size();i++){
					System.out.println("前台传来json数据条数："+dataArr.size());
					 dataObj = dataArr.getJSONObject(i);
					 System.out.println("保存第几条数据条数："+i);
					 //监测管子重号了没有，如果充好，前台提醒用户修改管号
					 String dn=dataObj.getString("dn");
					 String batchFull=dataObj.getString("batch_full");
					 String pipe_serial=dataObj.getString("pipe_serial");
					 String checkSql="select count(*) from t_zgk_pipe_ckd where pipe_serial='"+pipe_serial+"' and batch_full='"+batchFull+"' and dn='"+dn+"' and chukudanid='"+chukudanid+"'";
					 long count=systemService.getCountForJdbc(checkSql);
				//	system.out
					 if(count>=1){
						 	String msg="管序号：'"+pipe_serial+"'"+";"+"批号：'"+batchFull+"'"+";"+"规格：'"+dn+"'"+";"+";"+"出库单编号：'"+chukudanid+"'"+";"+"所组成的管号已经在该单子里存在，请修改管号后再提交！";
						    message=msg;
							j.setMsg(message);
						//	j.setSuccess(false); 
							return j;
					 }
					//保存出库子表信息
					T_ZGK_PIPE_CKDEntity pd =new T_ZGK_PIPE_CKDEntity();		
					
			        pd.setChukudanid(chukudanid);	
			        System.out.println("chukudanid:"+chukudanid);
					pd.setDn(dataObj.getString("dn"));
					System.out.println("expFlag:"+dataObj.getString("expFlag"));
					pd.setExpFlag(dataObj.getString("expFlag"));
					pd.setSpecialDesc(dataObj.getString("specialDesc"));
					pd.setBatchFull(dataObj.getString("batch_full"));
					pd.setPipeSerial(dataObj.getString("pipe_serial"));
					pd.setPackageid(dataObj.getString("packageid"));
					pd.setProductPlanNo(dataObj.getString("product_plan_no"));
					pd.setItemCode(dataObj.getString("item_code"));
					pd.setItemCname(dataObj.getString("item_cname"));
					//pd.setExpFlag("");
					pd.setSpecialDesc(dataObj.getString("special_desc"));															
					String pipenum=dataObj.getString("pipenum");
					System.out.println("pipenum:"+pipenum);	
					if(StringUtil.equals(pipenum, "null")){
						pd.setPipenum(0);
						
					}else
					{			
						pd.setPipenum(Integer.parseInt(dataObj.getString("pipenum")));
					}
					
					String cengci=dataObj.getString("cengci");
					System.out.println("cengci:"+cengci);	
					if(cengci!=null&& !"null".equals(cengci)){
						pd.setCengci(Integer.parseInt(dataObj.getString("cengci")));
						
					}else
					{
						pd.setCengci(0);
					}
					String cengneixuhao=dataObj.getString("cengneixuhao");
					System.out.println("cengneixuhao:"+cengneixuhao);	
					if(cengneixuhao!=null&& !"null".equals(cengneixuhao)){
						pd.setCengneixuhao(Integer.parseInt(dataObj.getString("cengneixuhao")));
						
					}else
					{
						pd.setCengneixuhao(0);
					}
					//pd.setSuitWay(dataObj.getString("suit_way"));
					pd.setHuowei(dataObj.getString("huowei"));
					//pd.setCengci(dataObj.getInt("cengci"));
					//pd.setCengneixuhao(dataObj.getInt("cengneixuhao"));
					pd.setProductLine(dataObj.getString("product_line"));
					pd.setBillLadingNoItem(dataObj.getString("bill_lading_no_item"));
					//pd.setId(dataObj.getString("id"));
					
					
				t_ZGK_PIPE_CKDService.save(pd);	
					j.setMsg("恭喜，操作成功");
					
				}
			}else{
				message="参数错误！请检查参数信息";
			}
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			j.setMsg(message);
		}catch (Exception e) {
			e.printStackTrace();
			message="添加失败，"+e;
		}
		return j;
	}
	
	@RequestMapping(params = "sureConceal")
	@ResponseBody
	public AjaxJson sureConceal(HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
				String chukudanid=request.getParameter("chukudanid");
				
				T_ZGK_PIPE_CKMEntity ckm =t_ZGK_PIPE_CKMService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class,"chukudanid", chukudanid);
				System.out.println("BillNoticeNo:"+ckm.getBillNoticeNo());
				System.out.println("ReadFla:"+ckm.getReadFlag());		
				if(ckm.getReadFlag().equals("1") || ckm.getReadFlag().equals("2") ){
					ckm.setReadFlag("0");
					ckm.setShbz("0");
																
			}
				t_ZGK_PIPE_CKMService.saveOrUpdate(ckm);										
				j.setMsg("恭喜您，红冲确认成功，请作废响应的出库单，重新做出库单！！！！");
		}catch (Exception e) {
			e.printStackTrace();
			
			j.setMsg("系统繁忙，稍后再试！");
			
		}
		return j;
	}
	/**
	 * 出库单主表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_CKMEntity t_ZGK_PIPE_CKM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CKM.getId())) {
			t_ZGK_PIPE_CKM = t_ZGK_PIPE_CKMService.getEntity(T_ZGK_PIPE_CKMEntity.class, t_ZGK_PIPE_CKM.getId());
			req.setAttribute("t_ZGK_PIPE_CKMPage", t_ZGK_PIPE_CKM);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckm/t_ZGK_PIPE_CKM");
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_CKMEntity> list() {
		List<T_ZGK_PIPE_CKMEntity> listT_ZGK_PIPE_CKMs=t_ZGK_PIPE_CKMService.getList(T_ZGK_PIPE_CKMEntity.class);
		return listT_ZGK_PIPE_CKMs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_CKMEntity task = t_ZGK_PIPE_CKMService.get(T_ZGK_PIPE_CKMEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_CKMEntity t_ZGK_PIPE_CKM, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CKMEntity>> failures = validator.validate(t_ZGK_PIPE_CKM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CKMService.save(t_ZGK_PIPE_CKM);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_CKM.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_CKMController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_CKMEntity t_ZGK_PIPE_CKM) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CKMEntity>> failures = validator.validate(t_ZGK_PIPE_CKM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CKMService.saveOrUpdate(t_ZGK_PIPE_CKM);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_CKMService.deleteEntityById(T_ZGK_PIPE_CKMEntity.class, id);
	}
}
