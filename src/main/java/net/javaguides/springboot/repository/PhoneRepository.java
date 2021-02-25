package net.javaguides.springboot.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

	Optional<Phone> findById(UUID id);

}
