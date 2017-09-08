<%@ page language="java" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
       body {
            overflow: hidden;
        }

        .l-table-edit {
            width: 100%;
        }
        .l-table-edit-td {
            text-align: right;
            font-size: 12px;
            padding: 4px;
            height: 40px;
        }

        .l-button-submit, .l-button-reset {
            width: 80px;
            float: left;
            margin-left: 120px;
            padding-bottom: 2px;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/leaver.js"></script>
</head>
<body>

<div style="height: 36px; padding-top: 10px; padding-left: 15px" id="leaver_tb">
    <a  class="easyui-linkbutton"
        data-options="iconCls:'icon-add',plain:true" onclick="add()">添加记录</a>
    <a  class="easyui-linkbutton"
       data-options="iconCls:'icon-reload',plain:true" onclick="reload()">查询全部</a>
    工号:<input type="text" name="sn"/>
    姓名:<input type="text" name="username"/>
    <a  class="easyui-linkbutton"
       data-options="iconCls:'icon-search',plain:true" onclick="searchForm()">查询</a>
</div>
    <table id="leaver_datagrid"></table>
<div id="reason_dialog">
    <form id="reason_form" method="post">
        <input type="hidden" name="id" />
        <table align="left" style="margin-top: 15px;margin-left: 40px">
            <tbody>
            <tr style="height: 40px;">

            <td class="l-dialog-textarea" style="text-align: left;" colspan="6">
                        <textarea cols="20"  name="reason" rows="4" style="width:100%">
                </textarea>
            </td>
        </tr>
            </tbody>
        </table>
    </form>

</div>


<div id="leaver_dialog">
    <form id="leaver_form" method="post">

        <table align="left" style="margin-top: 15px;margin-left: 40px">
            <tbody>
            <tr  style="height: 40px;">
                <td class="l-table-edit-td" style="width: 100px">请假员工:</td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input type="text" id="employee_combobox" name="employee.id" class="easyui-combobox"
                           data-options="
							        valueField: 'id',
							        textField: 'username',
							        url: '/employee_listAll.do',panelHeight:'auto'" />
                </td>
                <td style="width: 100px" class="l-table-edit-td">请假类别:</td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input type="text" id="leaverClass_combobox" name="leaveClass.id" class="easyui-combobox"
                           data-options="
							        valueField: 'id',
							        textField: 'name',
							        url: '/leaveClass_listAll.do',panelHeight:'auto'" />
                </td>
            </tr>
            <tr style="height: 40px;">
                 <td class="l-table-edit-td" style="width: 60px">请假原因：
                 </td>
                 <td class="l-table-edit-td" style="text-align: left;" colspan="3">
                        <textarea cols="20" id="leavefor" name="leavefor" rows="2" style="width:80%">
                        </textarea>
                     <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="leavefor" data-valmsg-replace="true"></span></font></span>
                 </td>
            </tr>
            <tr style="height: 40px;" style="width: 60px">
                <td class="l-table-edit-td">开始时间：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input   name="leaveTimes" type="text" class="easyui-datebox" />
                </td>
                <td class="l-table-edit-td" style="width: 60px">结束时间：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input   name="leaveTimed" type="text" class="easyui-datebox" />
                </td>
            </tr>
            <tr style="height: 40px;">
                <td class="l-table-edit-td" style="width: 100px">请假时长：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input  id="leaderShipoption" name="leaveDuration" type="text" value="" />

                </td>
                <td class="l-table-edit-td" style="width: 100px">是否请假：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <span>请假 <input Checked="checked"    name="isLeave" type="radio" value="true" />&nbsp;&nbsp;&nbsp;&nbsp;旷工 <input id="Isleave" name="isLeave" type="radio" value="false" /></span>
                </td>
            </tr>

            <tr style="height: 40px;">
                <td class="l-table-edit-td" style="width: 100px">领导意见：
                </td>
                <td class="l-table-edit-td" style="text-align: left;" colspan="3">
                        <textarea cols="20"  name="leaderShipoption" rows="2" style="width:80%">
                </textarea>
                    <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="Leadershipopinion" data-valmsg-replace="true"></span></font></span>
                </td>
            </tr>



            </tbody>
        </table>
    </form>
</div>


<div id="leaver_btns">
    <a  class="easyui-linkbutton"
       data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
    <a  class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
</div>
<div id="reason_btns">
    <a  class="easyui-linkbutton"
        data-options="iconCls:'icon-save',plain:true" onclick="save1()">提交</a>
    <a  class="easyui-linkbutton"
        data-options="iconCls:'icon-cancel',plain:true" onclick="cancel1()">取消</a>
</div>

</body>
</html>
