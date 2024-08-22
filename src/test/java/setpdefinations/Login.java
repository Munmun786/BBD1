package setpdefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

import java.util.Date;

public class Login {
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	@Given("User has Navigates to login Page")
	public void User_navigates_to_login_page() {
		     driver= DriverFactory.getDriver();
		    HomePage homePage = new HomePage(driver);
		 homePage.clickOnMyAccount();   
		  loginPage= homePage.clickOnLoginOption();
		   
			}
	@When("^User has entered valid  email address (.+) into email field$")
	public void user_has_entered_valid_email_address_into_email_field(String emailText) {
	   
		 
		 loginPage.enterEmailAddress(emailText);
	}

	@And("^User has entered valid Password  (.+) into Password Field$")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
		
           loginPage.enterPassword(passwordText);
		
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   
		accountPage=loginPage.clickOnLoginButton();
	}

	@Then("User should get Successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
	    Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User has entered invalid email  address  into the email field")
	public void user_has_entered_invalid_email_address_into_the_email_field() {
		         
		         loginPage.enterEmailAddress(CommonUtils.getEmailWIthTimeStamp());
		
		
	}

	@When("User has entered invalid password address {string} into password field")
	public void user_has_entered_invalid_password_address_into_password_field(String invalidPasswordText) {
		
		 loginPage.enterPassword(invalidPasswordText);
		
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("User should get a Warring massage about credential miss match")
	public void user_should_get_a_warring_massage_about_credential_miss_match() {
	    Assert.assertTrue(loginPage.getWaringMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User don't enter email  address  into the email field")
	public void user_don_t_enter_email_address_into_the_email_field() {

	loginPage.enterEmailAddress("");
	}

	@When("User don't enter password address  into password field")
	public void user_don_t_enter_password_address_into_password_field() {
		loginPage.enterPassword("");
	}


	
}