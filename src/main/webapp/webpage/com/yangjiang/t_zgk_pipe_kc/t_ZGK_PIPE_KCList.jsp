<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_KCList" title="管子库存" actionUrl="t_ZGK_PIPE_KCController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="storeName" field="storeName"   width="120"></t:dgCol>
   <t:dgCol title="dn" field="dn"   width="120"></t:dgCol>
   <t:dgCol title="batchFull" field="batchFull"   width="120"></t:dgCol>
   <t:dgCol title="pipeSerial" field="pipeSerial"   width="120"></t:dgCol>
   <t:dgCol title="packageid" field="packageid"   width="120"></t:dgCol>
   <t:dgCol title="productPlanNo" field="productPlanNo"   width="120"></t:dgCol>
   <t:dgCol title="itemCode" field="itemCode"   width="120"></t:dgCol>
   <t:dgCol title="itemCname" field="itemCname"   width="120"></t:dgCol>
   <t:dgCol title="expFlag" field="expFlag"   width="120"></t:dgCol>
   <t:dgCol title="specialDesc" field="specialDesc"   width="120"></t:dgCol>
   <t:dgCol title="pipenum" field="pipenum"   width="120"></t:dgCol>
   <t:dgCol title="suitWay" field="suitWay"   width="120"></t:dgCol>
   <t:dgCol title="huowei" field="huowei"   width="120"></t:dgCol>
   <t:dgCol title="cengci" field="cengci"   width="120"></t:dgCol>
   <t:dgCol title="cengneixuhao" field="cengneixuhao"   width="120"></t:dgCol>
   <t:dgCol title="productLine" field="productLine"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZGK_PIPE_KCController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_KCController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZGK_PIPE_KCController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_PIPE_KCController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>