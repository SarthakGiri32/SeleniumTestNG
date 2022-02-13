package co.wipro.selenium.automation.flows;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.wipro.selenium.automation.resources.Variables;

/**
 * Class containing common functions for the Automation Flows
 * @author Sarthak Giri
 *
 */
public class LocalAutoFunctions extends Variables {

	public static WebDriver driver = null;
	
	/**
	 * Function for starting the web driver and loading an URL
	 * @param url
	 * @param ld
	 */
	public static void loadUrl(String url, String ld) {
		try {
			System.setProperty("webdriver.chrome.driver", ld);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
		} catch (IllegalStateException e) {
			throw new IllegalStateException("ERROR: couldn't connect to driver");
		}
		
		try {
			driver.get(url);
			System.out.println("Website \"" + url + "\" loaded...");
		} catch (WebDriverException e) {
			throw new WebDriverException("ERROR: URL not resolved");
		}
	}
	
	/**
	 * Function for selecting a web element based on a particular selector and locator value
	 * @param selector
	 * @param text
	 * @param duration
	 * @throws InterruptedException 
	 */
	public static void clickElement(String selector, String text, int duration, boolean pageLoadDelay) throws InterruptedException {
		By by = null;
		switch(selector) {
		case "id":
			by = By.id(text);
			break;
		case "name":
			by = By.name(text);
			break;
		case "className":
			by = By.className(text);
			break;
		case "cssSelector":
			by = By.cssSelector(text);
			break;
		case "linkText":
			by = By.linkText(text);
			break;
		case "partialLinkText":
			by = By.partialLinkText(text);
			break;
		case "tagName":
			by = By.tagName(text);
			break;
		case "xpath":
			by = By.xpath(text);
		}
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.click();
			System.out.println("Button \"" + text + "\" clicked...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: Button \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element based on a particular selector and locator value,
	 * using Javascript Executor
	 * @param selector
	 * @param text
	 * @param duration
	 * @param pageLoadDelay 
	 * @throws InterruptedException 
	 */
	public static void clickElementJSExecutor(String selector, String text, int duration, boolean pageLoadDelay) throws InterruptedException {
		By by = null;
		switch(selector) {
		case "id":
			by = By.id(text);
			break;
		case "name":
			by = By.name(text);
			break;
		case "className":
			by = By.className(text);
			break;
		case "cssSelector":
			by = By.cssSelector(text);
			break;
		case "linkText":
			by = By.linkText(text);
			break;
		case "partialLinkText":
			by = By.partialLinkText(text);
			break;
		case "tagName":
			by = By.tagName(text);
			break;
		case "xpath":
			by = By.xpath(text);
		}
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			System.out.println("Button \"" + text + "\" clicked...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: Button \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element based on a particular selector and locator value,
	 * after that element is visible on page
	 * @param selector
	 * @param text
	 * @param duration
	 * @param pageLoadDelay 
	 * @throws InterruptedException 
	 */
	public static void clickElementWhenVisible(String selector, String text, int duration, boolean pageLoadDelay) throws InterruptedException {
		By by = null;
		switch(selector) {
		case "id":
			by = By.id(text);
			break;
		case "name":
			by = By.name(text);
			break;
		case "className":
			by = By.className(text);
			break;
		case "cssSelector":
			by = By.cssSelector(text);
			break;
		case "linkText":
			by = By.linkText(text);
			break;
		case "partialLinkText":
			by = By.partialLinkText(text);
			break;
		case "tagName":
			by = By.tagName(text);
			break;
		case "xpath":
			by = By.xpath(text);
		}
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			System.out.println("Button \"" + text + "\" clicked...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: Button \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element from a list of web elements having the same class name
	 * @param text
	 * @param n
	 * @param duration
	 * @param pageLoadDelay 
	 * @throws InterruptedException 
	 */
	public static void clickElement(String text, int n, int duration, boolean pageLoadDelay) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(text)));
			List<WebElement> listOfElements = driver.findElements(By.className(text));
			element = listOfElements.get(n);
			element.click();
			System.out.println("Button order " + n + " of class \"" + text + "\" clicked...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: Button order " + n + " of class \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element from a list of web elements having the same class name,
	 * using Javascript Executor
	 * @param text
	 * @param n
	 * @param duration
	 * @param pageLoadDelay 
	 * @throws InterruptedException 
	 */
	public static void clickElementJSExecutor(String text, int n, int duration, boolean pageLoadDelay) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(text)));
			List<WebElement> listOfElements = driver.findElements(By.className(text));
			element = listOfElements.get(n);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			System.out.println("Button order " + n + " of class \"" + text + "\" clicked...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: Button order " + n + " of class \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element from a list of web elements having the same class name,
	 * after that element is visible on page
	 * @param text
	 * @param n
	 * @param duration
	 * @param pageLoadDelay 
	 * @throws InterruptedException 
	 */
	public static void clickElementWhenVisible(String text, int n, int duration, boolean pageLoadDelay) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(text)));
			List<WebElement> listOfElements = driver.findElements(By.className(text));
			element = listOfElements.get(n);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			System.out.println("Button order " + n + " of class \"" + text + "\" clicked...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: Button order " + n + " of class \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for sending a string value to an input field
	 * @param selector
	 * @param text
	 * @param keyValue
	 * @param duration
	 * @param pageLoadDelay 
	 * @throws InterruptedException 
	 */
	public static void sendingKey(String selector, String text, String keyValue, int duration, boolean pageLoadDelay) throws InterruptedException {
		By by = null;
		switch(selector) {
		case "id":
			by = By.id(text);
			break;
		case "name":
			by = By.name(text);
			break;
		case "className":
			by = By.className(text);
			break;
		case "cssSelector":
			by = By.cssSelector(text);
			break;
		case "linkText":
			by = By.linkText(text);
			break;
		case "partialLinkText":
			by = By.partialLinkText(text);
			break;
		case "tagName":
			by = By.tagName(text);
			break;
		case "xpath":
			by = By.xpath(text);
		}
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.sendKeys(keyValue);
			System.out.println("sending \"" + keyValue + "\" key to \"" + text + "\" field...");
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			throw new TimeoutException("ERROR: field \"" + text + "\" took too long to load");
		}
	}
}
