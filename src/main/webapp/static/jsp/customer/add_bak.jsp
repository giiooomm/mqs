﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		loadSelect("006","td_level","cust_level.dictid");
		loadSelect("002","td_resource","cust_source");
		loadSelect("001","td_industry","cust_industry");
		});
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>

</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/CustomerAction_add" 
		 method="post">
		

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg>
					<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=cust_name
														style="WIDTH: 180px" maxLength=50 name=cust_name>
								</td>
								<td>客户级别 ：</td>
								<td id=td_level>

								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td id=td_resource>
								
								</td>
								<td>联系人：</td>
								<td>
								
								</td>
							</TR>

							<TR>
								
								
								<td>固定电话 ：</td>
								<td id=td_phone>
									<INPUT class=textbox id=cust_phone
														style="WIDTH: 180px" maxLength=50 name=cust_phone>
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=cust_mobile
														style="WIDTH: 180px" maxLength=50 name=cust_mobile>
								</td>
							</TR>
							<tr>
								<td>客户行业</td>
								<td id="td_industry">
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td rowspan=2>
								<INPUT type=submit id=sButton2 
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
			
		</TABLE>
	</FORM>
</BODY>
</HTML>