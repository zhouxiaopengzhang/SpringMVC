package com.springboot.json.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.json.model.Person;
import com.springboot.json.model.Student;
import com.springboot.json.model.Teacher;
/*该类的作用是将java对象转换成json对象，并响应到浏览器中*/
//注意：json有两种结构（对象、数组）
@RestController
@RequestMapping("/json")
public class Controller {
	//在浏览器中可以查看普通对象的json格式
	@RequestMapping("/student")
	public Student printStudent(){
		Student s=new Student();
		s.setId(1);
		s.setName("张三");
		s.setSex("male");
		return s;
	}
	//在浏览器中可以查看集合对象的json格式
	@RequestMapping("/map")
	public Map<String,Object> printMap(){
		Student s=new Student();
		s.setId(1);
		s.setName("张三");
		s.setSex("male");
		Teacher t=new Teacher();
		t.setId(2);
		t.setName("李老师");
		t.setSex("female");
		t.setLevel("高级教师");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("student", s);
		map.put("teacher", t);
		return map;
	}
	//在浏览器中可以查看数组的json格式
		@RequestMapping("/array")
		public Student[] printArrayStudent(){
			Student[] array=new Student[2];
			Student s=new Student();
			s.setId(1);
			s.setName("张三");
			s.setSex("male");
			Student s2=new Student();
			s2.setId(2);
			s2.setName("李四");
			s2.setSex("male");
			array[0]=s;
			array[1]=s2;
			return array;
		}
		//在浏览器中可以查看日期对象的json格式
		@RequestMapping("/date")
		public Date printDate(){
			Date d=new Date();
			return d;
		}
		//在浏览器中可以查看复合对象的json格式
		@RequestMapping("/person")
		public Person printComplexObject(){
			Person p=new Person();
			p.setId(1);
			p.setName("zhangsan");
			LocalDate date=LocalDate.now();
			p.setBirthday(date);
			return p;
		}
		//通过请求体传参并在浏览器中可以查看复合对象的json格式
		@RequestMapping("/person2")
		public Person printComplexObject2(@RequestBody Person p){
			System.out.println(p);
			return p;
		}
}
