<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:0px;border:0px">
		<t:datagrid name="t_ZGK_PIPE_CKMList" title="胶圈发运数据查询审核" checkbox="true" queryMode="group"
			actionUrl="JQTransportDataController.do?PipeUpDataGrid" idField="id" fitColumns="true" pagination="true"
			 showPageList="true" pageSize="40">			   
			<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
			<t:dgCol title="出库单号" field="chukudanid" query="true"></t:dgCol>
			<t:dgCol title="审核结果" field="SHBZ" ></t:dgCol>		
			<t:dgCol title="库名" field="store_name" ></t:dgCol>
			<t:dgCol title="产品代码" field="itemCode"></t:dgCol>
			<t:dgCol title="产品名称" field="itemName"   ></t:dgCol>
		   <t:dgCol title="支数" field="sendNum"   ></t:dgCol>
		   <t:dgCol title="重量" field="sendWeight"   ></t:dgCol>
		   <t:dgCol title="承运商代码" field="carry_company_code"  ></t:dgCol>
		   <t:dgCol title="承运商名称" field="carry_company_name"   ></t:dgCol>
		   <t:dgCol title="车牌号" field="car_no"  ></t:dgCol>
		   <t:dgCol title="司机姓名" field="driver_name"   ></t:dgCol>
		   <t:dgCol title="司机电话" field="driver_tel"  ></t:dgCol>
		   <t:dgCol title="司机身份证号" field="id_number"   ></t:dgCol>
		   <t:dgCol title="保管员" field="baoguanyuan"   ></t:dgCol>
		   <t:dgCol title="车型" field="BLOCK_SIZE"   ></t:dgCol>
		   <t:dgCol title="车型名称" field="BLOCK_SIZE_NAME"></t:dgCol>
		   <t:dgCol title="车号" field="BLOCK_NO"></t:dgCol>
		   <t:dgCol title="短尺标志" field="NO_SAME_MARK"></t:dgCol>
		   <t:dgCol title="样品管标志" field="SAMPLE"></t:dgCol>
		   <t:dgCol title="箱型" field="BOX_NO"></t:dgCol>
		   <t:dgCol title="审核人" field="SHR"></t:dgCol>
		   <t:dgCol title="审核时间" field="SHSJ"></t:dgCol>
		   <t:dgCol title="审核标志" field="SHBZ"></t:dgCol>
		   <t:dgCol title="备注" field="REMARK"></t:dgCol>
		   <t:dgCol title="日期" field="riqi"  query="true"></t:dgCol>
		   <t:dgCol title="销售公司" field="org_name"></t:dgCol>
		   <t:dgCol title="客户公司" field="consign_cname"></t:dgCol>
		   <t:dgCol title="到站" field="delivy_place_name"></t:dgCol>
		   <t:dgCol title="专线名称" field="private_route_name"></t:dgCol>
		   <t:dgCol title="发货通知单号" field="bill_notice_no"></t:dgCol>
		   <t:dgCol title="发货通知单明细号" field="bill_lading_no_item"></t:dgCol>
		   <t:dgCol title="派车单号" field="send_car_no"></t:dgCol>
		   <t:dgCol title="运输方式" field="trnp_mode"></t:dgCol>
		   <t:dgCol title="读取标志" field="READ_FLAG"></t:dgCol>	
   		   <t:dgToolBar title="审核" icon="icon-search" url="" funname="doCheck"></t:dgToolBar>
   		   
		   
		</t:datagrid>
	</div>
</div>
<script type="text/javascript">
function ExporterExcel() {  
    //获取Datagride的列  
    var rows = $('#t_ZGK_PIPE_CKMList').datagrid('getRows');  
    var columns = $("#t_ZGK_PIPE_CKMList").datagrid("options").columns[0];  
    var oXL = new ActiveXObject("Excel.Application"); //创建AX对象excel   
    var oWB = oXL.Workbooks.Add(); //获取workbook对象   
    var oSheet = oWB.ActiveSheet; //激活当前sheet  
    //设置工作薄名称  
    oSheet.name = "导出Excel报表";  
    //设置表头  
    for (var i = 0; i < columns.length; i++) {  
        oSheet.Cells(1, i+1).value = columns[i].title;  
    }  
    //设置内容部分  
    for (var i = 0; i < rows.length; i++) {  
        //动态获取每一行每一列的数据值  
        for (var j = 0; j < columns.length; j++) {                 
            oSheet.Cells(i + 2, j+1).value = rows[i][columns[j].field];  
        }     
    }                
    oXL.Visible = true; //设置excel可见属性  
}  
	$(document).ready(function(){		  
		$("#t_ZGK_PIPE_CKMListtb").find("input[name='riqi']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
		  $("input[name='riqi']").val(today);	
		//  $("#riqi").val(new Date().Format("yyyy-MM-dd hh:mm:ss"));
	});
	//Date.prototype.Format = function(fmt)   
	//	{ //author: meizz   
		//  var o = {   
		//    "M+" : this.getMonth()+1,                 //月份   
		//    "d+" : this.getDate(),                    //日   
		////    "h+" : this.getHours(),                   //小时   
		//    "m+" : this.getMinutes(),                 //分   
		//    "s+" : this.getSeconds(),                 //秒   
		////    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
		//    "S"  : this.getMilliseconds()             //毫秒   
		//  };   
		 // if(/(y+)/.test(fmt))   
		 //   fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		 // for(var k in o)   
		 //   if(new RegExp("("+ k +")").test(fmt))   
		//  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		//  return fmt;   
		//}  
	
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
	function doCheck(){
		
		//var row1 =$("#t_ZGK_PIPE_CKMList").datagrid("getSelected");
		var getSelections = $("#t_ZGK_PIPE_CKMList").datagrid("getSelections");
		if(getSelections.length==0){
			tip("请选择要审核的条目");
			return;
		}
		var ids = [];
		for(var index in getSelections){
			var row =getSelections[index];		
			ids.push(row.id);
			
		}
		console.log(ids.join(","));
		//var id = row.chukudanid+"";
		$.dialog.confirm("确定要通过审核吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CKD_JQController.do?doCheck",
				data:{ids:ids.join(",")},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZGK_PIPE_CKMList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}
	
	
	//----------------------------------------------------------------------------
	//作废
	function doTrash(index){
		var row =$("#t_ZGK_PIPE_CKMList").datagrid("getSelected");
		var id = row.chukudanid+"";
		$.dialog.confirm("确定要作废吗？",function(){
			$.ajax({
				url:"t_ZGK_PIPE_CKD_JQController.do?doTrash",
				data:{ids:id},
				dataType:"json", 
				success:function(data){
					tip(data.msg);
					$("#t_ZGK_PIPE_CKMList").datagrid("reload");
				}
			});
		},function(){
			
		});
	}	
</script>