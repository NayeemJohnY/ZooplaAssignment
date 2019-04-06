package com.zoopla.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.base.TestBase;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDtlPage;

public class PropertyDtilPageTest extends TestBase{

	HomePage homepage;
	ForSalePage forSalePage;
	PropertyDtlPage propertyDtlPage;
	
	@BeforeMethod
	public void setupPropertyPage()
	{
		initilization();
		homepage= new HomePage();
		forSalePage=homepage.searchSaleLocation(prop.getProperty("location"));
		propertyDtlPage=forSalePage.getPropertybyPosition(Integer.parseInt(prop.getProperty("position")));
	}
	
	@Test
	public void getAgentdetailsTest()
	{
		propertyDtlPage.getAgentdetails();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
