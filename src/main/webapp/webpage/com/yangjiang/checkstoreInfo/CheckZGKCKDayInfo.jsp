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
      	data=JSON.stringify(getSelectionsDatas);
      	var tuikudanid=getUrlParam("tuikudanid");
      	console.info(getSelectionsDatas);
      	if(getSelectionsDatas.length<1){
      		alert("请选择需要入库的管子！！！")
      	}else{
      		$.ajax({
			    url: "t_ZGK_PIPE_TKDController.do?save",
			    data:{data:data,tuikudanid:tuikudanid},
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
				<td align="right"><label class="Validform_label"> 规格: </label>
				</td>
				<td class="value"><t:dictSelect field="dn" type="select"
						datatype="*" dictTable="t_zg_code_pipe_dn" dictField="dn"
						dictText="dn" id="pipetype"></t:dictSelect> <span
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
					<div style=" height: 500px;width:1600px;" align="left">
					<t:datagrid name="instoreDataList" title="铸管出库信息查询" checkbox="true"
			actionUrl="CheckZGKCKInfoController.do?datagrid"
			idField="outStoreDay">
							
								<t:dgCol title="库名" field="store_name"  ></t:dgCol>
								<t:dgCol title="出库日期" field="outStoreDay" ></t:dgCol>
								<t:dgCol title="产品编码" field="item_code" ></t:dgCol>
								<t:dgCol title="名称" field="item_cname" ></t:dgCol>
								<t:dgCol title="内外销" field="exp_flag" ></t:dgCol>
								<t:dgCol title="层内序号" field="special_desc" ></t:dgCol>
								<t:dgCol title="日出库数" field="cknum" ></t:dgCol>
								<t:dgCol title="入库重量" field="ckwt" ></t:dgCol>
								<t:dgCol title="规格" field="SPEC_DESC"  sortable="true"></t:dgCol>
								<t:dgCol title="接口" field="INTERFACE_DESC" ></t:dgCol>
								<t:dgCol title="等级" field="PROD_GRADE_DESC" ></t:dgCol>
								<t:dgCol title="长度" field="LENGTH_DESC" ></t:dgCol>
								<t:dgCol title="内涂" field="INNER_LINING_DESC" ></t:dgCol>
								<t:dgCol title="锌层厚度" field="ZN_THICK_DESC" ></t:dgCol>
								<t:dgCol title="外涂" field="OUTER_COATING_DESC" ></t:dgCol>
		</t:datagrid>
	</div>	
				</div>
			</div>
			
		</div>

	
 </body>