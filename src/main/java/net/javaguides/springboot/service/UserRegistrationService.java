package net.javaguides.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.DuplicateElement;
import net.javaguides.springboot.exception.ExistingEmailException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserRegistrationService {

	private UserRepository userRepository;
	private TokenService tokenService;

	@Autowired
	public UserRegistrationService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public ResponseEntity<User> registrate(User user) {

		Optional<User> a = userRepository.findByEmail(user.getEmail());

//		if (a.isEmpty() || a.isPresent()) {
//			return ResponseEntity.badRequest().body(user);
//		} else {
			user.setToken(tokenService.generateToken(user));
			User u = userRepository.save(user);
//			u.setToken(tokenService.generateToken(user));
//			u = userRepository.save(u);

			return ResponseEntity.ok().body(u);
	//	}
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public User userExists(String email) {
		User user = userRepository.findByEmail(email).orElseThrow(DuplicateElement::new);

		// Optional<User> user = userRepository.findByEmail(email);
		// System.out.print("TESTANDOOOOOOOOOOOO 22222222222222222222");
		return user;
	}
}
