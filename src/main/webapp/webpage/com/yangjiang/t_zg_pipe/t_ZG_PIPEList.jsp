<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZG_PIPEList" title="铸管部入库详单" actionUrl="t_ZG_PIPEController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="管号" field="pipeCode"   width="120"></t:dgCol>
   <t:dgCol title="规格" field="dn"   width="120"></t:dgCol>
   <t:dgCol title="年份" field="pYear"   width="120"></t:dgCol>
   <t:dgCol title="批号" field="batch"   width="120"></t:dgCol>
   <t:dgCol title="批号全文" field="batchFull"   width="120"></t:dgCol>
   <t:dgCol title="管序号" field="pipeSerial"   width="120"></t:dgCol>
   <t:dgCol title="生成计划号" field="productPlanNo"   width="120"></t:dgCol>
   <t:dgCol title="产品编码" field="itemCode"   width="120"></t:dgCol>
   <t:dgCol title="产品中文名称" field="itemCname"   width="120"></t:dgCol>
   <t:dgCol title="标志" field="expFlag"   width="120"></t:dgCol>
   <t:dgCol title="特殊合同描述" field="specialDesc"   width="120"></t:dgCol>
   <t:dgCol title="包号" field="packageid"   width="120"></t:dgCol>
   <t:dgCol title="数量" field="pipenum"   width="120"></t:dgCol>
   <t:dgCol title="入库单编号" field="mainId"   width="120"></t:dgCol>
   <t:dgCol title="二维码" field="qrcode"   width="120"></t:dgCol>
   <t:dgCol title="效验码" field="rccode"   width="120"></t:dgCol>
   <t:dgCol title="标志" field="flag"   width="120"></t:dgCol>
   <t:dgCol title="生产线" field="productLine"   width="120"></t:dgCol>
   <t:dgCol title="编辑人" field="edituser"   width="120"></t:dgCol>
   <t:dgCol title="编辑IP地址" field="editip"   width="120"></t:dgCol>
   <t:dgCol title="编辑时间" field="edittime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZG_PIPEController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZG_PIPEController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZG_PIPEController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZG_PIPEController.do?addorupdate&main_ID={id}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
