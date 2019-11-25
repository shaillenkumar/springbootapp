package com.helix.rest.webservice.restfulwebservicedemo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	@GetMapping("/filteringbeanfields")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}
	@GetMapping("/filteringbeanfieldfromlist")
	public List<SomeBean> retrieveSomeBeanList() {
		return Arrays.asList(new SomeBean("value01", "value02", "value03"),new SomeBean("value11", "value12", "value13"));
	}
}
