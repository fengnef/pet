<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/icon.css">
    <script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/plugins/echarts-2.2.7/echarts-all.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#pd_datagrid").datagrid({
                columns: [[
                    {field: "productName", title: "商品名称", width: 100},
                    {field: "stockIncomeAveragePrice", title: "入库单价(月均/元)", width: 100},
                    {field: "stockOutcomeAveragePrice", title: "出库单价(月均/元)", width: 100},
                    {field: "salePrice", title: "销售价格(月均/元)", width: 100},
                    {field: "saleCount", title: "销售数量", width: 100},
                    {field: "salePriceCount", title: "销售总价(元)", width: 100},
                    {field: "profit", title: "盈利(元)", width: 100}
                ]],
                url: "/queryPageResult.do",
                fit: true,
                fitColumns: true,
                striped: true,
                singleSelect: true
            })
        })

        function searchForm() {
//		var productName=$("#petKindTwo").val();
            var productName = $("#petKindTwo").combobox("getText");
            //var selectDate=$("#selectDate").val();
            $("#pd_datagrid").datagrid('load', {
                productName: productName
                //selectDate:selectDate,
            });
        }
    </script>
    <title>商品数据报表</title>
</head>
<body>
<div>
    <input id="petKind" class="easyui-combobox" data-options="
       	 		valueField: 'id',    
        		textField: 'kind',
       		    url: '/getPetKind_list.do',
       		    panelHeight:'auto',
       		    editable:false,
        		onChange:function(){
						var parentId=$('#petKind').combobox('getValue');
            				$('#petKindTwo').combobox({
								url:'/getProductNameBypc_list.do?parentId='+parentId,
								valueField:'id',
								textField:'name',
								panelHeight:'auto',
       		   					editable:false
						});
        		}"/>
    <input id="petKindTwo" class="easyui-combobox"/>
    <%--日期:<input id="selectDate" type="text" class="easyui-datebox"/>--%>
   <%-- <select id="Time" class="easyui-combobox" style="width:200px;" data-options=" panelHeight:'auto'">
        <option>所有</option>
        <option>日</option>
        <option>月</option>
        <option>年</option>
    </select>--%>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchForm()">查询</a>
</div>
<div style="height: 400px">
    <table id="pd_datagrid" class="easyui-datagrid"></table>
</div>
<%--
	var url = '/category_listAll.do';
$.getJSON(url, function (json) {
    $('#category').combobox({
        data: json,
        valueField: 'id',
        textField: 'petcategoryname',
        onSelect: function (data) {
            $('#breed').combobox({
                url: '/selectBreedByCategoryId.do?id=' + data.id,
                valueField: 'id',
                textField: 'petbreedname',
            })
        }
    });
});

--%>
</body>
</html>