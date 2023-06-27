package util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageHelper 
{
	
	public static void javascriptClick(WebDriver driver, WebElement element)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static boolean isElementDisplayed(WebDriver driver, WebElement element)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
	}
		
		catch(NoSuchElementException e)
		{
			return false;
		}
}
	public static void sendKeysToElement(WebDriver driver, WebElement element,String text)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.and(ExpectedConditions.attributeToBeNotEmpty(element, "value"),
					
					ExpectedConditions.elementToBeClickable(element)));
			element.clear();
			element.sendKeys(text);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			
	}
		
		catch(Exception e)
		{
			Assert.fail(String.valueOf(e));
		}
	}
	
	public static void scrollToView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	
	 public static boolean radioValueWebelement(String value, WebElement container,  WebDriver driver) 
	 {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    try{
		      wait.until(ExpectedConditions.and(
		           ExpectedConditions.visibilityOf(container)
		      ));
		      List<WebElement> radioList = container.findElements(By.cssSelector("input[type='radio']"));
		      for (WebElement element : radioList) {
		        if (element.getAttribute("value").equals(value)) {

		          wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));

		          js.executeScript("arguments[0].click()", element);

		          wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
		          break;
		        }
		      }
		      return true;
		    }catch(Exception e)
		    {
		      
		      return false;
		    }
	 }
	 
	 public static void selectElementInDropdown(WebDriver driver, WebElement element, String option){
		    String xPath = "//*[text() = '" + option + "']";
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    try{

		      wait.until(ExpectedConditions.elementToBeClickable(element));
		      element.click();
		      List<WebElement> elements = driver.findElements(By.xpath(xPath));
		      WebElement selection = elements.get(elements.size() - 1);
		      wait.until(ExpectedConditions.elementToBeClickable(selection));
		      //it sometimes breaks if you get rid of these sleeps. Goes too fast for itself.
		      Thread.sleep(250);
		      selection.click();
		      Thread.sleep(250);

		      
		      if(!element.getText().equals(option)){
		        
		        throw new Exception();
		      }
		    } catch (Exception e){
		      Assert.fail(String.valueOf(e));
		    }
		  }

		  public static void selectElementWhenDropdownIsOfSelectType(WebDriver driver, WebElement element, String option){
		    Select select = new Select(element);
		    select.selectByVisibleText(option);

		  }
}
