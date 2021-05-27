package spring.online.store.security.configuration;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.security.web.server.authorization.AuthorizationContext;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Order
@ComponentScan({"spring.online.store.service", "spring.online.store.controller"})
public class SecurityConfig {
	
	private static final String [] UNSECURED = {"/start/json", "/start/login"};
			
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
		return httpSecurity.authorizeExchange().pathMatchers(UNSECURED).
		permitAll().pathMatchers("/not/allowed").permitAll().anyExchange().authenticated()
		.and().csrf().disable().formLogin().loginPage("/start/login")
		.authenticationSuccessHandler(new RedirectServerAuthenticationSuccessHandler("/dashbord"))
		.and().build();
	}
	
	public ServerLogoutSuccessHandler logoutSuccess(final String uri) {
		RedirectServerLogoutSuccessHandler logoutSuccess = new RedirectServerLogoutSuccessHandler();
		logoutSuccess.setLogoutSuccessUrl(URI.create(uri));
		return logoutSuccess;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
