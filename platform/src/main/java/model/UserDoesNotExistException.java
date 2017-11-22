package model;

public class UserDoesNotExistException extends Exception {
	
	public UserDoesNotExistException(){
		System.out.println("Unexpected error : the username has not been found.");
	} 
	
}
