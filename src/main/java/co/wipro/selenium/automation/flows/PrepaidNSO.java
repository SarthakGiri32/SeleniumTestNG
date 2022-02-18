package co.wipro.selenium.automation.flows;

import java.io.IOException;
import java.util.Date;

import org.json.simple.parser.ParseException;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Class for executing the Prepaid NSO Flow
 * @author Sarthak Giri
 *
 */
public class PrepaidNSO extends LocalAutoFunctions {

	/**
	 * This is the Main Method used to execute the flow steps
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@Test
	public static void mainMethod() throws InterruptedException, IOException, ParseException {
		
		setVariables();
		String currentDate = new Date().toString();
		//System.out.println("Current Date and Time: " + currentDate);
		
		loadUrl(VERIZON_WEBSITE, CHROME_DRIVER);
		
		Reporter.log("Flow Start Date and Time: " + currentDate);
		clickElementJSExecutor("id", VERIZON_SHOP, WAIT_TIME, false);
		clickElementJSExecutor("id", VERIZON_PREPAID_MENU, WAIT_TIME, false);
		clickElementJSExecutor("linkText", VERIZON_PREPAID_OVERVIEW, WAIT_TIME, true);
		clickElementWhenVisible("linkText", VERIZON_BYOD, WAIT_TIME, true);
		clickElementWhenVisible("linkText", VERIZON_JOIN, WAIT_TIME, true);
		clickElementJSExecutor("xpath", VERIZON_SMARTPHONE_DEVICE, WAIT_TIME, false);
		clickElementJSExecutor("xpath", VERIZON_CONTINUE_BUTTON, WAIT_TIME, false);
		clickElementJSExecutor("linkText", VERIZON_I_DONT_KNOW, WAIT_TIME, false);
		sendingKey("id", VERIZON_IMEI_NUMBER_FIELD, IMEI_NUMBER, WAIT_TIME, true);
		clickElementJSExecutor("xpath", VERIZON_CHECK_MY_DEVICE, WAIT_TIME, true);
		clickElementWhenVisible("xpath", VERIZON_ADD_SIM, WAIT_TIME, true);
		sendingKey("name", VERIZON_ZIP_CODE_FIELD, ZIP_CODE_1, WAIT_TIME, true);
		clickElementJSExecutor("xpath", VERIZON_REMEMBER_MY_LOCATION, WAIT_TIME, true);
		clickElementJSExecutor("xpath", VERIZON_CONFIRM_LOCATION, WAIT_TIME, true);
		clickElementWhenVisible("cssSelector", VERIZON_LINE_PLAN, WAIT_TIME, false);
		clickElementWhenVisible("id", VERIZON_SELECT_PLAN, WAIT_TIME, true);
		clickElementWhenVisible("xpath", VERIZON_DECLINE_INTERNATIONAL_PLAN, WAIT_TIME, false);

	}

}
