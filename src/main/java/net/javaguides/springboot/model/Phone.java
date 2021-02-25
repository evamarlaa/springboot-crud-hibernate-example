package net.javaguides.springboot.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Phone {

	@Id
    @GeneratedValue(generator = "UUID")
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User user;

	@Column(name = "number")
	private String number;

	@Column(name = "ddd")
	private String ddd;
	
	@Column(name = "created")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "modified")
	@CreationTimestamp
	private Date updatedAt;

	public Phone(String number, String ddd) {

		this.number = number;
		this.ddd = ddd;
	}

	public Phone() {

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
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

	@Override
	public String toString() {
		return "Phone [id=" + id + ", ddd=" + ddd + ", number=" + number + ", user_id=" +"]";
	}
}
