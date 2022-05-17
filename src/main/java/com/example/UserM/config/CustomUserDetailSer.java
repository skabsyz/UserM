package com.example.UserM.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.UserM.entity.User;
import com.example.UserM.repository.UserRepository;

public class CustomUserDetailSer implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {

		try {

			User u = repo.findByEmail("abc@gmail.com");

			System.out.println(u.getEmail());
			if (u == null) {
				// System.out.println(u);
				throw new UsernameNotFoundException("No UserName found");
			} else
				return new CoustomUserDetails(u);

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return null;

	}

}
