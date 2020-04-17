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
 * Servlet implementation class QueryStudentServlet
 */
@WebServlet("/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		IStudentService demo=new StudentServiceImpl();
		Student student=demo.query(id);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		request.setAttribute("student", student);
		if(student!=null) {
			request.getRequestDispatcher("updatestudent.jsp").forward(request, response);
		}else {
			response.getWriter().println("≤È—Ø ß∞‹£°");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
