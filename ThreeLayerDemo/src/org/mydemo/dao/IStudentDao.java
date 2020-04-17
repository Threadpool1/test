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
	//����ѧ��
	public int Add(Student student);
	//ɾ��ѧ��
	public int Delete(int id) ;
	//�޸�ѧ��
	public int Updata(int id,Student student);
	//��ѯ��û�д�ѧ��
	public boolean StudentisEmpty(int id) ;
    //��ѯ��ѧ��
	public Student Query(int id) ;
	//��ѯȫ��
	public List<Student> queryAllStudent() ;
	//��ѯ����
	public int getTotalCount();
	//��ѯ��ǰҳ���ݼ��ϣ�currentPage����ǰҳ(ҳ��) pageSize��ҳ���С��ÿҳ��ʾ������������
	public List<Student> queryStudentsByPage(int currentPage,int PageSize);
}
