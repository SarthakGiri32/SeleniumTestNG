package co.wipro.selenium.automation.resources;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadConfigFile {

	protected static JSONArray createJsonArray() throws IOException, ParseException {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        String configFilePath = "/home/sarthakgiri/Documents/java-workspace/SelenimTestNG/src/main/resources/Config.json";
        FileReader reader = new FileReader(configFilePath);
		Object obj = jsonParser.parse(reader);
        JSONArray configList = (JSONArray) obj;
        return configList;
	}
}
