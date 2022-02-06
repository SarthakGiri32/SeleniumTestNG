package co.wipro.selenium.automation.resources;

/**
 * Class for storing the variables relate to all the flows
 * @author sarthakgiri
 *
 */
public class Variables {
	
	// common variables for all flows
	public static final String VERIZON_WEBSITE = "https://www.verizon.com/";
	public static final String CHROME_DRIVER = "/home/sarthakgiri/Downloads/Softwares/chromedriver";
	public static final int WAIT_TIME = 30;
	public static final int PAGE_LOAD_DELAY = 10000;
	
	// Prepaid NSO flow variables
	// user input values
	public static final String IMEI_NUMBER = "357536082126865";
	public static final String ZIP_CODE_1 = "76401";
	
	// website element locators
	public static final String VERIZON_SHOP = "gnav20-Shop-L1";
	public static final String VERIZON_PREPAID_MENU = "gnav20-Shop-L2-7";
	public static final String VERIZON_PREPAID_OVERVIEW = "Prepaid overview";
	public static final String VERIZON_BYOD = "Learn how";
	public static final String VERIZON_JOIN = "Join Verizon";
	public static final String VERIZON_SMARTPHONE_DEVICE = "//p[contains(text(),'Smartphone')]";
	public static final String VERIZON_CONTINUE_BUTTON = "//button[contains(text(), 'Continue')]";
	public static final String VERIZON_I_DONT_KNOW = "I don't know";
	public static final String VERIZON_IMEI_NUMBER_FIELD = "imei";
	public static final String VERIZON_CHECK_MY_DEVICE = "//button[contains(text(), 'Check my device')]";
	public static final String VERIZON_ADD_SIM = "//button[contains(text(), 'Add SIM to cart')]";
	public static final String VERIZON_ZIP_CODE_FIELD = "zip";
	public static final String VERIZON_REMEMBER_MY_LOCATION = "//p[contains(text(),'Remember My Location')]";
	public static final String VERIZON_CONFIRM_LOCATION = "//button[contains(text(), 'Confirm location')]";
	public static final String VERIZON_LINE_PLAN = "[aria-label=\"Select 5 GB plan\"]";
	public static final String VERIZON_SELECT_PLAN = "selectPlanBtn";
	public static final String VERIZON_DECLINE_INTERNATIONAL_PLAN = "//button[contains(text(), 'Not now')]";
	
}