package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.UserAutheticatedDTO;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserRegistrationService;

@RestController
public class UserRegistrationController {

	private UserRegistrationService userRegistrationService;
	private UserRepository userRepository;

	@Autowired
	public UserRegistrationController(UserRegistrationService userRegistrationService, UserRepository userRepository) {
		this.userRegistrationService = userRegistrationService;
		this.userRepository = userRepository;
	}

	public UserRegistrationController() {

	}

	@PostMapping("/user_auth")
	public ResponseEntity<UserAutheticatedDTO> registrate(@RequestBody User userRegistrationDTO) {

		ResponseEntity<User> user = userRegistrationService.registrate(userRegistrationDTO);
		return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user.getBody(), "Bearer "), HttpStatus.CREATED);

	}
}
