package org.zxp.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCServlet {
	//访问网址 http://localhost:8087/springMVC/welcome
	/*根据配置文件applicationContext.xml中配置视图解析器，视图解析器将在执行完welcome方法后返
	 * 回的success拼接成要跳转的路径 /views/success.jsp
	 * 
	 */
	@RequestMapping("welcome")
	public String welcome(){
		return "success";
	}
}
