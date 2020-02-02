<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
   	background: url("https://cdn.pixabay.com/photo/2018/03/02/19/46/rose-petals-3194062__340.jpg");
  	background-repeat: no-repeat;
  	background-size:cover;
}

<style>
body
{
	margin: 0;
	padding: 0;
	background: url(bg.jpg);
	background-size: cover;
	font-family: sans-serif;
}
.loginBox
{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	width: 350px;
	height: 418px;
	padding: 80px 40px;
	box-sizing: border-box;
	background: rgba(0,0,0,.5);
}

.sanBox
{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	width: 600px;
	height: 500px;
	padding: 80px 40px;
	box-sizing: border-box;
	background: rgba(0,0,0,.5);
}


.menuBox
{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	width: 1040px;
	height: 500px;
	padding: 80px 40px;
	box-sizing: border-box;
	background: rgba(0,0,0,.5);
}

.mapBox
{
	position: absolute;
	top: 60%;
	left: 50%;
	transform: translate(-50%,-50%);
	width: 1280px;
	height: 600px;
	padding: 80px 40px;
	box-sizing: border-box;
	background: rgba(0,0,0,.5);
}
.user
{
	width: 100px;
	height: 100px;
	border-radius: 50%;
	overflow: hidden;
	position: absolute;
	top: calc(-100px/2);
	left: calc(50% - 50px);
}
h2
{
	margin: 0;
	padding: 0 0 20px;
	color: #efed40;
	text-align: center;
}
h3
{
	color: #efed40;
}
h1
{
	color: #efed40;
	text-align: center;
}
.loginBox p
{
	margin: 0;
	padding: 0;
	font-weight: bold;
	color: #fff;
}
.loginBox input
{
	width: 100%;
	margin-bottom: 20px;
}
.loginBox input[type="email"],
.loginBox input[type="password"]
{
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}
::placeholder
{
	color: rgba(255,255,255,.5);
}
.loginBox input[type="submit"]
{
	border: none;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
	background: #ff267e;
	cursor: pointer;
	border-radius: 20px;
}
.loginBox input[type="submit"]:hover
{
	background: green;
	color: white;
}
.loginBox a
{
	color: #fff;
	font-size: 14px;
	font-weight: bold;
	text-decoration: none;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 10px;
    overflow: hidden;
    background-color: #333;
}

li {
    float: right;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: skyblue;
}

.active {
    background-color: red;

</style>
</head>



<%-- <body style="background-color:background;">
<center>
<fieldset style="width:350px">
<form action="Login"  method="post" >
<h1><div style="background-color:red";>${msg }</div></h1><h2><b>
<pre>
<h1><u>LOGIN PAGE</u></h1><h2 style="background-color:orange;" ><b>
Email Id:  <input type="email" name="email"  required="required"> 
Password:  <input type="password" name="password"  required="required"> 
<input  type="submit" value="Login "><h5><a href="ForgotPw">Forgot Password?</a></h5></b><br></h2></h3>
</pre><button><h3><a href="UserRegister">Register</a></h3></button>
</form>
</fieldset>
</center>
 --%>

<body>
<ul>
  <li><a href="UserRegister">SIGN UP</a></li>
  <li><a href="UserLogin">LOGIN</a></li>
</ul>
<br><br>
			<div class="loginBox">
			<img src="https://www.freepnglogos.com/uploads/student-png/student-png-sammilani-mahavidyalaya-undergraduate-and-24.png" class="user">
			<h2>Administrator</h2>
			<form action="Login" method="post">
				<p>Email ID</p>
				<input type="email" name="email" placeholder="Enter Email" required>
				<p>Password</p>
				<input type="password" name="password" placeholder="password" required>
				<input type="submit" value="Sign In"><center><a href="ForgotPw">Forgot Password?</a></center>
				  <center><lebel style="background-color:red">${msg }</lebel></center>
			</form>
		</div>
	</body>
</html>

</body>
</html>


	