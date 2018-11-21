<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_KC_LS_FLAGList" title="结转标志" actionUrl="t_ZGK_PIPE_KC_LS_FLAGController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="结算日前" field="riqi" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称" field="storeName"   width="120"></t:dgCol>
   <t:dgCol title="结算标志" field="flag"   width="120"></t:dgCol>
   <t:dgCol title="结算人" field="jiesuanRen"   width="120"></t:dgCol>
   <t:dgCol title="结算IP地址" field="jiesuanIp"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZGK_PIPE_KC_LS_FLAGController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_KC_LS_FLAGController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZGK_PIPE_KC_LS_FLAGController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_PIPE_KC_LS_FLAGController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>