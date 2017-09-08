<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
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

    <shiro:hasPermission name="employee:view">
    <div class="imageButton now" onclick="show('/employee.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/Line.png" /><p style="text-align: center; margin-top: 7px;">基本信息</p>
    </div>
    </shiro:hasPermission>

    <shiro:hasPermission name="positionName:view">
    <div class="imageButton" onclick="show('/positionName.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/pie.png" /><p style="text-align: center; margin-top: 7px;">职位设置</p>
    </div>
    </shiro:hasPermission>

    <shiro:hasPermission name="positionName:view">
    <div class="imageButton" onclick="show('/leaver.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/report.png" /><p style="text-align: center; margin-top: 7px;">请假记录</p>
    </div>
    </shiro:hasPermission>

    <shiro:hasPermission name="salary:view">
    <div class="imageButton" onclick="show('/salary.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/xz.png" /><p style="text-align: center; margin-top: 7px;">薪资计算</p>
    </div>
    </shiro:hasPermission>

    <shiro:hasPermission name="shopkeeper:view">
    <div class="imageButton" onclick="show('/shopkeeper.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/yf.png" /><p style="text-align: center; margin-top: 7px;">用户管理</p>
    </div>
    </shiro:hasPermission>

    <shiro:hasPermission name="role:view">
    <div class="imageButton" onclick="show('/role.do')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/png/js.png" /><p style="text-align: center; margin-top: 7px;">角色管理</p>
    </div>
    </shiro:hasPermission>
</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/employee.do"></iframe>
</div>
</body>
</html>
