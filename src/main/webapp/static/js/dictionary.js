$(function () {
    $("#dictionary_datagrid").datagrid({
        url:"/dictionary_list.do",
        fit:true,
        fitColumns:true,
        singleSelect:true,
        toolbar:"#dictionaryTools",
        columns:[[
            {field:'sn',title:'字典编号',width:100,align:'center'},
            {field:'name',title:'字典名称',width:100,align:'center'},
            {field:'intro',title:'字典简介',width:120,align:'center'}
        ]],
        onClickRow:function(rowIndex, rowData) {
            $("#dictionaryItem_datagrid").datagrid("load", {
                "pid": rowData.id
            });
        }
    });


    $("#dictionaryItem_datagrid").datagrid({
        url:"/dictionaryItem_list.do",
        fit:true,
        singleSelect:true,
        toolbar:"#dictionaryItemTools",
        fitColumns:true,
        columns:[[
            {field:'sn',title:'字典明细编码',width:100,align:'center'},
            {field:'name',title:'字典明细名称',width:100,align:'center'},
            {field:'intro',title:'字典明细简介',width:100,align:'center'},
            {field:'parent.name',title:'字典目录',width:100,align:'center',formatter: parentFormatter}
        ]]
    });
    function parentFormatter(value, row, index) {
        return row.dictionary?row.dictionary.name:"";
    }



    $("#mydialog").dialog({
        width : 300,
        height : 300,
        top : 100,
        resizable : true,
        closed : true,
        buttons : "#dialogbutton"
    });
    $("#dialogItem").dialog({
        width : 300,
        height : 300,
        top : 100,
        resizable : true,
        closed : true,
        buttons :"#dialogbuttonItem"
    });




    $("a[data-cmd]").on("click",function(){
        var cmd = $(this).data("cmd");

        if(cmd){
            cmdObj[cmd]();
        }
    });



    var cmdObj={
        cancel:function(){
            $("#mydialog").dialog("close");
        },
        add :function () {
            $("#mydialog").dialog("open");
            $("#mydialog").dialog("setTitle","字典目录新增");
            $("#myform").form("clear");
        },
        edit:function () {
            var row = $("#dictionary_datagrid").datagrid("getSelected");
            if (!row){
                $.messager.alert('温馨提示', '请选择一行数据!', 'info');
                return;
            }
            $("#myform").form("clear");
            $("#myform").form("load",row);
            $("#mydialog").dialog("open");
            $("#mydialog").dialog("setTitle","字典目录编辑");
        },
        fresh:function () {
            $("#dictionary_datagrid").datagrid("reload");
        },
        save:function () {
            var url;
            if ($("[name='id']").val()) {
                url = "/dictionary_update.do";
            } else {
                url = "/dictionary_save.do";
            }
            $('#myform').form('submit', {
                url:url,
                success: function (data) {
                    // 转成json对象
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert('温馨提示', data.msg, 'info', function () {
                            // 关闭弹出框
                            $("#mydialog").dialog("close");
                            // 刷新数据表格(保持在当前页)
                            $("#dictionary_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert('温馨提示', data.msg, 'info');
                    }
                }
            })
        },

        itemcancel : function(){
            $("#dialogItem").dialog("close");
        },
        Itemadd : function(){
            var row = $("#dictionary_datagrid").datagrid("getSelected");
            if (!row){
                $.messager.alert('温馨提示', '请在左侧选择一行数据!', 'info');
                return;
            }
            $("#itemForm").form("clear");
            $("#dialogItem").dialog("open");
            $("#dialogItem").dialog("setTitle","新增字典目录明细");
            $("input[name='dictionary.name']").val(row.name);
            $("input[name='dictionary.id']").val(row.id);
        },
        itemedit:function(){
            var row = $("#dictionaryItem_datagrid").datagrid("getSelected");
            console.log(row);
            if(!row){
                $.messager.alert("提示消息", "请选择一行数据", "info");
                return;
            }
            $("#dialogItem").dialog("open");
            $("#dialogItem").dialog("setTitle", "编辑字典目录明细");
            $("#itemForm").form("load",row);
            $("input[name='dictionary.name']").val(row.dictionary.name);
           /* $("input[name='dictionary.id']").val(row.dictionary.id);*/

        },
        itemfresh:function(){
            $("#dictionaryItem_datagrid").datagrid("reload");
        },
        itemSave:function () {
            var url;
            console.log($("[name='id']").val()+"------------------");
            if ($("[name='id']" && $("#item") ).val()) {
                url = "/dictionaryItem_update.do";
            } else {
                url = "/dictionaryItem_save.do";
            }
            $('#itemForm').form('submit', {
               url:url,
                success: function (data) {
                    // 转成json对象
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert('温馨提示', data.msg, 'info', function () {
                            // 关闭弹出框
                            $("#dialogItem").dialog("close");
                            // 刷新数据表格(保持在当前页)
                            $("#dictionaryItem_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert('温馨提示', data.msg, 'info');
                    }
                }
            });
        },
        itemremove :function () {
            var row = $("#dictionaryItem_datagrid").datagrid("getSelected");
            if (!row){
                $.messager.alert('温馨提示', '请在左侧选择一行数据!', 'info');
            }
                $.messager.confirm("确认", "确定要删除这个明细吗?", function(r) {
                    if(r){
                        $.get("dictionaryItem_delete.do?delId="+row.id,function(data){
                            if(data.success){
                                $.messager.alert("提示消息", data.msg, "info");
                                $("#dialogItem").dialog("close");
                                $("#dictionaryItem_datagrid").datagrid("reload");
                            }else{
                                $.messager.alert("提示消息", data.msg, "info");
                            }
                        });
                    }
                })
        }

    }

});
