package net.javaguides.springboot.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.javaguides.springboot.model.User;

@Service
public class TokenService {
	
	private String key = "String Aleatoria Secret";

	private static final long expirationTime = 1800000;

	public String generateToken(User user) {
		
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
	            .setSubject("Teste JWT API")
	            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
	            .signWith(SignatureAlgorithm.HS256, key)
	            .compact();
		}

	public Claims decodeToken(String token) {
		return Jwts.parser()
				.setSigningKey(key)
	            .parseClaimsJws(token)
	            .getBody();
		}

}
