<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%--引入自定义标签库--%>
<%--<%@taglib uri="http://lyg.com" prefix="myFn"%>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>白牙宠物店云管理系统</title>
    <link rel="shortcut icon" href="/static/myindex/Images/red-upper-C.ico" />
    <script src="/static/myindex/Scripts/jquery-1.7.1.js"></script>
    
    <script src="/static/myindex/Scripts/js/LG.js"></script>
    <script src="/static/myindex/Scripts/jquery.autocomplete.js"></script>
    <script src="/static/myindex/Scripts/jquery.bigautocomplete.js"></script>
    <script src="/static/myindex/ligerUI/js/core/base.js"></script>
    
    <script src="/static/myindex/ligerUI/js/ligerui.all.js"></script>
    <link href="/static/myindex/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/jquery.autocomplete.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/jquery.bigautocomplete.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/newstyle.css" rel="stylesheet"/>
    <link href="/static/myindex/ligerUI/skins/Tab/css/all.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/style1.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/style.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/top.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/JS/UserDetailedInfo/StoreList.css" rel="stylesheet"/>
    
    <script src="/static/myindex/Content/JS/Home/Index.js" type="text/javascript"></script>
    <script type="text/javascript" src="/static/js/index.js"></script>
    
    <style type="text/css">
        body {
            min-width: 1250px;
            overflow-x: auto;
        }
        
        #main {
            margin: 0;
            padding: 0;
            overflow: visible;
        }
        
        .pageTop {
            height: 45px;
            background: #FFFFFF;
        }
        
        .pageBottom {
            height: 30px;
            color: #dadada;
            line-height: 30px;
            text-align: center;
            color: #dadada;
            background: #393939;
            font-size: 12px;
            width: 100%;
        }
        
        .l-layout-left {
            border: 0px;
        }
        
        .l-layout-center {
            border: 0px;
        }
        
        .l-layout-bottom {
            border-left: 0px;
            border-top: 0px;
        }
        
        .l-layout-header {
            height: 28px;
            background: #393939;
        }
        
        div [position="left"] {
            background: #323232;
        }
        
        .tip {
            position: absolute;
            top: 25px;
            left: -13px;
            z-index: 10000;
            border: 1px solid #FFC340;
            width: 150px;
            height: 20px;
            line-height: 20px;
            padding-left: 5px;
            background-color: #FFFCC7;
            border-radius: 5px;
            display: none;
            text-align: center;
            color: red;
        }
        
        .tip1 {
            position: absolute;
            z-index: 10000;
            border: 1px solid #FFC340;
            line-height: 20px;
            padding: 8px;
            background-color: #FFFCC7;
            border-radius: 5px;
            display: none;
            color: #F00;
            right: 115px;
        }
    </style>
    
    <script type="text/javascript">
        $(function() {
            $("#weixin").on("mouseover mouseout", function (event) {
                if (event.type == "mouseover") {
                    $("#tip1").css("display", "block");
                } else if (event.type == "mouseout") {
                    $("#tip1").css("display", "none");
                }
            })
        })
    </script>
</head>


<body>
<div class="pageTop">
    <div class="head">
        <div class="top_left">
            <img src="/static/myindex/Content/icon/logo_gl.png"/>
        </div>
        <div class="top_right">
            <a href="#">当前用户:<shiro:principal property="username"/></a>&nbsp;&nbsp;
            <span class="wc">|</span>&nbsp;&nbsp;
            <span id="weixin" style="cursor: pointer">微信二维码</span><span id="tip1" class="tip1">
                    <img style="position: absolute; top: -8px; left: 60px; width: 15px;"
                         src="/static/myindex/Images/ud/jj.png">
                    <img src="/static/myindex/gc.png" width="130"/>
            </span>&nbsp;&nbsp;
            <span class="wc">|</span>&nbsp;&nbsp;
            <span id="day_day"></span>&nbsp;&nbsp;
            <!-- 用户注销 -->
            <span class="wc">|</span>&nbsp;&nbsp;
            <a href="/logout" onclick="return confirm('确定要退出系统吗？');">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
    </div>
