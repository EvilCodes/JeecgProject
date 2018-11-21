package com.yangjiang.controller.tuikudanid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangjiang.controller.checkrukuid.CheckrukuidController;
@Controller
@RequestMapping("/TuikudanidController")
public class TuikudanidController extends BaseController {
	private static final Logger logger = Logger.getLogger(TuikudanidController.class);
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
		String sql="select COUNT(*) from t_zg_pipe_rk where SUBSTRING(rukudanid, 0, 10)='"+seq+"'";
		System.out.println("sql:"+sql);
		Long total= systemService.getCountForJdbc(sql)+1;
		System.out.println("total:"+total);
		return total.toString();
	}
}
