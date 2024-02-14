package testScripts;

import java.time.Duration;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

public class PlaceOrderTest {
	WebDriver driver;
	HomePage homePage;
	SearchResultPage resultPage;
	ShoppingCartPage cartPage;
	CheckOutPage outPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver(); //get the driver and opening in the chrome
		driver = TestBase.getDriver();
		homePage = new HomePage(driver); // locating the element in the homepage with the driver
		resultPage = new SearchResultPage(driver);
		cartPage = new ShoppingCartPage(driver);
		outPage = new CheckOutPage(driver);
	}
	
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("http://danube-webshop.herokuapp.com/");
	}
  @Test(priority=1)
  public void addToCartTest() {
	  
	  homePage.searchItem("Parry Hotter");
	  resultPage.viewItemDetail();
	  resultPage.addToCart();
	  boolean isAdded = cartPage.isItemAdded();
	  Assert.assertTrue(isAdded);
  }
  
  @Test(priority=2)
  public void checkoutTest() {
	  cartPage.addCoupon();
	  cartPage.doCheckout();
  
}
  
  @Test(priority=3)
  public void checkoutFrom() {
	  
	  String s = outPage.checkHeading();
	  Assert.assertEquals(s,  "Checkout");
	  
	  
	  outPage.buyItems();
	  
	 Assert.assertEquals(driver.getTitle(),"Danube WebShop");
  }
	  
	  
	  
	
  
}

