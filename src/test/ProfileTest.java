package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import dao.ProfileDao;
import model.Profile;

public class ProfileTest {
  @Test
  public void testInsert() {
	  ProfileDao pDao = new ProfileDao();
	  Profile profile = new Profile();
	  profile.setProfile("Test");
	  assertEquals(true, pDao.addProfile(profile));
  }
  @Test
  public void testUpdate() {
	  ProfileDao pDao = new ProfileDao();
	  Profile profile = new Profile();
	  profile.setId(1);
	  profile.setProfile("Test");
	  assertEquals(true, pDao.updateProfile(profile));
  }
  
  @Test
  public void testDelete() {
	  ProfileDao pDao = new ProfileDao();
	  assertEquals(true, pDao.deleteUser(3));
  }
  
}
