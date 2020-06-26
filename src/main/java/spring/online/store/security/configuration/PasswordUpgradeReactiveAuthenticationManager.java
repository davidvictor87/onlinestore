package spring.online.store.security.configuration;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import spring.online.store.login.model.Users;
import spring.online.store.login.repository.UserRepository;

public class PasswordUpgradeReactiveAuthenticationManager implements ReactiveAuthenticationManager{
	
	private final UserRepository users;
	private final ReactiveAuthenticationManager delegate;
	private final PasswordEncoder encoder;

	PasswordUpgradeReactiveAuthenticationManager(UserRepository users,
			ReactiveUserDetailsService userDetailsService, PasswordEncoder encoder) {
		this.users = users;
		this.delegate = createDelegate(userDetailsService, encoder);
		this.encoder = encoder;
	}
	
	@Override
	public Mono<Authentication> authenticate(Authentication authentication){
		return this.delegate.authenticate(authentication).delayUntil(a -> updatePassword(authentication));
	}
	
	private Mono<Users> updatePassword(Authentication authentication){
		return users.findByName(authentication.getName()).publishOn(Schedulers.parallel())
				.doOnSuccess(u -> u.setPassword(this.encoder.encode(authentication.getCredentials().toString())))
				.flatMap(this.users::save);
	}
	
	private static ReactiveAuthenticationManager createDelegate(ReactiveUserDetailsService reactiveUserDetailsService, PasswordEncoder encoder) {
		UserDetailsRepositoryReactiveAuthenticationManager result = new UserDetailsRepositoryReactiveAuthenticationManager(
				reactiveUserDetailsService);
		result.setPasswordEncoder(encoder);
		return result;
	}


}
