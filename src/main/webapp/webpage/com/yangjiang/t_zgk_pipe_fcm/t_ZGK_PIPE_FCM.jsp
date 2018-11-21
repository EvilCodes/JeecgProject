<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>返厂主表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_FCMController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_FCMPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							返厂单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="fankudanid" name="fankudanid" 
							   value="${t_ZGK_PIPE_FCMPage.fankudanid}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="riqi" name="riqi" ignore="ignore"
							     value="<fmt:formatDate value='${t_ZGK_PIPE_FCMPage.riqi}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓库名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="storeName" name="storeName" ignore="ignore"
							   value="${t_ZGK_PIPE_FCMPage.storeName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保管员:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="baoguanyuan" name="baoguanyuan" ignore="ignore"
							   value="${t_ZGK_PIPE_FCMPage.baoguanyuan}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							承运公司编码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="carryCompanyCode" name="carryCompanyCode" ignore="ignore"
							   value="${t_ZGK_PIPE_FCMPage.carryCompanyCode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							承运公司:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="carryCompanyName" name="carryCompanyName" ignore="ignore"
							   value="${t_ZGK_PIPE_FCMPage.carryCompanyName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							运输方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trnpMode" name="trnpMode" ignore="ignore"
							   value="${t_ZGK_PIPE_FCMPage.trnpMode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="carNo" name="carNo" ignore="ignore"
							   value="${t_ZGK_PIPE_FCMPage.carNo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>