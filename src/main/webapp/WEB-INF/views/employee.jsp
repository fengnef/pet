<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/static/common/common.jsp" %>


	<style type="text/css">
		body
		{
			overflow: hidden;
		}

		.l-table-edit
		{
			width: 100%;
		}

		.l-table-edit-td
		{
			text-align: right;
			font-size: 12px;
			padding: 4px;
			height: 40px;
		}

		.l-button-submit, .l-button-reset
		{
			width: 80px;
			float: left;
			margin-left: 120px;
			padding-bottom: 2px;
		}

		.border-color-error
		{
			border: 1px solid red;
		}

		.border-color-success
		{
			border: 1px solid #D0D0D0;
		}
	</style>
<script type="text/javascript" src="/static/js/employee.js"></script>

</head>
<body>
	<div style="height: 36px; padding-top: 10px; padding-left: 15px" id="employee_tb">
		<a  class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="add()">添加员工</a>
		<a href="#" class="easyui-linkbutton"
		   data-options="iconCls:'icon-reload',plain:true" onclick="reload()">查询全部</a>
		员工编号:<input type="text" name="sn"/>
		员工姓名:<input type="text" name="username"/>
		<a href="#" class="easyui-linkbutton"
		   data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
	</div>
	<table id="emp_datagrid"></table>

	<div id="emp_dialog">
		<form id="emp_form" method="post">
			<input type="hidden" name="id" />
			<table align="left" style="margin-top: 15px;margin-left: 40px">
				<tbody>
					<tr  style="height: 40px;">
						<td class="l-table-edit-td" style="width: 80px">工号:</td>
						<td >
							<input class="easyui-validatebox" data-options="required:true" type="text" name="sn" />
						</td>
						<td class="l-table-edit-td">职位:</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input type="text" name="positionName.id" class="easyui-combobox"
								   data-options="
							        valueField: 'id',
							        textField: 'positionname',
							        url: '/positionName_listAll.do',panelHeight:'auto'" />
						</td>
					</tr>
					<tr style="height: 40px;">
						<td style="width: 80px" class="l-table-edit-td">姓名:</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input type="text" name="username" class="easyui-validatebox" required="true" />
						</td>
						<td class="l-table-edit-td">性别</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<select  class="easyui-combobox" name="sex" panelHeight="auto" style="width:143px;">
								<option value="true">男</option>
								<option value="false">女</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="l-table-edit-td">联系电话：</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input id="phone" name="phone" type="text" class="easyui-validatebox" required="true" validType="mobile" />
						</td>
						<td class="l-table-edit-td">身份证号：</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input id="IDcard" name="idcard" type="text"  class="easyui-validatebox" required="true" validType="idcard" />
						</td>
					</tr>
					<tr style="height: 40px;">
						<td class="l-table-edit-td">基本工资：</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input id="basicSalary" name="basicSalary" type="text"  class="easyui-validatebox" required="true" />
						</td>

						<td class="l-table-edit-td">入职时间：</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input  id="InductionTime" name="inductionTime" type="text" class="easyui-datebox" />
						</td>
					</tr>

					<%--<tr id="pwdInput" style="height: 40px;">
						<td class="l-table-edit-td">密码:</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input type="password" name="password" class="easyui-validatebox" required="true" />
						</td>
						<td class="l-table-edit-td">重复密码：</td>
						<td class="l-table-edit-td" style="text-align: left;">
							<input type="password"  class="easyui-validatebox" required="required" validType="equals['#password']"  />
						</td>
					</tr>--%>

				</tbody>

			</table>

		</form>
	</div>

	<%--<div id="emp_tb">
		<!-- 使用shiro标签控制按钮显示 -->
		<shiro:hasPermission name="employee:save">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" data-cmd="add">新增</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="employee:update">
		<a href="#" class="easyui-linkbutton" id="emp_tb_edit"
			data-options="iconCls:'icon-edit',plain:true" data-cmd="edit">编辑</a>
		</shiro:hasPermission>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true" id="emp_tb_cs"
			data-cmd="changeState">离职</a>
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true" data-cmd="reload">查询全部</a>
		<!-- 关键字查询 -->

		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cut',plain:true" data-cmd="exportFile">导出</a>
		
	</div>--%>

	<div id="emp_btns">
		<a  class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
		<a  class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
	</div>

	<%--<div id="emp_file" class="easyui-dialog" data-options="">
		<form action="/employee_import.do" method="post" enctype="multipart/form-data">
			文件:<input type="file" name="file"><br>
			<input type="submit" value="提交">		
		</form>
	</div>--%>

</body>
</html>