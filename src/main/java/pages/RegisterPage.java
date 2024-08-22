package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	@FindBy(id = "input-lastname")
	private WebElement lastNameFieldE;
	@FindBy(id = "input-email")
	private WebElement emailField;
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	@FindBy(id = "input-password")
	private WebElement passwordFiel;
	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuButton;
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement selectNewsletter;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessag;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWaring;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWaring;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailFieldWaring;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement phoneFielsWaring;
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordFieldWaring;
	
	public void enterFirstNameField(String firstNameText) {
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_TIME);
		
		
	}
	
	public void enterLastNameField(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameFieldE, lastNameText, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterEmailField(String email) {
	elementUtils.typeTextIntoElement(emailField, email, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterTelephoneField(String number) {
		elementUtils.typeTextIntoElement(telephoneField, number, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterPasswordField(String password) {
		elementUtils.typeTextIntoElement(passwordFiel, password, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterConfirmPassword(String password) {
	 elementUtils.typeTextIntoElement(confirmPassword, password, CommonUtils.EXPLICIT_WAIT_TIME);

	}
	
	public void privecyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public AccountSuccessPage clickOnContinuButton() {
		elementUtils.clickOnElement(continuButton, CommonUtils.EXPLICIT_WAIT_TIME);
		
		return new AccountSuccessPage(driver);
	}
	
	public void clickOnSelectBox() {
		elementUtils.clickOnElement(selectNewsletter, CommonUtils.EXPLICIT_WAIT_TIME);
	
	}
	public String getWaringMessage() {
		return elementUtils.getTextFromElement(warningMessag, CommonUtils.EXPLICIT_WAIT_TIME);
	      
		}
	public String getFiestNameWaringMessage() {
		return elementUtils.getTextFromElement(firstNameWaring, CommonUtils.EXPLICIT_WAIT_TIME);
	
	}
	
	
	public String getLastNameWaringMessage() {
	return elementUtils.getTextFromElement(lastNameWaring, CommonUtils.EXPLICIT_WAIT_TIME);
		
		}
	public String getEmailFieldWaringMessage() {
	return	elementUtils.getTextFromElement(emailFieldWaring, CommonUtils.EXPLICIT_WAIT_TIME);
		
		}
	
	public String getTelephoneWaringMessage() {
		return elementUtils.getTextFromElement(phoneFielsWaring,CommonUtils.EXPLICIT_WAIT_TIME );
		
		}
	public String getPasswordFieldMessage() {
		return elementUtils.getTextFromElement(passwordFieldWaring, CommonUtils.EXPLICIT_WAIT_TIME);
		
		}
}
