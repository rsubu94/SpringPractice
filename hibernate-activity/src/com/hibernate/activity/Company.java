package com.hibernate.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private int id;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_designation")
	private String employeeDesignation;

	@Column(name = "company_name")
	private String companyName;

	public Company() {
	}

	public Company(String employeeName, String employeeDesignation, String companyName) {
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.companyName = companyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", employeeName=" + employeeName + ", employeeDesignation=" + employeeDesignation
				+ ", companyName=" + companyName + "]";
	}

}
