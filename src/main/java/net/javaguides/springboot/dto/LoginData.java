package net.javaguides.springboot.dto;

public class LoginData {

	private String email;
	private String password;

	public LoginData() {

	}

	public LoginData(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}
