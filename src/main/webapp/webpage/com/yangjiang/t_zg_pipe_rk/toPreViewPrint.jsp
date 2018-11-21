<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title >广东新兴铸管有限公司</title>
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
			text-align: center;
			width:300px;
			margin: 4px auto;
			font-size: 28px;
			font-weight: bold;
			border-top: 8px;
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
			width: 980px;
		}
		.table-info td{
			padding: 8px;
			text-align: center;
			font-size: 14px;
			font-weight: bold;
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
    		<div class="print-titile" align="center">球墨铸铁管成品入库单</div><span class="print-btn" onclick="doPrint()" style="color: red">打印</span>
    		<ul class="attr-info">
    			<li>流水号：</li><li class="underline">${t_zg_pipe_rk.rukudanid }</li>
    			<li>特殊合同描述：</li><li class="underline">${printData[0].special_desc}</li>
    			<li>日期：</li><li class="underline">${t_zg_pipe_rk.riqi }</li>
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			<li>规格：</li><li class="underline">${printData[0].dn }</li>
    			<li>级别：</li><li class="underline">${printData[0].PROD_GRADE_DESC }</li>
    			<li>接口：</li><li class="underline">${printData[0].INTERFACE_DESC }</li>
    			<li>出口：</li><li class="underline">${printData[0].exp_flag }</li>
    			<li>长度：</li><li class="underline">${printData[0].LENGTH_DESC }</li>
    			<li>内衬：</li><li class="underline">${printData[0].INNER_LINING_DESC }</li>
    			<div class="clear"></div>
    		</ul>
    		<ul class="attr-info">
    			<li>喷锌：</li><li class="underline">${printData[0].ZN_THICK_DESC }</li>
    			<li>外涂层：</li><li class="underline">${printData[0].OUTER_COATING_DESC }</li>
    			<li>线别：</li><li class="underline">${printData[0].product_line }</li>
    			<li>标重：</li><li class="underline">${printData[0].PIECE_WT }</li>    			
    			<div class="clear"></div>
    		</ul>
    		<table class="table-info" border="1"  bordercolor="#000"  cellspacing="0"  >
    			<thead>
    			<tr>
    				<td>序</td>
    				<td>批次</td>
    				<td>管号</td>
    				<td>包号</td>
    				<td>支数</td>
    				<td>序</td>
    				<td>批</td>
    				<td>管号</td>
    				<td>包号</td>
    				<td>支数</td>
    				<td>序</td>
    				<td>批</td>
    				<td>管号</td>
    				<td>包号</td>
    				<td>支数</td>
    			</tr>
    			</thead>
    			<c:forEach var="row" begin="1" end="${rows }" step="1" varStatus="vs">
	    			<tr>
	    				<td> ${(3*(vs.index)-2) }</td>
	    				<c:choose>
	    					<c:when test="${(3*(vs.index)-3)<total }">
	    						<td>${printData[3*(vs.index)-3].batch_full }</td>
	    						<td>${printData[3*(vs.index)-3].pipe_serial }</td>
	    						<td>${printData[3*(vs.index)-3].packageid }</td>
	    						<td>${printData[3*(vs.index)-3].pipenum }</td>	    					
	    					</c:when>
	    					<c:otherwise>
	    						<td></td>
	    						<td></td>
	    						<td></td>
	    						<td></td>
	    						
	    					</c:otherwise>
	    				</c:choose>
	    				<td>${(3*(vs.index)-1) }</td>
	    				<c:choose>
	    					<c:when test="${(3*(vs.index)-2)<total }">
	    						<td>${printData[3*(vs.index)-2].batch_full }</td>
	    						<td>${printData[3*(vs.index)-2].pipe_serial }</td>
	    						<td>${printData[3*(vs.index)-2].packageid }</td>
	    						<td>${printData[3*(vs.index)-2].pipenum }</td>	    						
	    					</c:when>
	    					<c:otherwise>
	    						<td></td>
	    						<td></td>
	    						<td></td>
	    						<td></td>
	    						
	    					</c:otherwise>
	    				</c:choose>
	    				<td>${(3*(vs.index)) }</td>
	    				<c:choose>
	    					<c:when test="${(3*(vs.index)-1)<total }">
	    						<td>${printData[3*(vs.index)-1].batch_full }</td>
	    						<td>${printData[3*(vs.index)-1].pipe_serial }</td>
	    						<td>${printData[3*(vs.index)-1].packageid }</td>
	    						<td>${printData[3*(vs.index)-1].pipenum }</td>	    						
	    					</c:when>
	    					<c:otherwise>
	    						<td></td>
	    						<td></td>
	    						<td></td>
	    						<td></td>
	    						
	    					</c:otherwise>
	    				</c:choose>
	    			</tr>
    			</c:forEach>
    		</table>
    		<ul class="attr-info">
    			<li>合计：</li><li class="underline"></li>
    			<li>合计支数：</li><li class="underline">${TotalData.totalPipeNum }支</li>
    			<li>合计重量：</li><li class="underline">${TotalData.totalWeight }</li>
    			
    			<li>运输人：</li><li class="underline">${printData[0].yunshuren }</li>
    			<li>车号：</li><li class="underline">${printData[0].che }</li>
    			<li>检验员：</li><li class="underline">${printData[0].jianyanyuan }</li>
    			<li>保管员：</li><li class="underline">${printData[0].baoguanyuan }</li>   			
    			<div class="clear"></div>
    			</ul>
    		
    	</div>
  </body>
</html>
