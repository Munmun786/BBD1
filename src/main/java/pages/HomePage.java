package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
 WebDriver driver;
 private  ElementUtils elementUtils;
 
 public HomePage(WebDriver driver) {
	 
	 this.driver= driver;
	 PageFactory.initElements(driver, this);
	         
	  elementUtils = new ElementUtils(driver);
 }
	
 @FindBy(xpath = "//span[text()='My Account']")
 private WebElement myAccoutDropMenu;
 
 @FindBy(xpath = "//a[normalize-space()='Login']")
 private WebElement loginOption;
 
 @FindBy(xpath = "//a[normalize-space()='Register']")
private WebElement registerOption; 
 
 @FindBy(name = "search")
 private WebElement searchBoxField;
 
 @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
 private WebElement searchButton;
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccoutDropMenu, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage clickOnLoginOption() {
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_TIME);
		
		return new LoginPage(driver);
	}
	public RegisterPage registerOption() {
        elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_TIME);
	return new RegisterPage(driver);
	
	}
	
	public void enterProductIntoSearchBox(String validProduct) {
		elementUtils.typeTextIntoElement(searchBoxField, validProduct, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterInvalidProduct(String invalidProductText) {
		elementUtils.typeTextIntoElement(searchBoxField, invalidProductText, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_TIME);
	
	}
	

}

