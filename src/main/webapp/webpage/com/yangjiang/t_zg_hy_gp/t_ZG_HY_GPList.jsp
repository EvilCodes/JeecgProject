<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZG_HY_GPList" checkbox="true" title="光谱数据" actionUrl="t_ZG_HY_GPController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="分析时间" field="analyDate" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="试样名称" field="sampleName"   width="120"></t:dgCol>
   <t:dgCol title="试样编号" field="sampleNo"   width="120"></t:dgCol>
   <t:dgCol title="判定" field="result"   width="120"></t:dgCol>
   <t:dgCol title="c" field="c"   width="120"></t:dgCol>
   <t:dgCol title="si" field="si"   width="120"></t:dgCol>
   <t:dgCol title="mn" field="mn"   width="120"></t:dgCol>
   <t:dgCol title="s" field="s"   width="120"></t:dgCol>
   <t:dgCol title="p" field="p"   width="120"></t:dgCol>
   <t:dgCol title="mg" field="mg"   width="120"></t:dgCol>
   <t:dgCol title="ni" field="ni"   width="120"></t:dgCol>
   <t:dgCol title="cr" field="cr"   width="120"></t:dgCol>
   <t:dgCol title="mo" field="mo"   width="120"></t:dgCol>
   <t:dgCol title="v" field="v"   width="120"></t:dgCol>
   <t:dgCol title="ti" field="ti"   width="120"></t:dgCol>
   <t:dgCol title="al" field="al"   width="120"></t:dgCol>
   <t:dgCol title="pb" field="pb"   width="120"></t:dgCol>
   <t:dgCol title="ce" field="ce"   width="120"></t:dgCol>
   <t:dgCol title="cu" field="cu"   width="120"></t:dgCol>
   <t:dgCol title="ceq" field="ceq"   width="120"></t:dgCol>
   <t:dgCol title="lrsj" field="lrsj" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="b" field="b"   width="120"></t:dgCol>
   <t:dgCol title="sb" field="sb"   width="120"></t:dgCol>
   <t:dgCol title="as1" field="as1"   width="120"></t:dgCol>
   <t:dgCol title="sn" field="sn"   width="120"></t:dgCol>
   <t:dgCol title="lrr" field="lrr"   width="120"></t:dgCol>
   <t:dgCol title="lrbm" field="lrbm"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>    
   <t:dgToolBar title="判定" icon="icon-search" url="" funname="doBatchCheck"></t:dgToolBar>
   
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 function doBatchCheck(){
		var getSelections = $("#t_ZG_HY_GPList").datagrid("getSelections");
		if(getSelections.length==0){
			tip("请选择要判定的条目");
			return;
		}
		var ids = [];
		for(var index in getSelections){
			var row =getSelections[index];
			ids.push(row.id);
		}
		$.dialog.confirm("确定要通过判定吗？",function(){
			$.ajax({
				url:"t_ZG_HY_GPController.do?doCheck",
				data:{ids:ids.join(",")},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZG_HY_GPList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
 
 
 </script>