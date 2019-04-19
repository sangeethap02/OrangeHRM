package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pending_Leave_Request_PageObjects {
	
	@FindBy(id="menu_dashboard_index")
	public static WebElement menu_dashboard_index;
	
	@FindBy(xpath="//*[@id='task-list-group-panel-menu_holder']/table/tbody/tr/td")
	public static WebElement pending_leave_requests;

}
