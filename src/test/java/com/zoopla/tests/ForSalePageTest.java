package com.zoopla.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.base.TestBase;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDtlPage;

public class ForSalePageTest extends TestBase{
	
	HomePage homepage;
	ForSalePage forSalePage;
	PropertyDtlPage propertyDtlPage;
	

	@BeforeMethod
	public void setupForSalePage()
	{
		initilization();
		homepage= new HomePage();
		forSalePage=homepage.searchSaleLocation(prop.getProperty("location"));
	}
	@Test
	public void getAllPropertiesPriceReverseTest()
	{
		forSalePage.getAllPropertiesPriceReverse();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
