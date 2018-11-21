<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>出库单主表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_CKDController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_CKDPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							出库单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="chukudanid" name="chukudanid" 
							   value="${t_ZGK_PIPE_CKDPage.chukudanid}" datatype="*">
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
						<input class="inputxt" id="dn" name="dn" 
							   value="${t_ZGK_PIPE_CKDPage.dn}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							批号全称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="batchFull" name="batchFull" 
							   value="${t_ZGK_PIPE_CKDPage.batchFull}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管序号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pipeSerial" name="pipeSerial" 
							   value="${t_ZGK_PIPE_CKDPage.pipeSerial}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							包号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="packageid" name="packageid" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.packageid}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							生产计划号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="productPlanNo" name="productPlanNo" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.productPlanNo}">
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
						<input class="inputxt" id="itemCode" name="itemCode" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.itemCode}">
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
						<input class="inputxt" id="itemCname" name="itemCname" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.itemCname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							出口标识:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expFlag" name="expFlag" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.expFlag}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							特殊合同描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="specialDesc" name="specialDesc" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.specialDesc}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							支数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pipenum" name="pipenum" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.pipenum}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							套装方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="suitWay" name="suitWay" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.suitWay}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							货位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="huowei" name="huowei" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.huowei}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							层号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cengci" name="cengci" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.cengci}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							层内序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cengneixuhao" name="cengneixuhao" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.cengneixuhao}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							生产线:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="productLine" name="productLine" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.productLine}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发运计划单明细号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billLadingNoItem" name="billLadingNoItem" ignore="ignore"
							   value="${t_ZGK_PIPE_CKDPage.billLadingNoItem}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>