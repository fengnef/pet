<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>


    <script type="text/javascript" src="/static/js/pet.js"></script>
</head>
<body>
<%--布局视图--%>
<div class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true,border:false">
    <%--高级查询框--%>
    <div data-options="region:'north'" style="height:30px;" align="center">
        宠物名称:<input type="text" name="petNameQuery"/>
        手机号码:<input type="text" name="telQuery"/>
        <input id="statusQuery" class="easyui-combobox" name="statusQuery"
               data-options="valueField:'statusValue',textField:'statustext',url:'/serviceitem_status.do',panelHeight:'auto'"/>
        <a id="pet_search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-newsearch'"
           onclick="searchForm1()">查询</a>
        <a id="pet_return" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-return'" onclick="reload()">返回服务</a>
    </div>
    <%--显示树结构--%>
    <div data-options="region:'west',border:false" style="width:200px;">
        <ul id="service_tree"></ul>
    </div>
    <%--服务功能--%>
    <div data-options="region:'center',border:false" style="padding:5px;background:#eee;">
        <a id="pet_addService" href="#" class="easyui-linkbutton" onclick="addService();">添加服务项目</a>
        <a id="pet_register" href="#" class="easyui-linkbutton" onclick="petRigister();">宠物登记</a>
        <a id="pet_pay" href="#" class="easyui-linkbutton" onclick="petPay();">付款</a>
        <table id="petService"></table>
    </div>
</div>
<%--添加服务对话框--%>
<div id="service_dialog">
    <form action="#" clase="form-inline" method="post" id="service_form" role="form">
        <table class="l-table-edit">
            <tr style="height: 40px;">
                <td class="l-table-edit-td" style="width: 110px;color:red">服务名称：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input id="petServiceName" name="text" type="text"
                           value="" class="easyui-validatebox" data-options="required:true"/>
                </td>
            </tr>
            <tr style="height: 40px;">
                <td class="l-table-edit-td">所属项目：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input id="petServerID" class="easyui-combobox" name="parentId"
                           data-options="valueField:'id',textField:'text',url:'/serviceitem_list.do'"
                           style="width:150px" value="1">
                </td>
            </tr>
            <tr style="height: 40px;">
                <td style="width: 40px;text-align:right" class="l-table-edit-td">价格(元)/(最低)：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input data-val="true" data-val-number="字段 PetServiceMinPrice 必须是一个数字。"
                           data-val-required="PetServiceMinPrice 字段是必需的。" id="PetServiceMinPrice"
                           name="" style="width:45px" type="text" value="0"/>
                    最高： <input data-val="true" data-val-number="字段 PetServiceMaxPrice 必须是一个数字。"
                               data-val-required="PetServiceMaxPrice 字段是必需的。" id="PetServiceMaxPrice"
                               name="" style="width:45px" type="text" value="0"/>
                </td>
            </tr>
            <tr style="height: 40px;">
                <td style="width: 40px" class="l-table-edit-td">单位(次、天)：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input data-val="true" data-val-number="字段 Unit 必须是一个数字。" data-val-required="Unit 字段是必需的。" id="Unit"
                           name="units" placeholder="输入数字，几次或几天" type="text" value="1"/>
                </td>
            </tr>
            <tr style="height: 40px;">
                <td style="width: 40px" class="l-table-edit-td">备注：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                        <textarea cols="20" id="Note" name="remark" placeholder="该项目所拥有的服务。" rows="2">
</textarea>
                </td>
            </tr>
            <tr style="height: 40px;">
                <td align="left" class="l-table-edit-td">是否享受折扣：</td>
                <td class="l-table-edit-td" style="text-align: left;"><span class="radioMagin">是 <input
                        Checked="checked" data-val="true" data-val-number="字段 DisCount 必须是一个数字。"
                        data-val-required="DisCount 字段是必需的。" id="count" name="discount" type="radio" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;否 <input
                        checked="checked" id="discount" name="discount" type="radio" value="0"/>
                    </span></td>
            </tr>
            <tr style="height: 40px;">
                <td style="width: 40px" class="l-table-edit-td">服务指定折扣：
                </td>
                <td class="l-table-edit-td" style="text-align: left;">
                    <input data-val="true" data-val-number="字段 SpecifiedDiscount 必须是一个数字。"
                           data-val-required="specifieddiscount 字段是必需的。" id="specifieddiscount" name="specifieddiscount"
                           style="width:45px" type="text" value="100"/> %
                </td>
            </tr>
        </table>
    </form>
</div>

