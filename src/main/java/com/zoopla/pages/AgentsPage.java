package com.zoopla.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class AgentsPage extends TestBase {

	@FindBy(xpath="//div[@id='content']//b")
	WebElement headAgentName;
	
	public AgentsPage() {
	
		PageFactory.initElements(driver, this);
	}

	public String getAgentName()
	{
		return headAgentName.getText();
	}
}
