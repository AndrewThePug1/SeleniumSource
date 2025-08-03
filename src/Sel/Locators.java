package Sel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {

    public static void main(String[] args) {
    	
    	
    	//implicit wait - 2 seconds time out
    	

        // Path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/andre/Desktop/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        // Point directly to the copied profile (it's now its own user-data-dir)
        options.addArguments("user-data-dir=C:/Users/andre/AppData/Local/Google/Chrome/User Data/SeleniumProfile1");
        options.addArguments("profile-directory=.");

        // Optional: clean look
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Launch browser
        WebDriver driver = new ChromeDriver(options);
        //If taking > 5 seconds to load tell Selenium to not fail immediately. Wait 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("andrew");
        driver.findElement(By.name("inputPassword")).sendKeys("turtle22");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        
    }
}
