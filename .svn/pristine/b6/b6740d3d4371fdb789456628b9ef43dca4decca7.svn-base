<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
 
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../style/title.jsp"/>
    <title></title>  
    <style>
    	.table {margin:-550px 0px 0px 130px;width:70%;}
    	.font {font-size:26px}
    	</style>
    
</head>
<body>
    
    <table class="table table-hover">
		  <caption></caption>
		  <thead>
		    <tr>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="blogs" items="${list}">
			    <tr>
			      <td>
			      	<div>
			      	  <a href="${ctx}/blog/toContent?id=<c:out value='${blogs.id}' />" ><font class="title" > <c:out value="${blogs.id}" /><c:out value="${blogs.title}" /></font></a>
			      	  <a href="${ctx}/blog/delete?id=<c:out value='${blogs.id}' />"  onClick="return confirm('确定删除?');" style="float:right"><font class="font" >刪除</font></a>
			      	  <a href="${ctx}/blog/toUpdate?id=<c:out value='${blogs.id}' />" style="float:right"><font class="font" >修改</font></a>
			      	  <br>&nbsp;&nbsp;
			          <a href="${ctx}/blog/toContent?id=<c:out value='${blogs.id}' />" ><font class="content" ><c:out value="${blogs.content}" escapeXml="false"/></font></a>
			        </div>
			      </td>
			    </tr>
           </c:forEach>
		  </tbody>
		</table>



</body></html>
