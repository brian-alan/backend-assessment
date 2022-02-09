package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Profile;

public class ProfileMapper implements RowMapper<Profile>{

	@Override
	public Profile mapRow(ResultSet rs, int arg1) throws SQLException {
		Profile profile = new Profile();
		profile.setId(rs.getInt(1));
		profile.setProfile(rs.getString(2));
		return profile;
	}

}
