<%@ page language="java" contentType="text/html;charset=utf-8"
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
<%@ include file="/static/common/common.jsp" %>
<style type="text/css">
.border_right_none:{
		border-right:none
	}
</style>
<script type="text/javascript" src="/static/js/role.js">
</script>
</head>
<body>

<div id="role_dialog">
	<form action="" id="editForm"  method="post" >
	<input type="hidden" name="id"/>
		<table  align="center" style="margin-top: 15px" >
			<tr>
				<td>角色编号<input type="text" name="sn"></td>
				<td>角色名称 <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>
					<table id ="allPermission"></table>
				</td>
				<td>
					<table id ="selfPermission"></table>
				</td>
			</tr>
		</table>
	
	</form>
</div>


<div id="role_buts">
	<a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:'true'" data-cmd="save">保存</a>
	<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:'true'" data-cmd="cancel">取消</a>
</div>

<div id="role_tb">
	<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true'" data-cmd="add">新增</a>
	<a class="easyui-linkbutton" id="role_tb_edit" data-options="iconCls:'icon-edit',plain:'true'" data-cmd="edit">编辑</a>
	<a class="easyui-linkbutton" id="role_tb_change" data-options="iconCls:'icon-remove',plain:'true'" data-cmd="">删除</a>
	<a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:'true'" data-cmd="reload">查询全部</a>
	<a class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:'true'" data-cmd="loadPermission">加载所有权限</a>
	<input type="text" name="keyword">
	<a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'" data-cmd="query">查询</a>
</div>


<table id="role_datagrid" ></table>

</body>
</html>