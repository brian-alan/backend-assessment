package service;

import java.util.List;

import model.Profile;

public interface ProfileService {

	public Profile findProfile(int id);
	public List<Profile> findAll();
	public boolean addProfile(Profile profile);
	public boolean updateProfile(Profile profile);
	public boolean deleteUser(int id);
	
}
