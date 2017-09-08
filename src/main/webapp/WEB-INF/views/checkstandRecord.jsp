<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>

    <script type="text/javascript" src="/static/js/checkstandRecord.js"></script>
</head>
<body>
<table id="csr_datagrid"></table>

<div id="csr_dialog">
    <form id="csr_form" method="post">
        <input type="hidden" name="id"/>
        <table align="center" style="margin-top: 15px">
            <tbody>
            <tr>
                <td>订单编号:</td>
                <td>
                    <input type="text" name="ordresn"/>
                </td>
            </tr>
            <tr>
                <td>会员卡号:</td>
                <td>
                    <input type="text" name="membersn"/>
                </td>
            </tr>
            <tr>
                <td>店铺名称:</td>
                <td>
                    <input type="text" name="shopname"/>
                </td>
            </tr>
            <tr>
                <td>订单时间:</td>
                <td>
                    <input type="text" name="ordertime"/>
                </td>
            </tr>
            <tr>
                <td>商品总数:</td>
                <td>
                    <input type="text" name="productcount" class="easyui-datebox"/>
                </td>
            </tr>
            <tr>
                <td>消费金额:</td>
                <td>
                    <input type="text" name="monertary" class="easyui-datebox"/>
                </td>
            </tr>
            <tr>
                <td>操作人:</td>
                <td>
                    <input type="text" name="username" class="easyui-datebox"/>
                </td>
            </tr>
            <tr>
                <td>收款方式:</td>
                <td>
                    <input type="text" name="collection" class="easyui-datebox"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div id="csr_tb" style="height: 30px">
    订单编号：
    <input id="MemberNumber" name="MemberNumber" type="text" value=""/>
    收银店铺：
    <select class="div_div" id="StoreName" name="StoreName">
        <option value="0">所有</option>
    </select>
    收银时间:
    <input id="Timeone" class="easyui-datebox"/>
    ~
    <input id="Timetwo" class="easyui-datebox"/>
    收款方式：
    <select id="WayDispaly" class="input_check" style="width: 80px">
        <option value="0">所有</option>
        <option value="1">现金</option>
        <option value="2">微信</option>
        <option value="3">支付宝</option>
        <option value="4">卡内消费</option>
    </select>
    <a href="#" class="easyui-linkbutton" onclick="searchForm()">查询</a>
</div>

</body>
</html>