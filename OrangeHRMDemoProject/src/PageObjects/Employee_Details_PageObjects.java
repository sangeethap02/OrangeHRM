package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Employee_Details_PageObjects {
	
	@FindBy(id="menu_pim_viewPimModule")
	public static WebElement pimModule;
	
	@FindBy(id="menu_pim_addEmployee")
	public static WebElement addEmployee;
	
	@FindBy(id="btnAdd")
	public static WebElement btnAdd;
	
	@FindBy(id="btnDelete")
	public static WebElement btnDelete;

	@FindBy(id="firstName")
	public static WebElement firstName;
	
	@FindBy(id="lastName")
	public static WebElement lastName;

	@FindBy(id="employeeId")
	public static WebElement employeeId;
	
	@FindBy(id="photofile")
	public static WebElement photofile;
	
	@FindBy(id="btnSave")
	public static WebElement btnSave;
	
	@FindBy(id="chkLogin")
	public static WebElement chkLogin;
	
	@FindBy(id="user_name")
	public static WebElement user_name;
	
	@FindBy(id="user_password")
	public static WebElement user_password;
	@FindBy(id="re_password")
	public static WebElement re_password;
	@FindBy(id="status")
	public static WebElement status;
}
