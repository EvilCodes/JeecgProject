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
<title>二铸管管材打包</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<body style="overflow-y: hidden">

	<form action="" id="searchForm">
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td colspan="5" align="center" style="font-size: 17"><span>小管打包</span></td>
				<span></span>
				<td class="value"><input class="button" name="查询" onclick="checkorder()"
					value="查询生产计划" style="font-size: 14 ">
				</td>
				<td class="value">
				<input class="button" name="添加管号到列表" onclick="addpipecode_num()"
									value="添加管号到列表" style="font-size: 14,large; ">
				</td>
				<td class="value"><input class="button" name="提交保存打包信息" value="提交保存打包信息"
						onclick="save()"></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 年份: </label>
				</td>
				<td class="value"><input class="Wdate" id="pYear" name="pYear"
					ignore="ignore" datatype="n"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 月份: </label>
				</td>
				<td class="value"><input class="inputxt" id="pMonth"
					name="pMonth" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 规格: </label>
				</td>
				<td class="value"><t:dictSelect field="dn" type="select"
						datatype="*" dictTable="t_zg_code_pipe_dn" dictField="dn"
						dictText="dn" id="pipetype"></t:dictSelect> <span
					class="Validform_checktip"></span>
				</td>



				<td align="right"><label class="Validform_label"> 内外销（0：内销；1：外销）:
				</label>
				</td>
				<td class="value"><input class="inputxt" id="expflag"
					name="expflag" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>

				<td align="right"><label class="Validform_label"> 接口方式:
				</label>
				</td>
				<td class="value"><t:dictSelect field="interface_desc"
						type="select" datatype="*" dictTable="V_MYBM_JQ_JK"
						dictField="接口名称" dictText="接口名称"></t:dictSelect> <span
					class="Validform_checktip"></span>
				</td>

				<td align="right"><label class="Validform_label"> 壁厚等级:
				</label>
				</td>
				<td class="value"><t:dictSelect field="grade" type="select"
						datatype="*" dictTable="V_MYBM_ZG_DJ" dictField="等级描述"
						dictText="等级描述"></t:dictSelect> <span class="Validform_checktip"></span>
				</td>

				<td align="right"><label class="Validform_label"
					style="width:35px"> 长度: </label>
				</td>
				<td class="value"><t:dictSelect field="my_length" type="select"
						datatype="*" dictTable="V_MYBM_ZG_CD" dictField="长度描述"
						dictText="长度描述" id="my_length"></t:dictSelect> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label">是否5.7米改6米计划 :
					</label></td>
					<td class="value"><t:dictSelect field="shortpipe"
							type="select" datatype="*" dictTable="yesorno"
							dictField="name" dictText="name" id="shortpipe" defaultVal="不是"></t:dictSelect><span
						class="Validform_checktip"></span>
					</td>
			</tr>
		</table>
	</form>
	<div id="main">
		<table>
			<tr>
				<td>
					<div id="south" style="width: 50%">
						<div style="border: 1px solid; height: 200px;width:830px;"
							align="left">
							<t:datagrid name="vOrderPipeCodeList" title=""
								checkbox="true" actionUrl="myjkscjhController.do?orderDataGrid"
								idField="product_plan_no" singleSelect="true">
								<t:dgCol title="特殊合同描述" field="special_desc" frozenColumn="true"></t:dgCol>
								<t:dgCol title="生产计划号" field="product_plan_no"
									frozenColumn="true"></t:dgCol>
								<t:dgCol title="内外销" field="expFlag"></t:dgCol>
								<t:dgCol title="年份" field="pYear"></t:dgCol>
								<t:dgCol title="月份" field="pMonth"></t:dgCol>
								<t:dgCol title="规格" field="dn"></t:dgCol>
								<t:dgCol title="级别" field="grade"></t:dgCol>
								<t:dgCol title="接口" field="interface_desc"></t:dgCol>
								<t:dgCol title="长度" field="my_length"></t:dgCol>
								<t:dgCol title="品种" field="pipetype"></t:dgCol>
								<t:dgCol title="产品中文名称" field="item_cname"></t:dgCol>
								<t:dgCol title="产品编码" field="item_code"></t:dgCol>
							</t:datagrid>
						</div>
				</td>
				<td>
					<div id="left" style="width: 50%">
						<div style="border: 1px solid; height: 200px;width:500px;"
							align="right">
							<t:datagrid name="pipecodeList" title="" checkbox="true"
								actionUrl="pipecodebatchController.do?pipecodeDataGrid"
								idField="pipe_code" queryMode="single">
								<t:dgCol title="批号全称" field="batch_full" query="true"></t:dgCol>
								<t:dgCol title="管号" field="pipe_code"></t:dgCol>
								<t:dgCol title="管序号" field="pipe_serial"></t:dgCol>
								<t:dgCol title="批号" field="batch"></t:dgCol>
								
							</t:datagrid>
						</div>
						
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div id="top">
		<!--这里的管号会不会重复？？？不能让重复，选择B表的时候是不是要控制？？对
		会   那意思 B表出来的数据会不会有重复的,不会吧 我现在先把管号作为ID识别-->
		<div style="border: 1px solid; height: 600px;width:1400px;">
			<t:datagrid name="t_ZG_PIPEList" title=""
				actionUrl="t_ZG_PACKAGEController.do?save" idField="pipecode"
				fit="true" autoLoadData="false" fitColumns="true" checkbox="true">
				<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
				<t:dgCol title="删除行"  field="opt_del"  formatterjs="del"></t:dgCol>
				<t:dgCol title="包号" field="packid" extendParams="editor:'text'"></t:dgCol>
				<t:dgCol title="该批支数" field="pipenum" extendParams="editor:'text'"></t:dgCol>
				<t:dgCol title="批号" field="batchfull"></t:dgCol>	
				<t:dgCol title="规格" field="dn"></t:dgCol>				
				<t:dgCol title="管号" field="pipecode"></t:dgCol>
				<t:dgCol title="管序号" field="pipeserial"></t:dgCol>				
				<t:dgCol title="特殊合同描述" field="special"></t:dgCol>				
				<t:dgCol title="订单产品编码" field="itemcode"></t:dgCol>	
				<t:dgCol title="订单产品名称" field="itemcname"></t:dgCol>			
				<t:dgCol title="生产计划号" field="productplanno" ></t:dgCol>
				<t:dgCol title="产品名称" field="itemname" ></t:dgCol>
				<t:dgCol title="备注" field="remark" extendParams="editor:'text'"></t:dgCol>
				
				
			</t:datagrid>
			
		</div>
	</div>
	</div>

	<script type="text/javascript">
	function edit(val,row,index){  
	    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
	}  
	function del(val,row,index){  
	    return '<a href="#"  onclick="javascript:void(0);">删除</a>';  
	} 
	$("#t_ZG_PIPEList").datagrid({
		onClickCell:function(rowIndex, field, value){
			console.log("当前行==》》》"+rowIndex);			
			if(field=="opt_editor"){
			//	alert('编辑单元格');
				editRow(rowIndex)
			}else if(field=="opt_del"){
			//	alert('删除单元格');
				delRow(rowIndex);
			}
		}
	});
		function pad(num, n) {
			var i = (num + "").length;
			while (i++ < n)
				num = "0" + num;
			return num;
		};
		function cat() {
			var pipe_order = $("#lineNum").val();
			pipe_order = pad(pipe_order, 3);
			var riqi = $("#riqi").val();
			var pipeline = $("#line_name").val();
			var lineName;
			if (pipeline == "东线") {
				lineName = "1";
			} else if (pipeline == "西线") {
				lineName = "2";
			} else {
				lineName = "3";
			}
			$("#packageid").val("12" + riqi + lineName + pipe_order);
		}

		//var rukudanid = getUrlParam("rukudanid");
		Date.prototype.Format = function(fmt) { //author: meizz 
			var o = {
				"M+" : this.getMonth() + 1, //月份 
				"d+" : this.getDate(), //日 
				"h+" : this.getHours(), //小时 
				"m+" : this.getMinutes(), //分 
				"s+" : this.getSeconds(), //秒 
				"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
				"S" : this.getMilliseconds()
			//毫秒 
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		}
		function getUrlParam(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg); //匹配目标参数
			if (r != null)
				return unescape(r[2]);
			return null; //返回参数值
		};

		$(document).ready(function() {
			$("#pYear").attr("class", "Wdate").click(function() {
				WdatePicker({
					dateFmt : 'yyyy'
				});
			});

			$("#vOrderPipeCodeList").datagrid({
				singlSelect : true
			});	
					
			$('#vOrderPipeCodeList').datagrid({
				onSelect : function(index, row) {
					//TODO 事件响应代码；
					newItemcode();
					checkpipecode();
					
				}
			});
			$("#line_name").change(function() {
				cat();
			});
			$("#shortpipe").change(function() {
				newItemcode();
			});

		});
		function newItemcode(){
			var row = $("#vOrderPipeCodeList").datagrid("getSelected");
			var itemcode=row.item_code;
			var isYes=$("#shortpipe").val();
			console.info("isYes:"+isYes);
			var start=itemcode.substring(0,12);
			console.info("start:"+start);
			var end=itemcode.substring(13,16);
			console.info("end:"+end);
			if(isYes=="是"){
				itemcode=start+"7"+end;				
			}else{
				itemcode=itemcode;	
			}
			$("#itemcode").val(itemcode);
		}
		
		
		function checkorder() {
			var data = $("#searchForm").parseForm();
			$("#vOrderPipeCodeList").datagrid("reload", data);
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

		function checkpipecode() {
			//这是需要加载的datagrid的js
			var checkedItems = $("#vOrderPipeCodeList").datagrid('getSelected');
			//alert("dn:"+checkedItems.dn);
			$.post("pipecodebatchController.do?pipecodeDataGrid", {
				grade : checkedItems.grade,
				interface_desc : checkedItems.interface_desc,
				pipetype : checkedItems.pipetype,
				length : checkedItems.length,
				pYear : checkedItems.pYear,
				dn : checkedItems.dn
			}, function(datas) {
				console.log(datas);//这里拿到了数据，怎么放进datagrid
				$("#pipecodeList").datagrid("loadData", datas);
			}, "json");
			
		};

		/**
		 *添加到详细表
		 **/
		function addpipecode_num(){
			var orderPipeRow = $("#vOrderPipeCodeList").datagrid("getSelected");
			var pipecodeListSelected = $("#pipecodeList").datagrid("getSelections");
			var data_length = pipecodeListSelected.length;
			alert(data_length);
			//console.log(pipecodeListSelected);
			var selectData = {};
			selectData.rows = [];
			for ( var index in pipecodeListSelected) {
				var selectRowsData = pipecodeListSelected[index];
				var row = {};
				//管号表字段
				row.batchfull = selectRowsData.batch_full;
				row.dn = orderPipeRow.dn;
				row.pipecode = selectRowsData.pipe_code;
				row.pipeserial = selectRowsData.pipe_serial;				
				row.special = orderPipeRow.special_desc;
				row.itemcode = orderPipeRow.item_code;	
				row.itemname = orderPipeRow.item_cname;
				row.productplanno = orderPipeRow.product_plan_no;
																																				
				selectData.rows.push(row);
			}
			//alert(main_id);
			$("#t_ZG_PIPEList").datagrid('loadData', selectData);
		};
		function endEdit(){
			//这里不应该只是编辑当前行？？？？？
			var  editIndex = $('#t_ZG_PIPEList').datagrid('getRows').length-1;
			for(var i=0;i<=editIndex;i++){
				if($('#t_ZG_PIPEList').datagrid('validateRow', i))
					$('#t_ZG_PIPEList').datagrid('endEdit', i);
				else
					return false;
			}
			return true;
		}
		//编辑行
		function editRow(index){
			var rows=$('#t_ZG_PIPEList').datagrid("getChecked");
			if(rows.length==0){
				tip("请选择条目");
				return false;
			}
			$('#t_ZG_PIPEList').datagrid('beginEdit', index);
		}
		//删除行
		function delRow(index){
			alert("del row");
			$('#t_ZG_PIPEList').datagrid('deleteRow',index); 
		}
		/**
		 *你这里需要一行行的添加还是批量添加？？批量添加
		 *
		 **/
		function save() {
			/**
			 *t_ZG_PIPEList获取全部选中记录
			 **/
			endEdit();
			var getSelectionsDatas = $('#t_ZG_PIPEList').datagrid("getSelections");
			//alert("length:"+getSelectionsDatas.length);
			var detailinfo=JSON.stringify(getSelectionsDatas);
			console.info("detailinfo:"+detailinfo);
			$.ajax({
				url : "t_ZG_PACKAGEController.do?save",
				 data:{data:JSON.stringify(getSelectionsDatas)},
				dataType : "json",
				type : "POST",
				success : function(data) {
					//操作提示
					tip(data.msg);
				}
			});
		}
	</script>


</body>