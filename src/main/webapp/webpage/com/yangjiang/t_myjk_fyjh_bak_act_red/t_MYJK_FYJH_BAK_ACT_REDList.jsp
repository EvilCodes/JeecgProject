<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_MYJK_FYJH_BAK_ACT_REDList" title="数据红冲" actionUrl="t_MYJK_FYJH_BAK_ACT_REDController.do?datagrid" singleSelect="true" checkbox="true" idField="id" fit="true">
   
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="发货通知单号" field="billNoticeNo"   width="120"></t:dgCol>
   <t:dgCol title="发货通知单明细号" field="billLadingNoItem"   width="120"></t:dgCol>
   <t:dgCol title="出库单号" field="sendNo"   width="120"></t:dgCol>
   <t:dgCol title="红冲日期" field="insertDate" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="出库库名" field="outStorehouseName"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="红冲人" field="lrr"   width="120"></t:dgCol>
   <t:dgCol title="同意标志" field="readFlag"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_MYJK_FYJH_BAK_ACT_REDController.do?del&id={id}" />
   <t:dgToolBar title="汽车红冲" icon="icon-add" url="t_MYJK_FYJH_BAK_ACT_REDController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="火车红冲" icon="icon-add" url="t_MYJK_FYJH_BAK_ACT_REDController.do?addorupdate2" funname="add"></t:dgToolBar>
   <t:dgToolBar title="确认汽车红冲" icon="icon-search" url="" funname="sureConceal"></t:dgToolBar>
   <t:dgToolBar title="确认火车红冲" icon="icon-search" url="" funname="doHCConceal"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 function sureConceal(){
	 	
		var row =$("#t_MYJK_FYJH_BAK_ACT_REDList").datagrid("getSelected");
		var chukudanid=row.sendNo;
		if(row.length==0){
			tip("请选择要确认红冲的条目");
			return;
		}
		//alert(chukudanid);
		$.dialog.confirm("确定要通过红冲确认吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CKMController.do?sureConceal",
				data:{chukudanid:chukudanid},
				dataType:"json", 
				success:function(data){
					tip(data.msg);	
					$("#t_MYJK_FYJH_BAK_ACT_REDList").datagrid("reload");	
					
				}
			})
				},function(){
			
		});
		
	}
 
 //火车确认红冲
	function doHCConceal(){
	 alert(111);
		var row = $("#t_MYJK_FYJH_BAK_ACT_REDList").datagrid("getSelected");
		if(row.length==0){
			tip("请选择要确认红冲的条目");
			return;
		}
		var chukudanid=row.sendNo;
		$.dialog.confirm("确定要通过红冲确认吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CK_HCZController.do?sureConceal",
				data:{chukudanid:chukudanid},
				dataType:"json", 
				success:function(data){
				tip(data.msg);	
				$("#t_MYJK_FYJH_BAK_ACT_REDList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
 </script>