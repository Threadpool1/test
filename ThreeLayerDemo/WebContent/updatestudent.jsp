<%@page import="org.mydemo.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
      <% Student student=(Student)request.getAttribute("student");%>
      <form action="UpdateStudentServlet">
               学号：<input type="text" name="uid" value="<%=student.getNumber() %>" readonly="readonly"/><br/>
               姓名：<input type="text" name="uname" value="<%=student.getName()%>"/><br/>
               年龄：<input type="text" name="uage" value="<%=student.getAge()%>"/><br/>
               地址：<input type="text" name="uaddress" value="<%=student.getAddress()%>"/><br/>
       <input type="submit" value="修改"/>
      </form>

</body>
</html>