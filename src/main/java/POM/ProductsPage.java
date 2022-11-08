package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage 
{

	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menuBox;
	@FindBy(xpath="//a[@id='inventory_sidebar_link']") private WebElement allItems;
	@FindBy(xpath="//a[@id='about_sidebar_link']") private WebElement about;
	@FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement logOut;
	@FindBy(xpath="//a[@id='reset_sidebar_link']") private WebElement restAppState;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cart;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement filter;
	@FindBy(xpath="//button[text()='Add to cart']") private List <WebElement> addToCart;
	@FindBy(xpath="//button[text()='Remove']") private List <WebElement> remove;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitter;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebook;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedIn;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenuBox()
	{
		menuBox.click();
	}
	
	public void clickOnAllItems()
	{
		allItems.click();
	}
	
	public void clickOnAbout()
	{
		about.click();
	}
public void clickOnLogOut()
{
	logOut.click();
}
public void clickOnRestAppState()
{
	restAppState.click();
}
public void clickOnCart()
{
	cart.click();
}
public void clickOnFilter(String a)
{
	Select s=new Select(filter);
	s.selectByVisibleText(a);
}
public void clickOnAddToCart(int product)
{
	addToCart.get(product).click();;
}
public void clickOnRemove(int product)
{
	remove.get(product).click();
}
public void clickOnTwitter()
{
	twitter.click();
}
public void clickOnFaceBook()
{
	facebook.click();
}
public void clickOnLinkedIn()
{
	linkedIn.click();
}
public void isRemoveDisplay(int product)
{
	remove.get(product).isDisplayed();
}

public boolean isRemoveButtonDisplay(int product)
{
	return remove.get(product).isDisplayed();
	
}
public void addMultipleProductToCart()
{
	for(int i=addToCart.size()-1;i>=0;i--)
	{
		addToCart.get(i).click();
	}
}
	
	public int getNumberOfRemoveButton()
	{
		return remove.size();
	}
	public int getNumberOfAddToCartButton()
	{
		return addToCart.size();
	}


}





