$(function() {
	storage = $.localStorage;
	if (!storage)
		storage = $.cookieStorage;
	$('#vOrderPipeCodeList')
			.datagrid(
					{
						idField : 'id',
						title : '�ܺŲ�ѯ�б�',
						url : 'myjkscjhController.do?orderDataGrid&field=dn,grade,interface_desc,length,pipetype,contract_desc,item_cname,item_code,special_desc,product_plan_no,',
						fit : true,
						loadMsg : '���ݼ�����...',
						pageSize : 10,
						pagination : true,
						pageList : [ 10, 20, 30 ],
						sortOrder : 'asc',
						rownumbers : true,
						singleSelect : false,
						fitColumns : true,
						striped : true,
						showFooter : true,
						frozenColumns : [ [ {
							field : 'ck',
							checkbox : 'true'
						}, ] ],
						columns : [ [ {
							field : 'dn',
							title : '���',
							sortable : true
						}, {
							field : 'grade',
							title : '����',
							sortable : true
						}, {
							field : 'interface_desc',
							title : '�ӿ�'
						}, {
							field : 'length',
							title : '����',
							sortable : true
						}, {
							field : 'pipetype',
							title : '����',
							sortable : true
						}, {
							field : 'contract_desc',
							title : '��Լ���'
						}, {
							field : 'item_cname',
							title : '��Ʒ��������'
						}, {
							field : 'item_code',
							title : '��Ʒ����'
						}, {
							field : 'special_desc',
							title : '�����ͬ����'
						}, {
							field : 'product_plan_no',
							title : '�����ƻ���'
						} ] ],
						onLoadSuccess : function(data) {
							$("#vOrderPipeCodeList")
									.datagrid("clearSelections");
						},
						onClickRow : function(rowIndex, rowData) {
							rowid = rowData.id;
							gridname = 'vOrderPipeCodeList';
						}
					});
	$('#vOrderPipeCodeList').datagrid('getPager').pagination({
		beforePageText : '',
		afterPageText : '/{pages}',
		displayMsg : '{from}-{to}�� {total}��',
		showPageList : true,
		showRefresh : true
	});
	$('#vOrderPipeCodeList').datagrid('getPager').pagination({
		onBeforeRefresh : function(pageNumber, pageSize) {
			$(this).pagination('loading');
			$(this).pagination('loaded');
		}
	});
	try {
		restoreheader();
	} catch (ex) {
	}
});
function reloadTable() {
	try {
		$('#' + gridname).datagrid('reload');
		$('#' + gridname).treegrid('reload');
	} catch (ex) {
	}
}
function reloadvOrderPipeCodeList() {
	$('#vOrderPipeCodeList').datagrid('reload');
}
function getvOrderPipeCodeListSelected(field) {
	return getSelected(field);
}
function getSelected(field) {
	var row = $('#' + gridname).datagrid('getSelected');
	if (row != null) {
		value = row[field];
	} else {
		value = '';
	}
	return value;
}
function getvOrderPipeCodeListSelections(field) {
	var ids = [];
	var rows = $('#vOrderPipeCodeList').datagrid('getSelections');
	for ( var i = 0; i < rows.length; i++) {
		ids.push(rows[i][field]);
	}
	ids.join(',');
	return ids
};
function getSelectRows() {
	return $('#vOrderPipeCodeList').datagrid('getChecked');
}
function saveHeader() {
	var columnsFields = null;
	var easyextends = false;
	try {
		columnsFields = $('#vOrderPipeCodeList').datagrid('getColumns');
		easyextends = true;
	} catch (e) {
		columnsFields = $('#vOrderPipeCodeList').datagrid('getColumnFields');
	}
	var cols = storage.get('vOrderPipeCodeListhiddenColumns');
	var init = true;
	if (cols) {
		init = false;
	}
	var hiddencolumns = [];
	for ( var i = 0; i < columnsFields.length; i++) {
		if (easyextends) {
			hiddencolumns.push({
				field : columnsFields[i].field,
				hidden : columnsFields[i].hidden
			});
		} else {
			var columsDetail = $('#vOrderPipeCodeList').datagrid(
					"getColumnOption", columnsFields[i]);
			if (init) {
				hiddencolumns.push({
					field : columsDetail.field,
					hidden : columsDetail.hidden,
					visible : (columsDetail.hidden == true ? false : true)
				});
			} else {
				for ( var j = 0; j < cols.length; j++) {
					if (cols[j].field == columsDetail.field) {
						hiddencolumns.push({
							field : columsDetail.field,
							hidden : columsDetail.hidden,
							visible : cols[j].visible
						});
					}
				}
			}
		}
	}
	storage.set('vOrderPipeCodeListhiddenColumns', JSON
			.stringify(hiddencolumns));
}
function isShowBut() {
	var isShowSearchId = $('#isShowSearchId').val();
	if (isShowSearchId == "true") {
		$("#searchColums").hide();
		$('#isShowSearchId').val("false");
		$('#columsShow').remove("src");
		$('#columsShow').attr("src",
				"plug-in/easyui/themes/default/images/accordion_expand.png");
	} else {
		$("#searchColums").show();
		$('#isShowSearchId').val("true");
		$('#columsShow').remove("src");
		$('#columsShow').attr("src",
				"plug-in/easyui/themes/default/images/accordion_collapse.png");
	}
}
function restoreheader() {
	var cols = storage.get('vOrderPipeCodeListhiddenColumns');
	if (!cols)
		return;
	for ( var i = 0; i < cols.length; i++) {
		try {
			if (cols.visible != false)
				$('#vOrderPipeCodeList').datagrid(
						(cols[i].hidden == true ? 'hideColumn' : 'showColumn'),
						cols[i].field);
		} catch (e) {
		}
	}
}
function resetheader() {
	var cols = storage.get('vOrderPipeCodeListhiddenColumns');
	if (!cols)
		return;
	for ( var i = 0; i < cols.length; i++) {
		try {
			$('#vOrderPipeCodeList').datagrid(
					(cols.visible == false ? 'hideColumn' : 'showColumn'),
					cols[i].field);
		} catch (e) {
		}
	}
}
function vOrderPipeCodeListsearch() {
	try {
		if (!$("#vOrderPipeCodeListForm").Validform({
			tiptype : 3
		}).check()) {
			return false;
		}
	} catch (e) {
	}
	if (true) {
		var queryParams = $('#vOrderPipeCodeList').datagrid('options').queryParams;
		$('#vOrderPipeCodeListtb').find('*').each(function() {
			queryParams[$(this).attr('name')] = $(this).val();
		});
		$('#vOrderPipeCodeList')
				.datagrid(
						{
							url : 'myjkscjhController.do?orderDataGrid&field=dn,grade,interface_desc,length,pipetype,contract_desc,item_cname,item_code,special_desc,product_plan_no,',
							pageNumber : 1
						});
	}
}
function dosearch(params) {
	var jsonparams = $.parseJSON(params);
	$('#vOrderPipeCodeList')
			.datagrid(
					{
						url : 'myjkscjhController.do?orderDataGrid&field=dn,grade,interface_desc,length,pipetype,contract_desc,item_cname,item_code,special_desc,product_plan_no,',
						queryParams : jsonparams
					});
}
function vOrderPipeCodeListsearchbox(value, name) {
	var queryParams = $('#vOrderPipeCodeList').datagrid('options').queryParams;
	queryParams[name] = value;
	queryParams.searchfield = name;
	$('#vOrderPipeCodeList').datagrid('reload');
}
$('#vOrderPipeCodeListsearchbox').searchbox({
	searcher : function(value, name) {
		vOrderPipeCodeListsearchbox(value, name);
	},
	menu : '#vOrderPipeCodeListmm',
	prompt : '�������ѯ�ؼ���'
});
function EnterPress(e) {
	var e = e || window.event;
	if (e.keyCode == 13) {
		vOrderPipeCodeListsearch();
	}
}
function searchReset(name) {
	$("#" + name + "tb").find(":input").val("");
	var queryParams = $('#vOrderPipeCodeList').datagrid('options').queryParams;
	$('#vOrderPipeCodeListtb').find('*').each(function() {
		queryParams[$(this).attr('name')] = $(this).val();
	});
	$('#vOrderPipeCodeList')
			.datagrid(
					{
						url : 'myjkscjhController.do?orderDataGrid&field=dn,grade,interface_desc,length,pipetype,contract_desc,item_cname,item_code,special_desc,product_plan_no,',
						pageNumber : 1
					});
}