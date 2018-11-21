package com.yangjiang.controller.checkrukuidZGK;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yangjiang.controller.t_zg_pipe_rk.T_zg_pipe_rkController;
@Controller
@RequestMapping("/CheckrukuidZGKController")
public class CheckrukuidZGKController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckrukuidZGKController.class);
	@Autowired
	private SystemService systemService;

	/**
	 * 查询铸管厂入库单序号
	 * 
	 * @return
	 */
	@RequestMapping(params = "check")
	@ResponseBody
	public String check(HttpServletResponse response, HttpServletRequest request) {
		String seq=request.getParameter("seq");
		String sql="select COUNT(*) from t_zgk_pipe_rkm where SUBSTRING(rukudanid, 0, 11)='"+seq+"'";
		System.out.println("sql:"+sql);
		Long total= systemService.getCountForJdbc(sql)+1;
		System.out.println("total:"+total);
		return total.toString();
	}
}
