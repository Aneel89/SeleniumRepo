package com.maven.project;

import org.testng.annotations.Test;

public class SumTest {
	
	@Test
	public void sum() 
	{
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
	}
	@Test
	public void diff()
	{
		int a=100;
		int b=50;
		int c=a-b;
		System.out.println(c);
	}
	@Test
	public void mul()
	{
		int a=10;
		int b=5;
		int c=a*b;
		System.out.println(c);
	}

}