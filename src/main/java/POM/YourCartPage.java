package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage 
{

	@FindBy(xpath="//button[text()='Remove']") private WebElement remove;
	@FindBy(xpath="//button[text()='Continue Shopping']") private WebElement continueShopping;
    @FindBy(xpath="//button[text()='Checkout']") private WebElement checkout;
	
    
    public YourCartPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
public void clickOnRemove()
{
	remove.click();
}

public void clickOnContinueShopping()
{
	continueShopping.click();
}

public void clickOnCheckOut()
{
	checkout.click();
}
	
}
