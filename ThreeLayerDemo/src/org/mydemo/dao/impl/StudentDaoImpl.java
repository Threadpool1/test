package org.mydemo.dao.impl;

import java.sql.Connection;
                                                                                                                             
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mydemo.dao.IStudentDao;
import org.mydemo.entity.Student;
import org.mydemo.util.DBUtil;



public class StudentDaoImpl implements IStudentDao{

	public int Add(Student student) {
		String sql="insert into student values(?,?,?,?)";
		Object[] params= {student.getNumber(),student.getName(),student.getAge(),student.getAddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public int Delete(int id) {
		String sql="delete from student where id=?";
		Object[] params= {id};
		return DBUtil.executeUpdate(sql, params);
	}
	
    public int Updata(int id,Student student) {
		String sql="update student set name=?,age=?,address=? where id=?";
		Object[] params= {student.getName(),student.getAge(),student.getAddress(),id};
		return DBUtil.executeUpdate(sql, params);
	}
    
	public boolean StudentisEmpty(int id) {

		return Query(id)==null?true:false;

	}
	public Student Query(int id) {
		ResultSet resultSet=null;
		Student student = null;
		
		try {
			String sql="select * from student where id=?";
			Object [] params={id};
			resultSet=DBUtil.executeQuery(sql, params);
			if(resultSet.next()) {
				int number=resultSet.getInt("id");
				String name=resultSet.getString("name");
				int age=resultSet.getInt("age");
				String address=resultSet.getString("address");
				student=new Student(number,name,age,address);
			}
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		
		}finally {
			DBUtil.closeAll(resultSet, DBUtil.stmt, DBUtil.connection);
			
		}
		return student;
	}
	
	//查询全部
	public List<Student> queryAllStudent() {

		ResultSet resultSet=null;
		List<Student> students = new ArrayList<Student>();
		try {
			String sql="select * from student";
			resultSet=DBUtil.executeQuery(sql, null);
			while(resultSet.next()) {
				int number=resultSet.getInt("id");
				String name=resultSet.getString("name");
				int age=resultSet.getInt("age");
				String address=resultSet.getString("address");
				Student student=new Student(number,name,age,address);
				students.add(student);
				System.out.println("加入学生信息："+student.toString());
			}
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		
		}finally {
				DBUtil.closeAll(resultSet, DBUtil.stmt, DBUtil.connection);
			
			
		}
		return students;
	}
	//查询总数
	public int getTotalCount() {
		String sql="select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	//当前页数据集合
	public List<Student> queryStudentsByPage(int currentPage, int PageSize) {
		List<Student> students = new ArrayList<Student>();
		String sql="select * from student limit ?,?";
		Object[] params= {currentPage*PageSize,PageSize};
		ResultSet resultSet=DBUtil.executeQuery(sql, params);
		try {
			while(resultSet.next()) {
				int number=resultSet.getInt("id");
				String name=resultSet.getString("name");
				int age=resultSet.getInt("age");
				String address=resultSet.getString("address");
				Student student=new Student(number,name,age,address);
				students.add(student);
				System.out.println("加入学生信息："+student.toString());
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(resultSet, DBUtil.stmt, DBUtil.connection);
		}
		return students;
	}

}
