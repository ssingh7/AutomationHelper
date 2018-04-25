package com.scienitificgames.AutomationProject;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public class SeleniumHelper {
	private static WebDriver driver, backupDriver;

	public SeleniumHelper() {
		selectBrowser("chrome");
	}

	public SeleniumHelper(String url) {
		selectBrowser("chrome");
		driver.get(url);
	}

	public SeleniumHelper(String appPackage, String appActivity) {
		setMobileDriver(appPackage, appActivity);
	}

	public void selectBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "BrowserDriver/chromedriver.exe");
			if (driver == null) {
				driver = new ChromeDriver();
			}
			System.out.println(driver);
			break;
		case "Android":
			break;
		}
	}

	public void setMobileDriver(String appPackage, String appActivity) {
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

	public String click(String locatorType, String locatorValue) {
		backupDriver = driver;
		try {
			getWebElement(locatorType, locatorValue).click();
			return "Clicked Successfully";
		} catch (Exception e) {
			driver = backupDriver;
			return "Unable to Click";
		}

	}

	public String sendKeys(String locatorType, String locatorValue, String sendKeysValue) {
		backupDriver = driver;
		try {
			getWebElement(locatorType, locatorValue).click();
			return "Entered Text Successfully";
		} catch (Exception e) {
			driver = backupDriver;
			return "Unable to Enter Text";
		}
	}

	public String selectOperaton(String locatorType, String locatorValue, String selectOptionValue) {
		backupDriver = driver;
		try {
			Select select = new Select(getWebElement(locatorType, locatorValue));
			select.selectByVisibleText(selectOptionValue);
			return "Option Selected Successfully";
		} catch (Exception e) {
			driver = backupDriver;
			return "Unable to select given option";
		}
	}

	public String wait(String waitValue) {
		backupDriver = driver;
		try {
			return "Clicked Successfully";
		} catch (Exception e) {
			driver = backupDriver;
			return "Unable to Click";
		}
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "linkText":
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		return element;

	}

}
