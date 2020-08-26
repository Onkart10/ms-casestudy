package com.ibm.orderms.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ibm.orderms.service.AuthService;


@Component
public class RequestFilter extends OncePerRequestFilter{

	@Autowired
	AuthService authService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse  httpResponse= (HttpServletResponse) response;
		System.out.println("Filter: URL called:"+httpRequest.getRequestURL().toString());
		
		if(!authService.vlidateToken(request)) {
			httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().println("Invalid token");
		}
			
		filterChain.doFilter(httpRequest, httpResponse);
	}

}
