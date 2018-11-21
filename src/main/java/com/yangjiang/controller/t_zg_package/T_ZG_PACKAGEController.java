package com.yangjiang.controller.t_zg_package;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.batch.t_zg_batchEntity;
import com.yangjiang.entity.t_zg_package.T_ZG_PACKAGEEntity;
import com.yangjiang.entity.t_zg_package_detail.T_zg_package_detailEntity;
import com.yangjiang.entity.t_zgk_pipe_tkd.T_ZGK_PIPE_TKDEntity;
import com.yangjiang.service.t_zg_package.T_ZG_PACKAGEServiceI;
import com.yangjiang.service.t_zg_package_detail.T_zg_package_detailServiceI;

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
 * @Description: 二铸管打包
 * @author zhangdaihao
 * @date 2016-12-14 17:48:20
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZG_PACKAGEController")
public class T_ZG_PACKAGEController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZG_PACKAGEController.class);

	@Autowired
	private T_ZG_PACKAGEServiceI t_ZG_PACKAGEService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private T_zg_package_detailServiceI t_zg_package_detailServiceI;
	


	/**
	 * 二铸管打包列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		
		return new ModelAndView("com/yangjiang/t_zg_package/t_ZG_PACKAGEList");
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
	public void datagrid(T_ZG_PACKAGEEntity t_ZG_PACKAGE,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZG_PACKAGEEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZG_PACKAGE, request.getParameterMap());
		this.t_ZG_PACKAGEService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除二铸管打包
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZG_PACKAGEEntity t_ZG_PACKAGE, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZG_PACKAGE = systemService.getEntity(T_ZG_PACKAGEEntity.class, t_ZG_PACKAGE.getId());
		message = "二铸管打包删除成功";
		t_ZG_PACKAGEService.delete(t_ZG_PACKAGE);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加二铸管打包
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZG_PACKAGEEntity t_ZG_PACKAGE, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();		
		try{						
			String detailinfo=request.getParameter("data");
			System.out.println("detailinfo:"+detailinfo);
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(currentTime);
			if(StringUtil.isNotEmpty(detailinfo)){
				JSONArray dataArr=JSONHelper.toJSONArray(detailinfo);
					System.out.println("size:"+dataArr.size());
					//保存打包主表信息，设置属性	
					int size=dataArr.size();
					for(int i=0;i<dataArr.size();i++){
					JSONObject dataObj = dataArr.getJSONObject(i);
					System.out.println("batchfull:"+dataObj.getString("batchfull"));
					T_ZG_PACKAGEEntity pipe=new T_ZG_PACKAGEEntity();
					pipe.setPackid(dataObj.getString("packid"));
					System.out.println("第一个packid:"+i+"packid:"+dataObj.getString("packid"));
					pipe.setPipecode(dataObj.getString("pipecode"));
					pipe.setDn(dataObj.getString("dn"));
					pipe.setSpecial(dataObj.getString("special"));
					pipe.setBatchfull(dataObj.getString("batchfull"));
					pipe.setPipeserial(dataObj.getString("pipeserial"));
					pipe.setRemark(dataObj.getString("remark"));
					pipe.setItemname(dataObj.getString("itemname"));
					String editip=IpUtil.getIpAddr(request);
					pipe.setEditip(editip);
					//这里可以拿真是姓名
					String edituser=ResourceUtil.getSessionUserName().getUserName();
					pipe.setPipecount(dataObj.getInt("pipenum"));
					pipe.setCheckuser(edituser);
					pipe.setPackuser(edituser);										
					pipe.setJihuahao(dataObj.getString("productplanno"));					
					pipe.setItemcode(dataObj.getString("itemcode"));					
					pipe.setAddtime(currentTime);
					pipe.setOptime(currentTime);																							
					t_ZG_PACKAGEService.save(pipe);
					message="打包主表保存成功";
					//设置打包子表信息											
					//保存打包主表信息，设置属性										
					}
					
					//给管号预制表的标志位置位：标识为管号已经使用过了。
					//String pipecode=dataObj1.getString("pipecode");
					//t_zg_batchEntity tBatch=new t_zg_batchEntity();
					//String sql="update t_zg_batch_pipe set flag='120' where pipe_code='"+pipecode+"'";
					//systemService.executeSql(sql, 1);
					
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
	 * 二铸管打包列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZG_PACKAGEEntity t_ZG_PACKAGE, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZG_PACKAGE.getId())) {
			t_ZG_PACKAGE = t_ZG_PACKAGEService.getEntity(T_ZG_PACKAGEEntity.class, t_ZG_PACKAGE.getId());
			req.setAttribute("t_ZG_PACKAGEPage", t_ZG_PACKAGE);
		}
		return new ModelAndView("com/yangjiang/t_zg_package/t_ZG_PACKAGE");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZG_PACKAGEEntity> list() {
		List<T_ZG_PACKAGEEntity> listT_ZG_PACKAGEs=t_ZG_PACKAGEService.getList(T_ZG_PACKAGEEntity.class);
		return listT_ZG_PACKAGEs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZG_PACKAGEEntity task = t_ZG_PACKAGEService.get(T_ZG_PACKAGEEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZG_PACKAGEEntity t_ZG_PACKAGE, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZG_PACKAGEEntity>> failures = validator.validate(t_ZG_PACKAGE);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZG_PACKAGEService.save(t_ZG_PACKAGE);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZG_PACKAGE.getId();
		URI uri = uriBuilder.path("/rest/t_ZG_PACKAGEController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZG_PACKAGEEntity t_ZG_PACKAGE) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZG_PACKAGEEntity>> failures = validator.validate(t_ZG_PACKAGE);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZG_PACKAGEService.saveOrUpdate(t_ZG_PACKAGE);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZG_PACKAGEService.deleteEntityById(T_ZG_PACKAGEEntity.class, id);
	}
}
