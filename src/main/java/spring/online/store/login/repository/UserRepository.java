package spring.online.store.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.online.store.login.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
