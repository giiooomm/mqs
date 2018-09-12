<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			注册窗口
		</title> 
		<!--<script src="../js/day1/day1.js"></script>--> 
		<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script src="${pageContext.request.contextPath}/js/Jq.js"></script>  
		<link   rel="stylesheet" href="${pageContext.request.contextPath}/css/day1.css"/>
		<script>
		</script>
</head>
	<body> 
		<img src="${pageContext.request.contextPath}/images/mos.png" width="100%" id="mos" style="display:none"/>
		<div id="titleimg">
			<img src="${pageContext.request.contextPath}/images/1.png" width="100%"/>
		</div>
		<div id="father1">	
			<div id="lfet1">
				<a href="${pageContext.request.contextPath }/images/3.png">
					<img src="${pageContext.request.contextPath }/images/3.png" id="3png" width="100%" height="100%"/>
				</a>
			</div>
			<div id="RoleRegister">
				<form action="${pageContext.request.contextPath}/user/doregister" method="get" onsubmit="return registerform()" >
					<table border="1px" align="center" width="500px" height="400px" cellspacing="1">
						<tr height="20%">
							<td colspan="3" >用户注册界面</td>
			
						</tr>
						
						<tr>
							<td>用户名</td>
							<td colspan="2">
								<input type="text" name="username" id="username" value=""/>
							</td>
						</tr>
						
						<tr>
							<td>密码</td>
							<td colspan="2"><input type="password" name="password" id="password" value=""/> </td>
						</tr>
						
						<tr>
							<td>确认密码</td>
							<td colspan="2"><input type="password" name="repasswordname" id="repassword" value=""/> </td>
						</tr>
						<tr>
							<td>邮箱</td>
							<td colspan="2"><input type="text" name="Email" id="Email" value="" /></td>
						</tr>
						<tr>
							<td>姓名</td>
							<td colspan="2"><input type="text" name="name" id="name" value="" /></td>
						</tr>
						<tr>
							<td>性别</td>
							<td bordercolor="white" ><input type="radio"  name="sex" id="sex" value="1" />男</td>
							<td bordercolor="white"><input type="radio"  name="sex" id="sex" value="2" />女</td>
						</tr>
						<tr>
							<td>所在地</td>
							<td colspan="2">
								<select id="select_se">
									<option></option>
									<option value="0">广西</option>
									<option value="1">广东</option>
									<option value="2">湖南</option>	
								</select>
								<select id="select_si">
								</select>
								
							</td>
						</tr>
						<tr>
							<td>出生年月</td>
							<td colspan="2"><input type="date" name="csny" id="csny"/></td>
						</tr>
						<tr>
							<td>验证码</td>
							<td  width="33%" bordercolor="white"><input type="text" name="yzf" id="yzf" value="" /></td>
							<td bordercolor="white" height="10"><img src="2.png"/> </td>
						</tr>
						<tr>
							<td height="*" colspan="2"><input type="submit" name="提交" value="注册"/></td>
							<td> <input type="button" value="测试" id="tbn"/></td>
						</tr>
					</table>
				</form>
			</div>
			<div id="right1">
				<a href="${pageContext.request.contextPath }/imgages/4.png">
					<img href="${pageContext.request.contextPath }/images/4.png" src="${ pageContext.request.contextPath}/images/4.png" width="100%" id="4png" height="100%"/>
				</a>
			</div>
		</div>	
		
		<div id="title2">
			<ul>
				<li class="title2">电视剧</li>
				<li class="title2">电影</li> 
				<li class="title2">新闻</li> 
				<li class="title2">娱乐</li> 
				<li class="title2">军事</li> 
				<li class="title2">小游戏</li> 
				<li class="title2">新游</li> 
				<li class="title2">新游</li> 
				<li class="title2">特价</li> 
				<li class="title2">购物</li> 
				<li class="title2">综艺</li> 
				<li class="title2">软件</li>
				<li class="title2">理财</li>
		</div>
		<div id="down" style="background-image:url(${pageContext.request.contextPath}/images/5.png)">
			
		</div>
	</body>
</html>
