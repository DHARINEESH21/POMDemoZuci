package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	
	  @FindBy(xpath ="//input[@id='s-name']")
	  WebElement addname;
	  
	  @FindBy(id="s-surname")
	  WebElement addsurname;
	  
	  @FindBy(id="s-address")
	  WebElement addaddress;
	  
	  @FindBy(id="s-zipcode")
	  WebElement addzipcode;
	  
	  @FindBy(id="s-city")
	  WebElement addcity;
	  
	  @FindBy(id="s-company")
	  WebElement addcompany;
	  
	  
	  @FindBy(id="asap")
	  WebElement includedata;
	  
	
	  @FindBy(xpath="//button[text()='Buy']")
		WebElement buyitem;
	
	  @FindBy(xpath="//h1[text()='Checkout']")
	  	WebElement check;


	  public CheckOutPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	  
	  public String checkHeading()
		{
			 return check.getText();
		}
	  
	  public void buyItems() {
		  

		  addname.sendKeys("Dharineesh");
		  addsurname.sendKeys("S");
		  addaddress.sendKeys("223,cbe");
		  addzipcode.sendKeys("233456");
		  addcity.sendKeys("Chennai");
		  addcompany.sendKeys("Zuci Systems");
		  includedata.click();
		  buyitem.click();
	  }
	
	  

}
