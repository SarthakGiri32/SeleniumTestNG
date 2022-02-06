package co.wipro.selenium.automation.flows;

import org.testng.annotations.Test;

import co.wipro.selenium.automation.resources.Variables;

/**
 * Class for executing the Prepaid NSO Flow
 * @author Sarthak Giri
 *
 */
public class PrepaidNSO extends VerizonLocalAutoFunctions {

	/**
	 * This is the Main Method used to execute the flow steps
	 * @throws InterruptedException
	 */
	@Test
	public static void mainMethod() throws InterruptedException {
		
		loadUrl(Variables.VERIZON_WEBSITE, Variables.CHROME_DRIVER);
		clickElementJSExecutor("id", Variables.VERIZON_SHOP, Variables.WAIT_TIME, false);
		clickElementJSExecutor("id", Variables.VERIZON_PREPAID_MENU, Variables.WAIT_TIME, false);
		clickElementJSExecutor("linkText", Variables.VERIZON_PREPAID_OVERVIEW, Variables.WAIT_TIME, true);
		clickElementWhenVisible("linkText", Variables.VERIZON_BYOD, Variables.WAIT_TIME, true);
		clickElementWhenVisible("linkText", Variables.VERIZON_JOIN, Variables.WAIT_TIME, true);
		clickElementJSExecutor("xpath", Variables.VERIZON_SMARTPHONE_DEVICE, Variables.WAIT_TIME, false);
		clickElementJSExecutor("xpath", Variables.VERIZON_CONTINUE_BUTTON, Variables.WAIT_TIME, false);
		clickElementJSExecutor("linkText", Variables.VERIZON_I_DONT_KNOW, Variables.WAIT_TIME, false);
		sendingKey("id", Variables.VERIZON_IMEI_NUMBER_FIELD, Variables.IMEI_NUMBER, Variables.WAIT_TIME, true);
		clickElementJSExecutor("xpath", Variables.VERIZON_CHECK_MY_DEVICE, Variables.WAIT_TIME, true);
		clickElementWhenVisible("xpath", Variables.VERIZON_ADD_SIM, Variables.WAIT_TIME, true);
		sendingKey("name", Variables.VERIZON_ZIP_CODE_FIELD, Variables.ZIP_CODE_1, Variables.WAIT_TIME, true);
		clickElementJSExecutor("xpath", Variables.VERIZON_REMEMBER_MY_LOCATION, Variables.WAIT_TIME, true);
		clickElementJSExecutor("xpath", Variables.VERIZON_CONFIRM_LOCATION, Variables.WAIT_TIME, true);
		clickElementWhenVisible("cssSelector", Variables.VERIZON_LINE_PLAN, Variables.WAIT_TIME, false);
		clickElementWhenVisible("id", Variables.VERIZON_SELECT_PLAN, Variables.WAIT_TIME, true);
		clickElementWhenVisible("xpath", Variables.VERIZON_DECLINE_INTERNATIONAL_PLAN, Variables.WAIT_TIME, false);

	}

}
