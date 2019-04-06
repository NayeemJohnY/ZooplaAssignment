package com.zoopla.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.zoopla.util.BrowserSelection;
import com.zoopla.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public static WebDriverEventListener eventListener;
	public static EventFiringWebDriver eventfiringdriver;

	public TestBase() {
		log = Logger.getLogger(this.getClass());
		FileInputStream propfile;
		prop = new Properties();
		try {

			propfile = new FileInputStream(".\\src\\main\\java\\com\\zoopla\\config\\config.properties");
			prop.load(propfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void initilization() {
		driver = BrowserSelection.selectBrowser(prop.getProperty("browser"));

		eventfiringdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventfiringdriver.register(eventListener);
		driver = eventfiringdriver;

		driver.get(prop.getProperty("url"));

	}

}
