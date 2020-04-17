package org.mydemo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mydemo.entity.Student;
import org.mydemo.service.IStudentService;
import org.mydemo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		String address=request.getParameter("uaddress");
		
		
		int count=-1;
		Student student=new Student(id,name,age,address);
		IStudentService demo=new StudentServiceImpl();
		count=demo.update(id, student);
		
		//设置响应编码
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(count>0) {
			response.sendRedirect("QueryStudnetByPage");
		}else if(count==-2){
			response.getWriter().println("修改失败，系统不存在此学生");
		}else {
			response.getWriter().println("修改失败,系统错误");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
