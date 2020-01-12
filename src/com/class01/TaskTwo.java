package com.class01;

import org.testng.annotations.*;

/*
 * Create class that will have:
 * Before and After Class annotation
 * Before and After Method annotation
 * 2 methods with Test annotation
 * Observe the results!
 */

public class TaskTwo {

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	
	@Test
	public void testOne() {
		System.out.println("test one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("test two");
	}
	
}
