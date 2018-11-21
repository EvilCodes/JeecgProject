<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<form id="yearMonth">
<table>
<tr><span>年:</span><input type="text" name="plan_year" id="plan_year" ></tr>
<tr><span>月:</span><input type="text" name="plan_month" id="plan_month"></tr>
<tr><span style="font-size: 16;color: red">注释：如果需要修改年份和月份请输入您想修改的年份和月份，格式:年四位数字；月份两位数字</span></tr>
</table>
</form>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>	
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px;height: 1600">
  <t:datagrid name="t_MYJK_FYJHList" title="发运计划审核 注：默认打开就是当日最新计划" actionUrl="t_MYJK_FYJHController.do?dataGrid"
   idField="id" fit="true" checkbox="true"  singleSelect="false"  queryMode="group" pagination="true" pageSize="14">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="插入日期" field="insertDate" formatter="yyyy-MM-dd hh:mm:ss"  query="true"></t:dgCol>
   <t:dgCol title="发货通知单状态" field="planStatus"  query="true" ></t:dgCol>
   <t:dgCol title="产品名称" field="itemCname"   ></t:dgCol>
   <t:dgCol title="计划件数" field="planNum"   ></t:dgCol>
   <t:dgCol title="计划重量" field="planWt"   ></t:dgCol>
   <t:dgCol title="内外销标志" field="expFlag"  query="true"></t:dgCol>
   <t:dgCol title="合同号" field="contractNo"   hidden="true"></t:dgCol>
   <t:dgCol title="合同子项号" field="orderNo"   hidden="true"></t:dgCol>
   <t:dgCol title="批次号" field="schedulingNo"   hidden="true"></t:dgCol>
   <t:dgCol title="交货日期" field="delivyDate"  ></t:dgCol>
   <t:dgCol title="交货地点代码" field="delivyPlaceCode"   hidden="true"></t:dgCol>
   <t:dgCol title="交货地点名称" field="delivyPlaceName"   ></t:dgCol>
   <t:dgCol title="专用线代码" field="privateRouteCode"   hidden="true"></t:dgCol>
   <t:dgCol title="专用线名称" field="privateRouteName" ></t:dgCol>
   <t:dgCol title="运输方式代码" field="trnpModeCode"   hidden="true"></t:dgCol>
   <t:dgCol title="运输方式名称" field="trnpMode"  query="true"></t:dgCol>
   <t:dgCol title="发货组织机构代码" field="outOrgCode"   hidden="true"></t:dgCol>
   <t:dgCol title="发货组织机构名称" field="outOrgName" ></t:dgCol>
   <t:dgCol title="发货库房代码" field="outStorehouseCode"   hidden="true"></t:dgCol>
   <t:dgCol title="发货库房" field="outStorehouseName"   ></t:dgCol>
   <t:dgCol title="入库组织机构代码" field="inOrgCode"   hidden="true"></t:dgCol>
   <t:dgCol title="入库组织机构名称" field="inOrgName"   ></t:dgCol>
   <t:dgCol title="入库仓库代码" field="inWhouseCode"  ></t:dgCol>
   <t:dgCol title="入库仓库名称" field="inWhouseName"   ></t:dgCol>
   <t:dgCol title="收货地点" field="recAdd"  query="true"></t:dgCol>
   <t:dgCol title="收货联系人" field="recPerson"   ></t:dgCol>
   <t:dgCol title="收货人联系电话" field="recTel"   ></t:dgCol>
   <t:dgCol title="销售公司" field="orgName"   query="true"></t:dgCol>
   <t:dgCol title="收货单位名称" field="consignCname"  ></t:dgCol>
   <t:dgCol title="销售人员名称" field="salePersonName"   ></t:dgCol>
   <t:dgCol title="销售人员电话" field="mobilePhone"   ></t:dgCol>
   <t:dgCol title="备注" field="remark"   ></t:dgCol>
   <t:dgCol title="套装要求" field="suitFlag"   ></t:dgCol>
   <t:dgCol title="产品编码" field="itemCode"   hidden="true"></t:dgCol>
   <t:dgCol title="包装方式" field="packageWay"   ></t:dgCol>
   <t:dgCol title="特殊合同描述 " field="specialDesc"  ></t:dgCol>
   <t:dgCol title="胶圈指定生产厂代码" field="itemFactoryCode"  hidden="true" ></t:dgCol>
   <t:dgCol title="胶圈指定生产厂名称" field="itemFactoryName"   hidden="true"></t:dgCol>
   <t:dgCol title="读取标识" field="readFlag"   hidden="true"></t:dgCol>   
   <t:dgCol title="更新标识" field="updateflag"  hidden="true" ></t:dgCol>   
   <t:dgCol title="总发运数量" field="totaltransportnum"  hidden="true"></t:dgCol>
   <t:dgCol title="总发运重量" field="totaltransportwt"   hidden="true"></t:dgCol>  
   <t:dgCol title="发货通知单号" field="billNoticeNo"   ></t:dgCol>
   <t:dgCol title="发货通知单明细号" field="billLadingNoItem" ></t:dgCol>
   <t:dgToolBar title="审核" icon="icon-edit" url="t_MYJK_FYJHController.do?addorupdate"  funname="update"  onclick="addParam()"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_MYJK_FYJHController.do?addorupdate" funname="detail" ></t:dgToolBar>
  </t:datagrid>
  </div>
  
  </div>
 
 <script type="text/javascript">
 
