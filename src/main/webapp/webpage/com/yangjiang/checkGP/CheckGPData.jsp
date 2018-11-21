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
  <title>光谱数据查询</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  function getUrlParam(name)
	{
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg);  //匹配目标参数
			if (r!=null) return unescape(r[2]); return null; //返回参数值
	};
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
		 console.log("data:"+data);
		$("#instoreDataList").datagrid("reload", data);
		
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
					<td align="right"><label class="Validform_label"> 试样编号: </label>
				</td>
				<td class="value"><input class="inputxt" id="sampleNo"
					name="sampleNo" ignore="ignore" datatype="*"> <span
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
					<div style=" height: 800px;width:1600px;" align="left">
					<t:datagrid name="instoreDataList" title="光谱数据查询" checkbox="true"
			actionUrl="CheckGPData.do?datagrid" idField="sampleNo">							
								<t:dgCol title="分析时间" field="rq" ></t:dgCol>
								<t:dgCol title="试样名称" field="sampleName" ></t:dgCol>
								<t:dgCol title="试样编号" field="sampleNo" ></t:dgCol>
								<t:dgCol title="判定" field="result" ></t:dgCol>
								<t:dgCol title="C" field="C" ></t:dgCol>
								<t:dgCol title="Si" field="Si" ></t:dgCol>
								<t:dgCol title="Mn" field="Mn" ></t:dgCol>
								<t:dgCol title="S" field="S" ></t:dgCol>
								<t:dgCol title="P" field="P" ></t:dgCol>
								<t:dgCol title="Mg" field="Mg" ></t:dgCol>
								<t:dgCol title="Ni" field="Ni" ></t:dgCol>
								<t:dgCol title="Cr" field="Cr" ></t:dgCol>
								<t:dgCol title="Mo" field="Mo" ></t:dgCol>
								<t:dgCol title="V" field="V" ></t:dgCol>
								<t:dgCol title="Ti" field="Ti" ></t:dgCol>
								<t:dgCol title="Al" field="Al" ></t:dgCol>
								<t:dgCol title="Pb" field="Pb" ></t:dgCol>
								<t:dgCol title="Ce" field="Ce" ></t:dgCol>
								<t:dgCol title="Cu" field="Cu" ></t:dgCol>
								<t:dgCol title="Ceq" field="Ceq" ></t:dgCol>
								<t:dgCol title="B" field="B" ></t:dgCol>
								<t:dgCol title="Sb" field="Sb" ></t:dgCol>
								<t:dgCol title="As1" field="As1" ></t:dgCol>
								<t:dgCol title="Sn" field="Sn" ></t:dgCol>
		</t:datagrid>
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>