package com.volaris.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.volaris.commonMethods.Functionality;
import commonClassesReusable.BrowserSelection;
import commonClassesReusable.ReadPropertyFile;

import org.testng.*;

public class TestCaseClass extends BrowserSelection {

	@BeforeTest(alwaysRun = true)
	public static void navigation() {
		driver.get(ReadPropertyFile.read("applicationURL"));
		driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		extent.attachReporter(htmlReporter);
	}

	@Test(groups = "Domestic")
	public void reg001() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg001",
				"Domestic flight Card Payment in MXN currency with baggage and trip extras.");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting Trip extras and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with card.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg002() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg002", "Domestic flight Agency Payment in MXN currency.");
		test.log(Status.INFO, "Logging in with Agency User.");
		Functionality.login("agency");
		test.log(Status.INFO, "Setting up language to US.");
		Functionality.selectCulture("US");
		test.log(Status.INFO, "Searching for single flight.");
		Functionality.singleTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting single flight!");
		Functionality.selectFlightOneWay();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatOneWay();
		test.log(Status.INFO, "Default trip extras page.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "Filling payment info with card.");
		Functionality.payment();
		test.log(Status.INFO, "Logging out the Agnecy user.");
		Functionality.agencyAcntLogout();
		Assert.assertTrue(true);
	}

	@Test(groups = "International")
	public void reg003() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg003",
				"International flight Voucher Payment in MXN currency with multiple PAX with baggage and trip extras");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearchIntnl("1", "1", "1");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult, 1 minor and 1 infant.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting trip extras and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "Default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with electranics card.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "International")
	public void reg004() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg004",
				"International flight Card Payment with Vclub login in MXN currency with baggage");
		test.log(Status.INFO, "Logging in with VClub member.");
		Functionality.login("member");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCulture("US");
		test.log(Status.INFO, "Searching for single flight.");
		Functionality.singleTripSearchIntnl("1", "0", "0");
		test.log(Status.INFO, "Selecting single flight.");
		Functionality.selectFlightOneWay();
		test.log(Status.INFO, "Selecting combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatOneWay();
		test.log(Status.INFO, "Default Trip extras page.");
		Functionality.tripExtras("");
		test.log(Status.INFO, "Filling payment info with card.");
		Functionality.payment();
		test.log(Status.INFO, "Logging out the user.");
		Functionality.vClubAcntLogout();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg005() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg005",
				"Domestic flight Third Party Payment in MXN currency with multiple PAX with trip extras");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("2", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Default combo page.");
		Functionality.comboSelection("");
		test.log(Status.INFO, "Filling pax info for 2 adults.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Default Baggage info.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting Trip extras and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with third party.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg006() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg006",
				"Domestic flight Paypal Payment in MXN currency with multiple PAX with baggage and Hotel");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("0", "2", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 2 minors.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting hotal");
		Functionality.tripExtras("");
		test.log(Status.INFO, "car page is not showing for minor");
		test.log(Status.INFO, "Filling payment info with paypal.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg007() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg007",
				"Domestic flight Visa Checkout Payment in MXN currency with multiple PAX with baggage, trip extras and Activities");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("9", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 9 pax.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting trip extras, activities and bundle.");
		Functionality.tripExtras("TripAssistance,Activities");
		test.log(Status.INFO, "default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with visa checkout.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg008() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg008",
				"Domestic flight Visa Checkout Payment in MXN currency with multiple PAX with baggage, trip extras and Activities");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Default Trip extras page.");
		Functionality.tripExtras("");
		test.log(Status.INFO, "Selecting car.");
		Functionality.car("selectCar");
		test.log(Status.INFO, "Filling payment info with MasterPass.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg009() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg009",
				"Domestic flight Masterpass Payment in MXN currency with baggage, Hotal and Cars");
		test.log(Status.INFO, "Setting up currency to MXND.");
		Functionality.selectCurrency("MXND");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting hotal, activities, bundle and trip extras.");
		Functionality.tripExtras("TripAssistance,Activities");
		test.log(Status.INFO, "Selecting car.");
		Functionality.car("selectCar");
		test.log(Status.INFO, "Filling payment info with agency.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg010() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg010", "Domestic flight Card Payment in USD currency with baggage");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, " default Trip extras page.");
		Functionality.tripExtras("");
		test.log(Status.INFO, "Default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with card.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg011() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg011",
				"Domestic flight Agency Payment in USD currency with trip extras");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching for single flight.");
		Functionality.singleTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting single flight!");
		Functionality.selectFlightOneWay();
		test.log(Status.INFO, "Default Combo page.");
		Functionality.comboSelection("");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Default Baggage info.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatOneWay();
		test.log(Status.INFO, "Selecting trip extras and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "Default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with agency.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "International")
	public void reg012() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg012",
				"International flight Voucher Payment in USD currency with multiple PAX with baggage");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearchIntnl("1", "1", "1");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult, 1 minor and 1 infant.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Default Trip extras page.");
		Functionality.tripExtras("");
		test.log(Status.INFO, "Default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with electranic card.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "International")
	public void reg013() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg013",
				"International flight Card Payment with Vclub login in USD currency with baggage and trip extras");
		test.log(Status.INFO, "Logging in with VClub.");
		Functionality.login("member");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCulture("US");
		test.log(Status.INFO, "Searching for single flight.");
		Functionality.singleTripSearchIntnl("1", "0", "0");
		test.log(Status.INFO, "Selecting single flight!");
		Functionality.selectFlightOneWay();
		test.log(Status.INFO, "Selecting Combo.");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatOneWay();
		test.log(Status.INFO, "Selecting tripAssistance and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "Filling payment info with VClub.");
		Functionality.payment();
		test.log(Status.INFO, "Logging out the user.");
		Functionality.vClubAcntLogout();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg014() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg014",
				"Domestic flight Third Party Payment in USD currency with multiple PAX");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("2", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Default Combo page.");
		Functionality.comboSelection("");
		test.log(Status.INFO, "Filling pax info for 2 adults.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Default Baggage info.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, " default tripAssistance page.");
		Functionality.tripExtras("");
		test.log(Status.INFO, "Default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with third party.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg015() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg015",
				"Domestic flight Paypal Payment in USD currency with multiple PAX with baggage,trip extras and Hotel");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("0", "2", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting combo");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling info for 2 minor pax.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting baggage");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting tripAssistance, hotal and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "car page is not showing for minor");
		test.log(Status.INFO, "Filling payment info with paypal.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg016() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg016",
				"Domestic flight Visa Checkout Payment in USD currency with multiple PAX with baggage, trip extras and Activities");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("9", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting combo");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling info for 9 pax.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, " Selecting Activities.");
		Functionality.tripExtras("Activities");
		test.log(Status.INFO, "Default car page.");
		Functionality.car("");
		test.log(Status.INFO, "Filling payment info with visa checkout.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg017() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg017",
				"Domestic flight Visa Checkout Payment in USD currency with multiple PAX with baggage, trip extras and Activities");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting combo");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selcting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selcting trip extras and bundle.");
		Functionality.tripExtras("TripAssistance");
		test.log(Status.INFO, "Selecting car.");
		Functionality.car("selectCar");
		test.log(Status.INFO, "Filling payment info with MasterPass.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@Test(groups = "Domestic")
	public void reg018() throws InterruptedException, IOException {
		test = extent.createTest("Test case ID: reg018",
				"Domestic flight Visa Checkout Payment in USD currency with multiple PAX with baggage, trip extras and Activities");
		test.log(Status.INFO, "Setting up currency to USD.");
		Functionality.selectCurrency("USD");
		test.log(Status.INFO, "Searching round trip flight.");
		Functionality.roundTripSearch("1", "0", "0");
		test.log(Status.INFO, "Selecting flight for round trip.");
		Functionality.selectFlightRoundTrip();
		test.log(Status.INFO, "Selecting combo");
		Functionality.comboSelection("bag");
		test.log(Status.INFO, "Filling pax info for 1 adult.");
		Functionality.fillPaxinfoAll();
		test.log(Status.INFO, "Selecting Baggage.");
		Functionality.customerBaggage();
		test.log(Status.INFO, "Selecting default seat.");
		Functionality.seatRoundTrip();
		test.log(Status.INFO, "Selecting hotel and activities.");
		Functionality.tripExtras("Activities");
		test.log(Status.INFO, "Selecting car.");
		Functionality.car("selectCar");
		test.log(Status.INFO, "Filling payment info.");
		Functionality.payment();
		Assert.assertTrue(true);
	}

	@AfterMethod(alwaysRun = true)
	public void setupEnv(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Testcase failed.");
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(screenshotPath));
			test.fail("Testcase failed.").addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test case was skipped.");
		} else
			test.pass("Test case was passed.");
		{
			driver.navigate().to(ReadPropertyFile.read("applicationURL"));
			driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
		}
	}

}
