<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员页面</title>
    <link href="/static/css/member.css" rel="stylesheet"/>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/member.js"></script>

    <%-- <script type="text/javascript" src="/static/json/selectCity.js"></script>--%>
</head>
<body>
<div id="but_search">
    <div>
        <form>
            <div style="height: 36px; padding-top: 10px; padding-left: 20px; border-bottom: 1px solid #b8b6b4">
                <span>宠物类别：</span>
                <select data-val="true" id="PetClassID" name="PetClassID"
                        onchange="DoSearch();" style="width:72px">
                    <option value="0">所有</option>
                </select>
                <span>宠物品种：</span>
                <select data-val="true" id="PetVarietiesID" name="PetVarietiesID"
                        onchange="DoSearch();" style="width:128px">
                    <option value="0">所有</option>
                </select>
                <span>宠物名称：</span>
                <input type="text" class="input_check_1" id="PetName" onchange="DoSearch();"/>
                <span>手机号码：</span>
                <input type="text" class="input_check_1" id="PetNumber" onchange="DoSearch();"/>
                <span>备注：</span>
                <input type="text" class="input_check_1" id="MemberNote" onchange="DoSearch();"/>
                <input type="hidden" class="input_check" id="PetVarieties"/>
                <input type="button" class="comBtn gray" id="btnSearch" value="查询" onclick="DoSearch()">
              <%--  <script type="text/javascript">
                    addressInit('cmbProvince', 'cmbCity', 'cmbArea');
                </script>
                <select id="cmbProvince" name="cmbProvince">

                </select>
                <select id="cmbCity" name="cmbCity"></select>
                <select id="cmbArea" name="cmbArea"></select>--%>
            </div>
        </form>
    </div>

    <div style="padding: 10px 0; height: 36px;">
        <div style="float: left;">
            <input type="button" class="comBtn gray" onclick="btnRecharge()" value="充值"
                   style="margin-left: 20px">
            <input type="button" class="comBtn gray" onclick="btnAddMember()" value="添加会员">
            <input type="button" class="comBtn gray" onclick="btnAddPet()" value="添加宠物">
            <input type="button" class="comBtn gray" value="退卡"
                   onclick="memberOutDialog()">
            <input type="button" class="comBtn gray" onclick="AddAllMember()" value="导入会员">
        </div>
        <div style="float: right; padding-right: 20px">
            <input type="button" class="comBtn green" id="Btnsk" value="散客管理" onclick="FITManage()">
            <input id="View" type="button" value="充值记录" onclick="f_addTab();"
                   class="comBtn orange">
        </div>
    </div>
</div>
<%--下拉列表数据--%>
<table id="MemberOut">
</table>

<%--点击右键事件--%>
<div id="contextMenu_jygl" class="easyui-menu" style="width: 80px; display: none;">
    <div id="btn_More" data-options="iconCls:'icon-ok'" onclick="btnAddPet()">添加宠物</div>
    <div id="Pass" data-options="iconCls:'icon-remove'" onclick="editMember()">修改</div>
    <div id="NoPass" data-options="iconCls:'icon-remove'" onclick="deletePet()">删除</div>
</div>

<%--查看宠物图片--%>
<div id="loadPicture">
    <form  method="post" id="pictureId" enctype="multipart/form-data">
     选择文件:<input type="file" name="file">
            <input type="hidden"  id="hiddenId" name="id">
           <img src="/static/myindex/dog.jpeg" id="srcPicture">
    </form>-

</div>
<%--图片上传按钮--%>
<div id="picture_buttons">
    <a class="easyui-linkbutton" data-options="plain:true" onclick="sava_picture()">保存</a>
    <a class="easyui-linkbutton" data-options="plain:true" onclick="cencel_picture()">取消</a>
</div>


