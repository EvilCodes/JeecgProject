<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>结转标志</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_KC_LS_FLAGController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_KC_LS_FLAGPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							结算日前:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="riqi" name="riqi" 
							     value="<fmt:formatDate value='${t_ZGK_PIPE_KC_LS_FLAGPage.riqi}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" datatype="*">
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
						<input class="inputxt" id="storeName" name="storeName" 
							   value="${t_ZGK_PIPE_KC_LS_FLAGPage.storeName}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结算标志:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="flag" name="flag" ignore="ignore"
							   value="${t_ZGK_PIPE_KC_LS_FLAGPage.flag}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结算人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiesuanRen" name="jiesuanRen" ignore="ignore"
							   value="${t_ZGK_PIPE_KC_LS_FLAGPage.jiesuanRen}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							结算IP地址:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jiesuanIp" name="jiesuanIp" ignore="ignore"
							   value="${t_ZGK_PIPE_KC_LS_FLAGPage.jiesuanIp}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>