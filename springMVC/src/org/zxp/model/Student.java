package org.zxp.model;

public class Student {
	private String name;
	private int age;
	private String homeAddress;
	private String schoolAddress;
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
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", homeAddress=" + homeAddress + ", schoolAddress="
				+ schoolAddress + "]";
	}
	
}