<%--添加宠物--%>
<div id="addPet">
    <div class="areabx clear">
        <div class="tian_xi">
            <form  clase="form-inline" id="addPetForm" method="post"  role="form">
                <table style="margin-left: 50px; width: 100%" class="l-table-edit">
                  <tbody>
                  <tr style="height: 40px;">
                      <td class="l-table-edit-td" style="width: 80px" align="right">会员编号：
                      </td>
                      <td class="l-table-edit-td" style="text-align:left;">
                          <input readonly="true"  id="numberMember" name="membernumber" type="text">
                          <span><font color="#FF0000">*<span class="field-validation-valid" ></span></font></span>
                      </td>
                    <td class="l-table-edit-td" style="width: 80px" align="right">宠物名：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;">
                        <input data-val="true"  id="inputPetName" name="petname" type="text">
                        <span><font color="#FF0000">*<span class="field-validation-valid" ></span></font></span>
                    </td>
                </tr>
                <tr style="height: 40px;">
                    <td class="l-table-edit-td" align="right">宠物生日：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;width:145px">
                        <div class="l-text-wrapper"><div class="l-text l-text-date"><input id="PetBirthday"  class="easyui-datebox" name="perbirthday" class="l-text-field" ligeruiid="PetBirthday" type="text"></div>
                    <td class="l-table-edit-td" align="right">宠物性别：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;">
                        <span class="radioMagin">
                            弟弟 <input name="petgender" value="0" type="radio">
                            妹妹 <input name="petgender" value="1" type="radio">
                            不详 <input  name="petgender"  type="radio">
                        </span>
                    </td>
                </tr>
                <tr style="height: 40px;">
                    <td class="l-table-edit-td" align="right">宠物类别：
                    </td>
                    <td>
                        <input type="text" id="classPet" name="petVarietie.id"/>
                    </td>
                    <td class="l-table-edit-td" align="right">宠物品种：
                    </td>
                    <td>
                        <input type="text" id="varietiePet" name="petVarietie.id"/>
                    </td>
                </tr>
                <tr style="height: 40px;">
                    <td class="l-table-edit-td" align="right">过敏物：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;width:145px">
                        <select data-val="true" id="AllergicMaterialID" name="petallergicmaterial" style="width:120px"><option value="1" selected="selected">无</option>
                        </select>
                    </td>
                    <td class="l-table-edit-td" align="right">颜色：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;">
                        <input id="inputPetColor" name="petcolor" type="text">
                        <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="PetColor" data-valmsg-replace="true"></span></font></span>
                    </td>
                </tr>
                <tr style="height: 40px;">
                    <td class="l-table-edit-td" align="right">血统登记号：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;width:145px">
                        <input id="petlineageregisternumber" name="petlineageregisternumber" type="text">
                    </td>
                    <td class="l-table-edit-td" align="right">血统登记处：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;">
                        <input id="petlineageregistry" name="petlineageregistry" type="text">
                    </td>
                </tr>
                <tr style="height: 40px;">
                    <td class="l-table-edit-td" align="right">宠物状态：</td>
                    <td class="l-table-edit-td" style="text-align:left;width:145px">
                        <span class="radioMagin">
                            正常 <input   name="petstatus" value="1" type="radio">&nbsp;&nbsp;
                            生病 <input  name="petstatus" value="2" type="radio">&nbsp;&nbsp;
                            已逝 <input  name="petstatus" value="3" type="radio">
                            配种 <input  name="petstatus" value="4" type="radio">&nbsp;&nbsp;
                            绝育 <input  name="petstatus" value="5" type="radio">
                        </span>
                    </td>
                    <td class="l-table-edit-td" align="right">特征：
                    </td>
                    <td class="l-table-edit-td" style="text-align:left;">
                        <input id="petcharacteristic" name="petcharacteristic" type="text">
                        <span><font color="#FF0000"><span class="field-validation-valid" ></span></font></span>
                    </td>
                </tr>
                </tbody>
            </table>
            </form>
        </div>
    </div>
    <div class="l-box-dateeditor l-box-dateeditor-absolute" style="display:none">
</div>

    <%--添加宠物按钮--%>
    <div id="pet_buttons">
        <a class="easyui-linkbutton" data-options="plain:true" onclick="sava_AndPet()">保存</a>
        <a class="easyui-linkbutton" data-options="plain:true" onclick="cencel_Pet()">取消</a>
    </div>










































