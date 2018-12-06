package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import definition.EmiratesHomeStepDef;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
    public void beforeScenario(){
		EmiratesHomeStepDef.getCurrentTimeUsingDate();
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/java/browsers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.emirates.com/ae/english/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }	
	
	@After
    public void afterScenario(){
        driver.quit();
    }

}
