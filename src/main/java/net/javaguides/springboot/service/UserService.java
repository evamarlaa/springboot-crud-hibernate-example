package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.User;

public interface UserService {

	User createUser(User user);
	
	User updateUser(User user);

	List<User> getAllUser();
	
	User getUserById(long userId);
	
	void deleteUser(long id);
}
