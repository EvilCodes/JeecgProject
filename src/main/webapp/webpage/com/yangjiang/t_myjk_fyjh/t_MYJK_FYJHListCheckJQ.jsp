<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_MYJK_FYJHList" title="当日发运计划查询" actionUrl="t_MYJK_FYJHController.do?datagrid2" 
  idField="id" fit="true" queryMode="group" checkbox="true" >
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="接收日期" field="insertDate" formatter="yyyy-MM-dd hh:mm:ss"  query="true"></t:dgCol>
   <t:dgCol title="审核标记" field="auditflag"  ></t:dgCol>
   <t:dgCol title="主运号" field="carryNo"  ></t:dgCol>
   <t:dgCol title="发货通知单状态" field="planStatus" ></t:dgCol>
   <t:dgCol title="产品名称" field="itemCname"   ></t:dgCol>
   <t:dgCol title="计划件数" field="planNum"   ></t:dgCol>
   <t:dgCol title="计划重量" field="planWt"   ></t:dgCol>
   <t:dgCol title="内外销标志" field="expFlag"  ></t:dgCol>
   <t:dgCol title="合同号" field="contractNo"   ></t:dgCol>
   <t:dgCol title="合同子项号" field="orderNo"   ></t:dgCol>
   <t:dgCol title="批次号" field="schedulingNo"   ></t:dgCol>
   <t:dgCol title="交货日期" field="delivyDate"  ></t:dgCol>
   <t:dgCol title="交货地点代码" field="delivyPlaceCode"  hidden="true"></t:dgCol>
   <t:dgCol title="交货地点名称" field="delivyPlaceName"   ></t:dgCol>
   <t:dgCol title="专用线代码" field="privateRouteCode"  hidden="true"></t:dgCol>
   <t:dgCol title="专用线名称" field="privateRouteName" ></t:dgCol>
   <t:dgCol title="运输方式代码" field="trnpModeCode"   hidden="true"></t:dgCol>
   <t:dgCol title="运输方式名称" field="trnpMode"  ></t:dgCol>
   <t:dgCol title="发货组织机构代码" field="outOrgCode"   hidden="true"></t:dgCol>
   <t:dgCol title="发货组织机构名称" field="outOrgName" ></t:dgCol>
   <t:dgCol title="发货库房代码" field="outStorehouseCode"  hidden="true"></t:dgCol>
   <t:dgCol title="发货库房" field="outStorehouseName"   ></t:dgCol>
   <t:dgCol title="入库组织机构代码" field="inOrgCode"   hidden="true"></t:dgCol>
   <t:dgCol title="入库组织机构名称" field="inOrgName"   ></t:dgCol>
   <t:dgCol title="入库仓库代码" field="inWhouseCode"  hidden="true"></t:dgCol>
   <t:dgCol title="入库仓库名称" field="inWhouseName"   ></t:dgCol>
   <t:dgCol title="收货地点" field="recAdd"  ></t:dgCol>
   <t:dgCol title="收货联系人" field="recPerson"   ></t:dgCol>
   <t:dgCol title="收货人联系电话" field="recTel"   ></t:dgCol>
   <t:dgCol title="销售公司" field="orgName"   ></t:dgCol>
   <t:dgCol title="收货单位名称" field="consignCname"  ></t:dgCol>
   <t:dgCol title="销售人员名称" field="salePersonName"   ></t:dgCol>
   <t:dgCol title="销售人员电话" field="mobilePhone"   ></t:dgCol>
   <t:dgCol title="备注" field="remark"   ></t:dgCol>
   <t:dgCol title="套装要求" field="suitFlag"   ></t:dgCol>
   <t:dgCol title="产品编码" field="itemCode"   ></t:dgCol>
   <t:dgCol title="包装方式" field="packageWay"   ></t:dgCol>
   <t:dgCol title="特殊合同描述 " field="specialDesc"  ></t:dgCol>
   <t:dgCol title="胶圈指定生产厂代码" field="itemFactoryCode"   hidden="true"></t:dgCol>
   <t:dgCol title="胶圈指定生产厂名称" field="itemFactoryName"   ></t:dgCol>
   <t:dgCol title="读取标识" field="readFlag"   ></t:dgCol>   
   <t:dgCol title="更新标识" field="updateflag"   ></t:dgCol>   
   <t:dgCol title="总发运数量" field="totaltransportnum"  ></t:dgCol>
   <t:dgCol title="总发运重量" field="totaltransportwt"  ></t:dgCol>  
   <t:dgCol title="发货通知单号" field="billNoticeNo"   ></t:dgCol>
   <t:dgCol title="发货通知单明细号" field="billLadingNoItem" ></t:dgCol>
   
           
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 
 	$(function(){
 		$("#t_MYJK_FYJHListtb").find("input[name='insertDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		$("input[name='insertDate']").val(today);
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
 
 