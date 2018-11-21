package com.yangjiang.controller.t_zgk_pipe_dhw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang.math.NumberUtils;
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
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.yangjiang.entity.t_zg_pipe.T_ZG_PIPEEntity;
import com.yangjiang.entity.t_zgk_pipe_dhw.T_ZGK_PIPE_DHWEntity;
import com.yangjiang.service.t_zgk_pipe_dhw.T_ZGK_PIPE_DHWServiceI;

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
import org.json.JSONObject;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**   
 * @Title: Controller
 * @Description: 到货位
 * @author zhangdaihao
 * @date 2016-12-01 10:13:29
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/t_ZGK_PIPE_DHWController")
public class T_ZGK_PIPE_DHWController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(T_ZGK_PIPE_DHWController.class);

	@Autowired
	private T_ZGK_PIPE_DHWServiceI t_ZGK_PIPE_DHWService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 到货位列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/yangjiang/t_zgk_pipe_dhw/t_ZGK_PIPE_DHWList");
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
	public void datagrid(T_ZGK_PIPE_DHWEntity t_ZGK_PIPE_DHW,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(T_ZGK_PIPE_DHWEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, t_ZGK_PIPE_DHW, request.getParameterMap());
		cq.add();
		this.t_ZGK_PIPE_DHWService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除到货位
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(T_ZGK_PIPE_DHWEntity t_ZGK_PIPE_DHW, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		t_ZGK_PIPE_DHW = systemService.getEntity(T_ZGK_PIPE_DHWEntity.class, t_ZGK_PIPE_DHW.getId());
		message = "到货位删除成功";
		t_ZGK_PIPE_DHWService.delete(t_ZGK_PIPE_DHW);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 添加到货位
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(T_ZGK_PIPE_DHWEntity t_ZGK_PIPE_DHW, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		
		try{
			String jsondata=request.getParameter("data");	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  		    
			String riqi=request.getParameter("riqi");
			String riqi1=riqi.substring(0,4)+riqi.substring(5,7)+riqi.substring(8,10);
			Date mydate=sdf.parse(riqi);
			//生成倒库单号
			String sql="select COUNT(*) from T_ZGK_PIPE_DHW where SUBSTRING(daohuoweiid, 0, 9)='"+riqi1+"'";
			long total=systemService.getCountForJdbc(sql)+1;								
			System.out.println("total:"+total);	
			//System.out.println("hw:"+request.getParameter("after_huowei"));
			//System.out.println("cc:"+request.getParameter("after_cengci"));
			//System.out.println("cnxh:"+request.getParameter("after_cengneixuhao"));
			String sequence="";
			//System.out.println("sequence:"+sequence);
			if(StringUtil.isNotEmpty(total)){					
				if(total<10)
				{
					sequence="00"+total;
				}else if(total<100) 
				{
					sequence="0"+total;
				}
			}		
			//String tuikudanid=riqi.substring(1,8)+sequence;										
			//System.out.println("send_car_no:"+send_car_no);		
			//倒库单号生成完成
			System.out.println("jsondata:"+jsondata);
			if(StringUtil.isNotEmpty(jsondata)){
				JSONArray dataArr=JSONHelper.toJSONArray(jsondata);		
			//	net.sf.json.JSONObject dataObj0 = dataArr.getJSONObject(dataArr.size()-1);
				for(int i=0;i<dataArr.size();i++){
					System.out.println("dataArr.size():"+dataArr.size());
					System.out.println("i:"+i);
					net.sf.json.JSONObject dataObj = dataArr.getJSONObject(i);
				
					T_ZGK_PIPE_DHWEntity pipe =new T_ZGK_PIPE_DHWEntity();
					String store_seq=dataObj.getString("store_name");
					String seq="";
					if(store_seq.equals("广东新兴铸管一库")){
						 seq="1";
					}else if(store_seq.equals("广东新兴铸管一库")){
						 seq="2";
					}else if(store_seq.equals("广东新兴铸管一库")){
						 seq="3";
					}
					System.out.println("seq:"+seq);
					if(pipe.getRiqi()==null){
						pipe.setRiqi(mydate);
					}
					if(pipe.getAfterHuowei()==null){
						pipe.setAfterHuowei(request.getParameter("after_huowei").trim());
					}
					 // Pattern pattern = Pattern.compile("[0-9]*");
			          // Matcher isNum = pattern.matcher(request.getParameter("after_cengci"));
			         //  if( !isNum.matches() ){
			         //      return false;
			         //  }
			          // return true;
			          // NumberUtils.isNumber(str)
			         
			           
			           if(NumberUtils.isNumber(request.getParameter("after_cengci").trim()))
			           {
			        	   pipe.setAfterCengci(Integer.parseInt(request.getParameter("after_cengci").trim()));
			        	}
			           else
			           { pipe.setAfterCengci(0);}
			           //Matcher isNum1 = pattern.matcher(request.getParameter("after_cengneixuhao"));
			          
			           if(NumberUtils.isNumber(request.getParameter("after_cengneixuhao")))
			           {
			        	   pipe.setAfterCengneixuhao(Integer.parseInt(request.getParameter("after_cengneixuhao")));
			        	}
			           else
			           { pipe.setAfterCengneixuhao(0);}
					//if(pipe.getAfterCengci()==null&&request.getParameter("after_cengci")!=null&&request.getParameter("after_cengci")!=""){
						
						//pipe.setAfterCengci(Integer.parseInt(request.getParameter("after_cengci")));
						
						
					//}
					
					//if(pipe.getAfterCengneixuhao()==null&&request.getParameter("after_cengneixuhao")!=null&&request.getParameter("after_cengneixuhao")!=""){
						
					//	pipe.setAfterCengneixuhao(Integer.parseInt(request.getParameter("after_cengneixuhao")));
					//}
					if(pipe.getBeforeHuowei()==null){
						pipe.setBeforeHuowei(dataObj.getString("huowei"));
					}
					if(pipe.getBeforeCengci()==null){
						pipe.setBeforeCengci(dataObj.getInt("cengci"));
					}
					if(pipe.getBeforeCengneixuhao()==null){
						pipe.setBeforeCengneixuhao(dataObj.getInt("cengneixuhao"));
					}
					if(pipe.getPipeCode()==null){
						pipe.setPipeCode(dataObj.getString("dn")+"-"+dataObj.getString("batchFull")+"-"+dataObj.getString("pipeSerial"));
					}
					if(pipe.getStoreName()==null){
						pipe.setStoreName(dataObj.getString("store_name"));
					}
					if(pipe.getDaohuoweiid()==null){
						String daokudanid=riqi.substring(0,4)+riqi.substring(5,7)+riqi.substring(8,10)+seq+sequence;
						System.out.println("daokudanid:"+daokudanid);
						pipe.setDaohuoweiid(daokudanid);
					}
					pipe.setEdittime(new Date());
					String editip=IpUtil.getIpAddr(request);
					pipe.setEditip(editip);
					//这里可以拿真是姓名
					String edituser=ResourceUtil.getSessionUserName().getUserName();
					pipe.setEdituser(edituser);
					System.out.println(pipe.getAfterCengneixuhao());
					
					//pipe.setExpFlag(00);
					t_ZGK_PIPE_DHWService.save(pipe);
					message="添加成功";
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
	 * 到货位列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(T_ZGK_PIPE_DHWEntity t_ZGK_PIPE_DHW, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(t_ZGK_PIPE_DHW.getId())) {
			t_ZGK_PIPE_DHW = t_ZGK_PIPE_DHWService.getEntity(T_ZGK_PIPE_DHWEntity.class, t_ZGK_PIPE_DHW.getId());
			req.setAttribute("t_ZGK_PIPE_DHWPage", t_ZGK_PIPE_DHW);
		}
		return new ModelAndView("com/yangjiang/t_zgk_pipe_dhw/t_ZGK_PIPE_DHW");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T_ZGK_PIPE_DHWEntity> list() {
		List<T_ZGK_PIPE_DHWEntity> listT_ZGK_PIPE_DHWs=t_ZGK_PIPE_DHWService.getList(T_ZGK_PIPE_DHWEntity.class);
		return listT_ZGK_PIPE_DHWs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		T_ZGK_PIPE_DHWEntity task = t_ZGK_PIPE_DHWService.get(T_ZGK_PIPE_DHWEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody T_ZGK_PIPE_DHWEntity t_ZGK_PIPE_DHW, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_DHWEntity>> failures = validator.validate(t_ZGK_PIPE_DHW);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_DHWService.save(t_ZGK_PIPE_DHW);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = t_ZGK_PIPE_DHW.getId();
		URI uri = uriBuilder.path("/rest/t_ZGK_PIPE_DHWController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody T_ZGK_PIPE_DHWEntity t_ZGK_PIPE_DHW) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<T_ZGK_PIPE_DHWEntity>> failures = validator.validate(t_ZGK_PIPE_DHW);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		t_ZGK_PIPE_DHWService.saveOrUpdate(t_ZGK_PIPE_DHW);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		t_ZGK_PIPE_DHWService.deleteEntityById(T_ZGK_PIPE_DHWEntity.class, id);
	}
}
