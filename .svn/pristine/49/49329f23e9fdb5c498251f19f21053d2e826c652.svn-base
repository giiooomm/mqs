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
<script>
  $(function(){
    loadmenu();
  });
  function loadmenu(){
    $.ajax({
      type:"POST",
      dataType:"JSON",
      data:{},
      url:"${ctx}/sys/menu",
      success:function(result){
          $("#delni").remove(); 
          for(var i=0;i<result.length;i++){
            if(result[i].child.length > 0){
              var parentli=document.createElement('li');
              parentli.setAttribute("class","dropdown");
              var str = "<a class='dropdown-toggle' data-toggle='dropdown' href='#'>"+result[i].menuName+"<span class='caret'></span></a>";
              parentli.innerHTML = str;
              var parentmenu=document.createElement('ul'); 
              parentmenu.setAttribute("class","dropdown-menu");
              var string =  "";     
              for(var j=0;j<result[i].child.length;j++){             
                var childmenu = document.createElement('li');
                var strmenu = "<a href='${ctx}/"+result[i].child[j].menuUrl+"'>"+result[i].child[j].menuName+"</a>";             
                childmenu.innerHTML = strmenu;
                parentmenu.append(childmenu);
              }
              parentli.append(parentmenu);
              $(".nav-tabs").append(parentli);   
            }else{
              var newLi = document.createElement('li');
              var str = "<a href='${ctx}/"+result[i].menuUrl+"'>"+result[i].menuName+"</a>";
              newLi.innerHTML = str;
              $(".nav-tabs").append(newLi);
            }          
          }
      },
      error:function(result){
         alert("失败");
      }
    });
  }
</script>
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
        <li><a id="delni">你</a></li> 
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
