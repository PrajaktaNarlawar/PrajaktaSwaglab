package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage 
{

	@FindBy(xpath="//button[@id='back-to-products']")private WebElement backToHome;
	
	public CompletePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBackToHome()
	{
		backToHome.click();
	}
}
