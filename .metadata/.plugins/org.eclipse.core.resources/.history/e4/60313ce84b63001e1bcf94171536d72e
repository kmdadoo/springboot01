package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest
{
	public static void main(String[] args)
	{
		String configLocation = "classpath:beans.xml";
		// 1.IoC 컨테이너 생성  
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(configLocation);
		
		// 2.Hello Bean 가져오기, 스프링 컨테이너에서 컴포넌트 가져옮
		Hello hello = (Hello)context.getBean("hello");  
		hello.print();
		
		// 3.PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		hello.setPrinter(printer);  
		hello.print();
		
		// 4. 싱글톤인지 확인
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);  // 객체값이 같은지
		
		context.close();
	}
}
