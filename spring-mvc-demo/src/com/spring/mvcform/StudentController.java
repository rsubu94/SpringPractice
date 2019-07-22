package com.spring.mvcform;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
//@PropertySource(name="favLanguage" , value="classpath:../languages.properties")
public class StudentController {
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@Value("#{favLanguage}")
	private Map<String, String> favLanguage;

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		// create a student object and add that object to model
		model.addAttribute("studentDeta", new Student());
		model.addAttribute("theCountryOptions", countryOptions);
		model.addAttribute("theFavLanguage", favLanguage);
		System.out.println("value set");

		return "student-form";
	}

	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("studentDeta") Student studentDeta) {
		System.out.println("Student Firstname " + studentDeta.getFirstName());
		System.out.println("Student Lastname " + studentDeta.getLastName());
		//System.out.println("Student Contry " + studentDeta.getCountry());
		System.out.println("Student FavoriteLanguage " + studentDeta.getFavoriteLanguage());

		return "student-confirmation";

	}

}
