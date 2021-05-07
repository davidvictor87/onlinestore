package spring.online.store.security.configuration;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher.MatchResult;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Order
@ComponentScan({"spring.online.store.service", "spring.online.store.controller"})
public class SecurityConfig {
	
	private static final Set<String> UNSECURED = new HashSet<>( 
            Arrays.asList ( new String[] { "/start/json" } ) );
			
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
		httpSecurity.authorizeExchange().pathMatchers("/start/json").permitAll()
		.pathMatchers("/**").authenticated().and().csrf().and().formLogin().loginPage("/login")
		.authenticationSuccessHandler(new RedirectServerAuthenticationSuccessHandler("/")).and()
		.logout().logoutUrl("/logout");
		SecurityWebFilterChain filter = httpSecurity.build();
		return filter;

	}
	
	 public Mono<MatchResult> blockUnsecured( final ServerWebExchange exchange ) {    
	        URI uri = exchange.getRequest().getURI();
            boolean invalid = "http".equalsIgnoreCase( uri.getScheme() ) &&
	                !UNSECURED.contains ( uri.getPath().toLowerCase() );    
	        return invalid ? MatchResult.notMatch() : MatchResult.match();    
	    }
	
	public Mono<AuthorizationDecision> isUser(Mono<Authentication> authentication, AuthorizationContext context){
		return authentication.map(Authentication::getName)
				.map(username -> username.startsWith("rob@"))
				.map(AuthorizationDecision::new);
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
