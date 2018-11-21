<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>发运计划审核</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_MYJK_FYJHController.do?save">
			<input id="id" name="id" type="hidden" value="${t_MYJK_FYJHPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货通知单号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billNoticeNo" name="billNoticeNo" 
							   value="${t_MYJK_FYJHPage.billNoticeNo}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							发货通知单明细号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="billLadingNoItem" name="billLadingNoItem" 
							   value="${t_MYJK_FYJHPage.billLadingNoItem}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							发货通知单状态:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planStatus" name="planStatus" 
							   value="${t_MYJK_FYJHPage.planStatus}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							内外销标志:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expFlag" name="expFlag" ignore="ignore"
							   value="${t_MYJK_FYJHPage.expFlag}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="contractNo" name="contractNo" ignore="ignore"
							   value="${t_MYJK_FYJHPage.contractNo}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							合同子项号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orderNo" name="orderNo" ignore="ignore"
							   value="${t_MYJK_FYJHPage.orderNo}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							批次号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="schedulingNo" name="schedulingNo" ignore="ignore"
							   value="${t_MYJK_FYJHPage.schedulingNo}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							交货日期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="delivyDate" name="delivyDate" ignore="ignore"
							   value="${t_MYJK_FYJHPage.delivyDate}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交货地点代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="delivyPlaceCode" name="delivyPlaceCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.delivyPlaceCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							交货地点名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="delivyPlaceName" name="delivyPlaceName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.delivyPlaceName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							专用线代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="privateRouteCode" name="privateRouteCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.privateRouteCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							专用线名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="privateRouteName" name="privateRouteName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.privateRouteName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							运输方式代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trnpModeCode" name="trnpModeCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.trnpModeCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							运输方式名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trnpMode" name="trnpMode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.trnpMode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							发货组织机构代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="outOrgCode" name="outOrgCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.outOrgCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							发货组织机构名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="outOrgName" name="outOrgName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.outOrgName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							发货库房代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="outStorehouseCode" name="outStorehouseCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.outStorehouseCode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发货库房:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="outStorehouseName" name="outStorehouseName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.outStorehouseName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入库组织机构代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inOrgCode" name="inOrgCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.inOrgCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入库组织机构名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inOrgName" name="inOrgName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.inOrgName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							入库仓库代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inWhouseCode" name="inWhouseCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.inWhouseCode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							入库仓库名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inWhouseName" name="inWhouseName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.inWhouseName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							收货地点:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="recAdd" name="recAdd" ignore="ignore"
							   value="${t_MYJK_FYJHPage.recAdd}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							收货联系人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="recPerson" name="recPerson" ignore="ignore"
							   value="${t_MYJK_FYJHPage.recPerson}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							收货人联系电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="recTel" name="recTel" ignore="ignore"
							   value="${t_MYJK_FYJHPage.recTel}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							组织机构名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orgName" name="orgName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.orgName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							收货单位名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="consignCname" name="consignCname" ignore="ignore"
							   value="${t_MYJK_FYJHPage.consignCname}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							销售人员名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="salePersonName" name="salePersonName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.salePersonName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							销售人员电话:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mobilePhone" name="mobilePhone" ignore="ignore"
							   value="${t_MYJK_FYJHPage.mobilePhone}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="remark" name="remark" ignore="ignore"
							   value="${t_MYJK_FYJHPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							套装要求:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="suitFlag" name="suitFlag" ignore="ignore"
							   value="${t_MYJK_FYJHPage.suitFlag}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							产品编码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemCode" name="itemCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.itemCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							产品名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemCname" name="itemCname" ignore="ignore"
							   value="${t_MYJK_FYJHPage.itemCname}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							计划件数:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planNum" name="planNum" ignore="ignore"
							   value="${t_MYJK_FYJHPage.planNum}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							计划重量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planWt" name="planWt" ignore="ignore"
							   value="${t_MYJK_FYJHPage.planWt}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							包装方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="packageWay" name="packageWay" ignore="ignore"
							   value="${t_MYJK_FYJHPage.packageWay}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							特殊产品描述 :
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="specialDesc" name="specialDesc" ignore="ignore"
							   value="${t_MYJK_FYJHPage.specialDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							胶圈指定生产厂代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemFactoryCode" name="itemFactoryCode" ignore="ignore"
							   value="${t_MYJK_FYJHPage.itemFactoryCode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							胶圈指定生产厂名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemFactoryName" name="itemFactoryName" ignore="ignore"
							   value="${t_MYJK_FYJHPage.itemFactoryName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							读取标识:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="readFlag" name="readFlag" ignore="ignore"
							   value="${t_MYJK_FYJHPage.readFlag}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							插入日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="insertDate" name="insertDate" ignore="ignore"
							     value="<fmt:formatDate value='${t_MYJK_FYJHPage.insertDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							更新标识:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="updateflag" name="updateflag" ignore="ignore"
							   value="${t_MYJK_FYJHPage.updateflag}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							主运号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="carryNo" name="carryNo" ignore="ignore"
							   value="${t_MYJK_FYJHPage.carryNo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总发运数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="totaltransportnum" name="totaltransportnum" ignore="ignore"
							   value="${t_MYJK_FYJHPage.totaltransportnum}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							总发运重量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="totaltransportwt" name="totaltransportwt" ignore="ignore"
							   value="${t_MYJK_FYJHPage.totaltransportwt}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							审核标记:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="auditflag" name="auditflag" ignore="ignore"
							   value="${t_MYJK_FYJHPage.auditflag}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>