<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="asysUserList" checkbox="true" fitColumns="false" title="大系统用户信息" actionUrl="asysUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="userId"  field="userId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="loginname"  field="loginname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="loginpwd"  field="loginpwd"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="fullname"  field="fullname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="email"  field="email"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="phone"  field="phone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="enabled"  field="enabled"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="pwderrorcount"  field="pwderrorcount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="logincount"  field="logincount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="registertime"  field="registertime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="lastlogintime"  field="lastlogintime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="identitycode"  field="identitycode"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="createid"  field="createid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="createby"  field="createby"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="createtime"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="modifyid"  field="modifyid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="modifyby"  field="modifyby"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="modifytime"  field="modifytime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="isdeleted"  field="isdeleted"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="displayname"  field="displayname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="danwei"  field="danwei"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="bumen"  field="bumen"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="danweiid"  field="danweiid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="bumenid"  field="bumenid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="asysUserController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="asysUserController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="asysUserController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="asysUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="asysUserController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/yangjiang/asysuser/asysUserList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#asysUserListtb").find("input[name='registertime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='registertime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='lastlogintime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='lastlogintime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='modifytime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#asysUserListtb").find("input[name='modifytime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'asysUserController.do?upload', "asysUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("asysUserController.do?exportXls","asysUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("asysUserController.do?exportXlsByT","asysUserList");
}
 </script>