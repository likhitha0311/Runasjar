package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerClass implements ITestListener


{
	
	public static WebDriver driver;


	    @Override		
	    public void onTestFailure(ITestResult result) {					
	   			
	        	System.out.println("Testcase has been failed"+result.getName());
	        	try {
					takeScreenshot(driver, result);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult result) {					
	    	System.out.println("Testcase has been started"+result.getName());					
	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }	
	    
	    public void takeScreenshot(WebDriver driver,ITestResult result) throws IOException 
	    {
	    	TakesScreenshot tScreenshot = (TakesScreenshot)driver;
	    	File srcFile = tScreenshot.getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(srcFile, new File("./screenshots/"+ result.getName()+"-"+ getCurrentDateandTime()+".jpg"));
	    	
	    	
	    }
	    
	    public String getCurrentDateandTime()
	    {
	    	Date dt = new Date();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");

		    String dateandtime = dateFormat.format(dt);
		    return dateandtime;
			 
	    	
	    }
	    

}
