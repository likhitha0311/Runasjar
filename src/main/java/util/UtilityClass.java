package util;

import java.util.Random;

import org.testng.TestNG;

public class UtilityClass 
{
	public static  String emailGenerator() 
	{
		
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000000);
		String email="username"+randomInt+"@gmail.com";
		
		return email;
		
	}

	public static  String companyNameGenerator()
	{

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000000);
		String company="Company-"+randomInt;

		return company;

	}

	public static  String opportunityNameGenerator()
	{

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000000);
		String opportunity="Opportunity-"+randomInt;

		return opportunity;

	}

}