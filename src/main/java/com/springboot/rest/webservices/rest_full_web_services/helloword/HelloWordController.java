package com.springboot.rest.webservices.rest_full_web_services.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWordController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		
		return "Hello World";
	}
	
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		
		return new HelloWorldBean("Hello World");
	}
	
	
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldPathVariable helloWorldPathVariable(@PathVariable String name){
		
		return new HelloWorldPathVariable(String.format("Hello world, %s ", name));
	}

}
