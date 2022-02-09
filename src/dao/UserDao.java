package dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import mapper.UserMapper;
import model.User;
import service.IdInterface;
import service.UserService;

public class UserDao implements UserService{

	@Override
	public User findUser(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "SELECT IdUser, Username, password, IdProfile, IdEmployee, Status, CreatedDate, UpdateDate, Login from Tbl_Users WHERE IdUser = ?";
		List<User> user = temp.query(query, new Object[] {id} , new UserMapper());
		if(user.isEmpty()) 
			return null;
		return user.get(0);
		
	}

	@Override
	public List<User> findAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "SELECT IdUser, Username, password, IdProfile, IdEmployee, Status, CreatedDate, UpdateDate, Login from Tbl_Users";
		List<User> user = temp.query(query, new UserMapper());
		return user;
	}

	@Override
	public boolean addUser(User user) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		//Functional interface for getting last id
		IdInterface o = () -> temp.queryForObject("select max(IdUser)+1 from Tbl_Users", Integer.class);
		String query = "INSERT INTO Tbl_Users values(?,?,?,?,?,?,?,?,?)";
		return temp.update(query, new Object[] {o.getId(), user.getUsername(), user.getPassword(), user.getIdProfile(), user.getIdEmployee(), user.getStatus(), user.getCreatedDate(), user.getUpdateDate(), user.getLogin()})>0;
	}

	@Override
	public boolean updateUser(User user) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "UPDATE Tbl_Users SET Username = ?, "
				+ "password = ?, "
				+ "IdProfile = ?, "
				+ "IdEmployee = ?, "
				+ "Status = ?, "
				+ "CreatedDate = ?, "
				+ "UpdateDate = ?, "
				+ "Login = ? "
				+ "WHERE IdUser = ?";
		return temp.update(query, new Object[] {user.getUsername(), user.getPassword(), user.getIdProfile(), user.getIdEmployee(), user.getStatus(), user.getCreatedDate(), user.getUpdateDate(), user.getLogin(), user.getId()})>0;
	}

	@Override
	public boolean deleteUser(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "DELETE FROM Tbl_Users WHERE IdUser = ?";
		return temp.update(query, new Object[] {id})>0;
	}

	
}
