$(function () {
    // 抽取变量
    var productStock_datagrid = $("#productStock_datagrid");
    var productStock_form = $('#productStock_form');
    // 初始化数据表格
    productStock_datagrid.datagrid({
        url: "/productStock_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        toolbar: "#productStock_tb",
        pagination: true,
        singleSelect: true,
        //  toolbar: '#productStock_tb',
        columns: [[{
            field: 'sn',
            title: '库存编号',
            width: 100
        }, {
            field: 'productSn',
            title: '商品69码',
            width: 100,
            formatter: productSnFormatter
        }, {
            field: 'productName',
            title: '商品名称',
            width: 100,
            formatter: productNameFormatter
        }, {
            field: 'productCategory',
            title: '商品类别',
            width: 100
        }, {
            field: 'productBrand',
            title: '品牌',
            width: 100
        }, {
            field: 'productDate',
            title: '生产日期',
            width: 100,
        }, {
            field: 'warrantyDate',
            title: '保质期',
            width: 100,
        }, {
            field: 'productSpecification',
            title: '商品规格',
            width: 100,
        },
            {
                field: 'balancestock',
                title: '库存结余',
                width: 100,
            }
        ]]

    });

// 商品名称格式化
    function productNameFormatter(value, row, index) {
        console.debug(value);
        console.debug(row);
        return row.product ? row.product.name : "";
    };

// 商品69码格式化
    function productSnFormatter(value, row, index) {
        console.debug(value);
        console.debug(row);
        return row.product ? row.product.sn : "";
    };
    $('#category').combobox({
        url: '/orderBill_getProductCategory.do',
        valueField: 'category',
        textField: 'category',
        panelHeight: 'auto'
    });
})
;


//高级查询
function searchForm() {
    var keyword = $("[name='keyword']").val();
    var productName = $("[name='productName']").val();
    var category = $("[name='category']").val();
    $("#productStock_datagrid").datagrid('load', {
        keyword: keyword,
        productName: productName,
        category: category
    });
}

//刷新,清空表单用
function reloadBill() {
    //商品类别设为空字符
    $("[name='keyword']").val('');
    $("[name='productName']").val('');
    $("#category").combobox("setValue", '');
    //表格加载全部
    $("#productStock_datagrid").datagrid("load", {});
};
