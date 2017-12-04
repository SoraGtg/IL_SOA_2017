package controller;

import controller.DatabaseOperator;

import model.User;
import model.UserDoesNotExistException;

public class Controller {
  private DatabaseOperator dbo = new DatabaseOperator();

  public User getUser(String username, String password)  throws UserDoesNotExistException {
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
    //TODO
  }

  public DataContainer downloadData(DataContainer data) {
    //TODO
  }

  public AnalysisResults claimAnalysis(DataContainer data, AnalysisRequest analysisRequest) {
    //TODO
  }

}
