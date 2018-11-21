<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  	<form action="" id="searchForm">
		<table style="width: 50%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 年份: </label>
				</td>
				<td class="value"><input class="Wdate" id="pYear" name="pYear"
					ignore="ignore" datatype="n">
				</td>
				<td align="right"><label class="Validform_label"> 月份: </label>
				</td>
				<td class="value"><input class="inputxt" id="pMonth"
					name="pMonth" ignore="ignore" datatype="*"> 
				</td>
				<td><input type="button" name="查询" onclick="checkorder()"
					value="查询" style="font-size: 14 ">
				</td>
				</tr>																
		</table>
	</form>
  <t:datagrid name="t_MYJK_SCJHList" title="当月计划明细" actionUrl="CheckSCJHDetailController.do?CheckSCJHDetailDataGrid" 
  idField="生产计划号" fit="true" queryMode="group" checkbox="true" fitColumns="true">        
   <t:dgCol title="生产计划号" field="生产计划号" frozenColumn="true"></t:dgCol>
   <t:dgCol title="年" field="年" frozenColumn="true"></t:dgCol>
   <t:dgCol title="月" field="月" frozenColumn="true"></t:dgCol>
   <t:dgCol title="下达日期" field="计划下达日期"   frozenColumn="true"></t:dgCol>
   <t:dgCol title="合同描述" field="特殊合同描述"   frozenColumn="true"></t:dgCol>
   <t:dgCol title="内外销" field="内外销标记"   ></t:dgCol>
   <t:dgCol title="产品代码" field="产品代码"   hidden="true"></t:dgCol>
   <t:dgCol title="产品名称" field="产品中文名称"   hidden="true"></t:dgCol>
   <t:dgCol title="产品英文名称" field="产品英文名称"  hidden="true"></t:dgCol>
   <t:dgCol title="技术标准" field="技术标准"   ></t:dgCol>      
    <t:dgCol title="品种" field="品种"   ></t:dgCol>   
   <t:dgCol title="规格" field="规格"   ></t:dgCol>
   <t:dgCol title="接口" field="接口"   ></t:dgCol>
   <t:dgCol title="等级" field="等级"   ></t:dgCol>   
   <t:dgCol title="长度" field="长度"   ></t:dgCol>
   <t:dgCol title="内衬" field="内衬"   ></t:dgCol>
   <t:dgCol title="锌层厚度" field="锌层厚度"   ></t:dgCol>
   <t:dgCol title="外涂" field="外涂"   ></t:dgCol>
   <t:dgCol title="支数" field="批复生产数量" ></t:dgCol>
   <t:dgCol title="重量" field="批复生产重量"   ></t:dgCol>
   <t:dgCol title="标重" field="标重"   ></t:dgCol> 
   <t:dgCol title="编制人" field="生产计划编制人"   ></t:dgCol>
   <t:dgCol title="编制日期" field="生产计划编制日期"   ></t:dgCol>
   <t:dgCol title="审核人" field="审核人"   ></t:dgCol>
   <t:dgCol title="审核结果" field="审核结果"   ></t:dgCol>   
   <t:dgCol title="交货日期" field="交付截止日期"  ></t:dgCol>
   <t:dgCol title="备注" field="备注"   ></t:dgCol>
   <t:dgCol title="工业区代码" field="工业区代码" ></t:dgCol>
   <t:dgCol title="工业区名称" field="工业区名称"  ></t:dgCol>                    
    <t:dgCol title="合约号" field="合约号"></t:dgCol>
   <t:dgCol title="合同号" field="合同号"></t:dgCol>
   <t:dgCol title="合约简称" field="合约简称"></t:dgCol>                        
   <t:dgCol title="套装方式" field="套装方式"  ></t:dgCol>
   <t:dgCol title="套装数量" field="套装数量"  ></t:dgCol>        
   <t:dgCol title="销售机构代码" field="销售机构代码"   ></t:dgCol>
   <t:dgCol title="销售机构名称" field="销售机构名称"   ></t:dgCol>
   <t:dgCol title="订货用户代码" field="订货用户代码"   ></t:dgCol>
   <t:dgCol title="订货用户中文名称" field="订货用户中文名称"   ></t:dgCol>
   <t:dgCol title="订货用户英文名称" field="订货用户英文名称"   ></t:dgCol>
   <t:dgCol title="内防腐执行标准序码" field="内防腐执行标准序码"   ></t:dgCol>
   <t:dgCol title="内防腐执行标准描述" field="内防腐执行标准描述"  ></t:dgCol>
   <t:dgCol title="内防腐终饰层厚度序码" field="内防腐终饰层厚度序码"  ></t:dgCol>
   <t:dgCol title="内防腐终饰层厚度描述" field="内防腐终饰层厚度描述"  ></t:dgCol>
   <t:dgCol title="喷锌标准序码" field="喷锌标准序码"   ></t:dgCol>
   <t:dgCol title="喷锌标准描述" field="喷锌标准描述"   ></t:dgCol>
   <t:dgCol title="外防腐终饰层厚度序码" field="外防腐终饰层厚度序码"   ></t:dgCol>
   <t:dgCol title="外防腐终饰层厚度描述" field="外防腐终饰层厚度描述"  ></t:dgCol>
   <t:dgCol title="外防腐执行标准序码" field="外防腐执行标准序码"   ></t:dgCol>
   <t:dgCol title="外防腐执行标准描述" field="外防腐执行标准描述"   ></t:dgCol>
   <t:dgCol title="承口内部终饰层材料序码" field="承口内部终饰层材料序码"   ></t:dgCol>
   <t:dgCol title="承口内部终饰层材料描述" field="承口内部终饰层材料描述"   ></t:dgCol>
   <t:dgCol title="承口内部终饰层厚度序码" field="承口内部终饰层厚度序码"   ></t:dgCol>
   <t:dgCol title="承口内部终饰层厚度描述" field="承口内部终饰层厚度描述"   ></t:dgCol>
   <t:dgCol title="插口端终饰层材料序码" field="插口端终饰层材料序码"   ></t:dgCol>
   <t:dgCol title="插口端终饰层材料描述" field="插口端终饰层材料序码"   ></t:dgCol>
   <t:dgCol title="插口端终饰层厚度序码" field="插口端终饰层厚度序码"  ></t:dgCol>
   <t:dgCol title="插口端终饰层厚度描述" field="插口端终饰层厚度描述"  ></t:dgCol>
   <t:dgCol title="排产单号(外销排产)" field="排产单号"  ></t:dgCol>                     
   <t:dgCol title="申报单位代码(外销排产)" field="申报单位代码"   ></t:dgCol>
   <t:dgCol title="申报单位中文名(外销排产)" field="申报单位中文名"   ></t:dgCol>
   <t:dgCol title="结算单位代码(外销排产)" field="结算单位代码"   ></t:dgCol>
   <t:dgCol title="结算单位中文名(外销排产)" field="结算单位中文名"  ></t:dgCol>
   <t:dgCol title="申报时间(外销排产)" field="申报时间"   ></t:dgCol>
   <t:dgCol title="最终销售地(外销排产)" field="最终销售地"   ></t:dgCol>
   <t:dgCol title="采购商(外销排产)" field="采购商"   ></t:dgCol>
   <t:dgCol title="交货日期(外销排产)" field="交货日期"   ></t:dgCol>
   <t:dgCol title="交货地点(外销排产)" field="交货地点"  ></t:dgCol>
   <t:dgCol title="运输方式代码(外销排产)" field="运输方式代码"   ></t:dgCol>
   <t:dgCol title="运输方式描述(外销排产)" field="运输方式描述"   ></t:dgCol>
   <t:dgCol title="需求程度(外销排产)" field="需求程度"   ></t:dgCol>
   <t:dgCol title="技术要求(外销排产)" field="技术要求"   ></t:dgCol>
   <t:dgCol title="包装要求(外销排产)" field="包装要求"   ></t:dgCol>
   <t:dgCol title="包装唛头(外销排产)" field="包装唛头"  ></t:dgCol>
   <t:dgCol title="运输唛头(外销排产)" field="运输唛头"   ></t:dgCol>
   <t:dgCol title="质保书(外销排产)" field="质保书"  ></t:dgCol>
   <t:dgCol title="商检(外销排产)" field="商检"   ></t:dgCol>
   <t:dgCol title="排产单总金额(外销排产)" field="排产单总金额"   ></t:dgCol>               
   <t:dgCol title="附件路径" field="附件地址"   ></t:dgCol>
   <t:dgCol title="计划接收时间" field="插入日期" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>   
   <t:dgCol title="生产单位" field="生产单位"   ></t:dgCol>  
   <t:dgCol title="计划类型" field="计划类型"   ></t:dgCol>                
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">    
 	$(function(){
 		$("#searchForm").find("input[name='pYear']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy'});});
 		$("#searchForm").find("input[name='pMonth']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'MM'});});
 		var today=new Date();
 		$("input[name='pYear']").val(today.getFullYear());
 		$("input[name='pMonth']").val(today.getMonth()+1);
 		
 	});
 	function checkorder() {			
			var data = $("#searchForm").parseForm();						
			$("#t_MYJK_SCJHList").datagrid("reload", data);
		};	
	(function($){
			$.fn.parseForm = function() {
				var serializeObj = {};
				var array = this.serializeArray();
				var str = this.serialize();
				$(array)
						.each(
								function() {
									if (serializeObj[this.name]) {
										if ($.isArray(serializeObj[this.name])) {
											serializeObj[this.name]
													.push(this.value);
										} else {
											serializeObj[this.name] = [
													serializeObj[this.name],
													this.value ];
										}
									} else {
										serializeObj[this.name] = this.value;
									}
								});
				return serializeObj;
			};
			//扩展jquery的格式化方法
		})(jQuery);
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
 
 