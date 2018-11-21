<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_zg_pipe_rkList" title="铸管部交库" actionUrl="t_zg_pipe_rkController.do?datagrid" queryMode="group" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="入库单编号" field="rukudanid"   query="true"></t:dgCol>
   <t:dgCol title="仓库名称" field="storeName"   ></t:dgCol>
   <t:dgCol title="车号" field="che" ></t:dgCol>
   <t:dgCol title="数量" field="count"   ></t:dgCol>
   <t:dgCol title="运输人" field="yunshuren"   ></t:dgCol>
   <t:dgCol title="检验员" field="jianyanyuan"   ></t:dgCol>
   <t:dgCol title="保管员" field="baoguanyuan"   ></t:dgCol>
   <t:dgCol title="日期" field="riqi" formatter="yyyy-MM-dd hh:mm:ss"  query="true"></t:dgCol>
   <t:dgCol title="状态" field="state"   ></t:dgCol>
   <t:dgCol title="打印时间" field="printtime" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
   <t:dgCol title="编辑人" field="edituser"    hidden="true"></t:dgCol>
   <t:dgCol title="编辑IP地址" field="editip"    hidden="true"></t:dgCol>
   <t:dgCol title="编辑时间" field="edittime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>   
   <t:dgCol title="备注" field="remark"   ></t:dgCol>        
   <t:dgCol title="操作" field="opt" width="160"></t:dgCol>
   <t:dgFunOpt funname="addpipecode(rukudanid,id)" title="添加管号"></t:dgFunOpt>
   <t:dgFunOpt funname="checkpipecode(rukudanid)" title="查看已添加管号"></t:dgFunOpt>  
   <t:dgFunOpt funname="toPreViewPrint(rukudanid,id)" title="打印"></t:dgFunOpt>    
   <t:dgToolBar title="录入" icon="icon-add" url="t_zg_pipe_rkController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_zg_pipe_rkController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_zg_pipe_rkController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(function(){
		$("#t_zg_pipe_rkListtb").find("input[name='riqi']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
		$("input[name='riqi']").val(today);
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
function addpipecode(rukudanid,id){
	var row = $('#t_zg_pipe_rkList').datagrid('getSelected');
	//alert("storeName:"+row.storeName);		
		createwindow("添加入库管号", "t_ZG_PIPEController.do?addorupdate&rukudanid="+rukudanid,1400,800);	
		
}
function checkpipecode(rukudanid){
	var row = $('#t_zg_pipe_rkList').datagrid('getSelected');
	//alert("storeName:"+row.storeName);		
		createwindow("查看入库管号", "t_zg_pipe_rkController.do?list2&rukudanid="+rukudanid,1100,700);	
		
}
function toPreViewPrint(rukudanid){
	addOneTab("入库单打印预览", "t_zg_pipe_rkController.do?toPreViewPrint&rukudanid="+rukudanid);
}
 </script>