<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>新闻信息管理系统</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/pintuer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/admin.css">
<script src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />新闻后台管理系统
			</h1>
		</div>
		<div class="head-l" style="float: right; margin-right: 2%;">
			<span style="color: white"><span style="color: lightblue">${message}</span>
				登录</span> <span style="margin-left: 20px; margin-right: 30px; color: white">身份：<span
				style="color: lightblue;">管理员</span></span> <a
				class="button button-little bg-red"
				href="${pageContext.request.contextPath}/exit">
				<span class="icon-power-off"></span> 退出登录
			</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>

		<h2>
			<span class="icon-pencil-square-o"></span>管理员管理
		</h2>
		<ul style="display: block;">
			<li><a
				href="${pageContext.request.contextPath}/goAddAdmin"
				target="right"> <span class="icon-caret-right"></span>添加管理员
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/findAllAdmin"
				target="right"> <span class="icon-caret-right"></span>管理员列表
			</a></li>
		</ul>
		
		<h2>
			<span class="icon-pencil-square-o"></span>新闻类型管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/goAddNewsType"
				target="right"> <span class="icon-caret-right"></span>添加新闻类型
			</a></li>
			<li><a href="${pageContext.request.contextPath}/findAllNewsType"
				target="right"> <span class="icon-caret-right"></span>新闻类型列表
			</a></li>
		</ul>
		
		<h2>
			<span class="icon-pencil-square-o"></span>新闻管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/NewsgoAddNews"
				target="right"> <span class="icon-caret-right"></span>添加新闻
			</a></li>
			<li><a href="${pageContext.request.contextPath}/findAllNews"
				target="right"> <span class="icon-caret-right"></span>新闻列表
			</a></li>
		</ul>
		
		<h2>
			<span class="icon-pencil-square-o"></span>轮播图管理
		</h2>
		<ul>
			<li><a
				href="${pageContext.request.contextPath}/admin/Banner_AddBanner.jsp"
				target="right"> <span class="icon-caret-right"></span>添加轮播图
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/BannerServlet?method=findAllBanner"
				target="right"> <span class="icon-caret-right"></span>轮播图列表
			</a></li>
		</ul>


		<h2>
			<span class="icon-pencil-square-o"></span>学院概况
		</h2>
		<ul>
			<li><a
				href="${pageContext.request.contextPath}/AboutServlet?method=goAddAbout"
				target="right"> <span class="icon-caret-right"></span>添加概况
			</a></li>
			<li><a
				href="${pageContext.request.contextPath}/AboutServlet?method=findAllAbout"
				target="right"> <span class="icon-caret-right"></span>概况列表
			</a></li>
		</ul>




		

		


		<h2>
			<span class="icon-pencil-square-o"></span>教学类型管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/TeacherTypeServlet?method=goAddTeacherType"
				target="right"> <span class="icon-caret-right"></span>添加教学类型
			</a></li>
			<li><a href="${pageContext.request.contextPath}/TeacherTypeServlet?method=findAllTeacherType"
				target="right"> <span class="icon-caret-right"></span>教学类型列表
			</a></li>
		</ul>


		<h2>
			<span class="icon-pencil-square-o"></span>教学管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/TeacherServlet?method=goAddTeacher"
				target="right"> <span class="icon-caret-right"></span>添加教学
			</a></li>
			<li><a href="${pageContext.request.contextPath}/TeacherServlet?method=findAllTeacher"
				target="right"> <span class="icon-caret-right"></span>教学列表
			</a></li>
		</ul>


		<h2>
			<span class="icon-pencil-square-o"></span>招就类型管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/JobTypeServlet?method=goAddJobType"
				target="right"> <span class="icon-caret-right"></span>添加招就类型
			</a></li>
			<li><a href="${pageContext.request.contextPath}/JobTypeServlet?method=findAllJobType"
				target="right"> <span class="icon-caret-right"></span>招就类型列表
			</a></li>
		</ul>

		<h2>
			<span class="icon-pencil-square-o"></span>招就管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/JobServlet?method=goAddJob"
				target="right"> <span class="icon-caret-right"></span>添加招就
			</a></li>
			<li><a href="${pageContext.request.contextPath}/JobServlet?method=findAllJob"
				target="right"> <span class="icon-caret-right"></span>招就列表
			</a></li>
		</ul>

        <h2>
			<span class="icon-pencil-square-o"></span>校务类型管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/SchoolTypeServlet?method=goAddSchoolType"
				target="right"> <span class="icon-caret-right"></span>添加校务类型
			</a></li>
			<li><a href="${pageContext.request.contextPath}/SchoolTypeServlet?method=findAllSchoolType"
				target="right"> <span class="icon-caret-right"></span>校务类型列表
			</a></li>
		</ul>


        <h2>
			<span class="icon-pencil-square-o"></span>校务管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/SchoolServlet?method=goAddSchool"
				target="right"> <span class="icon-caret-right"></span>添加校务
			</a></li>
			<li><a href="${pageContext.request.contextPath}/SchoolServlet?method=findAllSchool"
				target="right"> <span class="icon-caret-right"></span>校务列表
			</a></li>
		</ul>

        <h2>
			<span class="icon-pencil-square-o"></span>书香类型管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/LibraryTypeServlet?method=goAddLibraryType"
				target="right"> <span class="icon-caret-right"></span>添加书香类型
			</a></li>
			<li><a href="${pageContext.request.contextPath}/LibraryTypeServlet?method=findAllLibraryType"
				target="right"> <span class="icon-caret-right"></span>书香类型列表
			</a></li>
		</ul>


        <h2>
			<span class="icon-pencil-square-o"></span>书香管理
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/LibraryServlet?method=goAddLibrary"
				target="right"> <span class="icon-caret-right"></span>添加书香
			</a></li>
			<li><a href="${pageContext.request.contextPath}/LibraryServlet?method=findAllLibrary"
				target="right"> <span class="icon-caret-right"></span>书香列表
			</a></li>
		</ul>
        

        <h2><span class="icon-pencil-square-o"></span>网上客户管理</h2>
		<ul>
		
		     <li><a href="${pageContext.request.contextPath}/admin/MessageCustomer_RegisterCustomer.jsp" target="right"> 
			       <span class="icon-caret-right"></span>客户注册
			    </a>
			</li>
			<li><a href="${pageContext.request.contextPath}/admin/MessageCustomer_LoginCustomer.jsp" target="right"> 
			       <span class="icon-caret-right"></span>客户登录
			    </a>
			</li>
			<li><a href="${pageContext.request.contextPath}/MessageCustomerServlet?method=goAddCustomer" target="right"> 
			       <span class="icon-caret-right"></span>添加客户
			    </a>
			</li>
			<li><a href="${pageContext.request.contextPath}/MessageCustomerServlet?method=findAllCustomer" target="right"> 
			       <span class="icon-caret-right"></span>客户列表
			    </a>
			</li>
		</ul>
        
                <h2>
			<span class="icon-pencil-square-o"></span>网上留言
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/admin/Message_Add.jsp"
				target="right"> <span class="icon-caret-right"></span>添加留言
			</a></li>
			<li><a href="${pageContext.request.contextPath}/MessageServlet?method=listMessage"
				target="right"> <span class="icon-caret-right"></span>留言管理
			</a></li>
		</ul>
        
        
		<h2>
			<span class="icon-pencil-square-o"></span>前台展示
		</h2>
		<ul>
			<li><a href="${pageContext.request.contextPath}/CusIndexServlet"
				target="_blank"> <span class="icon-caret-right"></span>进入首页
			</a></li>
		</ul>

	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="${pageContext.request.contextPath}/admin/index.jsp"
			target="_blank" class="icon-home">系统首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="Main_info.jsp"
			name="right" width="100%" height="100%"></iframe>
	</div>
</body>
</html>