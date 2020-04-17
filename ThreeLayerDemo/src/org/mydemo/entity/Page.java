package org.mydemo.entity;

import java.util.List;

public class Page {
	//当前页
	private int currentPage;
	//页面大小
	private int pageSize;
	//总数据
	private int totalCount;
	//总页数
	private int totalPage;
	//当前页的数据集合
	private List<Student> students;
	public Page() {
		
	}
	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> students) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.totalPage=this.totalCount%this.pageSize==0
				?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/*
	 * 总页数=数据总数%页面大小==0？数据总数/页面大小：数据总数/页面大小+1
	 * 当我们调用了数据总数的set（）和页面大小的set（）以后，自动计算出页面总数
	 * */
	public int getTotalPage() {
		
		return totalPage;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	

}
