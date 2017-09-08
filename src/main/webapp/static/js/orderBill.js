$(function () {
    console.debug("==========fgsdgsdghsh==========");
    // 抽取变量
    var orderBill_datagrid = $("#orderBill_datagrid");
    // 初始化数据表格
    orderBill_datagrid.datagrid({
        url: "/orderBill_list.do",
        fitColumns: true,
        striped: true,
        pagination: true,
        singleSelect: true,
        toolbar: '#orderBill_tb',
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
            title: '商品规格',
            width: 100,
        }, {
            field: 'costPrice',
            title: '进货单价',
            width: 100,
        }, {
            field: 'count',
            title: '进货数量',
            width: 100,
        }, {
            field: 'totalamount',
            title: '进货总价',
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
            width: 100,
        },
            {
                field: 'warrantyDate',
                title: '保质期',
                width: 100,
            }
        ]],

    });
    getUUID();

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

//获取产品的名称列表
// $("[name='productName']").combobox({
//     url: '/orderBill_productNameList.do',
//     valueField: 'name',
//     textField: 'name',
//     panelHeight: 'auto'
// });
//获取产品的69条码列表
// $("[name='productSn']").combobox({
//     url: '/orderBill_productNameList.do',
//     valueField: 'sn',
//     textField: 'sn',
//     panelHeight: 'auto'
// });
//产品名称和69码关联,值改变事件
// $("[name='productSn']").change(function () {
//     var name = $(this).val();
//     console.debug(name+"================");
// });

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
/*==================================================================*/
// 删除一条数据
function removeBill() {
    console.debug("===========remove============");
    var row = $("#orderBill_datagrid").datagrid("getSelected");
    $.post("/orderBill_remove.do", {
        id: row.id
    }, function (data) {

        $.messager.alert('温馨提示', data.msg, 'info', function () {
            // 刷新数据表格(保持在当前页)
            $("#orderBill_datagrid").datagrid("reload");
        });
    });
    console.debug("===========remove2============");

}

// 新增或保存一条订单数据
function add() {
    console.debug("===========add============");
    // 判断是否有id
    var url;
    if ($("[name='id']").val()) {
        url = "/orderBill_update.do";
    } else {
        url = "/orderBill_save.do";
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
                $("#orderBill_datagrid").datagrid("reload");
                getUUID();
            });
        }
    });

}
//全部入库
function AllInStock() {
    console.debug("===========AllInStock1============");

    var rows = $("#orderBill_datagrid").datagrid("getRows");
    var myarray = [];
    console.debug(rows);
    for (var i = 0; i < rows.length; i++) {
        myarray[i] = rows[i].id;
    }
    console.debug(myarray);
    $.post("/stockIncomeBillItem_saveAll.do", {
        orderBills: myarray
    }, function (data) {
        $.messager.alert('温馨提示', data.msg, 'info', function () {
            // 刷新数据表格(保持在当前页)
            $("#orderBill_datagrid").datagrid("reload");
            getUUID();
        });
    })

    console.debug("===========AllInStock2============");
}

// 编辑一条数据
function editBill() {
    console.debug("===========edit===========");
    //清空表单数据
    $('#ff').form("clear");
    //数据回显
    var row = $("#orderBill_datagrid").datagrid("getSelected");
    console.debug(row);
    $('#ff').form("load", row);
    console.debug("===========edit2=============");
}

//自动生成uuid最为库存编码
function getUUID() {
    $.post("/orderBill_sn.do", function (data) {
        console.debug("========uuid=============");
        console.debug(data);
        $("[name='sn']").val(data);
    })
}

//商品69码值改变事件
function changeProduct() {
    var sn = $("[name='productSn']").val();
    $.post("/orderBill_getProductBySn.do", {sn: sn},
        function (data) {
            console.debug(data);
            $("[name='productName']").val(data.name)
        });
};
//刷新,清空表单用
function reloadBill() {
    console.debug("========reloadBill==========");
    //清空表单数据
    $('#ff').form("clear");
    //库存编码重新生成
    getUUID();
    //表格加载全部
    $("#orderBill_datagrid").datagrid("load");
};



