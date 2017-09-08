$(function () {
    //查询会员与宠物列表信息
    $("#MemberOut").datagrid({
        url: "/member_list.do",
        fit: true,
        fitColumns: true,
        striped: true,
        pagination: true,
        align: 'center',
        singleSelect: true,
        toolbar: "#but_search",
        columns: [[
            //{field: 'id', title: '会员名', width: 100},
            {field: 'membernumber', title: '会员名', width: 100},
            {field: 'petname', title: '宠物姓名', width: 100, formatter: petnameFormatter},
            {field: 'petLineage', title: '宠物品种', width: 100},
            {field: 'petgender', title: '性别', width: 100, formatter: petgender},
            {field: 'perbirthday', title: '生日', width: 100, formatter: perbirthday},
            {field: 'petlineageregistry', title: '血统', width: 100, formatter: petlineageregistry},
            {field: 'petcolor', title: '毛色', width: 100, formatter: petcolor},
            {field: 'sufficienttake', title: '余额', width: 100, formatter: sufficienttake},
            {field: 'memberarddess', title: '地址', width: 100},
            {field: 'memberstart', title: '状态', width: 100, formatter: memberstart},
            {field: 'membernote', title: '备注', width: 100},
            {field: 'sale', title: '消费记录', width: 100, formatter: saleFormatter},
            {field: 'petpicture', title: '图片', width: 100,
                formatter: function(value, rowData, rowIndex) {
                var h = "";
                h += "<a name='opera' name=rowIndex  onclick='consume(" + rowIndex+1 + ")' ></a> ";
                return h;
            }}
        ]],
        onLoadSuccess: function (data) {
            $("a[name='opera']").linkbutton({text: '查看图片', plain: true});

        },
        onRowContextMenu: function(e, rowIndex, rowData){
            console.debug(e);
            e.preventDefault(); //阻止浏览器捕获右键事件
            // 显示快捷菜单
            $('#contextMenu_jygl').menu('show',{
                left: e.pageX,
                top: e.pageY
            });
        }

    });
    //状态
    function memberstart(value, rowData, rowIndex) {
        return rowData.memberstart == 0 ? "已退卡" : "";
    }


    //余额
    function sufficienttake(value, rowData, rowIndex) {
        return rowData.sufficienttake ? rowData.sufficienttake.totalamount : "余额不足";
    }

    //宠物生毛色
    function petcolor(value, rowData, rowIndex) {
        return rowData.pet ? rowData.pet.petcolor : "红毛";
    }

    //宠物生血统
    function petlineageregistry(value, rowData, rowIndex) {
        return rowData.pet ? rowData.pet.petlineageregisternumber : "o形";
    }

    //宠物生性别
    function petgender(value, rowData, rowIndex) {
        return rowData.pet ? "弟弟" : "妹妹";
    }

    //宠物生日
    function perbirthday(value, rowData, rowIndex) {
        return rowData.pet ? rowData.pet.perbirthday : "无生日";
    }

    /* //宠物品总
     function petLineageRegisterNumber(value, rowData, rowIndex) {
     return rowData.pet?rowData.pet.petlineageregisternumber:"暂无品总";
     }*/
    //宠物姓名
    function petnameFormatter(value, rowData, rowIndex) {
        return rowData.pet ? rowData.pet.petname : "暂无宠物";
    }

    //状态格式化消费记录
    function saleFormatter(value, rowData, rowIndex) {
        return " <a  style='align-content: center' onclick='sales()'>查看 </a>";
    }




    $("#btnRecharge").dialog({
        title: '充值',
        top: 30,
        width: 810,
        height: 400,
        closed: true,
        buttons: "#recharge_buttons"
    });

    $("#btnAddMember").dialog({
        title: '添加会员',
        top: 30,
        width: 1300,
        height: 500,
         closed: true,
        buttons: "#member_buttons"
    });

    $("#addPet").dialog({
        title: '添加宠物',
        top: 30,
        width: 700,
        height: 500,
        closed: true,
        buttons: "#pet_buttons"
    });


});

function sales() {
    $.messager.confirm("温馨提示","该会员穷了,没有消费记录")
}




//查看宠物图片
function consume(rowIndex) {
    console.debug(rowIndex);


    $("#loadPicture").dialog({
        title: '图片上传',
        top: 30,
        width: 600,
        height: 550,
        buttons: "#picture_buttons"
    })
    $("#hiddenId").val(rowIndex);
}

function sava_picture() {

    $("#pictureId").form("submit", {
        url: "/photoUpload.do",
        success: function (data) {
            console.log(data);
            data = $.parseJSON(data);
            // data = eval("(" + data + ")");
            $.messager.confirm("温馨提示", data.msg, function () {
                if (data.success) {
                    $.messager.confirm("温馨提示", data.msg, function () {
                        //2 关闭diaolog
                        $("#loadPicture").dialog("close");
                        //3 重新加载当前列表页面
                        $("#MemberOut").datagrid("reload");
                    })
                } else {
                    $.messager.confirm("温馨提示", data.success)
                }
            })
        }

    })
}
//图片保存弹出框取消操作
function cencel_picture() {
    $("#loadPicture").dialog("close");
}




