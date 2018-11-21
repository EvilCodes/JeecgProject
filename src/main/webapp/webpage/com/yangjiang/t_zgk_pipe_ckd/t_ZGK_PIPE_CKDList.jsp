<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_CKDList" title="出库单主表" actionUrl="t_ZGK_PIPE_CKDController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="出库单号" field="chukudanid"   width="120"></t:dgCol>
   <t:dgCol title="规格" field="dn"   width="120"></t:dgCol>
   <t:dgCol title="批号全称" field="batchFull"   width="120"></t:dgCol>
   <t:dgCol title="管序号" field="pipeSerial"   width="120"></t:dgCol>
   <t:dgCol title="包号" field="packageid"   width="120"></t:dgCol>
   <t:dgCol title="生产计划号" field="productPlanNo"   width="120"></t:dgCol>
   <t:dgCol title="产品编码" field="itemCode"   width="120"></t:dgCol>
   <t:dgCol title="产品名称" field="itemCname"   width="120"></t:dgCol>
   <t:dgCol title="出口标识" field="expFlag"   width="120"></t:dgCol>
   <t:dgCol title="特殊合同描述" field="specialDesc"   width="120"></t:dgCol>
   <t:dgCol title="支数" field="pipenum"   width="120"></t:dgCol>
   <t:dgCol title="套装方式" field="suitWay"   width="120"></t:dgCol>
   <t:dgCol title="货位" field="huowei"   width="120"></t:dgCol>
   <t:dgCol title="层号" field="cengci"   width="120"></t:dgCol>
   <t:dgCol title="层内序码" field="cengneixuhao"   width="120"></t:dgCol>
   <t:dgCol title="生产线" field="productLine"   width="120"></t:dgCol>
   <t:dgCol title="发运计划单明细号" field="billLadingNoItem"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZGK_PIPE_CKDController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_CKDController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZGK_PIPE_CKDController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_PIPE_CKDController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>