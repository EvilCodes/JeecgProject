package com.yangjiang.controller.t_zg_pipe_rk;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.entity.t_zg_pipe_rk.T_zg_pipe_rkEntity;
import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.service.t_zg_pipe.T_ZG_PIPEServiceI;
import com.yangjiang.service.t_zg_pipe_rk.T_zg_pipe_rkServiceI;

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
 * @Description: 铸管部入库
 * @author zhangdaihao
 * @date 2016-10-13 17:27:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_zg_pipe_rkController")
public class T_zg_pipe_rkController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_zg_pipe_rkController.class);

	@Autowired
	private T_zg_pipe_rkServiceI t_zg_pipe_rkService;
	@Autowired
	private T_ZG_PIPEServiceI t_zg_pipeService;
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private Validator validator;
	
	/**
	 * 批量删除交库管号
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "恭喜恭喜！！！删除入库管号成功。";
		try{
			for(String id:ids.split(",")){						
				t_zg_pipeService.deleteEntityById(T_ZG_PIPEEntity.class, id);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除入库管号失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	
	@RequestMapping(params = "toPreViewPrint")
	public ModelAndView toPreViewPrint(T_zg_pipe_rkEntity t_zg_pipe_rk,HttpServletRequest request){	
		if(StringUtil.isNotEmpty(t_zg_pipe_rk.getRukudanid())){
			t_zg_pipe_rk = t_zg_pipe_rkService.findUniqueByProperty(T_zg_pipe_rkEntity.class, "rukudanid", t_zg_pipe_rk.getRukudanid());
			request.setAttribute("t_zg_pipe_rk", t_zg_pipe_rk);
			String sql ="select a.baoguanyuan,b.pipe_serial,b.pipenum,b.packageid,b.qrcode,a.yunshuren,b.batch_full,a.rukudanid,c.LENGTH_DESC,a.store_name,a.riqi,a.che,a.jianyanyuan,b.dn,b.item_code,b.special_desc,b.pipe_code,"
					+" c.PROD_GRADE_DESC,c.INTERFACE_DESC,c.OUTER_COATING_DESC,c.INNER_LINING_DESC,b.exp_flag,b.product_line,c.PIECE_WT,c.ZN_THICK_DESC"
					+" from t_zg_pipe_rk a inner join T_ZG_PIPE b on a.rukudanid=b.main_ID"
					+" inner join V_MYBM_CPBM c on b.item_code=c.ITEM_CODE"
					+" where a.rukudanid=?";
 			List<Map<String, Object>>  printData= t_zg_pipe_rkService.findForJdbc(sql, 	t_zg_pipe_rk.getRukudanid());
			String rukudanid=t_zg_pipe_rk.getRukudanid();
			System.out.println("rukudanid:"+t_zg_pipe_rk.getRukudanid());
			String sqlTotal="SELECT a.rukudanid,sum(c.PIECE_WT*CONVERT(int,b.pipenum)) as totalWeight,sum(CONVERT(int,b.pipenum)) as totalPipeNum"+
							"  FROM t_zg_pipe_rk as a INNER JOIN T_ZG_PIPE as b ON a.rukudanid = b.main_ID INNER JOIN V_MYBM_CPBM as c ON b.item_code = c.ITEM_CODE  where a.rukudanid= '"+rukudanid+"'  group by a.rukudanid" ;
			Map<String, Object> TotalData= t_zg_pipe_rkService.findOneForJdbc(sqlTotal);
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
		return new ModelAndView("com/yangjiang/t_zg_pipe_rk/toPreViewPrint");
	}
	
	/**
	 * 铸管部入库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zg_pipe_rk/t_zg_pipe_rkList");
	}
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		request.setAttribute("rukudanid", request.getParameter("rukudanid"));
		return new ModelAndView("com/yangjiang/t_zg_pipe/t_ZG_PIPEList2");
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
	public void datagrid(T_zg_pipe_rkEntity t_zg_pipe_rk,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_zg_pipe_rkEntity.class, dataGrid);
		//查询条件组装器
		if(t_zg_pipe_rk.getRiqi()==null){
			String bTStr = DateUtils.getDataString(new SimpleDateFormat("yyyy-MM-dd"));
			String endStr = bTStr+" 23:59:59";
			cq.between("riqi", DateUtils.str2Date(bTStr+" 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")), DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}else{
			//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_MYJK_SCJH, request.getParameterMap());
			Date bT = t_zg_pipe_rk.getRiqi();
			String endStr= DateUtils.formatDate(bT, "yyyy-MM-dd");
			endStr = endStr+" 23:59:59";
			cq.between("riqi", bT, DateUtils.str2Date(endStr, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		}
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_zg_pipe_rk, request.getParameterMap());
		cq.add();
		this.t_zg_pipe_rkService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_ZG_PIPEEntity t_zg_pipe_rk,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZG_PIPEEntity.class, dataGrid);
		//查询条件组装器
		String rukudanid=t_zg_pipe_rk.getMainId();
		cq.eq("mainId", rukudanid);
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_zg_pipe_rk, request.getParameterMap());
		cq.add();
		this.t_zg_pipeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除铸管部入库
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_zg_pipe_rkEntity t_zg_pipe_rk, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_zg_pipe_rk = systemService.getEntity(T_zg_pipe_rkEntity.class, t_zg_pipe_rk.getId());
		message = "铸管部入库删除成功";
		t_zg_pipe_rkService.delete(t_zg_pipe_rk);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加铸管部入库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_zg_pipe_rkEntity t_zg_pipe_rk, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_zg_pipe_rk.getId())) {
			message = "铸管部入库更新成功";
			T_zg_pipe_rkEntity t = t_zg_pipe_rkService.get(T_zg_pipe_rkEntity.class, t_zg_pipe_rk.getId());
			System.out.println("getRukudanid:"+t.getRukudanid());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_zg_pipe_rk, t);
				t_zg_pipe_rkService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "铸管部入库更新失败";
			}
		} else {
			message = "铸管部入库添加成功";
			System.out.println("12123:"+t_zg_pipe_rk.getStoreName());
			t_zg_pipe_rk.setEdittime(new Date());
			String editip=IpUtil.getIpAddr(request);
			t_zg_pipe_rk.setEditip(editip);
			//这里可以拿真是姓名
			String edituser=ResourceUtil.getSessionUserName().getUserName();
			t_zg_pipe_rk.setEdituser(edituser);
			t_zg_pipe_rkService.save(t_zg_pipe_rk);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 铸管部入库列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_zg_pipe_rkEntity t_zg_pipe_rk, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_zg_pipe_rk.getId())) {
			t_zg_pipe_rk = t_zg_pipe_rkService.getEntity(T_zg_pipe_rkEntity.class, t_zg_pipe_rk.getId());
			req.setAttribute("t_zg_pipe_rkPage", t_zg_pipe_rk);
		}
		return new ModelAndView("com/yangjiang/t_zg_pipe_rk/t_zg_pipe_rk");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_zg_pipe_rkEntity> list() {
		List<T_zg_pipe_rkEntity> listT_zg_pipe_rks=t_zg_pipe_rkService.getList(T_zg_pipe_rkEntity.class);
		return listT_zg_pipe_rks;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_zg_pipe_rkEntity task = t_zg_pipe_rkService.get(T_zg_pipe_rkEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_zg_pipe_rkEntity t_zg_pipe_rk, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_zg_pipe_rkEntity>> failures = validator.validate(t_zg_pipe_rk);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_zg_pipe_rkService.save(t_zg_pipe_rk);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_zg_pipe_rk.getId();
		URI uri = uriBuilder.path("/rest/t_zg_pipe_rkController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_zg_pipe_rkEntity t_zg_pipe_rk) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_zg_pipe_rkEntity>> failures = validator.validate(t_zg_pipe_rk);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_zg_pipe_rkService.saveOrUpdate(t_zg_pipe_rk);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_zg_pipe_rkService.deleteEntityById(T_zg_pipe_rkEntity.class, id);
	}
}
