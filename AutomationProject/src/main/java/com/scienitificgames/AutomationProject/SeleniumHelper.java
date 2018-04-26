package com.scienitificgames.AutomationProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			if (driver == null || driver.toString().contains("null")) {
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
			System.out.println(driver.getPageSource());
			File f = new File("E:\\BigBasketPageSource.txt");
			FileWriter fw;
			try {
				fw = new FileWriter(f);
				BufferedWriter br = new BufferedWriter(fw);
				br.write(driver.getPageSource());
				br.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
			getWebElement(locatorType, locatorValue).sendKeys(sendKeysValue);
			return "Entered Text Successfully";
		} catch (Exception e) {
			driver = backupDriver;
			return "Unable to Enter Text";
		}
	}

	public String selectOperation(String locatorType, String locatorValue, String selectOptionValue) {
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

	public String highlight(String locatorType, String locatorValue) {
		backupDriver = driver;
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", getWebElement(locatorType, locatorValue));
			return "Highlighted Successfully";
		} catch (Exception e) {
			driver = backupDriver;
			return "Unable to identify element";
		}
	}

	public void close() {
		driver.quit();
		
	}
	
	public void perfromMultipleSteps(List<String> steps) {
		for(String step: steps) {
			String[] a = step.split(":");
			if(a[0].equals("sameer")) {
				
			}
			switch(a[0]) {
			case "clickOperation":
				click(a[1], a[2]);
				break;
			case "sendKeys":
				sendKeys(a[1], a[2],a[3]);
				break;
			case "selectOperation":
				selectOperation(a[1], a[2],a[3]);
				break;
			case "wait":
				wait(a[1]);
				break;
			}
		}
	}

}
