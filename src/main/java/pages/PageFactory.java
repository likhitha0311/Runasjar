package pages;

import org.openqa.selenium.WebDriver;

import util.ListenerClass;

public class PageFactory

{

	private WebDriver driver;
	public PageFactory(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLoginPage()
	{
		return new LoginPage(this.driver);
	}
//
//	public ListenerClass getListenerClass() {
//		
//		return new ListenerClass(this.driver);
//	}
//	
	
	
}
