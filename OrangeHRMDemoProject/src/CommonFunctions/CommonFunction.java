package CommonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import PageObjects.Login_PageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




public class CommonFunction {

	public static Properties properties;
	public static WebDriver driver;
	
	Logger logger=Logger.getLogger(CommonFunction.class);//factory design pattern
	
	public Properties loadPropertyFile() throws IOException{		
		FileInputStream fileinputstream=new FileInputStream("config.properties");
		properties=new Properties();
		properties.load(fileinputstream);
		return properties;
	}
	
	@BeforeSuite
	public WebDriver launchBrowser() throws IOException{

		PropertyConfigurator.configure("log4j.properties");		
		logger.info("Application test begin");	
		loadPropertyFile();
		logger.info("Loading the Config properties");
		String Browser=properties.getProperty("browser");
		String URL=properties.getProperty("url");
		String driverlocation=properties.getProperty("driverlocation");
		
		if (Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",driverlocation);
			 driver = new ChromeDriver();
			 logger.info("Launched Chrome");
		}
		else if(Browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", driverlocation);
			logger.info("Launching firefox");
			 driver = new FirefoxDriver();
		}
		driver.get(URL);
		logger.info("Navigate to application URL");
		driver.manage().window().maximize();
		logger.info("Maximize the application page");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginApplication();
		return driver;
	}
	public void LoginApplication(){
		PageFactory.initElements(driver, Login_PageObjects.class);
		Login_PageObjects.txtUsername.sendKeys(properties.getProperty("username"));
		Login_PageObjects.txtPassword.sendKeys(properties.getProperty("password"));
		Login_PageObjects.btnLogin.click();
		logger.info("Logging in to OrangeHRM application");
	}
	@AfterSuite
	public void tearDown(){
		driver.quit();
		logger.info("The browser is closed");
	}
	
	public String[][] readExcelFile(String sSheetName) throws BiffException, IOException{
		String sFileLoc=properties.getProperty("Filelocation");
		//System.out.println("The Excel file location is "+sFileLoc);
		logger.info(sFileLoc);
		FileInputStream file=new FileInputStream(sFileLoc);
		
		
		Workbook workbook=Workbook.getWorkbook(file);
		Sheet sheet=workbook.getSheet(sSheetName);
		int rowCount= sheet.getRows();
		int colCount =sheet.getColumns();
		
		String tData[][]=new String[rowCount-1][colCount];
		 for(int i=1;i<rowCount;i++){
			 for(int j=0;j<colCount;j++){
				 
				 tData[i-1][j]= sheet.getCell(j,i).getContents();
				 //System.out.println(sheet.getCell(j,i).getContents());
			 }
			 //Add_CandidateDetails()
			 
		 }
		
		return tData;
	}
}

