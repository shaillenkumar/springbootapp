package com.helix.rest.webservice.restfulwebservicedemo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	// To Filter out Field3 and send only field2 and field3
	@GetMapping("/filteringrequest1")
	public MappingJacksonValue retrieveSomeBean() {		
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;		
	}
	
	@GetMapping("/filteringbeanfieldfromlist")
	public MappingJacksonValue retrieveSomeBeanList() {
		List<SomeBean> list =  Arrays.asList(new SomeBean("value01", "value02", "value03"),new SomeBean("value11", "value12", "value13"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	/**
	@GetMapping("/filteringbeanfields")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}
	@GetMapping("/filteringbeanfieldfromlist")
	public List<SomeBean> retrieveSomeBeanList() {
		return Arrays.asList(new SomeBean("value01", "value02", "value03"),new SomeBean("value11", "value12", "value13"));
	}
	**/
}
