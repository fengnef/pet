<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/salary.js"></script>
</head>
<body>

<div style="height: 36px; padding-top: 10px; padding-left: 15px" id="salary_tb">

    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-reload',plain:true" onclick="reload()">查询全部</a>
    姓名:<input type="text" name="username"/>
    时间:<input id="currentDate" type="text" name="currentDate" class="easyui-datebox"/>
    <a  class="easyui-linkbutton"
       data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
</div>
<table id="salary_datagrid"></table>

</body>
</html>
