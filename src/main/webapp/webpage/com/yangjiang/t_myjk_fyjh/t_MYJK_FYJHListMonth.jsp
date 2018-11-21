<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <style>
#main {
	
}


#south {
	
	padding: 0px;
	width: 60%,
}

#left {
	border: 1px;
	width: 30%,
}
</style>
  <title>铸管库入库单</title>
  <script type="text/javascript" charset="utf-8">
	/*
	 *	excel导出
	 */
	function courseListExportXls() {
	//	JeecgExcelExport("CheckFYJHController.do?exportXls","t_MYJK_FYJHList");
	}
	
	
</script>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 <script type="text/javascript">
 function formatDatebox(value) {  
	    if (value == null || value == '') {  
	        return '';  
	    }  
	    var dt;  
	    if (value instanceof Date) {  
	        dt = value;  
	    } else {  
	        dt = new Date(value);  
	    }  
	  
	    return dt.format("yyyy-MM-dd"); //扩展的Date的format方法(上述插件实现)  
	}  
 
 	$(function(){ 
 		$("#searchForm").find("input[name='startDate']").attr("class","Wdate").attr("style","height:20px;width:120px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		$("#searchForm").find("input[name='endDate']").attr("class","Wdate").attr("style","height:20px;width:120px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		var today=new Date();
 		var cur_year=today.getFullYear();
 		//alert(cur_year);
 		var pre_month=today.getMonth();
 		//alert(pre_month);
 		var end=today.format('yyyy-MM-dd');
 		var firstdate=getLastMonthThreeDay(cur_year,pre_month); 
 		if(firstdate<10){
 			firstdate="0"+firstdate;
 		}
 		//alert(cur_year+"-"+pre_month+"-"+firstdate);		
 		//var start=firstdate.format('yyyy-MM-dd')
 		$("input[name='startDate']").val(cur_year+"-"+pre_month+"-"+firstdate);
 		
 		$("input[name='endDate']").val(end);
 		
 		
 	});
 	function getCurrentMonthFirst(){
	 var date=new Date();
	 date.setDate(1);
	 return date;
	};
 	function today(){
	    var today=new Date();
	    var h=today.getFullYear();
	    var m=today.getMonth()+1;
	    var d=today.getDate();
	    m= m<10?"0"+m:m;   //  这里判断月份是否<10,如果是在月份前面加'0'
	    d= d<10?"0"+d:d;        //  这里判断日期是否<10,如果是在日期前面加'0'
	    return h+"-"+m+"-"+d;
	};	
	function checkorder() {		
			//alert("1111");	
			var data = $("#searchForm").parseForm();						
			$("#t_MYJK_FYJHList").datagrid("reload", data);
	};
	(function($){
			$.fn.parseForm = function() {
				var serializeObj = {};
				var array = this.serializeArray();
				var str = this.serialize();
				$(array)
						.each(
								function() {
									if (serializeObj[this.name]) {
										if ($.isArray(serializeObj[this.name])) {
											serializeObj[this.name]
													.push(this.value);
										} else {
											serializeObj[this.name] = [
													serializeObj[this.name],
													this.value ];
										}
									} else {
										serializeObj[this.name] = this.value;
									}
								});
				return serializeObj;
			};
			//扩展jquery的格式化方法
		})(jQuery);	
	Date.prototype.format = function(format){ 
	var o = { 
	"M+" : this.getMonth()+1, //month 
	"d+" : this.getDate(), //day 
	"h+" : this.getHours(), //hour 
	"m+" : this.getMinutes(), //minute 
	"s+" : this.getSeconds(), //second 
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
	"S" : this.getMilliseconds() //millisecond 
	} 
	
	if(/(y+)/.test(format)) { 
	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 
	
	for(var k in o) { 
	if(new RegExp("("+ k +")").test(format)) { 
	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	} 
	} 
	return format; 
	
} ;

	function getLastMonthThreeDay(year,month)   
	{   
	 var new_year = year;  //取当前的年份   
	 var new_month = month;//取下一个月的第一天，方便计算（最后一天不固定）   
	 if(month>12)      //如果当前大于12月，则年份转到下一年   
	 {   
	 new_month -=12;    //月份减   
	 new_year++;      //年份增   
	 }   
	 var new_date = new Date(new_year,new_month,1);        //取当年当月中的第一天   
	 return (new Date(new_date.getTime()-1000*60*60*24*4)).getDate();//获取当月最后一天日期   
	}   
	  
			 	 	 
 </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">

		<div id="main">
			<div  id="south">
				<div id="left">
					<form action="" id="searchForm">
		<table style="width: 50%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 开始日期: </label>
				</td>
				<td class="value"><input class="Wdate" id="startDate" name="startDate"
					ignore="ignore" datatype="*">
				</td>
				<td align="right"><label class="Validform_label"> 结束日期: </label>
				</td>
				<td class="value"><input class="Wdate" id="endDate"
					name="endDate" ignore="ignore" datatype="*"> 
				</td>
				<td align="right"><label class="Validform_label"> 规格: </label>
				</td>
				<td class="value"><t:dictSelect field="dn" type="select"
						datatype="*" dictTable="t_zg_code_pipe_dn" dictField="dn"
						dictText="dn" id="pipetype"></t:dictSelect> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 发货通知单号: </label></td>
					<td class="value"><input class="inputxt" id="BILL_NOTICE_NO"
					name="BILL_NOTICE_NO" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span></td>
				<td><input type="button" name="查询" onclick="checkorder()"
					value="查询" style="font-size: 14 ">
				</td>
				</tr>																
		</table>
	</form>
				</div>
				<div id="right">
					<div style=" height: 500px;" align="left">
					<t:datagrid name="t_MYJK_FYJHList" title="铸管发运计划明细查询" actionUrl="CheckFYJHController.do?CheckFYJHMonthDataGrid" 
  idField="发货通知单明细号" queryMode="group" checkbox="true" pagination="true">   
   <t:dgCol title="发货通知单号" field="发货通知单号" ></t:dgCol>
   <t:dgCol title="发货通知单明细号" field="发货通知单明细号"  ></t:dgCol>
   <t:dgCol title="交货日期" field="交货日期"  ></t:dgCol>
   <t:dgCol title="交货地点名称" field="交货地点名称" ></t:dgCol>
   <t:dgCol title="计划件数" field="计划件数" ></t:dgCol>
   <t:dgCol title="计划重量" field="计划重量"></t:dgCol>   
   <t:dgCol title="专用线名称" field="专用线名称"></t:dgCol>
   <t:dgCol title="运输方式名称" field="运输方式名称"  ></t:dgCol>
   <t:dgCol title="发货库房代码" field="发货库房代码"  hidden="true"></t:dgCol>
   <t:dgCol title="发货库房名称" field="发货库房名称" ></t:dgCol>
   <t:dgCol title="收货地点" field="收货地点"></t:dgCol>
   <t:dgCol title="物料代码" field="物料代码"  hidden="true"></t:dgCol>
   <t:dgCol title="产品代码" field="产品代码"  hidden="true"></t:dgCol>
   <t:dgCol title="产品" field="产品" ></t:dgCol>
   <t:dgCol title="品种代码" field="品种代码" hidden="true"></t:dgCol>
   <t:dgCol title="品种" field="品种"  ></t:dgCol>
   <t:dgCol title="技术标准序码" field="技术标准序码"  hidden="true"></t:dgCol>
   <t:dgCol title="技术标准" field="技术标准" ></t:dgCol>
   <t:dgCol title="规格序码" field="规格序码" hidden="true"></t:dgCol>
   <t:dgCol title="规格" field="规格"  ></t:dgCol>
   <t:dgCol title="接口序码" field="接口序码"  hidden="true"></t:dgCol>
   <t:dgCol title="接口" field="接口" ></t:dgCol>
   <t:dgCol title="等级序码" field="等级序码" hidden="true"></t:dgCol>
   <t:dgCol title="等级" field="等级"  ></t:dgCol>
   <t:dgCol title="长度序码" field="长度序码"  hidden="true"></t:dgCol>
   <t:dgCol title="长度" field="长度" ></t:dgCol>
   <t:dgCol title="内防腐序码" field="内防腐序码" hidden="true"></t:dgCol>
   <t:dgCol title="内防腐" field="内防腐"  ></t:dgCol>
   <t:dgCol title="锌层厚度序码" field="锌层厚度序码"  hidden="true"></t:dgCol>
   <t:dgCol title="锌层厚度" field="锌层厚度" ></t:dgCol>
   <t:dgCol title="外防腐序码" field="外防腐序码" hidden="true"></t:dgCol>
   <t:dgCol title="外防腐" field="外防腐"  ></t:dgCol>
   <t:dgCol title="物料名称" field="物料名称"  ></t:dgCol>
   
   <t:dgCol title="发货组织机构代码" field="发货组织机构代码"  hidden="true"></t:dgCol>
   <t:dgCol title="发货组织机构名称" field="发货组织机构名称"  ></t:dgCol>
   <t:dgCol title="专用线代码" field="专用线代码" hidden="true"></t:dgCol>
   <t:dgCol title="合同号" field="合同号"></t:dgCol>
   <t:dgCol title="合同子项号" field="合同子项号"  ></t:dgCol>
   <t:dgCol title="接口序码" field="接口序码"  hidden="true"></t:dgCol>
   <t:dgCol title="特殊合同描述" field="特殊合同描述" ></t:dgCol>
   <t:dgCol title="销售公司" field="销售公司"></t:dgCol>
   <t:dgCol title="收货单位" field="收货单位"  ></t:dgCol>
   <t:dgCol title="下达时间" field="下达时间" formatterjs='formatDatebox'></t:dgCol>
   <t:dgCol title="收货人" field="收货人" ></t:dgCol> 
   
   <t:dgCol title="收货电话" field="收货电话"  ></t:dgCol>
   <t:dgCol title="销售人员" field="销售人员"  ></t:dgCol>
   <t:dgCol title="手机" field="手机" ></t:dgCol>
   <t:dgCol title="计划状态" field="计划状态"></t:dgCol>
   <t:dgCol title="备注" field="备注"  ></t:dgCol>
   <t:dgCol title="更新标识" field="更新标识"  ></t:dgCol>
   <t:dgCol title="内外销标识" field="内外销标识" ></t:dgCol>   
   <t:dgToolBar title="导出Excel" icon="icon-search" onclick="courseListExportXls();"></t:dgToolBar>       
  </t:datagrid>
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>