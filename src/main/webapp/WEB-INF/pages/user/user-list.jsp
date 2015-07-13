<%@ page import="com.xbzheng.model.UserInfo" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/7/10
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
  <%
    List<UserInfo> userInfo = (List<UserInfo>)request.getAttribute("userInfoList");
   // System.out.println(userInfo);
  %>
  ${userInfoList}
  <c:out value="aaaaaaaaaaaaa"/>
  <c:if test="${empty userInfoList}">
    Not user info in the database;
  </c:if>
asdasasdasds
  adasdasdasd
</body>
</html>
