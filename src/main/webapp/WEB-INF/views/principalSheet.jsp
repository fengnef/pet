<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head style="width: 100%; height: 100%">
    <title>本店信息</title>
    <script src="/static/myindex/Scripts/jquery-1.7.1.js"></script>
    <script src="/static/myindex/Scripts/js/LG.js"></script>
    <script src="/static/myindex/Scripts/jquery.autocomplete.js"></script>
    <script src="/static/myindex/Scripts/jquery.bigautocomplete.js"></script>

    <script src="/static/myindex/ligerUI/js/core/base.js"></script>
    <script src="/static/myindex/ligerUI/js/ligerui.all.js"></script>

    <link href="/static/myindex/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/jquery.autocomplete.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/jquery.bigautocomplete.css" rel="stylesheet"/>
    <link href="/static/myindex/Content/newstyle.css" rel="stylesheet"/>
    <link href="/static/myindex/ligerUI/skins/Tab/css/all.css" rel="stylesheet"/>

    <%--&lt;%&ndash; <link href="/static/myindex/ligerUI/skins/Gray2014/css/all.css" rel="stylesheet" />&ndash;%&gt;--%>
    <link href="/static/myindex/Content/JS/UserDetailedInfo/StoreList.css" rel="stylesheet"/>
    <script src="/static/myindex/Content/JS/UserDetailedInfo/StoreList.js" type="text/javascript"></script>
    <script type="text/javascript" src="/static/js/area.js"></script>


    <%--<script src="/static/myindex/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
     <script src="/static/myindex/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>--%>

    <%--<script src="/static/js/views/shop.js"></script>--%>

    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript">

        oFReader = new FileReader();
        rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;

        oFReader.onload = function (oFREvent) {
            document.getElementById("uploadPreview").src = oFREvent.target.result;
        };

        function loadImageFile() {
            if (document.getElementById("fileUpload").files.length === 0) {
                return;
            }
            var oFile = document.getElementById("fileUpload").files[0];
            if (!rFilter.test(oFile.type)) {
                alert("You must select a valid image file!");
                return;
            }
            oFReader.readAsDataURL(oFile);
            $("#Grid").submit();
        }
        $(function () {
            $("#file_dialog").dialog({
                width:250,
                height:100,
                closed: true,
                buttons:"#inport_tb"
            });
        });


        //导出
        function exportDb() {

            $.messager.confirm('温馨提示', '您确定需要备份数据码?', function (r) {
                if (r) {
                    $.get("/export.do");
                    //var exportMsg='${sessionScope.exportMsg}'
                    $.messager.alert('温馨提示', "备份成功", 'info');
                }
            });
        }

        //恢复即导入
        function importDb() {
           $("#file_dialog").dialog("open");
            // 提交表单
            $("#file_dialog").dialog("setTitle","请选择要恢复的数据文件");

        }
        function cancel() {
            $("#file_dialog").dialog("close");
        }
        function save() {
            $("#file_dialog").dialog("close");
            $("#Form2").form('submit', {
                url : "/import.do",
                success : function (data) {
                    // 转成json对象
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert('温馨提示', data.msg, 'info', function () {
                            // 关闭弹出框
                            $("#file_dialog").dialog("close");

                        });
                    } else {
                        $.messager.alert('温馨提示', data.msg, 'info');
                    }
                }
            });

        }

    </script>
