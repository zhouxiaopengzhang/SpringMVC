package org.zxp.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*全局异常处理类：可以捕获处理这个web应用的所有异常*/
@ControllerAdvice	//该注解代表这是一个异常处理类（可以处理所有类抛出的异常）
public class MyExceptionHandler {
	/*处理所有类抛出的异常ArithmeticException*/
	@ExceptionHandler(value={ArithmeticException.class})
	public String arithmeticExceptionHandler(ArithmeticException e,Model m){
		System.out.println(e.getMessage()); //在控制台打印
		m.addAttribute("arithmeticException", e.getMessage());
		return "error";
	}
	/*处理所有类抛出的异常ArrayIndexOutOfBoundsException*/
	@ExceptionHandler(value={ArrayIndexOutOfBoundsException.class})
	public String arrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e,Model m){
		System.out.println(e); //在控制台打印
		m.addAttribute("arrayIndexOutOfBoundsException", e);
		return "error";
	}
}
