function getWSize(){
    var height = window["innerHeight"] || document.compatMode === "CSS1Compat" && document.documentElement["clientHeight"] || document.body["clientHeight"];
    var width = window["innerWidth"] || document.compatMode === "CSS1Compat" && document.documentElement["clientWidth"] || document.body["clientWidth"];
    return [width, height];
}