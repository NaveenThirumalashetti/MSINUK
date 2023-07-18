package com.msinuk.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String userName;
	
	private String password;
	
	private Long lastVisited;
	
	private Long[] Wishlist;
	
	public User() {
		
	}

	public User(Long id, String firstName, String lastName, String userName, String password, Long lastVisited,
			Long[] wishlist) {
		super();
		this.id = id;
		firstName = firstName;
		lastName = lastName;
		userName = userName;
		this.password = password;
		this.lastVisited = lastVisited;
		Wishlist = wishlist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getLastVisited() {
		return lastVisited;
	}

	public void setLastVisited(Long lastVisited) {
		this.lastVisited = lastVisited;
	}

	public Long[] getWishlist() {
		return Wishlist;
	}

	public void setWishlist(Long[] wishlist) {
		Wishlist = wishlist;
	}
	
}
