package TestCases;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonFunctions.CommonFunction;
import PageObjects.add_Recruitment_Candidate_PageObjects;
import jxl.read.biff.BiffException;

public class add_Recruitment_Candidate extends CommonFunction {
	Logger logger=Logger.getLogger(add_Recruitment_Candidate.class);
	
	public void NavigateToRecruitmentPage(){
		PageFactory.initElements(driver,add_Recruitment_Candidate_PageObjects.class);
		add_Recruitment_Candidate_PageObjects.wRecruitment.click();
		logger.info("Navigated to Recuruitment page successfully");
		
		add_Recruitment_Candidate_PageObjects.wCandidate.click();
		logger.info("Navigated to Candidate page successfully");
		
	}
	@Test
	public void Add_Candidate() throws BiffException, IOException{
		NavigateToRecruitmentPage();
		
		String[][] sData=readExcelFile("Add_Candidate");
		logger.info(sData.length);
		System.out.println("the test data length from excel is :"+sData.length);
		for (int i=0;i<sData.length;i++){
			String sFirstName=sData[i][0];
			String sLastName=sData[i][1];
			String sEmail=sData[i][2];
			String sPhNum=sData[i][3];
			String sSkill=sData[i][4];
				logger.info(sFirstName+","+sLastName+","+sEmail+","+sPhNum+","+sSkill);
				add_Recruitment_Candidate_PageObjects.wAdd.click();
				logger.info("Navigated to Add Recuruitment page successfully");
				logger.info("Adding  Candidate details page");
				add_Recruitment_Candidate_PageObjects.wAddFirstName.sendKeys(sFirstName);
				add_Recruitment_Candidate_PageObjects.wAddLastName.sendKeys(sLastName);
				add_Recruitment_Candidate_PageObjects.wEmail.sendKeys(sEmail);
				Select select=new Select(add_Recruitment_Candidate_PageObjects.wVacancy);
				select.selectByIndex(0);
				add_Recruitment_Candidate_PageObjects.wbtnSave.click();
				//add_Recruitment_Candidate_PageObjects.wVacancy.Se
				logger.info("Successfully save a candidate");	
				add_Recruitment_Candidate_PageObjects.wbtnBack.click();
				logger.info("Successfully Clicked back button");	
		}
		
	}
	
}
