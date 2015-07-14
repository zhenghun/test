<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <header>
        <title>${pageContext.request.contextPath}</title>
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/test.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/jerichotab/css/jquery.jerichotab.css" rel="stylesheet"/>
    </header>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <span class="navbar-brand">Test 快速开发平台</span>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#" >我的面板</a></li>
                        <li><a href="#" >在线办公</a></li>
                        <li><a href="#" >内容管理</a></li>
                        <li><a href="#" >系统设置</a></li>
                        <li><a href="#" >代码生成</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="" ></a>
                        </li>
                        <li>
                            <a href="" ></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" title="个人信息">
                                你好！
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="" target="mainFrame">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        个人信息
                                    </a>
                                </li>
                                <li>
                                    <a href="" target="mainFrame">
                                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        修改密码
                                    </a>
                                </li>
                                <li>
                                    <a href="" target="mainFrame">
                                        <span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
                                        我的消息
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="">退出</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div id="body" class="row">
                <div id="left" style="width:200px">
                    <div class="panel-group" id="accordion2">
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                <a class="accordion-toggle">test1</a>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                                <div class="panel-body">test2</div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                                <a class="accordion-toggle">数据库</a>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse" style="height: 0px;">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="#">SQL基础</a></li>
                                        <li><a href="#">Oracle</a></li>
                                        <li><a href="#">MySQL</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                                <a class="accordion-toggle">健康养生</a>
                            </div>
                            <div id="collapseThree" class="panel-collapse in" style="height: auto;">
                                <div class="panel-body">说起食物我们每天都离不开</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="switchBar" class="open"></div>
                <div id="content">
                    <iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
                </div>
            </div>
            <div id="footer" class="row">
                Copyright © 2015-2020 test 快速开发平台 - Powered By <a href="" target="_blank">test</a> V1.0.0-SNAPSHOT
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/resources/common/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/test.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/jerichotab/js/jquery.jerichotab.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(window).resize(function(){
                console.log(getWSize());
            });

        </script>
    </body>
</html>
