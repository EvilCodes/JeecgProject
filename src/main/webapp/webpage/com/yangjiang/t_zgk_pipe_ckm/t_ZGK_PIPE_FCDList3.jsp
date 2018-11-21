<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_ZG_PIPEList" title="返厂管材" checkbox="true"
	 actionUrl="t_ZGK_PIPE_FCDController.do?datagrid2&fankudanid=${fankudanid }"    autoLoadData="true"
								  pagination="true"  >									  							 
	   <t:dgCol title="返厂单号" field="fankudanid"   ></t:dgCol>
	   <t:dgCol title="规格" field="dn"   ></t:dgCol>	   
	   <t:dgCol title="批号全称" field="batchFull"  ></t:dgCol>
	   <t:dgCol title="管序号" field="pipeSerial"  ></t:dgCol>
	 
	   <t:dgCol title="包号" field="packageid"  ></t:dgCol>
	   <t:dgCol title="产品编码" field="itemCode"  ></t:dgCol>
	   <t:dgCol title="产品名称" field="itemCname"  ></t:dgCol>
	   <t:dgCol title="内外销标识" field="expFlag"  ></t:dgCol>
	   <t:dgCol title="合同描述" field="specialDesc"  ></t:dgCol>
	   <t:dgCol title="支数" field="pipenum"  ></t:dgCol>
	   <t:dgCol title="货位" field="huowei"  ></t:dgCol>
	   <t:dgCol title="层号" field="cengci"  ></t:dgCol>
	   <t:dgCol title="层内序号" field="cengneixuhao"  ></t:dgCol>		
	   													 																										
		</t:datagrid>
  </div>
 </div>
 <script>
 
 
 function getUrlParam(name)
	{
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg);  //匹配目标参数
			if (r!=null) return unescape(r[2]); return null; //返回参数值
	};
	
	
	//alert(rukudanid);
	
 </script>