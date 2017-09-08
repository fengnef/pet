<%@ page language="java" contentType="text/html;charset=utf-8"%>
<html>
<head>
    <title></title>
    <meta charset="utf-8" />
    <%@include file="/static/common/common.jsp" %>

    <script>

        $(document).ready(function () {
            $(".main_box div").click(function () {
                $(".main_box div").removeClass("now");
                $(this).addClass("now")
            })
        });
        function show(obj) {
            $("#index").attr("src", obj)
        }
    </script>
    <style>
        .l-text-wrapper {
            position: relative;
            float: left;
            margin: 10px;
        }

        .main_box {
            height: 90px;
            min-width: 1100px;
            overflow: hidden;
            width: 100%;
            margin: 5px auto 0 10px;
            padding-top: 5px;
        }

        .now {
            border: 2px solid #ccc;
            box-shadow: none;
        }

        .imageButton {
            background: #fafbfb none repeat scroll 0 0;
            box-shadow: 1px 2px 5px 0 rgba(111, 111, 111, 0.7);
            float: left;
            height: 70px;
            margin-right: 27px;
            padding-top: 10px;
            width: 90px;
        }
    </style>
</head>
<body style="overflow:hidden">
<div class="main_box">
    <div class="imageButton now" onclick="show('/line.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/line.png"/><p style="text-align: center; margin-top: 7px;">数据报表</p>
    </div>
    <div class="imageButton" onclick="show('/pie.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/pie.png"/><p style="text-align: center; margin-top: 7px;">分类销售</p>
    </div>
    <div class="imageButton" onclick="show('/ProductData.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/report.png" /><p style="text-align: center; margin-top: 7px;">商品数据</p>
    </div>
    <div class="imageButton" onclick="show('/CashierRecord.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/sales.png" /><p style="text-align: center; margin-top: 7px;">收银记录</p>
    </div>
    <div class="imageButton" onclick="show('/ProductSellRecord.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/sale.png" /><p style="text-align: center; margin-top: 7px;">商品销售</p>
    </div>
</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/line.do"></iframe>
</div>
</body>
</html>
