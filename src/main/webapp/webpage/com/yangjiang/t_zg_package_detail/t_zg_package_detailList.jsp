<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_zg_package_detailList" title="打包子表" actionUrl="t_zg_package_detailController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="包号" field="packid"   width="120"></t:dgCol>
   <t:dgCol title="批号全称" field="batchfull"   width="120"></t:dgCol>
   <t:dgCol title="规格" field="dn"   width="120"></t:dgCol>
   <t:dgCol title="产品代码" field="itemcode"   width="120"></t:dgCol>
   <t:dgCol title="产品名称" field="itemcname"   width="120"></t:dgCol>
   <t:dgCol title="生产计划号" field="productplanno"   width="120"></t:dgCol>
   <t:dgCol title="管号" field="pipecode"   width="120"></t:dgCol>
   <t:dgCol title="批支数" field="pipenum"   width="120"></t:dgCol>
   <t:dgCol title="特殊合同描述" field="special"   width="120"></t:dgCol>
   <t:dgCol title="pipeserial" field="pipeserial"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_zg_package_detailController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_zg_package_detailController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_zg_package_detailController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_zg_package_detailController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>