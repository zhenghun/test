<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/7/15
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="left-menu" class="col-md-3">
  <div class="panel-group" id="accordion2">
    <div class="panel panel-default">
      <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
        <a class="accordion-toggle"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>test1</a>
      </div>
      <div id="collapseOne" class="panel-collapse in" style="height: auto;">
        <div class="panel-body"><span class="func" datatype="html" dataLink="${pageContext.request.contextPath}/index.jsp" target="mainFrame">test home</span></div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
        <a class="accordion-toggle"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>数据库</a>
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
        <a class="accordion-toggle"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>健康养生</a>
      </div>
      <div id="collapseThree" class="panel-collapse collapse" style="height: 0px;">
        <div class="panel-body">说起食物我们每天都离不开</div>
      </div>
    </div>
  </div>
</div>
