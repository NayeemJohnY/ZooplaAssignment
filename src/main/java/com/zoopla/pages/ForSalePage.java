package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class ForSalePage extends TestBase {

	@FindBy(how = How.TAG_NAME, using = "h1")
	WebElement lblHeading;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'listing_')]//a[contains(@class, 'price')]")
	List<WebElement> listPriceProperites;

	@FindBy(how = How.XPATH, using ="//i[contains(@class,'cancel')]")
	WebElement cancelFilter;
	
	List<Integer> pricelist = new ArrayList<Integer>();
	
	public ForSalePage() {
		
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLocation(String location)

	{
		
		return lblHeading.getText().contains(location);
	}

	public void getAllPropertiesPriceReverse()

	{
		
		for (WebElement propertyPrice : listPriceProperites) {
			if(propertyPrice.getText().replaceAll("[^0-9]", "").isEmpty())
			{
				System.out.println("The One Property has a price="+propertyPrice.getText()+" which is not the actual value, So this property was not added in Pricelist");
			}
			else
			pricelist.add(Integer.parseInt(propertyPrice.getText().replaceAll("[^0-9]", "")));
		}
		System.out.println("List of the Properties Price in decreasing order---->");
		Collections.sort(pricelist, Collections.reverseOrder());
		System.out.println(pricelist);

	}
	
	public PropertyDtlPage getPropertybyPosition(int position)
	{	cancelFilter.click();
		listPriceProperites.get(position).click();
		return new PropertyDtlPage();
	}
}
