package iProgrammer_UTechIFA_BasePackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import iProgrammer_UTechIFA_Utility.ExcelFileReader;

public class BaseInit {

	public static WebDriver driver;
	public static Logger loggs;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static Wait<WebDriver> waitFluent;
	public static Properties sitedata;
	public static Properties objectstorage;
	public static Properties objectstorage2d;
	public static Properties objectstorage3d;
	public static Properties objectstoragerwh;
	public static Properties objectstorageatt;
	public static Properties objectstoragevastucheck;
	public static Properties objectstoragedetailedestimation;
	public static Properties objectstoragefinancialservices;
	public static Properties objectstorageasktheexpert;
	public static Properties objectStorageOnSiteConsulting;
	public static Properties objectstorageMCL;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static MultiPartEmail email;
	public static ExcelFileReader sr2dlayout;
	public static ExcelFileReader sr3dlayout;
	public static ExcelFileReader rwh;
	public static ExcelFileReader att;
	public static ExcelFileReader VastuCheck;
	public static ExcelFileReader DetailedEstimation;
	public static ExcelFileReader FinancialServices;
	public static ExcelFileReader AskTheExpert;
	public static ExcelFileReader onSiteConsulting;
	public static ExcelFileReader MCL;

	public void startUP() throws Exception {

		if (driver == null) {

			// Log4j configuration.
			loggs = Logger.getLogger("devpinoyLogger");

			// Properties file configuration.
			loggs.info("Sitedata propertifiles goining to configur");
			sitedata = new Properties();
			FileInputStream sitedatafile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/resources/iProgrammer_UTechIFA_PropertiesData/SiteData.properties");
			sitedata.load(sitedatafile);
			loggs.info("sitedata propertifiles configured sucessfully");

			loggs.info("objectstorage propertifiles goining to configur");
			objectstorage = new Properties();
			FileInputStream objectstoragefile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorage.properties");
			objectstorage.load(objectstoragefile);
			loggs.info("objectstorage propertifiles configured sucessfully");

			loggs.info("objectstorage2d propertifiles goining to configur");
			objectstorage2d = new Properties();
			FileInputStream objectstorage2Dfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorage2D.properties");
			objectstorage2d.load(objectstorage2Dfile);
			loggs.info("objectstorage2d propertifiles configured sucessfully");

			loggs.info("objectstorage3d propertifiles goining to configur");
			objectstorage3d = new Properties();
			FileInputStream objectstorage3Dfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorage3D.properties");
			objectstorage3d.load(objectstorage3Dfile);
			loggs.info("objectstorage3d propertifiles configured sucessfully");

			loggs.info("objectstoragerwh propertifiles goining to configur");
			objectstoragerwh = new Properties();
			FileInputStream objectstoragerwhfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageRWH.properties");
			objectstoragerwh.load(objectstoragerwhfile);
			loggs.info("objectstoragerwh propertifiles configured sucessfully");

			loggs.info("objectstorageatt propertifiles goining to configur");
			objectstorageatt = new Properties();
			FileInputStream objectstorageattfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageATT.properties");
			objectstorageatt.load(objectstorageattfile);
			loggs.info("objectstorageatt propertifiles configured sucessfully");

			loggs.info("objectstorageVastuCheck propertifiles goining to configur");
			objectstoragevastucheck = new Properties();
			FileInputStream objectstoragevcfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageVastuCheck.properties");
			objectstoragevastucheck.load(objectstoragevcfile);
			loggs.info("objectstorageVastuCheck propertifiles configured sucessfully");
			
			loggs.info("objectstorageDetailEstimation propertifiles goining to configur");
			objectstoragedetailedestimation = new Properties();
			FileInputStream objectstoragedefile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageDetailedEstimation.properties");
			objectstoragedetailedestimation.load(objectstoragedefile);
			loggs.info("objectstorageDetailEstimation propertifiles configured sucessfully");


			loggs.info("objectstoragefinancialservices propertifiles goining to configur");
			objectstoragefinancialservices = new Properties();
			FileInputStream objectstoragefcfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstoragefinancialservices.properties");
			objectstoragefinancialservices.load(objectstoragefcfile);
			loggs.info("objectstoragefinancialservices propertifiles configured sucessfully");
			
			loggs.info("objectstorageasktheexpert propertifiles goining to configur");
			objectstorageasktheexpert = new Properties();
			FileInputStream objectstorageatefile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageAskTheExpert.properties");
			objectstorageasktheexpert.load(objectstorageatefile);
			loggs.info("objectstorageasktheexpert propertifiles configured sucessfully");

			loggs.info("objectStorageOnSiteConsulting propertifiles goining to configur");
			objectStorageOnSiteConsulting = new Properties();
			FileInputStream objectStorageOnSiteConsultingfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageOnsiteConsulting.properties");
			objectStorageOnSiteConsulting.load(objectStorageOnSiteConsultingfile);
			loggs.info("objectStorageOnSiteConsulting propertifiles configured sucessfully");

			loggs.info("objectstorageMCL propertifiles goining to configur");
			objectstorageMCL = new Properties();
			FileInputStream objectstorageMCLfile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_PropertiesData/objectstorageMCL.properties");
			objectstorageMCL.load(objectstorageMCLfile);
			loggs.info("getObjectstorageMCL propertifiles configured sucessfully");
			
			
			// Lunch the browser
			String browserVal = sitedata.getProperty("browser");

			if (browserVal.equalsIgnoreCase("firefox")) {

				loggs.info("Firefox browser is goining to lunch");
				System.setProperty("webdriver.gecko.driver", sitedata.getProperty("FirefoxDriver"));
				FirefoxOptions options = new FirefoxOptions();
				options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); // set the path to the Firefox binary file
				driver = new FirefoxDriver(options);
				loggs.info("Firefox browser is lunched sucessfully");

			} else if (browserVal.equalsIgnoreCase("chrome")) {


				loggs.info("Chrome browser is goining to lunch");
				if("MAC".equalsIgnoreCase(sitedata.getProperty("operatingSystem"))){
					System.setProperty("webdriver.chrome.driver", sitedata.getProperty("macChromeDriver"));
				}else {
					System.setProperty("webdriver.chrome.driver", sitedata.getProperty("windowsChromeDriver"));
				}
				ChromeOptions option = new ChromeOptions();
				option.setHeadless(false);
				option.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(option);
				loggs.info("Chrome browser is lunched sucessfully");

			} else {

				loggs.info("No browser defined..");

			}

			driver.manage().window().maximize();
			loggs.info("Browser window maximize");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 10sec wait to find element.

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			waitFluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

			// Excel file configuration.
			loggs.info("2D layout excel file going to be configur.");
			sr2dlayout = new ExcelFileReader(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_XLSFile/sr2dlayout.xlsx");
			loggs.info("2D layout excel file configured sucessfully");

			loggs.info("3D layout excel file goining to be configured");
			sr3dlayout = new ExcelFileReader(System.getProperty("user.dir")
					+ "/src/test/resources/iProgrammer_UTechIFA_XLSFile/sr3dlayout.xlsx");
			loggs.info("3D layout excel file configured sucessfully");

			rwh = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/rwh.xlsx");
			loggs.info("RWH excel file configured sucessfully");

			att = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/att.xlsx");
			loggs.info("ATT excel file configured sucessfully");
			
			VastuCheck = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/VastuCheck.xlsx");
			loggs.info("Vastu Check excel file configured sucessfully");
			
			DetailedEstimation = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/DetailedEstimation.xlsx");
			loggs.info("Vastu Check excel file configured sucessfully");
			
			FinancialServices = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/FinancialServices.xlsx");
			loggs.info("Financial Services excel file configured sucessfully");

			AskTheExpert = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/AskTheExperts.xlsx");
			loggs.info("Ask The Experts excel file configured sucessfully");

			onSiteConsulting = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/OnsiteConsulting.xlsx");
			loggs.info("On Site Consulting excel file configured sucessfully");

			MCL = new ExcelFileReader(
					System.getProperty("user.dir") + "/src/test/resources/iProgrammer_UTechIFA_XLSFile/mcl.xlsx");
			loggs.info("MCL excel file configured sucessfully");

			js = (JavascriptExecutor) driver;

		}
		// Advanced Report configuration.
		loggs.info("Advanced report goining to be configure");
		reporter.config().setDocumentTitle(sitedata.getProperty("documenttitle"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Reporter Name:", sitedata.getProperty("reportername"));
		extent.setSystemInfo("Server:", sitedata.getProperty("envirment"));
		loggs.info("Advanced report configured sucessfully");

	}

	// This method is use to get the syntax as per the requirement dynamically with
	// element value.
	public static WebElement isElementPresent(String propKey, Properties propfilename) {

		try {

			if (propKey.contains("xpath")) {

				return driver.findElement(By.xpath(propfilename.getProperty(propKey)));

			} else if (propKey.contains("linkText")) {

				return driver.findElement(By.linkText(propfilename.getProperty(propKey)));

			} else if (propKey.contains("id")) {

				return driver.findElement(By.id(propfilename.getProperty(propKey)));

			} else if (propKey.contains("name")) {

				return driver.findElement(By.name(propfilename.getProperty(propKey)));

			} else {

				System.out.println("No Browser Defined in the Properties File");

			}

		} catch (Exception e) {

		}
		return null;

	}

}