</head>
<body style="width: 100%; font-family: '微软雅黑'; background: none; color: black"
<%--onload="address()"--%>
<div class="areabx clear" style="width: 100%;">
    <div id="Info" class="tian_xi">
         <form clase="form-inline"    enctype="multipart/form-data" id="gridLoads"
              method="post" name="uploadForm"  role="form" style="height:100%;display:block">
            <div style="width: 52%; height: 487px; background: url(/static/myindex/Images/ba.png) no-repeat; overflow: hidden; float: left">
                <div>
                    <img <%--id="uploadPreview"--%> class="dpImg" src="/static/myindex/dog.jpeg"/>
                    <div style="width: 350px; height: 35px; line-height: 35px; color: #fff; background: #393939; opacity: 0.6;
                    text-align: center; position: absolute; left: 141px; top: 396px; font-size: 14px;">修改图片
                    </div>
                    <input type="file" class="sc_btn" size="25" id="fileUpload"
                           style="filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0; position: absolute; left: 141px;
                           top: 61px; width: 350px; height: 350px;"/>
                    <input  class="sc_btn" onchange="loadImageFiles();"
                           style="filter: alpha(opacity=0); -moz-opacity: 0; opacity: 0; position: absolute;
                           left: 141px; top: 61px; width: 350px; height: 350px;" type="file">

                </div>
            </div>
        </form>
        <div style="margin-right: 35px; float: left; height: 487px; width: 40%">
            <div>
                <div class="guider" id="guider">
                    <div class="font-50" style="font-size: 24px;">
                        <input  id="ID"
                               name="ID" type="hidden" value="780"/>
                        <input data-val="true"
                               id="UserID" name="UserID" type="hidden" value="737"/>
                        <span id="store" style="float: left; padding-top: 10px"></span>
                        <img id="starimg"  src="/static/myindex/Images/star.png"
                            style="transform: rotate(40deg); -moz-transform: rotate(40deg); margin-bottom: 5px; margin-left: -22px; display: none; float: left"/>
                        <span class="update_info" onclick="UpdateRecord()">
                                <p style="float: left">修改</p>
                            </span>
                    </div>
                </div>
                <div style="clear: both"></div>
                <div style="width: 90%; font-weight: 800">
                    <div class="Contact_tit"></div>
                    <div class="con_info"><span id="storeheads">负责人：</span></div>
                    <div class="con_info"><span id="contactmobiles">联系电话：</span></div>
                    <div class="con_info"><span id="Address">店铺地址：</span>
                    </div>
                    <div class="con_info"><span id="setuptimes">成立时间：</span></div>
                </div>
                <div class="Contact_tit"></div>
                <div id="StoreIntroduce1" name="storeintroduce" style="font-size: 13px; width: 90%;">给亲爱的宠物最佳的服务</div>
            </div>


            <div style="height: 100px;">
                <div class="kjtb" id="wx" onclick="SchoolInfo()">
                    <img src="/static/myindex/Images/leftimg/dphd.png"/>
                    <p>店铺活动</p>
                </div>
                <div class="kjtb" id="star" onclick="StarStore()" style="display: none">
                    <img src="/static/myindex/Images/starwhite.png">
                    <p>明星店铺</p>
                    <p style="margin-left: -10px; display: none" id="dttime"></p>
                    <p id="dt" style="display: none">(已到期)</p>
                </div>
                <!--  <div class="kjtb" id="UD" onclick="top.f_addTab('U盾保护','U盾保护','/LevelUp/UdPay');">
                     <img src="/static/myindex/Content/icon/UD.png" />
                     <p>U盾保护</p>
                     <p id="UDtrue" style="display: none">(已绑定)</p>
                 </div> -->
                <div class="kjtb" id="Smq" onclick="top.f_addTab('weixinstep','微信公众号','/LevelUp/WeiXin');">
                    <img src="/static/myindex/Images/leftimg/weixin.png"/>
                    <p style="width: 60px; margin-left: -5px;">公众号绑定</p>
                </div>

            </div>
            <div style="height: 30px;">
                <img src="/static/myindex/Content/icon/sqfd1.png"/>
            </div>
            <div class="kjtb" onclick="exportDb()">
                <img src="/static/myindex/Content/icon/tjzh.png"/>
                <p>数据备份</p>
            </div>

            <div class="kjtb" onclick="importDb()">
                <img src="/static/myindex/Images/kj_xg.png">
                <p>数据恢复</p>
            </div>

            <!--  <button class="kjtb"  onclick="exportDb()" style="width: 80px; height: 80px;margin-right: 35px;background-color: #6B6B6B">数据备份</button>
             <button class="kjtb" onclick="importDb()"   style="width: 80px; height: 80px;margin-right: 35px;background-color: #6B6B6B">数据恢复</button> -->
          <%--  <video src="/static/png/7290.mp4"  controls height="600" wight="800">您的浏览器不支持video标签</video>--%>

        </div>
    </div>
    <div style="clear: both">
        <div id="StoreInfo" class="areabx clear" style="height: 36px; padding-top: 10px; display: none">
            <span>店铺名称：</span><input class="input_check" id="StoreName" name="StoreName" onchange="DoSearch();"
                                     type="text" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="com_btn1" value="查询" onclick="DoSearch();">
            <div id="grid">
            </div>
        </div>
    </div>