$(document).ready(function(){		
	$("#insertDate").attr("class","Wdate").click(function(){Wdate({dateFmt:'yyyy-MM-dd 00:00:00'})});
	
	/**
	var cur_date=new Date();
	var year=cur_date.getFullYear();
	var month=cur_date.getMonth()+1;
	var sdate=cur_date.getDate();
	if(sdate.length=1){
		c_date=year.toString()+"-"+month.toString()+"-"+sdate.toString()+" 00:00:00";
	}else if(sdate.length=2) {
		c_date=year.toString()+"-"+month.toString()+"-"+sdate.toString()+" 00:00:00";
	}	
	//console.info(month);
	$("input[name='insertDate']").val(c_date);
	$("#plan_year").val(year);
	$("#plan_month").val(month);
	//将年和月（用户输入的年月）添加到datagrid参数里
	var queryParams = $('#t_MYJK_FYJHList').datagrid('options').queryParams; 
	queryParams.plan_year=$("#plan_year").val();  
	queryParams.plan_month=$("#plan_month").val(); 
	$('#t_MYJK_FYJHList').datagrid('options').queryParams=queryParams;
	$("#t_MYJK_FYJHList").datagrid("load", queryParams);
	**/
	
	$("#t_MYJK_FYJHListForm").prepend("<span style='margin:0 5px;'>月</span><input onkeypress='EnterPress(event)' onkeydown='EnterPress()' type='text' name='plan_month' class='inuptxt' style='width: 100px;margin-buttom:5px;'>")
	$("#t_MYJK_FYJHListForm").prepend("<span style='margin:0 5px;'>年</span><input onkeypress='EnterPress(event)' onkeydown='EnterPress()' type='text' name='plan_year' class='inuptxt' style='width: 100px;margin-buttom:5px;'>")
	
	//plan_year=$("#plan_year").val();
	//plan_month=$("#plan_month").val();
	
});
function addParam(){
	//alert("1111111");
	var url = "t_MYJK_FYJHController.do?addorupdate&plan_year="+$("#plan_year").val()+"&plan_month="+$("#plan_month").val();
	update('审核',url,'t_MYJK_FYJHList',null,null);
}
	//将表单数据转为json
    function form2Json(id) {

        var arr = $("#" + id).serializeArray()
        var jsonStr = "";

        jsonStr += '{';
        for (var i = 0; i < arr.length; i++) {
            jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
        }
        jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
        jsonStr += '}'

        var json = JSON.parse(jsonStr)
        return json
    }
</script>