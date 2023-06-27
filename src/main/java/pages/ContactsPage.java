package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.UtilityClass;

public class ContactsPage 
{

	private WebDriver driver;
	
	private static final Map<String, String> contactData = new HashMap<>();
	
	public ContactsPage( WebDriver driver) 
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="")
//	private WebElement ;
//	
//	@FindBy(xpath="")
//	private WebElement ;
//	
//	@FindBy(xpath="")
//	private WebElement ;
//	
//	@FindBy(xpath="")
//	private WebElement ;
//	
//	@FindBy(xpath="")
//	private WebElement ;
//	
//	@FindBy(xpath="")
//	private WebElement ;
//	
//	@FindBy(xpath="")
//	private WebElement ;
	
	private void generateTestData() 
	{
		contactData.put("Name", "Ajay");
		contactData.put("Email", UtilityClass.emailGenerator());
		contactData.put("PhoneNumber", "897737377");
		contactData.put("Address", "4821 Ridge Top Cir");
		contactData.put("Country", "India");
		contactData.put("ZipCode", "575005");
	}
	
	
	
	
	
}
