<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>
	Welcome.
	<form name="loginForm" action="userBean/login" method="post"><!--  -->
	<span>User &nbsp;</span>
	<br>
	<input type="text" name="userName" />
	
	<br>
	<span>Password</span>
	<br>
	<input type="password" name="password" />
	<br>
	<input type="button" value="Login" id="loginBtn" onclick="login()" />
	</form>
	<span id="errMsg" style="color:red"></span> 
</body>
<script type="text/javascript">
	function login(){
			
			$.ajax({
					url :"userBean/login",
					type :"post",
					async: false,  
					dataType :"json",
					success :function(data){
						
						alert("success!"+data.msg);
						 document.getElementById("errMsg").innerHTML=data.msg;
						
					},
					error:function(){
						alert("ERROR");
					}
			})
		}
</script>
</html>