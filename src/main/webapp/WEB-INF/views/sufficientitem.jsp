<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">

    </style>
    <title>Title</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("[name='rechargenumber']").val('');
            $("[name='membernumber']").val('');
            $("[name='menberName']").val('');
            $("#grid").datagrid({
                url: "/sufficientitem_list.do",
                fit: true,
                fitColumns: true,
                striped: true,
                pagination: true,
                align: 'center',
                singleSelect: true,
                toolbar: "#doSearch_form",
                columns: [[
                    {field: 'rechargenumber', title: '充值单编号', width: 100},
                    {field: 'membernumber', title: '会员卡号', width: 100, formatter: membernumber},
                    {field: 'membername', title: '会员姓名', width: 100, formatter: member},
                    {field: 'usergroupcode', title: '充值门店编号', width: 100},
                    {field: 'usergroupname', title: '充值门店名称', width: 100},
                    {field: 'rechargetime', title: '充值时间', width: 100},
                    {field: 'rechargeprice', title: '充值金额', width: 100},
                    {field: 'itemremarks', title: '备注', width: 100}

                ]]
            });
            //会员明
            function member(value, rowData, rowIndex) {
                return rowData.membername ? rowData.membername.membername : "匿名";
            }

            //会员卡号
            function membernumber(value, rowData, rowIndex) {
                return rowData.membername ? rowData.membername.membernumber : "订单编号过期";
            }
        })

        //高级查询操作
        function DoSearch() {
            var rechargenumber = $("[name='rechargenumber']").val();
            var membernumber = $("[name='membernumber']").val();
            var menberName = $("[name='menberName']").val();
            $("#grid").datagrid("load", {
                rechargenumber: rechargenumber,
                membernumber: membernumber,
                menberName: menberName

            })
        }

    </script>
</head>
<body>
<div id="doSearch_form" class="areabx clear" style="height: 36px; padding-top: 10px; padding-left: 15px">
    <form>
        <div>
            <span>充值单编号：</span><input class="trade-time" id="RechargeNumber" name="rechargenumber"

                                      type="text" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span>会员卡号：</span><input class="trade-time" id="MemberNumber" name="membernumber"
                                     type="text" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span>会员姓名：</span><input class="trade-time" id="MemberName" name="menberName"
                                     type="text"
                                     value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="com_btn1" value="查询" onclick="DoSearch();">
        </div>
    </form>
</div>

<table id="grid">
</table>

</body>
</html>
