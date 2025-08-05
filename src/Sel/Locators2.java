package Sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) {
		
		
		 String name = "rahul";
		 System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 String password = getPassword(driver);
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 driver.findElement(By.id("inputUsername")).sendKeys(name);
		 driver.findElement(By.name("inputPassword")).sendKeys(password);
		 Thread.sleep(2000);
		 System.out.println(driver.findElement(By.tagName("p")).getText());
		 Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are succesfully logged i n");
		 Assert.assertEquals(driver.findElement(By.cssSelector("div[class=login-container'] h2")).getText(), null);
		 
		 
		 
		 
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'"); //chops the string wherever it sees an empty apostrophe
		String password = passwordArray[1].split("'")[0];
		return password;
		;
	}

}
