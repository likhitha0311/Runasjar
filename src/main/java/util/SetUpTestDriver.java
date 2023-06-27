package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpTestDriver 
{
private String  browser;
private String os;
private String url;
private WebDriver driver;

public SetUpTestDriver(WebDriver driver,String url,String  browser,String os)
{
	this.browser=browser;
	this.os=os;
	this.url=url;
	this.driver=driver;
	setUpLocalDriver();
}

private void setUpLocalDriver() 
{
if(browser.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-notifications");
	options.addArguments("--incognito");
	driver=new ChromeDriver(options);
	//driver.get(url);
	driver.manage().window().maximize();
}

else if (browser.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	
     FirefoxOptions options= new FirefoxOptions();
	options.addArguments("--disable-notifications");
	options.addArguments("--incognito");
	driver=new FirefoxDriver(options);
	driver.get(url);
	driver.manage().window().maximize();
}
}

public WebDriver getDriver()
{
	return this.driver;
}

}
