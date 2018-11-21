package com.yangjiang.controller.t_zgk_pipe_ckd;
import java.util.List;

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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zgk_pipe_ckd.T_ZGK_PIPE_CKDEntity;
import com.yangjiang.entity.t_zgk_pipe_ckd_jq.T_ZGK_PIPE_CKD_JQEntity;
import com.yangjiang.entity.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMEntity;
import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.service.t_zgk_pipe_ckd.T_ZGK_PIPE_CKDServiceI;

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
 * @date 2016-10-31 09:09:24
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_CKDController")
public class T_ZGK_PIPE_CKDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_CKDController.class);

	@Autowired
	private T_ZGK_PIPE_CKDServiceI t_ZGK_PIPE_CKDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 出库单主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd/t_ZGK_PIPE_CKDList");
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
	public void datagrid(T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_CKDEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_CKD, request.getParameterMap());
		this.t_ZGK_PIPE_CKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除出库单主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_CKD = systemService.getEntity(T_ZGK_PIPE_CKDEntity.class, t_ZGK_PIPE_CKD.getId());
		message = "出库单主表删除成功";
		t_ZGK_PIPE_CKDService.delete(t_ZGK_PIPE_CKD);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}
	/**
	 * 批量删除大系统用户信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
	//	System.out.print( "*************11,"+request.getParameter("ids"));
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "恭喜恭喜！！！删除出库管号成功。";
		try {
			//for (String id : request.getParameter("ids").split(",")) {
				T_ZGK_PIPE_CKDEntity rkd = systemService.getEntity(
						T_ZGK_PIPE_CKDEntity.class, request.getParameter("ids"));
				//String pipecode = rkd.getPipeCode();
				String dn = rkd.getDn();
				String batchfull = rkd.getBatchFull();
				String pipeSerial = rkd.getPipeSerial();
			//	String chukudanid= rkd.getChukudanid();
				T_ZGK_PIPE_CKMEntity jq=systemService.findUniqueByProperty(T_ZGK_PIPE_CKMEntity.class,"chukudanid",rkd.getChukudanid());
				if(jq.getReadFlag().equals("1") || jq.getReadFlag().equals("2") ){
					j.setMsg("该条信息已经抛送给贸易公司，不能作废，请联系管理员修改！！！！");
					return j;
				}
				else if(jq.getShbz() !=null && jq.getShbz().equals("1")){
					j.setMsg("该条信息已经审核通过，不能作废，请联系管理员修改！！！！");
					return j;
				}
				else{
				String existSql = "select count(1) from T_ZGK_PIPE_KC where dn= '"
						+ dn
						+ "' and batch_full='"
						+ batchfull
						+ "' and pipe_serial='" + pipeSerial + "'";
				long num = systemService.getCountForJdbc(existSql);
				if (num > 0) {
					message = "不好意思，这支管材库里已存在，所以不能删除这条信息";
					j.setMsg(message);
					return j;
				}
				System.out.print( "*************"+ids);
				t_ZGK_PIPE_CKDService.deleteEntityById(
						T_ZGK_PIPE_CKDEntity.class, request.getParameter("ids"));
				// t_ZGK_PIPE_RKDService.delete(rkd);
				systemService.addLog(message+","+rkd.getChukudanid()+","+rkd.getDn()+rkd.getBatchFull()+"-"+rkd.getPipeSerial(), Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();
			message = "大系统用户信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
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
	public AjaxJson save(T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CKD.getId())) {
			message = "出库单主表更新成功";
			T_ZGK_PIPE_CKDEntity t = t_ZGK_PIPE_CKDService.get(T_ZGK_PIPE_CKDEntity.class, t_ZGK_PIPE_CKD.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_ZGK_PIPE_CKD, t);
				t_ZGK_PIPE_CKDService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "出库单主表更新失败";
			}
		} else {
			message = "出库单主表添加成功";
			t_ZGK_PIPE_CKDService.save(t_ZGK_PIPE_CKD);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 出库单主表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CKD.getId())) {
			t_ZGK_PIPE_CKD = t_ZGK_PIPE_CKDService.getEntity(T_ZGK_PIPE_CKDEntity.class, t_ZGK_PIPE_CKD.getId());
			req.setAttribute("t_ZGK_PIPE_CKDPage", t_ZGK_PIPE_CKD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd/t_ZGK_PIPE_CKD");
	}
	@RequestMapping(params = "addorupdate2")
	public ModelAndView addorupdate2(T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_CKD.getId())) {
			t_ZGK_PIPE_CKD = t_ZGK_PIPE_CKDService.getEntity(
					T_ZGK_PIPE_RKDEntity.class, t_ZGK_PIPE_CKD.getId());
			req.setAttribute("t_ZGK_PIPE_CKDPage", t_ZGK_PIPE_CKD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd/t_ZGK_PIPE_CKD2");
	}
	
	/**
	 * 手工添加出库管号页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate3")
	public ModelAndView addorupdate3(
			HttpServletRequest req) {
		//if (StringUtil.isNotEmpty(t_ZGK_PIPE_CKD.getId())) {
		//	t_ZGK_PIPE_CKD = t_ZGK_PIPE_CKDService.getEntity(
			//		T_ZGK_PIPE_CKDEntity.class, t_ZGK_PIPE_CKD.getId());
		//	req.setAttribute("t_ZGK_PIPE_CKDPage", t_ZGK_PIPE_CKD);
		//}
		req.setAttribute("chukudanid", req.getParameter("chukudanid"));
		return new ModelAndView("com/yangjiang/t_zgk_pipe_ckd/t_ZGK_PIPE_CKD3");
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
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_CKDEntity> list() {
		List<T_ZGK_PIPE_CKDEntity> listT_ZGK_PIPE_CKDs=t_ZGK_PIPE_CKDService.getList(T_ZGK_PIPE_CKDEntity.class);
		return listT_ZGK_PIPE_CKDs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_CKDEntity task = t_ZGK_PIPE_CKDService.get(T_ZGK_PIPE_CKDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CKDEntity>> failures = validator.validate(t_ZGK_PIPE_CKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CKDService.save(t_ZGK_PIPE_CKD);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_CKD.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_CKDController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_CKDEntity t_ZGK_PIPE_CKD) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_CKDEntity>> failures = validator.validate(t_ZGK_PIPE_CKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_CKDService.saveOrUpdate(t_ZGK_PIPE_CKD);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_CKDService.deleteEntityById(T_ZGK_PIPE_CKDEntity.class, id);
	}
}
