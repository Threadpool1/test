package org.mydemo.service.impl;

import java.util.List;

import org.mydemo.dao.IStudentDao;
import org.mydemo.dao.impl.StudentDaoImpl;
import org.mydemo.entity.Student;
import org.mydemo.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	private  IStudentDao daoDemo=new StudentDaoImpl();
	public int Add(Student student) {
		int count=-1;
		boolean b=daoDemo.StudentisEmpty(student.getNumber());
		if(b) {
			count=daoDemo.Add(student);
		}else{
			count=-2;//表示系统已经有该学生信息
		}
		return count;
	}
	
	public int Delete(int id) {
		int count=-1;
		if(!daoDemo.StudentisEmpty(id)) {
			count=daoDemo.Delete(id);
		}else {
			count=-2;//表示系统没有该学生信息
		}
		return count;
	}
	public Student query(int id) {
	    return daoDemo.Query(id);
			
	}
	public int update(int id,Student student) {
		int count=-1;
		if(!daoDemo.StudentisEmpty(id)) {
			count =daoDemo.Updata(id, student);
		}else {
			count=-2;//表示该学生不存在
		}
		return count;
	}
	public List<Student> AllStudent(){
		return daoDemo.queryAllStudent();
	}

	@Override//查询总数
	public int getTotalCount() {
		// TODO 自动生成的方法存根
		return daoDemo.getTotalCount();
	}

	@Override//查询当前页面数据集合
	public List<Student> queryStudentsByPage(int currentPage, int PageSize) {
		// TODO 自动生成的方法存根
		return daoDemo.queryStudentsByPage(currentPage, PageSize);
	}
}
