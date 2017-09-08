<%@ page language="java" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8"/>
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
    <div class="imageButton now" onclick="show('/specification.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/spec.png"/>
        <p style="text-align: center; margin-top: 7px;">商品规格</p>
    </div>

    <div class="imageButton" onclick="show('/productCategory.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/category.png"/>
        <p style="text-align: center; margin-top: 7px;">商品类目</p>
    </div>
    <div class="imageButton" onclick="show('/manufacturer.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/manufacturer.png"/>
        <p style="text-align: center; margin-top: 7px;">生产厂商</p>
    </div>
    <div class="imageButton" onclick="show('/brand.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/brand.png"/>
        <p style="text-align: center; margin-top: 7px;">商品品牌</p>
    </div>
    <div class="imageButton" onclick="show('/productPomponent.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/element.png"/>
        <p style="text-align: center; margin-top: 7px;">商品成分</p>
    </div>
    <div class="imageButton" onclick="show('/product.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/proMsg.png" /><p style="text-align: center; margin-top: 7px;">商品信息</p>
    </div>
    <div class="imageButton" onclick="show('/vipmember.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/vip.png" /><p style="text-align: center; margin-top: 7px;">会员等级</p>
    </div>
    <div class="imageButton" onclick="show('/petkindandcategory.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/pet.png" /><p style="text-align: center; margin-top: 7px;">宠物品种</p>
    </div>
    <div class="imageButton" onclick="show('/supplier.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/supplier.png" /><p style="text-align: center; margin-top: 7px;">供应商管理</p>
    </div>
    <div class="imageButton" onclick="show('/outindepot.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/outIn.png" /><p style="text-align: center; margin-top: 7px;">出入库方式</p>
    </div>
    <div class="imageButton" onclick="show('/dictionary.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/dictionaries.png" /><p style="text-align: center; margin-top: 7px;">数据字典</p>
    </div>
    <div class="imageButton" onclick="show('/systemlog.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/log.png"/>
        <p style="text-align: center; margin-top: 7px;">操作日志</p>
    </div>
</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/product.do"></iframe>
</div>
</body>
</html>
