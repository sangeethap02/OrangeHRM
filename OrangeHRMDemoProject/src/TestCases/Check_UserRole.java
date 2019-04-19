package TestCases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import CommonFunctions.CommonFunction;
import PageObjects.Check_User_Role_PageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Check_UserRole extends CommonFunction {
	Logger logger=Logger.getLogger(Check_UserRole.class);
	
	public void NavigateUserPage(){
		logger.info("Navigate to user page");
	PageFactory.initElements(driver,Check_User_Role_PageObjects.class);
	Actions actions=new Actions(driver);
	actions.moveToElement(Check_User_Role_PageObjects.admin_menu);
	actions.moveToElement(Check_User_Role_PageObjects.admin_Usermanagement);
	actions.moveToElement(Check_User_Role_PageObjects.admin_Systemusers);
	actions.click().build().perform();
	logger.info("Navigated to the user page");
	
	}
	@Test
	public void verifyUserPage(){
		NavigateUserPage();
		logger.info("Verifying user Status Page");
		Select selectRole= new Select(Check_User_Role_PageObjects.search_Usertype);
		selectRole.selectByVisibleText("Admin");
		logger.info("Select the user role");
		
		Select selectUserStatus=new Select(Check_User_Role_PageObjects.search_Userstatus);
		selectUserStatus.selectByVisibleText("Enabled");
		logger.info("Select the user status");
		
		Check_User_Role_PageObjects.searchBtn.click();
		
		String actualUserRole=Check_User_Role_PageObjects.result_UserRole.getText();
		String actualUserStatus=Check_User_Role_PageObjects.result_Enabled.getText();
		Assert.assertEquals(actualUserRole, "Admin");
		logger.info("Executed Verify user Role : " +actualUserRole );
		Assert.assertEquals(actualUserStatus, "Enabled");
		logger.info("Executed Verify user Status : " +actualUserStatus );
		logger.info("Executed Verify user page");
		
		
		
	}
}
