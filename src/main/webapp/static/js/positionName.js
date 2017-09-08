$(function(){
    $("#posi_datagrid").datagrid({
        url : "/positionName_list.do",
        fit : true,
        fitColumns : true,
        striped : true,
        pagination : true,
        singleSelect : true,
        toolbar:"#positionname_tb",
        columns : [ [
            {
                field : 'positionname',
                title : '职位名称',
                width : 100
            },
            {
                field : 'postallowance',
                title : '岗位津贴',
                width : 100
            },
            {
                field : 'trafficsubsidies',
                title : '交通补贴',
                width : 100
            },
            {
                field : 'phonesubsidies',
                title : '话费补贴',
                width : 100
            },
            {
                field : 'subsidizedmeals',
                title : '餐补',
                width : 100
            },
            {
                field : 'fulltime',
                title : '全勤',
                width : 100
            },
            {
                field : 'commission',
                title : '提成比例(%)',
                width : 100
            },
            {field:'operate',title:'操作',align:'center',width:100,
                formatter:function(value, row, index){
                    var h = "";
                    h += "<a name='opera'  onclick='edit("+index +")' ><!--<img src='/Images/update.png' />--></a> ";
                    h += "<a name='opera1'  onclick='del("+index +")'><!--<img src='/Images/delete.png' />--></a> ";
                    return h;
                }}
        ]],
        onLoadSuccess:function(data){
            $("a[name='opera']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
            $("a[name='opera1']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
        }
    });
    $("#positionName_dialog").dialog({
        width : 300,
        height : 350,
        buttons : '#positionName_btns',
        closed : true
    });


});

function add() {
    // 清空表单
    $("#positionName_form").form("reset");
    $("#positionName_form").form("clear");
    // 打开弹出框
    $("#positionName_dialog").dialog("open");
    // 设置标题
    $("#positionName_dialog").dialog("setTitle", "添加职位");
}
 function cancel() {
    // 关闭窗口
    $("#positionName_dialog").dialog("close");
}

function save() {
    // 判断是否有id
    var url;
    if ($("[name='id']").val()) {
        url = "/positionName_update.do";
    } else {
        url = "/positionName_save.do";
    }
    // 提交表单
    $("#positionName_form").form('submit', {
        url : url,
        success : function(data) {
            // 转成json对象
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function() {
                    // 关闭弹出框
                    $("#positionName_dialog").dialog("close");
                    // 刷新数据表格(保持在当前页)
                    $("#posi_datagrid").datagrid("reload");
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }
    });
}



function edit(index) {
    $('#posi_datagrid').datagrid('selectRow',index);
    var row = $('#posi_datagrid').datagrid('getSelected');
    if (row){
        // 清空表单
        $("#positionName_form").form("clear");
        // 回显数据
        $("#positionName_form").form("load", row);
        // 打开弹出框
        $("#positionName_dialog").dialog("open");
        // 设置标题
        $("#positionName_dialog").dialog("setTitle", "编辑职位");
    }
}
function del(index) {
    $('#posi_datagrid').datagrid('selectRow',index);
    var row = $('#posi_datagrid').datagrid('getSelected');
    if (row){
        // 弹出确认框
        $.messager.confirm('确认对话框', '您确定删除该行吗？', function(r) {
            if (r) {
                $.post("/positionName_delete.do", {
                    id : row.id
                }, function(data) {
                    $.messager.alert('温馨提示', data.msg, 'info', function() {
                        // 刷新数据表格(保持在当前页)
                        $('#posi_datagrid').datagrid("reload");
                    });
                })
            }
        });
    }

}
