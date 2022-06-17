package com.digitalhouse.jwt.service;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

	String extractUserName(String token);
	Date extractExpiration(String token);
	Date extractClaimDate(String token);
	String extractClaimUsername(String token);
	String generateToken(UserDetails userDetails);
	Boolean validateToken(String token, UserDetails userDetails);
}