</div>

<div id="file_dialog">
    <form name="Form2" action="/" method="post"  enctype="multipart/form-data">
        <input id="txt_head"  name="path" class="easyui-filebox" data-options="buttonText:'选择文件',editable:false">
    </form>
</div>





<div id="principalSheet" hidden="true">
    <form  id="sheetForm" method="post">
        <table class="l-table-edit">
            <tr style="height: 40px;" hidden="hidden">
                <td class="l-table-edit-td" style="width: 80px">用户id：
                </td>
                <td style="text-align: left; width: 290px" class="l-table-edit-td">
                    <input   id="userId1" name="id" type="text"  />
                </td>
            </tr>
            <tr style="height: 40px;">
                <td class="l-table-edit-td" style="width: 80px">店铺名称：
                </td>
                <td style="text-align: left; width: 290px" class="l-table-edit-td">
                    <input id="storeName1" name="storeName" readonly="true" style="background:#d6d6d6 ;margin-top:5px;width:200px" type="text"/>
                </td>
                <td class="l-table-edit-td">店铺手机：
                </td>
                <td style="text-align: left" class="l-table-edit-td">
                    <input id="ContactMobile" name="contactmobile"  style="background:#d6d6d6 ;" type="text"  />
                </td>
            </tr>
            <tr style="height: 40px;">
                <td class="l-table-edit-td">店铺负责人：
                </td>
                <td style="text-align: left;" class="l-table-edit-td">
                    <input id="StoreHead" name="storehead" readonly="true" style="background:#d6d6d6 ;" type="text"  />
                </td>"
                <td class="l-table-edit-td">店铺地址：
                </td>
                <td style="text-align: left" class="l-table-edit-td">
                    <span class="intelligent-label f-fl">店铺地址：</span>
                    <select id="s_province" name="s_province" class="txt-m fl" style="width:85px;padding-left:3px">
                        <option selected="selected"  value="请选择"></option>
                    </select>
                    <select id="s_city" name="s_city" class="txt-m fl" style="width:auto;padding-left:3px">
                    </select>
                    <select id="s_county" class="txt-m fl" style="width:auto;padding-left:3px">
                    </select>
                    <script type="text/javascript">_init_area();</script>
                    <input id="provinceAddress"  style="margin-top:5px;width:200px" type="text"/>
                </td>
            </tr>
            <tr style="height: 40px;">
                <td class="l-table-edit-td">店铺传真：
                </td>
                <td style="text-align: left" class="l-table-edit-td"><input id="StoreFax" name="storefax" type="text"  />
                </td>
                <td class="l-table-edit-td" style="text-align: right;" > 成立时间：
                </td>
                <td style="text-align: left" class="l-table-edit-td">
                    <input  id="SetupTime" name="setuptime"  readonly="true" required="required" />
                </td>
            </tr>
            <tr style="height: 80px;">
                <td class="l-table-edit-td">店铺誓言：
                </td>
                <td style="text-align: left" colspan="3" class="l-table-edit-td">
                        <textarea cols="20" id="StoreIntroduce" name="storeintroduce" rows="2" style="width:610px;heigth:80px"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>
<%--修改店主信息按钮--%>
<div id="principal_buttons" hidden="true">
    <a class="easyui-linkbutton" data-options="plain:true" onclick="sava_Andsheet()">保存</a>
    <a class="easyui-linkbutton" data-options="plain:true" onclick="cencel_sheet()">取消</a>
</div>
<div id="inport_tb" hidden="true">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="save()">保存</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
</div>



</body>
</html>
