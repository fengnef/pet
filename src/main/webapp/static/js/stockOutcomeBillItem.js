$(function () {
    console.debug("==========fgsdgsdghsh==========");
    // 抽取变量
    var stockOutcomeBillItem_datagrid = $("#stockOutcomeBillItem_datagrid");
    var stockOutcomeBillItem_form = $('#stockOutcomeBillItem_form');
    // 初始化数据表格
    stockOutcomeBillItem_datagrid.datagrid({
        url: "/stockOutcomeBillItem_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        toolbar: '#stockOutcomeBillItem_tb',
        columns: [[{
            field: 'productName',
            title: '商品名称',
            width: 100
        }, {
            field: 'inputtime',
            title: '出库时间',
            width: 100
        }, {
            field: 'productCategory',
            title: '商品类别',
            width: 100
        }, {
            field: 'productSpecification',
            title: '商品规格',
            width: 100
        }, {
            field: 'costPrice',
            title: '成本价',
            width: 100
        }, {
            field: 'saleprice',
            title: '售价',
            width: 100,
        }, {
            field: 'memberprice',
            title: '会员价',
            width: 100,
        }, {
            field: 'count',
            title: '出货数量',
            width: 100,
        }, {
            field: 'totalamout',
            title: '出货总价',
            width: 100,
        }, {
            field: 'subStore',
            title: '入货商店',
            width: 100,
        }, {
            field: 'operator',
            title: '操作人',
            width: 100,
        }
        ]]

    });


})
//高级查询
function searchForm() {
    var beginDate = $("[name='beginDate']").val();
    var endDate = $("[name='endDate']").val();
    var keyword = $("[name='keyword']").val();
    $("#stockOutcomeBillItem_datagrid").datagrid('load', {
        beginDate: beginDate,
        endDate: endDate,
        keyword: keyword
    });
}

//刷新,清空表单用
function reloadBill() {
    //商品类别设为空字符
    $("[name='keyword']").val('');
    $("#endDate").datebox("setValue", '');
    $("#beginDate").datebox("setValue", '');
    //表格加载全部
    $("#stockOutcomeBillItem_datagrid").datagrid("load", {});
};