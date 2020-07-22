
window.addEventListener('load',function(event){
	//아이디를 가진 dom 객체 찾아오기
	var useremail = document.getElementById("useremail");
	var userpassword = document.getElementById("userpassword");
	var loginform = document.getElementById("loginform");
	var loginbtn = document.getElementById("loginbtn");
	var registerbtn = document.getElementById("registerbtn");
	var mainbtn = document.getElementById("mainbtn");
	
	//mainbtn을 클릭할 때 메인 페이지로 보내기
	mainbtn.addEventListener("click",function(event){
		location.href = "../";
	});
	
	//서버로 보내서 로그인을 처리
	loginbtn.addEventListener("click",function(event){
		//ajax를 이용
		//1.ajax 객체 생성
		var request = new XMLHttpRequest();
		//2.ajax 요청 설정
		request.open('post','login',true);
		//3.ajax 파라미터 설정
		//get방식이면 open의 url 뒤에 붙이고
		//post 방식이면 formdata 객체를 생성하고 send
		var formdata = new FormData(loginform);
		request.send(formdata);
		alert(formdata);
		alert(loginform);
		//4.ajax 응답이 온 경우 처리할 콜백함수 등록
		request.addEventListener('load',function(event){
			//로그인 실패한 경우
			if(event.target.responseText.trim().length == 0){
				
				alert("없는 email 이거나 잘못된 비밀번호 입니다.")
			}else{
				//로그인이 성공한 경우
				location.href = "../";
			}
		});
		
		
	});
	
	var msg = document.getElementById("msg");

	loginbtn.addEventListener("click",function(event) {
		msg.innerHTML = '';
		var flag = false;
		if (useremail.value.trim().length < 1) {
			msg.innerHTML = '이메일은 필수 입력입니다.<br/>';
			flag = true;
			} else {
				var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				if (!emailRegExp.test(useremail.value.trim())) {
					msg.innerHTML = '잘못된 이메일 형식입니다.<br/>';
					flag = true;
				}
			}
			if (userpassword.value.trim().length < 1) {
				msg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
				flag = true;
			}
			if (flag == true) {
				event.preventDefault();
			}
	});
	
});