<%--宠物登记对话框--%>
<div id="pet_dialog">
     <span id="msg">
        <div id="listbox1"></div>
        <input id="listcheck0" style="display: none;"/></span>
    <table>
        <tr>
            <td class="l-table-edit-td">会员号：</td>
            <td class="l-table-edit-td" style="text-align: left;">
                <input type="text" id="Number" onblur="searchInfo()" name="memberNumber"
                       validate="{required:true,number:true,minlength:11,maxlength:11}"/>
                <img src="static/plugins/easyui/themes/icons/search.png" onclick="searchInfo()"/>
            </td>
            <td colspan="2">
                <div id="listbox" style="display: none; font-size: 12px"></div>
                <input id="dialogData" style="display: none;"/>
            </td>
        </tr>
    </table>
    <div id="PetList" style="width: 666px; overflow: hidden; border: 1px solid #A3C0E8;">
        <div id="Pet0" tabid="home" title="宠物" lselected="true" style="height: 358px">
            <div class="areabx clear" id="111">
                <div class="tian_xi">
                    <form method="post" id="petRegister_form">
                        <table class="l-table-edit">
                            <tr style="height: 40px;">
                                <td style="width: 80px; text-align: right" class="l-table-edit-td"><span
                                        style="color: #f00">服务项目：</span>
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;width:240px">

                                    <input id="petServer"
                                           style="width:150px">


                                </td>
                                <td>
                                    <input id="cihldrenServer"
                                           style="width:150px" name="serviceId">
                                </td>
                                <td>
                                    <input type="text" name="costprice" class="easyui-numberbox" data-options="min:0"
                                           style="width:50px">

                                </td>

                            <tr>
                                <td class="l-table-edit-td" style="width: 80px"><span style="color: #f00">宠物名：</span>
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input data-val="true" data-val-number="字段 PetID 必须是一个数字。"
                                           data-val-required="PetID 字段是必需的。" id="PetID" name="PetID" type="hidden"
                                           value=""/>
                                    <input id="PetName" name="petname" type="text" validate="{required:true}" value=""/>
                                </td>

                            </tr>
                            <tr style="height: 40px;">
                                <td class="l-table-edit-td">主人名：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input id="MemberName" name="membername" type="text" value=""/>
                                </td>
                                <td style="width: 80px; text-align: right" class="l-table-edit-td">联系方式：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input id="MemberNumber" name="membernumber" onchange="CheckBlackList()" type="text"
                                           value=""/>
                                </td>
                            </tr>
                            <tr style="height: 40px;">
                                <td style="width: 90px" class="l-table-edit-td">预计开始时间：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input data-val="true" data-val-date="字段 ExpectStartTime 必须是日期。"
                                           id="ExpectStartTime" name="begintime" type="text" value=""
                                           class="easyui-datebox" required="required"/>
                                </td>
                                <td style="width: 90px" class="l-table-edit-td">预计结束时间：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input data-val="true" data-val-date="字段 ExpectEndTime 必须是日期。" id="ExpectEndTime"
                                           name="endtime" type="text" value="" class="easyui-datebox"
                                           required="required"/>
                                </td>
                            </tr>
                            <tr style="height: 40px;">
                                <td style="width: 80px" class="l-table-edit-td">宠物年龄：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input data-val="true" data-val-number="字段 PetAge 必须是一个数字。" id="PetAge"
                                           name="PetAge"
                                           type="text" value=""/>
                                </td>
                                <td style="width: 80px" class="l-table-edit-td">宠物品种：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">

                                    <input id="category"
                                           style="width:75px" name="categoryId">
                                    <input id="breed"
                                           style="width:75px" name="breedId">
                                </td>
                            </tr>
                            <tr style="height: 40px;">
                                <td style="width: 80px" class="l-table-edit-td">宠物性别：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                <span class="radioMagin"><input id="PetSex" name="petgender" type="radio" value="1"
                                                                checked="checked"/>弟弟
                                 <input id="PetSex" name="petgender" type="radio" value="0"/>妹妹
                                </span>
                                </td>
                                <td style="width: 80px" class="l-table-edit-td">预付款：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                    <input data-val="true" data-val-number="字段 Imprest 必须是一个数字。"
                                           data-val-required="Imprest 字段是必需的。" id="Imprest" name="Imprest" type="text"
                                           value=""/>
                                </td>
                            </tr>
                            <tr style="height: 40px;">
                                <td style="width: 80px" class="l-table-edit-td">自带物品：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                <textarea cols="20" id="PetItems" name="PetItems" rows="2">
</textarea>
                                </td>
                                <td style="width: 80px" class="l-table-edit-td">特殊备注：
                                </td>
                                <td class="l-table-edit-td" style="text-align: left;">
                                <textarea cols="20" id="PetSpecialNote" name="remark" rows="2">
</textarea>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--添加服务按钮--%>
<div id="service_btns">
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-save',plain:true" onclick="save();">添加</a>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancel();">取消</a>
</div>
<%--宠物登记按钮--%>
<div id="pet_btns">
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-save',plain:true" onclick="savePetRegister();">添加</a>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancelPetRegister();">取消</a>
</div>
<%--添加记录按钮--%>
<div id="login_btns">
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-save',plain:true" onclick="saveLogin();">添加</a>
    <a href="#" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancelLogin();">取消</a>
</div>

