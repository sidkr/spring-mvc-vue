package com.rest.filter.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.dto.ApiResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
	
	private static final Logger logger = Logger.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		logger.error(" Unauthorized request attempt " + authException.getStackTrace());
		
		 ObjectMapper mapper = new ObjectMapper();
		 
		 ApiResponse r = new ApiResponse(false, "Unauthorized. Please sign in and try again.");
		 
		 String responseMsg = mapper.writeValueAsString(r);
		 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(responseMsg); 
	}

}
