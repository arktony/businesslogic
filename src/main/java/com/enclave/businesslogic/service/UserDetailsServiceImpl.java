package com.enclave.businesslogic.service;

import com.enclave.businesslogic.domain.User;
import com.enclave.businesslogic.repository.UserRepository;
import com.enclave.businesslogic.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		System.out.println(user+ "From Repo");
		if(user == null)
			throw new UsernameNotFoundException("Invalid Username and Password");

		return new CustomSecurityUser(user);
	}
}
