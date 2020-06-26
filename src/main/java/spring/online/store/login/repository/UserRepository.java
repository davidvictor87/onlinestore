package spring.online.store.login.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;
import spring.online.store.login.model.Users;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Integer>{

	public Mono<Users> findByName(String username);

}
