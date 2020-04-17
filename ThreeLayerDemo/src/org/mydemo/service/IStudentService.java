package org.mydemo.service;

import java.util.List;

import org.mydemo.entity.Student;

public interface IStudentService {
    public int Add(Student student);
	public int Delete(int id) ;
	public Student query(int id) ;
	public int update(int id,Student student);
	public List<Student> AllStudent();
	public int getTotalCount();
	public List<Student> queryStudentsByPage(int currentPage,int PageSize);
}
