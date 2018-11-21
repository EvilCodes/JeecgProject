package com.yangjiang.controller.t_zg_hy_gp;
import java.util.Date;
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
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zg_hy_gp.T_ZG_HY_GPEntity;
import com.yangjiang.entity.t_zgk_pipe_ck_hcz.T_ZGK_PIPE_CK_HCZEntity;
import com.yangjiang.service.t_zg_hy_gp.T_ZG_HY_GPServiceI;

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
 * @Description: 光谱数据
 * @author zhangdaihao
 * @date 2017-03-23 18:01:56
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZG_HY_GPController")
public class T_ZG_HY_GPController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZG_HY_GPController.class);

	@Autowired
	private T_ZG_HY_GPServiceI t_ZG_HY_GPService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 光谱数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zg_hy_gp/t_ZG_HY_GPList");
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
	public void datagrid(T_ZG_HY_GPEntity t_ZG_HY_GP,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZG_HY_GPEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZG_HY_GP, request.getParameterMap());
		this.t_ZG_HY_GPService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除光谱数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZG_HY_GPEntity t_ZG_HY_GP, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZG_HY_GP = systemService.getEntity(T_ZG_HY_GPEntity.class, t_ZG_HY_GP.getId());
		message = "光谱数据删除成功";
		t_ZG_HY_GPService.delete(t_ZG_HY_GP);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
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
				T_ZG_HY_GPEntity gp =t_ZG_HY_GPService.get(T_ZG_HY_GPEntity.class, idsAttr[i]);
				if(gp.getResult()!=null ){
					j.setMsg("该条数据已经判定过，你确定要重新判定吗");
					return j;
				}else{
					//判定逻辑
					java.math.BigDecimal c=gp.getC();
				}
				
				t_ZG_HY_GPService.saveOrUpdate(gp);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("URL::t_ZGK_PIPE_CK_HCZController.do?doCheck>>>>>error:"+e.toString());
			j.setMsg("系统繁忙，稍后再试！");
		}
		return j;
	}
	/**
	 * 添加光谱数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZG_HY_GPEntity t_ZG_HY_GP, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(t_ZG_HY_GP.getId())) {
			message = "光谱数据更新成功";
			T_ZG_HY_GPEntity t = t_ZG_HY_GPService.get(T_ZG_HY_GPEntity.class, t_ZG_HY_GP.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(t_ZG_HY_GP, t);
				t_ZG_HY_GPService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "光谱数据更新失败";
			}
		} else {
			message = "光谱数据添加成功";
			t_ZG_HY_GPService.save(t_ZG_HY_GP);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 光谱数据列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZG_HY_GPEntity t_ZG_HY_GP, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZG_HY_GP.getId())) {
			t_ZG_HY_GP = t_ZG_HY_GPService.getEntity(T_ZG_HY_GPEntity.class, t_ZG_HY_GP.getId());
			req.setAttribute("t_ZG_HY_GPPage", t_ZG_HY_GP);
		}
		return new ModelAndView("com/yangjiang/t_zg_hy_gp/t_ZG_HY_GP");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZG_HY_GPEntity> list() {
		List<T_ZG_HY_GPEntity> listT_ZG_HY_GPs=t_ZG_HY_GPService.getList(T_ZG_HY_GPEntity.class);
		return listT_ZG_HY_GPs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZG_HY_GPEntity task = t_ZG_HY_GPService.get(T_ZG_HY_GPEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZG_HY_GPEntity t_ZG_HY_GP, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZG_HY_GPEntity>> failures = validator.validate(t_ZG_HY_GP);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZG_HY_GPService.save(t_ZG_HY_GP);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZG_HY_GP.getId();
		URI uri = uriBuilder.path("/rest/t_ZG_HY_GPController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZG_HY_GPEntity t_ZG_HY_GP) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZG_HY_GPEntity>> failures = validator.validate(t_ZG_HY_GP);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZG_HY_GPService.saveOrUpdate(t_ZG_HY_GP);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZG_HY_GPService.deleteEntityById(T_ZG_HY_GPEntity.class, id);
	}
}
