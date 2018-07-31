package BaseClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import constants.Constants;
import utilities.FileOperations;

public class Driver {

	public static WebDriver driver = null;

	public static String getRootPath() {
		return System.getProperty("user.dir");

	}

	public static String getBrowserType() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "browserName");
	}

	public String getUrl() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "url");
	}

	public String getUsername() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "username");
	}

	public String getPassword() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "password");
	}

	public String getUrlBA() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "urlBA");
	}

	public String getUsernameBA() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "usernameBA");
	}

	public String getPasswordBA() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "passwordBA");
	}

	// salesforce login as CSR
	public String getUrlTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "urlTestSalesforce");
	}

	public String getUsernameCSRTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "usernameCSRTestSalesforce");
	}

	public String getPasswordCSRTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "passwordCSRTestSalesforce");
	}

	// salesforce login as Admin
	public String getUsernameAdminTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "usernameAdminTestSalesforce");
	}

	public String getPasswordAdminTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "passwordAdminTestSalesforce");
	}
	// CCB login details

	public String CCBLoginUserName() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "CCBUserID");
	}

	public String CCBLoginUserPassword() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "CCBPassword");
	}

	public void writeErrorInLogFile(LogEntries logEntries, String currentURL) throws IOException {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		fileOperations.writeJSErrorInLogFile(constants.CONFIG_WEB_ERROR_LOG_PATH, logEntries, currentURL);
	}

	@SuppressWarnings("deprecation")
	public static WebDriver createDriver() throws IOException {
		String browserName = getBrowserType();
		if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("ch")) {
			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "src/../libs/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			// driver = new ChromeDriver(cap);

			driver = new ChromeDriver(chromeCapabilities);
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("internet explorer") || browserName.equalsIgnoreCase("ie")) {

			try {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\c4p4\\workspace\\complexbilling\\libs\\IEDriverServer_64.exe");
				/*DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				
				//capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://test.salesforce.com/");
				
				// capabilities=Configuration.browserCapabilities();
				
				
				 driver = new InternetExplorerDriver(capabilities);
				 driver.get("https://test.salesforce.com/");*/

				/*	
				    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //disable protected mode settings
				 
				    caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				    caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
				    caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				    caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				  //  caps.setCapability(InternetExplorerDriver., false);
				    // caps.setCapability("initialBrowserUrl", "https://test.salesforce.com/");
				    caps.setJavascriptEnabled(true);
				    caps.acceptInsecureCerts();
				    driver = new InternetExplorerDriver(caps);*/

				DesiredCapabilities objIEDesiredCapabilities = DesiredCapabilities.internetExplorer();
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				objIEDesiredCapabilities
						.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				
				//objIEDesiredCapabilities.setCapability("ignoreProtectedModeSettings", true);
				

				//objIEDesiredCapabilities.setCapability("allow-blocked-content", true);
				//objIEDesiredCapabilities.setCapability("allowBlockedContent", true);
				//objIEDesiredCapabilities.setJavascriptEnabled(false);
				
				driver = new InternetExplorerDriver(objIEDesiredCapabilities);

				System.out.println(driver);
				driver.manage().window().maximize();
			}

			catch (Exception e) {

				e.printStackTrace();
			}

		}
		return driver;
	}

	public WebDriver getCurrentWebDriver() {
		return driver;
	}

}