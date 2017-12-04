package controller;

import java.sql.*;

import model.User;
import model.UserDoesNotExistException;

public class DatabaseOperator {

	// Credentials to connect to the database
	private String dbURL = "jdbc:postgresql://baasu.db.elephantsql.com:5432/kyzksfba";
	private String dbUsername = "kyzksfba";
	private String dbPassword = "eOpz1rPDBSMo7fICNIu6Otj47Rc7rKdd";
	
	//Connection element
	private Connection db ;

	public DatabaseOperator() {
		// Nothing to do ???
	}
	
	public void connectToDatabase() throws ClassNotFoundException, SQLException {
		// TODO : renvoyer une erreur si on est déjà connecté
        Class.forName("org.postgresql.Driver");
    	//org.postgresql.Driver driver = new org.postgresql.Driver() ;
        
        this.db = DriverManager.getConnection(this.dbURL, this.dbUsername, this.dbPassword);
		
	}
	
	public void disconnectFromDatabase() {
		
	}
	
	public User getUser(String username) throws UserDoesNotExistException, SQLException  {
		// TODO : renvoyer des erreurs si pas encore connecté
		// Declaration of variables needed to create a User
		int id;
		int usertype;

        // Declaration of variables needed  for connection to database
        Statement st = db.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = " + username);
        // Autre possibilité : PreparedStatement requete = db.prepareStatement("SELECT * FROM users WHERE username = ?");
        if (rs.next()) {
        	id = rs.getInt(1) ;
        	usertype = rs.getInt(4) ;
        } else {
        	// If nothing was found, close connection before raising an error
            rs.close();
            st.close();
            db.close();
        	throw new UserDoesNotExistException() ;
        }
        // NB : we do not test if there is a second entry, because username is declared as UNIQUE in the database
        rs.close();
        st.close();
        db.close();
        
        // Finally, we can make a new User and return it.
		return new User(this, id, username, usertype);
	}
	
	public boolean testPassword(int id, String password) throws UserDoesNotExistException, SQLException, ClassNotFoundException {
		boolean pwdOK = false ;
		
        Class.forName("org.postgresql.Driver");
    	//org.postgresql.Driver driver = new org.postgresql.Driver() ;

        // Declaration of variables needed  for connection to database
        Connection db = DriverManager.getConnection(this.dbURL, this.dbUsername, this.dbPassword);
        Statement st = db.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE id = " + Integer.toString(id) );
        // Autre possibilité : PreparedStatement requete = db.prepareStatement("SELECT * FROM users WHERE username = ?");
        if (rs.next()) {
        	if (rs.getString(3) == password) {
        		pwdOK = true ;
        	}
        } else {
        	// If nothing was found, close connection before raising an error
            rs.close();
            st.close();
            db.close();
        	throw new UserDoesNotExistException() ;
        }
        // NB : we do not test if there is a second entry, because id is declared as a KEY in the database
        rs.close();
        st.close();
        db.close();
        
		return pwdOK ;
	}
	
}
