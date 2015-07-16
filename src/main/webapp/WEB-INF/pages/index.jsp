<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
    <header>
        <title>${pageContext.request.contextPath}</title>
        <tiles:insertAttribute name="header"/>
    </header>
    <body>
        <div class="container-fluid" id="layout">
            <tiles:insertAttribute name="page_header"/>
            <div class="row" style="width:100%; height: 60px;"></div>
            <div class="row" id="bodyContainer">
                <tiles:insertAttribute name="left_menu"/>
                <div id="switchBar" class="close"></div>
                <div id="content" class="col-md-8">
                </div>
            </div>
            <div class="row" id="footerContainer">
                <tiles:insertAttribute name="page_footer"/>
            </div>
        </div>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
