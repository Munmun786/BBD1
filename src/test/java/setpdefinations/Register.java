package setpdefinations;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	
	@Given("User Navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		registerPage=homepage.registerOption();
		
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    Map<String, String> dataMap = dataTable.asMap(String.class, String.class );
	   
	        
	       
	       registerPage.enterFirstNameField(dataMap.get("firstName"));
	     registerPage.enterLastNameField(dataMap.get("lastName"));
	  registerPage.enterEmailField(CommonUtils.getEmailWIthTimeStamp());
	  registerPage.enterTelephoneField(dataMap.get("telephone"));
	  registerPage.enterPasswordField(dataMap.get("password"));
	  registerPage.enterConfirmPassword(dataMap.get("password"));
	  
	   
	}
	
	@When("user enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email (DataTable dataTable) {
	    Map<String, String> dataMap = dataTable.asMap(String.class, String.class );
	    
	    
	       
	       registerPage.enterFirstNameField(dataMap.get("firstName"));
	     registerPage.enterLastNameField(dataMap.get("lastName"));
	  registerPage.enterEmailField(dataMap.get("email"));
	  registerPage.enterTelephoneField(dataMap.get("telephone"));
	  registerPage.enterPasswordField(dataMap.get("password"));
	  registerPage.enterConfirmPassword(dataMap.get("password"));
	    
	  
	   
	}

	@When("User selectd yes for Newsletter")
	public void user_selectd_yes_for_newsletter() {
		registerPage.clickOnSelectBox();
	   
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
	 registerPage.privecyPolicy();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		accountSuccessPage=registerPage.clickOnContinuButton();
	   
	}

	@Then("User accoutn should get created successfully")
	public void user_accoutn_should_get_created_successfully() {
		
		
	   Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	     
	}

	@Then("User should get a proper waring message")
	public void user_should_get_a_proper_waring_message() {
	   Assert.assertTrue(registerPage.getWaringMessage().contains("Warning: E-Mail Address is already registered!"));
	}
	@When("user dont enters the details into  fields")
	public void user_dont_enters_the_details_into_fields() {
	     
	       registerPage.enterFirstNameField("");
	     registerPage.enterLastNameField("");
	  registerPage.enterEmailField("");
	  registerPage.enterTelephoneField("");
	  registerPage.enterPasswordField("");
	  registerPage.enterConfirmPassword("");
	    
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
	  
		Assert.assertTrue(registerPage.getWaringMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFiestNameWaringMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWaringMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailFieldWaringMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWaringMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordFieldMessage());
	}

	
}
