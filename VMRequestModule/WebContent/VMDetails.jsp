<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="VMAction" method="post">

<table border =2>

<caption>Physical Machine Statistics</caption>
	<tr>
		<th><h4>PM ID</h4></th>
		<th><h4>Physical Machines</h4></th>
	</tr>
	<tr>
		<td>1</td>
		<td>192.168.12.38</td>
	</tr>
	<tr>
		<td>2</td>
		<td>192.168.12.35</td>
	</tr>
	<tr>
		<td>3</td>
		<td>192.168.12.102</td>
	</tr>
	<tr>
		<td>4</td>
		<td>192.168.12.153</td>
	</tr>
</table>

<br>
<br>
<br>
<br>
<br>

<s:textfield default=" " name="hddreq" placeholder="HARD DISK SIZE" key="REQ HDD" size="30"></s:textfield>
<br>
<br>
<s:textfield default=" " name="cpureq" placeholder="CLOCK SPEED OF CPU IN GHZ" key="REQ CLSP" size="30"></s:textfield>
<br>
<br>
<s:textfield  default=" " name="ramreq" placeholder="SIZE OF RAM IN GB" key="REQ RAM" size="30"></s:textfield>
<br>
<br>
<s:submit value="SUBMIT REQUEST"  ></s:submit>

</s:form>
</body>
</html>