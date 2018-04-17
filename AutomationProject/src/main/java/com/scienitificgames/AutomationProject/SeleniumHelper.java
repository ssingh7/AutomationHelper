package com.scienitificgames.AutomationProject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHelper {
	private static WebDriver driver,backupDriver;

	public SeleniumHelper() {
		selectBrowser("chrome");
	}

	public SeleniumHelper(String url) {
		selectBrowser("chrome");
		driver.get(url);
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
