/****************************************************************************************
 *WebDriverManager: Instantiate and quit driver
 ****************************************************************************************
 *Constructor WebDriverManager: Initialize drivertype and environmenttype 
 *Method getdriver: Instantiate driver @return WebDriver driver
 *Method createDriver: Create local/remote driver with createLocalDriver/createRemoteDriver @param environmenttype,  @return WebDriver driver
 *Method createLocalDriver: Create local driver @param drivertype, @return WebDriver driver
 *Method createRemoteDriver: Create remote driver @return WebDriver driver
 *Method closedriver: Quit driver 
 * 
 * @author  santhiparambalam
 * @version 1.0 05/03/19
 *****************************************************************************************/

package manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import Utils.ConfigReader;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType drivertype;
	private static EnvironmentType environmenttype;
	private static String url;
	
	public WebDriverManager()
	{
		drivertype=ConfigReader.getdrivertype();
		environmenttype=ConfigReader.getenvironment();
		url=ConfigReader.getURL();
	}
	
	public WebDriver getdriver()
	{
		return (driver==null) ? driver=createDriver() : driver;
	}
	
	
	private WebDriver createDriver() {
		switch(environmenttype)
		{
		case LOCAL:
			driver=createLocalDriver();
		case REMOTE:
			driver=createRemoteDriver();
		}
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch(drivertype)
		{
		case CHROME:
		driver = new ChromeDriver();
		break;
		case FIREFOX:
		driver=new FirefoxDriver();
		break;
		case INTERNETEXPLORER:
		driver=new InternetExplorerDriver();
		break;
		}
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(ConfigReader.getimplicitlywait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;		
	}
	
	private WebDriver createRemoteDriver()
	{
		//NO CODE YET
		return driver;
	}
	
	public void closedriver()
	{
		driver.quit();
	}

}
