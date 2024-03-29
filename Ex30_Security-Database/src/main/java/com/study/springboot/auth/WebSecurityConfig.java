package com.study.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig
{
	@Autowired
	public AuthenticationFailureHandler authenticationFailureHandler;
	
	// 세큐리티 사용을 위해 빈생성
	@Bean  // 변경된 코드
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{  
        http.csrf((csrf) -> csrf.disable())
    		.cors((cors) -> cors.disable())
        	.authorizeHttpRequests(request -> request  
        		/*
        			스프링 부트 3.0부터 적용된 스프링 시큐리티 6.0 에서 forward 방식 페이지 
        			이동에도 default로 인증이 걸리도록 변경되어서 JSP나 타임리프 등 컨트롤러에서 
        			화면 파일명을 리턴해 ViewResolver가 작동해 페이지 이동을 하는 경우 이처럼 
        			설정을 해야 한다.
        		*/
        		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//        			/ : 모든 요청명에 대해 권한 없이 접근할 수 있다.
        		.requestMatchers("/").permitAll()
        		//		정적 리소스(static하위) 에는 권한없이 접근할 수 있다.
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                //		권한없이 접근할 수 있다.
                .requestMatchers("/guest/**").permitAll()  // 모두에게 허용.
                //		USER,ADMIN 권한 중 하나가 있어야 접근할 수 있다.
                .requestMatchers("/member/**").hasAnyRole("USER", "ADMIN") // 두권한 허용
                //	 	ADMIN 권한 만 접근할 수 있다.
                .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 허용
                .anyRequest().authenticated()	// 어떠한 요청이라도 인증 필요
            );
        
        // 로그인 페이지 설정(세큐리티의 디폴트 페이지를 사용한다.)
        http.formLogin((formLogin) ->
        // 이게없으면 기본폼이 출현함.
        	formLogin.loginPage("/loginForm")
        	// 로그인처리(폼전송)를 위한 요청명
        	.loginProcessingUrl("/j_spring_security_check")
        	// 실패시 이동할 경로
//        	.failureUrl("/loginError?error")
        	// 로그인 성공시 이동할 경로
        	.failureHandler(authenticationFailureHandler)
        	// 아이디 입력상자의 name 속성
        	.usernameParameter("j_username")
        	// 패스워드 입력상자에 name 속성
        	.passwordParameter("j_password")
        	.permitAll());
 
        // 로그 아웃 기본 설정 (/logout으로 인증 해제)
        http.logout((logout) ->
    				logout.logoutUrl("/logout")
    				.logoutSuccessUrl("/")
    				.permitAll()
        		);	
        
		return http.build(); 
    }
 
//	@Bean
//    // users() 메서드는 빠른 테스트를 위해 등록이 간단한 inMemory 방식의 인증 사용자를 등록
//    protected UserDetailsService users() 
//    {
//        UserDetails user = User.builder()
//        		.username("user")
//        		.password(passwordEncoder().encode("1234"))
//        		.roles("USER")	// ROLE_USER 에서 ROLE_ 자동으로 붙는다.
//        		.build();
//        UserDetails admin = User.builder()
//        		.username("admin")
//        		.password(passwordEncoder().encode("1234"))
//        		.roles("USER", "ADMIN")	
//        		.build();
//        
//        // 메모리에 사용자 정보를 담는다.
//        return new InMemoryUserDetailsManager(user, admin);
//    }
// 
//    public PasswordEncoder passwordEncoder() {
//      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select name as userName, password, enabled"
							+ " from user_list where name = ?")
		.authoritiesByUsernameQuery("select name as userName, authority "
								+" from user_list where name = ?")
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}
