<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>光谱数据表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="t_zg_analy_GPController.do?save">
			<input id="id" name="id" type="hidden" value="${t_zg_analy_GPPage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							分析时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="analydate" name="analydate" ignore="ignore"
							     value="<fmt:formatDate value='${t_zg_analy_GPPage.analydate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							样子编号:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sampleno" name="sampleno" ignore="ignore"
							   value="${t_zg_analy_GPPage.sampleno}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							样子名称:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="samplename" name="samplename" ignore="ignore"
							   value="${t_zg_analy_GPPage.samplename}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							判定结果:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="result" name="result" ignore="ignore"
							   value="${t_zg_analy_GPPage.result}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							C:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="c" name="c" ignore="ignore"
							   value="${t_zg_analy_GPPage.c}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Si:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="si" name="si" ignore="ignore"
							   value="${t_zg_analy_GPPage.si}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Mn:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mn" name="mn" 
							   value="${t_zg_analy_GPPage.mn}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							S:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="s" name="s" ignore="ignore"
							   value="${t_zg_analy_GPPage.s}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							P:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="p" name="p" ignore="ignore"
							   value="${t_zg_analy_GPPage.p}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Mg:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mg" name="mg" ignore="ignore"
							   value="${t_zg_analy_GPPage.mg}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Ni:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ni" name="ni" ignore="ignore"
							   value="${t_zg_analy_GPPage.ni}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Cr:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cr" name="cr" ignore="ignore"
							   value="${t_zg_analy_GPPage.cr}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Mo:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="mo" name="mo" ignore="ignore"
							   value="${t_zg_analy_GPPage.mo}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							V:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="v" name="v" ignore="ignore"
							   value="${t_zg_analy_GPPage.v}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Ti:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ti" name="ti" ignore="ignore"
							   value="${t_zg_analy_GPPage.ti}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Al:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="al" name="al" ignore="ignore"
							   value="${t_zg_analy_GPPage.al}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Pb:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="pb" name="pb" ignore="ignore"
							   value="${t_zg_analy_GPPage.pb}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Ce:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ce" name="ce" ignore="ignore"
							   value="${t_zg_analy_GPPage.ce}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Cu:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="cu" name="cu" ignore="ignore"
							   value="${t_zg_analy_GPPage.cu}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Ceq:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="ceq" name="ceq" ignore="ignore"
							   value="${t_zg_analy_GPPage.ceq}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							录入时间:
						</label>
					</td>
					<td class="value">
						<input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="inputdate" name="inputdate" ignore="ignore"
							     value="<fmt:formatDate value='${t_zg_analy_GPPage.inputdate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							B:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="b" name="b" ignore="ignore"
							   value="${t_zg_analy_GPPage.b}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Sb:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sb" name="sb" ignore="ignore"
							   value="${t_zg_analy_GPPage.sb}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							As1:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="as1" name="as1" ignore="ignore"
							   value="${t_zg_analy_GPPage.as1}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							Sn:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="sn" name="sn" ignore="ignore"
							   value="${t_zg_analy_GPPage.sn}" datatype="d">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							录入人:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="inputer" name="inputer" ignore="ignore"
							   value="${t_zg_analy_GPPage.inputer}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							录入部门:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="department" name="department" ignore="ignore"
							   value="${t_zg_analy_GPPage.department}">
						<span class="Validform_checktip"></span>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>