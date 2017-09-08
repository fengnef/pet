<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp" %>

<script type="text/javascript" src="/static/js/shopkeeper.js"></script>
</head>
<body>
	<table id="shopkeeper_datagrid"></table>

	<div id="shopkeeper_dialog">
		<form id="shopkeeper_form" method="post">
			<input type="hidden" name="id" />
			<table align="center" style="margin-top: 15px">
				<tbody>

					<tr id="pwdInput">
						<td>登录账号:<input type="text" name="username" /></td>
						<td >登录密码:<input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>真实姓名:<input type="text" name="storehead" /></td>
						<td>电话号码:<input type="text" name="contactmobile" /></td>
					</tr>

					<tr>
						<td>
							<table id="allRoles"></table>
						</td>
						<td>
							<table id="selfRoles"></table>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

	<div id="shopkeeper_tb">
		<a  class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">添加账号</a>


	</div>

	<div id="shopkeeper_btns">
		<a  class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
		<a  class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
	</div>


</body>
</html>