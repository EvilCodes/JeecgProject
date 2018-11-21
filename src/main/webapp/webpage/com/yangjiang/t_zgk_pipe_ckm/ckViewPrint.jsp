<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>广东新兴铸管有限公司</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<style type="text/css">
		body,div,p,ul,li,table,tr,td,tr,h1,h2,h3,h4,h5,h6{
			margin: 0;
			padding: 0;
		}
		.clear{
			clear: both;
		}
		.main-panel{
			width: 1000px;
			margin: 0px auto;
		}
		.print-titile{
			width:400px;
			margin: 0px auto;
			font-size: 28px;
			font-weight: bold;
		}
		.print-btn{
			margin-left: 30px;
			cursor: pointer;
		}
		li{
			list-style: none;
		}
		.attr-info li {
			float: left;
			text-align: left;
			padding: 5px 10px 5px 5px;;
			font-size: 22px;
			font-family:宋体;
		}
		.underline{
			text-decoration: underline;
		}
		.table-info{
			width: 1000px;
		}
		.table-info td{
			padding: 8px;
			text-align: center;
			font-size: 22px;
			font-family:宋体;
		}
	</style>
	<script type="text/javascript">
	
		function doPrint(){	
			window.print();
		}
	</script>
  </head>  
  <body>
    	<div class="main-panel" id="content">
    		<div class="print-titile">${printData[0].store_name }出库单</div><span class="print-btn" onclick="doPrint()" style="color: red">打印</span>
    		<ul class="attr-info">
    			<li>出库单编号：</li><li class="underline">${t_zg_pipe_ckm.chukudanid }</li>    			
    			
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			   			
    			<li>日期：</li><li class="underline">${printData[0].riqi }</li>
    			<li>仓库名称：</li><li class="underline">${printData[0].store_name }</li>
    			<li>保管员：</li><li class="underline">${printData[0].baoguanyuan }</li>
    			
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			<li>车种：</li><li class="underline">${printData[0].trnp_mode }</li>
    			<li>车号：</li><li class="underline">${printData[0].car_no }</li>
    			<li>收货单位：</li><li class="underline">${printData[0].consign_cname }</li>
    			
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			<li>销售公司：</li><li class="underline">${printData[0].org_name }</li>
    			<li>到站：</li><li class="underline">${printData[0].delivy_place_name }</li>
    			<li>承运商：</li><li class="underline">${printData[0].carry_company_name }</li>  			
    			<div class="clear"></div>
    		</ul>
    		<table class="table-info" border="1"  bordercolor="#000"  cellspacing="0"  >
    			<thead>
    				<td>规格</td>
    				<td>批号</td>
    				<td>品质</td>
    				<td>壁厚</td>
    				<td>接口</td>
    				<td>锌层厚度</td>
    				<td>外涂</td>
    				<td>内衬</td>
    				<td>销售合同</td>
    				<td>长度</td>
    				<td>支数</td>
    							
    			</thead>
    			<c:forEach var="row" begin="0" end="${total}" step="1" varStatus="vs">
	    			<tr>	    					    				
	    						<td>${printData[vs.index].dn }</td>
	    						<td>${printData[vs.index].batch_full }</td>
	    						<td>${printData[vs.index].exp_flag }</td>
	    						<td>${printData[vs.index].PROD_GRADE_DESC }</td>
	    						<td>${printData[vs.index].INTERFACE_DESC }</td>
	    						<td>${printData[vs.index].ZN_THICK_DESC }</td>
	    						<td>${printData[vs.index].OUTER_COATING_DESC }</td>
	    						<td>${printData[vs.index].INNER_LINING_DESC }</td>
	    						<td>${printData[vs.index].special_desc }</td>
	    						<td>${printData[vs.index].LENGTH_DESC }</td>
	    						<td>${printData[vs.index].pipenum }</td>
	    						   					
	    			</tr>
    			</c:forEach>
    		</table>
    		<table class="table-info" border="1"  bordercolor="#000"  cellspacing="0">
    		<thead>
    				
    				<td>序号</td>
    				<td>货物名称</td>
    				<td>规格</td>
    				<td>数量</td>
    				<td>重量</td>
    				<td>厂家代码</td>
    				<td>备注</td>
    		</thead>
    		<%-- <tr>
    		<td>1</td>
    		<td>${jqprintData[0].name }</td>
    		<td>${jqprintData[0].SPEC_DESC }</td>
    		<td>${jqprintData[0].sendNum }</td>
    		<td>${jqprintData[0].sendWeight }</td>
    		<td>${jqprintData[0].factory }</td>
    		<td>${jqprintData[0].remark }</td>
    		
    		</tr> --%>
    		
    		<c:forEach  items="${jqprintData}" var="li" varStatus="status">
	    		<tr>		    					    				
	    						<td>${status.index+1 }</td>
	    						<td>${li.name }</td>
	    						<td>${li.SPEC_DESC }</td>
	    						<td>${li.sendNum }</td>	    						
	    						<td>${li.sendWeight }</td>
	    						<td>${li.factory }</td>
	    						<td>${li.remark }</td>
	    						
	    						   					
	    		</tr>	
    			</c:forEach>
    			
    		</table>
    		<ul class="attr-info">
    			<li>合计：</li>
    			<li>支数：</li><li class="underline">${TotalData.totalPipeNum } 支</li>
    			<li>吨数：</li><li class="underline">${TotalData.totalWeight } 吨</li>    					
    			<div class="clear"></div>
    			</ul>
    		<span>注：共两联，一联留存，二联质检</span>
    	</div>
  </body>
</html>
