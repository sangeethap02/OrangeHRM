package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class add_Recruitment_Candidate_PageObjects {
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public static WebElement wRecruitment;
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public static WebElement wCandidate;
	
	@FindBy(id="btnAdd")
	public static WebElement wAdd;
	
	@FindBy(id="addCandidate_firstName")
	public static WebElement wAddFirstName;
	
	@FindBy(id="addCandidate_lastName")
	public static WebElement wAddLastName;
	
	@FindBy(id="addCandidate_email")
	public static WebElement wEmail;
	
	@FindBy(id="addCandidate_vacancy")
	public static WebElement wVacancy;
	
	@FindBy(id="btnSave")
	public static WebElement wbtnSave;
	
	@FindBy(id="btnDelete")
	public static WebElement wbtnDelete;
	
	@FindBy(id="resultTable")
	public static WebElement wresultTable;
	
	@FindBy(xpath="//*[@id='resultTable']//tr")
	public static List<WebElement> wTableRow;
	
	@FindBy(xpath="//*[@id='resultTable']//th")
	public static List<WebElement> wTableCol;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr/")
	public static WebElement wBodyrow;
	
	@FindBy(id="dialogDeleteBtn")
	public static WebElement wDialogDeleteBtn;
	
	@FindBy(id="btnBack")
	public static WebElement wbtnBack;
	
	
	
	

}
