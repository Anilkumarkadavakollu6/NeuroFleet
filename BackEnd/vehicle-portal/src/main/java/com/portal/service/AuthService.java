	package com.portal.service;
	
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.portal.model.User;
	import com.portal.repository.UserRepository;
	
	@Service
	public class AuthService {
	
	    @Autowired
	    UserRepository repo;
	
	    public User signup(User u) {

	        System.out.println("EMAIL RECEIVED = " + u.getEmail());

	        Optional<User> check = repo.checkEmail(u.getEmail());

	        System.out.println("QUERY RESULT = " + check);

	        if(check.isPresent()) {
	            throw new RuntimeException("Email Exists");
	        }

	        return repo.save(u);
	    }

	    public Optional<User> login(String email, String pass, String role) {

	        return repo.doLogin(email, pass, role);
	    }

	}	
