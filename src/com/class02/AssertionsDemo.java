package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionsDemo extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}
	
	@Test
	public void titleValidation() {
		String expTitle="Human Management System";
		String actualTitle=driver.getTitle();
		
		Assert.assertEquals(actualTitle, expTitle, "Titles Matched");
		
	}
	
	@Test
	public void logoValidate() {
		boolean isDisp=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		
		Assert.assertTrue(isDisp, "Syntax logo is displayed");
		//using if condition we cannot make TestNG test fail
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
