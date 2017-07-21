<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<div class="g-doc">
<#if product.pid<0>
    <div class="n-result">
        <h3>内容不存在！</h3>
    </div>
<#else>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${product.image}" alt=""></div>
        <div class="cnt">
            <h2>${product.title}</h2>
            <p class="summary">${product.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${product.price}</span>
            </div>

            <#if user??>
                <#if user.userType==0>
                    <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">${product.buyNum!1}</span><span
                            id="addNum" class="moreNum"><a>+</a></span></div>
                </#if>
            </#if>

            <div class="oprt f-cb">
                <#if user??>
                    <#if user.userType==0>
                        <#if product.isBuy==1>
                            <button class="u-btn u-btn-primary" id="add" data-id="${product.pid}"
                                    data-title="${product.title}" data-price="${product.price}">
                                再次购买
                            </button>
                            <span class="buyprice">当时购买价格：¥${product.buyPrice}</span>
                        <#else>
                            <button class="u-btn u-btn-primary" id="add" data-id="${product.pid}"
                                    data-title="${product.title}" data-price="${product.price}">
                                加入购物车
                            </button>
                        </#if>
                    <#else >
                        <a href="/edit?pid=${product.pid}" class="u-btn u-btn-primary">编 辑</a>
                        <span class="buyprice">已售出：${product.sellNum!0}</span>
                    </#if>
                </#if>


            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
    ${product.detail}
    </div>
</#if>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>