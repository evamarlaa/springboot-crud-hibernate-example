package net.javaguides.springboot.dto;

import net.javaguides.springboot.model.User;

public class UserAutheticatedDTO {
		
	private String email;
	private String nome;
	private String token;

	public UserAutheticatedDTO(String email, String nome,
			String token) {

		this.email = email;
		this.nome = nome;
		this.token = token;
	}

	public UserAutheticatedDTO() {
	}

	public static UserAutheticatedDTO toDTO(User user, String tipo) {
		return new UserAutheticatedDTO(user.getEmail(), user.getName(),
				user.getToken());
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

}
