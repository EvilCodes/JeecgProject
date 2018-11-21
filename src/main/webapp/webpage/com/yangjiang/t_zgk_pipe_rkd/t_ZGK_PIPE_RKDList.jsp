<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>管材入库</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style type="text/css">
#main {
	border: 2px solid ;
	padding: 10px;
}

#top {
	min-height: 300px;
	width: 100%,
}

#south {
	padding: 10px;
	width: 60%,
}

#left {
	width: 100%,
}
</style>
</head>

<body>

	<div id="main">
		<div id="south">
				
		</div>			
	<div id="top">	
	<div style="height: 600px;width:1000px;">
				<t:datagrid name="pipeuplist" title=""
								checkbox="true"  actionUrl="#"  idField="pipe_code"  autoLoadData="false"
								  pagination="true"  >									  							 
								  <t:dgCol title="入库单号" field="rukudanid" ></t:dgCol>
								  <t:dgCol title="管材名称" field="item_cname" ></t:dgCol>
								  <t:dgCol title="管号" field="pipe_code"  ></t:dgCol>
								  <t:dgCol title="包号" field="packageid" ></t:dgCol>
								  <t:dgCol title="套装方式" field="suit_way"  extendParams="editor:'text'"></t:dgCol>	
								 <t:dgCol title="货位" field="huowei"  extendParams="editor:'text'"></t:dgCol>															
								<t:dgCol title="层号" field="cengci"  extendParams="editor:'text'"></t:dgCol>								
								<t:dgCol title="层内序号" field="cengneixuhao"  extendParams="editor:'text'"></t:dgCol>																								
																								 																										
		</t:datagrid>
		<table>
		<tr>
		
		</tr>
		</table>
		</div>
	</div>
	
	
</body>
<script type="text/javascript">
function getUrlParam(name)
{
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
};

function getUuid(){
	  var len=36;//32长度
	  var radix=16;//16进制
	  var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');var uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
	  return uuid.join('');
	}  
function edit(val,row,index){  
    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
}  
$(document).ready(function() {	
	var rukudanid=getUrlParam("rukudanid");
	//alert("rukudanid:"+rukudanid);
	checkPipecode();
	$("#pipeuplist").datagrid({
		onClickCell:function(rowIndex, field, value){
			console.log("当前行==》》》"+rowIndex);								
			editRow(rowIndex);		
		}
	});	
});
 function checkPipecode() {			
		//var data = $("#checkform").parseForm();						
		var rukudanid=getUrlParam("rukudanid");
		$.ajax({
		    url: "PipeUpcontroller.do?PipeUpDataGrid",
		    data:{rukudanid:rukudanid},
		    dataType: "json",
		    type: "POST",          
		    success: function (data) {
		    	$("#pipeuplist").datagrid("loadData", data);
		    }
	});  
	
	};	
		//结束编辑
		function endEdit(){
			//这里不应该只是编辑当前行？？？？？
			var  editIndex = $('#pipeuplist').datagrid('getRows').length-1;
			for(var i=0;i<=editIndex;i++){
				if($('#pipeuplist').datagrid('validateRow', i))
					$('#pipeuplist').datagrid('endEdit', i);
				else
					return false;
			}
			return true;
		}
		//编辑行
		function editRow(index){
			var rows=$('#pipeuplist').datagrid("getChecked");
			if(rows.length==0){
				tip("请选择条目");
				return false;
			}
			$('#pipeuplist').datagrid('beginEdit', index);
		}
		function saveData(){	
			endEdit();			
          	var getSelectionsDatas=$('#pipeuplist').datagrid("getSelections");   
          	var jsondata=JSON.stringify(getSelectionsDatas);
          	console.info("getSelectionsDatas:"+getSelectionsDatas);
          	console.info("jsondata:"+jsondata);
          	$.ajax({
				    url: "t_ZGK_PIPE_RKDController.do?pipeup",
				    data:{data:JSON.stringify(getSelectionsDatas)},
				    dataType: "json",
				    type: "POST",          
				    success: function (data) {
				        alert(data.msg);
				    }
			});  
          	//$("#t_ZGK_FYJH_PCDList").datagrid(reload);
		}
 </script>
