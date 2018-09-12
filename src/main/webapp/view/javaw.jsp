<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
	<meta charset="utf-8" />
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        html, body {width:100%;height:100%;} /*非常重要的样式让背景图片100%适应整个屏幕*/
        .bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(http://t2.hddhhn.com/uploads/tu/201707/115/52.jpg) no-repeat bottom center;background-color: #000;background-size: cover;}
        .my-navbar {padding:20px 0;transition: background 0.5s ease-in-out, padding 0.5s ease-in-out;}
        .my-navbar a{background:transparent !important;color:#fff !important}
        .my-navbar a:hover {color:#45bcf9 !important;background:transparent;outline:0}
        .my-navbar a {transition: color 0.5s ease-in-out;}/*-webkit-transition ;-moz-transition*/
        .top-nav {padding:0;background:#000;}
        .table {margin:150px 0px 0px 0px;}
		.open>.dropdown-toggle{background-color:#000!important;}
		.open>.dropdown-menu {background-color:#000!important;}
        button.navbar-toggle {background-color:#fbfbfb;}/*整个背景都是transparent透明的，会看不到，所以再次覆盖一下*/
        button.navbar-toggle > span.icon-bar {background-color:#dedede}
    </style>
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
				<a href="#">Home</a></li>
			<li>
				<a href="#">SVN</a></li>
			<li>
				<a href="#">iOS</a></li>
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
        $(window).scroll(function () {
            if ($(".navbar").offset().top >= -50) {$(".navbar-fixed-top").addClass("top-nav");
            }else {$(".navbar-fixed-top").removeClass("top-nav");}
        })</script>
</body></html>
