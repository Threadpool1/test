<%@page import="org.mydemo.entity.Page"%>
<%@page import="org.mydemo.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息列表</title>
</head>
<body>

       <table border="1px">
             <tr>
              <th>学号</th>
              <th>姓名</th>
              <th>年龄</th>
              <th>地址</th>
              <th>操作</th>
              <th>操作</th>
              </tr>
              <%
              Page p=(Page)request.getAttribute("page");
              for(Student s:p.getStudents()){
              %>
            	  <tr>
            	      <td><%=s.getNumber() %></td>
            	      <td><%=s.getName()%></td>
            	      <td><%=s.getAge()%></td>
            	      <td><%=s.getAddress()%></td>
            	      <td><a href="QueryStudentServlet?id=<%=s.getNumber() %>">修改</a></td>
            	      <td><a href="DeleteStudentServlet?id=<%=s.getNumber() %>">删除</a></td>
            	  </tr>
              <%
              }
              %>
       </table>
       
       <a href="addStudent.jsp">增加</a>
       <a href="QueryStudnetByPage?currentPage=0">首页</a>
       
       <a href="QueryStudnetByPage?currentPage=<%=p.getCurrentPage()==0?"0":p.getCurrentPage()-1%>">上一页</a>
           <select>
           <% for(int i=0;i<p.getTotalPage();i++){
        	   %>
        	   <option value="<%=i+1 %>"><%=i+1%></option>
           <%
           }%>
                 
           </select>
       <a href="QueryStudnetByPage?currentPage=<%=p.getCurrentPage()==p.getTotalPage()-1?p.getTotalPage()-1:p.getCurrentPage()+1 %>">下一页</a>
       <a href="QueryStudnetByPage?currentPage=<%=p.getTotalPage()-1%>">尾页</a>

       <br>
       
</body>
</html>