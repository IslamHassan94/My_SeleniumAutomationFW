package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	// load the properties file from the folder
	public static Properties userData = loadProperties(
			System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userData.properites");
	
	//Load Sauce Labs account properties
	public static Properties sauceLabsData = loadProperties(
			System.getProperty("user.dir") + "\\src\\main\\java\\properties\\sauceLabs.properties");

	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		// stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occured: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occured: " + e.getMessage());
		}
		return pro;
	}

}
