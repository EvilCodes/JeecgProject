<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>新兴铸管股份有限公司</title>
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
			width:300px;
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
			font-size: 18px;
			font-weight: bold;
		}
		.underline{
			text-decoration: underline;
		}
		.table-info{
			width: 1000px;
		}
		.table-info td{
			padding: 8px;
			font-size: 16px;
			text-align: center;
		}
	</style>
	<script type="text/javascript">
	
		function doPrint(){			
			window.print();
		}
	</script>
  </head>  
  <body>
    	<div class="main-panel">
    		<div class="print-titile">铸管成品库退库单</div><span class="print-btn" onclick="doPrint()" style="color: red">打印</span>
    		<ul class="attr-info">
    			<li>退库单编号：</li><li class="underline">${t_zg_pipe_tkm.tuikudanid }</li>    			
    			
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			   			
    			<li>日期：</li><li class="underline">${printData[0].riqi }</li>
    			<li>库房：</li><li class="underline">${printData[0].store_name }</li>
    			<li>生产单位：</li><li class="underline">${printData[0].consignee }</li>    			
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			<li>保管员：</li><li class="underline">${printData[0].baoguanyuan }</li>  
    			<li>备注：</li>  			
    			<div class="clear"></div>
    		</ul>    	
    		<table class="table-info" border="1"  bordercolor="#000"  cellspacing="0"  >
    			<thead>
    				<td>货位</td>
    				<td>批号</td>
    				<td>管号</td>
    				<td>包号</td>	
    				<td>规格</td>
    				<td>壁厚</td>
    				<td>接口</td>
    				<td>品质</td>
    				<td>销售合同</td>
    				<td>支数</td>   				
    				
    				<td>锌层</td>
    				<td>外涂</td>
    				<td>内衬</td>	
    						
    			</thead>
    			<c:forEach var="row" begin="0" end="${total}" step="1" varStatus="vs">
	    			<tr>	    					    				
	    						<td>${printData[vs.index].huowei }</td>
	    						<td>${printData[vs.index].batch_full }</td>
	    						<td>${printData[vs.index].pipe_serial }</td>
	    						<td>${printData[vs.index].packageid }</td>
	    						<td>${printData[vs.index].dn }</td>
	    						<td>${printData[vs.index].PROD_GRADE_DESC }</td>
	    						<td>${printData[vs.index].INTERFACE_DESC }</td>
	    						<td>${printData[vs.index].exp_flag }</td>
	    						<td>${printData[vs.index].special_desc }</td>
	    						<td>${printData[vs.index].pipenum }</td>
	    						
	    						
	    						<td>${printData[vs.index].ZN_THICK_DESC }</td>
	    						<td>${printData[vs.index].OUTER_COATING_DESC }</td>
	    						<td>${printData[vs.index].INNER_LINING_DESC }</td>
	    						
	    						   					
	    			</tr>
    			</c:forEach>
    		</table>
    		<ul class="attr-info">
    			<li>合计</li><li class="underline"></li>
    			<li>支数：</li><li class="underline"> ${TotalData.totalPipeNum }支</li>
    			<li>重量：</li><li class="underline"> ${TotalData.totalWeight }吨</li>					
    			<div class="clear"></div>
    		</ul>
    	</div>
  </body>
</html>
