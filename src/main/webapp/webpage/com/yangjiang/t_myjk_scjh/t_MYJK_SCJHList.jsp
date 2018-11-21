<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="t_MYJK_SCJHList" title="生产计划" actionUrl="t_MYJK_SCJHController.do?datagrid" 
  idField="id" fit="true" queryMode="group" checkbox="true">
  <t:dgCol title="操作" field="opt" ></t:dgCol>
   <t:dgFunOpt funname="doCheck" title="审核"></t:dgFunOpt>
   <t:dgFunOpt funname="doTrash" title="废除"></t:dgFunOpt>
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>   
   <t:dgCol title="生产计划号" field="productPlanNo"    ></t:dgCol>
   <t:dgCol title="合约号" field="contractNo"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="合同号" field="orderNo"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="合约简称" field="contractDesc"   width="120" hidden="true"></t:dgCol>   
   <t:dgCol title="年" field="year"    ></t:dgCol>
   <t:dgCol title="月" field="month"   ></t:dgCol>
   <t:dgCol title="合同描述" field="specialDesc"   ></t:dgCol>
   <t:dgCol title="内外销" field="expFlag"    ></t:dgCol>
   <t:dgCol title="产品代码" field="itemCode"    ></t:dgCol>
   <t:dgCol title="产品名称" field="itemCname"  ></t:dgCol>
   <t:dgCol title="产品英文名称" field="itemEname"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="工业区代码" field="factoryCode"   width="120" hidden="true"></t:dgCol>   
   <t:dgCol title="支数" field="launchCount"   ></t:dgCol>
   <t:dgCol title="重量" field="launchWeight"   ></t:dgCol>
   <t:dgCol title="接收时间" field="insertDate" formatter="yyyy-MM-dd"  query="true"></t:dgCol>
   <t:dgCol title="套装方式" field="suitMode"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="套装数量" field="suitCount"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="编制人" field="planPerson"   ></t:dgCol>
   <t:dgCol title="编制日期" field="planCerateDate"   ></t:dgCol>
   <t:dgCol title="下达日期" field="planLaunchDate"   ></t:dgCol>
   <t:dgCol title="交货日期" field="planDeliveryDate"   ></t:dgCol>
   <t:dgCol title="销售机构代码" field="saleDept"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="销售机构名称" field="saleDeptName"   ></t:dgCol>
   <t:dgCol title="订货用户代码" field="orderUserNum"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="订货用户中文名称" field="orderUserCname"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="订货用户英文名称" field="orderUserEname"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="内防腐执行标准序码" field="liningStdSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="内防腐执行标准描述" field="liningStdDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="内防腐终饰层厚度序码" field="liningTkSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="内防腐终饰层厚度描述" field="liningTkDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="喷锌标准序码" field="zincStdSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="喷锌标准描述" field="zincStdDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="外防腐终饰层厚度序码" field="coatTkSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="外防腐终饰层厚度描述" field="coatTkDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="外防腐执行标准序码" field="coatStdSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="外防腐执行标准描述" field="coatStdDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="承口内部终饰层材料序码" field="bellMaterialSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="承口内部终饰层材料描述" field="bellMaterialDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="承口内部终饰层厚度序码" field="bellTkSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="承口内部终饰层厚度描述" field="bellTkDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="插口端终饰层材料序码" field="jackMaterialSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="插口端终饰层材料描述" field="jackMaterialDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="插口端终饰层厚度序码" field="jackTkSeq"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="插口端终饰层厚度描述" field="jackTkDesc"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="排产单号(外销排产)" field="schedulingNo"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="申报单位代码(外销排产)" field="reportUserNum"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="申报单位中文名(外销排产)" field="reportUserCname"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="结算单位代码(外销排产)" field="settleUserNum"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="结算单位中文名(外销排产)" field="settleUserCname"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="申报时间(外销排产)" field="reportTime"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="最终销售地(外销排产)" field="saleGround"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="采购商(外销排产)" field="buyers"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="交货日期(外销排产)" field="deliveryDate"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="交货地点(外销排产)" field="deliveryPlace"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="运输方式代码(外销排产)" field="trnpModeCode"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="运输方式描述(外销排产)" field="trnpModeName"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="需求程度(外销排产)" field="requireLevel"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="技术要求(外销排产)" field="technicalDemand"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="包装要求(外销排产)" field="packingDemand"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="包装唛头(外销排产)" field="shippingMark"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="运输唛头(外销排产)" field="trnpModeMark"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="质保书(外销排产)" field="millCertificate"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="商检(外销排产)" field="inspection"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="排产单总金额(外销排产)" field="schedulingAmt"   width="120" hidden="true"></t:dgCol>   
   <t:dgCol title="备注" field="remark"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="附件路径" field="annexPath"   width="120" hidden="true"></t:dgCol>   
   <t:dgCol title="生产单位" field="scdw"   ></t:dgCol>
   <t:dgCol title="审核人" field="shr"   ></t:dgCol>
   <t:dgCol title="审核部门" field="shbm"   ></t:dgCol>
   <t:dgCol title="审核时间" field="shsj" formatter="yyyy-MM-dd hh:mm:ss"  ></t:dgCol>
   <t:dgCol title="计划类型" field="planType"   width="120" hidden="true"></t:dgCol>
   <t:dgCol title="审核结果" field="auditresult"   ></t:dgCol>
   <t:dgCol title="工业区名称" field="factoryName"  ></t:dgCol>      
   <t:dgToolBar title="编辑" icon="icon-edit" url="t_MYJK_SCJHController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="t_MYJK_SCJHController.do?addorupdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="批量审核" icon="icon-search" url="" funname="doBatchCheck"></t:dgToolBar>
   <t:dgToolBar title="批量作废" icon="icon-search" url="" funname="doBatchTrash"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(function(){
 		$("#t_MYJK_SCJHListtb").find("input[name='insertDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		$("input[name='insertDate']").val(today);
 	});
 	
 	function today(){
	    var today=new Date();
	    var h=today.getFullYear();
	    var m=today.getMonth()+1;
	    var d=today.getDate();
	    m= m<10?"0"+m:m;   //  这里判断月份是否<10,如果是在月份前面加'0'
	    d= d<10?"0"+d:d;        //  这里判断日期是否<10,如果是在日期前面加'0'
	    return h+"-"+m+"-"+d;
	}
 	
 	//审核
 	function doCheck(index){
 		var row =$("#t_MYJK_SCJHList").datagrid("getRows")[index];
 		var id = row.id+"";
 		$.dialog.confirm("确定要通过审核吗？",function(){
 			$.ajax({
 				url:"t_MYJK_SCJHController.do?doCheck",
 				data:{ids:id},
 				dataType:"json", 
 				success:function(data){
 					tip(data.msg);
 					$("#t_MYJK_SCJHList").datagrid("reload");
 				}
 			});
 		},function(){
 			
 		});
 	}
 	
 	/**
 	*批量审核操作
 	**/
 	function doBatchCheck(){
 		var getSelections = $("#t_MYJK_SCJHList").datagrid("getSelections");
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
 				url:"t_MYJK_SCJHController.do?doCheck",
 				data:{ids:ids.join(",")},
 				dataType:"json", 
 				success:function(data){
 					tip(data.msg);
 					$("#t_MYJK_SCJHList").datagrid("reload");
 				}
 			});
 		},function(){
 			
 		});
 	}
 	
 	//----------------------------------------------------------------------------
 	//审核
 	function doTrash(index){
 		var row =$("#t_MYJK_SCJHList").datagrid("getRows")[index];
 		var id = row.id+"";
 		$.dialog.confirm("确定要作废吗？",function(){
 			$.ajax({
 				url:"t_MYJK_SCJHController.do?doTrash",
 				data:{ids:id},
 				dataType:"json", 
 				success:function(data){
 					tip(data.msg);
 					$("#t_MYJK_SCJHList").datagrid("reload");
 				}
 			});
 		},function(){
 			
 		});
 	}
 	
 	/**
 	*批量审核操作
 	**/
 	function doBatchTrash(){
 		var getSelections = $("#t_MYJK_SCJHList").datagrid("getSelections");
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
 				url:"t_MYJK_SCJHController.do?doTrash",
 				data:{ids:ids.join(",")},
 				dataType:"json", 
 				success:function(data){
 					tip(data.msg);
 					$("#t_MYJK_SCJHList").datagrid("reload");
 				}
 			});
 		},function(){
 			
 		});
 	}
 	
 </script>
 
 