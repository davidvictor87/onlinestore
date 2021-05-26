package spring.online.store.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring.online.store.login.model.Users;
import spring.online.store.security.configuration.CurrentUser;

@ControllerAdvice
public class ApplicationControllerAdvice {
	
	@ModelAttribute("curentuser")
	public Users currentUser(@CurrentUser Users user) {
		return user;
	}

}
