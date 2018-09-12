<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
	<meta charset="utf-8" />
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/css/title/title.css"> 
</head>
<body>

    <nav class="navbar navbar-fixed-top my-navbar" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">菜鸟教程</a>
            </div>
        </div>	
		<ul class="nav nav-tabs">
			<li>
				<a href="${ctx}/view/main.jsp">Home</a></li>
			<li>
				<a href="${ctx}/blog">Blog</a></li>
			<li>
				<a href="${ctx}/view/blog/blog_add.jsp">添加Blog</a></li>
			<li>
				<a href="#">VB.Net</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Java
					<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li>
						<a href="#">Swing</a></li>
					<li>
						<a href="#">jMeter</a></li>
					<li>
						<a href="#">EJB</a></li>
					<li class="divider"></li>
					<li>
						<a href="#">分离的链接</a></li>
				</ul>
			</li>
			<li>
				<a href="#">PHP</a></li>
		</ul>
    </nav>


     <div class="bg"></div>
    <script>
    	  $(function(){
    	  
    	  	$(".navbar-fixed-top").addClass("top-nav");
    	  });
        $(window).scroll(function () {
            if ($(".navbar").offset().top >= -50) {$(".navbar-fixed-top").addClass("top-nav");
            }else {$(".navbar-fixed-top").removeClass("top-nav");}
        })</script>
</body></html>
