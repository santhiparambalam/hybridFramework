package manager;

import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginpage;

	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LoginPage loginpage()
	{
		return (loginpage==null) ? new LoginPage(driver) : loginpage;
	}
}
