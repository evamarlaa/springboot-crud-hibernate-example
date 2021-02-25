package net.javaguides.springboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.LoginData;
import net.javaguides.springboot.dto.UserAutheticatedDTO;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserAuthenticationService;

@RestController
public class AuthenticationController {

	private UserAuthenticationService userAuthenticationService;

	@Autowired
	public AuthenticationController(UserAuthenticationService userAuthenticationService) {
		this.userAuthenticationService = userAuthenticationService;
	}

	public AuthenticationController() {

	}

	@PostMapping("/login")
	public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody LoginData dadosLogin,
			@RequestHeader String Authorization) {
		User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
		return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
	}

}
