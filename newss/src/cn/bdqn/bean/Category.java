package cn.bdqn.bean;

import java.util.Date;



public class Category {
	private int id;
	private  String name;
	private Date createDate;
	public Category(int id, String name, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", createDate="
				+ createDate + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
}
