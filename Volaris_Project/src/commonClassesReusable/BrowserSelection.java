package commonClassesReusable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.volaris.pageFactory.CarPage;
import com.volaris.pageFactory.ComboPage;
import com.volaris.pageFactory.CustomerPage;
import com.volaris.pageFactory.HomePage;
import com.volaris.pageFactory.LoginPage;
import com.volaris.pageFactory.PaxInfoPage;
import com.volaris.pageFactory.PaymentPage;
import com.volaris.pageFactory.SeatSelectionPage;
import com.volaris.pageFactory.SelectFlightPage;
import com.volaris.pageFactory.StandAloneVClubPage;
import com.volaris.pageFactory.TripExtrasPage;
import componentDefinition.GlobalComponents;

public class BrowserSelection implements LoginPage, ComboPage,GlobalComponents,HomePage,SelectFlightPage,PaxInfoPage,CustomerPage,SeatSelectionPage,TripExtrasPage,PaymentPage,CarPage,StandAloneVClubPage {	

	public static WebDriver driver;
	public static WebElement element;
	public static WebDriver globalSeleniumInstance;
	public static Logger log1 = Logger.getLogger("rootLogger");
//	
	public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportPath);
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	
	
	
	
	
	
	
	@BeforeClass
	@Parameters({"browserName"})
	public static WebDriver beforeSuite(String browserName) throws IOException {
		System.out.println("Before Suite");
//			
//		Selecting browser
		switch (browserName) {
		case "PJS":
			System.out.println("Running PhantomJS");
			System.setProperty("phantomjs.binary.path", phantomPath);
			driver = new PhantomJSDriver();
			break;
//
		case "MF":
			log1.info("Running FireFox");
			System.setProperty("webdriver.gecko.driver", gerkoPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
//
		case "GC":
			System.setProperty("webdriver.chrome.driver", chromePath);
			System.out.println("Running Chrome");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(ReadPropertyFile.read("standAloneURL"));
			driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
			break;
//
		case "IE":
			System.setProperty("webdriver.ie.driver", iePath);
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(dc);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
//
		case "AS":
			System.setProperty("webdriver.safari.driver", "Browser_Files\\SafariSetup.exe");
			System.out.println("Running Safari");
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
//
		default:
			System.out.println("Running FireFox");
			log1.info("Running FireFox");
			System.setProperty("webdriver.gecko.driver", gerkoPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		} 
		return driver;
	}

	@AfterSuite(alwaysRun = true)
	public void quitDriver() {
		extent.flush();
		log1.info("Exiting browser.");
		driver.quit();
	}
}
