<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose Mail</title>

<style>
body {margin:0;
 	background: url("https://lh5.googleusercontent.com/proxy/H4EWPk50N_6xas-v_a4-KFKtmtjKDdGCIKcTXP1D-PayZW9rFgZlF4JkWCZMpYkMb6Ph2cP6w1edXlGTt3hhFIFu-C_vLIQ9bDmxoi3-p5TqEf7yPQrrzQJGSVq5L4h8dupRgSh-0EHx");
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


.btn input[type="submit"]
{
	border: none;
	outline: none;
	height: 55px;
	width: 142px;
	color: #fff;
	font-size: 29px;
	background: #ff267e;
	cursor: pointer;
	border-radius: 20px;
}
.fnt input[type="text"]
{
    border: none;
	outline: none;
	height: 55px;
	width: 192px;
   	font-size: 29px;
	border-radius: 15px;
}
.fnt input[type="email"]
{
    border: none;
	outline: none;
	height: 55px;
	width: 192px;
   	font-size: 29px;
	border-radius: 15px;
}
.fnt-content p
{
    border: none;
	outline: none;
	height: 55px;
	width: 192px;
   	font-size: 29px;
	border-radius: 20px;
}
.btn input[type="submit"]:hover
{
	background: green;
	color: #262626;
}

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
<center>
<fieldset style="width:350px" style="height:100px"><div>
<form action="draftEditSent"  method="post" >
<h1>Compose Mail</h1><b>
<input type="hidden" name="infid" value="${ dto.getInfid()}" >
<div class="fnt">
                  <h2>To</h2>
<input type="email" name="email" value="${dto.getUdraft()}" required="required"></div>
             <div class="fnt"><h2>Subject</h2>
<input type="text" name="msub" value="${dto.getMsub()}" required="required"></div> 
          <div class="fnt"> <h2>Message</h2>
<textarea rows="8" cols="23" name="uinbox" required="required">${dto.getUinbox()}</textarea></div><br>
<div class="btn"><input  type="submit"  value="Sent"></div></b><br></h2>
</form>
</div></fieldset><br><br><br><br><br><br><br><br><br><br>
</center>
</body>
</html>