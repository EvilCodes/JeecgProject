<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>添加批号</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_zg_batchController.do?save">
			<input id="id" name="id" type="hidden" value="${t_zg_batchPage.id }">
			<table style="width: 800px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							规格:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="dn" type="select" datatype="*"  dictTable="t_zg_code_pipe_dn"
						dictField="dn" dictText="dn"  id="pipetype"  ></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							批号全称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="batchFull" name="batchFull" 
							    datatype="*" >
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							年份:
						</label>
					</td>
					<td class="value">						
						<input class="Wdate" id="pYear" name="pYear" ignore="ignore" datatype="n">
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							批号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="batch" name="batch" 
							   value="${t_zg_batchPage.batch}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>					
					<td align="right">
						<label class="Validform_label">
							接口方式:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="interfaceDesc" type="select" datatype="*" dictTable="V_MYBM_ZG_JK"
						dictField="接口描述" dictText="接口描述" ></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>										
				</tr>				
				<tr>
					<td align="right">
						<label class="Validform_label">
							壁厚等级:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="grade" type="select" datatype="*" dictTable="V_MYBM_ZG_DJ"
						dictField="等级描述" dictText="等级描述" ></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				
					<td align="right">
						<label class="Validform_label">
							长度:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="length" type="select" datatype="*" dictTable="V_MYBM_ZG_CD"
						dictField="长度描述" dictText="长度描述"></t:dictSelect>
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				
				
			</table>
		</t:formvalid>
		<script type="text/javascript">
$(document).ready(function(){
	  
	  $("#pYear").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy'});});
	  //$("#usetime").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	   //$("#productDate").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	 var stDate=new Date();
	 var stYear=stDate.getFullYear()
	 $("#pYear").val(stYear);
	 
	
	 $("#pYear").change(function(){
				batchFull();
	});
	
	$("#batch").change(function(){
				batchFull();
	});	
	var ss=$("#batchFull").val();
	console.info("111:"+ss);
	});
	
	
function batchFull(){
			var pYear=$("#pYear").val();
			var batch=$("#batch").val();
			console.info("pYear:"+pYear);
			console.info("batch:"+batch);		
			$("#batchFull").val(pYear+"-"+batch);
		};
















</script>
 </body>