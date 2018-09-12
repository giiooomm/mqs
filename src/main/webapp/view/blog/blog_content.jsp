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
    	.table {margin:-750px 0px 0px 130px;width:70%;}
    	.table td div{ text-overflow:ellipsis; overflow:scroll; height:100%;white-space: nowrap;}
    	</style>
</head>
<body>
    
    <table class="table table-striped">
		  <caption></caption>
		  <thead>
		    <tr>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
			    <tr>
			      <td>
			      	<div>
			      	  <font class="title" > <c:out value="${blog.title}" /></font></a><br>&nbsp;&nbsp;
			          <font class="content" ><c:out value="${blog.content}" escapeXml="false"/></font></a>
			        </div>
			      </td>
			    </tr>
		  </tbody>
		</table>



</body></html>
