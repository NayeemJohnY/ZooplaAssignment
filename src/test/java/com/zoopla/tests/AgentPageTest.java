package com.zoopla.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.base.TestBase;
import com.zoopla.pages.AgentsPage;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDtlPage;

public class AgentPageTest extends TestBase{

	
	HomePage homepage;
	ForSalePage forSalePage;
	PropertyDtlPage propertyDtlPage;
	AgentsPage agentsPage;
	
	@BeforeMethod
	public void setupAgentPage()
	{
		initilization();
		homepage= new HomePage();
		forSalePage=homepage.searchSaleLocation(prop.getProperty("location"));
		propertyDtlPage=forSalePage.getPropertybyPosition(Integer.parseInt(prop.getProperty("position")));
	}

	
	@Test
	public void verifyAgentNameTest()
	{	 agentsPage = propertyDtlPage.clickonAgentName();
		Assert.assertTrue(agentsPage.getAgentName().contains(propertyDtlPage.AgentName));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
