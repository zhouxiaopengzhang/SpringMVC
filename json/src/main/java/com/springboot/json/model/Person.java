package com.springboot.json.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


public class Person {
	private Integer id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +  ", birthday=" + birthday + "]";
	}
	
}
