package service;

import java.util.List;

import model.User;

public interface UserService {

	public User findUser(int id);
	public List<User> findAll();
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	
}
