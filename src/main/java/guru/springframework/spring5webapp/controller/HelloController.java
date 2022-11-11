package guru.springframework.spring5webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello world!!!";
	}
	

	@GetMapping("/print")
	public String print() {
		return "welcome msg!!!";
	}
	
	

}
