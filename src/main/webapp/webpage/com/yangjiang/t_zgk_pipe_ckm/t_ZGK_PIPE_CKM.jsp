<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE html>
<html>
<head>
<style>
#main {
	border: 2px solid red;
	padding: 0px;
}

#top {
	min-height: 200px;
	border: 1px dashed blue;
}

#south {
	border: 1px dashed blue;
	padding: 0px;
	
}

#left {
	border: 1px dotted burlywood;
	width: 30%,
}
</style>
<title>铸管库管材出库</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<body style="overflow-y: hidden"  scroll="no">

	<form action="" id="searchForm">
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
		
			<tr>
				<td align="right"><label class="Validform_label"> 日期: </label>
				</td>
				<td class="value">
				<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  style="width: 150px" id="riqi1" name="riqi1" ignore="ignore"   
				onFocus="WdatePicker({startDate: new Date() ,dateFmt:'yyyy-MM-dd',alwaysUseStartDate: true })">
					 <span class="Validform_checktip"></span>
				</td>
				<td align="right"><label class="Validform_label"> 派车单号: </label>
				</td>
				<td class="value"><input class="inputxt" id="send_car_no"
					name="send_car_no" ignore="ignore" datatype="*"> <span
					class="Validform_checktip"></span>
				</td>	
				<td class="value"><input type="button" name="查询" onclick="checkpcd()"
					value="查询" style="font-size: 14 ">
				</td>
				</tr>
				<tr>
				<td>
				<label>请填写保管员：</label>
				</td>
				<td>
				<input type="text" id="baoguanyuan" name="baoguanyuan" value="">
				</td>
				<td>
				<label>临时出库单号：</label>
				</td>
				<td>
				<input type="text" id="chukudanid" name="chukudanid"  value="">
				</td>
				<td class="value">
				
				<input type="button" name="添加到入库详细信息" onclick="addpipecode_num()"
									value="添加到入库详细信息" style="font-size: 14 ">
				</td>
				<td class="value">
					<input type="button" name="提交保存" value="提交保存" onclick="save()">
				</td>
				</tr>				
		</table>
	</form>
	<div id="main">
		<table width="90%" height="30%">
			<tr>
				<td >
					<div id="south" >
						<div style="border: 1px solid red; height: 300px;width:800px;"
							align="left">
							<t:datagrid name="pcdlist" title="派车单查询"
								checkbox="true"  actionUrl="CheckPCDController.do?checkPCDGrid"  idField="bill_notice_no_item"
								  singleSelect="true" pagination="true" >
								<t:dgCol title="派车单号" field="send_car_no" frozenColumn="true"></t:dgCol>
								<t:dgCol title="派车单序号" field="number"
									frozenColumn="true"></t:dgCol>
									<t:dgCol title="承运商名称" field="carry_company_name"
									frozenColumn="true"></t:dgCol>
								<t:dgCol title="内外销" field="expFlag"></t:dgCol>
								<t:dgCol title="合同描述" field="specialDesc"></t:dgCol>
								<t:dgCol title="数量" field="carry_num"></t:dgCol>
								<t:dgCol title="重量" field="carry_wt"></t:dgCol>
								<t:dgCol title="产品描述" field="item_name"></t:dgCol>
								<t:dgCol title="产品编码" field="item_code"></t:dgCol>
								<t:dgCol title="车号" field="car_no"></t:dgCol>
								<t:dgCol title="仓库名称" field="out_storehouse_name"></t:dgCol>								
								<t:dgCol title="发运计划号" field="bill_notice_no"></t:dgCol>
								<t:dgCol title="发运计划明细号" field="bill_notice_no_item"></t:dgCol>
								<t:dgCol title="收货公司" field="consign_cname"></t:dgCol>
								<t:dgCol title="收货地" field="rec_add"></t:dgCol>
								<t:dgCol title="销售公司" field="org_name"></t:dgCol>
							</t:datagrid>
						</div>
				</div></td>
				<td>
					<div id="left" style="width: 30%">
						<div style="border: 1px solid red; height: 300px;width:600px;"
							align="right">
						
							<t:datagrid name="pipecodeList" title="" fit="true"
								checkbox="true"  actionUrl="CheckOutstorePipeCodeController.do?pipecodeDataGrid" idField="id" 
								autoLoadData="false"   pagination="true" showPageList="true" pageSize="100">								
								<t:dgCol title="包号" field="packageid" ></t:dgCol>
								<t:dgCol title="批号全称" field="batchFull"  ></t:dgCol>
								<t:dgCol title="管序号" field="pipeSerial" ></t:dgCol>
								<t:dgCol title="规格" field="dn" ></t:dgCol>
								<t:dgCol title="垛位号" field="huowei" ></t:dgCol>
								<t:dgCol title="层号" field="cengci" hidden="true"></t:dgCol>
								<t:dgCol title="层内序号" field="cengneixuhao" hidden="true"></t:dgCol>
								<t:dgCol title="生产计划号" field="productPlanNo" hidden="true"></t:dgCol>
								<t:dgCol title="名称" field="itemCname" hidden="true"></t:dgCol>
								<t:dgCol title="内外销标志" field="expFlag"></t:dgCol>
								<t:dgCol title="特殊合同描述" field="specialDesc" ></t:dgCol>					
								<t:dgCol title="支数" field="pipenum"></t:dgCol>
								<t:dgCol title="套装方式" field="suitWay" hidden="true"></t:dgCol>
								<t:dgCol title="生产线" field="productLine" hidden="true"></t:dgCol>
								<t:dgCol title="产品编码" field="itemCode"  hidden="true"></t:dgCol>
								<t:dgCol title="id" field="id"  hidden="true"></t:dgCol>
								
									
							</t:datagrid>
							<form action="" id="search">
							<table>
								<tr>
									<td>
									 <label>垛位:</label><input type="text" id="huowei">
									</td>
									<td>
									 <label>批号:</label><input type="text" id="batchfull">
									</td>
									<td>
									 <label>包号:</label><input type="text" id="packageid">
									</td>
									<td>
									 <input type="button" name="查询" value="查询" onclick="check()">
									</td>
								</tr>
							</table>
							</form>
						</div>

					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="top" style="width: 1400px;height:300px;">
		
			<t:datagrid name="t_ZG_PIPEList" title=""
				actionUrl="" idField="pipe_serial" fit="true" autoLoadData="false"
				checkbox="true">
				<t:dgCol title="编辑行"  field="opt_editor"  formatterjs="edit"></t:dgCol>
				<t:dgCol title="删除行"  field="opt_del"  formatterjs="del"></t:dgCol>
				<t:dgCol title="管号" field="pipe_serial" extendParams="editor:'text'"></t:dgCol>
				<t:dgCol title="批号" field="batch_full" extendParams="editor:'text'"></t:dgCol>
				<t:dgCol title="备注" field="remark" extendParams="editor:'text'"></t:dgCol>				
				<t:dgCol title="车号" field="send_car_no" ></t:dgCol>				
				<t:dgCol title="销售公司" field="org_name"></t:dgCol>
				<t:dgCol title="收货单位" field="consign_cname" ></t:dgCol>
				<t:dgCol title="到站" field="rec_add" ></t:dgCol>
				<t:dgCol title="产品编码" field="item_code" ></t:dgCol>
				<t:dgCol title="产品中文名称" field="item_cname" ></t:dgCol>				
				<t:dgCol title="仓库" field="store_name"></t:dgCol>
				<t:dgCol title="规格" field="dn"></t:dgCol>								
				<t:dgCol title="货位" field="huowei"></t:dgCol>
				<t:dgCol title="层号" field="cengci" ></t:dgCol>
				<t:dgCol title="层内序号" field="cengneixuhao" ></t:dgCol>
				<t:dgCol title="内外销" field="expFlag"  ></t:dgCol>	
				<t:dgCol title="合同描述" field="specialDesc" ></t:dgCol>			
				<t:dgCol title="编号" field="id" ></t:dgCol>				
			</t:datagrid>
			
			
		
	</div>

	<script type="text/javascript">
		var main_id=getUrlParam("pipe_rk_id");
		function getUuid(){
			  var len=36;//32长度
			  var radix=16;//16进制
			  var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');var uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
			  return uuid.join('');
			}
		var id=getUuid();
		Date.prototype.Format = function(fmt)   
		{ //author: meizz   
		  var o = {   
		    "M+" : this.getMonth()+1,                 //月份   
		    "d+" : this.getDate(),                    //日   
		    "h+" : this.getHours(),                   //小时   
		    "m+" : this.getMinutes(),                 //分   
		    "s+" : this.getSeconds(),                 //秒   
		    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
		    "S"  : this.getMilliseconds()             //毫秒   
		  };   
		  if(/(y+)/.test(fmt))   
		    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		  for(var k in o)   
		    if(new RegExp("("+ k +")").test(fmt))   
		  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		  return fmt;   
		}  
		function getUrlParam(name)
			{
					var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
					var r = window.location.search.substr(1).match(reg);  //匹配目标参数
					if (r!=null) return unescape(r[2]); return null; //返回参数值
			};
		$(document).ready(function() {
			$("#t_ZG_PIPEList").datagrid({
				onClickCell:function(rowIndex, field, value){
					console.log("当前行==》》》"+rowIndex);
					if(field=="opt_editor"){
					//	alert('编辑单元格');
						editRow(rowIndex)
					}else if(field=="opt_del"){
						//	alert('删除单元格');
						delRow(rowIndex);
					}
				}
			});
			
			$("#pcdlist").datagrid({
				singlSelect:true
			});
			$('#pcdlist').datagrid({
				onSelect: function(index,row){
					//TODO 事件响应代码；
					checkpipecode();																				
				}
			});									
			//初始化出库日期
			var curDate=new Date().Format("yyyy-MM-dd hh:mm:ss");
			var curDate1=new Date().Format("yyyyMMdd");
			console.log(curDate);
			$("#riqi").val(new Date().Format("yyyy-MM-dd hh:mm:ss"));
			$("#riqi1").val(new Date().Format("yyyy-MM-dd"));
			//alert($("#riqi").val());	
			$("#riqi1").val(new Date().Format("yyyy-MM-dd"));
			checkseq(curDate1);	
		});
		function pad(num, n) {   
	  		var i = (num + "").length;   
	  		while(i++ < n) num = "0" + num;   
	  		return num;   
	  		} ;
		//查询出库单序号
		function checkseq(sss){		
  		$.ajax({
		    url: "CheckOutstoreSeq.do?check",
		    data:{seq:sss},
		    dataType: "json",
		    type: "POST",          
		    success: function (data) {
		    	console.info("data:"+data);
		        var seq=pad(data,3);
		        $("#chukudanid").val(sss+"Y1"+seq);
		        console.info("sss+seq:"+sss+seq);
		       var store_name=$("#store_name").val();
		    }
	});  
  	}
		function del(val,row,index){  
		    return '<a href="#"  onclick="javascript:void(0);">删除</a>';  
		}  
		function edit(val,row,index){  
		    return '<a href="#"  onclick="javascript:void(0);">编辑</a>';  
			} 
		//编辑行
		function editRow(index){
			var rows=$('#t_ZG_PIPEList').datagrid("getChecked");
			if(rows.length==0){
				tip("请选择条目");
				return false;
			}
			$('#t_ZG_PIPEList').datagrid('beginEdit', index);
		}
		//结束编辑
		function endEdit(){
			//这里不应该只是编辑当前行？？？？？
			var  editIndex = $('#t_ZG_PIPEList').datagrid('getRows').length-1;
			for(var i=0;i<=editIndex;i++){
				if($('#t_ZG_PIPEList').datagrid('validateRow', i))
					$('#t_ZG_PIPEList').datagrid('endEdit', i);
				else
					return false;
			}
			return true;
		}
		//打印测试
		function printDemo(){
			window.print();
		}
		//删除行
		function delRow(index){		
			$('#t_ZG_PIPEList').datagrid('deleteRow',index);						
		}
		function checkpcd() {			
			var data = $("#searchForm").parseForm();						
			$("#pcdlist").datagrid("reload", data);
		};	
		function check(){
			var checkedItems =$("#pcdlist").datagrid('getSelected');
			
	 		var huowei =$("#huowei").val();
	 		var batchfull = $("#batchfull").val();
	 		var packageid = $("#packageid").val();
			//console.log("packageid:"+row);
			//$("#store_name").val(row.out_storehouse_name);
	 		//alert("dn:"+checkedItems.dn);
	 		$.post("CheckOutstorePipeCodeController.do?pipecodeDataGrid",{
	 			huowei:huowei,
	 			batchfull:batchfull,
	 			item_code:checkedItems.item_code,
	 			packageid:packageid
			  	},function(datas){			
					console.log(datas);					
					$("#pipecodeList").datagrid("loadData", datas)},"json");
	 				
			};
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
		
	 	function checkpipecode(){		 		
	 		var checkedItems =$("#pcdlist").datagrid('getSelected');
	 		var row = $("#pcdlist").datagrid("getSelected");
			console.log("ROW:"+row);
			$("#store_name").val(row.out_storehouse_name);
	 		//alert("dn:"+checkedItems.dn);
	 		$.post("CheckOutstorePipeCodeController.do?pipecodeDataGrid",{
	 				item_code:checkedItems.item_code,
	 				expFlag:checkedItems.expFlag,id:checkedItems.id,
	 				specialDesc:checkedItems.specialDesc
			  	},function(datas){			
					console.log(datas);					
					$("#pipecodeList").datagrid("loadData", datas)},"json");
	 				
			};
										
		/**
		*添加到详细表
		**/
		function addpipecode_num(){
			
			var chukudanid= $("#chukudanid").val();
			var curDate=new Date().Format("yyyy-MM-dd hh:mm:ss");
			var baoguanyuan= $("#baoguanyuan").val();
			//alert("chukudanid:"+chukudanid);
            var orderPipeRow = $("#pcdlist").datagrid("getSelected"); 
            var  pipecodeListSelected = $("#pipecodeList").datagrid("getSelections");
            var data_length=pipecodeListSelected.length;
            //alert(data_length);
            console.log(pipecodeListSelected);
       		var selectData = {};
       		selectData.rows =[];
          	for(var index in pipecodeListSelected){
          			var selectRowsData = pipecodeListSelected[index];
          		   	var row ={};
          		   	//管子信息（出库子表信息）
          		   	row.id=id;
          		  	row.chukudanid =chukudanid;
          		   	//row.pipe_serial = selectRowsData.pipe_serial;
          		  	row.packageid = selectRowsData.packageid;
          		 	row.dn=selectRowsData.dn;
          		 	row.batch_full=selectRowsData.batchFull;
          		   	row.pipe_serial = selectRowsData.pipeSerial;
          		 	row.product_plan_no=selectRowsData.productPlanNo;
      		   		row.special_desc=selectRowsData.specialDesc;
      		   		row.pipenum=selectRowsData.pipenum;
      		   		row.suit_way=selectRowsData.suitWay;
	      		   	row.huowei=selectRowsData.huowei;
	  		   		row.cengci=selectRowsData.cengci;
	  		   	    row.expFlag=selectRowsData.expFlag;
	  		   		
	  		  		row.cengneixuhao=selectRowsData.cengneixuhao;
	  		  		row.product_line=selectRowsData.productLine;
	  		  		row.bill_lading_no_item=orderPipeRow.bill_notice_no_item;//通知单明细号
      		   	  	//出库单主表信息
      		   	  	row.specialDesc=orderPipeRow.specialDesc;
      		   	  	row.riqi=curDate;
      		   	  	row.store_name=orderPipeRow.out_storehouse_name;
      		   		row.baoguanyuan=baoguanyuan;
      		   		row.send_car_no=orderPipeRow.send_car_no;
      		  		row.bill_notice_no=orderPipeRow.bill_notice_no;
      		  		row.carry_company_code=orderPipeRow.carry_company_code;
      		 		row.carry_company_name=orderPipeRow.carry_company_name;
      		 		row.trnp_mode=orderPipeRow.trnp_mode;
      		 		row.car_no=orderPipeRow.car_no;
      		 		row.driver_name=orderPipeRow.driver_name;
      		 		row.driver_tel=orderPipeRow.driver_tel;
      		 		row.id_number=orderPipeRow.id_number;
      		 		row.org_name=orderPipeRow.org_name;
      		 		row.consign_cname=orderPipeRow.consign_cname;
      		 		row.rec_add=orderPipeRow.rec_add;
      		 		row.pcNum=orderPipeRow.carry_num;
      		 		row.item_code=orderPipeRow.item_code;
      		   		row.item_cname=orderPipeRow.item_name;
      		 		
      		 		console.log("rec_add:"+orderPipeRow.rec_add);
      		 		
      		 		      				         				
      		   	  	//row.edittime=new Date().Format("yyyy-MM-dd HH:mm:ss");
          		    selectData.rows.push(row);
          		 	$("#t_ZG_PIPEList").datagrid('appendRow', row);
          		   //console.log("row:"+row);
          	}
          	//alert(main_id);
          	 //alert("selectData:"+selectData);
          	//$("#t_ZG_PIPEList").datagrid('loadData', selectData);
          	
		};
		
			/**
			*你这里需要一行行的添加还是批量添加？？批量添加
			*
			**/
			function save(){	
				/**
				*t_ZG_PIPEList获取全部选中记录
				**/
				var sumVal=0;
				var pcNum;
	          	var getSelectionsDatas=$('#t_ZG_PIPEList').datagrid("getRows");
	          	pcNum=getSelectionsDatas[0].pcNum;
	          	
				console.log("getSelectionsDatas:"+JSON.stringify(getSelectionsDatas));
				//alert(getSelectionsDatas.length);
				for(var i=0; i<getSelectionsDatas.length; i++){
					var pnum=getSelectionsDatas[i].pipenum;
					//alert(sumValue);
					if(isNaN(pnum)||pnum==null||pnum==""){  
						sumVal +=0;  
			            }else{			            
			            	sumVal=parseInt(pnum)+parseInt(sumVal);		
			            	//alert(sumVal);
			            } 
				}
				alert("您将要入库的管子支数是："+sumVal);
				if(pcNum != sumVal){
					alert("派车数量是:"+pcNum+"而所选择的支数是："+sumVal+"；请检查所选管子数量是否等于派车数量，系统检测到所选数量不等于派车数量！！！！");
					
				}else{
					$.ajax({
					    url: "t_ZGK_PIPE_CKMController.do?save",
					    data:{data:JSON.stringify(getSelectionsDatas)},
					    dataType: "json",
					    type: "POST",          
					    success: function (data) {
				//	console.log('11111111  '+data);
					    //	tip(''+data.msg);
					 //   console.log('ssssssssssssssssssssssss');
					    //	console.log(data.msg);
					      alert(data.msg);
					    	//tip(data.msg);
					    
					    	
					    	//tip(data.msg);
							
					    }
				});
				}
				//alert(ids.join(''));
	          	
			}
	</script>


</body>