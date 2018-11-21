<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>光谱数据</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_ZG_HY_GPController.do?save">
			<input id="id" name="id" type="hidden" value="${t_ZG_HY_GPPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							分析时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="分析时间" name="分析时间" 
							     value="<fmt:formatDate value='${t_ZG_HY_GPPage.分析时间}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							试样名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="试样名称" name="试样名称" ignore="ignore"
							   value="${t_ZG_HY_GPPage.试样名称}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							试样编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="试样编号" name="试样编号" 
							   value="${t_ZG_HY_GPPage.试样编号}" datatype="*">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							判定:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="判定" name="判定" ignore="ignore"
							   value="${t_ZG_HY_GPPage.判定}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							c:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="c" name="c" ignore="ignore"
							   value="${t_ZG_HY_GPPage.c}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							si:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="si" name="si" ignore="ignore"
							   value="${t_ZG_HY_GPPage.si}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							mn:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mn" name="mn" ignore="ignore"
							   value="${t_ZG_HY_GPPage.mn}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							s:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="s" name="s" ignore="ignore"
							   value="${t_ZG_HY_GPPage.s}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							p:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="p" name="p" ignore="ignore"
							   value="${t_ZG_HY_GPPage.p}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							mg:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mg" name="mg" ignore="ignore"
							   value="${t_ZG_HY_GPPage.mg}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ni:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ni" name="ni" ignore="ignore"
							   value="${t_ZG_HY_GPPage.ni}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cr:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cr" name="cr" ignore="ignore"
							   value="${t_ZG_HY_GPPage.cr}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							mo:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mo" name="mo" ignore="ignore"
							   value="${t_ZG_HY_GPPage.mo}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							v:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="v" name="v" ignore="ignore"
							   value="${t_ZG_HY_GPPage.v}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ti:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ti" name="ti" ignore="ignore"
							   value="${t_ZG_HY_GPPage.ti}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							al:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="al" name="al" ignore="ignore"
							   value="${t_ZG_HY_GPPage.al}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							pb:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pb" name="pb" ignore="ignore"
							   value="${t_ZG_HY_GPPage.pb}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ce:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ce" name="ce" ignore="ignore"
							   value="${t_ZG_HY_GPPage.ce}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							cu:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cu" name="cu" ignore="ignore"
							   value="${t_ZG_HY_GPPage.cu}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ceq:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ceq" name="ceq" ignore="ignore"
							   value="${t_ZG_HY_GPPage.ceq}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							lrsj:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="lrsj" name="lrsj" ignore="ignore"
							     value="<fmt:formatDate value='${t_ZG_HY_GPPage.lrsj}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							b:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="b" name="b" ignore="ignore"
							   value="${t_ZG_HY_GPPage.b}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sb:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sb" name="sb" ignore="ignore"
							   value="${t_ZG_HY_GPPage.sb}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							as1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="as1" name="as1" ignore="ignore"
							   value="${t_ZG_HY_GPPage.as1}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							sn:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sn" name="sn" ignore="ignore"
							   value="${t_ZG_HY_GPPage.sn}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							lrr:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lrr" name="lrr" ignore="ignore"
							   value="${t_ZG_HY_GPPage.lrr}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							lrbm:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="lrbm" name="lrbm" ignore="ignore"
							   value="${t_ZG_HY_GPPage.lrbm}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>