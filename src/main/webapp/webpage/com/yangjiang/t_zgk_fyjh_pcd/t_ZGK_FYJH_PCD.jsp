<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>派车单</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style type="text/css">
#main {
	border: 2px solid red;
	padding: 10px;
}

#top {
	min-height: 300px;
	border: 0px dashed;
	width: 100%,
}

#south {
	border: 1px dotted blue;
	padding: 10px;
	width: 30%,
}

#left {
	border: 1px dotted burlywood;
	width: 100%,
}
</style>
</head>

<body>

	<div id="main">
		<div id="south">		
			<form action="" title="查询条件" id="checkform">
				<table title="查询条件">
					<td style="font-size: x-large;color: blue;">火车发运计划单生成表</td>				
					<td align="right"><label> 发货通知单号: </label></td>
					<td class="value"><input class="inputxt" id="BILL_NOTICE_NO"
					name="BILL_NOTICE_NO" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span></td>
					<td align="right"><label> 发货通知单明细号: </label></td>
					<td class="value"><input class="inputxt" id="BILL_LADING_NO_ITEM"
					name="BILL_LADING_NO_ITEM" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span></td>
					<td align="right"><input type="button" name="查询计划"
						value="查询计划" onclick="checkzgtransplan()"
						style="font-size: x-large;color: red;"></td>
					
				</table>
			</form>
		</div>
			<div style="border: 0px solid; height: 200px;width:1400px;" align="left">
				<t:datagrid name="outstoreList" title="铸管火车发运计划列表"
								checkbox="true"  actionUrl="CheckZgTransportPlanController.do?planDataGrid"  idField="发货通知单明细号"
								   pagination="true">																							
								<t:dgCol title="发货通知单号" field="发货通知单号"></t:dgCol>								
								<t:dgCol title="发货通知单明细号" field="发货通知单明细号"></t:dgCol>								
								<t:dgCol title="计划状态名称" field="计划状态名称"></t:dgCol>
								<t:dgCol title="产品代码" field="产品代码" hidden="true"></t:dgCol>
								<t:dgCol title="产品名称" field="产品中文名称"></t:dgCol>								
								<t:dgCol title="计划支数" field="计划支数"></t:dgCol>
								<t:dgCol title="计划重量" field="计划重量"></t:dgCol>							
								<t:dgCol title="已派支数" field="已派支数"></t:dgCol>
								<t:dgCol title="已派重量" field="已派重量"></t:dgCol>																
								<t:dgCol title="未派支数" field="未派支数"></t:dgCol>
								<t:dgCol title="未派重量" field="未派重量"></t:dgCol>
								<t:dgCol title="单重" field="单重"></t:dgCol>
								<t:dgCol title="备注" field="备注"></t:dgCol>													
								<t:dgCol title="交货地点名称" field="交货地点名称"></t:dgCol>
								<t:dgCol title="收货地点" field="收货地点"></t:dgCol>
								<t:dgCol title="收货单位" field="收货单位"></t:dgCol>
								<t:dgCol title="收货人" field="收货人"></t:dgCol>
								<t:dgCol title="销售公司" field="销售公司"></t:dgCol>
								<t:dgCol title="特殊合同描述" field="特殊合同描述"></t:dgCol>
								<t:dgCol title="内外销标识" field="内外销标识"></t:dgCol>
								<t:dgCol title="发货库房名称" field="发货库房名称"></t:dgCol>
								<t:dgCol title="运输方式名称" field="运输方式名称"></t:dgCol>																																	
		</t:datagrid>
			</div>
		</div>
	<div id="top">
	
	<div style="border: 1px solid red; height: 500px;width:1400px;">
				<t:datagrid name="pcdlist" title="生成派车单列表"
								checkbox="true"  actionUrl="#"  idField="id"  autoLoadData="false" pagination="true" >
								<t:dgCol title="增加行"  field="opt_add"  formatterjs="add"  ></t:dgCol>
								<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
								<t:dgCol title="删除行"  field="opt_del"  formatterjs="del"></t:dgCol>
								
								<t:dgCol title="仓库名称" field="outStorehouseName" hidden="true"  ></t:dgCol>
								<t:dgCol title="派车单号" field="sendCarNo" hidden="true" ></t:dgCol>
								<t:dgCol title="运输方式" field="trnpMode" hidden="true"></t:dgCol>	
								<t:dgCol title="主运号" field="carryNo" hidden="true"></t:dgCol>															
								<t:dgCol title="序号" field="number"  extendParams="editor:'text'"></t:dgCol>								
								<t:dgCol title="产品代码" field="itemCode"  ></t:dgCol>								
								<t:dgCol title="产品名称" field="itemName" editor="text"></t:dgCol>																
								<t:dgCol title="承运商代码" field="carryCompanyCode" extendParams="editor:'combobox'" ></t:dgCol>
								<t:dgCol title="承运商名称" field="carryCompanyName" extendParams="editor:'combobox'" dictionary="T_MYJK_ZGQYCYS"></t:dgCol>								
								<t:dgCol title="承运数量" field="carryNum" extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="承运重量" field="carryWt" extendParams="editor:'text'"></t:dgCol>																				
								<t:dgCol title="车牌号" field="carNo" extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="司机姓名" field="driverName" extendParams="editor:'text'"></t:dgCol>			
								<t:dgCol title="司机电话" field="driverTel" extendParams="editor:'text'"></t:dgCol>			
								<t:dgCol title="司机身份证号" field="idNumber" extendParams="editor:'text'"></t:dgCol>																						
								<t:dgCol title="发货库房代码" field="carryCompanyCode" extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="发货通知单号" field="billNoticeNo"></t:dgCol>
								<t:dgCol title="发货通知单明细号" field="billNoticeNoItem" ></t:dgCol>
								<t:dgCol title="销售公司" field="orgName" ></t:dgCol>
								<t:dgCol title="收货公司" field="consignCname" ></t:dgCol>
								<t:dgCol title="收货地址" field="recAdd" ></t:dgCol>
								<t:dgCol title="发货库房名称" field="storeName" ></t:dgCol>
								<t:dgCol title="运输方式名称" field="trnMode" ></t:dgCol>
								<t:dgCol title="编号" field="id"></t:dgCol>
									  							 								  																																							 																										
		</t:datagrid>
		<table>
		<tr>		
		<td><input id="addPlan"  type="button" name="addPlan" value="添加计划" onclick="addPlan()" style="font-size: large;color: blue;"></td>
		<td><input id="savePlan"  type="button" name="savePlan" value="提交保存" onclick="saveData()" style="font-size: large;color: red;"></td>		
		</tr>
		</table>
		</div>
	</div>
	
	
