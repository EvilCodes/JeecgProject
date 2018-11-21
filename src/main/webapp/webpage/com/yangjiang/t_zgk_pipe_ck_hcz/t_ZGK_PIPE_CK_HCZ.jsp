<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>火车装车</title>
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
					<td style="font-size: x-large;color: blue;"></td>				
					<td align="right"><label>发货通知单号: </label></td>
					<td class="value"><input class="inputxt" id="chukudanid"
					name="chukudanid" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span></td>
					<td align="right"><label>派车单单号: </label></td>
					<td class="value"><input class="inputxt" id="sendCarNo"
					name="sendCarNo" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span></td>
					<td align="right"><input type="button" name="查询装车数据"
						value="查询装车数据" onclick="checkZgkOutStore()"
						style="font-size: large;color: red;"></td>
					
				</table>
			</form>
		</div>
			<div style="border: 0px solid; height: 200px;width:1400px;" align="left">
				<t:datagrid name="outstoreList" title=""
								checkbox="true"  actionUrl="CheckZGKOutStoreInfo.do?planDataGrid"  idField="发货通知单明细号"
								   pagination="true" singleSelect="true">
								<t:dgCol title="发货通知单号" field="发货通知单号"></t:dgCol>
								<t:dgCol title="发货通知单明细号" field="发货通知单明细号"></t:dgCol>																							
								<t:dgCol title="运输方式名称" field="运输方式名称" hidden="true"></t:dgCol>								
								<t:dgCol title="计划状态" field="计划状态" hidden="true"></t:dgCol>								
								<t:dgCol title="计划状态名称" field="计划状态名称"></t:dgCol>
								<t:dgCol title="产品代码" field="产品代码" hidden="true"></t:dgCol>
								<t:dgCol title="产品名称" field="产品中文名称"></t:dgCol>	
								<t:dgCol title="未派支数" field="未派支数"></t:dgCol>								
								<t:dgCol title="短倒支数" field="短倒支数"></t:dgCol>								
								<t:dgCol title="发出支数" field="发出支数"></t:dgCol>													
								<t:dgCol title="核减短倒" field="核减短倒"></t:dgCol>
								<t:dgCol title="交货日期" field="交货日期" hidden="true"></t:dgCol>								
								<t:dgCol title="交货地点名称" field="交货地点名称"></t:dgCol>					
								<t:dgCol title="专用线名称" field="专用线名称"></t:dgCol>
								<t:dgCol title="收货地点" field="收货地点"></t:dgCol>
								<t:dgCol title="收货单位" field="收货单位"></t:dgCol>
								<t:dgCol title="收货人" field="收货人" hidden="true"></t:dgCol>
								<t:dgCol title="发货库房名称" field="发货库房名称" ></t:dgCol>
								<t:dgCol title="收货电话" field="收货电话" hidden="true"></t:dgCol>
								<t:dgCol title="备注" field="备注" hidden="true"></t:dgCol>
								<t:dgCol title="销售公司" field="销售公司"></t:dgCol>
								<t:dgCol title="销售人员" field="销售人员" hidden="true"></t:dgCol>
								<t:dgCol title="手机" field="手机" hidden="true"></t:dgCol>
								<t:dgCol title="下达时间" field="下达时间" hidden="true"></t:dgCol>	
								<t:dgCol title="特殊合同描述" field="特殊合同描述"></t:dgCol>
								<t:dgCol title="内外销标识" field="内外销标识"></t:dgCol>
								<t:dgCol title="套装要求" field="套装要求" hidden="true"></t:dgCol>
								<t:dgCol title="包装方式" field="包装方式" hidden="true"></t:dgCol>
								<t:dgCol title="单重" field="单重"></t:dgCol>
																																							
		</t:datagrid>
			</div>
		</div>
	<div id="top">
	
	<div style="border: 1px solid red; height: 500px;width:1400px;">
				<t:datagrid name="pcdlist" title="装车信息"
								checkbox="true"  actionUrl="#"  idField="id"  autoLoadData="false" pagination="true" >
								<t:dgCol title="增加行"  field="opt_add"  formatterjs="add"  ></t:dgCol>
								<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
								<t:dgCol title="删除行"  field="opt_del"  formatterjs="del"></t:dgCol>
								<t:dgCol title="仓库名称" field="outWhouseName"   ></t:dgCol>
								<t:dgCol title="车皮型号代码" field="blockSize" extendParams="editor:'text'"  ></t:dgCol>
								<t:dgCol title="车皮型号" field="blockSizeName" extendParams="editor:'text'"  ></t:dgCol>
								<t:dgCol title="车号" field="blockNo" extendParams="editor:'text'" ></t:dgCol>
								<t:dgCol title="支数" field="planNum" extendParams="editor:'text'"  ></t:dgCol>
								<t:dgCol title="单重" field="perWeight" extendParams="editor:'text'"  ></t:dgCol>								
								<t:dgCol title="重量" field="planWt" extendParams="editor:'text'" ></t:dgCol>
								<t:dgCol title="样品管标志" field="sample" extendParams="editor:'text'"  ></t:dgCol>
								<t:dgCol title="短尺标志" field="noSameMark" extendParams="editor:'text'"  ></t:dgCol>
								<t:dgCol title="保管员" field="baoguanyuan" extendParams="editor:'text'"></t:dgCol>					
								<t:dgCol title="备注" field="remark"   ></t:dgCol>
								
								<t:dgCol title="单号" field="sendNo" ></t:dgCol>																																													
								<t:dgCol title="产品代码" field="itemCode"  ></t:dgCol>								
								<t:dgCol title="产品名称" field="itemCname" ></t:dgCol>																
								
								<t:dgCol title="到站" field="delivyPlaceName" ></t:dgCol>			
								<t:dgCol title="专线名称" field="privateRouteName" ></t:dgCol>																																									
								<t:dgCol title="发货通知单号" field="billNoticeNo"></t:dgCol>
								<t:dgCol title="发货通知单明细号" field="billLadingNoItem" ></t:dgCol>
								<t:dgCol title="销售公司" field="orgName" ></t:dgCol>
								<t:dgCol title="收货公司" field="consignCname" ></t:dgCol>
								<t:dgCol title="收货地址" field="recAdd" ></t:dgCol>								
								
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
 function checkZgkOutStore() {			
		var data = $("#checkform").parseForm();						
		$("#outstoreList").datagrid("reload", data);
	};	
	
	/**
	*添加到详细表
	**/
	var globalplannum=0;
	function addPlan(){			
            var plandata = $("#outstoreList").datagrid("getSelected"); 
            if(plandata.length==0){
            	tip("请选择发运计划");
            	return;
            }
            //添加到datagrid
            var selectData = {};
       		selectData.rows =[];                      
            var selectRowsData = plandata;
            var row ={};
            //row.sendNo="";
            row.billNoticeNo=selectRowsData.发货通知单号;
            row.billLadingNoItem=selectRowsData.发货通知单明细号;
            row.itemCode = selectRowsData.产品代码;
         	row.itemCname=selectRowsData.产品中文名称; 
         	row.orgName=selectRowsData.销售公司;
         	row.consignCname=selectRowsData.收货单位;
         	row.recAdd=selectRowsData.收货地点;
         	row.outWhouseName=selectRowsData.发货库房名称;
         	row.baoguanyuan=selectRowsData.baoguanyuan;
         	row.privateRouteName=selectRowsData.专用线名称;  
         	row.delivyPlaceName=selectRowsData.交货地点名称;
         	row.perWeight=selectRowsData.单重;
            row.id=getUuid(); 
            row.planNum="";
            row.blockSizeName="";
            row.blockNo="";
            row.planWt="";
            row.remark="";
         	selectData.rows.push(row);
         	console.info(row);
            globalplannum=selectRowsData.未派支数;
        	$("#pcdlist").datagrid('loadData', selectData);
           
        	//console.log(row);  
		};
		function addRow(index){  	
			var rows = $('#pcdlist').datagrid('getRows')[index];
			$('#pcdlist').datagrid('appendRow',{
				billNoticeNo:rows.billNoticeNo,
				billLadingNoItem:rows.billLadingNoItem,
				orgName:rows.orgName,
				consignCname:rows.consignCname,
				recAdd:rows.recAdd,
				id:getUuid(),
				itemCode:rows.itemCode,
				itemName:rows.itemName,
				storeName:rows.storeName,
				trnMode:rows.trnMode,
				perWeight:rows.perWeight,
				outWhouseName:rows.outWhouseName,
				itemCname:rows.itemCname,
				delivyPlaceName:rows.delivyPlaceName,
				privateRouteName:rows.privateRouteName,
				baoguanyuan:rows.baoguanyuan
				
			});	
			console.log("插入当前行======》》》》"+index);
			var editIndex =  $('#pcdlist').datagrid('getRows').length-1;
			//$('#pcdlist').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
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
		    var rows=$('#pcdlist').datagrid("getChecked");
			if(rows.length==0){
				tip("请选择要提交的信息");
				return false;
			}
			var sumzs=0;
			var  editIndex = $('#pcdlist').datagrid("getChecked").length-1;
			
			if(editIndex==0){
			sumzs =rows[0].planNum
			}
			else
			{
			for(var i=0;i<=editIndex;i++){
			sumzs = sumzs+parseInt(rows[i].planNum);
			//console.log("**************************");
			}
			}
			
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
          	var getSelectionsDatas=$('#pcdlist').datagrid("getSelections");
          	console.info("getSelectionsDatas:"+getSelectionsDatas);
          	//alert("length:"+getSelectionsDatas.length);  
          	var jsondata=JSON.stringify(getSelectionsDatas);
          	panduan();
          	console.info("jsondata:"+jsondata);
          	$.ajax({
				   url: "t_ZGK_PIPE_CK_HCZController.do?save",				 
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
          	$("#t_ZGK_PIPE_CK_HCZList").datagrid("reload");
		}
 </script>
