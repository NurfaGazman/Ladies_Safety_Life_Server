package com.PSM.B032110450.Ladies_Safety_Life_Server.Service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service

public class JwtTools {

	public static String secret = "c5d2460186f7233c927e7db2dcc703c0e500b653ca82273b7bfad8045d85a470";
	public static double expiry_time =  3.156e+10;
	
	public static String generateToken(String user_Id, String email , String full_name) {
		//build_payload
		
		Claims claims = Jwts.claims().setSubject(user_Id);
		claims.put("email", email);
		claims.put("full_name" , full_name);
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, secret)
				.setExpiration(new Date(System.currentTimeMillis()+ (int) expiry_time))
				.compact();
	}
	
	public static Claims validateAndExtractToken(String token) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
			return claims;
		}catch (JwtException e) {
			return null;
		}
	}
}
