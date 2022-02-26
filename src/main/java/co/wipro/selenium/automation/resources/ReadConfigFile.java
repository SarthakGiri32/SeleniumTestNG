package co.wipro.selenium.automation.resources;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadConfigFile extends Variables{

	protected static JSONArray createJsonArray() throws IOException, ParseException {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        String configFilePath = "/home/sarthakgiri/Documents/java-workspace/SeleniumTestNG/src/main/resources/Config.json";
        FileReader reader = new FileReader(configFilePath);
		Object obj = jsonParser.parse(reader);
        JSONArray configList = (JSONArray) obj;
        return configList;
	}
	
	protected static void setVariables() throws IOException, ParseException {
		JSONArray jsonList = (JSONArray) createJsonArray();
		boolean comVarsFlag = false;
		boolean inputVarsFlag = false;
		boolean webElemsFlag = false;
		for (int i = 0; i < jsonList.size(); i++) {
			JSONObject configObject = (JSONObject) jsonList.get(i);
			if (configObject.containsKey("commonVariables")) {
				JSONObject comVarObject = (JSONObject) configObject.get("commonVariables");
				VERIZON_WEBSITE =  comVarObject.get("verizonHomePage").toString();
				CHROME_DRIVER =  comVarObject.get("chromeDriveLocation").toString();
				WAIT_TIME = Integer.parseInt( comVarObject.get("seleniumWaitTime").toString());
				PAGE_LOAD_DELAY = Integer.parseInt( comVarObject.get("pageLoadDelay").toString());
				comVarsFlag = true;
			}
			else if(configObject.containsKey("prepaidNSO")) {
				JSONArray flowVarArray = (JSONArray) configObject.get("prepaidNSO");
				for (int j = 0; j < flowVarArray.size(); j++) {
					JSONObject flowVarObject = (JSONObject) flowVarArray.get(j);
					if (flowVarObject.containsKey("userInputValues")) {
						JSONObject userInpValsObject = (JSONObject) flowVarObject.get("userInputValues");
						IMEI_NUMBER =  userInpValsObject.get("imeiNumber").toString();
						ZIP_CODE_1 =  userInpValsObject.get("zipCode").toString();
						inputVarsFlag = true;
					}
					else if (flowVarObject.containsKey("webElemLocs")) {
						JSONObject webElemsObject = (JSONObject) flowVarObject.get("webElemLocs");
						VERIZON_SHOP =  webElemsObject.get("vznShop").toString();
						VERIZON_PREPAID_MENU =  webElemsObject.get("vznPreMenu").toString();
						VERIZON_PREPAID_OVERVIEW =  webElemsObject.get("vznPreOver").toString();
						VERIZON_BYOD =  webElemsObject.get("vznByod").toString();
						VERIZON_JOIN =  webElemsObject.get("vznJoin").toString();
						VERIZON_SMARTPHONE_DEVICE =  webElemsObject.get("vznDevice").toString();
						VERIZON_CONTINUE_BUTTON =  webElemsObject.get("vznContinue").toString();
						VERIZON_I_DONT_KNOW =  webElemsObject.get("vznIDontKnow").toString();
						VERIZON_IMEI_NUMBER_FIELD =  webElemsObject.get("vznImei").toString();
						VERIZON_CHECK_MY_DEVICE =  webElemsObject.get("vznCheckDev").toString();
						VERIZON_ADD_SIM = webElemsObject.get("vznAddSim").toString();
						VERIZON_ZIP_CODE_FIELD = webElemsObject.get("vznZip").toString();
						VERIZON_REMEMBER_MY_LOCATION = webElemsObject.get("vznRemLoc").toString();
						VERIZON_CONFIRM_LOCATION = webElemsObject.get("vznConLoc").toString();
						VERIZON_LINE_PLAN = webElemsObject.get("vznLine").toString();
						VERIZON_SELECT_PLAN = webElemsObject.get("vznPlanSel").toString();
						VERIZON_DECLINE_INTERNATIONAL_PLAN = webElemsObject.get("vznDecIntPlan").toString();
						webElemsFlag = true;
					}
				}
			}
		}
		System.out.println(comVarsFlag ? "Reading Common Variables... SUCCESS!" : "Reading Common Variables... FAILED!");
		System.out.println(inputVarsFlag ? "Reading User Input Variables... SUCCESS!" : "Reading User Input Variables... FAILED!");
		System.out.println(webElemsFlag ? "Reading Web Element Locator Variables... SUCCESS!" : "Reading Web Element Locator Variables... FAILED!");
	}
}
