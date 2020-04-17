package org.mydemo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mydemo.entity.Student;
import org.mydemo.service.IStudentService;
import org.mydemo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AllStudentServlet
 */
@WebServlet("/AllStudentServlet")
public class AllStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IStudentService demo=new StudentServiceImpl();
		List<Student> students=demo.AllStudent();
		System.out.println("学生列表："+students);
		request.setAttribute("students", students);
		request.getRequestDispatcher("index1.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
