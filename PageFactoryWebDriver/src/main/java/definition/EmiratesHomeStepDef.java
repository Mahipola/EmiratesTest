package definition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmiratesHomePage;
import utils.Hooks;

public class EmiratesHomeStepDef {
	
	public WebDriver driver;
	
	EmiratesHomePage emiratesPage;
	
	@Given("^Bill has decided to check available flights$")
	public void emirateHome() {
		driver = Hooks.driver;
		System.out.println("Entered given");
		String sTitle = driver.getTitle();
		if(sTitle.contains("Emirates flights")){
			System.out.println("Emirates Home page launched");
		}else{
			System.out.println("Emirates Home page not launched, getting title as : " + sTitle);
			Assert.assertTrue(false);
		}
	}
	
	@When("^Bill looks at a return trip from \"(.*)\" to \"(.*)\" leaving one week from now$")
	public void searchReturnTrip(String strFrom, String strTo) {
		System.out.println("Entered when");
		emiratesPage = new EmiratesHomePage(driver);
		emiratesPage.clickSearchFlights();
		emiratesPage.findDepartureAirport(strFrom);
		driver.findElement(By.xpath("//p[text()='"+"strFrom"+"']")).click();
		emiratesPage.findArrivalAirport(strTo);
		driver.findElement(By.xpath("//p[text()='"+"strTo"+"']")).click();
		emiratesPage.clickContinue();
		String sCurrDay = getCurrentTimeUsingDate("d");
		driver.findElement(By.xpath("//a[@data-date='"+sCurrDay+"']")).click();
		driver.findElement(By.xpath("(//a[@data-date='"+sCurrDay+"'])[2]")).click();
		emiratesPage.clickSearchFlightsBtn();
	}
	
	@Then("^Bill should be shown the cheapest return ticket from \"(.*)\" to \"(.*)\"$")
	public void enterPassword() {
		Assert.assertTrue("Cheapest Flights not displayed", emiratesPage.verifyLowestPricesDisplayed());
	}
	

public static String getCurrentTimeUsingDate(String sDate) {
    Calendar cal = Calendar.getInstance();
    Date date=cal.getTime();
    DateFormat dateFormat = new SimpleDateFormat(sDate);
    String formattedDate=dateFormat.format(date);
    return formattedDate;
}

}
