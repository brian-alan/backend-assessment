package dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import mapper.ProfileMapper;
import model.Profile;
import service.IdInterface;
import service.ProfileService;

public class ProfileDao implements ProfileService{

	@Override
	public Profile findProfile(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "SELECT IdProfile, Profile from Tbl_Profiles WHERE IdProfile = ?";
		List<Profile> profiles = temp.query(query, new Object[] {id} ,new ProfileMapper());
		if(profiles.isEmpty())
			return null;
		return profiles.get(0);
	}

	@Override
	public List<Profile> findAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "SELECT IdProfile, Profile from Tbl_Profiles";
		List<Profile> profiles = temp.query(query, new ProfileMapper());
		return profiles;
	}

	@Override
	public boolean addProfile(Profile profile) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		//Functional interface for getting last id
		IdInterface o = () -> temp.queryForObject("select max(IdProfile)+1 from Tbl_Profiles", Integer.class);
		String query = "INSERT INTO Tbl_Profiles values(?,?)";
		return temp.update(query, new Object[] {o.getId(), profile.getProfile()})>0;
	}

	@Override
	public boolean updateProfile(Profile profile) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "UPDATE Tbl_Profiles SET Profile = ? WHERE IdProfile = ?";
		return temp.update(query, new Object[] {profile.getProfile(), profile.getId()})>0;
	}

	@Override
	public boolean deleteUser(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
		JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
		String query = "DELETE FROM Tbl_Profiles WHERE IdProfile = ?";
		return temp.update(query, new Object[] {id})>0;
	}

}
