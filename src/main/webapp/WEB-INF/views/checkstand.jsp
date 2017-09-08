<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/checkstand.js"></script>
</head>
<body>
<div id="cc" class="easyui-layout" style="height: auto">
    <form id="cs_form" method="post">
        <table id="cs_datagrid">
            <font size=2>商品69编码/库存编码:</font>
            <input id="cs_sn" type="text"/><img src="/static/plugins/login/images/index.png" style="vertical-align: middle"/>

            <font size=2>&nbsp;&nbsp;&nbsp;&nbsp;商品名称:</font><input id="cs_name" type="text"/>
            <input id="View" type="button" value="收银记录"
                   onclick="top.f_addTab('收银记录', '收银记录', '/checkstandRecord.do');"
                   style="width: 100px; height: 30px;float: right; margin-left: 20px;background-color: #4cae4c"></td>
        </table>

        <div id="cs_dialog">
            <input type="hidden" name="id"/>
            <table align="center" style="margin-top: 15px">
                <tbody>
                <tr>
                    <td>库存编码:</td>
                    <td>
                        <input type="text" name="productstock_sn"/>
                    </td>
                </tr>
                <tr>
                    <td>商品69条码:</td>
                    <td>
                        <input type="text" name="sn"/>
                    </td>
                </tr>
                <tr>
                    <td>商品名称:</td>
                    <td>
                        <input type="text" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>原价(元):</td>
                    <td>
                        <input type="text" name="saleprice"/>
                    </td>
                </tr>
                <tr>
                    <td>折扣:</td>
                    <td>
                        <input type="text" name="xxx"/>
                    </td>
                </tr>
                <tr>
                    <td>会员价(元):</td>
                    <td>
                        <input type="text" name="memberPrice"/>
                    </td>
                </tr>
                <tr>
                    <td>数量:</td>
                    <td>
                        <input type="text" name="count"/>
                    </td>
                </tr>
                <tr>
                    <td>单位:</td>
                    <td>
                        <input type="text" name="unit"/>
                    </td>
                </tr>
                <tr>
                    <td>拆零:</td>
                    <td>
                        <input type="text" name="scattered"/>
                    </td>
                </tr>
                <tr>
                    <td>原价(元):</td>
                    <td>
                        <input type="text" name="qqq"/>
                    </td>
                </tr>
                <tr>
                    <td>会员价(元):</td>
                    <td>
                        <input type="text" name="www"/>
                    </td>
                </tr>
                <tr>
                    <td>服务人员:</td>
                    <td>
                        <input type="text" name="username"/>
                    </td>
                </tr>
                <tr>
                    <td>操作: <a href="#">删除</a></td>
                    <td>

                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>

<div>
    <table>
        <tr>
            <td><font size=2>会员卡号：</font><input type="text"/>
            </td>
            <td style="text-align: left; width: 160px"><font size=2>会员姓名：</font>
            </td>
            <td style="text-align: right; width: 160px"><font size=2>现有金额：</font>
            </td>
            <td style="text-align: right; width: 160px"><font size=2>会员等级：</font>
            </td>
            <td style="text-align: right; width: 160px"><font size=2>商品折扣：</font>
            </td>
            <td style="text-align: right; width: 160px"><font size=2>服务折扣：</font>
            </td>
            <td style="text-align: left; width: 80px">
                <span id="ServerProption" style="color: black; text-align: left"></span>%
            </td>
        </tr>
    </table>
</div>

<div id="cs_get">
    <form action="#" method="post">
        <table class="easyui-datagrid" style="width:480px;height:340px" data-options="pagination:true, singleSelect:true">
            <thead>
            <tr>
                <th data-options="field:'code'">挂单时间</th>
            </tr>
            </thead>
        </table>
    </form>
</div>


<div data-options="region:'south',title:'South Title',split:true" style="height: 50px">
    <span style="width: 80px"><font size=2>应收金额：</font></span>
    <input id="Price" name="Price" style="height:20px;width:100px;font-size:20px" type="text" value=""/>
    <span><font size=2>元</font></span>
    <span style="margin-left: 15px"><font size=2>实收金额：</font></span>
    <input data-val="true" data-val-number="字段 DiscountPrice 必须是一个数字。" data-val-required="DiscountPrice 字段是必需的。" id="DiscountPrice"
           name="DiscountPrice" style="height:20px;width:100px;font-size:20px" type="text" value=""/>
    <span><font size=2>元</font></span>
    <span id="fangshi" style="margin-left:20px;"><font size=2>收款方式：</font></span>
    <select id="Display" class="input_check" style="width: 80px">
        <option value="1">现金</option>
        <option value="2">微信</option>
        <option value="3">支付宝</option>
    </select>
    <br/>
    <br/>
    <input id="PayMoney" type="button"  value="现金结账" onclick="sumPriceMoney();"
           style="float: left;margin-top: -20px;margin-left: 20px; width: 100px; ">
    <input id="Waiting" type="button"  value="挂单" onclick="Waiting(); "
           style="width: 100px;float: left; margin-top: -20px;margin-left: 30px;">
    <input id="GetWaiting" type="button" class="btn_get" value="取单" onclick="get()"
           style="width: 100px;float: left; margin-top: -20px;margin-left: 40px;">
</div>

<div id="cs_btns">
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-ok',plain:true" onclick="save()">确定</a>
    <a class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true" onclick="cancel()">取消</a>
</div>


<!--小票 -->
<div id="dayprint" style="display: none">
    <!--startprint1-->
    <div id="PrintInfo">
        <div id="Print" style="width: 163px; height: auto;">
            <div id="StoreName" class="StoreName"></div>
            <div id="SzalesInfo"></div>
            <div id="GoodsInfo">
                <table border="0"
                       style="width: 100%; border-collapse: initial; font-size: 8px; text-align: center; border-bottom: 1px dashed #666; padding: 6px 0; line-height: 12px;">
                    <tbody id="goodstable" style="font-size: 8px;">
                    <tr style="height: 14px; font-size: 9px;">
                        <h5>单号:ON20170831732568</h5>
                        <h5>卡号:(非会员)</h5>
                        <p><h5>日期:2017/9/1 下午5:39:24</h5></p>
                        <p><h5>商品名: 吉米娃娃923-18</h5></p>
                        -------------------
                        <td>数量
                            <h5>1.00</h5>
                        </td>
                        <td>单价
                            <h5>150.00</h5>
                        </td>
                        <td>金额
                            <h5>150.00</h5>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="PriceInfo"></div>
            <div id="Code">
                <div style="width: 140px; margin: 10px auto; font-size: 8px; line-height: 12px; text-align: center;">
                    <img src="/static/png/ewn.jpg" style="width: 140px; height: 160px; margin: 0px auto;">
                    <span>谢谢惠顾，欢迎再次光临！</span><br/>
                    <span id="storephone"></span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
