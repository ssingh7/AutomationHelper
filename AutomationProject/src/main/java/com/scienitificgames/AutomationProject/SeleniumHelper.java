package com.scienitificgames.AutomationProject;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SeleniumHelper {
	private static WebDriver driver,backupDriver;

	public SeleniumHelper() {
		selectBrowser("chrome");
	}

	public SeleniumHelper(String url) {
		selectBrowser("chrome");
		driver.get(url);
	}
	
	public SeleniumHelper(String appPackage, String appActivity) {
		setMobileDriver(appPackage,appActivity);
	}

	public void selectBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "BrowserDriver/chromedriver.exe");
			if(driver==null) {
				driver = new ChromeDriver();
			}		
			break;
		case "Android":
			break;
		}
	}
	
	public void setMobileDriver(String appPackage, String appActivity ) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus 5X");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("newCommandTimeout", 3600);
		
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public String click(String locatorType,String locatorValue) {
		backupDriver = driver;
		try {
			switch(locatorType){
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).click();;break;
			case "id":
				driver.findElement(By.id(locatorValue)).click();;break;
			case "name":
				driver.findElement(By.name(locatorValue)).click();;break;
			case "linkText":
				driver.findElement(By.partialLinkText(locatorValue)).click();;break;
			}
			return "Clicked Successfully";
		}catch(Exception e) {
			driver = backupDriver;
			return "Unable to Click";
		}

	}

}
