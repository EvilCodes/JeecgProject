<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">

  <div region="center" style="padding:0px;border:0px">  
  <t:datagrid name="t_zg_batchList" title="批号" actionUrl="t_zg_batchController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="规格" field="dn"   width="120"></t:dgCol>
   <t:dgCol title="批号全称" field="batchFull"   width="120"></t:dgCol>
   <t:dgCol title="年份" field="pYear"   width="120" query="true"></t:dgCol>
   <t:dgCol title="批号" field="batch"   width="120" query="true"></t:dgCol>   
   <t:dgCol title="接口方式" field="interfaceDesc"   width="120"></t:dgCol>
   <t:dgCol title="壁厚等级" field="grade"   width="120"></t:dgCol>
   <t:dgCol title="长度" field="length"   width="120"></t:dgCol>      
   
   
   <t:dgToolBar title="录入" icon="icon-add" url="t_zg_batchController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_zg_batchController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_zg_batchController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
$(document).ready(function(){
	  
	  $("input[name='productDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	  $("input[name='productDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});;
 
});
</script>