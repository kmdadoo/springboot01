package com.edu.springboot;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig
{
	@Bean(name="myprops")
	public PropertiesFactoryBean propertiesFactoryBean()
	{
		//프로퍼티 인스턴스 생성 
		PropertiesFactoryBean  propertiesFactoryBean = new PropertiesFactoryBean();
		//사용자 정의 프로퍼티 파일의 경로 지정 
		ClassPathResource classPathResource = new ClassPathResource("board_config.properties");
		//경로를 등록한 후 인스턴스를 반환한다.
		propertiesFactoryBean.setLocation(classPathResource);
		return  propertiesFactoryBean;
	}
}
