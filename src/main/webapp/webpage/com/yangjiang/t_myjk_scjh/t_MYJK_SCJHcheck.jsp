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
  <t:datagrid name="t_MYJK_SCJHList" title="当月计划汇总" actionUrl="CheckSCJHMonthSumController.do?CheckSCJHMonthSumDataGrid" 
  idField="生产计划号"  queryMode="group" checkbox="true" fitColumns="true"   pageSize="20" pagination="true">        
   
   <t:dgCol title="年" field="年" frozenColumn="true"></t:dgCol>
   <t:dgCol title="月" field="月" frozenColumn="true"></t:dgCol>
   <t:dgCol title="产品代码" field="产品代码"   hidden="true"></t:dgCol>  
   <t:dgCol title="合同描述" field="特殊合同描述"   frozenColumn="true"></t:dgCol>
   <t:dgCol title="内外销" field="内外销标记"   ></t:dgCol>
   <t:dgCol title="品种" field="品种"   ></t:dgCol> 
   <t:dgCol title="技术标准" field="技术标准"   ></t:dgCol>                  
   <t:dgCol title="规格" field="规格"   ></t:dgCol>
   <t:dgCol title="接口" field="接口"   ></t:dgCol>
   <t:dgCol title="等级" field="等级"   ></t:dgCol>   
   <t:dgCol title="长度" field="长度"   ></t:dgCol>
   <t:dgCol title="内衬" field="内衬"   ></t:dgCol>
   <t:dgCol title="锌层厚度" field="锌层厚度"   ></t:dgCol>
   <t:dgCol title="外涂" field="外涂"   ></t:dgCol>
   <t:dgCol title="支数" field="数量" ></t:dgCol>
   <t:dgCol title="重量" field="重量"   ></t:dgCol>                          
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
 
 