<%@ page language="java" contentType="text/html;charset=utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/positionName.js"></script>
</head>
<body>

<div id="positionName_dialog">
    <form id="positionName_form" method="post">
        <input type="hidden" name="id" />
        <table align="center" style="margin-top: 15px">
            <tbody>
            <tr>
                <td>职位名称:</td>
                <td>
                    <input type="text" name="positionname" />
                </td>
            </tr>
            <tr>
                <td>岗位津贴:</td>
                <td>
                    <input type="number" min="0" name="postallowance" />
                </td>
            </tr>
            <tr>
                <td>交通补贴:</td>
                <td>
                    <input type="number" min="0" name="trafficsubsidies" />
                </td>
            </tr>
            <tr>
                <td>话费补贴:</td>
                <td>
                    <input type="number" min="0" name="phonesubsidies" />
                </td>
            </tr>
            <tr>
                <td>餐补补贴:</td>
                <td>
                    <input type="number" min="0" name="subsidizedmeals" />
                </td>
            </tr>
            <tr>
                <td>全勤奖励:</td>
                <td>
                    <input type="number" min="0" name="fulltime" />
                </td>
            </tr>
            <tr>
                <td>提成比例(%):</td>
                <td>
                    <input type="number" min="0" max="100" name="commission" />
                </td>
            </tr>

            </tbody>
        </table>
    </form>
</div>



<div id="positionName_btns">
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
</div >

    <div style="height: 36px; padding-top: 10px; padding-left: 15px" id="positionname_tb">
        <a  class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true" onclick="add()">添加职位</a>
    </div>

    <table id="posi_datagrid"></table>
</body>
</html>
