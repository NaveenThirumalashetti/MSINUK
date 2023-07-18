package com.msinuk.main.model;


public class UserDTO {

	private Long id;
	private String FirstName;
	private String LastName;
	private String UserName;
	private String password;
	private Long lastVisited;
	private Long[] Wishlist;
	
	public UserDTO() {
		
	}
	public UserDTO(Long id, String firstName, String lastName, String userName, String password, Long lastVisited,
			Long[] wishlist) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		UserName = userName;
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
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
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
