<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <style>
#main {
	
}


#south {
	
	padding: 0px;
	width: 60%,
}

#left {
	border: 1px;
	width: 30%,
}
</style>
  <title>铸管库入库单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(document).ready(function() {
	 
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
		 alert("data:"+data);
		$("#instoreDataList").datagrid("reload", data);
		$("#instoreDataList").datagrid("Footer", total);
		//$("#total").value("1231");
		
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
 				<td align="right"><label class="Validform_label"> 包号: </label>
				</td>
				<td class="value"><input class="inputxt" id="packid"
					name="packid" ignore="ignore" datatype="*"> <span
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
				</tr>
				<tr>
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
 </table>
 </form>
				</div>
				<div id="right">
					<div style=" height: 500px;" align="left">
					<t:datagrid name="instoreDataList" title="库存明细查询"
			actionUrl="CheckZGKKCInfoController.do?datagrid"
			idField="dn" >							
								<t:dgCol title="库名" field="store_name"  ></t:dgCol>
								<t:dgCol title="规格" field="dn" ></t:dgCol>
								<t:dgCol title="接口" field="INTERFACE_DESC" ></t:dgCol>
								<t:dgCol title="长度" field="LENGTH_DESC" ></t:dgCol>
								<t:dgCol title="锌层厚度" field="ZN_THICK_DESC" ></t:dgCol>
								<t:dgCol title="等级" field="PROD_GRADE_DESC" ></t:dgCol>
								<t:dgCol title="净重" field="PIECE_WT" ></t:dgCol>
								<t:dgCol title="支数" field="pipenum" ></t:dgCol>
								<t:dgCol title="包号" field="packageid" ></t:dgCol>
								<t:dgCol title="批号全称" field="batch_full" ></t:dgCol>
								<t:dgCol title="管序号" field="pipe_serial" ></t:dgCol>
								<t:dgCol title="货位" field="huowei" ></t:dgCol>
								<t:dgCol title="层号" field="cengci" ></t:dgCol>
								<t:dgCol title="层内序号" field="cengneixuhao" ></t:dgCol>
								
		</t:datagrid>
		
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>