package spring.online.store.entities.netty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;

import reactor.netty.http.server.HttpServer;



@Configuration
public class NettyContext {
	
	@Bean
	public NettyContext nettyContext(ApplicationContext context) {
		HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(context).build();
		ReactorHttpHandlerAdapter reactiveAdapter = new ReactorHttpHandlerAdapter(httpHandler);
		HttpServer httpServer = HttpServer.create();
		return (NettyContext) httpServer.handle(reactiveAdapter).bind().block();
	}

}
