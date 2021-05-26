package spring.online.store.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class WebRoutes {

	@Bean
	public RouterFunction<?> viewRoutes() {
		return RouterFunctions
				.route(RequestPredicates.GET("/login"),
						req -> ServerResponse.ok().render("login-form", req.exchange().getAttributes()))
				.andRoute(RequestPredicates.GET("/bye"), req -> ServerResponse.ok().render("bye"))
				.filter((req, resHandler) -> req.exchange()
						.getAttributeOrDefault(CsrfToken.class.getName(), Mono.empty().ofType(CsrfToken.class))
						.flatMap(csrfToken -> {
							req.exchange().getAttributes().put(csrfToken.getParameterName(), csrfToken);
							return resHandler.handle(req);
						})

				);
	}

}
