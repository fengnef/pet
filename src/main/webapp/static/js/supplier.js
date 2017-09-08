$(function () {
    $("#supplier_datagrid").datagrid({
        url: "/supplier_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        rownumbers:true,
        toolbar:"#supplier_toolbar",
        columns:[[
            {field:'name',title:'名称',width:100,align:'center'},
            {field:'linkman',title:'联系人',width:100,align:'center'},
            {field:'tel',title:'联系电话',width:100,align:'center'},
            {field:'good',title:'主供商品',width:100,align:'center'},
            {field:'cooperationtime',title:'合作时长(天)',width:100,align:'center'},
            {field:'advantage',title:'优势',width:100,align:'center'},
            {field:'operate',title:'操作',width:100,align:'center',
                formatter:function (value,row,index) {
                    return "<a name='opera' id='supplier_tb_edit' onclick='edit()'></a> "+
                    "<a name='oper' id='supplier_tb_cs' onclick='dlt()'></a> ";
            }}
        ]],onLoadSuccess:function (data) {
            $("a[name='opera']").linkbutton({text: '编辑', plain: true, iconCls: 'icon-edit'});
            $("a[name='oper']").linkbutton({text: '删除', plain: true, iconCls: 'icon-remove'});
        }
    });

    function stateFormatter(value,row,index) {
        return value?"是":"<font color='red'>否</font>";
    }

    //编辑增加页面
    $("#supplier_dialog").dialog({
        width:300,
        height:200,
        closed:true,
        buttons:"#supplier_buttons"
    })
});


function add() {
    //清空表单
    $("#editForm").form("clear");
    //打开弹出框
    $("#supplier_dialog").dialog("open");
    //设置标题
    $("#supplier_dialog").dialog("setTitle","新增品牌");
}
//编辑
function edit() {
    //判断是否选中数据
    var row = $("#supplier_datagrid").datagrid("getSelected");
    if (!row) {
        $.messager.alert('提示','请选择一条数据','info');
        return;
    }
    //清空表单
    $("#editForm").form("clear");
    //是否启用的回显的格式化
    row["state"]=row["state"]+"";
    //回显数据
    $("#editForm").form("load",row);
    //打开弹出框
    $("#supplier_dialog").dialog("open");
    //设置标题
    $("#supplier_dialog").dialog("setTitle","编辑");
}
//删除
function dlt() {
    //判断是否选中数据
    var row = $("#supplier_datagrid").datagrid("getSelected");
    if (!row) {
        $.messager.alert('提示','请选择要删除的数据','info');
        return;
    }
    $.messager.confirm('提示','确定删除该数据吗',function (r) {
        if (r) {
            $.post("/supplier_delete.do",{id:row.id},function (data) {
                if (data.success) {
                    $.messager.alert("温馨提示",data.msg,"info")
                    //关闭弹出框
                    $("#supplier_dialog").dialog("close");
                    //刷新页面
                    $("#supplier_datagrid").datagrid("reload");
                }
            })
        }
    })
}

function save() {
    var url;
    //判断是否存在id
    if ($("[name='id']").val()) {
        url = "/supplier_update.do";
    } else {
        url = "/supplier_save.do";
    }
    //提交表单
    $("#editForm").form("submit",{
        url:url,
        success:function (data) {
            data=$.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示",data.msg,"info")
                //关闭弹出框
                $("#supplier_dialog").dialog("close");
                //刷新页面
                $("#supplier_datagrid").datagrid("reload");
            }
        }
    })
}

function cancel() {
    $("#supplier_dialog").dialog("close");
}

//查询
function searchForm(){
    //获取参数
    var keyword = $("[name='keyword']").val();
    $("#supplier_datagrid").datagrid("load",{
        keyword:keyword
    })
}

//查询所有
function selectall() {
    $("[name='keyword']").val('');

    $("#supplier_datagrid").datagrid('load', {});
}