</body>
<script type="text/javascript">
function getUuid(){
	  var len=36;//32长度
	  var radix=16;//16进制
	  var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	  var uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
	  return uuid.join('');
	}  
function add(val,row,index){  	
    return '<a href="#"   onclick="javascript:void(0);">添加</a>';  
}  
function edit(val,row,index){  
    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
}  
function del(val,row,index){  
    return '<a href="#"  onclick="javascript:void(0);">删除</a>';  
}  
$(document).ready(function() {	
	//绑定单元格点击事件
	$("#pcdlist").datagrid({
		onClickCell:function(rowIndex, field, value){
			console.log("当前行==》》》"+rowIndex);
			if(field=="opt_add"){
			//	alert('添加单元格');
				addRow(rowIndex);
			}else if(field=="opt_editor"){
			//	alert('编辑单元格');
				editRow(rowIndex)
			}else if(field=="opt_del"){
			//	alert('删除单元格');
				delRow(rowIndex);
			}
		}
	});
	
});
 (function($) {
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
 function checkzgtransplan() {			
		var data = $("#checkform").parseForm();						
		$("#outstoreList").datagrid("reload", data);
	};	
	var globalplannum=0;
	/**
	*添加到详细表
	**/
	function addPlan(){			
            var plandata = $("#outstoreList").datagrid("getSelections"); 
            if(plandata.length==0){
            	tip("请选择发运计划");
            	return;
            }
            //添加到datagrid
            var selectData = {};
       		selectData.rows =[];
            for(var index in plandata){
            	console.info("index:"+index);
            var selectRowsData = plandata[index];
            var row ={};
            row.sendCarNo="";
            row.number="";
            row.carryNo=selectRowsData.carry_no;            
            row.billNoticeNo=selectRowsData.发货通知单号;
            row.billNoticeNoItem=selectRowsData.发货通知单明细号;
            row.itemCode = selectRowsData.产品代码;
         	row.itemName=selectRowsData.产品中文名称; 
         	row.orgName=selectRowsData.销售公司;
         	row.consignCname=selectRowsData.收货单位;
         	//row.recAdd=selectRowsData.收货地点;
         	row.recAdd=selectRowsData.交货地点名称;
         	row.storeName=selectRowsData.发货库房名称;
         	row.trnMode=selectRowsData.运输方式名称;
         	row.carryCompanyCode="";
         	row.carryCompanyName="";
         	row.carryNum="";
         	row.carryWt="";        	
         	row.carNo="";
         	row.driverName="";
         	row.driverTel="";
         	row.idNumber="";  
         	row.delFlag="";         	
         	row.edituser="";         	
         	row.editip="";       
         	row.edittime="";      
            row.id=getUuid();                                       
         	selectData.rows.push(row);
         	console.info(row);
         	 globalplannum=selectRowsData.未派支数;
            }
        	$("#pcdlist").datagrid('loadData', selectData);
           
        	//console.log(row);  
		};
		function addRow(index){  	
			var rows = $('#outstoreList').datagrid('getRows')[index];
			$('#pcdlist').datagrid('appendRow',{
				billNoticeNo:rows.发货通知单号,
				billNoticeNoItem:rows.发货通知单明细号,
				orgName:rows.销售公司,
				consignCname:rows.收货单位,
				recAdd:rows.交货地点名称,
				id:getUuid(),
				itemCode:rows.产品代码,
				itemName:rows.产品中文名称,
				storeName:rows.发货库房名称,
				trnMode:rows.运输方式名称
			});	
			console.log("插入当前行======》》》》"+index);
			var editIndex =  $('#pcdlist').datagrid('getRows').length-1;
			$('#pcdlist').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
		} 
		//结束编辑
		function endEdit(){
			//这里不应该只是编辑当前行？？？？？
			var  editIndex = $('#pcdlist').datagrid('getRows').length-1;
			for(var i=0;i<=editIndex;i++){
				if($('#pcdlist').datagrid('validateRow', i))
					$('#pcdlist').datagrid('endEdit', i);
				else
					return false;
			}
			return true;
		}
		//删除行
		function delRow(index){		
					$('#pcdlist').datagrid('deleteRow',index);						
				}
		//编辑行
		function editRow(index){
			var rows=$('#pcdlist').datagrid("getChecked");
			if(rows.length==0){
				tip("请选择条目");
				return false;
			}
			$('#pcdlist').datagrid('beginEdit', index);
		}
		
		function panduan()
		{
		    var rows=$('#pcdlist').datagrid("getSelections");
			if(rows.length==0){
				tip("请选择要提交的信息");
				return false;
			}
			var sumzs=0;
			//var  editIndex = $('#pcdlist').datagrid("getChecked").length-1;
			
			if(rows.length==1){
			sumzs =rows[0].carryNum
			}
			else
			{
			for(var i=0;i<rows.length;i++){
			sumzs = sumzs+parseInt(rows[i].carryNum);
			//console.log("**************************");
			}
			}
			console.log("sumzs:"+sumzs);
			console.log("sumzs1:"+globalplannum);
			if(sumzs>globalplannum)
			{tip("支数不能大于未派支数");
				return false;
			}
		}
			
				
		function saveData(){	
			/**
			*t_ZG_PIPEList获取全部选中记录
			**/
			endEdit();		
			panduan();	
          	var getSelectionsDatas=$('#pcdlist').datagrid("getSelections");
          	console.info("getSelectionsDatas:"+getSelectionsDatas);
          	alert("length:"+getSelectionsDatas.length);  
          	var jsondata=JSON.stringify(getSelectionsDatas);          	
          	console.info("jsondata:"+jsondata);
          	$.ajax({
				    url: "t_ZGK_FYJH_PCDController.do?save",
				    data:{data:JSON.stringify(getSelectionsDatas)},
				    dataType: "json",
				    type: "POST",          
				    success: function (data) {
				    	var win = frameElement.api.opener;
				    	if(data.success==true){
				    		frameElement.api.close();
				    		win.tip(data.msg);
				    		win.reloadTable();
				    	}
				    }
			});  
          	$("#t_ZGK_FYJH_PCDList").datagrid("reload");
		}
 </script>
