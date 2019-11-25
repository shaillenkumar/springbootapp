package com.helix.rest.webservice.restfulwebservicedemo.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All about the User")
public class User {
	private Integer id;
	
	@ApiModelProperty(notes="Name should be more than 2 characters!")
	@Size(min=2, message="Name should be more than 2 characters!")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Birthdate should not be a future date!")
	private Date date;

	public User() {

	}
	public User(String name) {
		super();
		this.name = name;
	}


	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}	

}