//添加宠物弹框
function btnAddPet() {
    var dataEmp = $("#MemberOut").datagrid("getSelected");
    if (!dataEmp) {
        $.messager.alert("温馨提示", "请选择一个会员");
        return;
    }

    $("#addPet").dialog("open");

    //宠物类别二级联动显示
    var url = '/category_listAll.do';
    $.getJSON(url, function (json) {
        $('#classPet').combobox({
            data: json,
            valueField: 'id',
            textField: 'petcategoryname',
            onSelect: function (data) {
                $('#varietiePet').combobox({
                    url: '/selectBreedByCategoryId.do?id=' + data.id,
                    valueField: 'id',
                    textField: 'petbreedname'
                })
            }
        })
    });

    $("#addPet").form("load", dataEmp);
}


//宠物保存
function sava_AndPet() {
    $("#addPetForm").form("submit", {
        url: "/save_pet.do",
        //添加额外参数
        onSubmit: function (param) {
            //类别
            param["category.id"] = $("#classPet").val();
            //品种
            param["breed.id"] = $("#varietiePet").val();


        },
        success: function (data) {
            console.log(data);

            data = $.parseJSON(data);
            // data = eval("(" + data + ")");
            $.messager.confirm("温馨提示", data.msg, function () {
                if (data.success) {
                    $.messager.confirm("温馨提示", data.msg, function () {
                        //2 关闭diaolog
                        $("#addPet").dialog("close");
                        //3 重新加载当前列表页面
                        $("#MemberOut").datagrid("reload");
                    })
                } else {
                    $.messager.confirm("温馨提示", data.success)
                }
            })
        }

    })
}

//删除宠物
function deletePet() {

    var dataEmp = $("#MemberOut").datagrid("getSelected");
     alert(dataEmp.pet.id);
    if (!dataEmp) {
        $.messager.alert("温馨提示", "请选择一条数据");
        return;
    }
    $.messager.confirm("温馨提示", "确认删除吗?", function (r) {
        if (r) {
            $.post("/delete_pet.do", {id: dataEmp.id}, function (data) {
                $.messager.confirm("温馨提示", data.msg, function () {
                    //3 重新加载当前列表页面
                    $("#MemberOut").datagrid("load");
                })
            })
        }
    })
}

//宠物保存弹出框取消操作
function cencel_Pet() {
    $("#addPet").dialog("close");
}





















//会员列表弹出窗
function btnAddMember() {
    $("#memberFrom").form("clear");

    $("#btnAddMember").dialog("open");

    //宠物类别二级联动显示
    var url = '/category_listAll.do';
    $.getJSON(url, function (json) {
        $('#petClass').combobox({
            data: json,
            valueField: 'id',
            textField: 'petcategoryname',
            onSelect: function (data) {
                $('#petVarietie').combobox({
                    url: '/selectBreedByCategoryId.do?id=' + data.id,
                    valueField: 'id',
                    textField: 'petbreedname'
                })
            }
        })
    })
    // 会员下拉列表
    $('#memberGrade').combobox({
        url: '/select_VIPMember.do',
        valueField: 'id',
        textField: 'vipname',
        panelHeight: 'auto',
        onSelect: function (data) {
            $("#memberProportion").html(data.vipmemberproportion);

            $("#serverProption").html(data.vipserverproption)
        }
    });
}


function editMember() {
    var dataEmp = $("#MemberOut").datagrid("getSelected");
    if (!dataEmp) {
        $.messager.alert("温馨提示", "请选择一个会员");
        return;
    }
    $("#btnAddMember").dialog("open");
    $("#btnAddMember").dialog("setTitle", "编辑页面");
    //宠物类别二级联动显示
    var url = '/category_listAll.do';
    $.getJSON(url, function (json) {
        $('#petClass').combobox({
            data: json,
            valueField: 'id',
            textField: 'petcategoryname',
            onSelect: function (data) {
                $('#petVarietie').combobox({
                    url: '/selectBreedByCategoryId.do?id=' + data.id,
                    valueField: 'id',
                    textField: 'petbreedname'
                })
            }
        })
    })

    $.ajax({
        url:'/select_VIPMember.do',
        type:"post",
        datatype:"json",
        success:function(data){
            dataEmp["vipmember.id"]=data[1].id;
            if(data){
                $('#chanel').combobox({
                    data:data,
                    valueField:'id',
                    textField:'vipname',
                    onLoadSuccess: function () { //加载完成后,设置选中第一项
                        var val = $(this).combobox("getData");
                        $(this).combobox("select", val[1]);
                    },
                    onSelect: function (data) {
                        //   $("#memberGrade").combobox("setValue",data.id);
                        $('#memberGrade').combobox('select',data.id);
                        $("#memberProportion").html(data.vipmemberproportion);

                        $("#serverProption").html(data.vipserverproption)
                    }
                });
            }else{
                data = [];
            }
        }
    });
    console.debug(dataEmp);
    //dataEmp["v.id"]=data[1].id;
    $("#btnAddMember").form("load", dataEmp);

}




