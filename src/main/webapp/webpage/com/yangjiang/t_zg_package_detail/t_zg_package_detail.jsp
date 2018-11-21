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
  <title>铸管库入库单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  function edit(val,row,index){  
	    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
	}  
  var rukudanid=getUrlParam("rukudanid");
  var id=getUrlParam("id");
  $(document).ready(function() {
	  //$('#rukudanid').val(rukudanid);
	  $("#instoreDetailList").datagrid({
			onClickCell:function(rowIndex, field, value){
				console.log("当前行==》》》"+rowIndex);								
				 if(field=="opt_editor"){
				//	alert('编辑单元格');
					editRow(rowIndex)
				}
			}
		});
	});
 
//结束编辑
	function endEdit(){
		//这里不应该只是编辑当前行？？？？？
		var  editIndex = $('#instoreDetailList').datagrid('getRows').length-1;
		for(var i=0;i<=editIndex;i++){
			if($('#instoreDetailList').datagrid('validateRow', i))
				$('#instoreDetailList').datagrid('endEdit', i);
			else
				return false;
		}
		return true;
	}
	//编辑行
	function editRow(index){
		var rows=$('#instoreDetailList').datagrid("getChecked");
		if(rows.length==0){
			tip("请选择条目");
			return false;
		}
		$('#instoreDetailList').datagrid('beginEdit', index);
	}
  //初始化下标
	function resetTrNum(tableId) {
		$tbody = $("#"+tableId+"");
		$tbody.find('>tr').each(function(i){
			$(':input, select', this).each(function(){
				var $this = $(this), name = $this.attr('name'), val = $this.val();
				if(name!=null){
					if (name.indexOf("#index#") >= 0){
						$this.attr("name",name.replace('#index#',i));
					}else{
						var s = name.indexOf("[");
						var e = name.indexOf("]");
						var new_name = name.substring(s+1,e);
						$this.attr("name",name.replace(new_name,i));
					}
				}
			});
			$(this).find('div[name=\'xh\']').html(i+1);
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
  //根据用户输入的入库单好查询铸管部入库数据，查询到的数据作为铸管库入库数据，用户只需选择。
  function checkpack() {		
		var data = $("#searchpipecodeForm").parseForm();
		$("#instoreDataList").datagrid("reload", data);
	};	
	/**
	*添加到详细表
	**/
	function addPipecode(){			
            var pipecodeListSelected = $("#instoreDataList").datagrid("getSelections"); 
            //console.log(pipecodeListSelected);
            var data_length=pipecodeListSelected.length;
            alert(data_length);
       		var selectData = {};
       		selectData.rows =[];
          	for(var index in pipecodeListSelected){
          		
          			var selectRowsData = pipecodeListSelected[index];
          		   	var row ={};
          		   	//管号表字段
          		   	row.rukudanid =rukudanid 
          		  	row.pipeCode=selectRowsData.pipecode;
      		   	  	row.dn=selectRowsData.dn;
      		   		row.batchFull=selectRowsData.batchfull;
      		   	  	row.pipeSerial=selectRowsData.pipeserial;;
      		   	  	row.packageid=selectRowsData.packid;
      		   	  	row.productPlanNo=selectRowsData.jihuahao;
      		   	  	row.itemCode=selectRowsData.itemcode;
      		   		row.itemCname=selectRowsData.itemname;     		  		
      				row.specialDesc=selectRowsData.special;
      		   	  	row.pipenum=selectRowsData.pipenum;     		   	  	
      		   	  	row.main_id=id;     		   	
          		    selectData.rows.push(row);
          	}
          	$("#instoreDetailList").datagrid('loadData', selectData);
          	console.info(selectData);
		};
		function save(){	
			/**
			*t_ZG_PIPEList获取全部选中记录
			**/
			endEdit();
          	var getSelectionsDatas=$('#instoreDetailList').datagrid("getSelections");
          	console.info(getSelectionsDatas);
          	if(getSelectionsDatas.length<1){
          		alert("请选择需要入库的管子！！！")
          	}else{
          	$.ajax({
				    url: "t_ZGK_PIPE_RKDController.do?save",
				    data:{data:JSON.stringify(getSelectionsDatas)},
				    dataType: "json",
				    type: "POST",          
				    success: function (data) {
				        alert(data.msg);
				    }
			});  
          	}
		}
		function getUrlParam(name)
		{
				var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
				var r = window.location.search.substr(1).match(reg);  //匹配目标参数
				if (r!=null) return unescape(r[2]); return null; //返回参数值
		};
		
 </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">

		<div id="main">
			<div  id="south">
				<div id="left">
					<form action="" id="searchpipecodeForm">
 <table cellpadding="0" cellspacing="1" class="formtable">
 	<tr>
 		<td align="right"><label>包号:</label></td>
 		<td >
				<input class="inputxt" id="packid" name="packid" datatype="*"  >								
		</td>
		<td align="right"><label>规格:</label></td>
 		<td >
				<input class="inputxt" id="dn" name="dn" datatype="*"  >								
		</td>
		<td align="right"><label>批号:</label></td>
 		<td >
				<input class="inputxt" id="batchfull" name="batchfull" datatype="*"  >								
		</td>
		<td align="left">
				<input name="查询数据"  type="button" value="查询数据"  onclick="checkpack()" style="font-size: large;">
		</td>										
	</tr>
 </table>
 </form>
				</div>
				<div id="right">
					<div style="border: 1px solid ; height: 500px;width:1400px;"
		align="left">
		<t:datagrid name="instoreDataList" title="包号列表" checkbox="true"
			actionUrl="CheckPackageController.do?instoreDataGrid"
			idField="pipe_code">			
			<t:dgCol title="包号" field="packid" frozenColumn="true"></t:dgCol>
			<t:dgCol title="批号全称" field="batchfull" frozenColumn="true"></t:dgCol>
			<t:dgCol title="规格" field="dn" frozenColumn="true"></t:dgCol>
			<t:dgCol title="包内支数" field="pipecount"></t:dgCol>			
			<t:dgCol title="管号" field="pipecode"></t:dgCol>
			<t:dgCol title="管序好" field="pipeserial"></t:dgCol>
			<t:dgCol title="生产计划号" field="jihuahao"></t:dgCol>
			<t:dgCol title="产品编码" field="itemcode"></t:dgCol>
			<t:dgCol title="产品中文名称" field="itemname"></t:dgCol>
			<t:dgCol title="特殊合同描述" field="special"></t:dgCol>
		</t:datagrid>
		<input type="button" name="添加入库管号" value="添加入库管号" onclick="addPipecode()">
	</div>	
				</div>
			</div>
			<div id="top">
		<div style="border: 1px solid; height: 300px;width:1600px;"
		align="left">
		<t:datagrid name="instoreDetailList" title="入库数据" checkbox="true"
			actionUrl="" idField="rukudanid" autoLoadData="false">			
			<t:dgCol title="入库单号" field="rukudanid" frozenColumn="true"></t:dgCol>
			<t:dgCol title="管号" field="pipeCode" frozenColumn="true"></t:dgCol>
			<t:dgCol title="规格" field="dn" frozenColumn="true"></t:dgCol>
			<t:dgCol title="批号全称" field="batchFull"></t:dgCol>
			<t:dgCol title="管序号" field="pipeSerial"></t:dgCol>
			<t:dgCol title="包号" field="packageid"></t:dgCol>
			<t:dgCol title="生产计划号" field="productPlanNo"></t:dgCol>
			<t:dgCol title="产品编码" field="itemCode"></t:dgCol>
			<t:dgCol title="产品中文名称" field="itemCname"></t:dgCol>
			<t:dgCol title="内外销标示" field="expFlag"></t:dgCol>
			<t:dgCol title="特殊合同描述" field="specialDesc"></t:dgCol>
			<t:dgCol title="日期" field="riqi" extendParams="editor:'datebox'"></t:dgCol>
			<t:dgCol title="保管员" field="baoguanyuan" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="支数" field="pipenum"></t:dgCol>
			<t:dgCol title="货位" field="huowei" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="层号" field="cengci" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="层内序号" field="cengneixuhao" extendParams="editor:'numberbox'"></t:dgCol>
			<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
		</t:datagrid>
		<input type="button" name="提交保存" value="提交入库" onclick="save()">
	</div>	
			</div>
		</div>

	
 </body>