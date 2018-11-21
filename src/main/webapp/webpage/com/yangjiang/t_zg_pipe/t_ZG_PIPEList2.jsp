<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZG_PIPEList" title="铸管部已交库数据" actionUrl="t_zg_pipe_rkController.do?datagrid2&mainId=${rukudanid }" 
  idField="pipeCode" fit="true" checkbox="true">   
   <t:dgCol title="管号" field="pipeCode"   ></t:dgCol>
   
   <t:dgCol title="规格" field="dn"   ></t:dgCol>
   <t:dgCol title="年份" field="pYear"   ></t:dgCol>
   <t:dgCol title="批号" field="batch"   ></t:dgCol>
   <t:dgCol title="批号全文" field="batchFull"  ></t:dgCol>
   <t:dgCol title="管序号" field="pipeSerial"   ></t:dgCol>
   <t:dgCol title="产品中文名称" field="itemCname"   ></t:dgCol>
   
   <t:dgCol title="标志" field="expFlag"   ></t:dgCol>
   <t:dgCol title="特殊合同描述" field="specialDesc"  ></t:dgCol>
   <t:dgCol title="包号" field="packageid"   ></t:dgCol>
   <t:dgCol title="数量" field="pipenum"   ></t:dgCol>
   <t:dgCol title="生成计划号" field="productPlanNo"   ></t:dgCol>
   <t:dgCol title="产品编码" field="itemCode"  ></t:dgCol>
   <t:dgCol title="入库单编号" field="mainId"   ></t:dgCol>
   <t:dgCol title="编号" field="id"   ></t:dgCol>
   <t:dgToolBar title="删除"  icon="icon-remove" url="t_zg_pipe_rkController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
