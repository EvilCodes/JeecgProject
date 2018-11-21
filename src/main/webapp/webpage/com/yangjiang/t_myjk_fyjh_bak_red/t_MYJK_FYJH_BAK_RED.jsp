<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>被动红冲</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_MYJK_FYJH_BAK_REDController.do?save">
			<input id="id" name="id" type="hidden" value="${t_MYJK_FYJH_BAK_REDPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							发运单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billNoticeNo" name="billNoticeNo" 
							   value="${t_MYJK_FYJH_BAK_REDPage.billNoticeNo}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发运明细号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billLadingNoItem" name="billLadingNoItem" 
							   value="${t_MYJK_FYJH_BAK_REDPage.billLadingNoItem}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出库单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sendNo" name="sendNo" 
							   value="${t_MYJK_FYJH_BAK_REDPage.sendNo}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓库名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="outStorehouseName" name="outStorehouseName" ignore="ignore"
							   value="${t_MYJK_FYJH_BAK_REDPage.outStorehouseName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核标志:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shbz" name="shbz" 
							   value="${t_MYJK_FYJH_BAK_REDPage.shbz}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shr" name="shr" ignore="ignore"
							   value="${t_MYJK_FYJH_BAK_REDPage.shr}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="shsj" name="shsj" ignore="ignore"
							     value="<fmt:formatDate value='${t_MYJK_FYJH_BAK_REDPage.shsj}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							接收时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="insertDate" name="insertDate" 
							     value="<fmt:formatDate value='${t_MYJK_FYJH_BAK_REDPage.insertDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					
				</tr>
			</table>
		</t:formvalid>
 </body>