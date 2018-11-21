<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <style>
#main {
	border: 2px solid ;
	padding: 10px;
}

#top {
	min-height: 200px;
	border: 1px dashed ;
}

#south {
	border: 1px dashed ;
	padding: 10px;
	width: 60%,
}

#left {
	border: 1px dotted burlywood;
	width: 30%,
}
</style>
  <title>铸管部交库详细信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">  
  function padLeft(str,lenght){ 
	if(str.length >= lenght) 
	return str; 
	else 
	return padLeft("0" +str,lenght); 
	} 
  function getUuid(){
	  var len=36;//32长度
	  var radix=16;//16进制
	  var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	  var uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
	  return uuid.join('');
	}  
 
  function add(val,row,index){  	
    return '<a href="#"   onclick="javascript:void(0);">添加</a>';  
	}  
  function edit(val,row,index){  
    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
	}  
	function del(val,row,index){  
	    return '<a href="#"  onclick="javascript:void(0);">删除</a>';  
	} 
  
	
	
  $(document).ready(function() {
	  //var sendNo=getUrlParam("sendNo");
	 	//alert(sendNo);
	  $("#pYear").attr("class", "Wdate").click(function() {
				WdatePicker({
					dateFmt : 'yyyy'
				});
			});
		var sdate=new Date();
		var pmonth=sdate.getMonth()+1;
		var mymonth=padLeft(pmonth,2);
		$("#pYear").val(sdate.getFullYear());
		$("#pMonth").val(mymonth);
	  $("#instoreDetailList").datagrid({
		onClickCell:function(rowIndex, field, value){
			console.log("当前行==》》》"+rowIndex);
			if(field=="opt_add"){
			//	alert('添加单元格');
				addRow(rowIndex);
			}else if(field=="opt_editor"){
			//	alert('编辑单元格');
				editRow(rowIndex)
			}else if(field=="opt_del"){
			//	alert('删除单元格');
				delRow(rowIndex);
			}
		}
	});
	 //addRow(0);
	});
 //编辑行
	function editRow(index){
		var rows=$('#instoreDetailList').datagrid("getChecked");
		if(rows.length==0){
			tip("请选择条目");
			return false;
		}
		$('#instoreDetailList').datagrid('beginEdit', index);
	}
	//结束编辑
	function endEdit(){
		//这里不应该只是编辑当前行？？？？？
		var  editIndex = $('#instoreDetailList').datagrid('getRows').length-1;
		for(var i=0;i<=editIndex;i++){
			if($('#instoreDetailList').datagrid('validateRow', i))
				$('#instoreDetailList').datagrid('endEdit', i);
			else
				return false;
		}
		return true;
	}
 //添加行
 function addRow(index){  	
	 	var rows = $('#instoreDetailList').datagrid('getRows')[index];
	 	console.log(rows);
	 	$('#instoreDetailList').datagrid('appendRow',{
	 		 	id : getUuid(),
	 		 	pyear : rows.pyear,
	 		 	productLine : $("#product_line").val(),
	 		 	dn : rows.dn,
	 		 	batch : rows.batch,
	 		 	pipenum:rows.pipenum,
	 		 	productPlanNo : rows.productPlanNo,
	 		 	itemCode : rows.itemCode,
	 		 	itemCname : rows.itemCname,
	 		 	expFlag : rows.expFlag,
	 		 	specialDesc : rows.specialDesc,
	 		 	rukudanid:rukudanid
	 	});
		var editIndex =  $('#instoreDetailList').datagrid('getRows').length-1;
		$('#instoreDetailList').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);

			//console.log(insertDataGridModel._data);
			
		} 

	//删除行
		function delRow(index){	
						//editIndex = $('#instoreDetailList').datagrid('getRows').length;
			           $('#instoreDetailList').datagrid('deleteRow', index);
			           //$('#instoreDetailList').datagrid('clearChecked');
			           //editIndex = undefined;
					resetTrNum('instoreDetailList');						
				}
	
  //初始化下标
	function resetTrNum(tableId) {
		$tbody = $("#"+tableId+"");
		$tbody.find('>tr').each(function(i){
			$(':input, select', this).each(function(){
				var $this = $(this), name = $this.attr('name'), val = $this.val();
				if(name!=null){
					if (name.indexOf("#index#") >= 0){
						$this.attr("name",name.replace('#index#',i));
					}else{
						var s = name.indexOf("[");
						var e = name.indexOf("]");
						var new_name = name.substring(s+1,e);
						$this.attr("name",name.replace(new_name,i));
					}
				}
			});
			$(this).find('div[name=\'xh\']').html(i+1);
		});
	}
	(function($) {
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
  //根据用户输入的入库单好查询铸管部入库数据，查询到的数据作为铸管库入库数据，用户只需选择。
  function checkorder() {		
		var data = $("#searchpipecodeForm").parseForm();
		$("#instoreDataList").datagrid("reload", data);
	};	
	/**
	*添加到详细表
	**/
	function addPipecode(){
						
            var pipecodeListSelected = $("#instoreDataList").datagrid("getSelections"); 
            //console.log(pipecodeListSelected);
            var data_length=pipecodeListSelected.length;
            var productLine=$("#product_line").val();
            if(productLine==null){
            	alert("请选择生产线");
            }
          //  alert(productLine);
       		var selectData = {};
       		selectData.rows =[];
          	for(var index in pipecodeListSelected){
          		
          			var selectRowsData = pipecodeListSelected[index];
          		   	var row ={};
          		   	//管号表字段
          		   	row.pyear=selectRowsData.pYear;          		   	
          		   	row.pipeserial="";
          		   	row.packid="";
          		   	row.pipenum="";
          		   	row.batch="";
          		   	row.productLine=productLine; 
          		   	row.dn=selectRowsData.dn;
          		   	row.productPlanNo=selectRowsData.product_plan_no;         		   	
          		   	row.itemCode=selectRowsData.item_code;
      		   		row.itemCname=selectRowsData.item_cname;
          		   	row.expFlag=selectRowsData.expFlag;
          		  	row.specialDesc=selectRowsData.special_desc;
      		   	  	row.rukudanid =rukudanid;
      		   		row.id=getUuid();
      		   		//alert(selectRowsData.batchFull);     		   	  	         		   	  	   		   	  	     		   		      		   		
          		    selectData.rows.push(row);
          		  	//insertDataGridModel.insertRows(index,row);
          	}
          	//console.log(insertDataGridModel._data);
          	
          	$("#instoreDetailList").datagrid('loadData',selectData);
          	$('#instoreDetailList').datagrid('selectRow', 0).datagrid('beginEdit', 0);
          	console.log(selectData);
		};
		
		function getUrlParam(name)
		{
				var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
				var r = window.location.search.substr(1).match(reg);  //匹配目标参数
				if (r!=null) return unescape(r[2]); return null; //返回参数值
		};
		function save(){	
          	var getSelectionsDatas=$("#instoreDataList").datagrid("getSelections");
          	var data=JSON.stringify(getSelectionsDatas);
          	var sendNo=getUrlParam("sendNo");
          	//alert("data length:"+getSelectionsDatas.length);
          	var sumVal=0;
			var pcNum;
          	pcNum=getSelectionsDatas[0].pcNum;
          	for(var i=0; i<getSelectionsDatas.length; i++){
				var pnum=getSelectionsDatas[i].pipenum;
				//alert(pnum);
				if(isNaN(pnum)||pnum==null||pnum==""){  
		               sumValue +=0;  
		            }else{			            
		            	sumVal=parseInt(pnum)+parseInt(sumVal);														
		            } 
			}
			alert("您将要入库的管子支数是："+sumVal);
          	
          	//alert("sendNo:"+sendNo);   
          	
          	$.ajax({
				    url: "t_ZGK_PIPE_HCKDController.do?save",
				    data:{data:JSON.stringify(getSelectionsDatas),sendNo:sendNo},
				    dataType: "json",
				    type: "POST",          
				    success: function (data) {
				    	tip(data.message);
				    }
			});  
          	
		}
 </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">

		<div id="main">
			<div  id="south">
				<div id="left">
<form action="" id="searchpipecodeForm">
 <table cellpadding="0" cellspacing="1" class="formtable">
 	<tr>		
 				<td align="right"><label class="Validform_label"> 出库单号: </label>
				</td>
				<td class="value"><input class="inputxt" id="chukudanid"
					name="chukudanid" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>	
				<td align="right"><label class="Validform_label">车 号: </label>
				</td>
				<td class="value"><input class="inputxt" id="carno"
					name="carno" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>
				
				
				<td class="value"><input class="button" name="查询" onclick="checkorder()"
					value="查询计划" style="font-size: 22 ">
				</td>
				<td class="value"><input class="button" name="提交入库信息" value="提交入库信息"
						onclick="save()"></td>
			</tr>
			
 </table>
 </form>
				</div>
				<div id="right">
					<div style="border: 1px solid; height: 500px;width:1400px;"
		align="left">
		<t:datagrid name="instoreDataList" title="计划列表" checkbox="true"
			actionUrl="HCShortTransitController.do?datagrid"
			idField="id" pageSize="200">			
			<t:dgCol title="出库单号" field="chukudanid" ></t:dgCol>									
			<t:dgCol title="规格" field="dn" ></t:dgCol>
			<t:dgCol title="批次" field="batch_full"  ></t:dgCol>
			<t:dgCol title="管号" field="pipe_serial"   ></t:dgCol>						
			<t:dgCol title="包号" field="packageid"  ></t:dgCol>
			<t:dgCol title="支数" field="pipenum"></t:dgCol>
			<t:dgCol title="生产线" field="product_plan_no"  ></t:dgCol>
			<t:dgCol title="代码" field="item_code" ></t:dgCol>	
			<t:dgCol title="产品名称" field="item_cname" ></t:dgCol>		
			<t:dgCol title="内外销" field="exp_flag"></t:dgCol>
			<t:dgCol title="合同描述" field="special_desc"></t:dgCol>			
			<t:dgCol title="套装方式" field="suit_way"></t:dgCol>
			<t:dgCol title="生产线" field="product_line"></t:dgCol>					
			<t:dgCol title="编号" field="id"></t:dgCol>		
		</t:datagrid>
	</div>	
				</div>
			</div>

			</div>
	
 </body>