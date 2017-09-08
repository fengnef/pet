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
    <script type="text/javascript" src="/static/js/orderBill.js"></script>
</head>
<body>


<div id="orderBill_tb">
    <form id="ff" method="post">
        <div class="spxin">
            <%--隐藏的id--%>
            <input type="hidden" name="id">
            <div class="spxin_title">商品条码：</div>
            <input type="text" class="kuan" name="productSn" placeholder="输入商品条码" onchange="changeProduct();"/>

            <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="GoodsNumber"
                                              data-valmsg-replace="true"></span></font></span>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>库存编码：</div>
            <div style="position: relative; width: 68%; float: left">
                <input type="text" name="sn" placeholder="系统默认，可自定义！" class="kuan" style="width: 100%"
                       onchange="IChoose()"/>
            </div>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>商品名称：</div>
            <div style="position: relative; width: 68%; float: left">
                <input type="text" name="productName" placeholder="商品名称" class="kuan" oninput="Search();"
                       style="width: 100%"/>
                <div class="pic" id="picture">
                    <img src="#" style="width: 200px; height: 220px; border-radius: 20px"/>
                </div>
            </div>
        </div>
        <div class="spxin">
            <div class="spxin_title">商品类别：</div>
            <input type="text" name="productCategory" style="display: none;" id="productCategory"/>
            <span class="wtps"><span class="field-validation-valid" data-valmsg-for="ClassificationName" data-valmsg-replace="true"></span></span>
        </div>

        <%--  <div class="spxin">
              <div class="spxin_title">生产产地：</div>
              <input type="text" id="ManufacturersIDT" name="product.manufacturerId" placeholder="输入你要添加的内容" class="kuan" style="display: none;"/>
              <select class="kuan" data-val="true" data-val-number="字段 ManufacturersID 必须是一个数字。" id="ManufacturersID" name="ManufacturersID">
                  <option value="1">无</option>
                  <option value="2"> 泰国</option>
              </select>
              <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;"
                 onclick="showSrc('ManufacturersID','ManufacturersIDT','ManufacturersIDG')">
                  <img id="ManufacturersIDG" class="spxin_img" src=""/></a>
              <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="ManufacturersID"
                                                data-valmsg-replace="true"></span></font></span>
          </div>--%>

        <div class="spxin">
            <div class="spxin_title">商品品牌：</div>
            <input type="text" id="productBrand" name="productBrand" style="display: none;"/>
            <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;" onclick="showSrc('BrandID','BrandIDT','BrandIDG')">
                <img id="BrandIDG" class="spxin_img"/></a>
            <span class="wtps"><span class="field-validation-valid" data-valmsg-for="BrandName" data-valmsg-replace="true"></span></span>
        </div>
        <%-- <div class="spxin">
             <div class="spxin_title">主要成分：</div>
             <input type="text" id="GoodsBasesT" name="GoodsBasesT" placeholder="输入你要添加的内容" class="kuan" style="display: none;"/>
             <select class="kuan" id="GoodsBases" name="GoodsBases">
                 <option value="无">无</option>
                 <option value="三文鱼,金枪鱼,鸡肉">三文鱼,金枪鱼,鸡肉</option>
                 <option value="猪黑肉">猪黑肉</option>
             </select>
             <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;" onclick="showSrc('GoodsBases','GoodsBasesT','GoodsBasesG')">
                 <img id="GoodsBasesG" class="spxin_img"/></a>
             <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="GoodsBases"
                                               data-valmsg-replace="true"></span></font></span>
         </div>--%>

        <%-- <div class="spxin">
             <div class="spxin_title">入库方式：</div>
             <input type="text" id="OutInWayIDT" name="OutInWayIDT" placeholder="输入你要添加的内容" class="kuan" style="display: none;"/>
             <select class="kuan" data-val="true" data-val-number="字段 OutInWayID 必须是一个数字。" id="OutInWayID" name="OutInWayID">
                 <option value="1">无</option>
                 <option value="2">进货</option>
                 <option value="10">借调</option>
                 <option value="12">自销</option>
             </select>
             <a style="width: 20px; height: 25px; margin-top: 8px; margin-left: 5px;" onclick="showSrc('OutInWayID','OutInWayIDT','OutInWayIDG')">
                 <img id="OutInWayIDG" class="spxin_img"/></a>
             <span><font color="#FF0000"><span class="field-validation-valid" data-valmsg-for="OutInWayID"
                                               data-valmsg-replace="true"></span></font></span>
         </div>--%>

        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>进货数量：</div>
            <input class="kuan" data-val="true" data-val-number="字段 PutInStorageCount 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+$" data-val-required="*" id="PutInStorageCount"
                   name="count" onBlur="Check(this)" placeholder="大于0的整数" style="width:100px;" type="text" value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>进价：</div>
            <input class="kuan" data-val="true" data-val-number="字段 GoodsPurchasePrice 必须是一个数字。" data-val-range=">0" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   id="GoodsPurchasePrice" name="costPrice" onBlur="Check(this)" placeholder="商品进价" style="width:100px;" type="text"
                   value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>商品价格：</div>
            <input class="kuan" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   id="GoodsPriceTag" name="saleprice" onBlur="Check(this)" placeholder="商品标价" style="width:100px;" type="text" value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title">会员价格：</div>
            <input name="discount" type="text" class="kuan"/>
        </div>
        <%--第二部分--%>
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
        <%--  <div class="spxin">
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
          </div>--%>
        <%--  <div class="spxin">
              <div class="spxin_title"><span style="color: #cc0000">*</span>拆零份数：</div>
              <input class="kuan" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                     data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                     onBlur="Check(this)" placeholder="拆零份数" style="width:100px;" type="text" value=""/>
          </div>
          <div class="spxin">
          </div>--%>

        <%--第三部分--%>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>生产日期：</div>
            <input class="easyui-datebox" name="productDate" data-val="true" data-val-number="字段 PutInStorageCount 必须是一个数字。" data-val-range=">0！"
                   data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+$" data-val-required="*"
                   style="width:100px;" type="text" value=""/>
        </div>
        <div class="spxin">
            <div class="spxin_title"><span style="color: #cc0000">*</span>保质期：</div>
            <input class="easyui-datebox" data-val="true" name="warrantyDate" data-val-number="字段 GoodsPurchasePrice 必须是一个数字。" data-val-range=">0"
                   data-val-range-max="2147483647"
                   data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                   onBlur="Check(this)" style="width:100px;" type="text"
                   value=""/>
        </div>
        <%-- <div class="spxin">
             <div class="spxin_title"><span style="color: #cc0000">*</span>预警日期：</div>
             <input class="easyui-datebox" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！"
                    data-val-range-max="2147483647"
                    data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                    style="width:100px;" type="text" value=""/>
         </div>
         <div class="spxin">
             <div class="spxin_title"><span style="color: #cc0000">*</span>预警数量：</div>
             <input class="kuan" data-val="true" data-val-number="字段 GoodsPriceTag 必须是一个数字。" data-val-range=">0！" data-val-range-max="2147483647"
                    data-val-range-min="0" data-val-regex=" 数值" data-val-regex-pattern="^[0-9]+(.[0-9]{1,6})?$" data-val-required="*"
                    style="width:100px;" type="text" value=""/>
         </div>--%>
    </form>
    <div>
        <a class="easyui-linkbutton" id="emp_tb_edit"
           data-options="iconCls:'icon-save',plain:true" data-cmd="edit" onclick="add();">保存订单</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true" id="emp_tb_cs"
           data-cmd="removeBill" onclick="removeBill();">删除</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-edit',plain:true"
           data-cmd="removeBill" onclick="editBill();">编辑</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true"
           data-cmd="reload" onclick="reloadBill();">刷新</a>
        <a class="easyui-linkbutton"
           data-options="iconCls:'icon-add',plain:true" id="AllInStock"
           data-cmd="storeIn" onclick="AllInStock();">全部入库</a>
    </div>
</div>
<table id="orderBill_datagrid">
</table>

</body>
</html>