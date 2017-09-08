$(function() {
	var role_datagrid = $("#role_datagrid");
	var role_dialog = $("#role_dialog");
	var editForm = $("#editForm");
	var allPermission = $("#allPermission");
	var selfPermission = $("#selfPermission");
	role_datagrid.datagrid({
		url : "/role_list.do",
		fitColumns : true,
		fit : true,
		striped : true,
		pagination : true,
		singleSelect : true,
		toolbar : "#role_tb",
		columns : [ [ {
			field : 'sn',
			title : '角色编号',
			width : 1
		}, {
			field : 'name',
			title : '角色名称',
			width : 1
		}

		] ]

	});

	role_dialog.dialog({
		width : 600,
		height : 500,
		closed : true,
		buttons : "#role_buts"
	});
	allPermission.datagrid({
		width : 250,
		height : 350,
		url : "/permission_listAll.do",
		fitColumns : true,
		title : '所有权限',
		columns : [ [ {
			field : 'name',
			title : '权限名称',
			align : 'center',
			width : 150
		} ] ],
		onDblClickRow : function(rowIndex, rowData) {
			// 取消选择所有当前页中所有的行
			allPermission.datagrid("unselectAll");
			// 获取已选择的所有数据(行)
			var rows = selfPermission.datagrid("getRows");
			// 判断选择的数据和已选择的数据对比id,如果存在,就选中当前行
			for ( var i = 0; i < rows.length; i++) {
				if (rowData.id == rows[i].id) {
					selfPermission.datagrid("selectRow", i);
					return;
				}
			}
			selfPermission.datagrid("appendRow", rowData);
		}
	});
	selfPermission.datagrid({
		width : 250,
		height : 350,
		title : '已有权限',
		fitColumns : true,
		columns : [ [ {
			field : 'name',
			title : '权限名称',
			align : 'center',
			width : 150
		} ] ],
		onDblClickRow : function(rowIndex, rowData) {
			// 删除当前选中的行
			selfPermission.datagrid("deleteRow", rowIndex);
		}
	});

	var methodName = {
		add : function() {
			selfPermission.datagrid("loadData", {
				rows : []
			});
			editForm.form("clear");
			role_dialog.dialog("open");
			role_dialog.dialog("setTitle", "保存角色");

		},
		edit : function() {
			var rowData = role_datagrid.datagrid("getSelected");
			if (!rowData) {
				$.messager.alert('来自网页的消息', "请选择一行数据", 'info');
				return;
			}

			editForm.form("clear");
			//获取datagrid属性对象
			var options= selfPermission.datagrid("options");
			//设置已有权限的URL,加载选中的角色的权限
			options.url="/getPermissionsByRoleId.do?rid="+rowData.id;
			//重新加载数据
			selfPermission.datagrid("reload");
			role_dialog.dialog("open");
			role_dialog.dialog("setTitle", "角色编辑");
			editForm.form("load", rowData);
		},

		cancel : function() {
			role_dialog.dialog("close");
		},

		save : function() {
			var url;
			if ($("[name='id']").val()) {
				url = "/role_update.do";
			} else {
				url = "/role_save.do";
			}

			editForm.form('submit', {
				url : url,
				onSubmit : function(param) {
					var rows = selfPermission.datagrid("getRows");
					for ( var i = 0; i < rows.length; i++) {
						param["permissions[" + i + "].id"] = rows[i].id;
					}
				},
				success : function(data) {
					data = eval("(" + data + ")");
					if (data.success) {
						$.messager.alert('来自网页的消息', data.msg, 'info',
								function() {
									role_dialog.dialog("close");
									role_datagrid.datagrid("reload");
								});
					} else {
						$.messager.alert('来自网页的消息', data.msg, 'info');
					}
				}
			});
		},
		query : function() {
			var keyword = $("[name='keyword']").val();
			role_datagrid.datagrid('load', {
				keyword : keyword
			});

		},
		// 查询全部
		reload : function() {
			// 清空查询条件
			$("[name='keyword']").val('');
			role_datagrid.datagrid('load', {});

		},
        loadPermission : function () {
            $.messager.confirm('温馨提示', '确定要重新加载所有权限？', function (r) {
                if (r) {
                    $.post("/loadPermission.do", {
                    }, function (data) {
                        $.messager.alert('温馨提示', data.msg, 'info', function () {
                            // 刷新数据表格(保持在当前页)
                            role_datagrid.datagrid("reload");
                        });
                    })
                }
            });
        }
	};
	// 统一事件绑定
	$("a[data-cmd]").on("click", function() {
		var data = $(this).data("cmd");
		methodName[data]();
	})

});
