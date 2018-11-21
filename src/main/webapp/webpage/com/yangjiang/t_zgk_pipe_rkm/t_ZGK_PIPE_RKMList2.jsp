<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_RKMList" title="管材入库主表信息111" actionUrl="t_ZGK_PIPE_RKMController.do?datagrid" idField="rukudanid"  sortName="riqi" sortOrder="desc" 
  fit="true" queryMode="group">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="入库单编号" field="rukudanid"   width="120" query="true"></t:dgCol>
   <t:dgCol title="日期" field="riqi" formatter="yyyy-MM-dd"  width="120" query="true" ></t:dgCol>
   <t:dgCol title="管库名称" field="storeName"   width="120" ></t:dgCol>
   <t:dgCol title="保管员" field="baoguanyuan"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="addpipecode(rukudanid,id)" title="添加管号" urlStyle="color:red"></t:dgFunOpt>
   <t:dgFunOpt funname="checkpipecode(rukudanid)" title="查看已添加管号"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_RKMController.do?addorupdate2" funname="add"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_PIPE_RKMController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">

function addpipecode(rukudanid,id) {
	//1.$.ajax带json数据的异步请求
	createwindow("添加入库管号", "t_ZGK_PIPE_RKDController.do?addorupdate2&rukudanid="+rukudanid+"&id="+id,1400,800);	
}
function checkpipecode(rukudanid) {
	//1.$.ajax带json数据的异步请求
	createwindow("查看已入库数据 ", "t_ZGK_PIPE_RKMController.do?list4&rukudanid="+rukudanid,1100,800);	
}
$(function(){
	$("#t_ZGK_PIPE_RKMListtb").find("input[name='riqi']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='riqi']").val(today);
});
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