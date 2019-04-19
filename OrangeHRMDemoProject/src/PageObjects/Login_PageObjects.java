package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PageObjects {
	@FindBy(id="txtUsername")
	public static WebElement txtUsername;
	
	@FindBy(id="txtPassword")
	public static WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	public static WebElement btnLogin;
}
