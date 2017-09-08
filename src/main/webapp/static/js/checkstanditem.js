$(function() {
	// 抽取变量
	var cs_datagrid = $("#cs_datagrid");
	var cs_dialog = $("#cs_dialog");
	var cs_form = $('#cs_form');

	// 初始化数据表格
	cs_datagrid.datagrid({
		url : "/checkstanditem.do",
		fitColumns : true,
		striped : true,
		fit : true,
		pagination : true,
		singleSelect : true,
		toolbar : '#cs_tb',
		columns : [ [ {
			field : 'username',
			title : '商品条码',
            align: 'center',
			width : 100
		}, {
			field : 'realname',
			title : '商品名称',
            align: 'center',
			width : 100
		}, {
			field : 'tel',
			title : '单位',
            align: 'center',
			width : 100
		}, {
			field : 'email',
			title : '商品原价(元)',
            align: 'center',
			width : 100
		}, {
			field : 'inputtime',
			title : '折扣(元)',
            align: 'center',
			width : 100
		}, {
			field : 'dept',
			title : '售价(元)',
            align: 'center',
			width : 100,
			formatter : deptFormatter
		}, {
			field : 'state',
			title : '销售数量',
            align: 'center',
			width : 100
			//formatter : stateFormatter
		}, {
			field : 'admin',
			title : '折扣原因',
            align: 'center',
			width : 100
			//formatter :
		},{
            field : 'admin',
            title : '服务人员',
            align: 'center'
            //formatter :
        } ] ],

	});

	cs_dialog.dialog({
		width : 300,
		height : 350,
		//buttons : '#cs_btns',
		closed : true
	});

	// 部门格式化
	function deptFormatter(value, row, index) {
		return value ? value.name : "";
	}


	var obj = {
		name : 'will',
		showName : function() {
			alert(1)
		}
	}
	var methodObj = {
		// 高级查询
		searchForm : function() {
			// 获取关键字文本框的值
			var keyword = $("[name='keyword']").val();

			cs_datagrid.datagrid('load', {
				keyword : keyword
			});
		},

		// 查询全部数据
		reload : function() {
			// 清空查询条件的内容
			$("[name='keyword']").val('');

			cs_datagrid.datagrid('load', {});
		},
	}

	//统一绑定事件
	$("a[data-cmd]").on("click",function(){
		//获取该链接需要执行的方法名字
		var methodName = $(this).data("cmd");
		//掉用方法
		methodObj[methodName]();
	})

})
