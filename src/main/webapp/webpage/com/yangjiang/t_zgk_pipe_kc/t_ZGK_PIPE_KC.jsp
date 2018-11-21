<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>管子库存</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_KCController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_KCPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							storeName:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="storeName" name="storeName" 
							   value="${t_ZGK_PIPE_KCPage.storeName}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							dn:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="dn" name="dn" 
							   value="${t_ZGK_PIPE_KCPage.dn}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							batchFull:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="batchFull" name="batchFull" 
							   value="${t_ZGK_PIPE_KCPage.batchFull}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pipeSerial:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pipeSerial" name="pipeSerial" 
							   value="${t_ZGK_PIPE_KCPage.pipeSerial}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							packageid:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="packageid" name="packageid" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.packageid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							productPlanNo:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="productPlanNo" name="productPlanNo" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.productPlanNo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							itemCode:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemCode" name="itemCode" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.itemCode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							itemCname:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemCname" name="itemCname" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.itemCname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							expFlag:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expFlag" name="expFlag" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.expFlag}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							specialDesc:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="specialDesc" name="specialDesc" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.specialDesc}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pipenum:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pipenum" name="pipenum" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.pipenum}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							suitWay:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="suitWay" name="suitWay" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.suitWay}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							huowei:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="huowei" name="huowei" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.huowei}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cengci:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cengci" name="cengci" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.cengci}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cengneixuhao:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cengneixuhao" name="cengneixuhao" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.cengneixuhao}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							productLine:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="productLine" name="productLine" ignore="ignore"
							   value="${t_ZGK_PIPE_KCPage.productLine}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>