package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage 
{

	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCode;
	@FindBy(xpath="//input[@id='continue']") private WebElement Continue;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancel;
	
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String fn)
	{
		firstName.sendKeys(fn);
	}
	
	public void enterLastName(String ln)
	{
		lastName.sendKeys(ln);
	}
	
	public void enterPostalCode(String pc)
	{
		postalCode.sendKeys(pc);
	}
	
	public void clickOnContinue()
	{
		Continue.click();
	}
	
	public void clickOncancel()
	{
		cancel.click();
	}
}
