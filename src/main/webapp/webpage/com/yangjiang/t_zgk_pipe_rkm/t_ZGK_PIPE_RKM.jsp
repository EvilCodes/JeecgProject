<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>铸管库入库</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  Date.prototype.Format = function(fmt)   
	{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
	} ;
  
  </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZGK_PIPE_RKMController.do?save" >
			<input id="id" name="id" type="hidden" value="${t_zgk_pipe_rkmPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
				<td align="right">
						<label class="Validform_label">
							入库单编号：
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="rukudanid" name="rukudanid" ignore="ignore"
							   value="${t_zgk_pipe_rkmPage.rukudanid}" autocomplete="on">
						<span class="Validform_checktip"></span>
					</td>
					<td align="right">
						<label class="Validform_label">
							日期:
						</label>
					</td>
					<td class="value">
							   <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="riqi" name="riqi" ignore="ignore"
							     value="<fmt:formatDate value='${t_zgk_pipe_rkmPage.riqi}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仓库名称:
						</label>
					</td>
					<td class="value"><t:dictSelect field="storeName" type="select"
						datatype="*" dictTable="T_ZGK_XDM_CPK" dictField="store_name"
						dictText="store_name" id="storeName"></t:dictSelect> 						
						<span
					class="Validform_checktip"></span>			
					<td align="right">
						<label class="Validform_label">
							保管员:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="baoguanyuan" name="baoguanyuan" ignore="ignore"
							   value="${t_zgk_pipe_rkmPage.baoguanyuan}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				
					</tr>
			</table>
		</t:formvalid>

 </body>
 <script type="text/javascript">
$(document).ready(function(){	  	  
	   $("#riqi").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd hh:mm:ss'});});
});
</script>