</div>
<div id="main" style="width: 99.9%">
    <input type="hidden" id="sess" value="小黑"/>
    <div class="left" position="left" style="overflow-y: auto;bottom:29px; ">
        <div id="nav">
            <div onclick="addtab('会员管理','会员管理','/member_view.do');">
                <img src="static/png/hygl.png"/><a style="float:left;" href="#">会员管理</a>
            </div>
            <div onclick="addtab('收银管理','收银管理','/checkstand.do');">
                <img src="/static/png/sygl.png"/><a style="float:left;" href="#">收银管理</a>
            </div>
            <div onclick="addtab('宠物服务','宠物服务','/pet.do');">
                <img src="/static/png/cwff.png"/><a style="float:left;" href="#">宠物服务</a>
            </div>
            <div onclick="addtab('库存管理','库存管理','/stockIndex.do');">
                <img src="/static/png/kcgl.png"/><a style="float:left;" href="#">库存管理</a>
            </div>
            <%--<div onclick="addtab('短信平台','短信平台','');" >
                <img src="/static/png/dxpt.png" /><a style="float:left;" href="#">短信平台</a>
                    </div>--%>


            <div onclick="addtab('报表分析','报表分析','/PriceTotalIndex.do');">
                <img src="/static/png/bbfx.png"/><a style="float:left;" href="#">报表分析</a>
            </div>
           
            
            <!--  菜单权限 -->
            <shiro:hasPermission name="employee:view">
            <div onclick="addtab('员工管理','员工管理','/employeeIndex.do');">
                <img src="/static/png/yggl.png"/><a style="float:left;" href="#">员工管理</a>
            </div>
            </shiro:hasPermission>
            
            <div onclick="addtab('系统设置','系统设置','/systemSet.do');">
                <img src="/static/png/xtsz.png"/><a style="float:left;" href="#">系统设置</a>
            </div>
        </div>
    </div>
    
    <div position="center" id="framecenter" style="overflow-y: auto;">
        <div tabid="home" title="我的主页" lselected="true">
            <iframe frameborder="0" name="showmessage" src="/principalSheet.do" class="frameindex"></iframe>
        </div>
        
        <marquee direction="left" onmouseover="this.stop()" onMouseout="this.start()"
                 onclick="top.f_addTab('home');" style="margin-top: 3px; width: 280px; height: 20px; position: absolute;
             right: 120px; top: 2px; opacity: 0.5; z-index: 99999;">
            <!-- 引入天气 -->
            <iframe class="wc" width="280" align="right" scrolling="no" height="20" frameborder="0"
                    allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=34&icon=1&num=3"></iframe>
        
        </marquee>
        
        <img style="position: absolute; right: 20px; top: 2px; opacity: 0.5; z-index: 99999; cursor: pointer"
             src="/static/myindex/Content/icon/home.png" onclick="top.f_addTab('home');">
    </div>
    
    <div position="bottom" class="pageBottom">版权所有Copyright ©2013-2017 白牙宠物</div>
</div>
</body>
<script type="text/javascript">
    
    //动态加载当前日期
    setInterval(function loadDate() {
        var time = new Date();
        var myYear = time.getFullYear();
        var myMonth = time.getMonth() + 1;
        var myDay = time.getDate();
        if (myMonth < 10) {
            myMonth = "0" + myMonth;
        }
        var myHour = time.getHours();
        if (myHour<10){
            myHour = "0"+myHour;
        }
        var myMinute = time.getMinutes();
        if (myMinute < 10){
            myMinute = "0" +myMinute;
        }
        var mySecond = time.getSeconds();
        if (mySecond < 10){
            mySecond = "0" + mySecond;
        }
        
        document.getElementById("day_day").innerHTML =
                myYear + "." + myMonth + "." + myDay + "  " + myHour + ":" + myMinute + ":" + mySecond;
    }, 1000);

</script>


</html>
