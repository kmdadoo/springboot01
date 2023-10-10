package com.study.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean
{
	private String name;
	private int age;
	
	public Student(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Student : afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Student : destroy()");
	}
}
