package com.cg.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	Optional<User> findByEmail(String email);
	List<User>findAll();
}
