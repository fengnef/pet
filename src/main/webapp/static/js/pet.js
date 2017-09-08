//显示列表
$(function () {
    $('#petService').datagrid({
        url: '/pet_listAll.do',
        striped: true,
        fit: true,
        halign: 'center',
        align: 'center',
        pagination: true,
        singleSelect: true,
        columns: [[
            {field: 'ck', checkbox:true},
            {field: 'petname', title: '宠物名'},
            {field: 'member.membername', title: '主人名', formatter: membernameFormatter},
            {field: 'member.membernumber', title: '联系方式',  formatter: membernumberFormatter},
            {field: 'serivceitem.text', title: '服务项目',  formatter: servicenameFormatter},
            {field: 'serivceitem.servicestatus', title: '当前状态',  formatter: servicestatusFormatter},
            {field: 'serivceitem.pay', title: '是否付款',  formatter: payFormatter},
            {field: 'serivceitem.begintime', title: '实际开始时间',  formatter: begintimeFormatter},
            {field: 'serivceitem.endtime', title: '实际结束时间',  formatter: endtimeFormatter},
            {field: 'serivceitem.fostertime', title: '寄养时间/剩余次数', formatter: fostertimeFormatter},
            {field: 'serviceitem.costprice', title: '服务价格',  formatter: costpriceFormatter},
            {field: 'serivceitem.advancepayment', title: '预付款项',  formatter: advancepaymentFormatter},
            {field: 'serivceitem.retainage', title: '尾款',  formatter: retainageFormatter},
            {field: 'login', title: '日志', width: 60, formatter: loginFormatter}
        ]],
        //右击显示菜单按钮
        onRowContextMenu:function(e, rowIndex, rowData){
            e.preventDefault();
            // 显示快捷菜单
            $('#register_menu').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        },
        onLoadSuccess: function (data) {
            //固定列高度
            $('#petService').datagrid('fixRowHeight');
            $('#petService').datagrid('autoSizeColumn');
            $("a[name='opera']").linkbutton({text: '查看', plain: true, iconCls: 'icon-search'});

        },
        resizeHandle: 'right',
        selectOnCheck:false,
        checkOnSelect:true
    });
    //日志数据
    $('#datagrid_login').datagrid({
        fitColumns: true,
        striped: true,
        fit: true,
        halign: 'center',
        align: 'center',
        pagination: true,
        singleSelect: true,
        columns:[[
            {field:'dateTime',title:'时间',width:100,editor:'datebox'},
            {field:'code',title:'记录',width:100,editor:'text'},
            {field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:''}}}
        ]],
        onClickCell: onClickCell
    });


    // 会员名称格式化
    function membernameFormatter(value, row, index) {
        if (row.member) {
            return row.member['membername'];
        }
        return "";
    }

    // 会员电话格式化
    function membernumberFormatter(value, row, index) {
        if (row.member) {
            return row.member['membernumber'];
        }
        return "";
    }
    // 服务项目名称格式化
    function servicenameFormatter(value, row, index) {
        if (row.serviceitem) {
            return row.serviceitem['text'];
        }
        return "";
    }
    // 服务状态格式化
    function servicestatusFormatter(value, row, index) {
        if (row.serviceitem) {
            if(row.serviceitem['servicestatus']=="进行中" || row.serviceitem['servicestatus']=="未付款"){
            return "<span style='color: red'>"+row.serviceitem['servicestatus']+"</span>";
            }else if(row.serviceitem['servicestatus']=="等待中"){
                return "<span style='color: blue'>"+row.serviceitem['servicestatus']+"</span>";
            }else if(row.serviceitem['servicestatus']=="已结束"){
                return "<span style='color: green'>"+row.serviceitem['servicestatus']+"</span>";

            }else if(row.serviceitem['servicestatus']=="已取消"){
                return "<span style='color: grey'>"+row.serviceitem['servicestatus']+"</span>";
            }
        }
        return "";
    }
    // 付款状态格式化
    function payFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['pay']?"<span style='color: red'>"+"未付款"+"</span>":"<span style='color: green'>"+"已付款"+"</span>";
        }
    }
    // 开始时间格式化
    function begintimeFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['begintime'];
        }else{
            return "";
        }
    }
    // 结束时间格式化
    function endtimeFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['endtime'];
        }else{
            return "";
        }
    }
    // 寄养时间格式化
    function fostertimeFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['fostertime'];
        }else{
            return "";
        }
    }
    // 服务价格格式化
    function costpriceFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['costprice'];
        }else{
            return "";
        }
    }
    // 预付款项格式化
    function advancepaymentFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['advancepayment'];
        }else{
            return "";
        }
    }
    // 尾款格式化
    function retainageFormatter(value, row, index) {
        if(row.serviceitem){
            return row.serviceitem['retainage'];
        }else{
            return "";
        }
    }



    //状态格式化消费记录
    function loginFormatter(value, row, index) {
        var h = "";
        h += "<a name='opera' id='emp_tb_login"+"'  onclick='login(" + index + ")' ></a> ";
        return h;
    }
    //服务对话框
    $('#service_dialog').dialog({
        title: '添加新项目',
        width: 400,
        height: 400,
        buttons: '#service_btns',
        closed: true
    });
    //宠物登记对话框
    $('#pet_dialog').dialog({
        title: '宠物登记',
        width: 700,
        height: 500,
        buttons: '#pet_btns',
        closed: true
    });
    //日志对话框
    $('#register_login').dialog({
        title: '打印日志',
        width: 700,
        height: 500,
        closed: true
    });
    //添加记录对话框
    $('#dialog_addData').dialog({
        title: '添加新记录',
        width: 400,
        height: 300,
        buttons: '#login_btns',
        closed: true
    });
    //打印对话框
    $('#dialog_print').dialog({
        title: '打印',
        width: 400,
        height: 300,
        closed: true
    });
    //训练项目对话框
    $('#dialog_class').dialog({
        title: '提示',
        width: 200,
        height: 200,
        closed: true
    });
    //点击树节点
   $('#service_tree').tree({
        onClick: function (node) {
            //清空表单
            $('#service_form').form("clear");
            $('#petServerID').combobox("setValue", node.id);
            //高级查询
            searchForm(node);
        }
    });
    // 右键点击节点并显示快捷菜单
    $('#service_tree').tree({
        onContextMenu: function(e, node){
            e.preventDefault();
             // 查找节点
             $('#service_tree').tree('select', node.target);
            // 显示快捷菜单
            $('#service_menu').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        }
    });


    //单元格的编辑行
    $.extend($.fn.datagrid.methods, {
        editCell: function(jq,param){
            return jq.each(function(){
                var opts = $(this).datagrid('options');
                var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
                for(var i=0; i<fields.length; i++){
                    var col = $(this).datagrid('getColumnOption', fields[i]);
                    col.editor1 = col.editor;
                    if (fields[i] != param.field){
                        col.editor = null;
                    }
                }
                $(this).datagrid('beginEdit', param.index);
                for(var i=0; i<fields.length; i++){
                    var col = $(this).datagrid('getColumnOption', fields[i]);
                    col.editor = col.editor1;
                }
            });
        }
    });
    var editIndex = undefined;
    function endEditing(){
        if (editIndex == undefined){return true}
        if ($('#datagrid_login').datagrid('validateRow', editIndex)){
            $('#datagrid_login').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
    function onClickCell(index, field){
        if (endEditing()){
            $('#datagrid_login').datagrid('selectRow', index)
                .datagrid('editCell', {index:index,field:field});
            editIndex = index;
        }
    }
})

