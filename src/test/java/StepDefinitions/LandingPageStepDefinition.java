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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
public WebDriver driver;	//to make is accessible whole page
public String landingPageProductName;
TestContextSetup testContextSetup;

public LandingPageStepDefinition(TestContextSetup testContextSetup) //creating a constructor //passing the instance of other class
{
   this.testContextSetup=testContextSetup;
}

@Given("user is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
	    
     System.setProperty("webdriver.chrome.driver", "\\Users\\hp\\Documents\\chromedriver\\chromedriver.exe");
     testContextSetup.driver = new ChromeDriver();
     testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
}
	
@When("user searched with Shortname {string} and extracted actual name of product")
public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	    LandingPage landingPage = new LandingPage(testContextSetup.driver);
	    landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName +" is extracted from Homepage");
	    
}
}

