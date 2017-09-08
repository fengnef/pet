$(function() {
	// 抽取变量
	// 初始化数据表格
	$("#shopkeeper_datagrid").datagrid({
		url : "/shopkeeper_list.do",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#shopkeeper_tb',
		columns : [ [ {
			field : 'username',
			title : '登录账号',
			width : 100
		}, {
			field : 'storehead',
			title : '真实姓名',
			width : 100
		}, {
            field : 'contactmobile',
            title : '电话号码',
            width : 100
        }, {
            field : 'logintime',
            title : '上次登录时间',
            width : 100
        }, {
            field : 'setuptime',
            title : '创建账号时间',
            width : 100
        }, {
            field : 'shopkeeper',
            title : '角色名称',
            width : 100,
            formatter: shopkeeperFormatter
        }, {

                field: 'operate', title: '权限操作', align: 'center', width: 100,
                formatter: function (value, row, index) {
                    var h = "";
                    h += "<a name='opera' id='emp_tb_edit'  onclick='edit(" + index + ")' ><!--<img src='/Images/update.png' />--></a> ";
                    return h;
                }

        }
		] ],
        onLoadSuccess: function (data) {
            $("a[name='opera']").linkbutton({text: '修改', plain: true, iconCls: 'icon-edit'});

        }
	});
    function shopkeeperFormatter(value, row, index) {

        var name='';
        for (var i = 0; i < row.roles.length; i++) {

              name += row.roles[i].name+',' ;

        }
        return name;
    }


	$("#shopkeeper_dialog").dialog({
		width : 600,
		height : 500,
		buttons : '#shopkeeper_btns',
		closed : true
	});

	$("#allRoles").datagrid({
		width : 240,
		height : 350,
		title : "所有角色",
		url : '/role_listAll.do',
		fitColumns : true,
		columns : [ [ {
			field : 'name',
			title : '角色名称',

			width : 100,
			align : 'center'
		} ] ],
		onDblClickRow : function(rowIndex, rowData) {
			//取消所有的选中后
			$("#selfRoles").datagrid("unselectAll");

			var rows = $("#selfRoles").datagrid("getRows");
			//获取已有权限的所有数据,获取每一行进行对比,看id是否一致
			for (var i = 0; i < rows.length; i++) {
				//如果已经存在已有权限中,就直接选中该数据
				if (rowData.id == rows[i].id) {
					//选中该行数据
					$("#selfRoles").datagrid("selectRow", i);
					return;
				}
			}
			//否则就添加当前行到已有权限中
			$("#selfRoles").datagrid("appendRow", rowData);
		}
	});
	$("#selfRoles").datagrid({
		width : 240,
		height : 350,
		fitColumns : true,
		title : "已有角色",
		columns : [ [ {
			field : 'name',
			title : '角色名称',
			width : 100,
			align : 'center'
		} ] ],
		onDblClickRow : function(rowIndex, rowData) {
			//删除改行数据
			$("#selfRoles").datagrid("deleteRow", rowIndex);
		}
	});

});


function add() {
    // 显示密码输入框
    $("#pwdInput").show();
        //清空已有权限的数据,加载本地数据
        $("#selfRoles").datagrid("loadData",{rows:[]});
        // 清空表单
        $('#shopkeeper_form').form("clear");
        // 打开弹出框
        $("#shopkeeper_dialog").dialog("open");
        // 设置标题
        $("#shopkeeper_dialog").dialog("setTitle", "添加账号");
    }

    // 编辑
     function edit(index) {
        // 判断是否选中数据
         $('#shopkeeper_datagrid').datagrid('selectRow',index);
         // 判断是否选中数据
         var row = $("#shopkeeper_datagrid").datagrid("getSelected");

         // 隐藏密码输入框
         $("#pwdInput").hide();

      /*  if (!row) {
            $.messager.alert('温馨提示', '请选中一条数据!', 'info');
            return;
        }*/

        // 清空表单
        $('#shopkeeper_form').form("clear");

        //获取datagrid的属性对象
        var options = $("#selfRoles").datagrid("options");

        //设置已有权限的url
        options.url = '/getRoleByshopkeeperId.do?shopkeeperId='+row.id;

        //重新加载数据
        $("#selfRoles").datagrid("reload");

        // 回显数据
        $('#shopkeeper_form').form("load", row);

        // 打开弹出框
        $("#shopkeeper_dialog").dialog("open");
        // 设置标题
        $("#shopkeeper_dialog").dialog("setTitle", "设置角色");

    }

    // 取消保存
     function cancel() {
        // 关闭窗口
        $("#shopkeeper_dialog").dialog("close");
    }

    // 保存
    function save() {
        // 判断是否有id
        var url;
        if ($("[name='id']").val()) {
            url = "/shopkeeper_update.do";
        } else {
            url = "/shopkeeper_save1.do";
        }

        // 提交表单
        $('#shopkeeper_form').form('submit', {
            url : url,
            onSubmit : function(param) {
                //获取已有权限的所有数据
                var rows = $("#selfRoles").datagrid("getRows");
                for (var i = 0; i < rows.length; i++) {
                    //添加权限的参数
                    param["roles["+i+"].id"] = rows[i].id;
                }

            },

            success : function(data) {
                // 转成json对象
                data = $.parseJSON(data);
                if (data.success) {
                    $.messager.alert('温馨提示', data.msg, 'info', function() {
                        // 关闭弹出框
                        $("#shopkeeper_dialog").dialog("close");
                        // 刷新数据表格(保持在当前页)
                        $("#shopkeeper_datagrid").datagrid("reload");
                    });
                } else {
                    $.messager.alert('温馨提示', data.msg, 'info');
                }
            }
        });
    }



