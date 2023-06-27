package util;

import java.util.Random;

import org.testng.TestNG;

public class UtilityClass 
{
	public static  String emailGenerator() 
	{
		
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10000); 
		String email="username"+randomInt+"@gmail.com";
		
		return email;
		
	}

}
