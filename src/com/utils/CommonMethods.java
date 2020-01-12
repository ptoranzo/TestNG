package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	public static WebDriver driver;
	
	/**
	 * Use this method in need of opening browser and target url
	 * @param browser The desired browser
	 * @param url The desired url
	 */
	
	public static void setUp(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else {
			System.err.println("Browser not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	/**
	 * This method will accept the alert 
	 * @throws will throw a NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	
	
	/**
	 * This method will dismiss the alert
	 * @throws will throw a NoAlertPresentException if alert is not present 
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	
	/**
	 * This method will get a text from the alert
	 * @return text of the alert
	 * @throws will throw a NoAlertPresentException if alert is not present
	 */
	
	public static String getTextAlert() {
		String text=null;
		try {
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
			//return text;
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
		return text;
	}
	
	
	/**
	 * This method will switch to the frame
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	
	
	/**
	 * This method will switch to the frame
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	
	
	/**
	 * This method will switch to the frame
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * This method will click on the element using JSExecutor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * This method will scroll until specified element
	 * @param element
	 */
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * This method will scroll page down until specified pixel
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	/**
	 * This method will scroll page up until specified pixel
	 * @param pixel
	 */
	
	public static void scrollUp(int pixel) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixel+")");
	}

}
