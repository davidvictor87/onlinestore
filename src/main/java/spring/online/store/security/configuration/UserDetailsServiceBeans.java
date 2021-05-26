package spring.online.store.security.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import spring.online.store.entities.LOG;
import spring.online.store.login.repository.RoleRepository;
import spring.online.store.login.repository.UserRepository;

@Configuration
public class UserDetailsServiceBeans {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
		
	@Bean
	@Primary
	public MapReactiveUserDetailsService mapReactiveUserDetailsService() {
		LOG.applicationLogger().info(users.toString());
		return new MapReactiveUserDetailsService(users);
	}
	
	public String getUsername() {
		return userRepository.findAll().blockFirst().getName();
	}
	
	public String getRole() {
		return roleRepository.findAll().blockFirst().getRole();
	}
	
	private static final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	private static UserDetails userDetails(final String username, final String... roles) {
		return User.withUsername(username)
				.passwordEncoder(passwordEncoder::encode)
				.password("pw")
				.authorities(roles)
				.build();
	}
	
	private Collection<UserDetails> users = new ArrayList<>(
            Arrays.asList(
            		userDetails("Username", "ROLE_")
            ));

}
