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
			count=-2;//��ʾϵͳ�Ѿ��и�ѧ����Ϣ
		}
		return count;
	}
	
	public int Delete(int id) {
		int count=-1;
		if(!daoDemo.StudentisEmpty(id)) {
			count=daoDemo.Delete(id);
		}else {
			count=-2;//��ʾϵͳû�и�ѧ����Ϣ
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
			count=-2;//��ʾ��ѧ��������
		}
		return count;
	}
	public List<Student> AllStudent(){
		return daoDemo.queryAllStudent();
	}

	@Override//��ѯ����
	public int getTotalCount() {
		// TODO �Զ����ɵķ������
		return daoDemo.getTotalCount();
	}

	@Override//��ѯ��ǰҳ�����ݼ���
	public List<Student> queryStudentsByPage(int currentPage, int PageSize) {
		// TODO �Զ����ɵķ������
		return daoDemo.queryStudentsByPage(currentPage, PageSize);
	}
}
