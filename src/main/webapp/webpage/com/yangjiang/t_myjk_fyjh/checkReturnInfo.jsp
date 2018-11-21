<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  
  <t:datagrid name="t_MYJK_FYJHList" title="贸易接口自动数据发送结果查询" actionUrl="CheckReturnInfo.do?datagrid" 
  idField="id" fit="true" queryMode="group" checkbox="true" >
   <t:dgCol title="编号" field="ID" hidden="true"></t:dgCol>
   <t:dgCol title="发货通知单号" field="接口代码"   ></t:dgCol>
   <t:dgCol title="发货通知单明细号" field="接口名称" ></t:dgCol>
   <t:dgCol title="接收日期" field="riqi" formatter="yyyy-MM-dd"  query="true"></t:dgCol>
   <t:dgCol title="发货通知单状态" field="返回信息" ></t:dgCol>
   <t:dgCol title="产品名称" field="返回标识"   ></t:dgCol>          
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 
 	$(function(){
 		$("#t_MYJK_FYJHListtb").find("input[name='riqi']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
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
 
 