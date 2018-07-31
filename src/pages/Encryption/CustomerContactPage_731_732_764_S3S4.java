/*package pages.Encryption;

import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.automation.framework.utilities.ObjectRead;
import com.pge.COC.ReUsable.utility.GenericUtilities;

public class CustomerContactPage_731_732_764_S3S4 extends BasePage {
	WebDriver driver;
	HashMap<String, String> localData;
	ObjectRead objectRead;

	private By usernameFldLocator = By.id("username");
	private By passwordFldLocator = By.id("password");
	// WI with data like customer contact and ABAC.
	private By WINumberLocator = By.xpath("//*[contains(text(),'00438051')]");

	private By AsBilledAmountLocator = By.id("00No0000008cglP");
	private By AsCorrectedAmountLocator = By.id("00No0000008cglT");
	private By BilledDateFromLocator = By.id("00No0000008cglR");
	private By BilledDateToLocator = By.id("00No0000008cglS");
	private By CustomerAjAmountLocator = By.id("Case.00Nq0000001eZPe-_help");

	private By customerContactInputEle = By.xpath("//*[@id='00Nq0000000ZKwc']");
	@FindBy(xpath = "//*[@id=\"00Nq0000000ZKwP\"]")
	WebElement addToCCbCaseLogCheckBoxEle;
	@FindBy(xpath = "//*[contains(text(),'Completed')]")
	WebElement WIStatus;

	@FindBy(xpath = "//select[@id=\"00Nq0000000iAXY\"]")
	private WebElement soxReqInfoEle;
	@FindBy(xpath = "(//a[contains(text(),'RR')])[position()=1]")
	private WebElement viewContactEle;
	@FindBy(xpath = "//*[@name=\"view_cc_b_customer_contact\"]")
	private WebElement viewCCBContactBtnEle;
	@FindBy(xpath = "(//*[@value=' Edit '])[position()=1]")
	private WebElement editWIBtnEle;
	@FindBy(xpath = "//*[@name=\"save\"]")
	private WebElement saveBtnEle;

	@FindBy(xpath = "//*[contains(text(),'Work Items about to ')]")
	private WebElement WIsaveSuccessfullConfirmEle;
	@FindBy(xpath = "//*[@id=\"00Nq00000017pTa_chkbox\"]")
	private WebElement customerContactLogWithABACCheckboxele;
	@FindBy(xpath = "//*[@id='00Nq0000000jVKC_ileinner']")
	private WebElement cclogText;

	// CCB login details
	@FindBy(xpath = "//*[@id=\"userId\"]")
	private WebElement CCBUserIdEle;
	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement CCBPasswordEle;
	@FindBy(xpath = "//input[@id=\"loginButton\"]")
	private WebElement CCBLoginBtn;

	@FindBy(xpath = "//div[@id=\"00Nq0000000ZKwc_ileinner\"]")
	private WebElement customerIdMainPageEle;

	@FindBy(xpath = "//*[@id=\"PER_ID\"]")
	private WebElement personIDCCBScreenEle;

	@FindBy(xpath = "(//*[contains(text(),'Edit')])[position()=3]")
	private WebElement relatedRecordEditlinkEle;

	@FindBy(xpath = "//*[@id=\"00Nq00000017pTZ\"]")
	private WebElement correctionCheckBoxEle;

	// SOX information field locators.
	@FindBy(xpath = "//*[@id=\"00No0000008cglY\"]")
	private WebElement billedToAmountEle;
	@FindBy(xpath = "//*[@id=\"00No0000008cglX\"]")
	private WebElement billedFromDateEle;
	@FindBy(xpath = "//*[@id=\"00No0000008cglZ\"]")
	private WebElement billedToDateEle;

	@FindBy(xpath = "(//td[@class=\" dataCell  \"])[position()=1]")
	private WebElement CustContactLogEntryEle;

	// @FindBy(xpath = "(//*[contains(text(),'RR-')])[position()=1]")
	@FindBy(xpath = "(//*[contains(text(),'RR-')])")
	private WebElement customerRelatedRecNamEle;

	@FindBy(xpath = "(//*[contains(text(),'CC LOG-')])[position()=1]")
	private WebElement customerContactLogNameEle;

	@FindBy(xpath = "//*[@name=\"view_cc_b_customer_contact\"]")
	private WebElement viewCCBCustomerContactEle;

	@FindBy(xpath = "(//*[@aria-labelledby=\"D_L_CC_LOG_CONTENT\"])[position()=1]//..")
	private WebElement CCLogStatementEle;
	@FindBy(xpath = "//*[contains(text(),'CC LOG-')]")
	private WebElement CCLOGNumberEle;
	@FindBy(xpath = "//*[contains(text(),'As Billed/Corrected From:')]")
	private WebElement CCLOGEntryTextEle;

	@FindBy(xpath = "//*[@title='Log']")
	private WebElement LogTabCCBele;

	public CustomerContactPage_731_732_764_S3S4(WebDriver driver, HashMap<String, String> localData) throws Exception {
		this.driver = driver;
		this.localData = localData;
		this.waitForPageLoad(driver);
		objectRead = new ObjectRead(this.getClass().getSimpleName());
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(WebDriver driver, String userName) {
		enterValue(driver, usernameFldLocator, userName);
	}

	public void enterPassword(WebDriver driver, String password) {
		enterValue(driver, passwordFldLocator, password);
	}

	public void clickOnWIWithStatusBWO(WebDriver driver, By loc) {
		driver.findElement(loc).click();
	}

	public CustomerContactPage_731_732_764_S3S4 loginIntoApplication(Hashtable<String, String> testData)
			throws Exception {

		Reporter.log("Step 1 Started- Loginto application");
		try {
			String username = getTestDataValue("CSR_User");
			String password = getTestDataValue("CSR_Password");
			enterUsername(driver, username);
			enterPassword(driver, password);
			// COC.webAdaptor(Actions.setValueToXpathAndClick, "Login");
			driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
			Thread.sleep(4000);

			Reporter.log("Step 1 completed. Successfully logged into application");

		} catch (Exception E) {

			Reporter.log("Step 1- login failed");
		}
		return this;
	}

	public CustomerContactPage_731_732_764_S3S4 clickOnWorkItems() throws Exception {
		COC.webAdaptor(Actions.setValueToXpathAndClick, "HomeTab");
		COC.webAdaptor(Actions.setValueToXpathAndClick, "WorkItemsTab");

		GenericUtilities util = new GenericUtilities();

		WebElement homebutton = driver.findElement(By.xpath("//*[@href=\"/home/home.jsp\"]"));

		util.click(homebutton);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Work Items')]")).click();

		return this;
	}

	public CustomerContactPage_731_732_764_S3S4 selectMyWI() throws Exception {
		Select dropdown = new Select(driver.findElement(By.id("fcf")));
		dropdown.selectByIndex(3);
		return this;
	}

	@SuppressWarnings("deprecation")
	public CustomerContactPage_731_732_764_S3S4 navigateToWI_AddContact(Hashtable<String, String> testData)
			throws Exception {

		GenericUtilities util = new GenericUtilities();

		// Step 13 started

		util.customAlertByJS("Step 13 started");
		Reporter.log("Step 13 started-Opening work item");
		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);

			Reporter.log("Step 13 passed- Work item opened successfully");
		} catch (Exception e) {

			Reporter.log(" Step 13 failed- unable to open work item");
		}

		// Step 14

		util.customAlertByJS(" Step 14 started");
		Reporter.log("Step 14 started");
		try {
			util.click(customerRelatedRecNamEle);
			String CCLOG = util.getText(CCLOGNumberEle);
			Reporter.log(" CCLOG Number is : " + CCLOG);
			util.click(CCLOGNumberEle);
			util.highlighElement(customerContactLogWithABACCheckboxele);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());
			util.highlighElement(cclogText);
			Assert.assertTrue(cclogText.isDisplayed());
			Reporter.log("CC log entry test is  :" + cclogText.getText());
			Reporter.log("Step 14 passed");

		} catch (AssertionError e) {

			Reporter.log("Step 14 failed" + e.getLocalizedMessage());
		}

		catch (Exception e) {

			Reporter.log("Step 14 failed" + e.getLocalizedMessage());
		}

		// Step 15

		util.customAlertByJS(" Step 15 started");
		Reporter.log("Step 15 started");
		try {
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);
			driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();
			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "2000");
			enterKeys(driver, AsCorrectedAmountLocator, "1000");
			enterKeys(driver, BilledDateFromLocator, "6/18/2018");
			enterKeys(driver, BilledDateToLocator, "6/18/2018");
			// enterKeys(driver, CustomerAjAmountLocator, "196");

			util.sendKeys(billedToAmountEle, "201");
			Thread.sleep(2000);
			util.sendKeys(billedFromDateEle, "6/18/2018");
			Thread.sleep(2000);
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "6/18/2018");
			billedToAmountEle.click();
			Thread.sleep(2000);
			if (correctionCheckBoxEle.isSelected() == false) {
				correctionCheckBoxEle.click();

			}

			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Thread.sleep(2000);
			Assert.assertTrue(WIsaveSuccessfullConfirmEle.isDisplayed());
			Reporter.log(" Step 15 passed");
		} catch (AssertionError e) {
			System.out.println(e);
			Reporter.log("Step 15 failed" + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e);
			Reporter.log("Step 15 failed" + e.getLocalizedMessage());
		}

		// Step 16

		util.customAlertByJS("Step 16 Execution started");
		Reporter.log(" Step 16 executed started");
		try {
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);
			util.click(customerRelatedRecNamEle);
			Thread.sleep(1000);
			String CCLOG1 = util.getText(CCLOGNumberEle);
			Reporter.log(" CCLOG Number is : " + CCLOG1);
			util.click(CCLOGNumberEle);
			util.highlighElement(customerContactLogWithABACCheckboxele);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());
			util.highlighElement(cclogText);
			Assert.assertTrue(cclogText.isDisplayed());
			Reporter.log("CC log entry test is  :" + cclogText.getText());
			Reporter.log(" Step 16 executed successfully");

		} catch (AssertionError e) {
			System.out.println(e);
			Reporter.log("Step 16 failed" + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println(e);
			Reporter.log("Step 16 failed" + e.getLocalizedMessage());
		}

		// Step 17 Scenario- Customer contact related record exists. Edit ABAC
		// info and close WI.

		util.customAlertByJS("Step 17 started");
		Reporter.log(" Step 17 Execution started");

		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();

			String WIwithoutCustCOntact2 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact3 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact2 + "')]"));

			util.click(WIwithoutContact3);
			Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Work Item Detail')]")).isDisplayed());

			Reporter.log(" Work item opened successfully");
			Reporter.log(" Step 17 passed");

		} catch (Exception e) {

			Reporter.log("Step 17 failed");
		}

		// Step 18

		util.customAlertByJS("Step 18 execution started");

		Reporter.log(" Step 18 execution started");
		try {
			driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();

			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "2000");
			enterKeys(driver, AsCorrectedAmountLocator, "1000");
			enterKeys(driver, BilledDateFromLocator, "6/18/2018");
			enterKeys(driver, BilledDateToLocator, "6/18/2018");
			// enterKeys(driver, CustomerAjAmountLocator, "196");

			util.sendKeys(billedToAmountEle, "201");
			util.sendKeys(billedFromDateEle, "6/18/2018");
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "6/18/2018");
			billedToAmountEle.click();
			Thread.sleep(1000);

			if (correctionCheckBoxEle.isSelected() == false) {
				correctionCheckBoxEle.click();

			}
			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Thread.sleep(2000);
			Reporter.log(" Step 18 executed successfully");
		} catch (Exception e) {

			Reporter.log("Step 18 failed");
		}

		// Step 19

		util.customAlertByJS("Step 19 execution started");
		Reporter.log("Step 19 execution started");
		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();

			String WIwithoutCustCOntact2 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact3 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact2 + "')]"));

			util.click(WIwithoutContact3);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@value=\"Close Work Item\"]")).click();

			WebElement statusDropdown = driver.findElement(By.xpath("//*[@id=\"cas7\"]"));
			util.selectByIndex(2, statusDropdown);

			WebElement postponeCredit = driver.findElement(By.xpath("//*[@id=\"00No0000008cgmD\"]"));
			util.selectByIndex(2, postponeCredit);

			WebElement subStatus = driver.findElement(By.xpath("//*[@id=\"00No0000008cgmk\"]"));
			util.selectByIndex(1, subStatus);

			WebElement rootCauseCategory = driver.findElement(By.xpath("//*[@id=\"00Nq0000000ZKwY\"]"));
			util.selectByIndex(5, rootCauseCategory);

			WebElement rootCausSUbCategory = driver.findElement(By.xpath("//*[@id=\"00No0000008cgmU\"]"));
			util.selectByIndex(2, rootCausSUbCategory);

			WebElement CustomerContactClass = driver.findElement(By.xpath("//*[@id=\"00No0000008cglg\"]"));

			util.selectByIndex(9, CustomerContactClass);

			WebElement CustContactType = driver.findElement(By.xpath("//*[@id=\"00No0000008cgll\"]"));

			util.selectByIndex(1, CustContactType);
			WebElement SOXReqInfo = driver.findElement(By.xpath("//*[@id=\"00Nq0000000iAXV\"]"));

			util.selectByIndex(1, SOXReqInfo);

			if (addToCCbCaseLogCheckBoxEle.isSelected() == false) {

				util.click(addToCCbCaseLogCheckBoxEle);
			}

			WebElement WICloseSaveBtn = driver.findElement(By.xpath("//*[@value=\" Save \"]"));

			util.click(WICloseSaveBtn);
			util.highlighElement(WIStatus);
			Assert.assertTrue(WIStatus.isDisplayed());
			Thread.sleep(1000);
			Reporter.log("Work item closed successfully");
			Reporter.log(" Step 19 executed successfully");

		} catch (AssertionError e) {
			Reporter.log("Step 19 failed" + e.getLocalizedMessage());
		} catch (Exception e) {
			Reporter.log("Step 19 failed" + e.getMessage());
		}

		// Step 20
		util.customAlertByJS(" Step 20 started");

		Reporter.log("Step 20 started");

		try {
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();

			String WIwithoutCustCOntact2 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact3 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact2 + "')]"));

			util.click(WIwithoutContact3);

			util.click(customerRelatedRecNamEle);
			Reporter.log("Related record name clicked");

			util.highlighElement(CustContactLogEntryEle);
			Assert.assertTrue(CustContactLogEntryEle.isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'CC LOG-')]")).isDisplayed());
			Reporter.log("Log Entry text is :" + CustContactLogEntryEle.getText());
			Reporter.log("Related record verification done");

			util.click(CCLOGNumberEle);
			Thread.sleep(1000);
			util.highlighElement(customerContactLogWithABACCheckboxele);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());

			driver.navigate().back();

			Reporter.log(" Step 20 executed successfully");

		} catch (AssertionError e) {
			Reporter.log("Step 20 failed" + e.getLocalizedMessage());
		} catch (Exception e) {
			Reporter.log("Step 20 failed" + e.getMessage());
		}

		// step 21

		util.customAlertByJS("Step 21 started");
		Reporter.log(" Step 21 started- Comparing Customer contact records and logs in SFDC & CC&B");

		try {
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();

			String WIwithoutCustCOntact4 = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact4 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact4 + "')]"));

			util.click(WIwithoutContact4);
			util.click(customerRelatedRecNamEle);

			util.click(CCLOGNumberEle);
			String CClogLogID = driver.findElement(By.xpath("//*[@id=\"00Nq0000000jVKD_ileinner\"]")).getText();
			driver.navigate().back();
			util.click(viewCCBContactBtnEle);
			util.switchToTab(1);

			try {

				util.CCBLogin(CCBUserIdEle, CCBPasswordEle, CCBLoginBtn);
				Reporter.log("CCB login done");
			}

			catch (Exception e) {

				Reporter.log("CCB already logged in");
			}
			driver.switchTo().defaultContent();

			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame("tabMenu");
			Thread.sleep(2000);

			util.click(LogTabCCBele);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame("tabPage");
			Thread.sleep(2000);

			String CCBLOGID = driver.findElement(By.xpath("//*[@name=\"CC_LOG$CC_LOG_ID\"]")).getText();

			Assert.assertEquals(CClogLogID, CCBLOGID);
			Reporter.log(
					"Step 21 complete-Customer contact records and logs comparion between SFDC & CC&B was successfull");

		}

		catch (AssertionError e) {

			Reporter.log("Step 21 failed: " + e);

		}

		catch (Exception e) {

			Reporter.log("Step 21 failed: " + e);

		}

		return this;
	}

}
*/