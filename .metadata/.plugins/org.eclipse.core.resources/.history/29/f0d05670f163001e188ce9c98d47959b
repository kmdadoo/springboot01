package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass
{
	public static void main(String[] args)
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:beans.xml");
		System.out.println("aaaaa");
		
		
		ctx.refresh();
		// afterPropertiesSet()실행 - Student
		// initMethod() 실행 - OtherStudent
		
		Student student = ctx.getBean("student", Student.class);	// 사용
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		System.out.println("bbbbb");  // 빈 역활
		
		OtherStudent otherStudent = ctx.getBean("otherStudent", OtherStudent.class);	// 사용
		System.out.println("이름 : " + otherStudent.getName());
		System.out.println("나이 : " + otherStudent.getAge());
		
		ctx.close();
		// 여기는 빈이 소멸된 상태로 아래가 실행됨.
		// destroyMethod() 실행 -OtherStudent
		// destroy() 실행 - Student
		
		System.out.println("ccccc");
	}
}
