$(function () {

    // 初始化数据表格
    $("#emp_datagrid").datagrid({
        url: "/employee_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        toolbar:"#employee_tb",
        columns: [[{
            field: 'sn',
            title: '工号',
            width: 100
        }, {
            field: 'positionName',
            title: '职位',
            width: 100,
            formatter: posFormatter
        }, {
            field: 'username',
            title: '姓名',
            width: 100
        }, {
            field: 'sex',
            title: '性别',
            width: 100,
            formatter:sexFormatter
        }, {
            field: 'phone',
            title: '联系电话',
            width: 100
        }, {
            field: 'inductionTime',
            title: '入职时间',
            width: 100
        }, {
            field: 'departureTime',
            title: '离职时间',
            width: 100
        }, {
            field: 'basicSalary',
            title: '基本工资',
            width: 100

        }, {
            field: 'state',
            title: '状态',
            width: 100,
            formatter: stateFormatter
        }, {
            field: 'admin',
            title: '管理员',
            width: 100,
            formatter: adminFormatter
        }, {
            field: 'operate', title: '操作', align: 'center', width: 100,
            formatter: function (value, row, index) {
                var h = "";
                h += "<a name='opera' id='emp_tb_edit"+index+"'  onclick='edit(" + index + ")' ><!--<img src='/Images/update.png' />--></a> ";
                h += "<a name='oper' id='emp_tb_cs"+index+"' onclick='changeState(" + index + ")'><!--<img src='/Images/delete.png' />--></a> ";
                return h;
            }
        }

        ]],
        onLoadSuccess: function (data) {

            $("a[name='opera']").linkbutton({text: '修改', plain: true, iconCls: 'icon-edit'});
            $("a[name='oper']").linkbutton({text: '离职', plain: true, iconCls: 'icon-remove'});
        },
        onClickRow: function (rowIndex, rowData) {

            // 如果当前行的状态是离职,就禁用编辑和离职按钮
            if (!rowData.state) {

                // 禁用按钮
                $("#emp_tb_edit"+rowIndex).linkbutton('disable');
                $("#emp_tb_cs"+rowIndex).linkbutton('disable');
            } else {

                // 显示按钮
                $("#emp_tb_cs"+rowIndex).linkbutton('enable');
                $("#emp_tb_edit"+rowIndex).linkbutton('enable');
            }
        }
    });

    $("#emp_dialog").dialog({
        width: 600,
        height: 350,
        buttons: '#emp_btns',
        closed: true
    });

    // 部门格式化
    function posFormatter(value, row, index) {
        return value ? value.positionname : "";
    }

    // 获取部门的其他数据,但是field不能设置重复,我们就通过row来获取
    /*
     * function deptFormatter1(value,row,index){ return row.dept?row.dept.id:""; }
     */
    // 状态格式化
    function stateFormatter(value, row, index) {
        return value ? "在职" : "<font color='red'>离职</font>";
    }

    // 是否管理员格式化
    function adminFormatter(value, row, index) {
        return value ? "是" : "否";
    }
    function sexFormatter(value, row, index) {
        return value ? "男" : "女";
    }


});

// 新增
function add() {

    // 清空表单
    $('#emp_form').form("clear");
    // 打开弹出框
    $("#emp_dialog").dialog("open");
    // 设置标题
    $("#emp_dialog").dialog("setTitle", "新增员工");
}

// 编辑
function edit(index) {
    $('#emp_datagrid').datagrid('selectRow',index);
    // 判断是否选中数据
    var row = $("#emp_datagrid").datagrid("getSelected");
    if (!row.state) {
        $.messager.alert('温馨提示', '该员工已离职!', 'info');
        return;
    }


    // 清空表单
    $('#emp_form').form("clear");

    // 是否管理员下拉框回显处理,设置为字符串类型

        row["sex"] = row["sex"] + "";


    // 部门下拉框处理(同名匹配原则)
    if (row["positionName"]) {
        row["positionName.id"] = row["positionName"].id;
    }



    // 回显数据
    $('#emp_form').form("load", row);

    // 打开弹出框
    $("#emp_dialog").dialog("open");
    // 设置标题
    $("#emp_dialog").dialog("setTitle", "编辑员工");

}


// 取消保存
function cancel() {
    // 关闭窗口
    $("#emp_dialog").dialog("close");
}


// 保存
 function save() {
    // 判断是否有id
    var url;
    if ($("[name='id']").val()) {
        url = "/employee_update.do";
    } else {
        url = "/employee_save.do";
    }

    // 提交表单
     $('#emp_form').form('submit', {
         url : url,
         success : function (data) {
             // 转成json对象
             data = $.parseJSON(data);
             if (data.success) {
                 $.messager.alert('温馨提示', data.msg, 'info', function () {
                     // 关闭弹出框
                     $("#emp_dialog").dialog("close");
                     // 刷新数据表格(保持在当前页)
                     $("#emp_datagrid").datagrid("reload");
                 });
             } else {
                 $.messager.alert('温馨提示', data.msg, 'info');
             }
         }
     });
}


// 设置为离职
  function  changeState(index) {
      $('#emp_datagrid').datagrid('selectRow',index);
    // 判断是否选中数据
    var row = $("#emp_datagrid").datagrid("getSelected");
    if (!row.state){
        $.messager.alert('温馨提示', '该员工已离职!', 'info');
        return;
    }

    // 弹出确认框
    $.messager.confirm('确认对话框', '您想要设置该员工为离职吗？', function (r) {
        if (r) {
            $.post("/employee_changeState.do", {
                id: row.id
            }, function (data) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 刷新数据表格(保持在当前页)
                    $("#emp_datagrid").datagrid("reload");
                });
            })
        }
    });

}


// 高级查询
  function searchForm() {
    // 获取关键字文本框的值
    var sn = $("[name='sn']").val();
    var username = $("[name='username']").val();

    $("#emp_datagrid").datagrid('load', {
        sn: sn,
        username:username
    });
}


// 查询全部数据
function reload() {
    // 清空查询条件的内容
    $("[name='sn']").val('');
    $("[name='username']").val('');

    $("#emp_datagrid").datagrid('load', {});
}

//导出文件
/*
exportFile:function () {
    window.location.href = "/employee_export.do";
}
*/
$(function() {
    //扩展easyui表单的验证
    $.extend($.fn.validatebox.defaults.rules, {
        //移动手机号码验证
        mobile: {//value值为文本框中的值
            validator: function (value) {
                var reg = /^1[3|4|5|8|9]\d{9}$/;
                return reg.test(value);
            },
            message: '输入手机号码格式不准确.'
        },
        idcard : {// 验证身份证
            validator : function(value) {
                return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value) || /^\d{18}(\d{2}[A-Za-z0-9])?$/i.test(value);
            },
            message : '身份证号码格式不正确'
        }
    });
});