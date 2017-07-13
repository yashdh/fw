package com.volaris.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonClassesReusable.BrowserSelection;
import commonClassesReusable.ByXpath;
import commonClassesReusable.ReadPropertyFile;

import com.aventstack.extentreports.Status;
import com.volaris.commonMethods.Functionality;


public class Re10 extends BrowserSelection {

	

	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		extent.attachReporter(htmlReporter);
	}

	@Test
	public static void tc0121() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0121", "To verify the functionality of Join Vclub button at the top right.");
		ByXpath.click(joinVClubEle);
		if (!ByXpath.isObjectAvailable(vClubSignUpPageEle))
			Assert.fail("VClub signup page was not found!");
		else
			Assert.assertTrue(true);

	}

	@Test
	public static void tc0122() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0122","To verify the First Name of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("fNameStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0123() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0123","To verify the First Name of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(fNameStdELe, ReadPropertyFile.read("fNameStd1"));
		ByXpath.click(clickOutsideOfTheFrm);
		if (!ByXpath.getInnerHTML(fNameStdErrMsgEle).contains("[vClubMembershipRegistration"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}

	@Test
	public static void tc0126() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0126", "To verify the last Name of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(lNameStdEle, ReadPropertyFile.read("lNameStd1"));
		ByXpath.click(clickOutsideOfTheFrm);
		if (!ByXpath.getInnerHTML(lNameStdErrMsgEle).contains("[vClubMembershipRegistration"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0128() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0128", "To verify the Birth Date of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("bDayStd", "");
		if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0150() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0150", "To verify the Country of the User.");
		ByXpath.click(joinVClubEle);
		TreeSet<String> ts = new TreeSet<>();
		String country = "";
		Iterator<WebElement> itr = driver.findElements(By.xpath(countryListEle)).iterator();
		System.out.println(driver.findElements(By.xpath(countryListEle)).size());
		while (itr.hasNext()) {
			
			country = itr.next().getText().trim();
			System.out.println(country);
			if (!country.equals("Country*") && !country.equals("Mexico") && !country.equals("Guatemala")
					&& !country.equals("Costa Rica") && !country.equals("Puerto Rico")
					&& !country.equals("United States Of America")) {
				ts.add(country);
			}
		}

		ts.forEach(System.out::println);
		System.out.println(ts.size());
	}
	
	@Test
	public static void tc0153() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0153", "To verify the Email of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("emailIDStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0154() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0154", "To verify the Email of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(emailIDStdEle, ReadPropertyFile.read("emailIDStd1"));
		driver.findElement(By.xpath(confrmEmailIDStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(emailIDStdErrMsgEle).contains("Email format"))
			Assert.assertTrue(true);
		else
			Assert.fail("Error message found after submitting!");
	}
	
	@Test
	public static void tc0155() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0155", "To verify the Confirm Email of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("confirmEmailIDStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0156() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0156", "To verify the Confirm Email of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(confrmEmailIDStdEle, ReadPropertyFile.read("confrmEmailIDStd1"));
		driver.findElement(By.xpath(pswdStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(misMatchEmailIDErrMsgEle).contains("Email mism"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0157() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0157", "To verify the password of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("pswdStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0158() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0158", "To verify the password of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(pswdStdEle, ReadPropertyFile.read("pswdStd1"));
		driver.findElement(By.xpath(confrmPswdStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(pswdStdErrMsgEle).contains("Invalid password"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0159() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0159", "To verify the Confirm password of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("confrmPasswdStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0160() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0160", "To verify the Confirm password of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(confrmPswdStdEle, ReadPropertyFile.read("confrmPswdStd1"));
		driver.findElement(By.xpath(addrsStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(confrmPswdStdErrMsgEle).contains("Invalid password"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0161() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0161", "To verify the address of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("addrsStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0162() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0162", "To verify the address of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(addrsStdEle, ReadPropertyFile.read("addrsStd1"));
		driver.findElement(By.xpath(postlCdeStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(addrsStdErrMsgEle).contains("characters allowed"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0163() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0163", "To verify the postal code of the User.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("postlCdeStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0164() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0164", "To verify the postal code of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(postlCdeStdEle, ReadPropertyFile.read("postlCdeStd1"));
		driver.findElement(By.xpath(stateOfCntryStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(postlCdeErrMsgEle).contains("characters allowed"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0165() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0165", "To verify the State of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("stateOfCntryStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0166() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0166", "To verify the City of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("cityOfStateStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0167() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0167", "To verify the City of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(cityOfStateStdEle, ReadPropertyFile.read("cityOfStateStd1"));
		driver.findElement(By.xpath(cntryCodeStdEle)).sendKeys(Keys.TAB);
		if (!ByXpath.getInnerHTML(cityOfStateStdErrMsgEle).contains("characters allowed"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0170() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0170", "To verify the Telephone of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("phoneStd", "");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0171() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0171", "To verify the Telephone of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		ByXpath.sendKeys(phoneStdEle, ReadPropertyFile.read("phoneStd1"));
		driver.findElement(By.xpath(chckBxStdEle)).click();
		if (!ByXpath.getInnerHTML(phoneStdErrMsgEle).contains("characters allowed"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0172() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0172", "To verify the Telephone of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		test.log(Status.INFO, "Entering password less than 10 digits.");
		Functionality.fillDetails("phoneStd", "123456");
		try{
			if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
				Assert.fail("Error message found after submitting!");
			else
				Assert.assertTrue(true);
		} catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public static void tc0173() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0173", "To verify the check button for Terms and Conditions and Privacy Policy");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("", "");

		if (!ByXpath.getInnerHTML(membershipSelectionPageEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0176() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0176", "To verify the Create Account button");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("cardNoStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0177() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0177", "To verify the Card Number");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0178() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0178", "To verify the Card Number with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("cardNoStd", "4111111111111112");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0179() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0179", "To verify the Expiration Date of Card Number");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0180() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0180", "To verify the Expiration Date of Card Number with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("yearStd", "2019");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0181() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0181", "To verify the CVV number of Card Number");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0182() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0182", "To verify the CVV number of Card Number with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("cvvStd", "738");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0183() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0183", "To verify the valid card number");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0184() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0184", "To verify the Use Primary Information check box");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0187() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0187", "To verify Address Line 1");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("adrs1Std", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0190() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0190", "To verify the Country of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("countryCustStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0191() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0191", "To verify the State of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("stateStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0192() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0192", "To verify the City of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("cityStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0193() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0193", "To verify the City of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("cityStd", "344555fvfbgnhdfvbffv");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0194() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0194", "To verify the Postal Code of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("zipCodeStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0195() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0195", "To verify the Email of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("emailStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0196() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0196", "To verify the Email of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("", "");
		ByXpath.sendKeys(cardNoStdEle, ReadPropertyFile.read("cardNoStd"));
		ByXpath.sendKeys(emailStdEle, ReadPropertyFile.read("emailStd1"));
		driver.findElement(By.xpath(cntryCodeCardStdEle)).click();
		if (!ByXpath.getInnerHTML(emailStdErrMsgEle).contains("Email format"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0199() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0199", "To verify the Telephone of the User");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("phoneNumberStd", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0200() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0200", "To verify the Telephone of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillDetails("", "");
		ByXpath.sendKeys(cardNoStdEle, ReadPropertyFile.read("cardNoStd"));
		ByXpath.sendKeys(phoneNumberStdEle, ReadPropertyFile.read("phoneNumberStd1"));
		driver.findElement(By.xpath(phoneTextPymntStdEle)).click();
		System.out.println(ByXpath.getText(phoneNumberStdErrMsgEle));
		if (ByXpath.getText(phoneNumberStdErrMsgEle).contains("Digits Allowed"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0201() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0201", "To verify the Telephone of the User with incorrect test data.");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("phoneNumberStd", "12345");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0202() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0202", "To verify the check box against I accept Reccurring Charge to my Card.");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0203() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0203", "To verify the check box of reCaptcha");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public static void tc0204() throws InterruptedException {
		test = extent.createTest("Test case ID: reg0204", "To verify the Buy Membership button");
		ByXpath.click(joinVClubEle);
		Functionality.fillCardDetails("", "");
		if (!ByXpath.getInnerHTML(paymentPageStdEle).contains("Error"))
			Assert.fail("Error message found after submitting!");
		else
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
			driver.navigate().to(ReadPropertyFile.read("standAloneURL"));
			driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
		}
	}

}
