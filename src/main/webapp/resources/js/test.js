var jericho = {
    buildTree: function(){
        $('span.func').css({ 'cursor': 'pointer' }).hover(function() {
            $(this).css({ 'color': '#3de', 'text-decoration': 'underline' });
        }, function() {
            $(this).css({ 'color': '#000', 'text-decoration': 'none' });
        }).click(function() {
            $.fn.jerichoTab.addTab({
                tabFirer: $(this),
                title: $(this).text(),
                closeable: true,
                iconImg: $(this).attr('iconImg'),
                data: {
                    dataType: $(this).attr('dataType'),
                    dataLink: $(this).attr('dataLink')
                }
            }).showLoader().loadData();
        });
    },
    buildTabpanel: function() {
        $.fn.initJerichoTab({
            renderTo: '#content',
            uniqueId: 'myJerichoTab',
            contentCss: { 'height': $('#content').height() - 50 },
            tabs: [{
                title: 'JeirchoTab',
                closeable: false,
                iconImg: 'images/jerichotab.png',
                data: { dataType: 'formtag', dataLink: '#tbNews' },
                onLoadCompleted: function(h) {
                    $('<b style="color:red" />').html('The JerichoTab processed in  milliseconds!').appendTo(h);
                }
            }],
            activeTabIndex: 0,
            loadOnce: true
        });
    }
}

var getWSize = function(){
    var height = window["innerHeight"] || document.compatMode === "CSS1Compat" && document.documentElement["clientHeight"] || document.body["clientHeight"];
    var width = window["innerWidth"] || document.compatMode === "CSS1Compat" && document.documentElement["clientWidth"] || document.body["clientWidth"];
    return [width, height];
};

$("#switchBar").on("click",function(){
    if($(this).hasClass("close")){//¹Ø±Õ
        $(this).addClass("open");
        $(this).removeClass("close");
        $("#left-menu").animate({width: 0, opacity: "hide"});
        $("#content").animate({width:$("#bodyContainer").width()-$("#switchBar").width()-10});
    }else{
        $(this).addClass("close");
        $(this).removeClass("open");
        $("#left-menu").animate({width: 230, opacity: "show"});
        $("#content").animate({width:$("#bodyContainer").width()-$("#switchBar").width()-240});
    }
});
$(document).ready(function(){
    var height = getWSize()[1];
    $("#left-menu").animate({width:230});
    $("#content").animate({width:$("#bodyContainer").width()-$("#switchBar").width()-240});
    $("#switchBar").height(height-100);
    $("#mainFrame").height(height-$("#footerContainer").height()-70);
    jericho.buildTree();
   jericho.buildTabpanel();
});

$(".panel-heading").click(function(){
    var iconObj = $($(this)[0].children[0].children[0]);
    if(iconObj.hasClass("glyphicon-chevron-right")){
        $(".glyphicon-chevron-down").addClass("glyphicon-chevron-right");
        $(".glyphicon-chevron-down").removeClass("glyphicon-chevron-down");
        iconObj.addClass("glyphicon-chevron-down");
        iconObj.removeClass("glyphicon-chevron-right");
    }else{
        iconObj.addClass("glyphicon-chevron-right");
        iconObj.removeClass("glyphicon-chevron-down");
    }
});
var resizeTimer = null;
$(window).on("resize", function(){
    if(resizeTimer){
        clearTimeout(resizeTimer);
    }
    resizeTimer = setTimeout(function(){
        var height = getWSize()[1];
        $("#content").animate({width:$("#bodyContainer").width()-$("#switchBar").width()-240});
        $("#mainFrame").height(height-$("#footerContainer").height()-70);
        $("#switchBar").height(height-100);
    },1000);
});

