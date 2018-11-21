package com.yangjiang.controller.t_zgk_pipe_tkm;
import java.util.HashMap;
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
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zgk_pipe_ckm.T_ZGK_PIPE_CKMEntity;
import com.yangjiang.entity.t_zgk_pipe_tkm.T_ZGK_PIPE_TKMEntity;
import com.yangjiang.service.t_zgk_pipe_tkm.T_ZGK_PIPE_TKMServiceI;

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
 * @Description: 退库主表
 * @author zhangdaihao
 * @date 2016-11-25 17:58:12
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_TKMController")
public class T_ZGK_PIPE_TKMController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_TKMController.class);

	@Autowired
	private T_ZGK_PIPE_TKMServiceI t_ZGK_PIPE_TKMService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(params = "tkViewPrint")
	public ModelAndView tkViewPrint(T_ZGK_PIPE_TKMEntity t_zg_pipe_tkm,HttpServletRequest request){	
		if(StringUtil.isNotEmpty(t_zg_pipe_tkm.getTuikudanid())){
			t_zg_pipe_tkm = t_ZGK_PIPE_TKMService.findUniqueByProperty(T_ZGK_PIPE_TKMEntity.class, "tuikudanid", t_zg_pipe_tkm.getTuikudanid());
			request.setAttribute("t_zg_pipe_tkm", t_zg_pipe_tkm);
			String sql ="select a.tuikudanid,c.ZN_THICK_DESC,a.riqi,a.store_name,a.consignee,b.packageid,a.baoguanyuan,b.huowei,b.cengci,b.cengneixuhao,b.pipe_serial,b.dn,b.exp_flag,b.special_desc,b.pipenum,b.batch_full,c.PROD_GRADE_DESC,c.INTERFACE_DESC,c.OUTER_COATING_DESC,c.INNER_LINING_DESC from T_ZGK_PIPE_TKM a inner join T_ZGK_PIPE_TKD b on a.tuikudanid=b.tuikudanid INNER JOIN V_MYBM_CPBM c ON b.item_code = c.ITEM_CODE where a.tuikudanid=?";
			System.out.println("getChukudanid:"+t_zg_pipe_tkm.getTuikudanid());
			List<Map<String, Object>>  printData= t_ZGK_PIPE_TKMService.findForJdbc(sql,t_zg_pipe_tkm.getTuikudanid());
			int rows =0;
			int total = printData.size();
			//String total_num=sum(pipe_num);
			String tuikudanid=t_zg_pipe_tkm.getTuikudanid();
			String sqlTotal="SELECT a.tuikudanid,sum(c.PIECE_WT*b.pipenum) as totalWeight,sum(b.pipenum) as totalPipeNum FROM T_ZGK_PIPE_TKM as a INNER JOIN T_ZGK_PIPE_TKD as b ON a.tuikudanid = b.tuikudanid INNER JOIN V_MYBM_CPBM as c ON b.item_code = c.ITEM_CODE  where a.tuikudanid= '"+tuikudanid+"'  group by a.tuikudanid" ;
			Map<String, Object> TotalData= t_ZGK_PIPE_TKMService.findOneForJdbc(sqlTotal);
			//
			request.setAttribute("TotalData", TotalData);
			request.setAttribute("rows", rows);
			request.setAttribute("total", total);
			request.setAttribute("printData", printData);			
			
			System.out.println("------------------------------------------------");
			System.out.println("printData:"+printData);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_tkm/tkViewPrint");
	}
	


	/**
	 * 退库主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_tkm/t_ZGK_PIPE_TKMList");
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
	public void datagrid(T_ZGK_PIPE_TKMEntity t_ZGK_PIPE_TKM,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_TKMEntity.class, dataGrid);
		//查询条件组装器
		//查询条件组装器  多字段排序  
		//Map<String,Object> map = new HashMap<String,Object>();  
		//map.put("riqi", "desc");  
		//cq.setOrder(map);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_TKM, request.getParameterMap());
		this.t_ZGK_PIPE_TKMService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除退库主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_TKMEntity t_ZGK_PIPE_TKM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_TKM = systemService.getEntity(T_ZGK_PIPE_TKMEntity.class, t_ZGK_PIPE_TKM.getId());
		message = "退库主表删除成功";
		t_ZGK_PIPE_TKMService.delete(t_ZGK_PIPE_TKM);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加退库主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_TKMEntity t_ZGK_PIPE_TKM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_TKM.getId())) {
			message = "退库主表更新成功";
			T_ZGK_PIPE_TKMEntity t = t_ZGK_PIPE_TKMService.get(T_ZGK_PIPE_TKMEntity.class, t_ZGK_PIPE_TKM.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_ZGK_PIPE_TKM, t);
				String storeName=t_ZGK_PIPE_TKM.getStoreName();
				t_ZGK_PIPE_TKMService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "退库主表更新失败";
			}
		} else {
			message = "退库主表添加成功";
			t_ZGK_PIPE_TKMService.save(t_ZGK_PIPE_TKM);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 退库主表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_TKMEntity t_ZGK_PIPE_TKM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_TKM.getId())) {
			t_ZGK_PIPE_TKM = t_ZGK_PIPE_TKMService.getEntity(T_ZGK_PIPE_TKMEntity.class, t_ZGK_PIPE_TKM.getId());
			req.setAttribute("t_ZGK_PIPE_TKMPage", t_ZGK_PIPE_TKM);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_tkm/t_ZGK_PIPE_TKM");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_TKMEntity> list() {
		List<T_ZGK_PIPE_TKMEntity> listT_ZGK_PIPE_TKMs=t_ZGK_PIPE_TKMService.getList(T_ZGK_PIPE_TKMEntity.class);
		return listT_ZGK_PIPE_TKMs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_TKMEntity task = t_ZGK_PIPE_TKMService.get(T_ZGK_PIPE_TKMEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_TKMEntity t_ZGK_PIPE_TKM, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_TKMEntity>> failures = validator.validate(t_ZGK_PIPE_TKM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_TKMService.save(t_ZGK_PIPE_TKM);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_TKM.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_TKMController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_TKMEntity t_ZGK_PIPE_TKM) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_TKMEntity>> failures = validator.validate(t_ZGK_PIPE_TKM);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_TKMService.saveOrUpdate(t_ZGK_PIPE_TKM);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_TKMService.deleteEntityById(T_ZGK_PIPE_TKMEntity.class, id);
	}
}
