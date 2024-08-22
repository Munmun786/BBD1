package setpdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {

	WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;

@Given("User opens the Application")
public void user_opens_the_application() {
   driver= DriverFactory.getDriver();
   homePage = new HomePage(driver);
   searchPage = new SearchPage(driver);
}

@When("User enters valid product {string} into Search box feilds")
public void user_enters_valid_product_into_search_box_feilds(String productText) {
	 
	
	homePage.enterProductIntoSearchBox(productText);
	
   
}

@When("User click on Serach button")
public void user_click_on_serach_button() {
    homePage.clickOnSearchButton();
	
	
}

@Then("User should get valid product display in search result")
public void user_should_get_valid_product_display_in_search_result() {
	 
	
 Assert.assertTrue(searchPage.GetProduct());
}

@When("User enters invalid product {string} into Search box feilds")
public void user_enters_invalid_product_into_search_box_feilds(String invalidProductText) {
	homePage.enterInvalidProduct(invalidProductText);
	 
}

@Then("User should get a message about not product matching")
public void user_should_get_a_message_about_not_product_matching() {
   Assert.assertEquals("There is no product that matches the search criteria.", searchPage.getNoMatchingWaringMessage());
}

@When("User dont enters any product into Search box feilds")
public void user_dont_enters_any_product_into_search_box_feilds() {
    homePage = new HomePage(driver);
}



	
	
}
