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
  var fankudanid=getUrlParam("fankudanid");
 // var id=getUrlParam("id");
  $(document).ready(function() {
	 // $('#rukudanid').val(rukudanid);
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
  function checkinstorepipecode() {		
		var data = $("#searchpipecodeForm").parseForm();
		$("#instoreDataList").datagrid("reload", data);
	};	
	/**
	*添加到详细表
	**/
	function addPipecode(){			
            var pipecodeListSelected = $("#instoreDataList").datagrid("getChecked"); 
            var data_length=pipecodeListSelected.length;
            //alert(data_length);
       		var selectData = {};
       		selectData.rows =[];
          	for(var index in pipecodeListSelected){          		
          			var selectRowsData = pipecodeListSelected[index];
          		   	var row ={};        		   
      		   	  	row.dn=selectRowsData.dn;
      		   		row.batchFull=selectRowsData.batch_full;
      		   	  	row.pipeSerial=selectRowsData.pipe_serial;
      		   	  	row.packageid=selectRowsData.packageid;
      		   	  	row.itemCode=selectRowsData.item_code;
      		   		row.itemCname=selectRowsData.item_cname;
      		  		row.expFlag=selectRowsData.exp_flag;
      		  		row.suitWay=selectRowsData.suit_way;
      				row.specialDesc=selectRowsData.special_desc;
      		   	  	row.pipenum=selectRowsData.pipenum;
      		   		row.huowei=selectRowsData.huowei;  
      		  		row.cengneixuhao=selectRowsData.cengneixuhao;  
      				row.cengci=selectRowsData.cengci;  
          		    selectData.rows.push(row);
          	}
          	$("#instoreDetailList").datagrid('loadData', selectData);
		};
		function save(){	
			/**
			*t_ZG_PIPEList获取全部选中记录
			**/
			endEdit();
          	var getSelectionsDatas=$('#instoreDetailList').datagrid("getRows");
          	console.info(getSelectionsDatas);
          	if(getSelectionsDatas.length<1){
          		alert("请选择需要入库的管子！！！")
          	}else{
          	$.ajax({
				    url: "t_ZGK_PIPE_FCDController.do?save",
				    data:{data:JSON.stringify(getSelectionsDatas),fankudanid:fankudanid},
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
 		<td align="right"><label>出库单编号:</label></td>
 		<td >
				<input class="inputxt" id="chukudanid" name="chukudanid" datatype="*"  >								
		</td>
		<td align="right"><label>管号:</label></td>
 		<td >
				<input class="inputxt" id="pipecode" name="pipecode" datatype="*"  >								
		</td>
		<td align="right"><label>规格:</label></td>
 		<td >
				<input class="inputxt" id="dn" name="dn" datatype="*"  >								
		</td>
		<td align="right"><label>批号:</label></td>
 		<td >
				<input class="inputxt" id="batchfull" name="batchfull" datatype="*"  >								
		</td>
		<td align="right"><label>管序号:</label></td>
 		<td >
				<input class="inputxt" id="pipeSerial" name="pipeSerial" datatype="*"  >								
		</td>
		<td align="right"><label>销售公司:</label></td>
 		<td >
				<input class="inputxt" id="org_name" name="org_name" datatype="*"  >								
		</td>
		<td align="right"><label>收货单位:</label></td>
 		<td >
				<input class="inputxt" id="consign_cname" name="consign_cname" datatype="*"  >								
		</td>
		<td align="left">
				<input name="查询数据    "  type="button" value="查询数据"  onclick="checkinstorepipecode()" style="font-size: large;color: blue">
		</td>	
		<td>
		<input type="button" name="添加入库管号" value="添加入库管号" onclick="addPipecode()" style="font-size: large;color: red">									
		</td>
	</tr>
 </table>
 </form>
				</div>
				<div id="right">
					<div style="border: 1px solid ; height: 300px;width:1600px;"
		align="left">
		<t:datagrid name="instoreDataList" title="出库单管号列表" checkbox="true"
			actionUrl="CheckpipeCodeFCController.do?pipecodedatagrid"
			idField="id">
			
			<t:dgCol title="编码" field="id" ></t:dgCol>			
			<t:dgCol title="出库单号" field="chukudanid" frozenColumn="true"></t:dgCol>			
			<t:dgCol title="规格" field="dn" frozenColumn="true"></t:dgCol>
			<t:dgCol title="批号全称" field="batch_full"></t:dgCol>
			<t:dgCol title="管序号" field="pipe_serial"></t:dgCol>
			<t:dgCol title="包号" field="packageid"></t:dgCol>
			<t:dgCol title="产品编码" field="item_code" hidden="true"></t:dgCol>
			<t:dgCol title="产品中文名称" field="item_cname"></t:dgCol>
			<t:dgCol title="内外销标示" field="exp_flag"></t:dgCol>
			<t:dgCol title="特殊合同描述" field="special_desc"></t:dgCol>
			<t:dgCol title="套装方式" field="suit_way" hidden="true"></t:dgCol>
			<t:dgCol title="生产线" field="product_line"></t:dgCol>
			<t:dgCol title="支数" field="pipenum"></t:dgCol>
			<t:dgCol title="收货单位" field="consign_cname"></t:dgCol>
			<t:dgCol title="销售公司" field="org_name"></t:dgCol>
			<t:dgCol title="目的地" field="delivy_place_name"></t:dgCol>
			<t:dgCol title="货位" field="huowei" hidden="true"></t:dgCol>
			<t:dgCol title="层次" field="cengci" hidden="true"></t:dgCol>
			<t:dgCol title="层内序号" field="cengneixuhao" hidden="true"></t:dgCol>
		</t:datagrid>
		
	</div>	
	
				</div>
			</div>
			<div id="top">
		<div style="border: 1px solid blue; height: 300px;width:1600px;"
		align="left">
		<t:datagrid name="instoreDetailList" title="返厂管列表" checkbox="true"
			actionUrl="" idField="id" autoLoadData="false">						
			<t:dgCol title="规格" field="dn" frozenColumn="true" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="批号全称" field="batchFull" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="管序号" field="pipeSerial" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="包号" field="packageid" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="产品编码" field="itemCode" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="产品名称" field="itemCname" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="内外销标示" field="expFlag" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="特殊合同描述" field="specialDesc" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="生产线" field="productLine" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="支数" field="pipenum" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="套装方式" field="suitWay" extendParams="editor:'text'"></t:dgCol>			
			<t:dgCol title="货位" field="huowei" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="层号" field="cengci" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="层内序号" field="cengneixuhao" extendParams="editor:'text'"></t:dgCol>
			<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
		</t:datagrid>
		<input type="button" name="提交保存" value="提交入库" onclick="save()">
		<span style="color: red">提示：如果返厂的管子未找到或者管号不清晰，请对管号相对应的字段进行编辑，并在批号上加上*号这个特殊标志</span>
	</div>	
			</div>
		</div>

	
 </body>