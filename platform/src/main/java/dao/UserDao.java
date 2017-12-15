package dao;
import model.Login;
import model.User2;
public interface UserDao {
  void register(User2 user);
  User2 validateUser(Login login);
}