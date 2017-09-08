<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>

    <script type="text/javascript" src="/static/js/checkstanditem.js"></script>
</head>
<body>
<table id="cs_datagrid"></table>

<div id="cs_dialog">
    <form id="cs_form" method="post">
        <input type="hidden" name="id"/>
        <table align="center" style="margin-top: 15px">
            <tbody>
            <tr>
                <td>商品69条码:</td>
                <td>
                    <input type="text" name="sn"/>
                </td>
            </tr>
            <tr>
                <td>商品名称:</td>
                <td>
                    <input type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>单位:</td>
                <td>
                    <input type="text" name="unit"/>
                </td>
            </tr>
            <tr>
                <td>原价(元):</td>
                <td>
                    <input type="text" name="saleprice"/>
                </td>
            </tr>
            <tr>
                <td>折扣:</td>
                <td>
                    <input type="text" name="xxx"/>
                </td>
            </tr>
            <tr>
                <td>售价(元):</td>
                <td>
                    <input type="text" name="memberPrice"/>
                </td>
            </tr>
            <tr>
                <td>数量:</td>
                <td>
                    <input type="text" name="count"/>
                </td>
            </tr>
            <tr>
                <td>折扣原因:</td>
                <td>
                    <input type="text" name="www"/>
                </td>
            </tr>
            <tr>
                <td>服务人员:</td>
                <td>
                    <input type="text" name="username"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div id="cs_tb" style="height: 30px">
    商品名称：
    <input id="MemberNumber" name="MemberNumber" onchange="DoSearch();" type="text" value=""/>

    <input type="button" class="comBtn gray" value="查询" onclick="DoSearch();" style="margin-top: -5px;">

    <input type="button" class="comBtn gray" value="打印该单" onclick="" style="margin-top: -5px;">
</div>

</body>
</html>