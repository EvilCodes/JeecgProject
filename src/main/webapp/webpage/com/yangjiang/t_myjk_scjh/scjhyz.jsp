<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  	<form action="" id="searchForm">
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 年份: </label>
				</td>
				<td class="value"><input class="Wdate" id="myear" name="myear"
					ignore="ignore" datatype="n">
				</td>
				<td align="right"><label class="Validform_label"> 月份: </label>
				</td>
				<td class="value"><input class="inputxt" id="mmonth"
					name="mmonth" ignore="ignore" datatype="*"> 
				</td>
				<td align="right"><label class="Validform_label"> 生产计划号: </label>
				</td>
				<td class="value"><input class="inputxt" id="product_plan_no"
					name="product_plan_no" ignore="ignore" datatype="*"> 
				</td>
				<td><input type="button" name="查询" onclick="checkorder()"
					value="查询" style="font-size: 24;color: red ">
				</td>
				</tr>																
		</table>
	</form>
  <t:datagrid name="t_MYJK_SCJHList" title="月底外销生产计划移转" actionUrl="SCJHYZController.do?datagrid" 
  idField="product_plan_no" fit="true" checkbox="true">
  <t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>        
   <t:dgCol title="生产计划号" field="product_plan_no"></t:dgCol>
   <t:dgCol title="年" field="myear" ></t:dgCol>
   <t:dgCol title="月" field="mmonth" ></t:dgCol>
   <t:dgCol title="产品名称" field="item_cname"></t:dgCol>
   <t:dgCol title="产品代码" field="item_code"   ></t:dgCol>
   
   <t:dgCol title="内外销" field="exp_flag"   ></t:dgCol>
   <t:dgCol title="合同描述" field="special_desc"   ></t:dgCol>
   <t:dgCol title="计划支数" field="launch_count" ></t:dgCol>
   <t:dgCol title="计划重量" field="launch_weight"   ></t:dgCol>
   <t:dgCol title="结转支数" field="synum" extendParams="editor:'numberbox'"></t:dgCol>
   <t:dgCol title="结转重量" field="syweight"   extendParams="editor:'numberbox'"></t:dgCol>
   <t:dgCol title="原计划下达日期" field="plan_delivery_date"   ></t:dgCol>
   <t:dgCol title="原计划编制日期" field="plan_cerate_date"   ></t:dgCol>
   <t:dgCol title="交货日期" field="sendDate"   extendParams="editor:'datebox'"></t:dgCol>
   <t:dgCol title="备注" field="remark"  ></t:dgCol>
   <t:dgToolBar title="移转" icon="icon-search" url="" funname="doMove"></t:dgToolBar>              
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">    
 	$(function(){
 		$("#searchForm").find("input[name='myear']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy'});});
 		$("#searchForm").find("input[name='mmonth']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'MM'});});
 		$("#t_MYJK_SCJHList").find("input[name='sendDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		var today=new Date();
 		$("input[name='myear']").val(today.getFullYear());
 		$("input[name='mmonth']").val(today.getMonth()+1);
 		$("#t_MYJK_SCJHList").datagrid({
 			onClickCell:function(rowIndex, field, value){
 				console.log("当前行==》》》"+rowIndex);
 				if(field=="opt_editor"){
 				//	alert('编辑单元格');
 					editRow(rowIndex)
 				}
 			}
 		});
 		
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
 	
 	/**
 	*批量移转操作
 	**/
 	function doMove(){
 		var getSelections = $("#t_MYJK_SCJHList").datagrid("getSelections");
 		if(getSelections.length==0){
 			tip("请选择要移转的条目");
 			return;
 		}
 		var getSelectionsDatas=$("#t_MYJK_SCJHList").datagrid("getSelections");
      	var mydata=JSON.stringify(getSelectionsDatas);
      	console.info("mydata length:"+getSelectionsDatas.length);
      	console.info("mydata:"+mydata);   
 		$.dialog.confirm("确定要移转吗？",function(){
 			$.ajax({
 				url:"t_MYJK_SCJHController.do?doMove",
 				data:{data:JSON.stringify(getSelectionsDatas)},
 				dataType:"json", 
 				success:function(data){
 					tip(data.msg);
 					$("#t_MYJK_SCJHList").datagrid("reload");
 				}
 			});
 		},function(){
 			
 		})
 	}
 	
	 //addRow(0);
	 function editRow(index){
		var rows=$('#t_MYJK_SCJHList').datagrid("getChecked");
		if(rows.length==0){
			tip("请选择条目");
			return false;
		}
		$('#t_MYJK_SCJHList').datagrid('beginEdit', index);
	}
	//结束编辑
	function endEdit(){
		//这里不应该只是编辑当前行？？？？？
		var  editIndex = $('#t_MYJK_SCJHList').datagrid('getRows').length-1;
		for(var i=0;i<=editIndex;i++){
			if($('#t_MYJK_SCJHList').datagrid('validateRow', i))
				$('#t_MYJK_SCJHList').datagrid('endEdit', i);
			else
				return false;
		}
		return true;
	}
 	function edit(val,row,index){  
 	    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
 		}  
 </script>
 
 