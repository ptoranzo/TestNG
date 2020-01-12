package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 *Open chrome browser
 *Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
 *Enter valid username
 *Leave password field empty
 *Verify error message with text “Password cannot be empty” is displayed. 
 */

public class HW extends CommonMethods{
	
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
	@Test(priority=2, dependsOnMethods= {"validationOfMessage"})
	public void validationOfLogo() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isTrue=driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
		
		Assert.assertTrue(isTrue, "Logo is Displayed");
		//if (isTrue) {
		//	System.out.println("Logo is dislayed");
		//}else {
		//	System.out.println("Logo is NOT displayed");
		//}
	}
	@Test(priority=1)
	public void validationOfMessage() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
		boolean message=driver.findElement(By.id("spanMessage")).isDisplayed();
		
		Assert.assertTrue(message, "Message is Displayed");
	//	if (message) {
	//		System.out.println("message is dislayed");
	//	}else {
	//		System.out.println("message is NOT displayed");
	//	}
	}

}
