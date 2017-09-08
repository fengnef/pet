$(function () {
    console.debug("==========fgsdgsdghsh==========");
    // 抽取变量
    var stockOutcomeBill_datagrid = $("#stockOutcomeBill_datagrid");
    // 初始化数据表格
    stockOutcomeBill_datagrid.datagrid({
        url: "/stockOutcomeBill_list.do",
        fitColumns: true,
        striped: true,
        pagination: true,
        singleSelect: true,
        toolbar: '#stockOutcomeBill_tb',
        columns: [[{
            field: 'productSn',
            title: '商品69条码',
            width: 100
        }, {
            field: 'sn',
            title: '库存编码',
            width: 100
        }, {
            field: 'productName',
            title: '商品名称',
            width: 100
        }, {
            field: 'inputtime',
            title: '录入时间',
            width: 120
        }, {
            field: 'productCategory',
            title: '商品类别',
            width: 100
        }, {
            field: 'productSpecification',
            title: '规格',
            width: 100,
        }, {
            field: 'costPrice',
            title: '出货单价',
            width: 100,
        }, {
            field: 'count',
            title: '出货数量',
            width: 100,
        }, {
            field: 'totalamount',
            title: '出货总价',
            width: 100,
        }, {
            field: 'subStore',
            title: '入货商店',
            width: 100,
        }, {
            field: 'saleprice',
            title: '标价',
            width: 100,
        }, {
            field: 'discount',
            title: '会员价格',
            width: 100,
        }, {
            field: 'productDate',
            title: '生产日期',
            width: 120,
        }, {
            field: 'productDate',
            title: '保质期',
            width: 120,
        }
        ]],

    });

    //设置填写规则
    $("[name='productSn']").validatebox({
        required: true,
        message: "必填字段"
    });
    $("[name='costPrice']").validatebox({
        required: true,
        message: "必填字段"
    });
    $("[name='count']").validatebox({
        required: true,
        message: "必填字段"
    });
    $("[name='saleprice']").validatebox({
        required: true,
        message: "必填字段"
    });

    //获取商品类型数据
    $('#productCategory').combobox({
        url: '/orderBill_getProductCategory.do',
        valueField: 'category',
        textField: 'category',
        panelHeight: 'auto'
    });
    //获取商品品牌
    $('#productBrand').combobox({
        url: '/orderBill_getBrand.do',
        valueField: 'brandname',
        textField: 'brandname',
        panelHeight: 'auto'
    });
})

// 删除一条数据
function removeStockOutcomeBill() {
    var row = $("#stockOutcomeBill_datagrid").datagrid("getSelected");
    $.post("/stockOutcomeBill_remove.do", {
        id: row.id
    }, function (data) {
        $.messager.alert('温馨提示', data.msg, 'info', function () {
            // 刷新数据表格(保持在当前页)
            $("#stockOutcomeBill_datagrid").datagrid("reload");
        });

    })

}

// 新增一条数据
function add() {
    // 判断是否有id
    var url;
    if ($("[name='id']").val()) {
        url = "/stockOutcomeBill_update.do";
    } else {
        url = "/stockOutcomeBill_save.do";
    }
    $('#ff').form('submit', {
        url: url,
        onSubmit: function () {
        },
        success: function (data) {
            data = $.parseJSON(data);
            $.messager.alert('温馨提示', data.msg, 'info', function () {
                $('#ff').form("clear");
                // 刷新数据表格(保持在当前页)
                $("#stockOutcomeBill_datagrid").datagrid("reload");
            });
        }
    });

}


//全部出库
function AllOutStock() {

    var rows = $("#stockOutcomeBill_datagrid").datagrid("getRows");
    //定义一数组
    var myarray = [];
    console.debug(rows);
    //将所有对象数据的id迭代到数组中
    for (var i = 0; i < rows.length; i++) {
        myarray[i] = rows[i].id;
    }
    console.debug(myarray);
    $.post("/stockOutcomeBillItem_saveAll.do", {
        stockOutcomeBills: myarray
    }, function (data) {

        $.messager.alert('温馨提示', data.msg, 'info', function () {
            // 刷新数据表格(保持在当前页)
            $("#stockOutcomeBill_datagrid").datagrid("reload");
        });
    })

}

// 编辑一条数据
function editStockOutcomeBill() {
    //清空表单数据
    $('#ff').form("clear");
    //数据回显
    var row = $("#stockOutcomeBill_datagrid").datagrid("getSelected");
    console.debug(row);

    $('#ff').form("load", row);
}


//商品69码填写完毕之后会显库存的数据
function changeProduct() {

    var productSn = $("[name='productSn']").val();
    console.debug("========changeProduct1==========");
    $.post("/stockOutcomeBill_getStockByProductSn.do", {productSn: productSn},
        function (data) {
            console.debug(data);
            // $("[name='sn']").val(data.sn);
            // $("[name='productName']").val(data["product"].name);
            // $("#productCategory").combobox('setValue', data.productCategory);
            // $("#productBrand").combobox('setValue', data.productBrand);
            data["productName"] = data["product"].name;
            console.debug(data);
            data.id = '';
            $('#ff').form("load", data);
        });
};

//刷新,清空表单用
function reloadBill() {
    console.debug("========reloadBill==========");
    //清空表单数据
    $('#ff').form("clear");
    //表格加载全部
    $("#stockOutcomeBill_datagrid").datagrid("load");
};
