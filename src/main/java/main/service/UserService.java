package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import main.model.Users;
import main.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;


	public void addUser(Users user) {
		
	}
	public boolean validateUser(String username, String password) {
		if (userRepo.findByUsername(username).size() == 0) { return false; }
		final Users user = userRepo.findByUsername(username).get(0);
		return password.equals(user.getPasswd());
	}	

}