$(function () {
    /*初始化树组件*/
    $("#service_tree").tree({
        url: "/serviceitem_list.do"
    })
})
//添加服务项目
function addService() {
    $("#service_dialog").dialog("open");
}
//添加宠物登记
function petRigister() {
    $("#petRegister_form").form("clear");
    $("#pet_dialog").dialog("open");
    //宠物服务二级菜单显示
    $('#petServer').combobox({
        url: '/serviceitem_list.do',
        valueField: 'id',
        textField: 'text',
        onSelect: function (data) {
            data = data['children'];
            var json = '';
            for (i = 0; i < data.length; i++) {
                if (i == 0) {
                    json = json + "[{'id':" + data[i].id + ",'text':'" + data[i].text + "'}";
                } else {
                    json = json + ",{'id':" + data[i].id + ",'text':'" + data[i].text + "'}";
                }
            }
            json = json + ']';
            json = eval("(" + json + ")");
            $('#cihldrenServer').combobox({
                //使用data接受
                data: json,
                valueField: 'id',
                textField: 'text'
            })
        }
    });
    //宠物类别二级联动显示
    var url = '/category_listAll.do';
    $.getJSON(url, function (json) {
        $('#category').combobox({
            data: json,
            valueField: 'id',
            textField: 'petcategoryname',
            onSelect: function (data) {
                $('#breed').combobox({
                    url: '/selectBreedByCategoryId.do?id=' + data.id,
                    valueField: 'id',
                    textField: 'petbreedname',
                })
            }
        });
    });
}
//取消服务框按钮
function cancel() {
    $('#service_dialog').dialog("close");
}
//取消宠物框按钮
function cancelPetRegister() {
    $('#pet_dialog').dialog("close");
}
//取消添加记录框按钮
function cancelLogin() {
    $('#login_dialog').dialog("close");
}
//保存服务按钮
function save() {
    // id
    var url = "/serviceitem_save.do";
    // 提交表单
    $('#service_form').form('submit', {
        url: url,
        onSubmit: function (param) {
            //获取下拉框的值
            var id = $("#petServerID").combobox("getValue");
        },
        success: function (data) {
            // 转成json对象
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#pet_dialog").dialog("close");
                    // 刷新数据表格(保持在当前页)
                    window.location.href = "/pet.do"
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }
    });
}
//保存宠物登记按钮
function savePetRegister() {
    // id
    var url = "/petAndMemberAndServiceitem_save.do";
    // 提交表单
    $('#petRegister_form').form('submit', {
        url: url,
        success: function (data) {
            // 转成json对象
            data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#pet_dialog").dialog("close");
                    // 刷新数据表格(保持在当前页)
                    window.location.href = "/pet.do"
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }
    });
}


