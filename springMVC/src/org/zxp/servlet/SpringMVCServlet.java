package org.zxp.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zxp.model.Person;
import org.zxp.model.Student;
/*@SessionAttributes("student")注解作用：如果要在request存放student对象，则同
 * 时将该对象存到session中；如果使用type属性，那么表示将指定类的所有对象都放到session中
 * 
 */
@SessionAttributes("student") 
@Controller
@RequestMapping("test")
public class SpringMVCServlet {
	//访问网址 http://localhost:8087/springMVC/test/welcome
	/*根据配置文件applicationContext.xml中配置视图解析器，视图解析器将在执行完welcome方法后返
	 * 回的success拼接成要跳转的路径 /views/success.jsp
	 * 
	 */
	@RequestMapping("/welcome")	//映射,默认get请求
	public String testWelcome(){
		return "success";	//默认使用了请求转发的跳转方式
	}
	/*@ResponseBody注解会自动的将返回的数据转换为json*/
	@RequestMapping("/requestbody/student")
	@ResponseBody
	public Student testRquestBody(@RequestBody Student stu){
		Student s=stu;
		return s;
	}
	/*@ResponseBody注解会自动的将返回的数据转换为json*/
	@RequestMapping("/requestbody/map")
	@ResponseBody
	public Map<String,Object> testRquestBody2(@RequestBody Map<String,Object> map){
		Map<String,Object> response=map;
		Student s=(Student) response.get("student");
		Person p=(Person) response.get("person");
		System.out.println(s);
		System.out.println(p);
		return response;
	}
	@RequestMapping(value="/param",method=RequestMethod.POST)	//映射
	public String testParam(@RequestParam String name,@RequestParam String age){
		System.out.println("name:"+name+"\n"+"age:"+age);
		return "success";	//默认使用了请求转发的跳转方式
	}
	
	/*直接将表单的各个属性填充到Student的s实例中必须满足以下条件：表单中的
	 * 各个input标签的name属性要与Student类定义的属性名相同*/
	@RequestMapping(value="/objectbinding")
	public String testRequestBody(Student s){
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
	/*在处理任何一个请求前都会先执行被@ModelAttribute注解标记的方法
	  功能：修改的前期准备工作，即查询学生名为zhangsan的记录
	 */
	@ModelAttribute
	public void queryStudent(){
		/*模仿dao层查询数据*/
		Student s=new Student();
		s.setName("zhangsan");
		s.setAge(12);
		s.setHomeAddress("sms");
		s.setSchoolAddress("xima");
	}
	/*掌握ModelAttribute注解的使用
	 * 测试：将学生名为zhangsan的年龄改为18；那么程序逻辑是先查询学生名为zhangsan的记录，之后更新该记录
	 */
	@RequestMapping(value="modelattribute")
	public String testModelAttribute(Student student){
		student.setAge(18);
		System.out.println(student);
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
	
	/*类型转换：将请求体中的特定格式字符串转换为Student*/
	@RequestMapping(value="/converter")
	public void testTypeConverter(@RequestParam("student") Student s){
		System.out.println("name:"+s.getName()+" age:"
		+s.getAge()+" homeAddress:"+s.getHomeAddress()+" schoolAddress:"+s.getSchoolAddress());
		//由于返回值是void，那么DispatcherServlet控制器会默认去找converter.jsp（没有创建这个页面所以404）
	}
	/*日期类型格式化
	 * 开启步骤：1.在配置文件中配置日期格式化类的bean，2.将bean的id值<mvc:annotation>的属性conversion-service
	 * 			3.在日期类型对象上使用@DateTimeFormat注解
	 * 额外扩展功能：如果输入的日期格式错误，那么将在控制台显示出错信息。
	 * 实现步骤，1.紧跟着接收数据的对象p添加参数BindingResult result（专门捕获异常）
	 * 程序的改变：添加参数BindingResult，程序格式化出错还会跳转到success页面；添加之前，程序格式化出错只会报404
	 * */
	@RequestMapping(value="/datetimeformat") //如果Person格式化出错，会将错误信息传入BindingResult对象中
	public String testDateFormat(Person p,BindingResult result){
		System.out.println(p);
		/*判断是否有错误，如果有遍历并打印每个错误至控制台*/
		if(result.getErrorCount()>0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getDefaultMessage());
			}
		}
		return "success";
	}
	/*将控制台中的消息传入jsp页面显示*/
	@RequestMapping(value="/errordeal")
	public String testErrorDeal(Person p,BindingResult result,Model model){
		if(result.getErrorCount()>0){
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error);
			}
			model.addAttribute("errors", result.getFieldErrors());
		}
		return "success";
	}
	/*类型转换响应*/
	@RequestMapping(value="/responseconvert")
	public ModelAndView testTypeConvertError(@RequestParam("student") Student s){
		ModelAndView mv=new ModelAndView("Response_dataFormat");
		mv.addObject("student", s);
		return mv;
	}
	/*文件上传
	 * 方法参数file直接接收文件
	 * */
	@RequestMapping(value="/upload")
	public String testUpload(@RequestParam("desc") String desc,@RequestParam("file")MultipartFile file) throws IOException{
		System.out.println(desc); //打印描述信息
		/*将文件上传到服务器的哪里*/
		InputStream in=file.getInputStream();
		String fileName=file.getOriginalFilename();
		byte[] b=new byte[1024];
		OutputStream out=new FileOutputStream("E:\\"+fileName);
		int len=-1;
		/*将文件以字节流的形式写到文件中*/
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		out.close();
		in.close();
		System.out.println("上传成功");
		return "success";
	}
	/*测试拦截器
	 * 该路径专门用于测试局部拦截器（在配置文件中配置的）
	 * */
	@RequestMapping(value="/interceptor")
	public String testInterceptor(){
		return "success";
	}
}
