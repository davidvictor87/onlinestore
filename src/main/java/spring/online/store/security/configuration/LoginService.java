package spring.online.store.security.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.online.store.login.model.Users;
import spring.online.store.login.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> users = userRepo.findByName(username);
		users.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return users.map(CustomUserDetails::new).get();
	
	}


}
