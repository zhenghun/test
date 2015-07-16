<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<header>
    <title>Test平台 登录</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet"/>
</header>
<body>
    <a href="findAll.do">go to</a>
    <div style="height: 80px;padding-top: 20px;">
        <div id="messageBox" class="alert alert-error hide" style="display: none;"><button data-dismiss="alert" class="close">×</button>
            <label id="loginError" class="error"></label>
        </div>
    </div>
    <h1 class="form-signin-header">Test 快速开发平台</h1>
    <div class="container" style="text-align: left">
        <form class="form-signin" method="post" id="loginForm" action="#" role="form">
            <h2>登录</h2>
            <div class="form-group">
                <div>
                    <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username" minlength="5"  required message="请输入"/>
                    <span class="help-block"></span>
                </div>
            </div>
            <div class="form-group">
                <div>
                    <input type="text" class="form-control" id="password" placeholder="请输入密码" name="password" minlength="5" required/>
                    <span class="help-block"></span>
                </div>
            </div>
            <div class="form-group">
                <div>
                    <label>
                        <input type="checkbox"> 记住我
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div>
                    <button type="submit" class="btn btn-primary btn-lg btn-block" id="submitBtn">登录</button>
                </div>
            </div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/resources/common/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/jquery-validation-1.14.0/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $("#form1").validate({
            rules:{
                validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
            },
            messages:{
                usernmae:{required:"请填写登录名"},
                password:{required:"请填写密码"},
                validateCode:{remote:"验证码不正确", required:"请填写验证码"}
            }
        });
    </script>
</body>
</html>
