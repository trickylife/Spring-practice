<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> The time on the server is ${serverTime}. </P>
<p> 스프링 홈페이지 </p>
<img src="img/capcut02.png" width="200"/>
<h1>mapping Test</h1>
<pre>
	a태그 (get)
	location.href (get)
	response.sendRedirect (get)
	form태그 (get/post)
</pre>
<div>
	<a href="/myapp/test1?num=1234&name=홍길동">접속하기(get)</a>
	<a href="/myapp/test2?num=55&name=이순신">접속하기2(get)</a>
	<a href="/myapp/test3?num=111&name=안창호&tel=010-1234-5678">접속하기3(get)</a>
</div>
<div>
	username : ${username} <br/>
	hi : ${hi}
</div>
</body>
</html>
