package com.zoopla.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class PropertyDtlPage extends TestBase{
	
	@FindBy(xpath="//h4[contains(@class, 'name')]")
	WebElement lblAgentName;
	
	@FindBy(xpath="//address[contains(@class, 'address')]")
	WebElement lblAgentAddress;
	
	@FindBy(xpath="//div[contains(@class,'logo')]/img")
	WebElement imgLogoText;
	
	@FindBy(xpath="//span[text()='Call ']//ancestor::a")
	WebElement lblPhoneNo;
	
	
	public String AgentName;
	public PropertyDtlPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	public void getAgentdetails()
	{
		System.out.println("Agent Details:");	
		System.out.println("Name="+lblAgentName.getText());
		System.out.println("Address="+lblAgentAddress.getAttribute("innerHTML"));
		System.out.println("Logo Text="+imgLogoText.getAttribute("alt"));
		System.out.println("Phone Number="+lblPhoneNo.getAttribute("href").replaceAll("tel:" , ""));
	}
	
	public AgentsPage clickonAgentName()
	{ 	AgentName=lblAgentName.getText();
		lblAgentName.click();
		return new AgentsPage();
	}

}
