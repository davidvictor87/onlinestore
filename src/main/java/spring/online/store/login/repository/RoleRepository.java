package spring.online.store.login.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import spring.online.store.login.model.Role;

@Repository
public interface RoleRepository extends ReactiveCrudRepository<Role, Integer>{

}
