<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {margin:0;
 	background: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHdxjFF4pRRLHXfci9QjKSRuTdMa8uu30qC4sshYtSEcfSxpZI&s");
  	background-repeat: no-repeat;
  	background-size:cover;
  } 
</style>
</head>
<body >

<center>
<fieldset style="width:350px">
<form action="FPW"  method="post" >
<h1><lebel style="background-color:green";>${msg }</lebel></h1><h2><b>
<pre>
<h1>Forgot Password</h1><h2><b>
Email Id:        <input type="email" name="email"  required="required">
New Password:    <input type="password" name="password1"  required="required">
Confirm Password:<input type="password" name="password2"  required="required">
<input  type="submit" value="Submit"></b></h2><a href=" Home">Home</a>
</pre>
</form>
</fieldset>
</center>

</body>
</html>