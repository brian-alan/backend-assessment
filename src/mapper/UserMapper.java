package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setIdProfile(rs.getInt(4));
		user.setIdEmployee(rs.getInt(5));
		user.setStatus(rs.getInt(6));
		user.setCreatedDate(rs.getString(7));
		user.setUpdateDate(rs.getString(8));
		user.setLogin(rs.getInt(9));
		return user;
	}

}