//保存添加记录按钮
function saveLogin() {
    // 提交表单
    $.ajax({
        url: "/addData_save.do",
        success: function (data) {
            // 转成json对象
            //data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    //var time = $("[name='Time']").datebox('getValue');
                    var serviceNote = $("[name='ServiceNote']").val();
                    // 关闭弹出框
                    $("#dialog_addData").dialog("close");
                    $('#datagrid_login').datagrid('appendRow',{
                        dateTime: new Date().toLocaleDateString(),
                        code: serviceNote
                    });
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }


    })
}
//加载日志
function login(index) {
    //清除所有行数据
    //获取当前页的记录数
    var item = $('#datagrid_login').datagrid('getRows');
    for (var i = item.length - 1; i >= 0; i--) {
        var index = $('#datagrid_login').datagrid('getRowIndex', item[i]);
        $('#datagrid_login').datagrid('deleteRow', index);
    }
    if(index){
        $('#petService').datagrid("selectRow",index);
        var rowData = $('#petService').datagrid("getSelected");
    $("#petNamel").html(rowData.petname);
    $("#petVarietiesNamel").html("大型犬");
    $("#PetItemsl").html("遛狗求");
    $("#PetSpecialNotel").html("好好服侍");
    $("#petAgel").html(12);
    $("#ExpectStartTimeStringl").html(rowData["serviceitem"].begintime);
    $("#ExpectEndTimeStringl").html(rowData["serviceitem"].endtime);
        rowData.petgender?$("#sexl").html("弟弟"):$("#sex").html("妹妹");
    //打开日志对话框
    $('#register_login').dialog("open");
        $('#datagrid_login').datagrid('appendRow',{
            dateTime: '2017/8/27 20:07:00',
            code: '宠物登记'
        });
    }
}
//添加记录
function addData(){
    $("#addData_form").form("clear");
    $('#dialog_addData').dialog("open");
}
//打印
function print(){
    var petNamel = $("#petNamel").html();
    var petVarietiesNamel = $("#petVarietiesNamel").html();
    var PetItemsl = $("#PetItemsl").html();
    var PetSpecialNotel = $("#PetSpecialNotel").html();
    var petAgel = $("#petAgel").html();
    var ExpectStartTimeStringl = $("#ExpectStartTimeStringl").html();
    var ExpectEndTimeStringl = $("#ExpectEndTimeStringl").html();
    var sexl = $("#sexl").html();
    $("#petNamep").html(petNamel);
    $("#petVarietiesNamep").html(petVarietiesNamel);
    $("#PetItemsp").html(PetItemsl);
    $("#PetSpecialNotep").html(PetSpecialNotel);
    $("#petAgep").html(petAgel);
    $("#ExpectStartTimeStringp").html(ExpectStartTimeStringl);
    $("#ExpectEndTimeStringp").html(ExpectEndTimeStringl);
    $("#sexp").html(sexl);
    $('#dialog_print').dialog("open");
}
// 菜单高级查询
function searchForm(node) {
    // 获取关键字文本框的值
    var petNameQuery = $("[name='petNameQuery']").val();
    var telQuery = $("[name='telQuery']").val();
    var statusQuery = $('#statusQuery').combobox('getValue');
    var menuIdQuery = node.text;
    $("#petService").datagrid('load', {
        petNameQuery: petNameQuery,
        telQuery:telQuery,
        statusQuery:statusQuery,
        menuIdQuery:menuIdQuery
    });
}
// 条件高级查询
function searchForm1() {
    // 获取关键字文本框的值
    var petNameQuery = $("[name='petNameQuery']").val();
    var telQuery = $("[name='telQuery']").val();
    var statusQuery = $('#statusQuery').combobox('getValue');
    $("#petService").datagrid('load', {
        petNameQuery: petNameQuery,
        telQuery:telQuery,
        statusQuery:statusQuery
    });
}
// 查询全部数据
function reload() {
    // 清空查询条件的内容
    $("[name='petNameQuery']").val('');
    $("[name='telQuery']").val('');
    $("#statusQuery").combobox("setValue","");
    $('#service_tree').tree("uncheck");
    $("#petService").datagrid('load', {});
}
//付款
function petPay(){
    window.location.href='/checkstand.do';
}
//训练课程
function addClass(){
    $("#dialog_class").dialog("open");
}
//进行中
function runSerivce(){
    var row = $('#petService').datagrid("getSelected");
    var id = row['serviceitem'].id;
    $.post(
            "/serviceitem_changeStatus.do",
        {
            statusId:id
        },
        function(data){
            // 转成json对象
            //data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#pet_dialog").dialog("close");
                    // 刷新数据表格(保持在当前页)
                    window.location.href = "/pet.do"
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }

    )
}
//已结束
function endSerivce(){
    var row = $('#petService').datagrid("getSelected");
    var id = row['serviceitem'].id;
    $.post(
            "/serviceitem_endStatus.do",
        {
            statusId:id
        },
        function(data){
            // 转成json对象
            //data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#pet_dialog").dialog("close");
                    // 刷新行
                    $('#petService').datagrid("load");
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }

    )
}
//取消
function cancelSerivce(){
    var row = $('#petService').datagrid("getSelected");
    var id = row['serviceitem'].id;
    $.post(
            "/serviceitem_cancelStatus.do",
        {
            statusId:id
        },
        function(data){
            // 转成json对象
            //data = $.parseJSON(data);
            if (data.success) {
                $.messager.alert('温馨提示', data.msg, 'info', function () {
                    // 关闭弹出框
                    $("#pet_dialog").dialog("close");
                    // 刷新行
                    $('#petService').datagrid("load");
                });
            } else {
                $.messager.alert('温馨提示', data.msg, 'info');
            }
        }

    )
}
//根据会员号查询对应数据回显到弹框
function searchInfo(){
    var memberNumber = $("#Number").val();
   /* $.post('/pet_selectOneConectionData.do',{
        memberNumber:memberNumber
    },function(data){
        $("[name='serviceId']").combobox('setValue', data["serviceitem"].id);
        console.log(data["serviceitem"].id);
    })*/
   $.getJSON('/pet_selectOneConectionData.do?memberNumber='+memberNumber,function(json){
           var cildrenId = json["serviceitem"].id;
           var parentId = json["serviceitem"].parentId;
           var begintime = json["serviceitem"].begintime;
           var endtime = json["serviceitem"].endtime;
           var remark = json["serviceitem"].remark;
           var membername = json["member"].membername;
           var membernumber = json["member"].membernumber;
           var categoryId = json["category"].id;
           var breedId = json["breed"].id;
           var petname = json.petname;
           var petgender = json.petgender;
           $("#petServer").combobox("setValue", parentId);
           $("#cihldrenServer").combobox("setValue", cildrenId);
           $("#category").combobox("setValue", categoryId);
           $("#breed").combobox("setValue", breedId);
           $("[name='petname']").val(petname);
           $("[name='membername']").val(membername);
           $("#ExpectStartTime").datebox('setValue', begintime);
           $("#ExpectEndTime").datebox('setValue', endtime);
           $("[name='membernumber']").val(membernumber);
           $("[name='PetAge']").val(12);
           $("[name='Imprest']").val(20);
           $("[name='PetItems']").val("溜溜球");
           $("[name='remark']").val(remark);
   })
}