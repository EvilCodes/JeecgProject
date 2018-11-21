<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_CK_HCZList" title="火车装车" queryMode="group" actionUrl="t_ZGK_PIPE_CK_HCZController.do?datagrid" 
  idField="id" fitColumns="true" fit="true" checkbox="true">
   <t:dgCol title="操作" field="opt"></t:dgCol>
   
   <t:dgFunOpt funname="ckViewPrint(sendNo)" title="打印出库单" urlStyle="color:red"></t:dgFunOpt>
   <t:dgFunOpt funname="enTruck(sendNo)" title="装车" urlStyle="color:blue" ></t:dgFunOpt>
   <t:dgFunOpt funname="doCheck" title="审核"></t:dgFunOpt>
   <t:dgFunOpt funname="doTrash" title="废除"></t:dgFunOpt>
   
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="到站" field="delivyPlaceName"   query="true"></t:dgCol>
   <t:dgCol title="销售公司" field="orgName"   query="true"></t:dgCol>
   <t:dgCol title="审核标志" field="shbz"   ></t:dgCol>
   <t:dgCol title="单号" field="sendNo"  ></t:dgCol>
   <t:dgCol title="产品编码" field="itemCode"   hidden="true"></t:dgCol>
   <t:dgCol title="产品名称" field="itemCname"   ></t:dgCol>
   <t:dgCol title="发货支数" field="planNum"   ></t:dgCol>
   <t:dgCol title="发货重量" field="planWt"   ></t:dgCol>
   <t:dgCol title="车皮型号代码" field="blockSize"   hidden="true"></t:dgCol>
   <t:dgCol title="车皮型号" field="blockSizeName"   ></t:dgCol>
   <t:dgCol title="车号" field="blockNo"   query="true"></t:dgCol>
   <t:dgCol title="短尺标志" field="noSameMark"   ></t:dgCol>
   <t:dgCol title="样品管标志" field="sample"   ></t:dgCol>
   <t:dgCol title="备注" field="remark"   ></t:dgCol>
   
   <t:dgCol title="收货单位" field="consignCname"   ></t:dgCol>
   <t:dgCol title="专线名称" field="privateRouteName"   ></t:dgCol>
   <t:dgCol title="保管员" field="stockPerson"   ></t:dgCol>
   
   <t:dgCol title="装车时间" field="sendTime" formatter="yyyy-MM-dd hh:mm:ss"  query="true"></t:dgCol> 
   <t:dgCol title="箱号" field="boxNo"   ></t:dgCol>
   
   <t:dgCol title="审核人" field="shr"   ></t:dgCol>
   <t:dgCol title="审核时间" field="shsj" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
   <t:dgCol title="读取标志" field="readFlag"   ></t:dgCol>
   
   <t:dgCol title="仓库名称" field="outWhouseName"   ></t:dgCol>
   <t:dgCol title="发货通知单号" field="billNoticeNo"  ></t:dgCol>
   <t:dgCol title="发货通知单明细" field="billLadingNoItem"   ></t:dgCol>
   
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_CK_HCZController.do?addorupdate" funname="add"  width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="红冲修改" icon="icon-edit" url="t_ZGK_PIPE_CK_HCZController.do?update" funname="update"  width="100%" height="100%"></t:dgToolBar>   
   <t:dgToolBar title="批量审核" icon="icon-search" url="" funname="doBatchCheck"></t:dgToolBar>
   <t:dgToolBar title="批量作废" icon="icon-search" url="" funname="doBatchTrash"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script>
 function ckViewPrint(sendNo){
		addOneTab("入库单打印预览", "t_ZGK_PIPE_CK_HCZController.do?ckViewPrint&sendNo="+sendNo);
		console.info(sendNo);
	}
 function enTruck(sendNo){
		addOneTab("火车装车", "t_ZGK_PIPE_CK_HCZController.do?enTruck&sendNo="+sendNo);
		console.info(sendNo);
	}
 $(function(){
		$("#t_ZGK_PIPE_CK_HCZListtb").find("input[name='sendTime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
		$("input[name='sendTime']").val(today);
	})
function today(){
 var today=new Date();
 var h=today.getFullYear();
 var m=today.getMonth()+1;
 var d=today.getDate();
 m= m<10?"0"+m:m;   //  这里判断月份是否<10,如果是在月份前面加'0'
 d= d<10?"0"+d:d;        //  这里判断日期是否<10,如果是在日期前面加'0'
 return h+"-"+m+"-"+d;
}
//单个审核
	function doCheck(index){
		var row =$("#t_ZGK_PIPE_CK_HCZList").datagrid("getRows")[index];
		var id = row.id+"";
		$.dialog.confirm("确定要通过审核吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CK_HCZController.do?doCheck",
				data:{ids:id},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZGK_PIPE_CK_HCZList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
	
	/**
	*批量审核操作
	**/
	function doBatchCheck(){
		var getSelections = $("#t_ZGK_PIPE_CK_HCZList").datagrid("getSelections");
		if(getSelections.length==0){
			tip("请选择要审核的条目");
			return;
		}
		var ids = [];
		for(var index in getSelections){
			var row =getSelections[index];
			ids.push(row.id);
		}
		$.dialog.confirm("确定要通过审核吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CK_HCZController.do?doCheck",
				data:{ids:ids.join(",")},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZGK_PIPE_CK_HCZList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
	
	//----------------------------------------------------------------------------
	//审核
	function doTrash(index){
		var row =$("#t_ZGK_PIPE_CK_HCZList").datagrid("getRows")[index];
		var id = row.id+"";
		$.dialog.confirm("确定要作废吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CK_HCZController.do?doTrash",
				data:{ids:id},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZGK_PIPE_CK_HCZList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
	
	/**
	*批量作废操作
	**/
	function doBatchTrash(){
		var getSelections = $("#t_ZGK_PIPE_CK_HCZList").datagrid("getSelections");
		if(getSelections.length==0){
			tip("请选择要审核的条目");
			return;
		}
		var ids = [];
		for(var index in getSelections){
			var row =getSelections[index];
			ids.push(row.id);
		}
		$.dialog.confirm("确定要作废吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CK_HCZController.do?doTrash",
				data:{ids:ids.join(",")},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZGK_PIPE_CK_HCZList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
 </script>