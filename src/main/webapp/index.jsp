<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content="width=device-width, initial-scale=1">
	<link rel ="stylesheet" href="css/bootstrap.css">
	<link rel ="stylesheet" href="css/custom.css"> 
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<body>
    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form method="post" id="signup-form" class="signup-form" action ="./userRegister">
                        <h4 class="form-title">회원 가입</h4>
                        <div class="form-group">
                            <input type="email" class="form-input" name="userId" id="userId" placeholder="이메일아이디"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="userName" id="userName" placeholder="이름"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="userPwd" id="userPwd" placeholder="비밀번호"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="userPwd2" id="userPwd2" placeholder="비밀번호 확인"/>
                        </div>
                         <div class="form-group">
                            <input type="text" class="form-input" name="userPhone" id="userPhone" placeholder="휴대번호"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span> <a href="#" class="term-service"> 요생소 이용 약관</a> 동의 </label>
                        </div>
                         <div class="form-group">
                            <input type="checkbox" name="agree-term2" id="agree-term2" class="agree-term" />
                            <label for="agree-term2" class="label-agree-term"><span><span></span></span> <a href="#" class="term-service"> 전자 상거래 이용 약관</a> 동의 </label>
                        </div>
                         <div class="form-group">
                            <input type="checkbox" name="agree-term3" id="agree-term3" class="agree-term" />
                            <label for="agree-term3" class="label-agree-term"><span><span></span></span> <a href="#" class="term-service"> 개인 정보 수집 이용</a> 동의 </label>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term4" id="agree-term4" class="agree-term" />
                            <label for="agree-term4" class="label-agree-term"><span><span></span></span> 만 14세 이상입니다.</label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="회원가입"/>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </div>
    
</body>
</html>


