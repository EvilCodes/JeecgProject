package com.yangjiang.controller.t_zgk_pipe_ck_hcz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
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

import com.yangjiang.asysuser.entity.AsysUserEntity;
import com.yangjiang.entity.t_myjk_scjh.T_MYJK_SCJHEntity;
import com.yangjiang.entity.t_zg_pipe_rk.T_zg_pipe_rkEntity;
import com.yangjiang.entity.t_zgk_fyjh_pcd.T_ZGK_FYJH_PCDEntity;
import com.yangjiang.entity.t_zgk_pipe_ck_hcz.T_ZGK_PIPE_CK_HCZEntity;
import com.yangjiang.entity.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMEntity;
import com.yangjiang.service.t_zgk_pipe_ck_hcz.T_ZGK_PIPE_CK_HCZServiceI;

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
 * @Description: 火车装车
 * @author zhangdaihao
 * @date 2017-02-24 14:58:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_CK_HCZController")
public class T_ZGK_PIPE_CK_HCZController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_CK_HCZController.class);

	@Autowired
	private T_ZGK_PIPE_CK_HCZServiceI t_ZGK_PIPE_CK_HCZService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(params = "enTruck")
	public ModelAndView enTruck(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ,HttpServletRequest request){	
		request.setAttribute("sendNo", request.getParameter("sendNo"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_hckd/t_ZGK_PIPE_HCKD");
	}
	
	@RequestMapping(params = "ckViewPrint")
	public ModelAndView ckViewPrint(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ,HttpServletRequest request){	
		if(StringUtil.isNotEmpty(t_ZGK_PIPE_CK_HCZ.getSendNo())){
			t_ZGK_PIPE_CK_HCZ = t_ZGK_PIPE_CK_HCZService.findUniqueByProperty(T_ZGK_PIPE_CK_HCZEntity.class, "sendNo", t_ZGK_PIPE_CK_HCZ.getSendNo());
			request.setAttribute("t_ZGK_PIPE_CK_HCZ", t_ZGK_PIPE_CK_HCZ);
			//String sql ="select * from T_ZGK_PIPE_CK_HCZ a inner join T_ZGK_PIPE_HCKD b on a.SEND_NO=b.chukudanid "+
			//			"inner join V_MYBM_CPBM c on b.item_code=c.ITEM_CODE where a.SEND_NO= ?";
			String sql ="select a.SEND_NO   ,a.BILL_NOTICE_NO,a.riqi,a.baoguanyuan,a.OUT_WHOUSE_NAME,a.BLOCK_NO,a.consign_cname,a.org_name,a.delivy_place_name, " +
					"b.dn,b.batch_full,b.exp_flag,c.PROD_GRADE_DESC,c.INTERFACE_DESC,c.ZN_THICK_DESC,c.OUTER_COATING_DESC,"+
 "c.INNER_LINING_DESC,b.special_desc,c.LENGTH_DESC,"+
"sum(b.pipenum) as pipenum from T_ZGK_PIPE_CK_HCZ a inner join T_ZGK_PIPE_HCKD b on a.SEND_NO=b.chukudanid "+					
"inner join V_MYBM_CPBM c on b.item_code=c.ITEM_CODE where a.SEND_NO= ?"+
" group by "+
"a.SEND_NO ,a.BILL_NOTICE_NO,a.riqi,a.baoguanyuan,a.OUT_WHOUSE_NAME,a.BLOCK_NO,a.consign_cname,a.org_name,a.delivy_place_name,"+
 "b.dn,b.batch_full,b.exp_flag,c.PROD_GRADE_DESC,c.INTERFACE_DESC,c.ZN_THICK_DESC,c.OUTER_COATING_DESC,"+
 "c.INNER_LINING_DESC,b.special_desc,c.LENGTH_DESC";
 			List<Map<String, Object>>  printData= t_ZGK_PIPE_CK_HCZService.findForJdbc(sql, 	t_ZGK_PIPE_CK_HCZ.getSendNo());
			String sendNo=t_ZGK_PIPE_CK_HCZ.getSendNo();
			System.out.println("sendNo:"+sendNo);
			String sqlTotal="select sum(b.pipenum) as totalNum,sum(b.pipenum*c.PIECE_WT) as totalWeight "+
							"from T_ZGK_PIPE_CK_HCZ a inner join T_ZGK_PIPE_HCKD b on a.SEND_NO=b.chukudanid inner join V_MYBM_CPBM c on b.item_code=c.ITEM_CODE where a.SEND_NO= '"+sendNo+"'" ;
			Map<String, Object> TotalData= t_ZGK_PIPE_CK_HCZService.findOneForJdbc(sqlTotal);
			//
			request.setAttribute("TotalData", TotalData);
			int rows =0;
			int total = printData.size();
			if(total>0){
				rows = (int)Math.ceil(total/3d);
			}
			request.setAttribute("rows", rows);
			request.setAttribute("total", total);
			request.setAttribute("printData", printData);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ck_hcz/ckViewPrint");
	}
	/**
	 * 火车装车列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ck_hcz/t_ZGK_PIPE_CK_HCZList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_CK_HCZEntity.class, dataGrid);
		//查询条件组装器
		String delivyPlaceName=t_ZGK_PIPE_CK_HCZ.getDelivyPlaceName();
		if(StringUtil.isNotEmpty(delivyPlaceName)){
			cq.eq("delivyPlaceName", delivyPlaceName);
		}
		String orgName=t_ZGK_PIPE_CK_HCZ.getOrgName();
		if(StringUtil.isNotEmpty(orgName)){
			cq.eq("orgName", orgName);
		}
		String blockNo=t_ZGK_PIPE_CK_HCZ.getBlockNo();		
		if(StringUtil.isNotEmpty(blockNo)){
			cq.eq("blockNo", blockNo);
		}
		if(t_ZGK_PIPE_CK_HCZ.getSendTime()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("sendTime", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_ZGK_PIPE_CK_HCZ.getSendTime();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("sendTime", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_CK_HCZ, request.getParameterMap());
		cq.add();
		this.t_ZGK_PIPE_CK_HCZService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除火车装车
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_CK_HCZ = systemService.getEntity(T_ZGK_PIPE_CK_HCZEntity.class, t_ZGK_PIPE_CK_HCZ.getId());
		message = "火车装车删除成功";
		if(t_ZGK_PIPE_CK_HCZ.getReadFlag()=="1"){
			j.setMsg("该条信息已经抛送给贸易公司，不能删除，请联系管理员！！！！");
			return j;
		}else if(t_ZGK_PIPE_CK_HCZ.getShbz()=="1"){
			j.setMsg("该条信息已经审核通过，不能删除，请联系管理员！！！！");
			return j;
		}else{
		t_ZGK_PIPE_CK_HCZService.delete(t_ZGK_PIPE_CK_HCZ);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
		}
	}
	/**
	 * 批量审核操作
	 * @param ids
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doCheck")
	@ResponseBody
	public AjaxJson doCheck(String ids,HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{
			j.setMsg("恭喜，操作成功");
			String[] idsAttr = ids.split(",");
			for(int i=0;i<idsAttr.length;i++){
				T_ZGK_PIPE_CK_HCZEntity myjk_SCJH =t_ZGK_PIPE_CK_HCZService.get(T_ZGK_PIPE_CK_HCZEntity.class, idsAttr[i]);
				if(myjk_SCJH.getReadFlag()=="1" ){
					j.setMsg("该条信息已经抛送给贸易公司，不能再审，请联系管理员修改！！！！");
					return j;
				}else if(myjk_SCJH.getShbz()=="1"){
					j.setMsg("该条信息已经审核通过，无需再审，请联系管理员修改！！！！");
					return j;
				}else{
				myjk_SCJH.setShsj(new Date());
				myjk_SCJH.setShbz("1");
				String edituser=ResourceUtil.getSessionUserName().getUserName();
				myjk_SCJH.setShr(edituser);
				}
				
				t_ZGK_PIPE_CK_HCZService.saveOrUpdate(myjk_SCJH);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doCheck>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	
	@RequestMapping(params="sureConceal")
	@ResponseBody
	public AjaxJson sureConceal(HttpServletRequest request){ 
		AjaxJson j = new AjaxJson();
		try{	j.setMsg("恭喜，操作成功");
				String chukudanid=request.getParameter("chukudanid");
				String hc=chukudanid.substring(9, 10);
				if(!hc.equals("T")){
					j.setMsg("请确认您选择出库单号是火车出库单号，系统判断该单号不是货车出库单号");
					return j;
				}else{
				T_ZGK_PIPE_CK_HCZEntity hcz =t_ZGK_PIPE_CK_HCZService.findUniqueByProperty(T_ZGK_PIPE_CK_HCZEntity.class,"sendNo", chukudanid);
				if(hcz.getReadFlag().equals("1")|| hcz.getReadFlag().equals("2")){
					hcz.setReadFlag("0");
					hcz.setShbz("0");
				}
				
				t_ZGK_PIPE_CK_HCZService.saveOrUpdate(hcz);
				j.setMsg("恭喜您，红冲确认成功，请作废响应的出库单，重新做出库单！！！！");
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
				
				T_ZGK_PIPE_CK_HCZEntity myjk_SCJH =t_ZGK_PIPE_CK_HCZService.get(T_ZGK_PIPE_CK_HCZEntity.class, idsAttr[i]);
				if(myjk_SCJH.getPlanNum()<=0 || myjk_SCJH.getBlockNo()==null){
					j.setMsg("该条信息"+myjk_SCJH.getSendNo()+"不符合规范，请检查支数或者车号！！！！");
					return j;
				}
				if(myjk_SCJH.getReadFlag().equals("1")||myjk_SCJH.getReadFlag().equals("2")){
					j.setMsg("该条信息已经抛送给贸易公司，不能废除，请联系管理员修改！！！！");
					return j;
				}
				//else if(myjk_SCJH.getShbz().equals("1")){
				//myjk_SCJH.setShsj(new Date());
				///myjk_SCJH.setShbz("0");
				//String edituser=ResourceUtil.getSessionUserName().getUserName();
				//myjk_SCJH.setShr(edituser);
				//t_ZGK_PIPE_CK_HCZService.saveOrUpdate(myjk_SCJH);
				//}
				else 
				{
					t_ZGK_PIPE_CK_HCZService.delete(myjk_SCJH);
				   j.setMsg("作废成功");
				   return j;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doTrash>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "恭喜，修改成功！";
		try{
			t_ZGK_PIPE_CK_HCZService.save(t_ZGK_PIPE_CK_HCZ);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "大系统用户信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 添加火车装车
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		try{
			String jsondata=request.getParameter("data");	
			if(StringUtil.isNotEmpty(jsondata)){
																			
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);
				System.out.println("dataArr.size():"+dataArr.size());
				for(int i=0;i<dataArr.size();i++){
					//生成火车装车单号：生成规则--》年月日+YT+顺序号;	
					Date d=new Date();
					String seqDate=DateUtils.formatDate(d,"yyyyMMdd").toString();
					java.sql.Date edttime=new java.sql.Date(d.getTime());
					System.out.println("格式化后的日期："+DateUtils.formatDate(d,"yyyy-MM-dd"));																						
					String sql="select isnull(max(SUBSTRING(SEND_NO,12,14)),0)  from T_ZGK_PIPE_CK_HCZ a where substring(a.SEND_NO,1,8)='"+seqDate+"'";
					long total=systemService.getCountForJdbc(sql)+1;								
					System.out.println("total:"+total);
					String sequence="";
					if(StringUtil.isNotEmpty(total)){					
						if(total<10)
						{
							sequence="00"+total;
						}else if(total<100) 
						{
							sequence="0"+total;
						}
					}	System.out.println("sequence:"+sequence);
					JSONObject dataObj = dataArr.getJSONObject(i);
					T_ZGK_PIPE_CK_HCZEntity pcd = (T_ZGK_PIPE_CK_HCZEntity) JSONHelper.json2Object(dataObj.toString(), T_ZGK_PIPE_CK_HCZEntity.class);
					String storeName=pcd.getOutWhouseName();
					String storeNo=storeName.substring(6, 7);
					String store_seq="";
					if(storeNo.equals("一"))
					{
						store_seq="1";
					}else if(storeNo.equals("二")){
						store_seq="2";
					}else{
						store_seq="3";
					}
					pcd.setSendNo(seqDate+"YT"+store_seq+sequence);
					System.out.println("pcd:"+pcd.getSendNo());
					pcd.getBillNoticeNo();
					pcd.setSendTime(new Date());
					if(pcd.getPlanNum()==null){
						pcd.setPlanNum(dataObj.getInt("planNum"));
					}
					//pcd.setSendNo("20170226YT001");
						pcd.setPlanWt(dataObj.getDouble("planWt"));
					pcd.setRiqi(new Date());
					pcd.setReadFlag("0");
					t_ZGK_PIPE_CK_HCZService.save(pcd);
					message = "恭喜，修改成功！";
					
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

	/**
	 * 火车装车列表页面跳转
	 * 
	 * @return t_ZGK_PIPE_KC_HCZ_HC
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CK_HCZ.getId())) {
			t_ZGK_PIPE_CK_HCZ = t_ZGK_PIPE_CK_HCZService.getEntity(T_ZGK_PIPE_CK_HCZEntity.class, t_ZGK_PIPE_CK_HCZ.getId());
			req.setAttribute("t_ZGK_PIPE_CK_HCZPage", t_ZGK_PIPE_CK_HCZ);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ck_hcz/t_ZGK_PIPE_CK_HCZ");
	}
	/**
	 * 火车装车列表页面跳转
	 * 
	 * @return t_ZGK_PIPE_KC_HCZ_HC
	 */
	@RequestMapping(params = "update")
	public ModelAndView update(T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CK_HCZ.getId())) {
			t_ZGK_PIPE_CK_HCZ = t_ZGK_PIPE_CK_HCZService.getEntity(T_ZGK_PIPE_CK_HCZEntity.class, t_ZGK_PIPE_CK_HCZ.getId());
			req.setAttribute("t_ZGK_PIPE_CK_HCZPage", t_ZGK_PIPE_CK_HCZ);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ck_hcz/t_ZGK_PIPE_KC_HCZ_HC");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_CK_HCZEntity> list() {
		List<T_ZGK_PIPE_CK_HCZEntity> listT_ZGK_PIPE_CK_HCZs=t_ZGK_PIPE_CK_HCZService.getList(T_ZGK_PIPE_CK_HCZEntity.class);
		return listT_ZGK_PIPE_CK_HCZs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_CK_HCZEntity task = t_ZGK_PIPE_CK_HCZService.get(T_ZGK_PIPE_CK_HCZEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CK_HCZEntity>> failures = validator.validate(t_ZGK_PIPE_CK_HCZ);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CK_HCZService.save(t_ZGK_PIPE_CK_HCZ);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_CK_HCZ.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_CK_HCZController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_CK_HCZEntity t_ZGK_PIPE_CK_HCZ) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CK_HCZEntity>> failures = validator.validate(t_ZGK_PIPE_CK_HCZ);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CK_HCZService.saveOrUpdate(t_ZGK_PIPE_CK_HCZ);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_CK_HCZService.deleteEntityById(T_ZGK_PIPE_CK_HCZEntity.class, id);
	}
}
