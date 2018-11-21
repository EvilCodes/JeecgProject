<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>大系统用户信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="a10UserController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${a10UserPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							userId:
						</label>
					</td>
					<td class="value">
					     	 <input id="userId" name="userId" type="text" style="width: 150px" class="inputxt"  datatype="*">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userId</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							loginname:
						</label>
					</td>
					<td class="value">
					     	 <input id="loginname" name="loginname" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">loginname</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							loginpwd:
						</label>
					</td>
					<td class="value">
					     	 <input id="loginpwd" name="loginpwd" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">loginpwd</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							fullname:
						</label>
					</td>
					<td class="value">
					     	 <input id="fullname" name="fullname" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">fullname</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							email:
						</label>
					</td>
					<td class="value">
					     	 <input id="email" name="email" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">email</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							phone:
						</label>
					</td>
					<td class="value">
					     	 <input id="phone" name="phone" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">phone</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							enabled:
						</label>
					</td>
					<td class="value">
					     	 <input id="enabled" name="enabled" type="text" style="width: 150px" class="inputxt"  datatype="*">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">enabled</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							pwderrorcount:
						</label>
					</td>
					<td class="value">
					     	 <input id="pwderrorcount" name="pwderrorcount" type="text" style="width: 150px" class="inputxt"  datatype="*">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">pwderrorcount</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							logincount:
						</label>
					</td>
					<td class="value">
					     	 <input id="logincount" name="logincount" type="text" style="width: 150px" class="inputxt"  datatype="*">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">logincount</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							registertime:
						</label>
					</td>
					<td class="value">
							   <input id="registertime" name="registertime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">registertime</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							lastlogintime:
						</label>
					</td>
					<td class="value">
							   <input id="lastlogintime" name="lastlogintime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">lastlogintime</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							identitycode:
						</label>
					</td>
					<td class="value">
					     	 <input id="identitycode" name="identitycode" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">identitycode</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							createid:
						</label>
					</td>
					<td class="value">
					     	 <input id="createid" name="createid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">createid</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							createby:
						</label>
					</td>
					<td class="value">
					     	 <input id="createby" name="createby" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">createby</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							createtime:
						</label>
					</td>
					<td class="value">
							   <input id="createtime" name="createtime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">createtime</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							modifyid:
						</label>
					</td>
					<td class="value">
					     	 <input id="modifyid" name="modifyid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">modifyid</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							modifyby:
						</label>
					</td>
					<td class="value">
					     	 <input id="modifyby" name="modifyby" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">modifyby</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							modifytime:
						</label>
					</td>
					<td class="value">
							   <input id="modifytime" name="modifytime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">modifytime</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							isdeleted:
						</label>
					</td>
					<td class="value">
					     	 <input id="isdeleted" name="isdeleted" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">isdeleted</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							displayname:
						</label>
					</td>
					<td class="value">
					     	 <input id="displayname" name="displayname" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">displayname</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							danwei:
						</label>
					</td>
					<td class="value">
					     	 <input id="danwei" name="danwei" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">danwei</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							bumen:
						</label>
					</td>
					<td class="value">
					     	 <input id="bumen" name="bumen" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">bumen</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							danweiid:
						</label>
					</td>
					<td class="value">
					     	 <input id="danweiid" name="danweiid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">danweiid</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							bumenid:
						</label>
					</td>
					<td class="value">
					     	 <input id="bumenid" name="bumenid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">bumenid</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/yangjiang/a10User/a10User.js"></script>		
