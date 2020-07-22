<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport"content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/user/css/login.css">
<script src="${pageContext.request.contextPath}/user/js/login.js"></script>

</head>
<body>
	<h1 >blkin</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<div id="msg" class="msg"></div>
			<!-- action : 처리할 서버의 URL 
			method : 전송방식 (get,post)
			enctype: file이 존재하는 경우만 multipart/form-data
			최근에는 조회를 제외하고는 action을 성정하지 않고 method는 post로 설정해서 get과 post로 구분을 한다. -->
			<form method="post" id="loginform" action="login">
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="email" class="screen_out">이메일</label> 
							<input type="email" id="useremail" name="useremail" placeholder="이메일을 입력하세요">
						</div>
						<div class="inp_text">
							<label for="userpw" class="screen_out">비밀번호</label> 
							<input type="password" id="userpassword" name="userpassword"
								placeholder="비밀번호를 입력하세요">
						</div>
					</div>
					<!-- 하나의 서버로 여러 디바이를 요청하는 처리하는 REST API 서버를 이용하는 경우에는 submit 대신에 button을 만들어서 버튼을 누르면
					ajax로 요청을 처리
					bootstrap 같은 자바스크립트 라이브러리를 이용하게 되면 button을 만들면 자동으로 submit을 만드는 경우가 있습니다. 그런 경우에는
					버튼을 form 외부에 생성 -->
					<button type="button" class="btn_login" id="loginbtn" >로그인</button>
					<div class="login_append">
						<div class="inp_chk">
							<input type="checkbox" id="keepLogin" class="inp_radio"	name="keepLogin"> 
							<label for="keepLogin" class="lab_g">
								<span class="img_top ico_check"></span>
								<span class="txt_lab">로그인	상태 유지</span>
							</label>
						</div>
					</div>
					<div class="login_append" align="center">
						<a href="#" class="link_find">아이디 찾기</a> 
						<a href="#"class="link_find">비밀번호 찾기</a> 
						<a href="${pageContext.request.contextPath}/member/register" class="link_find" id="registerbtn">회원가입</a>
						<a class="link_find" id="mainbtn" name="mainbtn">로그인</a>
						
						<button type="button" class="btn_login" id="mainbtn" name="mainbtn" >메인으로</button>
					</div>
					<!-- 네이버아이디로로그인 버튼 노출 영역 -->
					<div id="naverIdLogin" class="naverIdLogin"></div>
					
				</fieldset>
			</form>
		</div>
	</div>
	
</body>
</html>