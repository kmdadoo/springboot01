package com.study.springboot.auth;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomAuthenticationFailureHandle implements AuthenticationFailureHandler
{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
										HttpServletResponse response,
										AuthenticationException exception) 
	throws IOException, ServletException 
	{
		String loginid = request.getParameter("j_username");
		String errormsg = "";
		
		if (exception instanceof BadCredentialsException) {
			loginFailureCount(loginid);
			errormsg = "아디나 비번이 안맞음 확인ㄱ";
		}else if (exception instanceof InternalAuthenticationServiceException) {
			loginFailureCount(loginid);
			errormsg="아디비번 안맞 확인ㄱ";
		}else if(exception instanceof DisabledException) {
			errormsg="게정이 비활성화됬어 관리자문의 ㄱ";
		}else if(exception instanceof CredentialsExpiredException) {
			errormsg ="비밀번호 유효기간이 만료됬어용";
		}
		request.setAttribute("username", loginid);
		request.setAttribute("error_message", errormsg);
		
		request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
	}
	protected void loginFailureCount(String username) {
//			userDao.countFailure(username);
//			int cnt = userDao.checkFailureCount(username);
//			if (cnt==3) {
//				userDao.disabledUsername(username);
//			}
	}
}
