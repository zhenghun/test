<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<header>
    <title>Test平台 登录</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet"/>
</header>
<body>
    <div style="height: 120px;padding-top: 20px;">
        <div id="messageBox" class="alert alert-error" style="display: none;"><button data-dismiss="alert" class="close">×</button>
            <label id="loginError" class="error"></label>
        </div>
    </div>
    <h1 class="form-signin-header">Test 快速开发平台</h1>
    <div class="container" style="text-align: left">
        <form class="form-signin" method="post" id="loginForm" action="${pageContext.request.contextPath}/sys/login" role="form">
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
                        <input type="checkbox" name="rememberMe"> 记住我
                    </label>
                    <label style="float: right;">
                        <input type="text" id="validateCode" name="validateCode" maxlength="5" placeholder="验证码" required style="font-weight:bold;width:50px;"/>
                        <img src="${pageContext.request.contextPath}/servlet/validateCodeServlet" class="validateImag"/>
                        <a href="javascript:" onclick="$('.validateImag').attr('src','${pageContext.request.contextPath}/servlet/validateCodeServlet?'+new Date().getTime());" style="vertical-align: middle; font-size: 9px;">看不清</a>
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
        $(document).ready(function(){
            $("#loginForm").validate({
                rules:{
                    validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
                },
                messages:{
                    username:{required:"请填写登录名",minlength:"最少5个字符"},
                    password:{required:"请填写密码", minlength:"最少5个字符"},
                    validateCode:{remote:"验证码不正确", required:"请填写验证码"}
                },
                errorLabelContainer: "#messageBox",
                errorPlacement: function(error, element) {
                    error.appendTo($("#loginError").parent());
                }
            });
            $("button[class='close']").click(function(){
                $("#messageBox label").remove();
                $("<label id=\"loginError\" class=\"error\" style=\"display: none;\"></label>").appendTo($("#messageBox"));
                $("#messageBox").css("display","none");
                return false;
            });
        });
    </script>
</body>
</html>
