package com.zoopla.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(how = How.NAME, using = "q")
	WebElement txtBoxSearch;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement BtnSearch;

	public HomePage() {
		
		PageFactory.initElements(driver, this);

	}

	public ForSalePage searchSaleLocation(String location)
	{
		txtBoxSearch.sendKeys(location);	
		BtnSearch.click();
		
		return new ForSalePage();
	}
}
