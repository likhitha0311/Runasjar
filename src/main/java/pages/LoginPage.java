package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageHelper;

public class LoginPage 
{	
private WebDriver driver;

private DashboardPage dashboardPage;
	
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	this.dashboardPage= new DashboardPage(driver);
	PageFactory.initElements(driver,this);
}

@FindBy(xpath="//input[@name='username']")
private WebElement userNameTextbox;

@FindBy(xpath="//input[@name='pass']")
private WebElement passwordTextbox;

@FindBy(xpath="//button[.='Sign In']")
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

	return this.dashboardPage.isDisplayed();

}




}