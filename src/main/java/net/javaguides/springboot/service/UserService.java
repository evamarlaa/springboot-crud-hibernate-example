package net.javaguides.springboot.service;

import java.util.List;
import java.util.UUID;

import net.javaguides.springboot.model.User;

public interface UserService {

	User createUser(User user);
	
	User updateUser(User user);

	List<User> getAllUser();
	
	User getUserById(UUID userId);
	
	void deleteUser(UUID id);
}
