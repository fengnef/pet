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
    <div class="imageButton now" onclick="show('/productStock.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/kc.png" /><p style="text-align: center; margin-top: 7px;">库存</p>
    </div>
    <div class="imageButton" onclick="show('/orderBill.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/dd.png" /><p style="text-align: center; margin-top: 7px;">订单</p>
    </div>
    <div class="imageButton" onclick="show('/stockIncomeBillItem.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/rkjl.png" /><p style="text-align: center; margin-top: 7px;">入库记录</p>
    </div>
    <div class="imageButton" onclick="show('/stockOutcomeBill.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/chd.png" /><p style="text-align: center; margin-top: 7px;">出货单</p>
    </div>
    <div class="imageButton" onclick="show('/stockOutcomeBillItem.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/chjl.png" /><p style="text-align: center; margin-top: 7px;">出货记录</p>
    </div>

</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/productStock.do"></iframe>
</div>
</body>
</html>
