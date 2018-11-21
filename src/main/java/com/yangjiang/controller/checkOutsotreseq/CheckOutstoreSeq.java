package com.yangjiang.controller.checkOutsotreseq;

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
@RequestMapping("/CheckOutstoreSeq")
public class CheckOutstoreSeq extends BaseController {
	private static final Logger logger = Logger.getLogger(CheckOutstoreSeq.class);
	@Autowired
	private SystemService systemService;

	/**
	 * 查询铸管出库单序号
	 * 
	 * @return
	 */
	@RequestMapping(params = "check")
	@ResponseBody
	public String check(HttpServletResponse response, HttpServletRequest request) {
		String seq=request.getParameter("seq");
		String sql="select isnull(max(SUBSTRING(chukudanid, 11, 3)),0)+1  from T_ZGK_PIPE_CKM where SUBSTRING(chukudanid, 1, 8)='"+seq+"'";
		System.out.println("sql:"+sql);
		Long total= systemService.getCountForJdbc(sql);
		System.out.println("total:"+total);
		return total.toString();
	}
}
