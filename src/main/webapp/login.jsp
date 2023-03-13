<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	</head>
	<body>
		<form action="emailSendAction.jsp" method="post" id="mainForm">
			이메일인증 테스트 : <input type="text" name="email" id="emailInput">
			<button type="submit">검증</button>
		</form>
		<script type="text/javascript">
			let email = document.getElementById("emailInput");
			
			email.addEventListener("keyup",function(){
				var reg = /[a-zA-Z0-9]+@[a-z]+\.[a-z]{2,3}/;
				if(reg.test(this.value)){
					this.style.backgroundColor="green";
				}else{
					this.style.backgroundColor="red";
				}
			});
		</script>
	</body>
</html>