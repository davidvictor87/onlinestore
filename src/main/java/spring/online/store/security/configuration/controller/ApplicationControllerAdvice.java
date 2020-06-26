package spring.online.store.security.configuration.controller;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.security.web.reactive.result.view.CsrfRequestDataValueProcessor;
import reactor.core.publisher.Mono;
import spring.online.store.login.model.Users;
import spring.online.store.security.configuration.CurrentUser;

@ControllerAdvice
public class ApplicationControllerAdvice {
	
	@ModelAttribute
	public Mono<CsrfToken> csrfToken(ServerWebExchange serverExchange){
		Mono<CsrfToken> csrfToken = serverExchange.getAttribute(CsrfToken.class.getName());
		return csrfToken.doOnSuccess(appToken -> serverExchange.getAttributes().put(CsrfRequestDataValueProcessor.DEFAULT_CSRF_ATTR_NAME, appToken));
	}
	
	@ModelAttribute("curentuser")
	public Users currentUser(@CurrentUser Users user) {
		return user;
	}

}
