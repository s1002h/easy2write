<#--
//宏名字 page
//引入base宏
-->
<#macro page title js=[] css=[] keywords="">

<#include "base.ftl">
<#--
//标题 js css等让下一级扩展页传入 keywords本页赋值
//以下内容将被嵌套至base宏中#nested指令处， 注意内容中又包含一个#nested指令
-->
<@base base_title=title base_js=js base_css=css base_keywords="个人博客,java,初">
<div class="container">    
    <div class="blog-header">
        <h1 class="blog-title">初的博客</h1>
        <p class="lead blog-description">唯爱、技术和美食三者不可辜负.</p>
    </div>
    <div class="row">
        <div class="col-sm-8 blog-main">
        <#--  //该指令表明下一级扩展页内容将被嵌套至此  -->
        <#nested>
    </div>
 
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <h4>Hi</h4>
                <p>欢迎来到我的博客</p>
            </div>
            <#-- <div class="sidebar-module">
                <h4>标签</h4>
                <ol class="list-unstyled">
                    <li><a href="#">March 2014</a></li>
                </ol>
            </div>
            -->
            <div class="sidebar-module">
                <h4>档案</h4>
                <ol id="articleFilings" class="list-unstyled">
                </ol>
            </div>
        </div>
    </div>
</div>
</@base>
</#macro>