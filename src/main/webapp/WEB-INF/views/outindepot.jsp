<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/icon.css">
    <script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
    <script src="/static/js/outindepot.js"></script>
</head>
<body>
    <table id="outindepot_datagrid"></table>
    <%--表格的顶部工具栏--%>
    <div id="outindepot_toolbar">
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true" onclick="add()">新增</a>
        出入库方式名称: <input type="text" name="keyword"/>
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true" onclick="selectall()">查询所有</a>
    </div>
    <%--编辑增加页面--%>
    <div id="outindepot_dialog">
        <form id="editForm" method="post">
            <input type="hidden" name="id"/>
            <table align="center" style="margin-top: 30px">
                <tr>
                    <td>品牌产地名称:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>是否启用:</td>
                    <td>
                        <select id="state_com" class="easyui-combobox"
                                name="state"panelHeight='auto'style="width: 143px">
                            <option value="true">出库</option>
                            <option value="false">入库</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%--弹出框的底部工具栏--%>
    <div id="outindepot_buttons">
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
    </div>
</body>
</html>
