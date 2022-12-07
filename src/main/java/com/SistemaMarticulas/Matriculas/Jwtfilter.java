package com.SistemaMarticulas.Matriculas;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SistemaMarticulas.Matriculas.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class Jwtfilter extends OncePerRequestFilter{
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			String authenticationHeader = request.getHeader(HEADER);
			if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)) {
				SecurityContextHolder.clearContext();
			} else {
				String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
				Claims claims = Jwts.parser().setSigningKey(JwtUtil.CLAVE.getBytes()).parseClaimsJws(jwtToken)
						.getBody();
				if (claims.get("authorities") != null) {
					List<String> authorities = (List<String>) claims.get("authorities");
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
							claims.getSubject(), null,
							authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
					SecurityContextHolder.getContext().setAuthentication(auth);
				} else {
					SecurityContextHolder.clearContext();
				}
			}
			filterChain.doFilter(request, response);

		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			System.out.println("Excepcion de filtro JWT");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}
}
