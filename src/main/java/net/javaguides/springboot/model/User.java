package net.javaguides.springboot.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User{

	@Id
    @GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email"/* , unique = true */)
	private String email;

	@Column(name = "password")
    private String password;
    
	@Column(name = "token")
	private String token;
	
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL) 
	private Set<Phone> phones  = new HashSet<>();
	
	@Column(name = "created")
    @CreationTimestamp
	private Date createdAt;
	
	@Column(name = "modified")
	@CreationTimestamp
	private Date updatedAt;
	
	@Column(name = "last_login")
	private Date lastLogin;
	
	public User() {
		
	}
	
	public User(String email) {
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Phone> getPhones() {

		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
		for (Phone p : phones) {
			p.setUser(this);
		}
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
