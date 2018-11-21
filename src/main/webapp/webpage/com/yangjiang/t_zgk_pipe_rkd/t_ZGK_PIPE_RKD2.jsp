<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<style>
			#main {
				border: 2px solid red;
				padding: 10px;
			}
			
			#top {
				min-height: 200px;
				border: 1px dashed blue;
			}
			
			#south {
				border: 1px dashed blue;
				padding: 10px;
				width: 60%,
			}
			
			#left {
				border: 1px dotted burlywood;
				width: 30%,
			}
		</style>
		<title>铸管部手工入库详细信息</title>
		<t:base type="jquery,easyui,tools,DatePicker"></t:base>

	</head>

	<body style="overflow-y: hidden" scroll="no">

		<div id="main">
			<div id="south">
				<div id="left">
					<form action="" id="searchpipecodeForm">
						<table cellpadding="0" cellspacing="1" class="formtable">
							<tr>

								<td colspan="5" align="center" style="font-size: 22"><span>铸管手工入库</span></td>
								<span></span>
								<td class="value"><input type="button" class="button" name="查询" onclick="checkorder()" value="查询生产计划" style="font-size: 22 ">
								</td>
								<td class="value">
									<input type="button" name="添加计划到列表" onclick="addPipecode()" value="添加计划到列表" style="font-size: 14,large; ">
								</td>
								<td class="value"><input type="button" class="button" name="提交入库信息" value="提交入库信息" onclick="save()"></td>
							</tr>
							<tr>
								<td align="right"><label class="Validform_label"> 年份: </label>
								</td>
								<td class="value"><input class="Wdate" id="pYear" name="pYear" ignore="ignore" datatype="n"> <span class="Validform_checktip"></span>
								</td>
								<td align="right"><label class="Validform_label"> 月份: </label>
								</td>
								<td class="value"><input class="inputxt" id="pMonth" name="pMonth" ignore="ignore" datatype="*"> <span class="Validform_checktip"></span>
								</td>
								<td align="right"><label class="Validform_label"> 规格: </label>
								</td>
								<td class="value">
									<t:dictSelect field="dn" type="select" datatype="*" dictTable="t_zg_code_pipe_dn" dictField="dn" dictText="dn" id="pipetype"></t:dictSelect> <span class="Validform_checktip"></span>
								</td>
								<td align="right"><label class="Validform_label"> 内外销（0：内销；1：外销）:
				</label>
								</td>
								<td class="value"><input class="inputxt" id="expflag" name="expflag" ignore="ignore" datatype="*"> <span class="Validform_checktip"></span>
								</td>

							</tr>
							<tr>

								<td align="right"><label class="Validform_label"> 接口方式:
				</label>
								</td>
								<td class="value">
									<t:dictSelect field="interface_desc" type="select" datatype="*" dictTable="V_MYBM_JQ_JK" dictField="接口名称" dictText="接口名称"></t:dictSelect> <span class="Validform_checktip"></span>
								</td>

								<td align="right"><label class="Validform_label"> 壁厚等级:
				</label>
								</td>
								<td class="value">
									<t:dictSelect field="grade" type="select" datatype="*" dictTable="V_MYBM_ZG_DJ" dictField="等级描述" dictText="等级描述"></t:dictSelect> <span class="Validform_checktip"></span>
								</td>

								<td align="right"><label class="Validform_label" style="width:35px"> 长度: </label>
								</td>
								<td class="value">
									<t:dictSelect field="my_length" type="select" datatype="*" dictTable="V_MYBM_ZG_CD" dictField="长度描述" dictText="长度描述" id="my_length"></t:dictSelect> <span class="Validform_checktip"></span>
								</td>
								<td align="right">
									<label class="Validform_label">
							生产线:
						</label>
								</td>
								<td class="value">
									<t:dictSelect field="product_line" type="select" datatype="*" dictTable="T_ZG_PACKAGE_LINE" dictField="line_name" dictText="line_name" id="product_line"></t:dictSelect>
									<span class="Validform_checktip"></span>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div id="right">
					<div style="border: 1px solid red; height: 200px;width:1400px;" align="left">
						<t:datagrid name="instoreDataList" title="计划列表" checkbox="true" actionUrl="myjkscjhController.do?orderDataGrid" idField="product_plan_no">
							<t:dgCol title="计划号" field="product_plan_no" frozenColumn="true"></t:dgCol>
							<t:dgCol title="年" field="pYear" frozenColumn="true"></t:dgCol>
							<t:dgCol title="月" field="pMonth" frozenColumn="true"></t:dgCol>
							<t:dgCol title="规格" field="dn" frozenColumn="true"></t:dgCol>
							<t:dgCol title="等级" field="grade" frozenColumn="true"></t:dgCol>
							<t:dgCol title="产品编码" field="item_code"></t:dgCol>
							<t:dgCol title="产品中文名称" field="item_cname"></t:dgCol>
							<t:dgCol title="内外销标示" field="expFlag"></t:dgCol>
							<t:dgCol title="特殊合同描述" field="special_desc"></t:dgCol>
						</t:datagrid>
					</div>
				</div>
			</div>
			<div id="top">
				<div style="border: 1px solid blue; height: 500px;width:1400px;" align="left">
					<t:datagrid name="instoreDetailList" title="入库数据" checkbox="true" actionUrl="" idField="id" autoLoadData="false">
						<t:dgCol title="编辑行" field="opt_editor" formatterjs="edit"></t:dgCol>
						<t:dgCol title="添加行" field="opt_add" formatterjs="add"></t:dgCol>
						<t:dgCol title="删除行" field="opt_del" formatterjs="del"></t:dgCol>
						<t:dgCol title="年份" field="pyear" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="批号" field="batch" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="管序号" field="pipeserial" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="包号" field="packid" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="支数" field="pipenum" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="规格" field="dn"></t:dgCol>
						<t:dgCol title="生成计划号" field="productPlanNo"></t:dgCol>
						<t:dgCol title="产品编码" field="itemCode"></t:dgCol>
						<t:dgCol title="产品中文名称" field="itemCname"></t:dgCol>
						<t:dgCol title="内外销标示" field="expFlag"></t:dgCol>
						<t:dgCol title="特殊合同描述" field="specialDesc"></t:dgCol>
						<t:dgCol title="入库单号" field="rukudanid"></t:dgCol>
						<t:dgCol title="货位" field="huowei" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="层号" field="cengci" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="层内序号" field="cengneixuhao" extendParams="editor:'text'"></t:dgCol>
						<t:dgCol title="编号" field="id"></t:dgCol>
					</t:datagrid>

				</div>
			</div>

	</body>
	<script type="text/javascript">
		function padLeft(str, lenght) {
			if (str.length >= lenght)
				return str;
			else
				return padLeft("0" + str, lenght);
		}

		function getUuid() {
			var len = 36; //32长度
			var radix = 16; //16进制
			var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
			var uuid = [],
				i;
			radix = radix || chars.length;
			if (len) {
				for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
			} else {
				var r;
				uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
				uuid[14] = '4';
				for (i = 0; i < 36; i++) {
					if (!uuid[i]) {
						r = 0 | Math.random() * 16;
						uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
					}
				}
			}
			return uuid.join('');
		}

		function add(val, row, index) {
			return '<a href="#"   onclick="javascript:void(0);">添加</a>';
		}

		function edit(val, row, index) {
			return '<a href="#"  onclick="javascript:void(0);">编辑</a>';
		}

		function del(val, row, index) {
			return '<a href="#"  onclick="javascript:void(0);">删除</a>';
		}
		var rukudanid = getUrlParam("rukudanid");

		$(document).ready(function() {

			$('#rukudanid').val(rukudanid);
			$("#pYear").attr("class", "Wdate").click(function() {
				WdatePicker({
					dateFmt: 'yyyy'
				});
			});
			var sdate = new Date();
			var pmonth = sdate.getMonth() + 1;
			var mymonth = padLeft(pmonth, 2);
			$("#pYear").val(sdate.getFullYear());
			$("#pMonth").val(mymonth);
			$("#instoreDetailList").datagrid({
				onClickCell: function(rowIndex, field, value) {
					console.log("当前行==》》》" + rowIndex);
					if (field == "opt_add") {
						alert('添加单元格');
						addRow(rowIndex);
					} else if (field == "opt_editor") {
						alert('编辑单元格');
						editRow(rowIndex)
					} else if (field == "opt_del") {
						alert('删除单元格');
						delRow(rowIndex);
					}
				}
			});
			//addRow(0);
		});
		//编辑行
		function editRow(index) {
			console.log("editRow.index="+index);
			
			var rows = $('#instoreDetailList').datagrid("getChecked");
			console.log("editRow.rows.length="+rows.length);
			if (rows.length == 0) {
				tip("请选择条目");
				return false;
			}
			for (var i = 0; i < rows.length; i++) {
				var index = $('#instoreDetailList').datagrid('getRowIndex', rows[i]);
				$('#instoreDetailList').datagrid('beginEdit', index);
			}
		}
		//结束编辑
		function endEdit() {
			var editIndex = $('#instoreDetailList').datagrid('getRows').length - 1;
			for (var i = 0; i <= editIndex; i++) {
				if ($('#instoreDetailList').datagrid('validateRow', i))
					$('#instoreDetailList').datagrid('endEdit', i);
				else
					return false;
			}
			return true;
		}
		//添加行
		function addRow(index) {
			var rows = $('#instoreDetailList').datagrid('getRows')[index];
			console.log(rows);
			$('#instoreDetailList').datagrid('appendRow', {
				id: getUuid(),
				pyear: rows.pyear,
				productLine: $("#product_line").val(),
				dn: rows.dn,
				productPlanNo: rows.productPlanNo,
				itemCode: rows.itemCode,
				itemCname: rows.itemCname,
				expFlag: rows.expFlag,
				specialDesc: rows.specialDesc,
				rukudanid: rukudanid
			});
			var editIndex = $('#instoreDetailList').datagrid('getRows').length - 1;
			$('#instoreDetailList').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);

			//console.log(insertDataGridModel._data);

		}

		//删除行
		function delRow(index) {
			//editIndex = $('#instoreDetailList').datagrid('getRows').length;
			//$('#instoreDetailList').datagrid('deleteRow', index);
			//$('#instoreDetailList').datagrid('clearChecked');
			//editIndex = undefined;
			//resetTrNum('instoreDetailList');	
			console.log("deleRow.index=" + index);
			$('#instoreDetailList').datagrid('deleteRow', index);
			var rows = $('#instoreDetailList').datagrid('getRows');
			console.log("rows=" + rows.length);
			var editIndex = rows.length - 1;
			console.log("editIndex=" + editIndex);
			if (editIndex < 0) {
				endEdit();
			} else {

				$('#instoreDetailList').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
			}

		}

		//初始化下标
		function resetTrNum(tableId) {
			$tbody = $("#" + tableId + "");
			$tbody.find('>tr').each(function(i) {
				$(':input, select', this).each(function() {
					var $this = $(this),
						name = $this.attr('name'),
						val = $this.val();
					if (name != null) {
						if (name.indexOf("#index#") >= 0) {
							$this.attr("name", name.replace('#index#', i));
						} else {
							var s = name.indexOf("[");
							var e = name.indexOf("]");
							var new_name = name.substring(s + 1, e);
							$this.attr("name", name.replace(new_name, i));
						}
					}
				});
				$(this).find('div[name=\'xh\']').html(i + 1);
			});
		}
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
										this.value
									];
								}
							} else {
								serializeObj[this.name] = this.value;
							}
						});
				return serializeObj;
			};
			//扩展jquery的格式化方法
		})(jQuery);
		//根据用户输入的入库单好查询铸管部入库数据，查询到的数据作为铸管库入库数据，用户只需选择。
		function checkorder() {
			var data = $("#searchpipecodeForm").parseForm();
			$("#instoreDataList").datagrid("reload", data);
		};
		/**
		 *添加到详细表
		 **/
		function addPipecode() {

			var pipecodeListSelected = $("#instoreDataList").datagrid("getSelections");
			//console.log(pipecodeListSelected);
			var data_length = pipecodeListSelected.length;
			var productLine = $("#product_line").val();
			if (productLine == null) {
				alert("请选择生产线");
			}
			//  alert(productLine);
			var selectData = {};
			selectData.rows = [];
			for (var index in pipecodeListSelected) {

				var selectRowsData = pipecodeListSelected[index];
				var row = {};
				//管号表字段
				row.pyear = selectRowsData.pYear;
				row.productLine = productLine;
				row.dn = selectRowsData.dn;
				row.productPlanNo = selectRowsData.product_plan_no;
				row.itemCode = selectRowsData.item_code;
				row.itemCname = selectRowsData.item_cname;
				row.expFlag = selectRowsData.expFlag;
				row.specialDesc = selectRowsData.special_desc;
				row.rukudanid = rukudanid;
				row.id = getUuid();
				//alert(selectRowsData.batchFull);     		   	  	         		   	  	   		   	  	     		   		      		   		
				selectData.rows.push(row);
				//insertDataGridModel.insertRows(index,row);
			}
			//console.log(insertDataGridModel._data);

			$("#instoreDetailList").datagrid('loadData', selectData);
			$('#instoreDetailList').datagrid('selectRow', 0).datagrid('beginEdit', 0);
			console.log(selectData);
		};

		function save() {
			/**
			 *t_ZG_PIPEList获取全部选中记录
			 **/
			endEdit();
			var getSelectionsDatas = $('#instoreDetailList').datagrid("getRows");
			var mydata = JSON.stringify(getSelectionsDatas);
			console.info("mydata length:" + getSelectionsDatas.length);
			console.info("mydata:" + mydata);
			if (getSelectionsDatas.length < 1) {
				alert("请选择需要入库的管子！！！")
			} else {
				$.ajax({
					url: "t_ZGK_PIPE_RKDController.do?save2",
					data: {
						data: JSON.stringify(getSelectionsDatas)
					},
					dataType: "json",
					type: "POST",
					success: function(data) {
						console.info("data.obj:" + data.success);
						//是不是这里？？
						alert(data.msg);
						var win = frameElement.api.opener;
						if (data.success == true) {
							//frameElement.api.close();
							//win.tip(data.msg);
							//alert(data.msg);
							win.reloadTable();
						}
					}
				});
			}
		}

		function getUrlParam(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg); //匹配目标参数
			if (r != null) return unescape(r[2]);
			return null; //返回参数值
		};
	</script>