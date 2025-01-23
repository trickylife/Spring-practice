package com.ict.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	//Mapping ����
	//@RequestMapping, @GetMapping, @PostMapping
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1(HttpServletRequest request, Model model) { //Ŭ������ String�� ����: return "home"
		//��ſ����� String -> ������ ��ȯ�ؾ�
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		System.out.println(num+", "+name);
		//Model ��ü�� ������ �����ʹ� ��������(jsp)���� ��� �����ϴ�. 
		//				   ����,������
		model.addAttribute("username","�������");
		model.addAttribute("hi","Welcome");
		
		return "home"; //ViewResolver: WEB-INF/views/home.jsp
	}
	
	@RequestMapping(value="/test2") //Get ��� ���ӿ� ���� ���� (method ���� ����)
	public ModelAndView test2(int num, String name) { //request.getParameter, �� ��ȯ ���� ����
		System.out.println(num+10+"===="+name);
		
		//Model�� View�� ����� ���� Ŭ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("username","�����");
		mav.addObject("hi","bye");
		
		mav.setViewName("home"); //ViewResolver: WEB-INF/views/home.jsp
		return mav;
	}

	@GetMapping("/test3")
	public String test3(TestVO vo, Model model) {
		System.out.println(vo.toString());
		
		TestVO obj = new TestVO();
		obj.setNum(9999);
		obj.setName("�迬��");
		obj.setTel("010-8888-9999");
		
		model.addAttribute("vo",obj);
		
		return "test/view"; //ViewResolver: WEB-INF/views/test/view.jsp
	}
	
	//@PostMapping("/order");
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public ModelAndView test4(String productName, int price, String opt) {
		System.out.println("�ֹ� ��ǰ���� => "+productName+", "+price+", "+opt);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pName", productName+"("+opt+")"); //��Ʈ��(ȭ��Ʈ)
		mav.addObject("sales", price*0.9);
		
		mav.setViewName("test/view");
		return mav;
	}
}
