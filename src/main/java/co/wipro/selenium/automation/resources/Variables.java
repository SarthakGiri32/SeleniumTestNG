package co.wipro.selenium.automation.resources;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Class for storing the variables relate to all the flows
 * @author Sarthak Giri
 *
 */
public class Variables extends ReadConfigFile {
	
	// common variables for all flows
	protected static String VERIZON_WEBSITE = "";
	protected static String CHROME_DRIVER = "";
	protected static int WAIT_TIME = 0;
	protected static int PAGE_LOAD_DELAY = 0;
	
	// Prepaid NSO flow variables
	// user input values
	protected static String IMEI_NUMBER = "357536082126865";
	protected static String ZIP_CODE_1 = "76401";
	
	// website element locators
	protected static String VERIZON_SHOP = "gnav20-Shop-L1";
	protected static String VERIZON_PREPAID_MENU = "gnav20-Shop-L2-7";
	protected static String VERIZON_PREPAID_OVERVIEW = "Prepaid overview";
	protected static String VERIZON_BYOD = "Learn how";
	protected static String VERIZON_JOIN = "Join Verizon";
	protected static String VERIZON_SMARTPHONE_DEVICE = "//p[contains(text(),'Smartphone')]";
	protected static String VERIZON_CONTINUE_BUTTON = "//button[contains(text(), 'Continue')]";
	protected static String VERIZON_I_DONT_KNOW = "I don't know";
	protected static String VERIZON_IMEI_NUMBER_FIELD = "imei";
	protected static String VERIZON_CHECK_MY_DEVICE = "//button[contains(text(), 'Check my device')]";
	protected static String VERIZON_ADD_SIM = "//button[contains(text(), 'Add SIM to cart')]";
	protected static String VERIZON_ZIP_CODE_FIELD = "zip";
	protected static String VERIZON_REMEMBER_MY_LOCATION = "//p[contains(text(),'Remember My Location')]";
	protected static String VERIZON_CONFIRM_LOCATION = "//button[contains(text(), 'Confirm location')]";
	protected static String VERIZON_LINE_PLAN = "[aria-label=\"Select 5 GB plan\"]";
	protected static String VERIZON_SELECT_PLAN = "selectPlanBtn";
	protected static String VERIZON_DECLINE_INTERNATIONAL_PLAN = "//button[contains(text(), 'Not now')]";
	
	@SuppressWarnings("unchecked")
	protected static void setVariables() throws IOException, ParseException {
		JSONArray jsonList = (JSONArray) createJsonArray();
		jsonList.forEach(vars -> setAllVariables((JSONObject)vars));
	}
	
	private static void setAllVariables(JSONObject varObject) {
		if (varObject.containsKey("commonVariables")) {
			JSONObject comVarObject = (JSONObject) varObject.get("commonVariables");
			VERIZON_WEBSITE = (String) comVarObject.get("verizonHomePage");
			CHROME_DRIVER = (String) comVarObject.get("chromeDriveLocation");
			WAIT_TIME = Integer.parseInt((String) comVarObject.get("seleniumWaitTime"));
			PAGE_LOAD_DELAY = Integer.parseInt((String) comVarObject.get("pageLoadDelay"));
		}
	}
}