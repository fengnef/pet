$(function(){
    // 初始化数据表格
    $("#leaver_datagrid").datagrid({
        url: "/leaver_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        toolbar:"#leaver_tb",
        columns: [[{
            field: 'employee.sn',
            title: '工号',
            width: 70,
            formatter:snFormatter
        },  {
            field: 'employee.username',
            title: '姓名',
            width: 70,
            formatter:usernameFormatter
        }, {
            field: 'leaveClass',
            title: '请假类别',
            width: 50,
            formatter:leaveFormatter
        }, {
            field: 'leavefor',
            title: '请假事由',
            width: 150
        }, {
            field: 'leaveTimes',
            title: '请假开始时间',
            width: 80
        }, {
            field: 'leaveTimed',
            title: '请假结束时间',
            width: 80
        }, {
            field: 'leaveDuration',
            title: '请假时长(天)',
            width: 50

        }, {
            field: 'leaderShipoption',
            title: '领导意见',
            width: 150

        }, {
            field: 'isLeave',
            title: '是否正常请假',
            width: 70,
            formatter: isLeaveFormatter
        }, {
            field: 'state',
            title: '状态',
            width: 50,
            formatter: stateFormatter
        },{
            field: 'reason',
            title: '取消原因',
            width: 150

        }, {
            field: 'operate', title: '操作', align: 'center', width: 100,
            formatter: function (value, row, index) {

                var h = "";
                if (row.state){
                    h += "<a name='opera' id='emp_tb_edit"+index+"'  onclick='edit(" + index + ")' ><!--<img src='/Images/update.png' />--></a> ";
                }else {
                    h = "<font color='red'>已取消</font>"
                }
                return h;
            }
        }
        ]],
        onLoadSuccess: function (data) {
            $("a[name='opera']").linkbutton({text: '取消', plain: true, iconCls: 'icon-edit'});
        }
       /* onClickRow: function (rowIndex, rowData) {

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
        }*/
    });

    $("#leaver_dialog").dialog({
        width: 600,
        height: 450,
        buttons: '#leaver_btns',
        closed: true
    });
    $("#reason_dialog").dialog({
        width: 300,
        height: 200,
        buttons: '#reason_btns',
        closed: true
    });




    // 状态格式化
    function stateFormatter(value, row, index) {
        return value ? "请假" : "已取消";
    }
    // 是否正常格式化
    function isLeaveFormatter(value, row, index) {
        return value ? "请假" : "<font color='red'>旷工</font>";
    }
    //员工格式化
    function usernameFormatter(value, row, index) {
        return row.employee?row.employee.username:""
    }
    function snFormatter(value, row, index) {
        return row.employee?row.employee.sn:""
    }

    function leaveFormatter(value, row, index) {
        return value ? value.name : "";
    }

});

// 新增
function add() {

    // 清空表单
    $('#leaver_form').form("clear");
    // 打开弹出框
    $("#leaver_dialog").dialog("open");
    // 设置标题
    $("#leaver_dialog").dialog("setTitle", "新增记录");
}




// 取消保存
function cancel() {
    // 关闭窗口
    $("#leaver_dialog").dialog("close");
}

function edit(index){

    $('#leaver_datagrid').datagrid('selectRow',index);
    var row = $("#leaver_datagrid").datagrid("getSelected");
    // 清空表单
    $('#reason_form').form("clear");

    $('#reason_form').form("load", row);

    // 打开弹出框
    $("#reason_dialog").dialog("open");
    // 设置标题
    $("#reason_dialog").dialog("setTitle", "请输入取消原因");
}

function cancel1() {
    // 关闭窗口
    $("#reason_dialog").dialog("close");
}
function save1(){
    var url = "/leaver_update.do";

    $('#reason_form').form('submit', {
        url: url,
        success: function (data) {
            // 转成json对象
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#reason_dialog").dialog("close");
                    // 刷新数据表格(保持在当前页)
                    $("#leaver_datagrid").datagrid("reload");
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }
    });
}

// 保存
function save() {

    var   url = "/leaver_save.do";
    // 提交表单
    $('#leaver_form').form('submit', {
        url: url,

        success: function (data) {
            // 转成json对象
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#leaver_dialog").dialog("close");
                    // 刷新数据表格(保持在当前页)
                    $("#leaver_datagrid").datagrid("reload");
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }
    });
}
// 高级查询
function searchForm() {
    // 获取关键字文本框的值
    var sn = $("[name='sn']").val();
    var username = $("[name='username']").val();

    $("#leaver_datagrid").datagrid('load', {
        sn: sn,
        username:username
    });
}


// 查询全部数据
function reload() {
    // 清空查询条件的内容
    $("[name='sn']").val('');
    $("[name='username']").val('');

    $("#leaver_datagrid").datagrid('load', {});
}
