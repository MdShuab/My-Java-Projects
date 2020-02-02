 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chnage Password</title>

<style>
body {margin:0;
 	background: url("https://cdn.pixabay.com/photo/2020/01/20/19/41/finger-touch-4781220_960_720.jpg");
  	background-repeat: no-repeat;
  	background-size:cover;
  } 
   
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
}   

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}






/* ================================== */
.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}

/* =========================FORM STYLE=================== */


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
.loginBox input[type="text"],
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
<body style="background-color:pink">


<div class="navbar">
 <a class="active" href="Home">HOME</a>


  <div class="dropdown">
    <button class="dropbtn">INBOX
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Inbox">INBOX MAIL</a>
      <a href="dinbox">DELETED INBOX MAIL</a>
      <a href="rStoreInbx">RESTORE INBOX MAIL</a>
    </div>
  </div>

  <div class="dropdown">
    <button class="dropbtn">DRAFT
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
     <a href="Draft">DRAFT MAIL</a>
      <a href="ddraft">DELETED DRAFT MAIL</a>
      <a href="rStoreDarft">RESTORE DRAFT MAIL</a>
    </div>
  </div>
  
  
  
  <div class="dropdown">
    <button class="dropbtn">SENT
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
     <a href="SentInbox">SENT MAIL</a>
      <a href="dsentf">DELETED SENT MAIL</a>
      <a href="rStoreSent">RESTORE SENT MAIL</a>
    </div>
  </div>
  
  
 <a href="Compose">COMPOSE MAIL</a>
  <a href="ChangePw">CHANGE PASSWORD</a>
  <div class="dropdown">
    <button class="dropbtn">MY ACCOUNT
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Profile">PROFILE</a>
      <a href="AccDelete">DELETE ACCOUNT</a>
      <a href="Logout">LOGOUT</a>
    </div>
  </div>
</div>
<div>
<br><br>

<div class="loginBox">
				<h2>UPDATE PASSWORD</h2>
			<form action="ChanGePw" method="post">
				<p>New Password</p>
				<input type="password" name="password1" placeholder="Enter New Password" required>
				<p>Confirm Password</p>
				<input type="password" name="password2" placeholder="Confirm Password" required>
				<input type="submit" value="UPDATE">
				  <center><lebel style="background-color:red">${msg }</lebel></center>
			</form>
		</div>




</body>
</html>