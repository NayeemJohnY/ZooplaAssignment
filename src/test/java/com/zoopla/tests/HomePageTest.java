package com.zoopla.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.base.TestBase;
import com.zoopla.pages.ForSalePage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.PropertyDtlPage;

public class HomePageTest extends TestBase {

	HomePage homepage;
	ForSalePage forSalePage;

	@BeforeMethod
	public void setupHomePage() {
		initilization();
	}

	@Test
	public void verifyhomePageTitleTest() {
		Assert.assertEquals(driver.getTitle(), prop.getProperty("expectedTitle"));

	}

	@Test
	public void verifyForSalePageLocationTest() {
		homepage = new HomePage();
		forSalePage = homepage.searchSaleLocation(prop.getProperty("location"));
		Assert.assertTrue(forSalePage.verifyLocation(prop.getProperty("location")));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
