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
<script>
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#userId").focusout(function() {
		// id = "id_reg" / name = "userId"
		var userId = $('#userId').val();
		$.ajax({
			url : "com.vita.user.UserRegisterServlet",
			type : "post",
			data : {userId : userId},
			dataType : 'json',
			success : function(result) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (result == 0) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").html("사용중인 아이디입니다 :p");
						$("#id_check").attr("color", "red");
						$("#submit").attr("disabled", true);
					} else {
						$("#id_check").html("사용할 수 있는 아이디입니다.");
						$("#id_check").attr("color", "green");
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
</script>
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
                            <font class="id_check" id="id_check"></font>
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
    <%
    	String messageContent = null;
        if(session.getAttribute("messageContent")!=null){
        	messageContent = (String)session.getAttribute("messageContent");
        }
    	String messageType = null;
        if(session.getAttribute("messageType")!=null){
        	messageType = (String)session.getAttribute("messageType");
        }
        
        if(messageContent != null){            
    %>
    <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    	<div class = "vertical-alignment-helper">
    		<<div class="modal-dialog modal-lg" role="document">>
    			<div class = "modal-content  <% if(messageType.equals("오류 메세지")) out.println("panel-warning"); 
    			else out.println("panel-success"); %>">
    			<div class = "modal-header panel-heading">
    				<button type = "button" class = "close" data-dismiss="modal">
    					<span aria-hidden="true">&times;</span>
    					<span class = "sr-only">Close</span>
    				</button>
    				<h3 class ="modal-title">
    					<%= messageType %>
    				</h3>
    				</div>
    				<div class = "modal-body">
    				<%= messageContent %>
    				</div>
    				<div class = "modal-footer">
    					<button type = "button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <script>
    	$('#messageModal').modal("show")
    </script>
    <%
    	session.removeAttribute("messageContent");
    	session.removeAttribute("messageType");
        }
    %>
</body>
</html>


