<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="/static/css/orderBill.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%@include file="/static/common/common.jsp" %>
    <script type="text/javascript" src="/static/js/stockOutcomeBill.js"></script>
</head>
<body>
<div id="stockOutcomeBill_tb">
    <form id="ff" method="post">
        <div class="spxin">
            <input type="text" name="productSn" placeholder="输入商品条码" onchange="changeProduct()" class="kuan"/>
            <%--隐藏的id--%>
            <input type="hidden" name="id">
            <div class="spxin_title">商品条码：</div>
            <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="GoodsNumber"
                                              data-valmsg-replace="true"></span></font></span>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>库存编码：</div>
            <div style="position: relative; width: 68%; float: left">
                <input type="text" name="sn" placeholder="系统默认，可自定义！" class="kuan" style="width: 100%"/>
            </div>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>商品名称：</div>
            <div style="position: relative; width: 68%; float: left">
                <input type="text" name="productName" class="kuan"
                       style="width: 100%"/>
                <div class="pic" id="picture">
                    <img src="#" style="width: 200px; height: 220px; border-radius: 20px"/>
                </div>
            </div>
        </div>
        <%-- <div class="spxin">
             <div class="spxin_title">商品类别：</div>
             <input type="text"  name="productCategory"  style="display: none;" id="productCategory" class="kuan"/>
             <select class="kuan" data-val="true" name="productCategory">
                 <option value="1">无</option>
             </select>
             <span class="wtps"><span class="field-validation-valid" data-valmsg-for="ClassificationName" data-valmsg-replace="true"></span></span>
         </div>--%>
        <div class="spxin">
            <div class="spxin_title">入货商铺：</div>
            <input type="text" id="OutInWayIDT" name="OutInWayIDT" placeholder="输入你要添加的内容" style="display: none;"/>
            <select class="kuan" data-val="true" data-val-number="字段 OutInWayID 必须是一个数字。" id="subStore" name="subStore">
                <option value="1号分店">1号分店</option>
                <option value="2号分店">2号分店</option>
                <option value="3号分店">3号分店</option>
            </select>
            <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;" onclick="showSrc('OutInWayID','OutInWayIDT','OutInWayIDG')">
                <img id="OutInWayIDG" class="spxin_img"/></a>
            <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="OutInWayID"
                                              data-valmsg-replace="true"></span></font></span>
        </div>
        <div class="spxin">
            <div class="spxin_title">商品类别:</div>
            <input type="text" name="productCategory" style="display: none;" id="productCategory"/>
        </div>

        <%--<div class="spxin">
            <div class="spxin_title">生产产地：</div>
            <input type="text" id="ManufacturersIDT" name="product.manufacturerId" placeholder="输入你要添加的内容" class="kuan" style="display: none;"/>
            <select class="kuan" data-val="true" data-val-number="字段 ManufacturersID 必须是一个数字。" id="ManufacturersID" name="ManufacturersID">
                <option value="1">无</option>
                <option value="2"> 泰国</option>
            </select>
            <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;"
               onclick="showSrc('ManufacturersID','ManufacturersIDT','ManufacturersIDG')">
                <img id="ManufacturersIDG" class="spxin_img" src="/Images/update.png"/></a>
            <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="ManufacturersID"
                                              data-valmsg-replace="true"></span></font></span>
        </div>--%>
        <div>
            <%-- <div class="spxin_title">商品品牌：</div>
             <input type="text" id="productBrand" name="productBrand" style="display: none;" class="kuan"/>
             <select class="kuan" data-val="true" data-val-number="字段 BrandID 必须是一个数字。" id="BrandID" name="productBrand">
                 <option value="1">无</option>
             </select>
             <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;" onclick="showSrc('BrandID','BrandIDT','BrandIDG')">
                 <img id="BrandIDG" class="spxin_img" src="/Images/update.png"/></a>
             <span class="wtps"><span class="field-validation-valid" data-valmsg-for="BrandName" data-valmsg-replace="true"></span></span>--%>

            <div class="spxin">
                <div class="spxin_title">商品品牌:</div>
                <input type="text" name="productBrand" style="display: none;" id="productBrand"/>
            </div>
        </div>
        <%--  <div class="spxin">
              <div class="spxin_title">主要成分：</div>
              <input type="text" id="GoodsBasesT" name="GoodsBasesT" placeholder="输入你要添加的内容" class="kuan" style="display: none;"/>
              <select class="kuan" id="GoodsBases" name="GoodsBases">
                  <option value="无">无</option>
                  <option value="三文鱼,金枪鱼,鸡肉">三文鱼,金枪鱼,鸡肉</option>
                  <option value="猪黑肉">猪黑肉</option>
              </select>
              <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;" onclick="showSrc('GoodsBases','GoodsBasesT','GoodsBasesG')">
                  <img id="GoodsBasesG" class="spxin_img" src="/Images/update.png"/></a>
              <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="GoodsBases"
                                                data-valmsg-replace="true"></span></font></span>
          </div>--%>

        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>原有规格：</div>
            <select class="kuan" data-val="true" data-val-number="字段 ClassificationID 必须是一个数字。" name="productSpecification">
                <option value="把">把</option>
                <option value="次">次</option>
                <option value="个">个</option>
                <option value="根">根</option>
                <option value="罐">罐</option>
                <option value="盒">盒</option>
                <option value="件">件</option>
                <option value="粒">粒</option>
            </select>
        </div>
        <%--分隔--%>
        <div class="spxin">
        </div>
        <%--分隔--%>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>数量：</div>
            <input class="kuan" data-val="true" data-val-number="字段 PutInStorageCount 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+$" data-val-required="*" id="PutInStorageCount"
                   name="count" onBlur="Check(this)" placeholder="大于0的整数" style="width:100px;" type="text" value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>发货价：</div>
            <input class="kuan" data-val="true" data-val-number="字段 GoodsPurchasePrice 必须是一个数字。" data-val-range=">0" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   id="GoodsPurchasePrice" name="costPrice" onBlur="Check(this)" style="width:100px;" type="text"
                   value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>商品价格：</div>
            <input class="kuan" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   id="GoodsPriceTag" name="saleprice" onBlur="Check(this)" style="width:100px;" type="text" value=""/>
        </div>
        <div class="spxin">

            <div class="spxin_title">会员价格：</div>
            <input name="discount" type="text" class="kuan"/>
        </div>
        <%--分隔用--%>
        <%-- <div class="spxin">
         </div>--%>
        <%--分隔用--%>
        <%--第二部分--%>

        <%-- <div class="spxin">
             <div class="spxin_title"><span style="color: #cc0000">*</span>拆分规格：</div>

             <select class="kuan" data-val="true" data-val-number="字段 ClassificationID 必须是一个数字。" name="ClassificationID">
                 <option value="把">把</option>
                 <option value="次">次</option>
                 <option value="个">个</option>
                 <option value="根">根</option>
                 <option value="罐">罐</option>
                 <option value="盒">盒</option>
                 <option value="件">件</option>
                 <option value="粒">粒</option>
             </select>
         </div>
         <div class="spxin">
             <div class="spxin_title"><span style="color: #cc0000">*</span>拆零份数：</div>
             <input class="kuan" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                    data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                    placeholder="拆零份数" style="width:100px;" type="text" value=""/>
         </div>--%>
        <%--<div class="spxin">
        </div>--%>
        <%--第三部分--%>
        <%-- <div class="spxin">
         </div>--%>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>生产日期：</div>
            <input class="easyui-datebox" data-val="true" data-val-number="字段 PutInStorageCount 必须是一个数字。" data-val-range=">0！"
                   data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+$" data-val-required="*"
                   name="productDate" onBlur="Check(this)" placeholder="大于0的整数" style="width:100px;" type="text" value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>保质期：</div>
            <input class="easyui-datebox" data-val="true" data-val-number="字段 GoodsPurchasePrice 必须是一个数字。" data-val-range=">0"
                   data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   name="warrantyDate" onBlur="Check(this)" style="width:100px;" type="text"
                   value=""/>
        </div>
        <%-- <div class="spxin">
             <div class="spxin_title"><span style="color: #cc0000">*</span>预警日期：</div>
             <input class="easyui-datebox" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！"
                    data-val-range-max="2147483647"
                    data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                    name="" style="width:100px;" type="text" value=""/>
         </div>--%>
        <%--<div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>预警数量：</div>
            <input class="kuan" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   style="width:100px;" type="text"/>
        </div>--%>
        <div class="spxin">
        </div>
        <div class="spxin">
        </div>
    </form>
    <div>
        <a class="easyui-linkbutton" id="emp_tb_edit"
           data-options="iconCls:'icon-save',plain:true" data-cmd="edit" onclick="add();">保存订单</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true"
           data-cmd="removeBill" onclick="removeStockOutcomeBill();">删除</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true"
           data-cmd="removeBill" onclick="editStockOutcomeBill();">编辑</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true"
           data-cmd="removeBill" onclick="reloadBill();">刷新</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true"
           data-cmd="storeIn" onclick="AllOutStock();">全部出库</a>
    </div>
</div>
<table id="stockOutcomeBill_datagrid">
</table>


</body>
</html>