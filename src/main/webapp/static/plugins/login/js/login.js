// JavaScript Document
//支持Enter键登录
document.onkeydown = function (e) {
    if ($(".bac").length == 0) {
        if (!e) e = window.event;
        if ((e.keyCode || e.which) == 13) {
            var obtnLogin = document.getElementById("submit_btn");
            obtnLogin.focus();
        }
    }
}

$(function () {
    //提交表单
    $('#submit_btn').click(function () {
        show_loading();

        if ($('#email').val() == '') {
            show_err_msg('账号还没填呢！');
            $('#username').focus();
        } else if ($('#password').val() == '') {
            show_err_msg('密码还没填呢！');
            $('#password').focus();
        } else {
            //ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
                 $("form").submit();
             /*show_msg('登录成功咯！  正在为您跳转...');*/
        }
    });
});


/*
//登入错误消息提示
$(function () {
    //判断是否有错误信息
    var msg = '${errorMsg}';
    if (msg) {
        alert(msg);
    }
});
*/
