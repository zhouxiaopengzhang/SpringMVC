package org.zxp.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*实现springMVC的异常处理功能（局部异常处理）*/
@Controller
@RequestMapping("/test")
public class ExceptionHandlerController {
	/*捕获该类中其他方法抛出的指定异常（由@ExceptionHandler的参数指定）,并在jsp页面显示异常信息
	 * 参数e：接收捕获的异常
	 * */
	@ExceptionHandler(value={ArithmeticException.class})
	public String ExceptionHandler(ArithmeticException e,Model m){
		System.out.println(e.getMessage()); //在控制台打印
		m.addAttribute("exception", e.getMessage());
		return "error";
	}
	/*测试在抛出算数异常（本类可以处理的异常类型）*/
	@RequestMapping("/partexceptionhandler")
	public String testPartExceptionHandler(){
		System.out.println(2/0); //会抛出ArithmeticException
		return "success";
	}
	/*测试在抛出数组溢出异常（本类无法处理的异常类型）*/
	@RequestMapping("/exceptionhandler")
	public String testExceptionHandler(){
		int[] a=new int[2];
		a[0]=1;
		a[1]=2;
		System.out.println(a[2]); //会抛出ArrayIndexOutOfBoundsException
		return "success";
	}
}
