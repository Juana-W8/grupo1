package com.SistemaMarticulas.Matriculas.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	public static final String CLAVE = "AFrt24M";

	public static String crearToken(String login, String rol) {

		List<GrantedAuthority> autorizaciones = AuthorityUtils.commaSeparatedStringToAuthorityList(rol);
		String token = Jwts.builder().setId("jwt" + login).setSubject(login)
				.claim("authorities",
						autorizaciones.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000))
				.signWith(SignatureAlgorithm.HS512, CLAVE.getBytes()).compact();
		return token;
	}
}
