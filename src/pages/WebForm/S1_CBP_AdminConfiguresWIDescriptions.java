/*package pages.WebForm;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import BaseClasses.Driver;
import BaseClasses.GenericUtilities;
import junit.framework.Assert;
import steps.ExternalSingleRequestFormSteps;
import steps.LoginSteps;
import utilities.FileOperations;

@Listeners(utilities.TestListener.class)
public class S1_CBP_AdminConfiguresWIDescriptions extends Driver {

	// WebDriver driver = null;
	Driver driverObj = new Driver();
	ExternalSingleRequestFormSteps ESRFStepObj = new ExternalSingleRequestFormSteps();
	LoginSteps loginStepsObj = new LoginSteps();
	SoftAssert softAssert = null;
	Logger logger;

	@FindBy(xpath = "//*[@title=\"All Tabs\"]")
	WebElement allTabsBtnEle;

	@FindBy(xpath = "//*[@title=\"Webform Field Settings\"]")
	WebElement webFormFieldSettingEle;

	@FindBy(xpath = "//h1[contains(text(),'Webform Field Settings')]")
	WebElement webFormFieldSettingHomePage;

	@FindBy(xpath = "//a[@href=\"https://cs20.salesforce.com/home/home.jsp\"]")
	WebElement homePageEle;
	
	@FindBy(xpath="//*[@id=\"fcf\"]") 
	WebElement ItemTypeDropDown;
	
	@FindBy(name="go") 
	WebElement GoButtonEle;
	
	@FindBy(id="ext-gen8") 
	WebElement workItemsListGridELe;
	
	@FindBy(xpath = "//span[text()='D']") 
	WebElement workItemsAlphabetsGridELe;
	
	@FindBy(xpath = "//span[text()='DA CCA Webform']") 
	WebElement webformInFieldSettingpage;

	@FindBy(xpath = "//h2[contains(text(),'Webform Field Settings Edit')]")
	WebElement webFormFieldSettingEditPage;
	
	@FindBy(xpath = "//*[contains(text(),'WITypeHelpText')]")
	WebElement wiTypeHelpText;
	
	@FindBy(xpath = "//*[@title='Save']")
	private WebElement save;
	

	public S1_CBP_AdminConfiguresWIDescriptions() {

		PageFactory.initElements(driver, this);
	}

	public void s1_CBP_AdminConfiguresWIDescriptions() throws Exception {
		/// logger= new Logger();
		GenericUtilities util = new GenericUtilities();
		// Step 1 login as business admin started

		util.customAlertByJS("Step 1 started");
		driver.get(driverObj.getUrlBA());

		// Step 2
		util.customAlertByJS("STep 2 started");
		loginStepsObj.login(driver, driverObj.getUsernameBA(), driverObj.getPasswordBA());
		Thread.sleep(2000);
		util.click(homePageEle);
		Thread.sleep(2000);
		// logger.info("Step 1 & 2 passed- Successfully logged into
		// application");

		// Step 3
		util.customAlertByJS("Step 3 started- Selecting WebForm field settings");
		util.click(allTabsBtnEle);
		Assert.assertTrue(webFormFieldSettingEle.isDisplayed());
		// logger.info("Step 3 passed, all objects including webForm field
		// settings are diaplayed");

		// Step 4
		util.customAlertByJS("Step 4 started");
		util.click(webFormFieldSettingEle);
		Assert.assertTrue(webFormFieldSettingHomePage.isDisplayed());
		
		// Step 5
		try{
		util.customAlertByJS("Step 5 started");
		util.selectByName("All", ItemTypeDropDown);
		util.click(GoButtonEle);
		util.highlighElement(workItemsListGridELe); 
		Assert.assertTrue(workItemsListGridELe.isDisplayed());
		}catch (Exception e) {
			Reporter.log("Step 5 failed");

		}
		
		//Step 6
		try{
		util.customAlertByJS("Step 6 started - Selecting WI to be Updated");
		util.click(workItemsAlphabetsGridELe);
		Assert.assertTrue(webformInFieldSettingpage.isDisplayed());
		}catch (Exception e) {
			Reporter.log("Step 6 failed");

		}
		
		//Step 7
		try{
			util.customAlertByJS("Step 7 started - Clik on Edit");
			driver.findElement(By.xpath("//a[contains(@href,'/a0gm00000033FeW/e?retURL=%2Fa0g%3Ffcf%3D00Bo0000003rBOW%26rolodexIndex%3D3%26page%3D1')]")).click();
			Assert.assertTrue(webFormFieldSettingEditPage.isDisplayed());
			}catch (Exception e) {
				Reporter.log("Step 7 failed");
			}
		
		//Step 8 and 9 combined
		
		try{
		util.customAlertByJS("Step 8 started - Update 'WITypeHelpText' field with the new WI type description");
		Assert.assertTrue(wiTypeHelpText.isDisplayed());
		WebElement logEntryField = driver.findElement(By.xpath("//*[@id=\"00Nm0000001j0mT\"]"));
		String logText = logEntryField.getText();
		util.sendKeys(logEntryField, logText.concat("Automation Test"));
		//util.sendKeys(logEntryField, logText.concat("<a href="https://www.pge.com/en_US/residential/customer-service/other-services/alternative-energy-providers/community-choice-aggregation/community-choice-aggregation.page" target="_blank">Automation Test</a>"));
		util.click(save);
		}catch (Exception e) {
			Reporter.log("Step 8 failed");

		}
		
		//Step 10,11,12,13,14,15
		
			util.customAlertByJS("Step 10 started - Confirm WI type description has been updated - External Submitter");
			WebElement logOutMenu = driver.findElement(By.xpath("//*[@id=\"globalHeaderNameMink\"]"));
			util.click(logOutMenu);
			WebElement logoutButton = driver.findElement(By.xpath("//*[@title=\"Logout\"]"));
			util.click(logoutButton);
			//User Login code needs to be added
			softAssert = new SoftAssert();
			logger = Logger.getLogger("devpinoyLogger");
			logger.debug("Verifying The Request Form Page");
			String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
			softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
			logger.debug("Verifying The Request Form Type");
			String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
			softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
			logger.debug("Verifying The Category SubTitle");
			String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
			softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
			logger.debug("Selecting the Category From DropDown");
			ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option2"));
			logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
			String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
			// softAssert.assertEquals(categoryDescriptionTxt, "");
			logger.debug("Verifying The Work Item SubTitle");
			String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
			softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
			logger.debug("Selecting the Work Item From DropDown");
			ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option4"));
			logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
			String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
			softAssert.assertEquals(wITDescriptionTxt, "");
			logger.debug("Selecting the Submission Type From DropDown");
			ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
			logger.debug("Verifying The Submission Type SubTitle");
			String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
			softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		
		}

		
		@AfterMethod(alwaysRun = true)
		public void tearDown() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}
		

	}

*/