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
  function getUrlParam(name)
	{
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg);  //匹配目标参数
			if (r!=null) return unescape(r[2]); return null; //返回参数值
	};
  var tuikudanid=getUrlParam("tuikudanid");
  console.log("tuikudanid:"+tuikudanid);
  //var id=getUrlParam("id"); 
  $(document).ready(function() {
	  
	  $('#tuikudanid').val(tuikudanid);
	   console.log("tuikudanid  1111:"+tuikudanid);
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
	function save(){	
		/**
		*t_ZG_PIPEList获取全部选中记录
		**/
		//endEdit();
      	var getSelectionsDatas=$('#instoreDataList').datagrid("getSelections");
      	alert(getSelectionsDatas.length);
      	data=JSON.stringify(getSelectionsDatas);
      	var tuikudanid=getUrlParam("tuikudanid");
      	console.info(getSelectionsDatas);      	
      		$.ajax({
			    url: "t_ZGK_PIPE_TKDController.do?save",
			    data:{data:JSON.stringify(getSelectionsDatas),tuikudanid:tuikudanid},
			    dataType: "json",
			    type: "POST",          
			    success: function (data) {
			        //alert(data.msg);
			    	var win = frameElement.api.opener;
			    	if(data.success==true){
			    		frameElement.api.close();
			    		win.tip(data.msg);
			    		win.reloadTable();
			    	}
			    }
			});  
      	
	}
 </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">

		<div id="main">
			<div  id="south">
				<div id="left">
					<form action="" id="searchpipecodeForm">
 <table cellpadding="0" cellspacing="1" class="formtable">
 	<tr>		
 				<td align="right"><label class="Validform_label"> 退库单号: </label>
				</td>
				<td class="value"><input class="inputxt" id="tuikudanid"
					name="tuikudanid" ignore="ignore" datatype="*" disabled="true"> <span
					class="Validform_checktip"></span>
				</td>								
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
				</tr>
				<tr>
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
				<td align="right"><label class="Validform_label"> 包号: </label>
				</td>
				<td class="value"><input class="inputxt" id="packageid"
					name="packageid" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				<td><input type="button" name="查询" onclick="checkpipe()"
					value="查询" style="font-size: large; ">
				</td>
				<td>
				<input type="button" name="保存" value="保存" onclick="save()" style="font-size: large;color: red">
				</td>
			</tr>			
 </table>
 </form>
				</div>
				<div id="right">
					<div style="border: 1px solid; height: 500px;width:1600px;" align="left">
					<t:datagrid name="instoreDataList" title="" checkbox="true"
			actionUrl="CheckOutstorePipeCodeController.do?pipecodeDataGrid"
			idField="id">
								<t:dgCol title="编号" field="id"  hidden="true"></t:dgCol>
								<t:dgCol title="批号全称" field="batchFull"  ></t:dgCol>
								<t:dgCol title="管序号" field="pipeSerial" ></t:dgCol>
								<t:dgCol title="规格" field="dn" ></t:dgCol>
								<t:dgCol title="垛位号" field="huowei" ></t:dgCol>
								<t:dgCol title="层号" field="cengci" ></t:dgCol>
								<t:dgCol title="层内序号" field="cengneixuhao" ></t:dgCol>
								<t:dgCol title="生产计划号" field="productPlanNo" ></t:dgCol>
								<t:dgCol title="名称" field="itemCname" ></t:dgCol>
								<t:dgCol title="编码" field="itemCode" ></t:dgCol>
								<t:dgCol title="特殊合同描述" field="specialDesc" ></t:dgCol>
								<t:dgCol title="内外销标志" field="expFlag" ></t:dgCol>
								<t:dgCol title="支数" field="pipenum" ></t:dgCol>
								<t:dgCol title="套装方式" field="suitWay" ></t:dgCol>
								<t:dgCol title="生产线" field="productLine" ></t:dgCol>
								<t:dgCol title="包号" field="packageid" ></t:dgCol>
		</t:datagrid>
		
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>