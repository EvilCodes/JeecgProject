<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_zg_analy_GPList" title="光谱数据表" actionUrl="t_zg_analy_GPController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="分析时间" field="analydate" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="样子编号" field="sampleno"   width="120"></t:dgCol>
   <t:dgCol title="样子名称" field="samplename"   width="120"></t:dgCol>
   <t:dgCol title="判定结果" field="result"   width="120"></t:dgCol>
   <t:dgCol title="C" field="c"   width="120"></t:dgCol>
   <t:dgCol title="Si" field="si"   width="120"></t:dgCol>
   <t:dgCol title="Mn" field="mn"   width="120"></t:dgCol>
   <t:dgCol title="S" field="s"   width="120"></t:dgCol>
   <t:dgCol title="P" field="p"   width="120"></t:dgCol>
   <t:dgCol title="Mg" field="mg"   width="120"></t:dgCol>
   <t:dgCol title="Ni" field="ni"   width="120"></t:dgCol>
   <t:dgCol title="Cr" field="cr"   width="120"></t:dgCol>
   <t:dgCol title="Mo" field="mo"   width="120"></t:dgCol>
   <t:dgCol title="V" field="v"   width="120"></t:dgCol>
   <t:dgCol title="Ti" field="ti"   width="120"></t:dgCol>
   <t:dgCol title="Al" field="al"   width="120"></t:dgCol>
   <t:dgCol title="Pb" field="pb"   width="120"></t:dgCol>
   <t:dgCol title="Ce" field="ce"   width="120"></t:dgCol>
   <t:dgCol title="Cu" field="cu"   width="120"></t:dgCol>
   <t:dgCol title="Ceq" field="ceq"   width="120"></t:dgCol>
   <t:dgCol title="录入时间" field="inputdate" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="B" field="b"   width="120"></t:dgCol>
   <t:dgCol title="Sb" field="sb"   width="120"></t:dgCol>
   <t:dgCol title="As1" field="as1"   width="120"></t:dgCol>
   <t:dgCol title="Sn" field="sn"   width="120"></t:dgCol>
   <t:dgCol title="录入人" field="inputer"   width="120"></t:dgCol>
   <t:dgCol title="录入部门" field="department"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="t_zg_analy_GPController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="t_zg_analy_GPController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_zg_analy_GPController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_zg_analy_GPController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>