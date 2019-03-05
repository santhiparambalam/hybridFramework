/****************************************************************************************
 *LoginPage: Find webelements and perform actions on Loginpage
 ****************************************************************************************
 *Constructor LoginPage: Intialize elements 
 *@Findby username, password, signin
 *Method enter_username: Sendkeys to enter username @param String userName
 *Method enter_password: Sendkeys to enter password @param String passWord
 *Method click_signin: Click on signin button
 *Method login: Bind method- enter username, password and click signin @param String username, String password 
 * 
 * @author  santhiparambalam
 * @version 1.0 05/03/19
 *****************************************************************************************/


package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.CSS, using="//input[name='userName']")
	public WebElement username_textbox;
	
	@FindBy(how=How.CSS, using="//input[name='password']")
	public WebElement password_textbox;
	
	@FindBy(how=How.CSS, using="//input[name='login']")
	public WebElement signin_button;
	
	public void enter_username(String userName)
	{
		username_textbox.sendKeys(userName);
	}
	
	public void enter_password(String passWord)
	{
		username_textbox.sendKeys(passWord);
	}
	
	public void click_signin()
	{
		username_textbox.click();
	}
	
	public void loginoperation(String username, String password)
	{
		enter_username(username);
		enter_password(password);
		click_signin();
	}
}
