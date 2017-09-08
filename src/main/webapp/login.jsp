<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <title>后台管理登路</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- CSS -->
    <link rel="stylesheet" href="/static/plugins/login/css/supersized.css">
    <link rel="stylesheet" href="/static/plugins/login/css/login.css">
    <link href="/static/plugins/login/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Javascript -->
    <script src="/static/plugins/easyui/jquery.min.js"></script>

    <script src="/static/plugins/login/js/supersized.3.2.7.min.js"></script>
    <script src="/static/plugins/login/js/supersized-init.js"></script>
    <script src="/static/plugins/login/js/jquery.form.js"></script>
    <script src="/static/plugins/login/js/scripts.js"></script>

    <script type="text/javascript" src="/static/plugins/login/js/tooltips.js"></script>
    <script type="text/javascript" src="/static/plugins/login/js/login.js"></script>
    <script type="text/javascript" src="/static/plugins/login/js/jquery.form.js"></script>

</head>

<body>
<div class="page-container">
    <div class="main_box">
        <div class="login_box">
            <div class="login_logo">
                <img src="/static/plugins/login/images/logo.png" >
            </div>

            <div class="login_form">
                <form action="/login.do" id="login_form" method="post">
                    <div class="form-group">
                        <label for="j_username" class="t">账　号：</label>
                        <input id="email" value="clcl" name="username" type="text" class="form-control x319 in"
                               autocomplete="off" >
                    </div>
                    <div class="form-group">
                        <label for="j_password" class="t">密　码：</label>
                        <input id="password" value="12345" name="password" type="password"
                               class="password form-control x319 in">
                    </div>
                    <%--<div class="form-group">
                        <label for="j_captcha" class="t">验证码：</label>
                        <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
                      <img id="captcha_img" alt="点击更换" title="点击更换" src="images/captcha.jpeg" class="m">
                    </div>--%>
                    <div class="form-group">
                        <label class="t"></label>
                        <label for="j_remember" class="m">
                            <input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
                    </div>
                    <div class="form-group space">
                        <label class="t"></label>　　　
                        <button type="button"  id="submit_btn"
                                class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
                        <input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
                    </div>
                </form>
            </div>
        </div>
        <div class="mg">
            <div class=".form_reg_btn" >还没账号 <a href="/register.jsp">马上注册</a> <a href="#">忘记密码</a></div></div>
    </div>
</div>

</body>
</html>