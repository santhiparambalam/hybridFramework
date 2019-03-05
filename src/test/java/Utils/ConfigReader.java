/****************************************************************************************
 *ConfigReader: Read and interact with config.properties
 ****************************************************************************************
 *Constructor ConfigReader: Read config.properties 
 *Method getdrivertype: Get driverttype with getproperty @return DriverType
 *Method getenvironment: Get environmenttype with getproperty @return EnvironmentType
 *Method getdrivertype: Get driverpath with getproperty @return String driverpath
 *Method getURL: Get url with getproperty @return String url
 *Method getimplicitlywait: Get implicitlywait with getproperty @return Long implicitwait
 *Method getexceltestdata: Get exceltestdata with getproperty @return String excelTDpath
 *Method getexcelactionkeyword: Get excelactionkeyword with getproperty @return String excelAKpath
 * 
 * @author  santhiparambalam
 * @version 1.0 05/03/19
 *****************************************************************************************/


package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import enums.DriverType;
import enums.EnvironmentType;

public class ConfigReader {

	public static Properties Config;
	private static String propertyFilepath="D://Eclipse QA//OwnFramework//Config//Config.property";
	
	public ConfigReader() 
	{
		BufferedReader reader;
		try {
			reader=new BufferedReader(new FileReader(propertyFilepath));
			Config=new Properties();
			try {
				Config.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to load reader");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to find config.property");
		}
		
	}
	
	public static DriverType getdrivertype()
	{
		String browser=Config.getProperty("drivertype");
		if (browser.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if (browser.equalsIgnoreCase("IE")) return DriverType.INTERNETEXPLORER;
		else if (browser.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else throw new RuntimeException("Drivertype is not found");
	}
	
	public static EnvironmentType getenvironment()
	{
		String environment=Config.getProperty("environmenttype");
		if (environment.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		if (environment.equalsIgnoreCase("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment is not found");
	}
	
	public static String getdriverpath()
	{
		String driverpath=Config.getProperty("driverpath");
		if (driverpath!=null) return driverpath;
		else throw new RuntimeException("Driverpath is not found");
	}
	
	public static String getURL()
	{
		String url=Config.getProperty("URL");
		if (url!=null) return url;
		else throw new RuntimeException("Driverpath is not found");
	}
	
	public static long getimplicitlywait()
	{
		String implicitwait=Config.getProperty("implicitlywait");
		if (implicitwait!=null) return Long.parseLong(implicitwait);
		else throw new RuntimeException("Implicit wait is not found");
	}
	
	public static String getexceltestdata()
	{
		String excelTDpath=Config.getProperty("exceltestdata");
		if (excelTDpath!=null) return excelTDpath;
		else throw new RuntimeException("Test data excel file path is not found");
	}
	
	public static String getexcelactionkeyword()
	{
		String excelAKpath=Config.getProperty("excelactionkeyword");
		if (excelAKpath!=null) return excelAKpath;
		else throw new RuntimeException("Action keyword excel file path is not found");
	}
	
	
}
