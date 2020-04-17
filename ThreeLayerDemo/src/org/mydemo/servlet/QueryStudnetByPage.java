package org.mydemo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mydemo.dao.IStudentDao;
import org.mydemo.entity.Page;
import org.mydemo.entity.Student;
import org.mydemo.service.IStudentService;
import org.mydemo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudnetByPage
 */
@WebServlet("/QueryStudnetByPage")
public class QueryStudnetByPage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService=new StudentServiceImpl();
		int count=studentService.getTotalCount();//数据总数
		
		String cpage=request.getParameter("currentPage");
		if(cpage==null) {
			//判断是不是第一次进入
			cpage="0";
		}
		int currentPage=Integer.parseInt(cpage);
//		int pageSize=3;
		List<Student> students=studentService.queryStudentsByPage(currentPage, 3);
		
		Page page=new Page();
		page.setTotalCount(count);
		page.setCurrentPage(currentPage);
		page.setPageSize(3);
		page.setStudents(students);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("index1.jsp").forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
