package spring.online.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan({"spring.online.store.security.configuration", "spring.online.store.login.repository", "spring.online.store.login.model", "spring.online.store.db"})
@EnableMongoRepositories
@EnableWebSecurity
public class SpringBootOnlineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnlineStoreApplication.class, args);
		System.out.println("App Started");
	}

}
