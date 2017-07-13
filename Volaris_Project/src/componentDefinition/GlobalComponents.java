package componentDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface GlobalComponents 
{
	
	//JS Executor 
	
	boolean jsExecutor = false;
	String browser = "GC";
	// Define Global Variables
    DateFormat df = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
	Date dateobj = new Date();
	String commonData="testData.properties";
	String gerkoPath =System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
	String chromePath =System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	String iePath =System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe";
	String phantomPath =System.getProperty("user.dir")+"\\Drivers\\phantomjs.exe";
	String extentReportPath =System.getProperty("user.dir")+"\\ExtentReport\\ExtentReport"+df.format(dateobj)+".html";
	String screenshotPath =System.getProperty("user.dir")+"\\ExtentReport\\Screenshots\\ExtentReport"+df.format(dateobj)+".png";

}
