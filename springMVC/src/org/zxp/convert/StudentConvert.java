package org.zxp.convert;

import org.springframework.core.convert.converter.Converter;
import org.zxp.model.Student;
/*该类的作用是将在浏览器中输入的字符串参数转换成Student对象*/
public class StudentConvert implements Converter<String,Student>{
	//方法参数source会获得在浏览器上输入的内容
	@Override
	public Student convert(String source) {
		String[] str=source.split("--");	//用-分割不同的属性
		Student s=new Student();
		s.setName(str[0]);
		s.setAge(Integer.parseInt(str[1]));
		s.setHomeAddress(str[2]);
		s.setSchoolAddress(str[3]);
		return s;
	}

}
