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
                    <iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;display:none;border:1px solid red" scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
                </div>
            </div>
            <div class="row" id="footerContainer">
                <tiles:insertAttribute name="page_footer"/>
            </div>
        </div>
        <tiles:insertAttribute name="footer"/>
        <script type="text/javascript">
            function addTabPage(title, url, closeable, $this, refresh){
                top.$.fn.jerichoTab.addTab({
                    tabFirer: $this,
                    title: title,
                    closeable: closeable == undefined,
                    data: {
                        dataType: 'iframe',
                        dataLink: url
                    }
                }).loadData(refresh != undefined);
            }
            function addTab($this, refresh) {
                $(".jericho_tab").show();
                $("#mainFrame").hide();
                $.fn.jerichoTab.addTab({
                    tabFirer: $this,
                    title: $this.text(),
                    closeable: true,
                    data: {
                        dataType: 'iframe',
                        dataLink: $this.attr('href')
                    }
                }).loadData(refresh);
                return false;
            }
            $(".func").click();
            $(".func").mouseup(function(){
                return addTab($(this), true);
            });
        </script>
    </body>
</html>
