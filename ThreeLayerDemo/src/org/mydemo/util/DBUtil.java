package org.mydemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mydemo.entity.Student;

public class DBUtil {
	
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/�û�?useUnicode = true��characterEncoding = utf-8��useSSL = false&serverTimezone = GMT";
	private static final String USERNAME="root";
	private static final String PWD="root";
	
	public static Connection connection=null;
	public static PreparedStatement stmt=null;
	public static ResultSet resultSet=null;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL,USERNAME,PWD);
	}
	
	
	
	public static void closeAll(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet!=null)resultSet.close();
			if(connection!=null)connection.close();
			if(statement!=null)statement.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	
	//ͨ�õ���ɾ��
	public static int executeUpdate(String sql,Object[] params) {
		int count=-1;
		
		try {
			stmt=getConnection().prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					stmt.setObject(i+1, params[i]);
				}	
			}
			count=stmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			count=-1;//��ʾϵͳ�쳣
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			count=-1;
		}finally {
			closeAll(null, stmt, connection);
		}
		return count;
	}
	
	//ͨ�õĲ�
	public static ResultSet executeQuery(String sql,Object[] params) {
		try {
			stmt=getConnection().prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					stmt.setObject(i+1, params[i]);
				}
			}
			resultSet=stmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		
		}
		return resultSet;
	}
	
	//��ѯ����
	public static int getTotalCount(String sql) {
		int count=-1;
		try {
			stmt=getConnection().prepareStatement(sql);
			resultSet=stmt.executeQuery();
			if(resultSet.next()) {
				count=resultSet.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			closeAll(resultSet, stmt, connection);
		}
		return count;
	}
}
