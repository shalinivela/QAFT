package GenericUtility;
/**
/**
 * @author skannan
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.junit.Before;

public class AppPropExtractor {

	
	
	static Properties uiMap = new Properties();
	static Properties testDataMap = new Properties();
	static Properties ConfigurationMap = new Properties();
	static AppPropExtractor s = new AppPropExtractor();
 

	
	
	public String configMap(String property) {
		try {
			File file = new File("src/Configu.properties");
			// System.out.println(file.getAbsolutePath());
			// Configuration object for the test app
			FileInputStream inConfig = new FileInputStream(file.getPath());
			// Load the map file
			ConfigurationMap.load(inConfig);
			String propStr = ConfigurationMap.getProperty(property);
			inConfig.close();
			return propStr;
		} catch (Exception e) {
			return " Property  file not found";
		}

	}

	public String testDataMap(String property) {
		// Configuration object for the test app
		try {
			FileInputStream inTda = new FileInputStream(
					"src/TestData.properties");
			// Load the map file
			testDataMap.load(inTda);
			// You can do something here like getting the value of a key.
			// Example
			String propStr = testDataMap.getProperty(property);
			// System.out.println(propStr);
			inTda.close();
			return propStr;
		} catch (Exception e) {
			return " Property  file not found";
		}
	}

	public String uiMap(String property) {
		try {
			FileInputStream inUi = new FileInputStream("src/UI.properties");
			// Load the map file
			uiMap.load(inUi);
			// You can do something here like getting the value of a key.
			// Example
			String propStr = uiMap.getProperty(property);
			// System.out.println(propStr);
			inUi.close();
			return propStr;
		} catch (Exception e) {
			return " Property  file not found";
		}

	}

	

	
}
