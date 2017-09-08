$(function () {
    console.debug("==========fgsdgsdghsh==========");
    // 抽取变量
    var stockIncomeBillItem_datagrid = $("#stockIncomeBillItem_datagrid");
    var stockIncomeBillItem_form = $('#stockIncomeBillItem_form');
    // 初始化数据表格
    stockIncomeBillItem_datagrid.datagrid({
        url: "/stockIncomeBillItem_list.do",
        fitColumns: true,
        striped: true,
        fit: true,
        pagination: true,
        singleSelect: true,
        toolbar: '#stockIncomeBillItem_tb',
        columns: [[{
            field: 'productName',
            title: '商品名称',
            width: 100
        }, {
            field: 'inputtime',
            title: '入库时间',
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
            title: '进价',
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
            title: '数量',
            width: 100,
        }, {
            field: 'totalamout',
            title: '进货总价',
            width: 100,
        }, {
            field: 'warrantydate',
            title: '保质期',
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
    $("#stockIncomeBillItem_datagrid").datagrid('load', {
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
    $("#stockIncomeBillItem_datagrid").datagrid("load", {});
};