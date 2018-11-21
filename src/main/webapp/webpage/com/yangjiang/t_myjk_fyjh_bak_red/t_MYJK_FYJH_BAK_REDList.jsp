<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_MYJK_FYJH_BAK_REDList" title="被动红冲" actionUrl="t_MYJK_FYJH_BAK_REDController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="派车单号" field="billNoticeNo"   width="120"></t:dgCol>
   <t:dgCol title="派车单明细号" field="billLadingNoItem"   width="120"></t:dgCol>
   <t:dgCol title="出库单号" field="sendNo"   width="120"></t:dgCol>
   <t:dgCol title="仓库名称" field="outStorehouseName"   width="120"></t:dgCol>  
   <t:dgCol title="接收时间" field="insertDate" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>   
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="doCheck" title="确认操作"></t:dgFunOpt>
   
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 function doCheck(index){
		var row =$("#t_MYJK_FYJH_BAK_REDList").datagrid("getRows")[index];
		var id = row.id+"";
		$.dialog.confirm("确定已经操作了吗？",function(){
			$.ajax({
				url:"t_MYJK_FYJH_BAK_REDController.do?doCheck",
				data:{ids:id},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_MYJK_FYJH_BAK_REDController").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
	
 </script>