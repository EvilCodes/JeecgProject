<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addT_ZGK_PIPE_RKDBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delT_ZGK_PIPE_RKDBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addT_ZGK_PIPE_RKDBtn').bind('click', function(){   
 		 var tr =  $("#add_t_ZGK_PIPE_RKD_table_template tr").clone();
	 	 $("#add_t_ZGK_PIPE_RKD_table").append(tr);
	 	 resetTrNum('add_t_ZGK_PIPE_RKD_table');
    });  
	$('#delT_ZGK_PIPE_RKDBtn').bind('click', function(){   
      	$("#add_t_ZGK_PIPE_RKD_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_t_ZGK_PIPE_RKD_table'); 
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addT_ZGK_PIPE_RKDBtn" href="#">添加</a> <a id="delT_ZGK_PIPE_RKDBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="t_ZGK_PIPE_RKD_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">入库单号</td>
				  <td align="left" bgcolor="#EEEEEE">规格</td>
				  <td align="left" bgcolor="#EEEEEE">批号全称</td>
				  <td align="left" bgcolor="#EEEEEE">管序号</td>
				  <td align="left" bgcolor="#EEEEEE">包号</td>
				  <td align="left" bgcolor="#EEEEEE">生产计划号</td>
				  <td align="left" bgcolor="#EEEEEE">产品编码</td>
				  <td align="left" bgcolor="#EEEEEE">产品名称</td>
				  <td align="left" bgcolor="#EEEEEE">出口标识</td>
				  <td align="left" bgcolor="#EEEEEE">特殊合同描述</td>
				  <td align="left" bgcolor="#EEEEEE">支数</td>
				  <td align="left" bgcolor="#EEEEEE">套装方式</td>
				  <td align="left" bgcolor="#EEEEEE">货位</td>
				  <td align="left" bgcolor="#EEEEEE">层号</td>
				  <td align="left" bgcolor="#EEEEEE">层序号</td>
				  <td align="left" bgcolor="#EEEEEE">生产线</td>
				  <td align="left" bgcolor="#EEEEEE">pipeCod</td>
	</tr>
	<tbody id="add_t_ZGK_PIPE_RKD_table">	
	<c:if test="${fn:length(t_ZGK_PIPE_RKDList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].rukudanid" maxlength="20" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].dn" maxlength="10" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].batchFull" maxlength="10" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].pipeSerial" maxlength="10" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].packageid" maxlength="20" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].productPlanNo" maxlength="20" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].itemCode" maxlength="20" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].itemCname" maxlength="200" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].expFlag" maxlength="8" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].specialDesc" maxlength="50" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].pipenum" maxlength="2" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].suitWay" maxlength="30" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].huowei" maxlength="10" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].cengci" maxlength="1" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].cengneixuhao" maxlength="1" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].productLine" maxlength="20" type="text" style="width:120px;" ></td>
				  <td align="left"><input name="t_ZGK_PIPE_RKDList[0].pipeCode" maxlength="100" type="text" style="width:120px;" ></td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(t_ZGK_PIPE_RKDList)  > 0 }">
		<c:forEach items="${t_ZGK_PIPE_RKDList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
				<input name="t_ZGK_PIPE_RKDList[${stuts.index }].id"  value="${poVal.id }" type="hidden" >
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].rukudanid" maxlength="20" value="${poVal.rukudanid }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].dn" maxlength="10" value="${poVal.dn }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].batchFull" maxlength="10" value="${poVal.batchFull }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].pipeSerial" maxlength="10" value="${poVal.pipeSerial }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].packageid" maxlength="20" value="${poVal.packageid }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].productPlanNo" maxlength="20" value="${poVal.productPlanNo }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].itemCode" maxlength="20" value="${poVal.itemCode }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].itemCname" maxlength="200" value="${poVal.itemCname }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].expFlag" maxlength="8" value="${poVal.expFlag }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].specialDesc" maxlength="50" value="${poVal.specialDesc }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].pipenum" maxlength="2" value="${poVal.pipenum }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].suitWay" maxlength="30" value="${poVal.suitWay }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].huowei" maxlength="10" value="${poVal.huowei }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].cengci" maxlength="1" value="${poVal.cengci }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].cengneixuhao" maxlength="1" value="${poVal.cengneixuhao }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].productLine" maxlength="20" value="${poVal.productLine }" type="text" style="width:120px;"></td>
				   <td align="left"><input name="t_ZGK_PIPE_RKDList[${stuts.index }].pipeCode" maxlength="100" value="${poVal.pipeCode }" type="text" style="width:120px;"></td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>