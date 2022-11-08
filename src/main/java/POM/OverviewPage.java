package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage 
{

	
@FindBy(xpath="//div[@class='inventory_item_name']") private WebElement cartItem;
@FindBy(xpath="//button[@id='finish']") private WebElement finish;
@FindBy(xpath="//button[@id='cancel']") private WebElement cancel;


public OverviewPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void clickOnCartItem()
{
	cartItem.click();
}

public void clickOnFinish()
{
    finish.click();
}

public void clickOnCancel()
{
	cancel.click();
}

}
