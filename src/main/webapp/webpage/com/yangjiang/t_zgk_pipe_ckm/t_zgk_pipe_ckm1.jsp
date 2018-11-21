<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<body style="overflow-y: hidden" scroll="no">
	<div class="easyui-layout" fit="true">
		<div region="center" style="padding:0px;border:0px">
			<t:datagrid name="t_ZGK_PIPE_CKMList" title="管材出库" checkbox="true"
				queryMode="group" actionUrl="t_ZGK_PIPE_CKMController.do?datagrid"
				idField="id" fit="true" pageSize="40" pagination="true">
				<t:dgCol title="操作" field="opt" frozenColumn="true"></t:dgCol>
				<t:dgFunOpt funname="addJQ(chukudanid)" title="添加胶圈"
					urlStyle="color:blue"></t:dgFunOpt>
				<t:dgFunOpt funname="ckViewPrint(chukudanid)" title="打印出库单"
					urlStyle="color:red"></t:dgFunOpt>
				<t:dgFunOpt funname="gzViewPrint(chukudanid)" title="打印跟踪卡"></t:dgFunOpt>
				<t:dgFunOpt funname="conceal()" title="作废出库单" urlStyle="color:blue"></t:dgFunOpt>
				<t:dgFunOpt funname="concealJQ()" title="删除胶圈" urlStyle="color:blue"></t:dgFunOpt>
				<t:dgFunOpt funname="checkpipecode(chukudanid)" title="删除管号"></t:dgFunOpt>
				<t:dgCol title="出库单号" field="chukudanid"></t:dgCol>
				<t:dgCol title="出库日期" field="riqi" formatter="yyyy-MM-dd"
					query="true"></t:dgCol>
				<t:dgCol title="库名" field="storeName"></t:dgCol>
				<t:dgCol title="保管员" field="baoguanyuan"></t:dgCol>
				<t:dgCol title="派车单" field="sendCarNo"></t:dgCol>
				<t:dgCol title="发货通知单号" field="billNoticeNo"></t:dgCol>
				<t:dgCol title="承运商代码" field="carryCompanyCode"></t:dgCol>
				<t:dgCol title="承运商名称" field="carryCompanyName"></t:dgCol>
				<t:dgCol title="运输方式名称" field="trnpMode"></t:dgCol>
				<t:dgCol title="车牌号" field="carNo"></t:dgCol>
				<t:dgCol title="司机姓名" field="driverName"></t:dgCol>
				<t:dgCol title="司机电话" field="driverTel"></t:dgCol>
				<t:dgCol title="司机身份证号" field="idNumber"></t:dgCol>
				<t:dgCol title="组织机构名称" field="orgName"></t:dgCol>
				<t:dgCol title="收货单位名称" field="consignCname"></t:dgCol>
				<t:dgCol title="交货地点名称" field="delivyPlaceName"></t:dgCol>
				<t:dgCol title="专线名称名称" field="privateRouteName" hidden="true"></t:dgCol>
				<t:dgCol title="读取标志" field="readFlag"></t:dgCol>
				<t:dgCol title="审核标志" field="shbz"></t:dgCol>
				<t:dgCol title="编号" field="id"></t:dgCol>
				<t:dgToolBar title="录入" icon="icon-add"
					url="t_ZGK_PIPE_CKMController.do?addorupdate" funname="add"
					width="100%" height="100%"></t:dgToolBar>
				<t:dgToolBar title="查看" icon="icon-search"
					url="t_ZGK_PIPE_CKMController.do?addorupdate" funname="detail"
					width="100%" height="100%"></t:dgToolBar>
			</t:datagrid>

		</div>
	</div>
	<script type="text/javascript">
	

	function checkpipecode(chukudanid) {
		
			addOneTab("查看已出库数据 ",
					"t_ZGK_PIPE_CKMController.do?list4&chukudanid="
							+ chukudanid, 900, 800);
		}
		function ckViewPrint(chukudanid) {
			addOneTab("入库单打印预览",
					"t_ZGK_PIPE_CKMController.do?ckViewPrint&chukudanid="
							+ chukudanid);
			console.info(chukudanid);
		}
		function addJQ(chukudanid) {
			addOneTab("添加胶圈", "t_ZGK_PIPE_CKD_JQController.do?list&chukudanid="
					+ chukudanid);
			console.info(chukudanid);
		}
		function concealJQ() {
			var row = $("#t_ZGK_PIPE_CKMList").datagrid("getSelected");
			var id = row.id + "";
			//alert("id::"+id);
			$.dialog.confirm("确定要删除该胶圈吗？", function() {
				$.ajax({
					url : "t_ZGK_PIPE_CKMController.do?doConcealJQ",
					data : {
						ids : id
					},
					dataType : "json",
					success : function(data) {
						tip(data.msg);
						$("#t_ZGK_PIPE_CKMList").datagrid("reload");
					}
				});
			}, function() {

			});
		}
		function gzViewPrint(chukudanid) {
			addOneTab("跟踪卡打印预览",
					"t_ZGK_PIPE_CKMController.do?gzViewPrint&chukudanid="
							+ chukudanid);
			console.info(chukudanid);
		}
	function conceal() {
			var row = $("#t_ZGK_PIPE_CKMList").datagrid("getSelected");
			var id = row.id + "";
			//	alert("id::"+id);
			$.dialog.confirm("确定要作废该订单吗？", function() {
				$.ajax({
					url : "t_ZGK_PIPE_CKMController.do?doConceal",
					data : {
						ids : id
					},
					dataType : "json",
					success : function(data) {
						tip(data.msg);
						$("#t_ZGK_PIPE_CKMList").datagrid("reload");
					}
				});
			}, function() {

			});
		}
		function checkrkm() {
			var data = $("#searchForm").parseForm();
			$("#t_ZGK_PIPE_CKMList").datagrid("reload", data);
			console.log("data:" + data);
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
		$(function() {
			$("#t_ZGK_PIPE_CKMListtb").find("input[name='riqi']").attr("class",
					"Wdate").attr("style", "height:20px;width:90px;").click(
					function() {
						WdatePicker({
							dateFmt : 'yyyy-MM-dd'
						});
					});
			$("input[name='riqi']").val(today);
		})
		function today() {
			var today = new Date();
			var h = today.getFullYear();
			var m = today.getMonth() + 1;
			var d = today.getDate();
			m = m < 10 ? "0" + m : m; //  这里判断月份是否<10,如果是在月份前面加'0'
			d = d < 10 ? "0" + d : d; //  这里判断日期是否<10,如果是在日期前面加'0'
			return h + "-" + m + "-" + d;
		}
	</script>
	</body>