package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Check_User_Role_PageObjects {
	
	@FindBy(id="menu_admin_viewAdminModule")
	public static WebElement admin_menu;
	
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement admin_Usermanagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement admin_Systemusers;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement search_Usertype;
	
	@FindBy(id="searchSystemUser_status")
	public static WebElement search_Userstatus;
	
	@FindBy(id="searchBtn")
	public static WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr[1]/td[3]")
	public static WebElement result_UserRole;
	
	@FindBy (xpath="//*[@id='resultTable']/tbody/tr[1]/td[5]")
	public static WebElement result_Enabled;
	
	////td[normalize-space()='Fiona Grace']
	

}
