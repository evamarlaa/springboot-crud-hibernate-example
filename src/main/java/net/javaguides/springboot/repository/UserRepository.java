package net.javaguides.springboot.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	Optional<User> findByEmail(String email);

	Optional<User> findById(UUID id);
}
