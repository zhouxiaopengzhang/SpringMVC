package org.zxp.servlet;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zxp.model.Student;
/*@SessionAttributes("student")注解作用：如果要在request存放student对象，则同
 * 时将该对象存到session中；如果使用type属性，那么表示将指定类的所有对象都放到session中
 * 
 */
@SessionAttributes("student") 
@Controller
@RequestMapping("test")
public class SpringMVCServlet {
	//访问网址 http://localhost:8087/springMVC/welcome
	/*根据配置文件applicationContext.xml中配置视图解析器，视图解析器将在执行完welcome方法后返
	 * 回的success拼接成要跳转的路径 /views/success.jsp
	 * 
	 */
	@RequestMapping("/welcome")	//映射,默认get请求
	public String welcome(){
		return "success";	//默认使用了请求转发的跳转方式
	}
	
	@RequestMapping(value="/param",method=RequestMethod.POST)	//映射
	public String Param(@RequestParam String name,@RequestParam String age){
		System.out.println("name:"+name+"\n"+"age:"+age);
		return "success";	//默认使用了请求转发的跳转方式
	}
	
	/*直接将表单的各个属性填充到Student的s实例中必须满足以下条件：表单中的
	 * 各个input标签的name属性要与Student类定义的属性名相同*/
	//该方法的功能暂未实现
	@RequestMapping(value="/requestbody",method=RequestMethod.POST)
	public String requestBody(@RequestBody Student s){
		System.out.println(s);
		return "success";
	}
	
	/*在springMVC中使用原生的ServletAPI的方式：
	 * 直接在方法参数中写上请求或响应等对象
	 * */
	@RequestMapping(value="servlet")
	public String testServletAPI(HttpServletRequest request,HttpServletResponse response){
		String name;
		String age;
		try {
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			age = new String(request.getParameter("age").getBytes("ISO-8859-1"),"UTF-8");
			age=request.getParameter("age");
		System.out.println("name:"+name+"\n"+"age:"+age);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return "success";
	}
	
	/*使用MOdelAndView可以实现向跳转的页面传参
	 * */
	@RequestMapping(value="modelandview")
	public ModelAndView testModelAndView(){
		ModelAndView mv=new ModelAndView("success");	//返回到success页面
		Student s=new Student();
		s.setName("张三");
		s.setAge(12);
		mv.addObject("student", s);	//相当于调用request.setAttribute()将s存到request域
		return mv;
	}
	
	/*使用MOdelMap可以实现向跳转的页面传参，
	 * 第二种传参，在方法传参列表中使用ModelMap
	 * */
	@RequestMapping(value="modelmap")
	public String testModelMap(ModelMap map){
		Student s=new Student();
		s.setName("张三2");
		s.setAge(13);
		map.addAttribute("student2", s);//自动将s存到request域
		return "success";
	}
	
	/*使用MOdelAndView可以实现向跳转的页面传参，
	 * 第3种传参，在方法传参列表中使用ModelMap
	 * */
	@RequestMapping(value="map")
	public String testMap(Map<String,Object> map){
		
		Student s=new Student();
		s.setName("张三3");
		s.setAge(11);
		map.put("student3", s);	//自动将s存到request域
		return "success";
	}
	
	/*使用MOdelAndView可以实现向跳转的页面传参，
	 * 第4种传参，在方法传参列表中使用ModelMap
	 * */
	@RequestMapping(value="model")
	public String testModel(Model model){
		Student s=new Student();
		s.setName("张三4");
		s.setAge(12);
		model.addAttribute("student4", s);	//自动将s存到request域
		return "success";
	}
	
	/*
	 * 控制器默认的页面跳转方式是forward即请求转发；下面这个方法将实现请求重定向
	 */
	@RequestMapping(value="redirect")
	public String testRedirect(){
		//return "success"; //这是隐式请求转发的实现方式
		//return "forward:/view/success.jsp"; //这是显式请求转发的实现方式
		return "redirect:/views/success.jsp";	//这是请求重定向的实现方式
	}
	
	/*类型转换：将请求体中的字符串转换为Student*/
	@RequestMapping(value="converter")
	public void testConverter(@RequestParam("student") Student s){
		System.out.println("name:"+s.getName()+" age:"
		+s.getAge()+" homeAddress:"+s.getHomeAddress()+" schoolAddress:"+s.getSchoolAddress());
		//由于返回值是void，那么DispatcherServlet控制器会默认去找converter.jsp（没有创建这个页面所以404）
	}
	/*数据格式化*/
	@RequestMapping(value="format")
	public String testDateFormat(){
		return "dateFormat";
	}
}
