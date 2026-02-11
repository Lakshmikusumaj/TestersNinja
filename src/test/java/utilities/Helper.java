package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Helper {
	
	



	    private static Properties properties;

	    // Load properties file
	    public static void  initProp() {
	        try {
	            FileInputStream ip =
	                    new FileInputStream("src/test/resources/config/config.properties");
	            properties = new Properties();
	            properties.load(ip);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to load config.properties");
	        }
	    }

	    // Read value using key
	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    
	}}

