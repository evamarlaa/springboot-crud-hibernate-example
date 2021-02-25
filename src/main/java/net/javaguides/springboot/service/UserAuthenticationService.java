package net.javaguides.springboot.service;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import net.javaguides.springboot.dto.LoginData;
import net.javaguides.springboot.exception.ExistingEmailException;
import net.javaguides.springboot.exception.ExpiredTokenException;
import net.javaguides.springboot.exception.InvalidLoginException;
import net.javaguides.springboot.exception.InvalidTokenException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
public class UserAuthenticationService {

	private final UserRepository userRepository;
	private final TokenService tokenService;

	@Autowired
	public UserAuthenticationService(UserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public User authenticate(LoginData dados, String token) {
		//User user = userRepository.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
		
		Optional<User> userDB = this.userRepository.findByEmail(dados.getEmail());
		
		if(userDB.isPresent()) {
			User user = userRepository.findByEmail(dados.getEmail()).get();
			if (dados.getpassword().equals(user.getPassword()) && !token.isEmpty() && validate(token)) {
				user.setLastLogin(new Date()); 
				userRepository.save(user);
				return user;
			} else {
				throw new InvalidLoginException("Incorrect email or password.");
			}
		} else {
			throw new ResourceNotFoundException("Record  not found.");
		}
		
		
	}

	private boolean validate(String token) {
		try {
			String tokenTratado = token.replace("Bearer ", "");
			Claims claims = tokenService.decodeToken(tokenTratado);

			System.out.println(claims.getIssuer());
			System.out.println(claims.getIssuedAt());
			if (claims.getExpiration().before(new Date(System.currentTimeMillis())))
				throw new ExpiredTokenException("Expired Token.");
			System.out.println(claims.getExpiration());
			return true;
		} catch (ExpiredTokenException et) {
			et.printStackTrace();
			throw et;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidTokenException("Invalid Token.");
		}

	}
}
