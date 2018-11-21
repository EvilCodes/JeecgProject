<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZGK_PIPE_TKMList" title="退库主表111" actionUrl="t_ZGK_PIPE_TKMController.do?datagrid" idField="id" fit="true" 
  sortName="riqi" sortOrder="desc">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="入库单号" field="tuikudanid"   width="120" query="true"></t:dgCol>
   <t:dgCol title="退库时间" field="riqi" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="库房名称" field="storeName"   width="120"></t:dgCol>
   <t:dgCol title="保管员" field="baoguanyuan"   width="120"></t:dgCol>
   <t:dgCol title="收货单位" field="consignee"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="addpipecode(tuikudanid)" title="添加管号"></t:dgFunOpt>
   <t:dgFunOpt funname="tkViewPrint(tuikudanid)" title="打印退库单"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="t_ZGK_PIPE_TKMController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_ZGK_PIPE_TKMController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_ZGK_PIPE_TKMController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 function tkViewPrint(tuikudanid){
		addOneTab("入库单打印预览", "t_ZGK_PIPE_TKMController.do?tkViewPrint&tuikudanid="+tuikudanid);
		console.info(tuikudanid);
	}
function addpipecode(tuikudanid) {
	//1.$.ajax带json数据的异步请求
	createwindow("添加入库管号", "t_ZGK_PIPE_TKDController.do?addorupdate&tuikudanid="+tuikudanid,1400,800);	
}
 </script>