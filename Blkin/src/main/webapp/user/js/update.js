window.addEventListener("load",function(event){
	//DOM 객체 찾아오기
	var updateform = document.getElementById("updateform");
	var user_email = document.getElementById("user_email");
	var user_password = document.getElementById("user_password");
	var pw1 = document.getElementById("pw1");
	var user_name = document.getElementById("user_name");
	var user_kg = document.getElementById("user_kg");
	var user_image = document.getElementById("user_image");
	
	var msg = document.getElementById("msg");
	var pwmsg = document.getElementById("pwmsg");
	
	var updatebtn = document.getElementById("updatebtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	
	mainbtn.addEventListener("click",function(event){
		location.href="../";
	
	});
	loginbtn.addEventListener("click",function(event){
		location.href="login";
	
	});
	
	user_image.addEventListener("change",function(event){
		if(this.files && this.files[0]){
			var filename = this.files[0].name;
			var reader = new FileReader();
			reader.addEventListener("load",function(e){
				img.src = e.target.result;
			});
			reader.readAsDataURL(this.files[0]);
		}
	})
	
	var flag = false;
	updatebtn.addEventListener("click",function(event){
		if(user_password.value.trim().length < 1){
			pwmsg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
			flag = true;
		}else{
			var pwRegExp =  /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$/;
			if (!pwRegExp.test(user_password.value.trim())) {
				pwmsg.innerHTML = '비밀번호는 숫자와 영문 대소문자 그리고 특수문자가 포함되어야 합니다.<br/>';
				flag = true;
		} else {
			if (user_password.value.trim() !== pw1.value.trim()) {
				pwmsg.innerHTML += '2개의 비밀번호는 같아야 합니다.<br/>';
				flag = true;
				}
			}
		}
		if(flag == true){
			return;
			event.priventDefault();
		}
		var url = "update";
		var request = new XMLHttpRequest();
		request.open("post",url,true);
		var formdata = new FormData(updateform);
		alert(formdata);
		request.send(formdata);
		request.addEventListener('load',function(e){
			var map = JSON.parse(e.target.responseText);
			if(map.result == true){
				location.href = "../";
				
			}else{
				msg.innerHTML = "수정실패";
			}
		})
	})
});