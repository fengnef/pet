$(function () {
    // 抽取变量
    var cs_datagrid = $("#cs_datagrid");
    var cs_dialog = $("#cs_dialog");
    var cs_form = $('#cs_form');
    var sn = $(this).val();

    // 初始化数据表格
    cs_datagrid.datagrid({
        url: "/checkstand_listAll.do?sn=" + sn,
        fitColumns: true,
        striped: true,
        fit: true,
        order: 'asc',
        pagination: true,
        singleSelect: true,
        toolbar: '#cs_tb',
        columns: [
            [{
                field: 'productstock.sn',
                title: '库存编码',
                width: 100,
                align: 'center',
                formatter: productStockFormatter,
                rowspan: 2
            }, {
                field: 'sn',
                title: '商品69条码',
                width: 100,
                align: 'center',
                rowspan: 2
            }, {
                field: 'name',
                title: '商品名称',
                align: 'center',
                width: 100,
                rowspan: 2
            }, {
                title: '单价',
                colspan: 3
            }, {
                field: 'count',
                title: '<span style="color: orange">数量</span>',
                formatter: numberFormatter,
                width: 100,
                align: 'center',
                rowspan: 2
            }, {
                field: 'unit',
                title: '单位',
                width: 100,
                align: 'center',
                formatter: unitFormatter,
                rowspan: 2
            }, {
                field: 'scattered',
                title: '<span style="color: orange">折零</span>',
                width: 100,
                align: 'center',
                formatter: scatteredFormatter,
                rowspan: 2
            }, {
                title: '总价',
                colspan: 2
            }, {
                field: 'employee.username',
                title: '<span style="color: orange">服务人员</span>',
                width: 100,
                align: 'center',
                formatter: employeeFormatter,
                rowspan: 2
            }, {
                field: 'eee',
                title: '操作',
                width: 100,
                align: 'center',
                formatter: deleteFormatter,
                rowspan: 2
            }
            ],
            [{
                field: 'incomebillitem.saleprice',
                title: '<span style="color: orange">原价(元)</span>',
                formatter: incomebillitemFormatter,
                width: 50
            }, {
                field: 'xxx',
                title: '折扣',
                align: 'center',
                formatter:costFormatter,
                width: 50
            }, {
                field: 'incomebillitem.memberprice',
                title: '会员价(元)',
                formatter: incomebillitemFormatter2,
                width: 60
            }, {
                field: 'qqq',
                title: '原价(元)',
                formatter: incomebillitemFormatter,
                width: 50
            }, {
                field: 'www',
                title: '会员价(元)',
                formatter: incomebillitemFormatter2,
                width: 60
            }]],

    });

    cs_dialog.dialog({
        width: 300,
        height: 350,
        //buttons : '#cs_btns',
        closed: true
    });

    //绑定失去焦点事件
    $("#cs_sn").blur(function () {
            //获取文本框的值

            //发送ajax请求
            $.post("/checkstand_listAll.do", {
                sn: sn
            }, function (data) {
                console.debug(data);
            })
        }
    );

    $("#cs_get").dialog({
        width: 500,
        height: 400,
        buttons: '#cs_btns',
        closed: true
    })

    $("#dayprint").dialog({
        width: 200,
        height: 500,
        title: '打印单',
        buttons: '#cs_btns',
        closed: true
    })

    function productStockFormatter(value, row, index) {
        if (row.productstock) {
            return row.productstock['sn'];
        } else {
            return '';
        }
    }

    function employeeFormatter(value, row, index) {
        if (row.employee) {
            return row.employee['username'];
        } else {
            return '';
        }
    }

    function incomebillitemFormatter(value, row, index) {
        if (row.incomebillitem) {
            return row.incomebillitem['saleprice'];
        } else {
            return '';
        }
    }

    function incomebillitemFormatter2(value, row, index) {
        if (row.incomebillitem) {
            return row.incomebillitem['memberprice'];
        } else {
            return '';
        }
    }

    function numberFormatter(value, row, index) {
        return '1';
    }

    function unitFormatter(value, row, index) {
        return '箱';
    }

    function scatteredFormatter(value, row, index) {
        return '否';
    }
    function costFormatter(value, row, index) {
        return '0.95';
    }

    function deleteFormatter(value, row, index) {
        return "<font color='red'>删除</font>";
    }
})


function get() {
    $("#cs_get").dialog("open");
    $("#cs_get").dialog("setTitle", "挂单列表");
}

function sumPriceMoney() {
    if ($("#DiscountPrice").val()) {
        var money = $("#DiscountPrice").val() - $("#Price").val();
        $.messager.confirm('提示', '应该找零' + money + '元', function (r) {
            if (r) {
                $("#dayprint").dialog("open");
            }
        });
    } else {
        $.messager.alert('提示', '请输入实收金额！', 'warning');
    }

}