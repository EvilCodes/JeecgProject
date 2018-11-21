<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>生产计划</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_MYJK_SCJHController.do?save">
			<input id="id" name="id" type="hidden" value="${t_MYJK_SCJHPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							生产计划号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="productPlanNo" name="productPlanNo" 
							   value="${t_MYJK_SCJHPage.productPlanNo}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							合约号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="contractNo" name="contractNo" ignore="ignore"
							   value="${t_MYJK_SCJHPage.contractNo}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							合同号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orderNo" name="orderNo" ignore="ignore"
							   value="${t_MYJK_SCJHPage.orderNo}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							合约简称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="contractDesc" name="contractDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.contractDesc}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							内外销标识:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="expFlag" name="expFlag" ignore="ignore"
							   value="${t_MYJK_SCJHPage.expFlag}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							年份:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="year" name="year" ignore="ignore"
							   value="${t_MYJK_SCJHPage.year}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							月份:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="month" name="month" ignore="ignore"
							   value="${t_MYJK_SCJHPage.month}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							产品代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemCode" name="itemCode" ignore="ignore"
							   value="${t_MYJK_SCJHPage.itemCode}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							产品中文名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemCname" name="itemCname" ignore="ignore"
							   value="${t_MYJK_SCJHPage.itemCname}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							产品英文名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="itemEname" name="itemEname" ignore="ignore"
							   value="${t_MYJK_SCJHPage.itemEname}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							工业区代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="factoryCode" name="factoryCode" ignore="ignore"
							   value="${t_MYJK_SCJHPage.factoryCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							工业区名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="factoryName" name="factoryName" ignore="ignore"
							   value="${t_MYJK_SCJHPage.factoryName}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							批复生产数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="launchCount" name="launchCount" ignore="ignore"
							   value="${t_MYJK_SCJHPage.launchCount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							批复生产重量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="launchWeight" name="launchWeight" ignore="ignore"
							   value="${t_MYJK_SCJHPage.launchWeight}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							套装方式:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="suitMode" name="suitMode" ignore="ignore"
							   value="${t_MYJK_SCJHPage.suitMode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							套装数量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="suitCount" name="suitCount" ignore="ignore"
							   value="${t_MYJK_SCJHPage.suitCount}" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							生产计划编制人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planPerson" name="planPerson" ignore="ignore"
							   value="${t_MYJK_SCJHPage.planPerson}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							生产计划编制日期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planCerateDate" name="planCerateDate" ignore="ignore"
							   value="${t_MYJK_SCJHPage.planCerateDate}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							计划下达日期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planLaunchDate" name="planLaunchDate" ignore="ignore"
							   value="${t_MYJK_SCJHPage.planLaunchDate}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							交付截止日期:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planDeliveryDate" name="planDeliveryDate" ignore="ignore"
							   value="${t_MYJK_SCJHPage.planDeliveryDate}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							销售机构代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="saleDept" name="saleDept" ignore="ignore"
							   value="${t_MYJK_SCJHPage.saleDept}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							销售机构名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="saleDeptName" name="saleDeptName" ignore="ignore"
							   value="${t_MYJK_SCJHPage.saleDeptName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							订货用户代码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orderUserNum" name="orderUserNum" ignore="ignore"
							   value="${t_MYJK_SCJHPage.orderUserNum}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							订货用户中文名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orderUserCname" name="orderUserCname" ignore="ignore"
							   value="${t_MYJK_SCJHPage.orderUserCname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							订货用户英文名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="orderUserEname" name="orderUserEname" ignore="ignore"
							   value="${t_MYJK_SCJHPage.orderUserEname}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							内防腐执行标准序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="liningStdSeq" name="liningStdSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.liningStdSeq}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							内防腐执行标准描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="liningStdDesc" name="liningStdDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.liningStdDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							内防腐终饰层厚度序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="liningTkSeq" name="liningTkSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.liningTkSeq}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							内防腐终饰层厚度描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="liningTkDesc" name="liningTkDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.liningTkDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							喷锌标准序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zincStdSeq" name="zincStdSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.zincStdSeq}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							喷锌标准描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="zincStdDesc" name="zincStdDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.zincStdDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							外防腐终饰层厚度序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="coatTkSeq" name="coatTkSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.coatTkSeq}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							外防腐终饰层厚度描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="coatTkDesc" name="coatTkDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.coatTkDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							外防腐执行标准序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="coatStdSeq" name="coatStdSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.coatStdSeq}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							外防腐执行标准描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="coatStdDesc" name="coatStdDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.coatStdDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							承口内部终饰层材料序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bellMaterialSeq" name="bellMaterialSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.bellMaterialSeq}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							承口内部终饰层材料描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bellMaterialDesc" name="bellMaterialDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.bellMaterialDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							承口内部终饰层厚度序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bellTkSeq" name="bellTkSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.bellTkSeq}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							承口内部终饰层厚度描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="bellTkDesc" name="bellTkDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.bellTkDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							插口端终饰层材料序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jackMaterialSeq" name="jackMaterialSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.jackMaterialSeq}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							插口端终饰层材料描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jackMaterialDesc" name="jackMaterialDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.jackMaterialDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							插口端终饰层厚度序码:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jackTkSeq" name="jackTkSeq" ignore="ignore"
							   value="${t_MYJK_SCJHPage.jackTkSeq}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							插口端终饰层厚度描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="jackTkDesc" name="jackTkDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.jackTkDesc}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							排产单号(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="schedulingNo" name="schedulingNo" ignore="ignore"
							   value="${t_MYJK_SCJHPage.schedulingNo}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申报单位代码(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="reportUserNum" name="reportUserNum" ignore="ignore"
							   value="${t_MYJK_SCJHPage.reportUserNum}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							申报单位中文名(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="reportUserCname" name="reportUserCname" ignore="ignore"
							   value="${t_MYJK_SCJHPage.reportUserCname}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							结算单位代码(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="settleUserNum" name="settleUserNum" ignore="ignore"
							   value="${t_MYJK_SCJHPage.settleUserNum}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							结算单位中文名(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="settleUserCname" name="settleUserCname" ignore="ignore"
							   value="${t_MYJK_SCJHPage.settleUserCname}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							申报时间(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="reportTime" name="reportTime" ignore="ignore"
							   value="${t_MYJK_SCJHPage.reportTime}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							最终销售地(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="saleGround" name="saleGround" ignore="ignore"
							   value="${t_MYJK_SCJHPage.saleGround}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							采购商(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="buyers" name="buyers" ignore="ignore"
							   value="${t_MYJK_SCJHPage.buyers}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							交货日期(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="deliveryDate" name="deliveryDate" ignore="ignore"
							   value="${t_MYJK_SCJHPage.deliveryDate}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							交货地点(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="deliveryPlace" name="deliveryPlace" ignore="ignore"
							   value="${t_MYJK_SCJHPage.deliveryPlace}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							运输方式代码(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trnpModeCode" name="trnpModeCode" ignore="ignore"
							   value="${t_MYJK_SCJHPage.trnpModeCode}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							运输方式描述(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trnpModeName" name="trnpModeName" ignore="ignore"
							   value="${t_MYJK_SCJHPage.trnpModeName}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							需求程度(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="requireLevel" name="requireLevel" ignore="ignore"
							   value="${t_MYJK_SCJHPage.requireLevel}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							技术要求(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="technicalDemand" name="technicalDemand" ignore="ignore"
							   value="${t_MYJK_SCJHPage.technicalDemand}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							包装要求(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="packingDemand" name="packingDemand" ignore="ignore"
							   value="${t_MYJK_SCJHPage.packingDemand}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							包装唛头(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shippingMark" name="shippingMark" ignore="ignore"
							   value="${t_MYJK_SCJHPage.shippingMark}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							运输唛头(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="trnpModeMark" name="trnpModeMark" ignore="ignore"
							   value="${t_MYJK_SCJHPage.trnpModeMark}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							质保书(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="millCertificate" name="millCertificate" ignore="ignore"
							   value="${t_MYJK_SCJHPage.millCertificate}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							商检(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inspection" name="inspection" ignore="ignore"
							   value="${t_MYJK_SCJHPage.inspection}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							排产单总金额(外销排产):
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="schedulingAmt" name="schedulingAmt" ignore="ignore"
							   value="${t_MYJK_SCJHPage.schedulingAmt}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							特殊合同描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="specialDesc" name="specialDesc" ignore="ignore"
							   value="${t_MYJK_SCJHPage.specialDesc}">
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
							   value="${t_MYJK_SCJHPage.remark}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							附件路径:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="annexPath" name="annexPath" ignore="ignore"
							   value="${t_MYJK_SCJHPage.annexPath}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							插入时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="insertDate" name="insertDate" ignore="ignore"
							     value="<fmt:formatDate value='${t_MYJK_SCJHPage.insertDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							生产单位:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="scdw" name="scdw" ignore="ignore"
							   value="${t_MYJK_SCJHPage.scdw}">
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
							   value="${t_MYJK_SCJHPage.shr}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							审核部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="shbm" name="shbm" ignore="ignore"
							   value="${t_MYJK_SCJHPage.shbm}">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							审核时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="shsj" name="shsj" ignore="ignore"
							     value="<fmt:formatDate value='${t_MYJK_SCJHPage.shsj}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							计划类型:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="planType" name="planType" ignore="ignore"
							   value="${t_MYJK_SCJHPage.planType}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							审核结果:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="auditresult" name="auditresult" ignore="ignore"
							   value="${t_MYJK_SCJHPage.auditresult}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>