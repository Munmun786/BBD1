package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noMatchingWaring;
	
	
	public boolean GetProduct() {
		return elementUtils.displayStatusOfElement(validProduct, CommonUtils.EXPLICIT_WAIT_TIME);
		
		
	}
	
	public String getNoMatchingWaringMessage() {
		return elementUtils.getTextFromElement(noMatchingWaring, CommonUtils.EXPLICIT_WAIT_TIME);
		 
	}
	
}
