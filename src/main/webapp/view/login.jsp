<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
				
					<div id="login-box" class="col-md-12">
						
						<form id="login-form" class="form" action="dang-nhap"
							method="post">
							<input type="hidden" value="login" name="action">
							<h3 class="text-center text-info">Login</h3>
							<div class="form-group">
								<label for="userName" class="text-info">Username:</label><br>
								<input type="text" name="userName" id="userName"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="text" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info"><span>Remember
										me</span> <span><input id="remember-me" name="remember-me"
										type="checkbox"></span></label><br> <input type="submit"
									name="submit" class="btn btn-info btn-md" value="submit">
							</div>
							<div id="register-link" class="text-right">
								<a href="#" class="text-info">Register here</a>
							</div>
						</form>
						
					</div>
					<c:if test="${not empty message }">
					<div class="alert alert-${alert }" role="alert">
						${message}
						</div>
					</c:if>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>