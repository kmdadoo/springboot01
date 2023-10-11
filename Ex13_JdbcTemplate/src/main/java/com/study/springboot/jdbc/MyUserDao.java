package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// @Repository 어노테이션을 통해 스프링 컨테이너 시작시 자동으로 빈이 생성된다.
@Repository  // 컨포넌트
public class MyUserDao {
	// JDBC작업을 위해 자동주입 받는다.
    @Autowired	
    // 자동으로 오라클 안의 객체를 연결. 
    // application.properties의 오라클 정보를 사용.
    private JdbcTemplate jdbcTemplate;
 
    // 회원목록
    public List<MyUserDto> list() {
        String query = "select * from myuser";	// 결과가 여러개
        
        /*
         	2개 이상의 레토드를 인출하는 select 쿼리문을 실행할때 query메서드를
         	호출한다. 두번째 인수인 RowMapper가 인출된 레코드를 DTO에 저장한 후
         	List에 추가하여 반환하게 된다. 즉  ResultSet을 저장하기 위한 반복적인
         	작업을 자동으로 처리해준다. 
        */
        List<MyUserDto> list = jdbcTemplate.query(
        		query, new BeanPropertyRowMapper<>(MyUserDto.class));
        		// MyUserDTO => query의 결과를 넣어줌.
        for(MyUserDto my : list) {
        	System.out.println(my);  
        }   
        
        return list;
    }
}