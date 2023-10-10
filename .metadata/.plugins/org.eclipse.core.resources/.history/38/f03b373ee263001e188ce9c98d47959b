package com.study.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 	@Configuration : 해당 클래스를 스프링 설정파일로 사용하겠다는 선언으로
		XML설정 파일을 사용하는 대신 JAVA파일을 설정파일로 사용한다.
 */
@Configuration
public class Config
{
	/*
	 	@Bean : <bean> 엘리먼트와 같이 자바빈을 생성할 때 선언한다.
	 		생성된 빈은 컨트롤러에서 getBean()메서드를 통해 주입받을 수 
	 		있다. 메서드명은 주입받을때의 참조변수명으로 사용한다.
	 		즉 Hello hellobean = new Hello()와 동일하다.
	 */
	@Bean
	public Hello hello() {
		Hello hello1 = new Hello();
		hello1.setName("홍길동");
		hello1.setNickname("전우치");
		hello1.setPrinter(new PrinterA());
		
		return hello1;
	}
	
	@Bean(name="hello1")
	public Hello hello2() {
		return new Hello("홍길동1", "전우치1", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
}