<%-- 添加会员--%>
<div id="btnAddMember">
    <div class="areabx clear">
        <div class="tian_xi" style="width: auto">

            <form class="form-inline" id="memberFrom" method="post">
                <table class="l-table-edit" style="width: 100%" border="0" cellpadding="0" cellspacing="0">
                    <tbody>
                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" width="80px" style="text-align: right;" colspan="10">
                            <span style="float: left; margin-top: 5px;">主人信息</span>
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" width="80px" style="text-align: right;"><span
                                style="color:#f00">手机号码：</span></td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input class="trade-timen"
                                   id="memberContactOne"
                                   name="membernumber" type="text"
                                   required="required"/>
                        </td>
                        <td class="l-table-edit-td" width="80px" style="text-align: right;">会员姓名：</td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input class="trade-timen" id="MemberName" name="membername" type="text"/>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;"><span style="color:#f00">首冲金额：</span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input class="trade-timen" id="MemberPrice" name="memberprice" type="text"/>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">会员等级：
                        </td>
                        <td>
                            <input type="text" id="memberGrade" />
                            商品折扣：<span id="memberProportion" style="color: black; text-align: left"></span>%
                            服务折扣：<span id="serverProption" style="color: black; text-align: left"></span>%
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" style="text-align: right;width:80px">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <span class="radioMagin">
                                男 <input  name="membersex" type="radio" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                女 <input name="membersex" type="radio" value="0"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                不详 <input  name="membersex" type="radio" value=""/>
                            </span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;width:80px">生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日：</td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input id="MemberBirthday" class="easyui-datebox" name="memberbirthday" type="text"/>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">住&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：
                        </td>
                        <td class="l-table-edit-td" colspan="4" style="text-align: left;">
                            <input class="trade-timen" id="MemberArddess" name="memberarddess" style="width:450px"
                                   type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="l-table-edit-td" style="text-align: right;">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input class="trade-timen" name="membernote" type="text"/>
                        </td>
                    </tr>


                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" width="80px" style="text-align: right;" colspan="10">
                            <span style="float: left; margin-top: 5px;">宠物信息：</span>
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" style="width: 80px;text-align: right;"><span
                                style="color:#f00">宠物名：</span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input  name="petname" type="text"
                                   validate="{required:true}"/>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">宠物生日：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input name="perbirthday" class="easyui-datebox" type="text"/>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">宠物性别：</td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <span class="radioMagin">
                                弟弟 <input id="PetSex1" name="petgender"  value="1"  type="radio"/>
                                妹妹 <input id="PetSex2" name="petgender" value="0" type="radio"/>
                                不详 <input id="petgender" name="petgender" value="" type="radio"/>
                            </span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">特征：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input id="PetFeature" name="petcharacteristic" type="text"/>
                            <span><font color="#FF0000"><span class="field-validation-valid"></span></font></span>
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" style="text-align: right;">宠物类别：
                        </td>

                        <td>
                            <input type="text" id="petClass"/>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">宠物品种：</td>
                        <td>
                            <input type="text" id="petVarietie" />
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">过敏物：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input id="petallergicmaterial" name="petallergicmaterial" type="text"/>
                            <span><font color="#FF0000"><span class="field-validation-valid"></span></font></span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">颜色：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input id="PetColor" name="petcolor" type="text"/>
                            <span><font color="#FF0000"><span class="field-validation-valid"
                                                              data-valmsg-replace="true"></span></font></span>
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td class="l-table-edit-td" style="text-align: right;">血统登记号：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input id="PetRegisteredNum" name="petlineageregisternumber" type="text"/>
                            <span><font color="#FF0000"><span class="field-validation-valid"></span></font></span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">血统登记处：
                        </td>
                        <td class="l-table-edit-td" style="text-align: left;">
                            <input id="PetRegistry" name="petlineageregistry" type="text"/>
                            <span><font color="#FF0000"><span class="field-validation-valid"></span></font></span>
                        </td>
                        <td class="l-table-edit-td" style="text-align: right;">宠物状态：</td>
                        <td class="l-table-edit-td" colspan="2" style="text-align: left;">
                            <span class="radioMagin">正常
                                <input name="petstatus" type="radio" value="1"/>生病
                                <input name="petstatus" type="radio" value="0"/>已逝
                                <input name="petstatus" type="radio" value="3"/>配种
                                <input name="petstatus" type="radio" value="4"/>绝育
                                <input name="petstatus" type="radio" value="5"/>
                            </span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>


