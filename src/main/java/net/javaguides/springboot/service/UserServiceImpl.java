package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Phone;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.PhoneRepository;
import net.javaguides.springboot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDB = this.userRepository.findById(user.getId());
		
		if(userDB.isPresent()) {
			
			User userUpdate = userDB.get();
			userUpdate.setId(user.getId());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setName(user.getEmail());
			userUpdate.setPassword(user.getPassword());
			userUpdate.setToken(user.getToken());
			userRepository.save(userUpdate);
			
			return userUpdate;
		} else {
			throw new ResourceNotFoundException("Record  not found with id: " + user.getId());
		}
	}

	@Override
	public List<User> getAllUser() {

		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		Optional<User> userDB = this.userRepository.findById(userId);
		
		if(userDB.isPresent()) {
			return userDB.get();
		} else {
			throw new ResourceNotFoundException("Record  not found with id: " + userId);
		}
	}

	@Override
	public void deleteUser(long userId) {
		Optional<User> userDB = this.userRepository.findById(userId);
		
		if(userDB.isPresent()) {
			this.userRepository.delete(userDB.get());;
		} else {
			throw new ResourceNotFoundException("Record  not found with id: " + userId);
		}
	}

}
