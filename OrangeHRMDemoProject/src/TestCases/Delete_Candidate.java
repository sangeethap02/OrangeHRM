package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonFunctions.CommonFunction;
import PageObjects.add_Recruitment_Candidate_PageObjects;
import jxl.read.biff.BiffException;

public class Delete_Candidate extends CommonFunction {
	Logger logger=Logger.getLogger(add_Recruitment_Candidate.class);
	
	public void NavigateToCRecruitmentPage(){
		PageFactory.initElements(driver,add_Recruitment_Candidate_PageObjects.class);
		add_Recruitment_Candidate_PageObjects.wRecruitment.click();
		logger.info("Navigated to Recuruitment page successfully");
		
		add_Recruitment_Candidate_PageObjects.wCandidate.click();
		logger.info("Navigated to Candidate page successfully");
		
	}
	
	
	@Test
	public void Delete_Candidate_Details() throws InterruptedException, BiffException, IOException{
		NavigateToCRecruitmentPage();
		logger.info("Delete Candidate details");
		//Thread.sleep(2000);
		String[][] sData=readExcelFile("Add_Candidate");
		logger.info(sData.length);
		//System.out.println("the test data length from excel is :"+sData.length);
		for (int k=0;k<sData.length;k++){
			
			String sFullName=sData[k][0]+" "+sData[k][1];
			logger.info("The Full name is :"+sFullName);
			//String sLastName=sData[k][1];
			
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				int tRow=add_Recruitment_Candidate_PageObjects.wTableRow.size();
				int tCol=add_Recruitment_Candidate_PageObjects.wTableCol.size();
				//System.out.println("The rowCount is "+tRow+ "The Column count is "+tCol);
				first:
				for (int i = 1; i < tRow; i++) {
					 // System.out.println(i);
					 for (int j = 1; j < tCol; j++) {
						 //boolean sFlag = false;
							String sTextName=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
							//System.out.println(sTextName);
							if (sTextName.equalsIgnoreCase(sFullName)){
								//sFlag = true;
								driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[1]/input")).click();
								add_Recruitment_Candidate_PageObjects.wbtnDelete.click();
								add_Recruitment_Candidate_PageObjects.wDialogDeleteBtn.click();
								logger.info("Deleted Candidate details");
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								break first;
								
							}
							//if (sFlag){ 
								//logger.info("sFlag is true ");
							//break;
							//}
					
					 }
				}
		
		}
		
		
	}
}
