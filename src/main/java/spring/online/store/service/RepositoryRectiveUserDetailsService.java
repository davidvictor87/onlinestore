package spring.online.store.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import spring.online.store.login.model.Users;
import spring.online.store.login.repository.UserRepository;

@Service
public class RepositoryRectiveUserDetailsService implements ReactiveUserDetailsService{
	
	private UserRepository userRepository;
	
	@Autowired
	public RepositoryRectiveUserDetailsService(UserRepository uRepo) {
		this.userRepository = uRepo;
	}

	@Override
	public Mono<UserDetails> findByUsername(String username) {
		return this.userRepository.findByName(username).map(CustomUserDetails::new);
	}
	
	static class CustomUserDetails extends Users implements UserDetails{

		private static final long serialVersionUID = 1L;

		public CustomUserDetails(Users user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}		
	}
	
	

}
