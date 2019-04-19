package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import CommonFunctions.CommonFunction;

import PageObjects.Pending_Leave_Request_PageObjects;

public class Pending_leaveRequest extends CommonFunction {
	Logger logger=Logger.getLogger(Pending_leaveRequest.class);
	
	
	@Test
	public void PendingLeaveRequest(){
		
		//LoginApplication();
		logger.info("Going to Pending leave request page");
		PageFactory.initElements(driver, Pending_Leave_Request_PageObjects.class);
		Pending_Leave_Request_PageObjects.menu_dashboard_index.click();
		String ActualMessage=Pending_Leave_Request_PageObjects.pending_leave_requests.getText();
		logger.info("Verify the Pending leave request page info");
		Assert.assertEquals(ActualMessage, "No Records are Available");
		logger.info("Verified Pending Leave Request");
		
		
	}
}
