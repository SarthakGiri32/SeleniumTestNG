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
import org.testng.Reporter;

import co.wipro.selenium.automation.resources.ReadConfigFile;

/**
 * Class containing common functions for the Automation Flows
 * @author Sarthak Giri
 *
 */
public class LocalAutoFunctions extends ReadConfigFile {

	public static WebDriver driver = null;
	
	/**
	 * Function for starting the web driver and loading a URL
	 * @param url - Website URL
	 * @param ld - Local Web driver Path
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
//			System.out.println("Website \"" + url + "\" loaded...");
			Reporter.log("Website load: \"" + url + "\"... SUCCESSFUL!", true);
		} catch (WebDriverException e) {
			Reporter.log("Website load: \"" + url + "\"... FAILED!", true);
			throw new WebDriverException("ERROR: URL not resolved");
		}
	}
	
	/**
	 * Function for selecting a web element based on a particular selector and locator value
	 * @param selector - element attribute type
	 * @param text - element attribute value
	 * @param duration - Web Driver Wait Duration
	 * @param stepName - name of the step
	 * @param pageLoadDelay - the delay for page loading
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void clickElement(String selector, String text, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
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
//			System.out.println("Button \"" + text + "\" clicked...");
			Reporter.log("Button click: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Button click: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: Button \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element based on a particular selector and locator value,
	 * using Javascript Executor
	 * @param selector - element attribute type
	 * @param text - element attribute value
	 * @param duration - Web Driver Wait Duration
	 * @param stepName - name of the step
	 * @param pageLoadDelay - the delay for page loading
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void clickElementJSExecutor(String selector, String text, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
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
//			System.out.println("Button \"" + text + "\" clicked...");
			Reporter.log("Button click: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Button click: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: Button \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element based on a particular selector and locator value,
	 * after that element is visible on page
	 * @param selector - element attribute type
	 * @param text - element attribute value
	 * @param duration - Web Driver Wait Duration
	 * @param stepName - name of the step
	 * @param pageLoadDelay - the delay for page loading
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void clickElementWhenVisible(String selector, String text, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
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
//			System.out.println("Button \"" + text + "\" clicked...");
			Reporter.log("Button click: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Button click: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: Button \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element from a list of web elements having the same class name
	 * @param text - classname value
	 * @param n - specific element in the list of elements
	 * @param duration - Web Driver Wait Duration
	 * @param pageLoadDelay - the delay for page loading
	 * @param stepName - the name of the step
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void clickElement(String text, int n, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(text)));
			List<WebElement> listOfElements = driver.findElements(By.className(text));
			element = listOfElements.get(n);
			element.click();
//			System.out.println("Button order " + n + " of class \"" + text + "\" clicked...");
			Reporter.log("Button click: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Button click: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: Button order " + n + " of class \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element from a list of web elements having the same class name,
	 * using Javascript Executor
	 * @param text - classname value
	 * @param n - specific element in the list of elements
	 * @param duration - Web Driver Wait Duration
	 * @param pageLoadDelay - the delay for page loading
	 * @param stepName - the name of the step
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void clickElementJSExecutor(String text, int n, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(text)));
			List<WebElement> listOfElements = driver.findElements(By.className(text));
			element = listOfElements.get(n);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//			System.out.println("Button order " + n + " of class \"" + text + "\" clicked...");
			Reporter.log("Button click: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Button click: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: Button order " + n + " of class \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for selecting a web element from a list of web elements having the same class name,
	 * after that element is visible on page
	 * @param text - classname value
	 * @param n - specific element in the list of elements
	 * @param duration - Web Driver Wait Duration
	 * @param pageLoadDelay - the delay for page loading
	 * @param stepName - the name of the step
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void clickElementWhenVisible(String text, int n, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(text)));
			List<WebElement> listOfElements = driver.findElements(By.className(text));
			element = listOfElements.get(n);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//			System.out.println("Button order " + n + " of class \"" + text + "\" clicked...");
			Reporter.log("Button click: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Button click: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: Button order " + n + " of class \"" + text + "\" took too long to load");
		}
	}
	
	/**
	 * Function for sending a string value to an input field
	 * @param selector - element attribute type
	 * @param text - element attribute value
	 * @param keyValue - the value to be sent to the field
	 * @param duration - Web Driver Wait Duration
	 * @param pageLoadDelay - the delay for page loading
	 * @param stepName - the name of the step
	 * @throws InterruptedException - Exception for 'Thread.sleep()'
	 */
	public static void sendingKey(String selector, String text, String keyValue, int duration, boolean pageLoadDelay, String stepName) throws InterruptedException {
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
//			System.out.println("sending \"" + keyValue + "\" key to \"" + text + "\" field...");
			Reporter.log("Sending Key to: \"" + stepName + "\"... SUCCESSFUL!", true);
			if (pageLoadDelay) {
				Thread.sleep(PAGE_LOAD_DELAY);
			}
		} catch (TimeoutException e) {
			Reporter.log("Sending Key to: \"" + stepName + "\"... FAILED!", true);
			throw new TimeoutException("ERROR: field \"" + text + "\" took too long to load");
		}
	}
}
