package spring.online.store.login.repository;

import java.util.Optional;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import spring.online.store.login.model.Users;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Integer>{

	public Optional<Users> findByName(String username);

}
