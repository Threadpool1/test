package org.mydemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mydemo.entity.Student;
import org.mydemo.service.IStudentService;
import org.mydemo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class AddStudentServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int number=Integer.parseInt(request.getParameter("unumber"));
		String name=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		String address=request.getParameter("uaddress");
		Student student=new Student(number,name,age,address);
		
		IStudentService serviceImpl=new StudentServiceImpl();
		int count=serviceImpl.Add(student);
		
		//������Ӧ����
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		
		PrintWriter out=response.getWriter();
		if(count>0) {
			//���ӳɹ�
			response.sendRedirect("QueryStudnetByPage");
		}else if(count==-2){
			out.println("ѧ���Ѿ�����");
		}else if(count==-1){
			out.println("ϵͳ�쳣");
		}else {
			out.println("���ʧ��");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
