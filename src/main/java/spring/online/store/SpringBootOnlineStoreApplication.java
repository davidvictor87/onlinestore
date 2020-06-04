package spring.online.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringBootOnlineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnlineStoreApplication.class, args);
		System.out.println("App Started");
	}

}
