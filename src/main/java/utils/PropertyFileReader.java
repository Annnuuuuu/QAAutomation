
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    private static String url;
    private static String browser;
    private static String userName;
    private static String password;
    private static String dwollaUrl;
    private static String dwollaUserName;
    private static String dwollaPassword;
   

    public static void loadData(String Environment) {
       
    	 Properties prop = new Properties();
		 String propertyFilePath = null;
		if(Environment.equalsIgnoreCase("Test")) {
				propertyFilePath= System.getProperty("user.dir")+"\\config\\test.properties";
	} else if(Environment.equalsIgnoreCase("Stage")) {
			propertyFilePath= System.getProperty("user.dir")+"\\config\\stage.properties";
	}
		try {
            prop.load(new FileInputStream(propertyFilePath));
            url = prop.getProperty("url");
            browser = prop.getProperty("browser");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
            dwollaUrl = prop.getProperty("dwollaUrl");
            dwollaUserName = prop.getProperty("dwollaUserName");
            dwollaPassword = prop.getProperty("dwollaPassword");
         } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }
	public static String getUrl() {
		return url;
	}
    
	 public static String getBrowser() {
			return browser;
		}
	public static String getUserName() {
		return userName;
	}
	public static String getPassword() {
		return password;
	}
	
	public static String getDwollaUrl() {
		return dwollaUrl;
	}
    
	 
	public static String getDwollaUserName() {
		return dwollaUserName;
	}
	public static String getDwollaPassword() {
		return dwollaPassword;
	}
}