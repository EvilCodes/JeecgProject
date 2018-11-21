<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_FYJH_PCDList" title="汽车派车单" actionUrl="t_ZGK_FYJH_PCDController.do?datagrid2" queryMode="group" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
    <t:dgCol title="是否已使用 " field="ifzc" replace="是_1,否_0" style="background:red;_1"></t:dgCol>
   <t:dgCol title="派车单" field="sendCarNo"   query="true"></t:dgCol>
   <t:dgCol title="派车单明细序号" field="number" hidden="true"></t:dgCol>
   <t:dgCol title="运号" field="carryNo"  hidden="true"></t:dgCol>
   <t:dgCol title="发货通知单号" field="billNoticeNo"  query="true"></t:dgCol>
   <t:dgCol title="发货通知单明细号" field="billNoticeNoItem"   ></t:dgCol>
   <t:dgCol title="产品代码" field="itemCode"></t:dgCol>
   <t:dgCol title="产品名称" field="itemName"  ></t:dgCol>
   <t:dgCol title="库房代码" field="outStorehouseCode"   hidden="true"></t:dgCol>
   <t:dgCol title="库房名称" field="outStorehouseName"   ></t:dgCol>
   <t:dgCol title="承运商代码" field="carryCompanyCode"  hidden="true"></t:dgCol>
   <t:dgCol title="承运商名称" field="carryCompanyName"  ></t:dgCol>
   <t:dgCol title="承运数量" field="carryNum"   ></t:dgCol>
   <t:dgCol title="承运重量" field="carryWt"  ></t:dgCol>
   <t:dgCol title="运输方式名称" field="trnpMode"   ></t:dgCol>
   <t:dgCol title="车牌号" field="carNo"   query="true"></t:dgCol>
   <t:dgCol title="司机姓名" field="driverName"  ></t:dgCol>
   <t:dgCol title="司机电话" field="driverTel"  ></t:dgCol>
   <t:dgCol title="司机身份证号" field="idNumber"   ></t:dgCol>
   <t:dgCol title="状态标记" field="delFlag"   ></t:dgCol>
   <t:dgCol title="修改人" field="edituser"  ></t:dgCol>
   <t:dgCol title="修改IP" field="editip"  ></t:dgCol>
   <t:dgCol title="时间" field="edittime" formatter="yyyy-MM-dd hh:mm:ss" query="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" ></t:dgCol>
   <t:dgDelOpt title="删除" url="t_ZGK_FYJH_PCDController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_FYJH_PCDController.do?addorupdate2" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZGK_FYJH_PCDController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_FYJH_PCDController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script>
 $(function(){
		$("#t_ZGK_FYJH_PCDListtb").find("input[name='edittime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
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