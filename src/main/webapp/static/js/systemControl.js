$(function () {
    function addTabs(ele) {
        if ($("#index_tabs").tabs("exists",node.text)) {
            $("#index_tabs").tabs("select", node.text);
        } else {
            $("#index_tabs").tabs("add",{
                title:node.text,
                closable:true,
                content:""
            });
        }
    }
})