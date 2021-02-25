package net.javaguides.springboot.dto;

import net.javaguides.springboot.model.User;

public class UserDTO {
		
	private String email;
	private String nome;
	private String token;
	private String password;

	public UserDTO(String email, String nome,
			String token, String password) {

		this.email = email;
		this.nome = nome;
		this.token = token;
		this.password = password;
	}

	public UserDTO() {
	}

	public static UserDTO toDTO(User user) {
		return new UserDTO(user.getEmail(), user.getName(),
				user.getToken(), user.getPassword());
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getToken() {
		return token;
	}
	
	public String getPassword() {
		return password;
	}

}
