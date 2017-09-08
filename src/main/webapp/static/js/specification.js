$(function () {
    $("#spec_datagrid").datagrid({
        url: "/specification_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        rownumbers:true,
        toolbar:"#spec_toolbar",
        columns:[[
            {field:'name',title:'商品规格',width:100,align:'center'},
            {field:'state',title:'是否启用',width:100,align:'center',formatter:stateFormatter}
        ]]
    });

    function stateFormatter(value,row,index) {
        return value?"是":"<font color='red'>否</font>";
    }

    //编辑增加页面
    $("#spec_dialog").dialog({
        width:300,
        height:200,
        closed:true,
        buttons:"#spec_buttons"
    })
});


function add() {
    //清空表单
    $("#editForm").form("clear");
    //打开弹出框
    $("#spec_dialog").dialog("open");
    //设置标题
    $("#spec_dialog").dialog("setTitle","新增品牌");
}

function save() {
    var url;
    //判断是否存在id
    if ($("[name='id']").val()) {
        url = "/specification_update.do";
    } else {
        url = "/specification_save.do";
    }
    //提交表单
    $("#editForm").form("submit",{
        url:url,
        success:function (data) {
            data=$.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示",data.msg,"info")
                //关闭弹出框
                $("#spec_dialog").dialog("close");
                //刷新页面
                $("#spec_datagrid").datagrid("reload");
            }
        }
    })
}

function cancel() {
    $("#spec_dialog").dialog("close");
}

//查询
function searchForm(){
    //获取参数
    var keyword = $("[name='keyword']").val();
    $("#spec_datagrid").datagrid("load",{
        keyword:keyword
    })
}

//查询所有
function selectall() {
    $("[name='keyword']").val('');

    $("#spec_datagrid").datagrid('load', {});
}