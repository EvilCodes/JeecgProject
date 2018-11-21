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
  <title>倒货位</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  function edit(val,row,index){  
	    return '<a href="#"  onclick="editRow('+index+')">编辑</a>';  
	}  
  function getUrlParam(name)
	{
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg);  //匹配目标参数
			if (r!=null) return unescape(r[2]); return null; //返回参数值
	};
 
  $(document).ready(function() {
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
  function checkpipe(){	
	  //alert("111");
		var data = $("#searchpipecodeForm").parseForm();
		 console.log("data:"+data);
		$("#instoreDataList").datagrid("reload", data);
		
	};
	//结束编辑
	function endEdit(){
		//这里不应该只是编辑当前行？？？？？
		var  editIndex = $('#instoreDataList').datagrid('getRows').length-1;
		for(var i=0;i<=editIndex;i++){
			if($('#instoreDataList').datagrid('validateRow', i))
				$('#instoreDataList').datagrid('endEdit', i);
			else
				return false;
		}
		return true;
	}
	//编辑行
	function editRow(index){
		var rows=$('#instoreDataList').datagrid("getChecked");
		//alert("开始编辑");
		if(rows.length==0){
			tip("请选择条目");
			return false;
		}
		//alert("开始编辑instoreDataList");
		$('#instoreDataList').datagrid('beginEdit',index);
	}
	function save(){	
		/**
		*t_ZG_PIPEList获取全部选中记录
		**/
		//endEdit();
     	//var getSelectionsDatas=$('#instoreDataList').datagrid("getSelections");
      		var getSelectionsDatas=$('#instoreDataList').datagrid("getChecked");
      	    console.info(getSelectionsDatas);     	
      	 
   		var riqi=$("#riqi").val();
   		//alert("riqi:"+riqi);
   		if(riqi==""){
      		alert("请选择日期");
      		return ;
      	}else{
      		
      	//var pipecodeListSelected = $("#instoreDataList").datagrid("getSelections"); 
            //console.log(pipecodeListSelected);
       	/*	var selectData = {};
       		selectData.rows =[];
      	
      for(var index in getSelectionsDatas){   		
      			var selectRowsData = getSelectionsDatas[index];
      		   	var row ={};
      		   	row.riqi =riqi; 
      		  	row.pipeCode=selectRowsData.dn+"-"+selectRowsData.batchFull+"-"+selectRowsData.pipeSerial;
  		   	  	row.storeName=selectRowsData.store_name;
  		   		row.batchFull=selectRowsData.batch_full;
  		   	  	row.afterHuowei=selectRowsData.after_huowei;
  		   		row.beforeCengci=selectRowsData.huowei;
  		  		row.beforeCengneixuhao=selectRowsData.cengneixuhao;
  				row.beforeHuowei=selectRowsData.huowei;
  		   	  	row.afterCengci=selectRowsData.after_cengci;
  		   	  	row.afterCengneixuhao=selectRowsData.after_cengneixuhao;
  		   		//row.daohuoweiid="D201612011001";
      		    selectData.rows.push(row);
      	}
        console.log("aaaaaa:"+JSON.stringify(selectData));*/
      	var data=JSON.stringify(getSelectionsDatas);
      //	var data=JSON.stringify(selectData);
      	console.log("selectData:"+data);
      	var after_huowei=$("#after_huowei").val();
      	var after_cengci=$("#after_cengci").val();
      	var after_cengneixuhao=$("#after_cengneixuhao").val();
      	//console.log("*************"+after_cengneixuhao);
      	//return;   
    	$.ajax({
		    url: "t_ZGK_PIPE_DHWController.do?save",
		    data:{data:data,riqi:riqi,after_huowei:after_huowei,after_cengci:after_cengci,after_cengneixuhao:after_cengneixuhao},
		    dataType: "json",
		    type: "POST",          
		    success: function (data) {
		        alert(data.msg);
		    }
	});  
      	}      	     	    	      	           	      	
	}
 </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">

		<div id="main">
			<div  id="south">
				<div id="left">
					<form action="" id="searchpipecodeForm">
 <table cellpadding="0" cellspacing="1" class="formtable">
 	<tr>		<td><label>日期:</label>
					</td>
					<td><input class="Wdate"
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px"
						id="riqi" name="riqi" ignore="ignore"></td>						
				<td align="right"><label class="Validform_label"> 批号全称: </label>
				</td>
				<td class="value"><input class="inputxt" id="batchfull"
					name="batchfull" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label">管序号: </label>
				</td>
				<td class="value"><input class="inputxt" id="pipeserial"
					name=""pipeserial"" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 规格: </label>
				</td>
				<td class="value"><t:dictSelect field="dn" type="select"
						datatype="*" dictTable="t_zg_code_pipe_dn" dictField="dn"
						dictText="dn" id="pipetype"></t:dictSelect> <span
					class="Validform_checktip"></span>
				</td>
				
				<td align="right"><label class="Validform_label"> 垛位号: </label>
				</td>
				<td class="value"><input class="inputxt" id="huowei"
					name="huowei" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 层号: </label>
				</td>
				<td class="value"><input class="inputxt" id="cengci"
					name="cengci" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 层内序号: </label>
				</td>
				<td class="value"><input class="inputxt" id="cengneixuhao"
					name="cengneixuhao" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td><input type="button" name="查询" onclick="checkpipe()"
					value="查询" style="font-size: large; ">
				</td>
				
			</tr>
			<tr>
			<td align="right"><label class="Validform_label"> 目标垛位号: </label>
				</td>
				<td class="value"><input class="inputxt" id="after_huowei"
					name="after_huowei"> <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 目标层号: </label>
				</td>
				<td class="value"><input class="inputxt" id="after_cengci"
					name="after_cengci" > <span
					class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 目标层内序号: </label>
				</td>
				<td class="value"><input class="inputxt" id="after_cengneixuhao"
					name="after_cengneixuhao" > <span
					class="Validform_checktip"></span>
				</td>
			</tr>
					
 </table>
 </form>
				</div>
				<div id="right">
					<div style="border: 1px solid; height: 300px;width:1600px;" align="left">
					<t:datagrid name="instoreDataList" title="" checkbox="true"
			        actionUrl="CheckOutstorePipeCodeController.do?pipecodeDataGrid"  idField="id">
								<t:dgCol title="仓库名称" field="store_name"  ></t:dgCol>
								<t:dgCol title="批号全称" field="batchFull"  ></t:dgCol>
								<t:dgCol title="管序号" field="pipeSerial" ></t:dgCol>
								<t:dgCol title="规格" field="dn" ></t:dgCol>
								<t:dgCol title="原垛位号" field="huowei" ></t:dgCol>
								<t:dgCol title="原层号" field="cengci" ></t:dgCol>
								<t:dgCol title="原层内序号" field="cengneixuhao" ></t:dgCol>								
								<t:dgCol title="生产计划号" field="productPlanNo" ></t:dgCol>
								<t:dgCol title="名称" field="itemCname" ></t:dgCol>
								<t:dgCol title="编码" field="itemCode" ></t:dgCol>
								<t:dgCol title="特殊合同描述" field="specialDesc" ></t:dgCol>
								<t:dgCol title="内外销标志" field="expFlag" ></t:dgCol>
								<t:dgCol title="支数" field="pipenum" ></t:dgCol>
								<t:dgCol title="套装方式" field="suitWay" ></t:dgCol>
								<t:dgCol title="生产线" field="productLine"  extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="包号" field="packageid" ></t:dgCol>								
								<t:dgCol title="目标垛位号" field="after_huowei1"  extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="目标层号" field="after_cengci1"  extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="目标层内序号" field="after_cengneixuhao1"  extendParams="editor:'text'"></t:dgCol>
								<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
								<t:dgCol title="id" field="id" ></t:dgCol>
		</t:datagrid>
		<input type="button" name="保存" value="添加" onclick="save()">
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>