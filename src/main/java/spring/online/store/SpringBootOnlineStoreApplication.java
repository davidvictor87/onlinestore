package spring.online.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"spring.online.store.security.configuration", "spring.online.store.login.repository", "spring.online.store.login.model", "spring.online.store.db"})
@EnableMongoRepositories
public class SpringBootOnlineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnlineStoreApplication.class, args);
		System.out.println("App Started");
	}

}
