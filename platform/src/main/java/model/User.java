package model;

import java.sql.SQLException;

public class User {
	
	private UsersList userList ; // We have to keep this, in order to test password later
	
	private int id ;
	private String username ;
	private int usertype ;
	private boolean isLoggedIn ;
	
	public User(UsersList userList, int id, String username, int usertype) throws UserDoesNotExistException {
		this.userList = userList ;
		this.id = id;  
		this.username = username ;
		this.usertype = usertype ;
		this.isLoggedIn = false ;
	}
	
	public boolean testPassword(String password) throws UserDoesNotExistException, SQLException, ClassNotFoundException {
		return this.userList.testPassword(this.id, password) ;
	}
	
	
	//***** Getters and Setters *****//
	
	
	public String getUsername() {
		return this.username ;
	}
	
	public int getuserType() {
		return this.usertype ;
	}
	
	public boolean getLoginStatus() {
		return this.isLoggedIn ;
	}
	
	public void setLoginStatus(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn ;
	}

}
