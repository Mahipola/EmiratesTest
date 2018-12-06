package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmiratesHomePage {
	
@FindBy(how = How.XPATH, using = ".//*[text()='Search flights']")
private WebElement searchFlightsTab;

@FindBy(how = How.NAME, using = "Departure airport")
private WebElement departureAirport;

@FindBy(how = How.NAME, using = "Arrival airport")
private WebElement arrivalAirport;

@FindBy(how = How.XPATH, using = "//span[text()='Continue']")
private WebElement continueBtn;

@FindBy(how = How.XPATH, using = "//span[contains(text(),'Lowest price')]")
private WebElement lowestPrice;

@FindBy(how = How.XPATH, using = "(//span[text()='Search flights'])[2]")
private WebElement searchFlightsBtn;



	
public EmiratesHomePage(WebDriver driver){

	 PageFactory.initElements(driver, EmiratesHomePage.class);
}

public void clickSearchFlights(){
	searchFlightsTab.click();
	System.out.println("Clicked Search Flights");
}

public void findDepartureAirport(String sDeprtAirport){
	departureAirport.sendKeys(sDeprtAirport);
	System.out.println("Entered in Departure Airport" +sDeprtAirport);
}

public void findArrivalAirport(String sArrivalAirport){
	arrivalAirport.sendKeys(sArrivalAirport);
	System.out.println("Entered in Arrival Airport" +sArrivalAirport);
}

public void clickContinue(){
	continueBtn.click();
	System.out.println("Clicked Continue button");
}

public boolean verifyLowestPricesDisplayed(){
	if(lowestPrice.isDisplayed()){
		return true;
	}else{
		return false;
	}
}

public void clickSearchFlightsBtn(){
	searchFlightsBtn.click();
}

}
