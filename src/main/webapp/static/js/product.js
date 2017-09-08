$(function () {
    $("#product_datagrid").datagrid({
        url: "/product_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        rownumbers:true,
        toolbar:"#product_toolbar",
        columns:[[
            {field:'sn',title:'商品69码',width:100,align:'center'},
            {field:'name',title:'名称',width:100,align:'center'},
            {field:'productcategory',title:'类别',width:100,align:'center',formatter:pcFormatter},
            {field:'brand',title:'品牌',width:100,align:'center',formatter:brandFormatter},
            {field:'manufacturer',title:'产地',width:100,align:'center',formatter:manuFormatter},
            {field:'productpomponent',title:'成分',width:100,align:'center',formatter:pomFormatter},
            {field:'allergens',title:'过敏物',width:100,align:'center'},
            {field:'saleprice',title:'售价',width:100,align:'center'},
            {field:'state',title:'是否启用',width:100,align:'center',formatter:stateFormatter},
            {field:'operate',title:'操作',width:100,align:'center',
                formatter:function (value,row,index) {
                    return "<a name='opera' id='emp_tb_edit' onclick='edit()'></a> "+
                    "<a name='oper' id='emp_tb_dlt' onclick='dlt()'></a> ";
            }}
        ]],onLoadSuccess:function (data) {
            $("a[name='opera']").linkbutton({text: '编辑', plain: true, iconCls: 'icon-edit'});
            $("a[name='oper']").linkbutton({text: '删除', plain: true, iconCls: 'icon-remove'});
        }

    });

    //类别数据格式化
    function pcFormatter(value,row,index) {
        return value?value.category:'';
    }
    //品牌数据格式化
    function brandFormatter(value,row,index) {
        return value?value.brandname:'';
    }
    //产地数据格式化
    function manuFormatter(value,row,index) {
        return value?value.productoriginname:'';
    }
    //成分数据格式化
    function pomFormatter(value,row,index) {
        return value?value.pomponentname:'';
    }
    //状态格式化
    function stateFormatter(value,row,index) {
        return value?"正常":"<font color='red'>异常</font>";
    }


    //编辑增加页面
    $("#product_dialog").dialog({
        width:350,
        height:400,
        closed:true,
        buttons:"#product_buttons"
    })
});


function add() {
    //清空表单
    $("#editForm").form("clear");
    //打开弹出框
    $("#product_dialog").dialog("open");
    //设置标题
    $("#product_dialog").dialog("setTitle","新增品牌");
}
//编辑
function edit() {
    //判断是否选中数据
    var row = $("#product_datagrid").datagrid("getSelected");
    if (!row) {
        $.messager.alert('提示','请选择一条数据','info');
        return;
    }
    //清空表单
    $("#editForm").form("clear");
    //是否启用的回显的格式化
    row["state"]=row["state"]+"";
    row["productcategory.id"]=row["productcategory"].id;
    row["brand.id"] = row.brand.id;
    row["manufacturer.id"] = row.manufacturer.id;
    row["productpomponent.id"] = row.productpomponent.id;
    //回显数据
    $("#editForm").form("load",row);
    //打开弹出框
    $("#product_dialog").dialog("open");
    //设置标题
    $("#product_dialog").dialog("setTitle","编辑");
}
//删除
function dlt() {
    //判断是否选中数据
    var row = $("#product_datagrid").datagrid("getSelected");
    if (!row) {
        $.messager.alert('提示','请选择要删除的数据','info');
        return;
    }
    $.messager.confirm('提示','确定删除该数据吗',function (r) {
        if (r) {
            $.post("/product_delete.do",{id:row.id},function (data) {
                if (data.success) {
                    $.messager.alert("温馨提示",data.msg,"info")
                    //关闭弹出框
                    $("#product_dialog").dialog("close");
                    //刷新页面
                    $("#product_datagrid").datagrid("reload");
                }
            })
        }
    })

}

function save() {
    var url;
    //判断是否存在id
    if ($("[name='id']").val()) {
        url = "/product_update.do";
    } else {
        url = "/product_save.do";
    }
    //提交表单
    $("#editForm").form("submit",{
        url:url,
        /*onSubmit:function (param) {
            //获取下拉框的值
            var category = $("#productcategory_combobox").combobox("getValue");
            param["productcategory.id"]=category;
            var brand = $("#brand_combobox").combobox("getValue");
            param["brand.id"]=brand;
            var manufacturer = $("#manufacturer_combobox").combobox("getValue");
            param["manufacturer.id"]=manufacturer;
            var pomponent = $("#pomponent_combobox").combobox("getValue");
            param["productpomponent.id"]=pomponent;
        },*/
        success:function (data) {
            data=$.parseJSON(data);
            if (data.success) {
                $.messager.alert("温馨提示",data.msg,"info")
                //关闭弹出框
                $("#product_dialog").dialog("close");
                //刷新页面
                $("#product_datagrid").datagrid("reload");
            }
        }
    })
}

function cancel() {
    $("#product_dialog").dialog("close");
}

//查询
function searchForm(){
    //获取参数
    var productName = $("[name='productName']").val();
    var categoryId = $("#category_combobox").combobox("getValue");
    var brandId = $("#bd_combobox").combobox("getValue");
    var pomponent = $("[name='pomponent']").val();
    $("#product_datagrid").datagrid("load",{
        productName:productName,
        categoryId:categoryId,
        brandId:brandId,
        pomponent:pomponent
    })
}

////查询所有
function selectall() {
    $("[name='productName']").val('');
    $("#category_combobox").combobox("setValue",'');
    $("#bd_combobox").combobox("setValue",'');
    $("[name='pomponent']").val('');
    $("#product_datagrid").datagrid('load', {});
}