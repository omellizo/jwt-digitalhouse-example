package com.digitalhouse.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digitalhouse.jwt.model.entity.UserEntity;
import com.digitalhouse.jwt.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Consultara username " + username + " en base de datos");
		UserEntity userEntity = userRepository.findByUsername(username);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(userEntity.getRole()));

		log.info("Usuario autenticado: " + username);

		return new User(username, userEntity.getPassword(), true, true, true, true, authorities);
	}
}
