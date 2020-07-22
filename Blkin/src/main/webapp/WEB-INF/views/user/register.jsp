<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/register.css">
<script src="${pageContext.request.contextPath}/user/js/register.js"></script>

</head>
<body>

	<div class="wrap">
		<div class="form-wrap">
			<div class="button-wrap">
				<button type="button" class="togglebtn" onclick="register()">REGISTER</button>
			</div>
			<div class="social-icons">
				<img src="${pageContext.request.contextPath}/user/img/facebook.png" alt="facebook"> 
				<img src="${pageContext.request.contextPath}/user/img/apple.png" alt="apple"> 
				<img src="${pageContext.request.contextPath}/user/img/google.png" alt="google">
			</div>

			<form id="registerform" class="input-group" enctype="multipart/form-data" >
				<div align="center" id="msg"></div>
				<input type="email" class="input-field" name="user_email" id="user_email" placeholder="Enter Email" >
				<div id="emailmsg"></div>  
				<input type="password"class="input-field" name="user_password" id="user_password" placeholder="Enter Password" >
				<div id="passwordmsg"></div>
				<input type="password"class="input-field" name="passwordchk" id ="passwordchk" placeholder="Checked your Password" >
				
				<input type="text" class="input-field" name="user_name" id="user_name" placeholder="User name" >
				<div id="namemsg"></div>
				<select name="user_gender" class="input-field">
				  <option value="남자">남자</option>
				  <option value="여자">여자</option>
				  <option value="기타" selected="selected">기타</option>
				</select>
			<li><label for="image">이미지</label>
			 	<input type="file" id="user_image"
				class="fileinput" accept="image/*" 
				name="user_image" /> 
				<img id="img" size="small" />
			</li>
			<li class="buttons" />
				
				<button type="button" class="togglebtn" id="registerbtn" name = "registerbtn">REGISTER</button>			
			</form>
		</div>
	</div>
</body>
</html>