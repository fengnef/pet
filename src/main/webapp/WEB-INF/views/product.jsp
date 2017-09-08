<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/themes/icon.css">
    <script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
    <script src="/static/js/product.js"></script>
</head>
<body>
    <table id="product_datagrid"></table>
    <%--表格的顶部工具栏--%>
    <div id="product_toolbar">
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true" onclick="add()">新增</a>
        商品名称: <input type="text" name="productName"/>
        商品类别:<input id="category_combobox" type="text"  class="easyui-combobox" name="productcategoryId"
                    data-options="
							        valueField: 'id',
							        textField: 'category',
							        url: '/productCategory_listall.do',panelHeight:'auto'" />
        品牌: <input id="bd_combobox" type="text"  class="easyui-combobox" name="brandId"
                   data-options="
							        valueField: 'id',
							        textField: 'brandname',
							        url: '/brand_listall.do',panelHeight:'auto'" />
        商品成分: <input type="text" name="pomponent"/>
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true" onclick="selectall()">查询所有</a>
    </div>
    <%--编辑增加页面--%>
    <div id="product_dialog">
        <form id="editForm" method="post">
            <input type="hidden" name="id"/>
            <table align="center" style="margin-top: 30px">
                <tr>
                    <td>商品69码:</td>
                    <td><input type="text" name="sn"></td>
                </tr>
                <tr>
                    <td>商品名称:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>商品类别:</td>
                    <td>
                        <input id="productcategory_combobox" type="text"  class="easyui-combobox" name="productcategory.id"
                               data-options="
							        valueField: 'id',
							        textField: 'category',
							        url: '/productCategory_listall.do',panelHeight:'auto'" />
                    </td>
                </tr>
                <tr>
                    <td>商品品牌:</td>
                    <td>
                        <input id="brand_combobox" type="text"  class="easyui-combobox" name="brand.id"
                               data-options="
							        valueField: 'id',
							        textField: 'brandname',
							        url: '/brand_listall.do',panelHeight:'auto'" />
                    </td>
                </tr>
                <tr>
                    <td>商品产地:</td>
                    <td>
                        <input id="manufacturer_combobox" type="text"  class="easyui-combobox" name="manufacturer.id"
                               data-options="
							        valueField: 'id',
							        textField: 'productoriginname',
							        url: '/manufacturer_listall.do',panelHeight:'auto'" />
                    </td>
                </tr>
                <tr>
                    <td>商品成分:</td>
                    <td>
                        <input id="pomponent_combobox" type="text"  class="easyui-combobox" name="productpomponent.id"
                               data-options="
							        valueField: 'id',
							        textField: 'pomponentname',
							        url: '/productPomponent_listall.do',panelHeight:'auto'" />
                    </td>
                </tr>
                <tr>
                    <td>过敏物:</td>
                    <td><input type="text" name="allergens"></td>
                </tr>
                <tr>
                    <td>售价:</td>
                    <td><input type="text" name="saleprice"></td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td>
                        <select id="state_com" class="easyui-combobox"
                                name="state"panelHeight='auto'style="width: 143px">
                            <option value="true">是</option>
                            <option value="false">否</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%--弹出框的底部工具栏--%>
    <div id="product_buttons">
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
        <a href="#" class="easyui-linkbutton"
           data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
    </div>
</body>
</html>
