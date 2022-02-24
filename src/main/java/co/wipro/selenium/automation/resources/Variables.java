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
	protected static String IMEI_NUMBER = "";
	protected static String ZIP_CODE_1 = "";
	
	// website element locators
	protected static String VERIZON_SHOP = "";
	protected static String VERIZON_PREPAID_MENU = "";
	protected static String VERIZON_PREPAID_OVERVIEW = "";
	protected static String VERIZON_BYOD = "";
	protected static String VERIZON_JOIN = "";
	protected static String VERIZON_SMARTPHONE_DEVICE = "";
	protected static String VERIZON_CONTINUE_BUTTON = "";
	protected static String VERIZON_I_DONT_KNOW = "";
	protected static String VERIZON_IMEI_NUMBER_FIELD = "";
	protected static String VERIZON_CHECK_MY_DEVICE = "";
	protected static String VERIZON_ADD_SIM = "";
	protected static String VERIZON_ZIP_CODE_FIELD = "";
	protected static String VERIZON_REMEMBER_MY_LOCATION = "";
	protected static String VERIZON_CONFIRM_LOCATION = "";
	protected static String VERIZON_LINE_PLAN = "";
	protected static String VERIZON_SELECT_PLAN = "";
	protected static String VERIZON_DECLINE_INTERNATIONAL_PLAN = "";
	
	@SuppressWarnings("unchecked")
	protected static void setVariables() throws IOException, ParseException {
		JSONArray jsonList = (JSONArray) createJsonArray();
		jsonList.forEach(vars -> setAllVariables((JSONObject)vars));
	}
	
	@SuppressWarnings("unchecked")
	private static void setAllVariables(JSONObject varObject) {
		if (varObject.containsKey("commonVariables")) {
			JSONObject comVarObject = (JSONObject) varObject.get("commonVariables");
			VERIZON_WEBSITE =  comVarObject.get("verizonHomePage").toString();
			CHROME_DRIVER =  comVarObject.get("chromeDriveLocation").toString();
			WAIT_TIME = Integer.parseInt( comVarObject.get("seleniumWaitTime").toString());
			PAGE_LOAD_DELAY = Integer.parseInt( comVarObject.get("pageLoadDelay").toString());
		}
		else if (varObject.containsKey("prepaidNSO")) {
			JSONArray prepaidNSOValues = (JSONArray) varObject.get("prepaidNSO");
			prepaidNSOValues.forEach(vars -> setPrepaidNSOValues((JSONObject)vars));
		}
	}

	private static void setPrepaidNSOValues(JSONObject varObject) {
		// TODO Auto-generated method stub
		if (varObject.containsKey("userInputValues")) {
			JSONObject flowInputVals = (JSONObject) varObject.get("userInputValues");
			IMEI_NUMBER =  flowInputVals.get("imeiNumber").toString();
			ZIP_CODE_1 =  flowInputVals.get("zipCode").toString();
		}
		else if (varObject.containsKey("webElemLocs")) {
			JSONObject elemLocs = (JSONObject) varObject.get("webElemLocs");
			VERIZON_SHOP =  elemLocs.get("vznShop").toString();
			VERIZON_PREPAID_MENU =  elemLocs.get("vznPreMenu").toString();
			VERIZON_PREPAID_OVERVIEW =  elemLocs.get("vznPreOver").toString();
			VERIZON_BYOD =  elemLocs.get("vznByod").toString();
			VERIZON_JOIN =  elemLocs.get("vznJoin").toString();
			VERIZON_SMARTPHONE_DEVICE =  elemLocs.get("vznDevice").toString();
			VERIZON_CONTINUE_BUTTON =  elemLocs.get("vznContinue").toString();
			VERIZON_I_DONT_KNOW =  elemLocs.get("vznIDontKnow").toString();
			VERIZON_IMEI_NUMBER_FIELD =  elemLocs.get("vznImei").toString();
			VERIZON_CHECK_MY_DEVICE =  elemLocs.get("vznCheckDev").toString();
			VERIZON_ADD_SIM = elemLocs.get("vznAddSim").toString();
			VERIZON_ZIP_CODE_FIELD = elemLocs.get("vznZip").toString();
			VERIZON_REMEMBER_MY_LOCATION = elemLocs.get("vznRemLoc").toString();
			VERIZON_CONFIRM_LOCATION = elemLocs.get("vznConLoc").toString();
			VERIZON_LINE_PLAN = elemLocs.get("vznLine").toString();
			VERIZON_SELECT_PLAN = elemLocs.get("vznPlanSel").toString();
			VERIZON_DECLINE_INTERNATIONAL_PLAN = elemLocs.get("vznDecIntPlan").toString();
		}
	}
}