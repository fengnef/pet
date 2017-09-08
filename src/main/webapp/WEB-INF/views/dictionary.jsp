
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据字典</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/dictionary.js"></script>
</head>
<body>

<div id="cc" class="easyui-layout" style="width:600px;height:400px;" fit="true">

    <div data-options="region:'west',title:'字典目录',split:true" style="width:700px;">
        <div id="dictionary_datagrid">
        </div>
    </div>
    <div data-options="region:'center',title:'字典目录明细'" style="padding:5px;background:#eee;">
        <div id="dictionaryItem_datagrid">
        </div>
    </div>
</div>

<table id="mydg" ></table>
<%--字典目录工具栏--%>
<div id="dictionaryTools">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  data-cmd="add"  >新增</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"   data-cmd="edit" >编辑</a>
    <!-- 	<a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"   data-cmd="remove" >删除</a> -->
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"   data-cmd="fresh"  >刷新</a>
</div>

<div id = "dialogbutton">
    <a  class="easyui-linkbutton"  data-options="iconCls:'icon-save',plain:true"  data-cmd="save"   >保存</a>
    <a  class="easyui-linkbutton"  data-options="iconCls:'icon-cancel',plain:true"  data-cmd="cancel"  >取消</a>
</div>

<!-- 对话框按钮 字典目录-->
<div id="mydialog">
    <form  id="myform"  method="post" action="">
        <input type="hidden" name=id />
        <table  align="center"  style="margin-top: 30px;" >
            <tr>
                <td>字典编号:</td>
                <th><input type="text"  name="sn"/></th>
            </tr>
            <tr>
                <td>目录名称:</td>
                <th>
                    <input type="text"  name="name"/>
                </th>
            </tr>
            <tr>
                <td>目录简介:</td>
                <th>
                    <textarea rows="3" cols="15" name="intro"></textarea>
                </th>
            </tr>
        </table>
    </form>
</div>



<%--字典目录明细工具栏--%>
<div id="dictionaryItemTools">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" data-cmd="Itemadd"  >新增</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" data-cmd="itemedit" >编辑</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" data-cmd="itemremove" >禁用</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" data-cmd="itemfresh"  >刷新</a>
</div>


<div id = "dialogbuttonItem">
    <a  class="easyui-linkbutton"  data-options="iconCls:'icon-save',plain:true"  data-cmd="itemSave"   >保存</a>
    <a  class="easyui-linkbutton"  data-options="iconCls:'icon-cancel',plain:true"  data-cmd="itemcancel"  >取消</a>
</div>

<%--字典明细 添加和修改弹出框--%>
<div id="dialogItem">
    <form  id="itemForm"  method="post" action="">
        <input type="hidden" name="id" id="item" />
        <input type="hidden" name="dictionary.id" />

        <table  align="center"  style="margin-top: 30px;" >
            <tr>
                <td>字典目录:</td>
                <th><input type="text"  name="dictionary.name" disabled="disabled" readonly="true"/></th>
            </tr>
            <tr>
                <td>字典明细编号:</td>
                <th><input type="text"  name="sn"/></th>
            </tr>
            <tr>
                <td>目录明细名称:</td>
                <th>
                    <input type="text"  name="name"/>
                </th>
            </tr>
            <tr>
                <td>目录明细简介:</td>
                <th>
                    <textarea rows="3" cols="15" name="intro"></textarea>
                </th>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
