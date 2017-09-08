$(function() {
	// 抽取变量
	var csr_datagrid = $("#csr_datagrid");
	var csr_dialog = $("#csr_dialog");
	var csr_form = $('#csr_form');

	// 初始化数据表格
	csr_datagrid.datagrid({
		url : "/checkstandRecord_listAll.do",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#csr_tb',
		columns : [ [ {
			field : 'ordersn',
			title : '订单编号',
            align: 'center',
			width : 100
		}, {
			field : 'menber.membernumber',
			title : '会员卡号',
            align: 'center',
            formatter: memberFormatter,
			width : 100
		}, {
			field : 'shop.name',
			title : '店铺名称',
            align: 'center',
            formatter: shopFormatter,
			width : 100
		}, {
			field : 'ordertime',
			title : '订单时间',
            align: 'center',
			width : 100
		}, {
			field : 'productcount',
			title : '商品总数',
            align: 'center',
			width : 100
		}, {
			field : 'monetary',
			title : '消费金额',
            align: 'center',
			width : 100
		}, {
			field : 'employee.username',
			title : '操作人',
            align: 'center',
            formatter: employeeFormatter,
			width : 100
		}, {
			field : 'collection',
			title : '收款方式',
            align: 'center',
            formatter: collFormatter,
			width : 100
		} ] ],

	});

	csr_dialog.dialog({
		width : 300,
		height : 350,
		//buttons : '#csr_btns',
		closed : true
	});

    function employeeFormatter(value, row, index) {
        if (row.employee) {
            return row.employee['username'];
        } else {
            return '';
        }
    }
    function memberFormatter(value, row, index) {
        if (row.employee) {
            return row.member['membernumber'];
        } else {
            return '';
        }
    }
    function shopFormatter(value, row, index) {
        if (row.employee) {
            return row.shop['name'];
        } else {
            return '';
        }
    }
    function collFormatter(value, row, index) {
        return '现金';
    }

	/*var methodObj = {
		// 高级查询
		searchForm : function() {
			// 获取关键字文本框的值
			var keyword = $("[name='keyword']").val();

			csr_datagrid.datagrid('load', {
				keyword : keyword
			});
		},

		// 查询全部数据
		reload : function() {
			// 清空查询条件的内容
			$("[name='keyword']").val('');

			csr_datagrid.datagrid('load', {});
		},
	}*/



})
// 高级查询
function searchForm() {
    // 获取关键字文本框的值
    var sn = $("#MemberNumber").val();
    var timeone = $("#Timeone").val();
    var timetow = $("#Timetow").val();
	console.debug(sn);
    $("#csr_datagrid").datagrid('load', {
        ordersn: sn,
		currentDate:timeone
    });
}
