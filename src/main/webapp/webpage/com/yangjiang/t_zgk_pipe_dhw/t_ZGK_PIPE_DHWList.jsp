<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_DHWList" title="倒货位" actionUrl="t_ZGK_PIPE_DHWController.do?datagrid" idField="id"  queryMode="group" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="日期" field="riqi" formatter="yyyy-MM-dd hh:mm:ss"  width="120" ></t:dgCol>
   <t:dgCol title="倒库单编号" field="daohuoweiid"   width="120"></t:dgCol>
   <t:dgCol title="管号" field="pipeCode"   width="120"></t:dgCol>
   <t:dgCol title="仓库名称" field="storeName"   width="120"></t:dgCol>
   <t:dgCol title="目标货位" field="afterHuowei"   width="120"></t:dgCol>
   <t:dgCol title="原层号" field="beforeCengci"   width="120"></t:dgCol>
   <t:dgCol title="原层内序号" field="beforeCengneixuhao"   width="120"></t:dgCol>
   <t:dgCol title="编辑人" field="edituser"   width="120"></t:dgCol>
   <t:dgCol title="编辑IP地址" field="editip"   width="120"></t:dgCol>
   <t:dgCol title="编辑时间" field="edittime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"  query="true"></t:dgCol>
   <t:dgCol title="原货位" field="beforeHuowei"   width="120"></t:dgCol>
   <t:dgCol title="目标层号" field="afterCengci"   width="120"></t:dgCol>
   <t:dgCol title="目标层内序号" field="afterCengneixuhao"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZGK_PIPE_DHWController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_DHWController.do?addorupdate" funname="add"></t:dgToolBar>
  
  </t:datagrid>
  </div>
 </div>
 <script>
 $(function(){
		$("#t_ZGK_PIPE_DHWList").find("input[name='edittime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
		$("input[name='edittime']").val(today);
	})
function today(){
 var today=new Date();
 var h=today.getFullYear();
 var m=today.getMonth()+1;
 var d=today.getDate();
 m= m<10?"0"+m:m;   //  这里判断月份是否<10,如果是在月份前面加'0'
 d= d<10?"0"+d:d;        //  这里判断日期是否<10,如果是在日期前面加'0'
 return h+"-"+m+"-"+d;
}
 </script>