//会员保存
function sava_menberAndPet() {
    $("#memberFrom").form("submit", {
        url:'/saveMemberAndPet_save.do',
        //添加额外参数
        onSubmit: function (param) {
            //获取已经选中的会员等级
            param["vipmember.id"] = $("#memberGrade").val();
           //类别
            param["category.id"] = $("#petClass").val();
            //品种
            param["breed.id"] = $("#petVarietie").val();
        },
        success: function (data) {
              console.log(data);
            console.log("aaaa"+data);
          data = $.parseJSON(data);
//             data = eval("(" + data + ")");

            if (data.success) {
                $.messager.confirm("温馨提示1", data.msg, function () {
                    //2 关闭diaolog
                    $("#btnAddMember").dialog("close");
                    //3 重新加载当前列表页面
                    $("#MemberOut").datagrid("reload");
                })
            } else {
                $.messager.alert("温馨提示2", data.msg)
            }
        }
    })
}

//弹出框取消操作
function cencel_menberAndPet() {
    $("#btnAddMember").dialog("close");
}





//充值弹窗
function btnRecharge() {
    var dataEmp = $("#MemberOut").datagrid("getSelected");
    if (!dataEmp) {
        $.messager.alert("温馨提示", "请选择一个会员");
        return;
    } else if (dataEmp.memberstart == 0) {
        $.messager.alert("温馨提示", "退卡不能再充值了");
        return;
    }
    $("#btnRecharge").form("clear");
    $("#btnRecharge").dialog("open");
    //随机生成订单编号
    $("#rechargeNumber").text(randomString(10));

    //  $('#member_cc').combobox('setValue', dataEmp.id);

    $('#employee').combobox({
        url: '/select_employee.do',
        valueField: 'id',
        textField: 'username',
        panelHeight: 'auto'
    });

    // 会员下拉列表
    $('#member_cc').combobox({
        url: '/select_VIPMember.do',
        valueField: 'id',
        textField: 'vipname',
        panelHeight: 'auto',
        onSelect: function (data) {
            $("#vipmemberproportion").html(data.vipmemberproportion);

            $("#vipserverproption").html(data.vipserverproption)
        }
    });

    //查询卡内余额和消费总额
    $.post("/sufficientTake.do", {id: dataEmp.id}, function (data) {
        if(data.totalamount){
        $("#memberPrices").text(data.totalamount);
        }else {
            $("#memberPrices").text("0");
        }
        if(data.amountspent){
        $("#memberPricesum").text(data.amountspent);
        }else{
            $("#memberPricesum").text(0);
        }

    });

    $("#btnRecharge").form("load", dataEmp);
}
//充值保存
function sava_recharge() {
    $("#btnRecharge_form").form("submit", {
        url: "/recharge_save.do",
        //添加额外参数
        onSubmit: function (param) {
            //获取已经选中的会员等级
            var rechargeNumber = $("#rechargeNumber").text();
            param["membername.id"] = $("#memberId").val();
            param.rechargenumber = rechargeNumber;

        },
        success: function (data) {
            console.log(data);

            data = $.parseJSON(data);
            // data = eval("(" + data + ")");
            $.messager.confirm("温馨提示", data.msg, function () {
                if (data.success) {
                    $.messager.confirm("温馨提示", data.msg, function () {
                        //2 关闭diaolog
                        $("#btnRecharge").dialog("close");
                        //3 重新加载当前列表页面
                        $("#MemberOut").datagrid("reload");
                    })
                } else {
                    $.messager.confirm("温馨提示", data.success)
                }
            })
        }

    })


}
//弹出框取消操作
function cencel_recharge() {
    $("#btnRecharge").dialog("close");
}

//随机生成订单编号
function randomString(len) {
    len = len || 32;
    var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
    /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
    var maxPos = $chars.length;
    var pwd = '';
    for (i = 0; i < len; i++) {
        pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

//会员退卡
function memberOutDialog() {
    var dataEmp = $("#MemberOut").datagrid("getSelected");
    if (!dataEmp) {
        $.messager.alert("温馨提示", "请选择一个会员");
        return;
    } else if (dataEmp.memberstart == 0) {
        $.messager.alert("温馨提示", "该会员已经退卡");
        return;
    }

    $.messager.confirm("温馨提示", "确认退卡吗?", function (r) {
        if (r) {
            $.post("/updatMemberstart.do", {id: dataEmp.id}, function (data) {
                $.messager.confirm("温馨提示", data.msg, function () {
                    //3 重新加载当前列表页面
                    $("#MemberOut").datagrid("reload");
                })
            })
        }
    });
}
//查看充值记录
function f_addTab() {
    window.location.href = "/sufficientitem.do"
}


//上传文件
function AddAllMember() {
    $("#leading_in").dialog("open");
}
//下载模版
function updownload(){
    window.location.href="/download.do";
}