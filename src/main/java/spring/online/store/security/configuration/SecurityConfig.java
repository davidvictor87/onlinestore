package spring.online.store.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import io.jsonwebtoken.JwtParser;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Order
@ComponentScan({"spring.online.store.service", "spring.online.store.controller"})
public class SecurityConfig {
			
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
		httpSecurity.authorizeExchange().pathMatchers("/users").access(this::isUser)
		.pathMatchers("/start/login", "/start/welcome", "/webjars/**").permitAll()
		.anyExchange().authenticated().and().formLogin().loginPage("/start/login");
		SecurityWebFilterChain filter = httpSecurity.build();
		return filter;
	}
	
	private Mono<AuthorizationDecision> isUser(Mono<Authentication> authentication, AuthorizationContext context){
		return authentication.map(Authentication::getName)
				.map(username -> username.startsWith("rob@"))
				.map(AuthorizationDecision::new);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
