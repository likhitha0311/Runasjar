package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PageHelper;

public class LoginPage 
{	
private WebDriver driver;
	
public LoginPage(WebDriver driver)
{
	this.driver=driver;
}

@FindBy(xpath="")
private WebElement userNameTextbox;

@FindBy(xpath="")
private WebElement passwordTextbox;

@FindBy(xpath="")
private WebElement submitButton;


public void setUsername(String uname)
{

	PageHelper.sendKeysToElement(driver, userNameTextbox, uname);
}

public void setPassword(String password)
{
	PageHelper.sendKeysToElement(driver, passwordTextbox, password);
}

public void clickLogin()
{
	PageHelper.javascriptClick(driver, submitButton);
}

public void loginToApplication(String uname, String password, String loginUrl)
{
	this.driver.get(loginUrl);
	PageHelper.isElementDisplayed(driver,userNameTextbox);
	setUsername(uname);
	PageHelper.isElementDisplayed(driver, passwordTextbox);
	setPassword(password);
	clickLogin();
	
}

public boolean isLoggedIn()
{
	//return this.dashboardpage.isDiplayed();
	return true;
}




}
