package com.PSM.B032110450.Ladies_Safety_Life_Server.Service;

import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception{
		System.out.println("intercepted");
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie :cookies) {				
			if (cookie.getName().equals("token")) {
				String token = cookie.getValue();
				Claims claims = JwtTools.validateAndExtractToken(token);
				//set the value from the payload into the attribute of request
				request.setAttribute("user_Id", claims.getSubject());
				request.setAttribute("email" , claims.get("email"));
				request.setAttribute("full_name" , claims.get("full_name"));
				return true;
				
					}
				}
			}
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write("Bad Request");
		return false;
	}

}



		
		