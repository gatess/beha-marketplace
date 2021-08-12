package com.gates.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gates.dao.model.User;
import com.gates.dao.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
    UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail);
		}
        return UserPrincipal.create(user);
	}
	
	   @Transactional
	    public UserDetails loadUserById(Long id) {
	        User user = userRepository.findById(id).get();
	        if(user == null) {
	        	throw new UsernameNotFoundException("User not found with id : " + id);
	        }
	        return UserPrincipal.create(user);
	    }

}
