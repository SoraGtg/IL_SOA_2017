package controller;

import java.sql.SQLException;

import controller.DatabaseOperator;
import model.AnalysisRequest;
import model.AnalysisResults;
import model.DataContainer;
import model.DataRequest;
import model.User;
import model.UserDoesNotExistException;

public class Controller {
  private DatabaseOperator dbo = new DatabaseOperator();

  public User getUser(String username, String password)  throws UserDoesNotExistException, SQLException, ClassNotFoundException {
    User user = dbo.getUser(username);
    int id = user.getUserId();
    boolean exitUser = dbo.testPassword(id, password);
    if(exitUser) {
      return user;
    } else {
      return null;
    }
  }

  public void addAccount(String username, String password, boolean partner) {
    //TODO
  }

  public DataContainer claimData(DataRequest dataRequest) {
	DataContainer dc = new DataContainer();
	//TODO
    return dc;
  }

  public DataContainer downloadData(DataContainer data) {
	  DataContainer dc = new DataContainer();
    //TODO
	  return dc;
  }

  public AnalysisResults claimAnalysis(DataContainer data, AnalysisRequest analysisRequest) {
	  AnalysisResults aResults = new AnalysisResults();
    //TODO
	  return aResults;
  }

}
