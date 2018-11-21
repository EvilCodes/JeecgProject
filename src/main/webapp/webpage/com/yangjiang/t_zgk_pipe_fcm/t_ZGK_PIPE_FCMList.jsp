<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_FCMList" title="返厂主表" actionUrl="t_ZGK_PIPE_FCMController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="返厂单号" field="fankudanid"   width="120"></t:dgCol>
   <t:dgCol title="日期" field="riqi" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称" field="storeName"   width="120"></t:dgCol>
   <t:dgCol title="保管员" field="baoguanyuan"   width="120"></t:dgCol>
   <t:dgCol title="承运公司编码" field="carryCompanyCode"   width="120"></t:dgCol>
   <t:dgCol title="承运公司" field="carryCompanyName"   width="120"></t:dgCol>
   <t:dgCol title="运输方式" field="trnpMode"   width="120"></t:dgCol>
   <t:dgCol title="车号" field="carNo"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="addpipecode(fankudanid)" title="添加管号"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_FCMController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZGK_PIPE_FCMController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_PIPE_FCMController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
function addpipecode(fankudanid) {
	//1.$.ajax带json数据的异步请求
	createwindow("添加入库管号", "t_ZGK_PIPE_FCDController.do?addorupdate&fankudanid="+fankudanid,1400,800);	
}
 </script>