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
  <title>退库信息查询</title>
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
		 //alert("data:"+data);
		$("#instoreDataList").datagrid("reload", data);
		
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
 				<td align="right">
						<label class="Validform_label">
							开始日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="sriqi" name="sriqi" ignore="ignore">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							结束日期:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="eriqi" name="eriqi" ignore="ignore">
						<span class="Validform_checktip"></span>
					</td>
 				<td align="right"><label class="Validform_label"> 退库单号: </label>
				</td>
				<td class="value"><input class="inputxt" id="ruikudanid"
					name="ruikudanid" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
 				
				
				</tr>
				<tr>
				<td align="right"><label class="Validform_label"> 包号: </label></td>
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
				<td><input type="button" name="查询" onclick="checkpipe()"
					value="查询" style="font-size: large; ">
				</td>
				
			</tr>			
 </table>
 </form>
				</div>
				<div id="right">
					<div style=" height: 500px;width:1600px;" align="left">
					<t:datagrid name="instoreDataList" title="铸管部交库数据查询"
			actionUrl="CheckZGKJKInfoController.do?datagrid"
			idField="dn" >		
								<t:dgCol title="入库单号" field="rukudanid"  ></t:dgCol>					
								<t:dgCol title="库名" field="store_name"  ></t:dgCol>
								<t:dgCol title="规格" field="dn" ></t:dgCol>
								<t:dgCol title="日期" field="riqi" ></t:dgCol>
								<t:dgCol title="生产计划号" field="product_plan_no" ></t:dgCol>
								<t:dgCol title="批号全称" field="batch_full" ></t:dgCol>
								<t:dgCol title="包号" field="packageid" ></t:dgCol>
								<t:dgCol title="支数" field="pipenum" ></t:dgCol>
								<t:dgCol title="管序号" field="pipe_serial" ></t:dgCol>
								<t:dgCol title="名称" field="item_cname" ></t:dgCol>						
								<t:dgCol title="管号" field="pipe_code" ></t:dgCol>
								<t:dgCol title="年份" field="p_year" ></t:dgCol>
								<t:dgCol title="内外销" field="exp_flag" ></t:dgCol>
								
		</t:datagrid>
		
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>