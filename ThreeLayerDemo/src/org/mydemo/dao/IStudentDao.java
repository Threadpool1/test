package org.mydemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mydemo.entity.Student;

public interface IStudentDao {
	//增加学生
	public int Add(Student student);
	//删除学生
	public int Delete(int id) ;
	//修改学生
	public int Updata(int id,Student student);
	//查询有没有此学生
	public boolean StudentisEmpty(int id) ;
    //查询该学生
	public Student Query(int id) ;
	//查询全部
	public List<Student> queryAllStudent() ;
	//查询总数
	public int getTotalCount();
	//查询当前页数据集合，currentPage：当前页(页码) pageSize：页面大小（每页显示的数据条数）
	public List<Student> queryStudentsByPage(int currentPage,int PageSize);
}
