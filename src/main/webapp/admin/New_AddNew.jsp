<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/admin.css">


<script src="${pageContext.request.contextPath}/admin/js/kindeditor-min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/pintuer.js"></script>

<script src="${pageContext.request.contextPath}/admin/ckeditor/ckeditor.js"></script>  <!--  注意，这里的src地址为 ckeditor中ckeditor.js 文件的位置，请根据您自己的地址填写 -->

  <style>
    input{
      height:35px;
    }
    .form-group{
      margin-bottom: 6px;
    }
  </style>


<!--  注意，这里的src地址为 ckeditor，将下面的代码复制到JSP中（head标签之间）-->
<script type="text/javascript">
	window.onload = function(){
	CKEDITOR.replace('content');
}
</script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加新闻</strong></div>
  
  <div class="padding border-bottom">
			<ul class="search" style="padding-left: 10px;">
				<li><a class="button border-main icon-plus-square-o"
					href="${pageContext.request.contextPath}/findAllNews">
						返回管理</a></li>
			</ul>
		</div>
		
		
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/addNews">

      <div class="form-group">
        <div class="label">
          <label for="sitename">新闻标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="title" size="50" placeholder="请输入新闻标题" data-validate="required:请输入新闻标题" />
          

        </div>
      </div>
      
      
      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新闻类型：</label>
        </div>
        <div class="field">
            <select name="type" id="type" style="height:35px;width:120px;">
                <c:forEach items="${newsType}" var="c" varStatus="vs">
                <option value="${c.typeName}" selected="selected">${c.typeName}</option>
                </c:forEach>
            </select>
            
        </div>
      </div>
      
      
      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新闻内容：</label>
        </div>
        <div class="field">
          <textarea id="content" name="content" style="width: 80%; height: 450px; border: 0 none; visibility: hidden;"></textarea>
        </div>
      </div>

        <div class="form-group">
        <div class="label">
          <label for="sitename">发布作者：</label>
        </div>
        <div class="field">
          <input name="author" type="text" class="input w50" id="author" placeholder="请输入发布作者" size="50" data-validate="required:请输入发布作者" />

        </div>
      </div>




      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 确认添加</button>
        </div>
      </div>      
    </form>
  </div>
</div>
<script>
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('.pic', {
            resizeType : 1,
             items : [
                 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                 'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                 'insertunorderedlist', '|', 'emoticons', 'image', 'link']

//            items : [
//                'image']
        });
    });
</script>
${successa}
</body></html>