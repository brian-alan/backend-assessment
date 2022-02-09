package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import dao.UserDao;
import model.User;

public class UserTest {
  @Test
  public void testInsert() {
	  UserDao uDao = new UserDao();
	  User user = new User();
	  user.setUsername("Test3");
	  user.setPassword("test123");
	  user.setIdProfile(1);
	  user.setIdEmployee(1);
	  user.setStatus(1);
	  user.setCreatedDate("2021-12-21");
	  user.setUpdateDate("2021-12-21");
	  user.setLogin(0);
	  assertEquals(true, uDao.addUser(user));
  }
  @Test
  public void testUpdate() {
	  UserDao uDao = new UserDao();
	  User user = new User();
	  user.setId(2);
	  user.setUsername("TestUpdate");
	  user.setPassword("test123");
	  user.setIdProfile(1);
	  user.setIdEmployee(1);
	  user.setStatus(1);
	  user.setCreatedDate("2021-12-21");
	  user.setUpdateDate("2021-12-21");
	  user.setLogin(0);
	  assertEquals(true, uDao.updateUser(user));
  }
  @Test
  public void testDelete() {
	  UserDao uDao = new UserDao();
	  assertEquals(true, uDao.deleteUser(3));
  }
}
