<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/register.css">
<script src="${pageContext.request.contextPath}/user/js/update.js"></script>
<title>회원 정보 수정</title>
</head>
<body>
	<form id="updateform" enctype="multipart/form-data">
		<h2>정보 수정</h2>
		<div align="center" id="msg"></div>
		<ul>
			<li>
				<label for="user_email">이메일</label> 
				<input type="text" id="user_email" name="user_email" class="textinput" value="${result.user_email}" readonly="readonly" />
			</li>
			<li>
				<label for="user_email">비밀번호</label> 
				<input type="password" id="user_password" name="user_password" class="textinput" placeholder="비밀번호는 8-15자로 만들어야 합니다." />
			</li>
				
			<div id="pwmsg"></div>
			<li>
				<label for="pw1">비밀번호확인</label> 
				<input type="password" id="pw1" class="textinput" placeholder="영문 대소문자와 특수문자와 숫자 1개 이상으로 만들어야 합니다." />
			</li>
			<li>
				<label for="user_name">이름</label> 
				<input type="text" id="user_name" name="user_name" class="textinput" readonly="readonly" value="${result.user_name}" />
			</li>
			<li>
				<label for="user_kg">KG</label> 
				<input type="text" id="user_kg" name="user_kg" class="textinput" value="${result.user_kg}" />
			</li>
			<li>
			<label for="user_gender">성별</label> 
			<select name="user_gender" class="input-field">
				  <option value="남자">남자</option>
				  <option value="여자">여자</option>
				  <option value="기타" selected="selected">기타</option>
			</select>
			</li>

			<li>
				<label for="image">이미지</label> <input type="file" id="user_image" class="fileinput" accept="image/*" name="user_image" /> 
				<c:if test="${result.user_image != null}">
				<img id="img" src="${pageContext.request.contextPath}/profile/${result.user_image}" />
				</c:if>
			</li>
			<li class="buttons">
				<input type="button" value="정보수정" id="updatebtn" /> 
				<input type="button" value="메인" id="mainbtn" /> 
				<input type="button" value="로그인" id="loginbtn" />
			</li>
		</ul>
	</form>
</html>