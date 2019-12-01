package com.helix.rest.webservice.restfulwebservicedemo.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	//Url Versioning
	@GetMapping("v1/getPerson")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("v2/getPerson")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

	// Version using the request Params variable
	@GetMapping(value="getPersonWithParamVer", params = "version=1")
	public PersonV1 personVerWithParamV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value="getPersonWithParamVer", params = "version=2")
	public PersonV2 personVerWithParamV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

	// Version using the Headers Variable 
	@GetMapping(value="getPersonWithHeaderVer", headers = "X-API-VERSION=1")
	public PersonV1 personVerWithHeaderV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value="getPersonWithHeaderVer", headers = "X-API-VERSION=2")
	public PersonV2 personVerWithHeaderV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}

	// Version using the ACCEPT Header - Produces parameter
	@GetMapping(value="getPersonWithProduces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 personProducesV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value="getPersonWithProduces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 personProducesV2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
}
