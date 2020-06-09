package spring.online.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ControllerStart {
	
	@GetMapping("/login")
	public void login() {
		System.out.println("Login");
	}
	
	@GetMapping("/welcome")
	public void welcome() {
		System.out.println("Login");
	}
	

}
