package com.spring.mvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller method to read form data and add data to the model

	@GetMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String studentName = request.getParameter("studentName");
		studentName = "Yo!!! " + studentName.toUpperCase();
		model.addAttribute("message", studentName);
		return "helloworld";
	}
	
	//using @RequestParam annotation to get form data
	@GetMapping("/processFormVersionThree")
	public String letsShoutDudeUsingAnnotation(@RequestParam("studentName") String studentName,Model model) {
		
		studentName = "HEY MY FRIEND " + studentName.toUpperCase();
		model.addAttribute("message", studentName);
		return "helloworld";
	}

}
