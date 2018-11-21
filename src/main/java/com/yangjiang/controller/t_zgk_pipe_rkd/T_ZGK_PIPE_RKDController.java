package com.yangjiang.controller.t_zgk_pipe_rkd;

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
import org.jeecgframework.core.common.exception.BusinessException;
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

import com.yangjiang.asysuser.entity.AsysUserEntity;
import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.entity.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDEntity;
import com.yangjiang.entity.t_zgk_pipe_rkm.T_ZGK_PIPE_RKMEntity;
import com.yangjiang.service.t_zg_pipe.T_ZG_PIPEServiceI;
import com.yangjiang.service.t_zgk_pipe_rkd.T_ZGK_PIPE_RKDServiceI;
import com.yangjiang.service.t_zgk_pipe_rkm.T_ZGK_PIPE_RKMServiceI;

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
 * @Description: 管材入库详细信息
 * @author zhangdaihao
 * @date 2016-10-27 14:46:48
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_RKDController")
public class T_ZGK_PIPE_RKDController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(T_ZGK_PIPE_RKDController.class);

	@Autowired
	private T_ZGK_PIPE_RKDServiceI t_ZGK_PIPE_RKDService;

	@Autowired
	private SystemService systemService;
	@Autowired
	private T_ZG_PIPEServiceI zgPipeService;
	@Autowired
	private Validator validator;

	/**
	 * 管材入库详细信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		System.out.println("进入到list1---------------------------");
		return new ModelAndView(
				"com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKDList");
	}

	/**
	 * 管材入库详细信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		System.out.println("进入到list2---------------------------");
		return new ModelAndView(
				"com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKD3List");

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
	public void datagrid(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKDEntity.class,
				dataGrid);
		// 查询条件组装器
		System.out.println("进入到datagrid1--------------------------------");
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				t_ZGK_PIPE_RKD, request.getParameterMap());
		this.t_ZGK_PIPE_RKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "datagrid2")
	public void datagrid2(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_RKDEntity.class,
				dataGrid);
		// 查询条件组装器
		System.out.println("进入到datagrid2--------------------------------");
		String rukudanid = request.getParameter("rukudanid");
		System.out.println("rukudanid：" + rukudanid);
		cq.eq("rukudanid", rukudanid);
		cq.add();
		this.t_ZGK_PIPE_RKDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除管材入库详细信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_RKD = systemService.getEntity(T_ZGK_PIPE_RKDEntity.class,
				t_ZGK_PIPE_RKD.getId());
		message = "管材入库详细信息删除成功";
		t_ZGK_PIPE_RKDService.delete(t_ZGK_PIPE_RKD);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);

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
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "恭喜恭喜！！！删除入库管号成功。";
		try {
			for (String id : ids.split(",")) {
				T_ZGK_PIPE_RKDEntity rkd = systemService.getEntity(
						T_ZGK_PIPE_RKDEntity.class, id);
				String pipecode = rkd.getPipeCode();
				String dn = rkd.getDn();
				String batchfull = rkd.getBatchFull();
				String pipeSerial = rkd.getPipeSerial();
				String existSql = "select count(1) from T_ZGK_PIPE_KC where dn= '"
						+ dn
						+ "' and batch_full='"
						+ batchfull
						+ "' and pipe_serial='" + pipeSerial + "'";
				long num = systemService.getCountForJdbc(existSql);
				if (num < 1) {
					message = "不好意思，这支管材不在库里或者已经出库，所以不能删除这条信息";
					j.setMsg(message);
					return j;
				}
				t_ZGK_PIPE_RKDService.deleteEntityById(
						T_ZGK_PIPE_RKDEntity.class, id);
				// t_ZGK_PIPE_RKDService.delete(rkd);
				systemService.addLog(message+pipecode, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "大系统用户信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加管材入库详细信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest request) {
		String message = "铸管部入库详单添加成功";
		AjaxJson j = new AjaxJson();
		try {
			String jsondata = request.getParameter("data");
			System.out.println("jsondata:" + jsondata);
			if (StringUtil.isNotEmpty(jsondata)) {
				JSONArray dataArr = JSONHelper.toJSONArray(jsondata);
				System.out.println("dataArr:" + dataArr.size());
				for (int i = 0; i < dataArr.size(); i++) {
					JSONObject dataObj = dataArr.getJSONObject(i);
					String dn = dataObj.getString("dn");
					String batchFull = dataObj.getString("batchFull");
					String pipeSerial = dataObj.getString("pipeSerial");
					String checkSql = "select count(*) from t_zgk_pipe_kc where dn='"
							+ dn
							+ "' and batch_full='"
							+ batchFull
							+ "' and pipe_serial='" + pipeSerial + "'";
					long count = systemService.getCountForJdbc(checkSql);
					if (count >= 1) {
						String msg = "opps,这个管号库存已经存在，请修改出库单号！！！;批号是：'"
								+ batchFull + "';管号是：'" + pipeSerial
								+ "';规格是：'" + dn + "'";
						message = msg;
						j.setMsg(message);
						return j;
					}
					T_ZGK_PIPE_RKDEntity pipe = (T_ZGK_PIPE_RKDEntity) JSONHelper
							.json2Object(dataObj.toString(),
									T_ZGK_PIPE_RKDEntity.class);
					T_ZG_PIPEEntity zgpipe = (T_ZG_PIPEEntity) JSONHelper
							.json2Object(dataObj.toString(),
									T_ZG_PIPEEntity.class);
					if (pipe.getPipenum() == null) {
						System.out.println("pipenum:"
								+ dataObj.getInt("pipenum"));
						pipe.setPipenum(dataObj.getInt("pipenum"));
					}
					if (pipe.getCengci() == null
							|| "".equals(dataObj.getString("cengci"))) {
						System.out.println("cengci:"
								+ dataObj.getString("cengci"));
						System.out
								.println("cengci:11111111111111111111111111111111");
						pipe.setCengci(0);
						System.out.println("cengci:" + pipe.getCengci());
					} else {
						pipe.setCengci(dataObj.getInt("cengci"));
					}
					if (pipe.getCengneixuhao() == null
							|| "".equals(dataObj.getString("cengneixuhao"))) {
						System.out.println("cengneixuhao:"
								+ dataObj.getString("cengneixuhao"));
						pipe.setCengneixuhao(0);
						System.out.println("cengneixuhao:"
								+ pipe.getCengneixuhao());
					} else {
						pipe.setCengneixuhao(dataObj.getInt("cengneixuhao"));
					}
					// pipe.setExpFlag(00);
					t_ZGK_PIPE_RKDService.save(pipe);
					systemService.addLog(message+pipe.getDn()+pipe.getBatchFull()+pipe.getPackageid(), Globals.Log_Type_INSERT,
							Globals.Log_Leavel_INFO);
					// zgpipe.setFlag("已入库");
					// zgPipeService.updateEntitie(zgpipe);

				}
			} else {
				message = "参数错误！请检查参数信息";
			}
			
			j.setMsg(message);
		} catch (Exception e) {
			e.printStackTrace();
			message = "添加失败，" + e;
		}
		return j;
	}

	/**
	 * 添加管材入库详细信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save2")
	@ResponseBody
	public AjaxJson save2(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest request) {
		String message = "铸管部入库详单添加成功";
		AjaxJson j = new AjaxJson();
		try {
			String jsondata = request.getParameter("data");
			System.out.println("jsondata:" + jsondata);
			if (StringUtil.isNotEmpty(jsondata)) {
				JSONArray dataArr = JSONHelper.toJSONArray(jsondata);
				System.out.println("dataArr:" + dataArr.size());
				for (int i = 0; i < dataArr.size(); i++) {
					JSONObject dataObj = dataArr.getJSONObject(i);
					String dn = dataObj.getString("dn");
					String batchFull = dataObj.getString("pyear") + "-"
							+ dataObj.getString("batch");
					String mpipeSerial = dataObj.getString("pipeserial");
//					t_zgk_pipe_kc
					String checkSql = "select count(*) from T_ZGK_PIPE_KC where dn='"
							+ dn
							+ "' and batch_full='"
							+ batchFull
							+ "' and pipe_serial='" + mpipeSerial + "'";
					long count = systemService.getCountForJdbc(checkSql);
					if (count >= 1) {
						String msg = "管号库存已经存在！;批号是：'" + batchFull + "';管号是：'"
								+ mpipeSerial + "';规格是：'" + dn + "'";
						message = msg;
						j.setMsg(message);
						return j;
					}
					// T_ZGK_PIPE_RKDEntity pipe = (T_ZGK_PIPE_RKDEntity)
					// JSONHelper.json2Object(dataObj.toString(),
					// T_ZGK_PIPE_RKDEntity.class);

					String rukudanid11 = dataObj.getString("rukudanid");
					String checkSql1 = "select count(*) from t_zgk_pipe_rkd where rukudanid='"
							+ rukudanid11
							+ "' and dn='"
							+ dn
							+ "' and batch_full='"
							+ batchFull
							+ "' and pipe_serial='" + mpipeSerial + "'";
					long count1 = systemService.getCountForJdbc(checkSql1);
					if (count1 >= 1) {
						String msg = "管号在本出库单重复！;批号是：'" + batchFull + "';管号是：'"
								+ mpipeSerial + "';规格是：'" + dn + "'";
						message = msg;
						j.setMsg(message);
						return j;
					}
					T_ZGK_PIPE_RKDEntity pipe = (T_ZGK_PIPE_RKDEntity) JSONHelper
							.json2Object(dataObj.toString(),
									T_ZGK_PIPE_RKDEntity.class);
					// pipe.setExpFlag(00);
					String batch = dataObj.getString("batch");
					String myear = dataObj.getString("pyear");
					String pipeSerial = dataObj.getString("pipeserial");
					if (pipe.getBatchFull() == null) {
						pipe.setBatchFull(myear + "-" + batch);
					}
					if (pipe.getPackageid() == null) {
						pipe.setPackageid(dataObj.getString("packid"));
					}
					if (pipe.getCengci() == null
							|| "".equals(dataObj.getString("cengci"))) {
						System.out.println("cengci:"
								+ dataObj.getString("cengci"));
						System.out
								.println("cengci:11111111111111111111111111111111");
						pipe.setCengci(0);
						System.out.println("cengci:" + pipe.getCengci());
					} else {
						pipe.setCengci(dataObj.getInt("cengci"));
					}
					if (pipe.getCengneixuhao() == null
							|| "".equals(dataObj.getString("cengneixuhao"))) {
						System.out.println("cengneixuhao:"
								+ dataObj.getString("cengneixuhao"));
						pipe.setCengneixuhao(0);
						System.out.println("cengneixuhao:"
								+ pipe.getCengneixuhao());
					} else {
						pipe.setCengneixuhao(dataObj.getInt("cengneixuhao"));
					}
					if (pipe.getPipeSerial() == null) {
						pipe.setPipeSerial(dataObj.getString("pipeserial"));
					}
					if (pipe.getPipeCode() == null) {
						pipe.setPipeCode(pipe.getDn() + "-" + myear + "-"
								+ batch + "-" + pipeSerial);
					}
					if (pipe.getPipenum() == null) {
						pipe.setPipenum(dataObj.getInt("pipenum"));
					}
					System.out.println("pipecode:" + pipe.getPipeCode());
					// T_ZGK_PIPE_RKDEntity t =
					// t_ZGK_PIPE_RKDService.findUniqueByProperty(T_ZGK_PIPE_RKDEntity.class,
					// "pipeCode", pipe.getPipeCode());
					// if(t==null){
					// t_ZGK_PIPE_RKDService.save(pipe);
					// }else{
					// message +="管号"+pipe.getPipeCode()+"已存在";
					// j.setMsg(message);
					// return j;
					// }
					t_ZGK_PIPE_RKDService.save(pipe);
					systemService.addLog(message+pipe.getDn()+pipe.getBatchFull()+pipe.getPackageid(), Globals.Log_Type_INSERT,
							Globals.Log_Leavel_INFO);
				}
			} else {
				message = "参数错误！请检查参数信息";
			}
			
			j.setMsg(message);
		} catch (Exception e) {
			e.printStackTrace();
			//错误的业务逻辑：1.AjaxJson信息默认的为“操作成功”;
     		//2.如果异常的话message异常信息并没有添加到AjaxJson数据中
			message = "添加失败，" + e;
		}
		return j;
	}

	/**
	 * 管材入库详细信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_RKD.getId())) {
			t_ZGK_PIPE_RKD = t_ZGK_PIPE_RKDService.getEntity(
					T_ZGK_PIPE_RKDEntity.class, t_ZGK_PIPE_RKD.getId());
			req.setAttribute("t_ZGK_PIPE_RKDPage", t_ZGK_PIPE_RKD);
		}
		System.out.println("addorupdate.before(return)");
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKD");
	}

	/**
	 * 手工管材入库详细信息列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate2")
	public ModelAndView addorupdate2(T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_RKD.getId())) {
			t_ZGK_PIPE_RKD = t_ZGK_PIPE_RKDService.getEntity(
					T_ZGK_PIPE_RKDEntity.class, t_ZGK_PIPE_RKD.getId());
			req.setAttribute("t_ZGK_PIPE_RKDPage", t_ZGK_PIPE_RKD);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_rkd/t_ZGK_PIPE_RKD2");
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_RKDEntity> list() {
		List<T_ZGK_PIPE_RKDEntity> listT_ZGK_PIPE_RKDs = t_ZGK_PIPE_RKDService
				.getList(T_ZGK_PIPE_RKDEntity.class);
		return listT_ZGK_PIPE_RKDs;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_RKDEntity task = t_ZGK_PIPE_RKDService.get(
				T_ZGK_PIPE_RKDEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(
			@RequestBody T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD,
			UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_RKDEntity>> failures = validator
				.validate(t_ZGK_PIPE_RKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(
					BeanValidators.extractPropertyAndMessage(failures),
					HttpStatus.BAD_REQUEST);
		}

		// 保存
		t_ZGK_PIPE_RKDService.save(t_ZGK_PIPE_RKD);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_RKD.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_RKDController/" + id)
				.build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(
			@RequestBody T_ZGK_PIPE_RKDEntity t_ZGK_PIPE_RKD) {
		// 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_RKDEntity>> failures = validator
				.validate(t_ZGK_PIPE_RKD);
		if (!failures.isEmpty()) {
			return new ResponseEntity(
					BeanValidators.extractPropertyAndMessage(failures),
					HttpStatus.BAD_REQUEST);
		}

		// 保存
		t_ZGK_PIPE_RKDService.saveOrUpdate(t_ZGK_PIPE_RKD);

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_RKDService.deleteEntityById(T_ZGK_PIPE_RKDEntity.class, id);
	}
}
