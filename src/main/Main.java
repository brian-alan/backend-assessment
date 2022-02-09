package main;

import java.util.List;

import dao.ProfileDao;
import model.Profile;

public class Main {

	public static void main(String[] args) {
		ProfileDao pDao = new ProfileDao();
		List<Profile> p = pDao.findAll();
		for(Profile profile : p) {
			System.out.println(profile);
		}
		System.out.println("Done!");
	}

}
