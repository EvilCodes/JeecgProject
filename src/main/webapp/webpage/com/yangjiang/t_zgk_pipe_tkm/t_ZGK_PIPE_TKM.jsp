<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>退库单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_TKMController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_TKMPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="riqi" name="riqi" ignore="ignore"
							     value="<fmt:formatDate value='${t_ZGK_PIPE_TKMPage.riqi}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							退库单编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="tuikudanid" name="tuikudanid" 
							   value="${t_ZGK_PIPE_TKMPage.tuikudanid}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保管员：
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="baoguanyuan" name="baoguanyuan" 
							   value="${t_ZGK_PIPE_TKMPage.baoguanyuan}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓库名称:
						</label>
					</td>
					<td class="value"><t:dictSelect field="storeName" type="select"
						datatype="*" dictTable="T_ZGK_XDM_CPK" dictField="store_name"
						dictText="store_name" id="store_name"></t:dictSelect> <span
					class="Validform_checktip"></span>
				</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收货单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="consignee" name="consignee" ignore="ignore"
							   value="${t_ZGK_PIPE_TKMPage.consignee}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
			</table>
		</t:formvalid>
 </body>