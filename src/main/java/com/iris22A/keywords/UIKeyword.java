package com.iris22A.keywords;

import java.awt.AWTException;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author radhi
 *
 */
public class UIKeyword {
	
	public static RemoteWebDriver driver;
	private static final Logger log = Logger.getLogger(UIKeyword.class);
	
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-notifications","start-maximized","incognito");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		log.info(browserName+" browser has launched successfully..!");

	}
	
	public static void launchUrl(String url) {
		driver.get(url);
		log.info("Url is launched!"+url);
	}
	
	public static void closeBrowser() {
		driver.close();
		log.info("Browser is closed successfully!");
	}
	
	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		while (!title.equalsIgnoreCase(byTitle)) {
			for (String window : windows) {
				if (driver.switchTo().window(window).getTitle().equals(byTitle)) {
					log.info("Switched on window: "+byTitle);
					
					break;
				}
			}
		}
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}
	
	public static void hitButton(int keyCode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			log.error("Unable to initaite robot class instance");
		}
		robo.keyPress(keyCode);
		robo.keyRelease(keyCode);
		
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());
		}
		return texts;
	}

	public static void mouseMove(By xpath) {
		Actions act = new Actions(driver); 
		act.moveToElement(driver.findElement(xpath)).build().perform();
	}

	public static void click(By xpath) {
		driver.findElement(xpath).click();
	}
	
	public static void click(String locatorType , String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void mouseMove(String locatorType, String locatorValue) {
		Actions act = new Actions(UIKeyword.driver);
		act.moveToElement(getWebElement(locatorType, locatorValue)).perform();
		
	}
	
	public static WebElement getWebElement(String locatorType , String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}else if (locatorType.equalsIgnoreCase("id")) {
			element =driver.findElement(By.id(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("css")) {
			element =driver.findElement(By.cssSelector(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("linkText")) {
			element =driver.findElement(By.linkText(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element =driver.findElement(By.partialLinkText(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("class")) {
			element =driver.findElement(By.className(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("tagName")) {
			element =driver.findElement(By.tagName(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("name")) {
			element =driver.findElement(By.name(locatorValue)); 
		}else {
			log.error("Invalid locator type: "+locatorType);
		}
		return element;
	}

	public static List<WebElement> getWebElements(String locatorType , String locatorValue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatorValue));
		}else if (locatorType.equalsIgnoreCase("id")) {
			elements =driver.findElements(By.id(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("css")) {
			elements =driver.findElements(By.cssSelector(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("linkText")) {
			elements =driver.findElements(By.linkText(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			elements =driver.findElements(By.partialLinkText(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("class")) {
			elements =driver.findElements(By.className(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("tagName")) {
			elements =driver.findElements(By.tagName(locatorValue)); 
		}else if (locatorType.equalsIgnoreCase("name")) {
			elements =driver.findElements(By.name(locatorValue)); 
		}else {
			log.error("Invalid locator type: "+locatorType);
		}
		return elements;
	}
	public static List<String> getTexts(String locatorType , String locatorValue) {
		List<WebElement> elements = getWebElements(locatorType, locatorValue);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt : elements) {
			texts.add(elmnt.getText());
		}
		return texts;
	}
	
	public static List<String> enterTexts(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
		return null;
	}

	public static void mouseMove(WebElement element) {
		Actions act = new Actions(UIKeyword.driver);
		act.moveToElement(element).perform();
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void enterText(WebElement element, String productName) {
		element.sendKeys(productName);
	}
	

}
