$(function () {
    $("#petkindandcategory_datagrid").datagrid({
        url: "/petkindandcategory_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        rownumbers:true,
        toolbar:"#petkindandcategory_toolbar",
        columns:[[
            {field:'petcategory',title:'宠物类别',width:100,align:'center'},
            {field:'petkind',title:'宠物名称',width:100,align:'center'},
            {field:'state',title:'是否启用',width:100,align:'center',formatter:stateFormatter},
            {field:'operate',title:'操作',width:100,align:'center',
                formatter:function (value,row,index) {
                    return "<a name='opera' id='petkindandcategory_tb_edit' onclick='edit()'></a> "+
                    "<a name='oper' id='petkindandcategory_tb_cs' onclick='dlt()'></a> ";
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
    $("#petkindandcategory_dialog").dialog({
        width:300,
        height:220,
        closed:true,
        buttons:"#petkindandcategory_buttons"
    })
});


function add() {
    //清空表单
    $("#editForm").form("clear");
    //打开弹出框
    $("#petkindandcategory_dialog").dialog("open");
    //设置标题
    $("#petkindandcategory_dialog").dialog("setTitle","新增品牌");
}
//编辑
function edit() {
    //判断是否选中数据
    var row = $("#petkindandcategory_datagrid").datagrid("getSelected");
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
    $("#petkindandcategory_dialog").dialog("open");
    //设置标题
    $("#petkindandcategory_dialog").dialog("setTitle","编辑");
}
//删除
function dlt() {
    //判断是否选中数据
    var row = $("#petkindandcategory_datagrid").datagrid("getSelected");
    if (!row) {
        $.messager.alert('提示','请选择要删除的数据','info');
        return;
    }
    $.messager.confirm('提示','确定删除该数据吗',function (r) {
        if (r) {
            $.post("/petkindandcategory_delete.do",{id:row.id},function (data) {
                if (data.success) {
                    $.messager.alert("温馨提示",data.msg,"info")
                    //关闭弹出框
                    $("#petkindandcategory_dialog").dialog("close");
                    //刷新页面
                    $("#petkindandcategory_datagrid").datagrid("reload");
                }
            })
        }
    })
}

function save() {
    var url;
    //判断是否存在id
    if ($("[name='id']").val()) {
        url = "/petkindandcategory_update.do";
    } else {
        url = "/petkindandcategory_save.do";
    }
    //提交表单
    $("#editForm").form("submit",{
        url:url,
        success:function (data) {
            data=$.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示",data.msg,"info")
                //关闭弹出框
                $("#petkindandcategory_dialog").dialog("close");
                //刷新页面
                $("#petkindandcategory_datagrid").datagrid("reload");
            }
        }
    })
}

function cancel() {
    $("#petkindandcategory_dialog").dialog("close");
}

//查询
function searchForm(){
    //获取参数
    var keyword = $("[name='keyword']").val();
    $("#petkindandcategory_datagrid").datagrid("load",{
        keyword:keyword
    })
}

//查询所有
function selectall() {
    $("[name='keyword']").val('');

    $("#petkindandcategory_datagrid").datagrid('load', {});
}