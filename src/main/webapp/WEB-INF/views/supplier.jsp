<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/icon.css">
    <script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
    <script src="/static/js/supplier.js"></script>
</head>
<body>
<table id="supplier_datagrid"></table>
<%--表格的顶部工具栏--%>
<div id="supplier_toolbar">
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true" onclick="add()">新增</a>
    供应商名称: <input type="text" name="keyword"/>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-reload',plain:true" onclick="selectall()">查询所有</a>
</div>
<%--编辑增加页面--%>
<div id="supplier_dialog">
    <form id="editForm" method="post">
        <input type="hidden" name="id"/>
        <table align="center" style="margin-top: 30px">
            <tr>
                <td>名称:</td>
                <td><input type="text" name="supplieroriginname"></td>
            </tr>
            <tr>
                <td>联系人:</td>
                <td><input type="text" name="suppliername"></td>
            </tr>
            <tr>
                <td>联系电话:</td>
                <td><input type="text" name="suppliername"></td>
            </tr>
            <tr>
                <td>主供商品:</td>
                <td><input type="text" name="suppliername"></td>
            </tr>
            <tr>
                <td>合作时长(天):</td>
                <td><input type="text" name="suppliername"></td>
            </tr>
            <tr>
                <td>优势:</td>
                <td><input type="text" name="suppliername"></td>
            </tr>
        </table>
    </form>
</div>
<%--弹出框的底部工具栏--%>
<div id="supplier_buttons">
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
</div>
</body>
</html>
