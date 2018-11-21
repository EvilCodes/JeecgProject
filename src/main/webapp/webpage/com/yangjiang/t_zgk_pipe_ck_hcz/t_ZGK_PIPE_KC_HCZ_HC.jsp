<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>11</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_CK_HCZController.do?doAdd">
			<input id="id" name="id" type="hidden" value="${t_ZGK_PIPE_CK_HCZPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货通知单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billNoticeNo" name="billNoticeNo" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.billNoticeNo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货通知单明细:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billLadingNoItem" name="billLadingNoItem" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.billLadingNoItem}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sendNo" name="sendNo" 
							   value="${t_ZGK_PIPE_CK_HCZPage.sendNo}" datatype="*">
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
						<input class="inputxt" id="outWhouseName" name="outWhouseName" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.outWhouseName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.remark}">
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
							   value="${t_ZGK_PIPE_CK_HCZPage.itemCode}">
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
							   value="${t_ZGK_PIPE_CK_HCZPage.itemCname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车皮型号代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="blockSize" name="blockSize" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.blockSize}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							车皮型号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="blockSizeName" name="blockSizeName" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.blockSizeName}">
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
						<input class="inputxt" id="blockNo" name="blockNo" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.blockNo}">
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
						<input class="inputxt" id="stockPerson" name="stockPerson" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.stockPerson}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货支数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planNum" name="planNum" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.planNum}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货重量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planWt" name="planWt" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.planWt}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="sendTime" name="sendTime" ignore="ignore"
							     value="<fmt:formatDate value='${t_ZGK_PIPE_CK_HCZPage.sendTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							短尺标志:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="noSameMark" name="noSameMark" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.noSameMark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							样品管标志:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sample" name="sample" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.sample}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="boxNo" name="boxNo" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.boxNo}">
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
						<input class="inputxt" id="shbz" name="shbz" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.shbz}">
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
							   value="${t_ZGK_PIPE_CK_HCZPage.shr}">
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
							     value="<fmt:formatDate value='${t_ZGK_PIPE_CK_HCZPage.shsj}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							读取标志:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="readFlag" name="readFlag" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.readFlag}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							到站:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="delivyPlaceName" name="delivyPlaceName" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.delivyPlaceName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							专线名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="privateRouteName" name="privateRouteName" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.privateRouteName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							销售公司:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orgName" name="orgName" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.orgName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收货单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="consignCname" name="consignCname" ignore="ignore"
							   value="${t_ZGK_PIPE_CK_HCZPage.consignCname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>