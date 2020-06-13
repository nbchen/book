<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>十指弹奏会员注册页面</title>
    <%--静态文件,包含base标签,css样式,jQuery文件--%>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {

            // ajax校验用户名是否可用
            $("#username").blur(function () {
                // 1.获取用户名
                var username = this.value
                $.getJSON("${basePath}/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
                    console.log(data)
                    if (data.isExist) {
                        $("span.errorMsg").text("用户名已存在!");
                    } else {
                        $("span.errorMsg").text("用户名可用!");
                    }
                })
            });

            $("#code_img").click(function () {
                // 发起验证码的请求,并加上时间戳,避免缓存
                this.src = "${basePath}/kaptcha.jpg?d="+new Date().getTime();
            });

            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1 获取用户名输入框的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户不合法!");
                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1 获取密码输入框的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法!");
                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码输入框的内容
                var repwdText = $("#repwd").val();
                if (repwdText !== passwordText) {
                    //2 提示用户结果
                    $("span.errorMsg").text("确认密码和密码不一致!");
                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱输入框的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                //3 使用test方法验证
                if (!emailPatt.test(emailText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("邮箱不合法!");
                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                //1 获取验证码输入框的内容,去除验证码前后的空格
                var codeText = $.trim($("#code").val());
                if (codeText == null || codeText === '') {
                    //2 提示用户结果
                    $("span.errorMsg").text("验证码不能为空!");
                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");
            });
        })
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.png">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册2</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册十指弹奏会员</h1>
                    <span class="errorMsg">
                        <%--<%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                               value="${username}"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                            value="${email}"
                        />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="width:154px;height:40px;float: right; margin-right: 49px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>