package com.spring.mvcformvalidation;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}

	@RequestMapping("/processForm")
	// BindingRequest should be used immediately after the @ModelAttribute
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBinding) {
		System.out.println("Customer Lastname " + customer.getLastName());
		System.out.println("Binding Result :" + theBinding);
		if (theBinding.hasErrors()) {
			return "customerform";
		} else {
			return "customer-confirmation";
		}

	}

	// add an initbinder - to convert trim input strings
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}
}
