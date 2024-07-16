package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
public String offerPageProductName;
TestContextSetup testContextSetup;

//Single responsibility Principle
//loosly coupled
//Factory Design Pattern

public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}
	
@Then("user searched for {string} shortname in offers page")
public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
	    
		
	    switchToOffersPage();  //SRP method to have each method loosely coupled
	    OffersPage offersPage = new OffersPage(testContextSetup.driver);
	    offersPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.offerPageProductName = offersPage.getProductName();
	    
	}

public void switchToOffersPage()
{
	       // if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/"))
	        
	        LandingPage landingPage = new LandingPage(testContextSetup.driver);
	        landingPage.selectTopDealsPage();
			Set<String> s1 = testContextSetup.driver.getWindowHandles();
			Iterator<String> i1= s1.iterator();
			String parentWindow = i1.next();
			String childWindow =i1.next();
			testContextSetup.driver.switchTo().window(childWindow);
	
}

@And("validate product name in offers page matches with Landing page")
public void validate_product_name_in_offers_page_matches_with_Landing_page(){
	
		Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.landingPageProductName);
	}
	
}
