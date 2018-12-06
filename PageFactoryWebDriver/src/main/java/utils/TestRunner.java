package utils;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "D:/Selenium/WebDriver/PageFactoryWebDriver/src/test/java/features"
 ,glue={"D:/Selenium/WebDriver/PageFactoryWebDriver/src/main/java/definition"}
 )
public class TestRunner {

}
