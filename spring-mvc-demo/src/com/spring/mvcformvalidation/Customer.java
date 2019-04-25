package com.spring.mvcformvalidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.customvalidation.CourseCode;

public class Customer {
	private String firstName;

	@NotNull(message = "Should not be null")
	@Size(min = 1, message = "is required")
	private String lastName;

	@NotNull(message = "Should not be null")
	@Min(value = 0, message = "value must be greater than 0")
	@Max(value = 10, message = "value must be less than or equal to 10")
	private Integer freePasses;

	@Pattern(regexp = "^[0-9]{6}", message = "must be 6 digits")
	private String postalCode;
	
	@CourseCode
	private String courseCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	

}
