package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
public WebDriver driver;   

By search = By.xpath("//input[@type='search']");
By productName = By.xpath("//h4[@class='product-name']");


			public OffersPage(WebDriver driver)
			{
				this.driver = driver;
			}
			
			
			public void searchItem(String name)
			{
				driver.findElement(search).sendKeys(name);
			}
			
			public void getSearchText()
			{
				driver.findElement(search).getText();
			}
			
			public String getProductName()
			{
				return driver.findElement(productName).getText();
			}
			
			public void changes()
			{
				System.out.println("Changes Made");
				System.out.println("Changes Made1");
				System.out.println("Changes Made2");
			}
			
			public void newchnages()
			{
				System.out.println("Learnign Github");
				System.out.println("Learnign Github1");
				System.out.println("Learnign Github2");
			}
			
		}

