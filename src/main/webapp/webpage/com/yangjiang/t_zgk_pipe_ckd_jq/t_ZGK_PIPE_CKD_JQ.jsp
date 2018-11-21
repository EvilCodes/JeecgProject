<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>随车胶圈</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_CKD_JQController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_CKD_JQPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							厂家:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="factory" name="factory" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.factory}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							产品编码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemcode" name="itemcode" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.itemcode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							产品名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemname" name="itemname" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.itemname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sendnum" name="sendnum" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.sendnum}" datatype="n">
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
						<input class="inputxt" id="chukudanid" name="chukudanid" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.chukudanid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							派车单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pcdid" name="pcdid" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.pcdid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发运重量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sendweight" name="sendweight" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.sendweight}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="name" name="name" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.name}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="dn" name="dn" ignore="ignore"
							   value="${t_ZGK_PIPE_CKD_JQPage.dn}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>