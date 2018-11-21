package com.yangjiang.controller.CheckZGKRukudanid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/CheckZGKRukudanidController")
public class CheckZGKRukudanidController extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckZGKRukudanidController.class);
	@Autowired
	private SystemService systemService;

	/**
	 * 查询铸管库入库单序号
	 * 
	 * @return
	 */
	@RequestMapping(params = "check")
	@ResponseBody
	public String check(HttpServletResponse response, HttpServletRequest request) {
		String seq=request.getParameter("seq");
		String sql="select isnull(max(SUBSTRING(rukudanid, 11, 3)),0)+1 from manuZGKRKM where SUBSTRING(rukudanid, 2, 9)='"+seq+"'";
		System.out.println("sql:"+sql);
		Long total= systemService.getCountForJdbc(sql);
		System.out.println("total:"+total);
		return total.toString();
	}
}
