package spring.online.store.security.configuration;

import org.springframework.boot.web.reactive.result.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {
	
	private final MustacheViewResolver viewResolver;
	
	public WebConfig(MustacheViewResolver resolver) {
		super();
		this.viewResolver = resolver;
	}
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver);
    }

}
