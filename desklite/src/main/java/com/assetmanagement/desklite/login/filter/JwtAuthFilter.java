package com.assetmanagement.desklite.login.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.assetmanagement.desklite.login.service.JwtService;
import com.assetmanagement.desklite.login.service.TokenBlackListService;
import com.assetmanagement.desklite.login.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//This class helps us to validate the generated jwt token 
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	
//	private final TokenBlackListService tokenBlacklistService;
//	
//	 public JwtAuthFilter(TokenBlackListService tokenBlacklistService) {
//	        this.toke nBlacklistService = tokenBlacklistService;
//	    }

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private TokenBlackListService tokenBlackListService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		
		
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			username = jwtService.extractUsername(token);
			
		}
		
		

		if (token != null && !tokenBlackListService.isTokenBlacklisted(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (jwtService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		} 
		if(token != null && tokenBlackListService.isTokenBlacklisted(token)) {
				 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				 System.out.println("token unauthorized");
		}
		filterChain.doFilter(request, response);
	}
}
