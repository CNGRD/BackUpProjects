package com.backend.testing;

public class A 
{
	public static A a()
	{
		System.out.println("execute a method");
		return new A();
	}
	public static A b()
	{
		System.out.println("execute b method");
		return new A();
	}
	public static B c()
	{
		System.out.println("execute c method");
		return new B();
	}
}
