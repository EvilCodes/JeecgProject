<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
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
					<td style="font-size: x-large;color: blue;">派车单查询</td>				
					<td align="right"><label> 派车单单号: </label></td>
					<td class="value"><input class="inputxt" id="send_car_no"
					name="send_car_no" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span></td>
					<td align="right"><input type="button" name="查询计划"
						value="查询计划" onclick="checkzgtransplan()"
						style="font-size: x-large;color: red;"></td>
							
				</table>
			</form>
		</div>
			<div style="border: 0px solid; height: 300px;width:98%;" align="left">
				<t:datagrid name="outstoreList" title="铸管汽车发运计划列表"
								checkbox="true"  actionUrl="CheckPCDController.do?checkPCDGrid"  idField="id"
								   pagination="true">
								<t:dgCol title="派车单号" field="send_car_no"></t:dgCol>																							
								<t:dgCol title="发货通知单号" field="bill_notice_no"></t:dgCol>								
								<t:dgCol title="发货通知单明细号" field="bill_notice_no_item"></t:dgCol>															
								<t:dgCol title="产品代码" field="item_code" hidden="true"></t:dgCol>
								<t:dgCol title="产品名称" field="item_name"></t:dgCol>								
								<t:dgCol title="发运数量" field="carry_num"></t:dgCol>
								<t:dgCol title="发运重量" field="carry_wt"></t:dgCol>							
																					
			
								<t:dgCol title="运输方式名称" field="trnp_mode"></t:dgCol>																																	
		</t:datagrid>
			</div>
		</div>
	<div id="top">
	
	<div style="border: 1px solid red; height: 500px;width:98%;">
				<t:datagrid name="pcdlist" title="胶圈发运列表"
								checkbox="true"  actionUrl="t_ZGK_PIPE_CKD_JQController.do?save&chukudanid=${chukudanid }"  idField="id"  autoLoadData="false" pagination="true" >
								<t:dgCol title="增加行"  field="opt_add"  formatterjs="add"  ></t:dgCol>
								<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
								<t:dgCol title="删除行"  field="opt_del"  formatterjs="del"></t:dgCol>																
								<t:dgCol title="派车单号" field="sendCarNo"></t:dgCol>																																
								<t:dgCol title="厂家" field="factory"  extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="厂家代码" field="factoryCode"  extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="备注" field="remark"  extendParams="editor:'text'"></t:dgCol>								
								<t:dgCol title="产品代码" field="itemCode"  ></t:dgCol>								
								<t:dgCol title="产品名称" field="itemName"></t:dgCol>																													
								<t:dgCol title="承运数量" field="carryNum" extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="承运重量" field="carryWt" extendParams="editor:'text'"></t:dgCol>																																																											
								<t:dgCol title="编号" field="id"></t:dgCol>
									  							 								  																																							 																										
		</t:datagrid>
		<table>
		<tr>		
		<td><input id="addPlan"  type="button" name="addPlan" value="添加计划" onclick="addPlan()" style="font-size: large;color: blue;"></td>
		<td><input id="savePlan"  type="button" name="savePlan" value="提交保存" onclick="saveData()" style="font-size: large;color: red;"></td>		
		</table>
		</div>
	</div>
	
	
</body>
<script type="text/javascript">
var chukudanid=getUrlParam("chukudanid");
//alert(chukudanid);
function getUrlParam(name)
{
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
};
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
       		var fdStart ;
            for(var index in plandata){
            console.info("index:"+index);
            var selectRowsData = plandata[index];
            var row ={};
            row.sendCarNo=selectRowsData.send_car_no;                                               
            row.itemCode = selectRowsData.item_code;
         	row.itemName=selectRowsData.item_name;          	         	
         	row.carryNum=selectRowsData.carry_num; 
         	row.carryWt=selectRowsData.carry_wt;     
            row.id=getUuid();  
            row.remark="";
          //  alert(row.itemCode);
            fdStart=row.itemCode.substring(0,2);
            
            if(fdStart !='D9')
            {
            tip("请选择胶圈发运计划");
            return;
            }
         	selectData.rows.push(row);
         	console.info(row);
            }
        	$("#pcdlist").datagrid('loadData', selectData);
           
        	//console.log(row);  
		};
		function addRow(index){  	
			var rows = $('#outstoreList').datagrid('getRows')[index];
			//alert(rows);
			var cysdm=$("#cys").val();
			var cys=$("#cys").find("option:selected").text();
			$('#pcdlist').datagrid('appendRow',{																				
				id:getUuid(),
				itemCode:rows.item_code,
				itemName:rows.item_name,
				sendCarNo:rows.send_car_no,
				carryWt:rows.carry_wt,
				carryNum:rows.carry_num,
				remark:rows.remark
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
		
				
		function saveData(){	
			/**
			*t_ZG_PIPEList获取全部选中记录
			**/
			endEdit();
			//alert(chukudanid);
          	var getSelectionsDatas=$('#pcdlist').datagrid("getSelections");
          	var planData=$('#outstoreList').datagrid("getSelected");
          	console.info("getSelectionsDatas:"+getSelectionsDatas);
          	var jsondata=JSON.stringify(getSelectionsDatas);
          	$.ajax({
				    url: "t_ZGK_PIPE_CKD_JQController.do?save",
				    data:{data:JSON.stringify(getSelectionsDatas),chukudanid:chukudanid},
				    dataType: "json",
				    type: "POST",          
				    success: function (data) {
				    	//var win = frameElement.api.opener;
				    	//console.log("success*****");
				    	if(data.success==true){
				    	//console.log("11111111111111save");
				    		//frameElement.api.close();
				    		//win.tip(data.msg);
				    		//win.reloadTable();
				    		tip(data.msg);
				    	}
				    }
			});  
          	$("#t_ZGK_FYJH_PCDList").datagrid("reload");
		}
 </script>
