<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册</title>
    <%@include file="/static/common/common.jsp" %>
    <link href="/static/plugins/login/register/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/plugins/login/register/css/gloab.css" rel="stylesheet">
    <link href="/static/plugins/login/register/css/index.css" rel="stylesheet">
    <script src="/static/plugins/login/register/js/jquery-1.11.1.min.js"></script>
    <script src="/static/plugins/login/register/js/register.js"></script>
    <script type="text/javascript" src="/static/js/area.js"></script>

     <%--   <script type="text/javascript">
        var Gid  = document.getElementById ;
        var showArea = function(){
            Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +
                Gid('s_city').value + " - 县/区" +
                Gid('s_county').value + "</h3>"
        }
        Gid('s_county').setAttribute('onchange','showArea()');
    </script>--%>



</head>
<body class="bgf4">

<form method="post"   id="shortForm" enctype="multipart/form-data">
    <div class="login-box f-mt10 f-pb50">
        <div class="main bgf">
            <div class="reg-box-pan display-inline">
                <%--动态导航条--%>
                <div class="step">
                    <ul>
                        <li class="col-xs-4 on">
                            <span class="num"><em class="f-r5"></em><i>1</i></span>
                            <span class="line_bg lbg-r"></span>
                            <p class="lbg-txt">填写账户信息</p>
                        </li>
                        <li class="col-xs-4">
                            <span class="num"><em class="f-r5"></em><i>2</i></span>
                            <span class="line_bg lbg-l"></span>
                            <span class="line_bg lbg-r"></span>
                            <p class="lbg-txt">验证账户信息</p>
                        </li>
                        <li class="col-xs-4">
                            <span class="num"><em class="f-r5"></em><i>3</i></span>
                            <span class="line_bg lbg-l"></span>
                            <p class="lbg-txt">注册成功</p>
                        </li>
                    </ul>
                </div>


                <div class="reg-box" id="verifyCheck" style="margin-top:20px;">
                    <div class="part1">
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">登入名：</span>
                            <div class="f-fl item-ifo">
                                <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1"
                                       data-valid="isNonEmpty||between:3-20||isUname"
                                       data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="username"
                                       name="username"/> <span
                                    class="ie8 icon-close close hide"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
                                <label class="focus valid"></label>
                            </div>
                        </div>

                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>
                            <div class="f-fl item-ifo">
                                <input type="password" id="password" name="possword" maxlength="20"
                                       class="txt03 f-r3 required"
                                       tabindex="3" style="ime-mode:disabled;" onpaste="return  false"
                                       autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2"
                                       data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合"/>
                                <span class="ie8 icon-close close hide" style="right:55px"></span>
                                <span class="showpwd" data-eye="password"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
                                <label class="focus valid"></label>
                                <span class="clearfix"></span>
                                <label class="strength">
                                    <span class="f-fl f-size12">安全程度：</span>
                                    <b><i>弱</i><i>中</i><i>强</i></b>
                                </label>
                            </div>
                        </div>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>
                            <div class="f-fl item-ifo">
                                <input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="4"
                                       style="ime-mode:disabled;" onpaste="return  false" autocomplete="off"
                                       data-valid="isNonEmpty||between:6-16||isRepeat:password"
                                       data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword"/>
                                <span class="ie8 icon-close close hide" style="right:55px"></span>
                                <span class="showpwd" data-eye="rePassword"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus">请再输入一遍上面的密码</label>
                                <label class="focus valid"></label>
                            </div>
                        </div>
                        <%--店铺名--%>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">店铺名：</span>
                            <div class="f-fl item-ifo">
                                <input type="text" name="storeName" maxlength="20" class="txt03 f-r3 required"
                                       tabindex="1"
                                       data-valid="isNonEmpty||between:3-20||isUname"
                                       data-error="店铺名不能为空||店铺长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="storeName"/> <span
                                    class="ie8 icon-close close hide"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
                                <label class="focus valid"></label>
                            </div>
                        </div>
                        <%--店主姓名--%>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">店主姓名：</span>
                            <div class="f-fl item-ifo">
                                <input type="text" name="storehead" maxlength="20" class="txt03 f-r3 required"
                                       tabindex="1" id="storehead"
                                       data-valid="isNonEmpty||between:3-20||isUname"
                                       data-error="店主姓名不能为空||店主长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" /> <span
                                    class="ie8 icon-close close hide"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
                                <label class="focus valid"></label>
                            </div>
                        </div>
                        <%--店铺地址--%>

                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">店铺地址：</span>

                            <select id="s_province" name="s_province" class="txt-m fl" style="width:85px;padding-left:3px">
                                <option>省份</option>
                            </select>
                            <select id="s_city" name="s_city" class="txt-m fl" style="width:auto;padding-left:3px">
                                <option>地级市</option>
                            </select>
                            <select id="s_county" class="txt-m fl" style="width:auto;padding-left:3px">
                                <option>市、县级市、县</option>
                            </select>
                            <script type="text/javascript">_init_area();</script>

                            <input id="StoreAddress" name="StoreAddress" style="margin-top:5px;width:200px"/>

                        </div>


                        <%--验证密码--%>
                      <%--  <div class="item col-xs-12">
                            <span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>
                            <div class="f-fl item-ifo">
                                <input type="text" maxlength="4" class="txt03 f-r3 f-fl required" tabindex="4"
                                       style="width:167px" id="randCode" data-valid="isNonEmpty" data-error="验证码不能为空"/>
                                <span class="ie8 icon-close close hide"></span>
                                <label class="f-size12 c-999 f-fl f-pl10">
                                    <img src="images/yzm.jpg"/>
                                </label>
                                <label class="icon-sucessfill blank hide" style="left:380px"></label>
                                <label class="focusa">看不清？<a href="javascript:;" class="c-blue">换一张</a></label>
                                <label class="focus valid" style="left:370px"></label>
                            </div>
                        </div>--%>
                        <div class="item col-xs-12" style="height:auto">
                            <span class="intelligent-label f-fl">&nbsp;</span>
                            <p class="f-size14 required" data-valid="isChecked" data-error="请先同意条款">
                                <input type="checkbox" checked/><a href="javascript:showoutc();"
                                                                   class="f-ml5">我已阅读并同意条款</a>
                            </p>
                            <label class="focus valid"></label>
                        </div>

                        <%--第一个下一步按钮--%>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">&nbsp;</span>
                            <div class="f-fl item-ifo">
                                <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">下一步</a>
                            </div>
                        </div>

                    </div>


                    <%--第二页--%>
                    <div class="part2" style="display:none">
                        <div class="alert alert-info" style="display:none" id="dentifyingCode" style="width:700px">短信已发送至您手机，请输入短信中的验证码，确保您的手机号真实有效。</div>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>
                            <div class="f-fl item-ifo">
                                <input type="text" name="contactmobile" class="txt03 f-r3 required" keycodes="tel"
                                       tabindex="2"
                                       data-valid="isNonEmpty||isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11"
                                       id="phone"/>
                                <span class="ie8 icon-close close hide"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus">请填写11位有效的手机号码</label>
                                <label class="focus valid"></label>
                            </div>
                        </div>
                      <div class="item col-xs-12">
                            <span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>
                            <div class="f-fl item-ifo">
                                <input type="text" maxlength="6" id="verifyNo" class="txt03 f-r3 f-fl required"
                                       tabindex="4" style="width:167px" data-valid="isNonEmpty||isInt"
                                       data-error="验证码不能为空||请输入6位数字验证码"/>
                                <span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled
                                      style="width:97px;display:none;">发送验证码</span>
                                <span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz"
                                      style="width:97px;">发送验证码</span>
                                <span class="ie8 icon-close close hide" style="right:130px"></span>
                                <label class="icon-sucessfill blank hide"></label>
                                <label class="focus"><span>请查收手机短信，并填写短信中的验证码（此验证码3分钟内有效）</span></label>
                                <label class="focus valid"></label>
                            </div>
                        </div>

                        <%--第二个注册按钮--%>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">&nbsp;</span>
                            <div class="f-fl item-ifo">
                                <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">注册</a>
                            </div>
                        </div>
                    </div>


                    <div class="part3" style="display:none">

                        <div class="inputsec">
                            <ul>
                                <li>
                                    <label class="fl mr2">主营项目：</label>
                                    <div class="fl" style="position: relative; z-index: 102; width: 600px;">
                                        <input type="radio" name="businesstype"  value="1"/>
                                        宠物商店&nbsp;
                                        <input type="radio" name="businesstype"  value="2"/>
                                        宠物学校&nbsp;
                                    </div>
                                </li>
                                <li>
                                    <label class="fl mr2">店铺誓言：</label>
                                    <textarea rows="6" cols="40" id="StoreIntroduce" name="storintroduce"
                                             id="storintroduce"  class="textarea fl"></textarea>
                                </li>
                                <%--<li>
                                    <label class="fl mr2">店铺照片：</label>
                                    <div class="fl sc_photo">
                                        <img id="uploadPreview" src="/Images/Temp/fm_default.png"/>
                                        <input type="file" class="sc_btn" id="uploadImage" onchange="loadImageFile();"
                                               style="filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0; position: absolute; left: 0px; top: 0px; width: 88px; height: 88px;"/>
                                    </div>
                                </li>--%>
                            </ul>
                        </div>


                        <%--最后提交按钮--%>
                        <div class="item col-xs-12">
                            <span class="intelligent-label f-fl">&nbsp;</span>
                            <div class="f-fl item-ifo">
                                <input   onclick="inputFrom()"  value="提交" class="btn btn-blue f-r3" <%--id="btn_part3"--%>  ></input>
                            </div>
                            <span class="intelligent-label f-fl">&nbsp;</span>
                            <div class="f-fl item-ifo">
                                <a href="javascript:inputFrom();" class="btn btn-blue f-r3" id="btn_part4">跳过此次</a>
                            </div>
                        </div>
                    </div>
                    <div class="part4 text-center" style="display:none">
                        <h3>恭喜您，您已注册成功，现在开始您的遛狗之旅吧！</h3>
                        <p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a
                                href="/login.jsp" class="c-blue">用户中心</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<div class="m-sPopBg" style="z-index:998;"></div>

<%--同意条款弹窗--%>
<div class="m-sPopCon regcon">
    <div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b>
    </div>
    <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
    </div>
    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3"
               href="javascript:closeClause();">已阅读并同意此条款</a></center>
</div>
</body>
</html>
