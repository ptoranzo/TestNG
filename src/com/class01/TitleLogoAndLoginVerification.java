package com.class01;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TitleLogoAndLoginVerification extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void titleValidation() {
		String expTitle="Human Management System";
		String actualTitle=driver.getTitle();
		
		if(actualTitle.equals(expTitle)) {
			System.out.println("test pass");
		}else {
			System.out.println("test failed");
		}
	}
	
	@Test
	public void logoValidate() {
		boolean isDisp=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		
		if(isDisp) {
			System.out.println("test pass");
		}else {
			System.out.println("test failed");
		}
	}
	
	@Test
	public void loginValidation() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	
	}
}

