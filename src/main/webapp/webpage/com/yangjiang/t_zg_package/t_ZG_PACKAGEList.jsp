<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZG_PACKAGEList" title="二铸管打包" actionUrl="t_ZG_PACKAGEController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="包号" field="packid" ></t:dgCol>
   <t:dgCol title="包支数" field="pipecount"></t:dgCol>
   <t:dgCol title="批次" field="batchfull"></t:dgCol>
   <t:dgCol title="规格" field="dn"   ></t:dgCol>
   <t:dgCol title="产品名称" field="itemname"></t:dgCol>
   <t:dgCol title="打包时间" field="addtime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="rccode" field="rccode"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="计划号" field="jihuahao"   ></t:dgCol>
   <t:dgCol title="入库单号" field="rukudanid"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="检验人" field="checkuser"   ></t:dgCol>
   <t:dgCol title="打包人" field="packuser"  ></t:dgCol>
   <t:dgCol title="transuser" field="transuser"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="备注" field="remark"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="维护人" field="edituser"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="维护时间" field="edittime" formatter="yyyy-MM-dd hh:mm:ss"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="维护IP" field="editip"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="线别" field="xianbie"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="标识" field="flag"   width="120" ></t:dgCol>
   <t:dgCol title="工作组" field="workgroup"   width="120"></t:dgCol>
   <t:dgCol title="是否打印" field="isprint"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="op" field="op"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="操作时间" field="optime" formatter="yyyy-MM-dd hh:mm:ss"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZG_PACKAGEController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZG_PACKAGEController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZG_PACKAGEController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZG_PACKAGEController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>