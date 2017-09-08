$(function () {
    $("#systemlog_datagrid").datagrid({
        url: "/systemlog_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        rownumbers:true,
        toolbar:"#systemlog_toolbar",
        columns:[[
            {field:'opuser',title:'操作用户',width:100,align:'center',formatter:opuserFormatter},
            {field:'optime',title:'操作时间',width:100,align:'center'},
            {field:'opip',title:'登录IP',width:100,align:'center'},
            {field:'function',title:'使用功能',width:200,align:'center'},
            {field:'params',title:'操作参数信息',width:100,align:'center'}
            //{field:'state',title:'是否启用',width:100,align:'center',formatter:stateFormatter},
        ]]
    });
    function opuserFormatter(value,row,index) {
        return value?value.username:'';
    }

    function stateFormatter(value,row,index) {
        return value?"是":"<font color='red'>否</font>";
    }

});





//查询
function searchForm(){
    //获取参数
    var keyword = $("[name='keyword']").val();
    $("#systemlog_datagrid").datagrid("load",{
        keyword:keyword
    })
}

//查询所有
function selectall() {
    $("[name='keyword']").val('');

    $("#systemlog_datagrid").datagrid('load', {});
}