<%--添加会员按钮--%>
<div id="member_buttons">
    <a class="easyui-linkbutton" data-options="plain:true" onclick="sava_menberAndPet()">保存</a>
    <a class="easyui-linkbutton" data-options="plain:true" onclick="cencel_menberAndPet()">取消</a>
</div>


<%--充值列表--%>
<div id="btnRecharge">
    <div class="areabx clear">
        <div class="tian_xi">
            <form action="/" method="post"
                  id="btnRecharge_form" style="margin-top:20px ">
                <input type="hidden" name="id" id="memberId">
                <div style="height: 40px;">
                    <span style="padding-top: 20px; padding-left: 20px; height: 40px;">充值单编号：</span>
                    <span style="font-size: 14px; font-weight: bold; padding-top: 20px; padding-left: 20px; height: 40px;"><label
                            name="rechargenumber" id="rechargeNumber"></label></span>
                </div>
                <table style="width: 720px; margin-left: 100px;" border="0" cellpadding="0" cellspacing="0"
                       class="l-table-edit">
                    <tbody>
                    <tr>
                        <td class="l-table-edit-td">会员卡号：</td>
                        <td text-align: left;>
                            <input class="trade-timen" id="MemberNumber" name="membernumber" type="text"
                                   readonly="true" value=""/><span readonly="true"></span>
                        </td>
                        <td style="width: 200px; text-align: right;">卡内余额：</td>
                        <td style="width: 100px; text-align: left;">
                            <span id="memberPrices" style="color: red"></span>元
                        </td>
                        <td style="width: 350px; text-align: right;" class="l-table-edit-td">历史消费总
                            额：
                        </td>
                        <td style="width: 160px; text-align: left;" class="l-table-edit-td">
                            <span id="memberPricesum" style="color: red"></span>元
                        </td>
                    </tr>
                    <tr style="height: 40px;">
                        <td style="width: 80px; text-align: right;" class="l-table-edit-td">充值金额：</td>
                        <td style="width: 230px; text-align: left;" colspan="5" class="l-table-edit-td">
                            <input id="RechargePrice" name="rechargeprice" type="text" class="easyui-numberbox"/></td>
                    </tr>
                    <tr>
                        <td>
                            会员等级
                        </td>
                        <td>
                            <input type="text" id="member_cc" name="vipmember.id"/>
                        </td>
                        <td style="width: 130px; text-align: left;" colspan="3" class="l-table-edit-td">
                            商品折扣：<span id="vipmemberproportion" style="color: black; text-align: left"></span>%

                            服务折扣： <span id="vipserverproption" style="color: black; text-align: left"></span>%
                        </td>
                    </tr>
                    <td></td>
                    <tr style="height: 40px;">

                        <td style="width: 80px; text-align: right;" class="l-table-edit-td">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：&nbsp;&nbsp;</td>
                        <td style="width: 230px; text-align: left;" colspan="5" class="l-table-edit-td">
                            <textarea class="trade-timen" cols="20" id="RechargeUpgradeDetails"
                                      name="itemremarks" rows="2" style="width:500px;height:50px;">
                                <a href="">
                                    查看
                                </a>
</textarea></td>

                    </tr>
                    </tbody>
                </table>
                <div style="margin-left: 470px; width: 100%; height: 50px;"> <td>
                 充值人员:   <input type="text" id="employee" name="employee.id"/>
                </td></div>
            </form>
        </div>
    </div>
</div>

<div id="leading_in" class="easyui-dialog" data-options="top:200,closed: true,width: 300,height: 350">
    <form action="/memeber_import.do" method="post" enctype="multipart/form-data">
        文件:<input type="file" name="file"> <input type="button"  value="下载模版" onclick="updownload()"></input>  <br>
        <input type="submit" value="提交">
    </form>
</div>

<%--充值按钮--%>
<div id="recharge_buttons">
    <a class="easyui-linkbutton" data-options="plain:true" onclick="sava_recharge()">保存</a>
    <a class="easyui-linkbutton" data-options="plain:true" onclick="cencel_recharge()">取消</a>
</div>
</body>
</html>
