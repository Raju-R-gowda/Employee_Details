package com.employeemodel.www;

public class EmployDetailss {
	private int id;
	private String name;
	private int age;
	public EmployDetailss(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public EmployDetailss() {
		super();
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "EmployDetailss [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	

}