<%--日志--%>
<div id="register_login">
    <input id="btnPrint" type="button" value="打印预览" onclick="print()"/>
    <table>
        <tr>
            <td class="cc">宠物名：</td>
            <td id="petNamel"></td>
            <td class="cc">品种：</td>
            <td id="petVarietiesNamel"></td>
            <td class="cc">年龄：</td>
            <td id="petAgel"></td>
            <td class="cc">性别：</td>
            <td><span id="sexl"></span></td>
        </tr>
        <tr>
            <td class="cc">服务时间：</td>
            <td colspan="3"><span id="ExpectStartTimeStringl"></span><span>~</span><span
                    id="ExpectEndTimeStringl"></span></td>
            <td class="cc">自带物品：</td>
            <td colspan="3" id="PetItemsl"></td>
        </tr>
        <tr>
            <td class="cc">特殊备注：</td>
            <td colspan="5" id="PetSpecialNotel"></td>
        </tr>
    </table>
    <input data-val="true" data-val-number="字段 ServiceListID 必须是一个数字。" data-val-required="ServiceListID 字段是必需的。"
           id="ServiceListID" name="ServiceListID" style="display:none" type="text" value=""/>
    <a id="addData" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addData();">添加记录</a>
    <table id="datagrid_login"></table>
</div>

<%--添加记录弹出框--%>
<div id="dialog_addData">
    <form method="post" id="addData_form">
        <table>
            <tr>
                <td class="l-table-edit-td" style="width: 80px">记录时间：</td>
                <td class="easyui-datebox" required="required" style="text-align: left;width:120px"><input
                        data-val="true" data-val-date="字段 Time 必须是日期。" id="Time" name="Time" type="text"
                        value="2017/8/27 20:07:00"/></td>
            </tr>
            <tr>
                <td class="l-table-edit-td" style="width: 80px">详情：</td>
                <td class="l-table-edit-td" style="text-align: left;"><textarea cols="20" id="ServiceNote"
                                                                                name="ServiceNote" rows="2"
                                                                                style="width:250px;height:166px">
宠物登记</textarea></td>
            </tr>
        </table>
    </form>
</div>

<%--打印窗口--%>
<div id="dialog_print">
    <table>
        <tr>
            <td class="cc">宠物名：</td>
            <td><span id="PetNamep"></span></td>
            <td class="cc">品种：</td>
            <td><span id="PetVarietiesNamep"></span></td>
            <td class="cc">年龄：</td>
            <td><span id="PetAgep"></span></td>
            <td class="cc">性别：</td>
            <td><span id="Sexp"></span></td>
        </tr>
        <tr>
            <td class="cc">服务时间：</td>
            <td colspan="3"><span id="ExpectStartTimeStringp"></span><span>~</span><span
                    id="ExpectEndTimeStringp"></span></td>
            <td class="cc">自带物品：</td>
            <td colspan="3"><span id="PetItemsp"></span></td>
        </tr>
        <tr>
            <td class="cc">特殊备注：</td>
            <td colspan="5"><span id="PetSpecialNotep"></span></td>
        </tr>
    </table>
    <table style="width: 100%;" border="1">
        <tr>
            <td style="text-align: center; font-weight: bold; font-size: 16px;" colspan="2">服务记录</td>
        </tr>
        <tr style="width: 100%">
            <th>
                <div align="center"
                     style="width: 40%; height: 24px; line-height: 24px; font-weight: bold; font-size: 14px; text-align: center">
                    <span>时间</span>
                </div>
            </th>
            <th>
                <div align="center"
                     style="width: 60%; height: 24px; line-height: 24px; font-weight: bold; font-size: 14px; text-align: center">
                    <span>记录</span>
                </div>
            </th>
        </tr>
        <tr>
            <td style="width: 40%; height: 24px; line-height: 24px; font-size: 13px; padding-left: 10px;">
                <div align="left">2017/8/26 15:17:01</div>
            </td>
            <td style="width: 60%; height: 24px; line-height: 24px; font-size: 13px; padding-left: 10px;">
                <div align="left">宠物登记</div>
            </td>
        </tr>
    </table>
</div>
<%--训练课程对话框--%>
<div id="dialog_class" style="align-content: center">该宠物无具体项信息!</div>

<%--右键菜单定义如下：--%>
<div id="service_menu" class="easyui-menu" style="width:120px;">
    <div onclick="addService();" data-options="iconCls:'icon-add'">增加</div>
    <div onclick="editSerivce()" data-options="iconCls:'icon-edit'">修改</div>
    <div onclick="removeSerivce()" data-options="iconCls:'icon-remove'">删除</div>
    <div onclick="showSerivce()">具体内容</div>
</div>
<%--右键数据列表定义如下：--%>
<div id="register_menu" class="easyui-menu" style="width:120px;">
    <div onclick="addClass();">训练课程</div>
    <div onclick="petPay()">付款</div>
    <div onclick="runSerivce()">进行中</div>
    <div onclick="endSerivce()">已结束</div>
    <div onclick="cancelSerivce()">取消服务</div>
</div>
</body>
</html>