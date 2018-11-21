<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE html>
<html>
<head>
<style>
#main {
	border: 2px solid red;
	padding: 0px;
}

#top {
	min-height: 200px;
	border: 1px dashed blue;
}

#south {
	border: 1px dashed blue;
	padding: 0px;
	width: 60%,
}

#left {
	border: 1px dotted burlywood;
	width: 30%,
}
</style>
<title>汽车出库数据红冲</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<body style="overflow-y: hidden">

	<form action="" id="searchForm">
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 出库单号:
				</label>
				</td>
				<td class="value"><input class="inputxt" id="chukudanid"
					name="chukudanid" ignore="ignore" datatype="*" > <span
					class="Validform_checktip"></span>
				</td>
				<td ><input class="button" name="查询" onclick="checkorder()"
					value="查询" style="font-size: 14 ">
				</td>
				<td >
				<input class="button" name="添加" onclick="addpipecode_num()"
					value="添加" style="font-size: 14 ">
				</td>
				<td ><input class="button" name="提交保存" value="提交保存"
						onclick="save()" style="font-size: 14 "></td>
			</tr>
			
				
			
		</table>
	</form>
	<div id="main">
		<table>
			<tr>
				<td>
					<div id="south" style="width: 50%">
						<div style="border: 1px solid; height: 200px;width:1030px;"
							align="left">
							<t:datagrid name="vOrderPipeCodeList" title="出单列表"
								checkbox="true" actionUrl="CheckpipeCodeFCController.do?pipecodedatagrid"
								idField="chukudanid" singleSelect="true">
								<t:dgCol title="出库单号" field="chukudanid" frozenColumn="true"></t:dgCol>
								<t:dgCol title="发货单号" field="bill_notice_no"></t:dgCol>
								<t:dgCol title="发货单明细号" field="bill_lading_no_item"></t:dgCol>
								<t:dgCol title="承运公司" field="consign_cname"></t:dgCol>
								<t:dgCol title="目的地" field="delivy_place_name"></t:dgCol>
								<t:dgCol title="销售公司" field="org_name"></t:dgCol>								
							</t:datagrid>
						</div>
				</td>
			</tr>
		</table>
	</div>
	<div id="top">
		<div style="border: 1px solid; height: 600px;width:1400px;">
			<t:datagrid name="t_ZG_PIPEList" title=""
				actionUrl="t_MYJK_FYJH_BAK_ACT_REDController.do?save" idField="chukudanid"
				fit="true" autoLoadData="false" fitColumns="true" checkbox="true">
				<t:dgCol title="发货通知单号" field="billNoticeNo" ></t:dgCol>
				<t:dgCol title="发货通知单明细号" field="billLadingNoItem"></t:dgCol>
				<t:dgCol title="出库单号" field="sendNo"></t:dgCol>															
			</t:datagrid>
			
		</div>
	</div>
	</div>

	<script type="text/javascript" >
		function checkorder(){
			var data = $("#searchForm").parseForm();
			alert(data);
			$("#vOrderPipeCodeList").datagrid("reload", data);
		};
		function addpipecode_num(){
			alert(1111);
			var orderPipeRow = $("#vOrderPipeCodeList").datagrid("getSelected");						
			var selectData = {};
			selectData.rows = [];							
			var row = {};								
			row.billNoticeNo = orderPipeRow.bill_notice_no;								
			row.billLadingNoItem = orderPipeRow.bill_lading_no_item;
			row.sendNo = orderPipeRow.chukudanid;																																									
			selectData.rows.push(row);
			$("#t_ZG_PIPEList").datagrid('loadData', selectData);
		};
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


		
		
		function save(){
			/**
			 *t_ZG_PIPEList获取全部选中记录
			 **/
			var getSelectionsDatas = $('#t_ZG_PIPEList').datagrid("getSelections");			
			var detailinfo=JSON.stringify(getSelectionsDatas);
			console.info("detailinfo:"+detailinfo);
			$.ajax({
				url : "t_MYJK_FYJH_BAK_ACT_REDController.do?save",
				 data:{data:JSON.stringify(getSelectionsDatas)},
				dataType : "json",
				type : "POST",
				success : function(data) {
					var win = frameElement.api.opener;
			    	if(data.success==true){
			    		frameElement.api.close();
			    		win.tip(data.msg);
			    		win.reloadTable();
					
				}
			    	}			   
			})
		}
	</script>


</body>