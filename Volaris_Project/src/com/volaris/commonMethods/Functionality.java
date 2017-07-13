package com.volaris.commonMethods;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commonClassesReusable.BrowserSelection;
import commonClassesReusable.ByXpath;
import commonClassesReusable.Jexecutor;
import commonClassesReusable.RandomData;
import commonClassesReusable.ReadPropertyFile;
import commonClassesReusable.dynamicwait;

public class Functionality extends BrowserSelection {

	// Created by Yashal //
	// ***********************************************************************************//

	public static WebElement ele;
	public static String verifyHotel = "We are sorry";

	public static void selectMorePax(String adult, String minor, String infant) throws InterruptedException {
		Jexecutor.setAttributeValue(adultEle, "value", adult);
		Jexecutor.setAttributeValue(minorEle, "value", minor);
		Jexecutor.setAttributeValue(infantsEle, "value", infant);
	}

	public static void fillPaxinfoAll() throws InterruptedException {

		if (ByXpath.isObjectAvailable(paxPageEle)) {
			int paxCount = driver.findElements(By.xpath(passangerCountEle)).size();
			int j = 0;
			int infantCount = 0;
			if (paxCount >= 1) {

				for (int i = 1; i <= paxCount; i++) {
					ele = driver.findElement(By.xpath(".//*[@id='passengerForm']/div[1]/div[" + i + "]"));
					String switchTo = ByXpath.getAttributeValue(".//*[@id='passengerForm']/div[1]/div[" + i + "]",
							"aria-label");
					j = i - 1;
					switch (switchTo.substring(0, 6).trim()) {

					case "Adult":
						log1.info("Filling pax info");
						log1.info("Filling first name.");
						ByXpath.sendKeys(startXpath + j + endFNameEle, RandomData.getSaltString());
						log1.info("Filling last name.");
						ByXpath.sendKeys(startXpath + j + endLNameEle, RandomData.getSaltString());
						log1.info("Filling Month.");
						ByXpath.drpdwnByText(startXpath + j + endMonthEle, ReadPropertyFile.read("month"));
						log1.info("Filling Day.");
						ByXpath.drpdwnByText(startXpath + j + endDayEle, ReadPropertyFile.read("day"));
						log1.info("Filling yYear.");
						ByXpath.drpdwnByText(startXpath + j + endYearEle, ReadPropertyFile.read("year"));
						log1.info("Filling Country.");
						ByXpath.drpdwnByText(startXpath + j + endNationalEle, ReadPropertyFile.read("country"));
						break;
					case "Minor":
						log1.info("Filling pax info");
						log1.info("Filling first name.");
						ByXpath.sendKeys(startXpath + j + endFNameEle, RandomData.getSaltString());
						log1.info("Filling last name.");
						ByXpath.sendKeys(startXpath + j + endLNameEle, RandomData.getSaltString());
						log1.info("Filling Month.");
						ByXpath.drpdwnByText(startXpath + j + endMonthEle, ReadPropertyFile.read("minorMonth"));
						log1.info("Filling Day.");
						ByXpath.drpdwnByText(startXpath + j + endDayEle, ReadPropertyFile.read("minorDay"));
						log1.info("Filling yYear.");
						ByXpath.drpdwnByText(startXpath + j + endYearEle, ReadPropertyFile.read("minorYear"));
						log1.info("Filling Country.");
						ByXpath.drpdwnByText(startXpath + j + endNationalEle, ReadPropertyFile.read("country"));
						break;
					case "Infant":
						log1.info("Filling pax info");
						log1.info("Filling first name.");
						ByXpath.sendKeys(startXpath + "Infants_" + infantCount + endFNameEle,
								RandomData.getSaltString());
						log1.info("Filling last name.");
						ByXpath.sendKeys(startXpath + "Infants_" + infantCount + endLNameEle,
								RandomData.getSaltString());
						log1.info("Filling Month.");
						ByXpath.drpdwnByText(startXpath + "Infants_" + infantCount + endMonthEle,
								ReadPropertyFile.read("infantMonth"));
						log1.info("Filling Day.");
						ByXpath.drpdwnByText(startXpath + "Infants_" + infantCount + endDayEle,
								ReadPropertyFile.read("infantDay"));
						log1.info("Filling Year.");
						ByXpath.drpdwnByText(startXpath + "Infants_" + infantCount + endYearEle,
								ReadPropertyFile.read("infantYear"));
						log1.info("Filling Country.");
						ByXpath.drpdwnByText(startXpath + "Infants_" + infantCount + endInfantNationality,
								ReadPropertyFile.read("country"));
						infantCount = infantCount + 1;
						break;
					}
				}
				// ****************Filling primary contact
				// information************************//
				log1.info("Filling primary contact information.");
				log1.info("Filling first name.");
				ByXpath.sendKeys(firstNameEle, ReadPropertyFile.read("firstName"));
				log1.info("Filling last name.");
				ByXpath.sendKeys(lastNameEle, ReadPropertyFile.read("lastName"));
				log1.info("Filling email id.");
				ByXpath.sendKeys(emailIDEle, ReadPropertyFile.read("email"));
				log1.info("Filling verfiy email id.");
				ByXpath.sendKeys(verifyEmailEle, ReadPropertyFile.read("verifyEmail"));
				log1.info("Filling country code.");
				ByXpath.jClick(countryCodeEle);
				log1.info("Selecting US code.");
				ByXpath.jClick(mxnContryCodeEle);
				log1.info("Filling phone number.");
				ByXpath.sendKeys(phoneNumberEle, ReadPropertyFile.read("phoneNumber"));
				log1.info("Selecting check box.");
				ByXpath.click(checkAcceptEle);
				ByXpath.click(submitOnPaxInfoEle);

			} else
				throw new RuntimeException("Pax page is not avaialbe!");
		}
	}

	// public static void captchaClick(String xpath) throws InterruptedException
	// {
	// for (int i = 0; i <= driver.findElements(By.tagName("iframe")).size();
	// i++) {
	// try {
	// driver.switchTo().frame(i);
	// Thread.sleep(5000);
	// WebElement element = driver.findElement(By.xpath(xpath));
	// JavascriptExecutor executor = (JavascriptExecutor) driver;
	// executor.executeScript("arguments[0].click();", element);
	// log1.info("Clicked.");
	//
	// System.out.println(i);
	// driver.switchTo().defaultContent();
	// Thread.sleep(5000);
	// break;
	// } catch (WebDriverException ex) {
	//
	// continue;
	// }
	// }
	// }

	public static void captchaClick(String xpath, int i) throws InterruptedException {

		driver.switchTo().frame(i);
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		log1.info("Clicked.");
		System.out.println(i);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

	}

	public static void login(String memberType) throws InterruptedException {

		log1.info("Clicking for Login the User/Member.");
		ByXpath.click(loginSignUpBtnEle);
		ByXpath.click(loginLnkEle);

		if (memberType.equals("member")) {
			log1.info("Clicking for VClub member.");
			ByXpath.click(memberLogin);
			ByXpath.sendKeys(unameEle, ReadPropertyFile.read("memberUser"));
			ByXpath.sendKeys(passEle, ReadPropertyFile.read("memberPass"));

			captchaClick(capchaEle, 0);
			System.out.println("Captcha was clicked!");
			if (ByXpath.getAttributeValue(loginMemberSubmitEle, "class").contains("disabled")) {
				Thread.sleep(2000);
				System.out.println("Submit button was enabled.");
			} else
				System.out.println("Submit button was disabled and script is going to fail. ");

			Jexecutor.scrollDown();
			ByXpath.actionClick(loginMemberSubmitEle);
			System.out.println("Login button was clicked!");
			Jexecutor.scrollUp();

		}
		if (memberType.equals("agency")) {
			log1.info("Clicking for agency user.");
			ByXpath.click(agencyLogin);
			ByXpath.sendKeys(agencyUserEle, ReadPropertyFile.read("agencyUser"));
			ByXpath.sendKeys(agencyPassEle, ReadPropertyFile.read("agencyPass"));

			captchaClick(capchaEle, 1);
			System.out.println("Captcha was clicked!");
			if (ByXpath.getAttributeValue(loginAgencySubmitEle, "class").contains("disabled")) {
				Thread.sleep(2000);
				System.out.println("Submit button was enabled.");
			} else
				System.out.println("Submit button was disabled and script is going to fail. ");

			Jexecutor.scrollDown();
			ByXpath.actionClick(loginAgencySubmitEle);
			System.out.println("Login button was clicked!");
			Jexecutor.scrollUp();
		}
	}

	public static void agencyAcntLogout() throws InterruptedException {
		log1.info("Clicking for logging out the agency user.");
		ByXpath.jClick(myAccountEle);
		log1.info("Logging out the agency user.");
		ByXpath.jClick(agentAcntLogoutEle);
	}

	public static void vClubAcntLogout() throws InterruptedException {
		log1.info("Clicking for logging out the VClub Member.");
		ByXpath.jClick(myAccountEle);
		log1.info("Logging out the VClub Member.");
		ByXpath.jClick(vClubAcntlogoutEle);
	}

	public static void roundTripSearch(String adult, String minor, String infant) throws InterruptedException {
		if (ByXpath.isObjectAvailable(homeEle)) {
			log1.info("Opening flight list.");
			ByXpath.click(flyListEle);
			// Thread.sleep(2000);
			log1.info("Selecting cities");
			ByXpath.click(cityFromEle);
			ByXpath.click(cityToEle);
			log1.info("Selecting Date.");
			ByXpath.click(selectDateEle);
			dynamicwait.waitFor(dateDivEle);
			if (!defaultDate) {
				ByXpath.click(fromDateEle);
				ByXpath.click(toDateEle);
			}
			ByXpath.click(btnNextPassanger);
			selectMorePax(adult, minor, infant);
			ByXpath.click(searchFlightButtonEle);
			windowHandle();
			log1.info("Successfully switched to new window.");
		} else
			throw new RuntimeException("Home page is not avaialbe!");
	}

	public static void singleTripSearch(String adult, String minor, String infant) throws InterruptedException {
		if (ByXpath.isObjectAvailable(homeEle)) {
			log1.info("Opening flight list.");
			ByXpath.click(flyListEle);
			log1.info("Selecting cities");
			ByXpath.click(cityFromEle);
			ByXpath.click(cityToEle);
			log1.info("Setting up round trip.");
			ByXpath.click(roundTripEle);
			ByXpath.click(oneWayDropdownEle);
			log1.info("Selecting Date.");
			ByXpath.click(selectDateEle);
			dynamicwait.waitFor(dateDivEle);
			if (!defaultDate) {
				ByXpath.click(fromDateEle);
				ByXpath.click(toDateEle);
			}
			ByXpath.click(btnNextPassanger);
			selectMorePax(adult, minor, infant);
			ByXpath.click(searchFlightButtonEle);
			windowHandle();
			log1.info("Successfully switched to new window.");
		} else
			throw new RuntimeException("Home page is not avaialbe!");
	}

	public static void roundTripSearchIntnl(String adult, String minor, String infant) throws InterruptedException {
		if (ByXpath.isObjectAvailable(homeEle)) {
			log1.info("Opening flight list.");
			ByXpath.click(flyListEle);
			Thread.sleep(2000);
			log1.info("Selecting cities");
			ByXpath.click(cityFromEle);
			ByXpath.click(usaTabEle);
			Thread.sleep(1000);
			ByXpath.click(cityToIntnlEle);
			log1.info("Selecting Date.");
			ByXpath.click(selectDateEle);
			dynamicwait.waitFor(dateDivEle);
			if (!defaultDate) {
				ByXpath.click(fromDateEle);
				ByXpath.click(toDateEle);
			}
			log1.info("Clicking next pax button.");
			ByXpath.click(btnNextPassanger);
			selectMorePax(adult, minor, infant);
			log1.info("Clicking search flight button.");
			ByXpath.click(searchFlightButtonEle);
			windowHandle();
			log1.info("Successfully switched to new window.");
		} else
			throw new RuntimeException("Home page is not avaialbe!");
	}

	public static void singleTripSearchIntnl(String adult, String minor, String infant) throws InterruptedException {
		if (ByXpath.isObjectAvailable(homeEle)) {
			log1.info("Opening flight list.");
			ByXpath.click(flyListEle);
			log1.info("Selecting cities");
			ByXpath.click(cityFromEle);
			ByXpath.click(usaTabEle);
			Thread.sleep(1000);
			ByXpath.click(cityToIntnlEle);
			log1.info("Setting up round trip.");
			ByXpath.click(roundTripEle);
			ByXpath.click(oneWayDropdownEle);
			log1.info("Selecting Date.");
			ByXpath.click(selectDateEle);
			dynamicwait.waitFor(dateDivEle);
			if (!defaultDate) {
				ByXpath.click(fromDateEle);
				ByXpath.click(toDateEle);
			}
			ByXpath.click(btnNextPassanger);
			selectMorePax(adult, minor, infant);
			ByXpath.click(searchFlightButtonEle);
			windowHandle();
			log1.info("Successfully switched to new window.");
		} else
			throw new RuntimeException("Home page is not avaialbe!");
	}

	public static void selectLanguage() throws InterruptedException {
		log1.info("Selecting language!");
		ByXpath.click(languageLnkEle);
		ByXpath.click(languageDrpdwnEle);
		ByXpath.click(languageUSEle);
	}

	public static void comboSelection(String comboType) throws InterruptedException {
		Thread.sleep(2000);
		if (ByXpath.isObjectAvailable(pageComboEle)) {

			switch (comboType) {
			case "":
				ByXpath.click(noThanksEle);
				break;

			case "flexy":
				ByXpath.click(flexiCheckboxEle);
				ByXpath.click(continueEle);
				break;

			case "speed":
				ByXpath.click(speedCheckboxEle);
				ByXpath.click(continueEle);
				break;

			case "bag":
				ByXpath.click(baggageCheckboxEle);
				ByXpath.click(continueEle);
				break;
			}

		} else
			throw new RuntimeException("Combo page is not avaialbe!");
	}

	public static void selectFlightOneWay() throws InterruptedException {

		dynamicwait.WaitUntilElement(By.xpath(fightPageEle));
		int divCount = driver.findElements(By.xpath(fightPageEle)).size();
		if (divCount > 0) {
			for (int i = 1; i <= divCount; i++) {
				String isDirect0 = driver
						.findElement(By.xpath(".//*[@id='sortedAvailability0']/div" + "[" + i + "]//h4"))
						.getAttribute("innerHTML");
				System.out.println("Text of row number " + i + "as following\n" + isDirect0);
				Thread.sleep(1000);
				if (isDirect0.contains("Direct")) {
					log1.info("Selecting departing flight.");
					ByXpath.jClick(".//*[@id='sortedAvailability0']/div" + "[" + i + "]"
							+ "//a[contains(@class,'button_fare')]");
					break;

				}
			}
		}

		if (ByXpath.getAttributeValue(nextButtonOnDepartingFlightEle, "class").contains("disabled")) {
			Thread.sleep(3000);
		}
		ByXpath.click(nextButtonOnDepartingFlightEle);
	}

	public static void selectFlightRoundTrip() throws InterruptedException {

		dynamicwait.WaitUntilElement(By.xpath(fightPageEle));
		int divCount = driver.findElements(By.xpath(fightPageEle)).size();
		if (divCount > 0) {
			for (int i = 1; i <= divCount; i++) {
				String isDirect0 = driver
						.findElement(By.xpath(".//*[@id='sortedAvailability0']/div" + "[" + i + "]//h4"))
						.getAttribute("innerHTML");
				System.out.println("Text of row number " + i + "as following\n" + isDirect0);
				Thread.sleep(1000);
				if (isDirect0.contains("Direct")) {
					log1.info("Selecting departing flight.");
					ByXpath.jClick(".//*[@id='sortedAvailability0']/div" + "[" + i + "]"
							+ "//a[contains(@class,'button_fare')]");
					break;

				}
			}
		}

		if (ByXpath.getAttributeValue(nextButtonOnDepartingFlightEle, "class").contains("disabled")) {
			Thread.sleep(3000);
		}
		ByXpath.click(nextButtonOnDepartingFlightEle);
		// Thread.sleep(2000);
		log1.info("Selecting return flight.");
		dynamicwait.WaitUntilElement(By.xpath(fightReturnPageEle));
		int divCount2 = driver.findElements(By.xpath(fightReturnPageEle)).size();
		if (divCount2 > 0) {
			for (int i = 1; i <= divCount2; i++) {
				String isDirect = driver
						.findElement(By.xpath(".//*[@id='sortedAvailability1']/div" + "[" + i + "]//h4"))
						.getAttribute("innerHTML");
				System.out.println("Text of row number " + i + "as following\n" + isDirect);
				if (isDirect.contains("Direct")) {
					log1.info("Selecting return flight.");
					ByXpath.jClick(".//*[@id='sortedAvailability1']/div" + "[" + i + "]"
							+ "//a[contains(@class,'button_fare')]");
					break;
				}
			}
		}

		if (ByXpath.getAttributeValue(nextButtonOnDepartingFlightEle, "class").contains("disabled")) {
			Thread.sleep(3000);
		}
		ByXpath.click(nextButtonOnDepartingFlightEle);
	}

	public static void customerBaggage() throws IOException, InterruptedException {
		if (ByXpath.isObjectAvailable(customerPageEle)) {
			log1.info("Continue on customer baggage page.");
			ByXpath.click(continueCustomerPageEle);
		} else
			throw new RuntimeException("Customer page is not avaialbe!");
	}

	public static void seatOneWay() throws IOException, InterruptedException {
		try {
			log1.info("Dismissing popup");
			ByXpath.click(seatPopupEle);
			if (ByXpath.isObjectAvailable(seatSelectionPageEle)) {
				log1.info("Selecting default seat.");
				ByXpath.click(continueBtnOnSeatPageEle);
			}
		} catch (WebDriverException ex) {
			ByXpath.click(continueBtnOnSeatPageEle);
		}
	}

	public static void seatRoundTrip() throws IOException, InterruptedException {
		try {
			log1.info("dismissing popup");
			ByXpath.click(seatPopupEle);
			if (ByXpath.isObjectAvailable(seatSelectionPageEle)) {
				log1.info("Selecting default seat.");
				ByXpath.click(nextBtnOnSeatPageEle);
				ByXpath.click(continueBtnOnSeatPageEle);
			}
		} catch (WebDriverException ex) {
			ByXpath.click(nextBtnOnSeatPageEle);
			Thread.sleep(2000);
			ByXpath.click(continueBtnOnSeatPageEle);
		}
	}

	public static void tripExtras(String assistance) throws InterruptedException {
		int withoutTrip = 0;
		List<String> assistanceList = Arrays.asList(assistance.split(","));
		Iterator<String> itr = assistanceList.iterator();
		log1.info("Selecting trip extras.");
		while (itr.hasNext()) {

			switch (itr.next().toString()) {
			case "":
				System.out.println("Selecting nothing.");
				break;
			case "TripAssistance":
				tripAssitance();
				withoutTrip = 1;
				break;
			case "Hotel":
				hotel();
				break;
			case "Activities":
				activities();
				break;
			}
		}

		if (withoutTrip == 0) {
			ByXpath.click(submitBtnTripExtrasEle);
			ByXpath.click(withoutAssitanceEle);
		} else
			ByXpath.click(submitBtnTripExtrasEle);
	}

	public static void tripAssitance() throws InterruptedException {
		ByXpath.click(tripAssistanceEle);
		ByXpath.actionClick(checkTripAssistanceEle);
		ByXpath.click(addTripAssistanceEle);
	}

	public static void hotel() throws InterruptedException {
		ByXpath.click(hotelEle);
		if (!ByXpath.getText(hotelTextEle).contains(verifyHotel)) {
			ByXpath.click(bookHotelEle);
			ByXpath.click(selectHotelEle);
		} else
			ByXpath.click(closeHotelPageEle);
	}

	public static void activities() throws InterruptedException {
		ByXpath.click(activitiesEle);
		if (!ByXpath.getText(verifyActivityEle).contains(verifyHotel)) {
			ByXpath.click(selectActivitiesEle);
			ByXpath.click(incRegChildEle);
			ByXpath.click(bookActivitiesToTripEle);
		} else
			ByXpath.click(activityCloseEle);
	}

	public static void car(String bookCar) throws InterruptedException {
		Thread.sleep(2000);
		switch (bookCar) {
		case "":
			log1.info("Continue on car page.");
			Thread.sleep(1500);
			ByXpath.click(continueOnCarEle);
			break;
		case "selectCar":
			log1.info("Selecting a car.");
			ByXpath.click(bookCarEle);
			ByXpath.click(continueOnCarEle);
			break;
		}
		log1.info("dismissing popup.");
		Thread.sleep(1500);
		ByXpath.click(noThanksPopUpEle);
	}

	public static void payment() throws IOException, InterruptedException {
		Thread.sleep(3000);
		if (ByXpath.isObjectAvailable(pagePaymentEle)) {
			log1.info("Selecting Payment type and filling card info.");
			ByXpath.sendKeys(cardNumberEle, ReadPropertyFile.read("cardNumber"));
			log1.info("Entering card number.");
			ByXpath.drpdwnByText(monthEle, ReadPropertyFile.read("expMonth"));
			ByXpath.drpdwnByText(yearEle, ReadPropertyFile.read("expYear"));
			ByXpath.sendKeys(cvvEle, ReadPropertyFile.read("cvvNo"));
			log1.info("Entering card holder details.");
			ByXpath.sendKeys(fnameCustEle, ReadPropertyFile.read("firstName"));
			ByXpath.sendKeys(lnameCustEle, ReadPropertyFile.read("lastName"));
			ByXpath.sendKeys(addressEle, ReadPropertyFile.read("address"));
			ByXpath.drpdwnByText(countryEle, ReadPropertyFile.read("countryName"));
			ByXpath.drpdwnByText(stateDropDownEle, ReadPropertyFile.read("stateName"));
			ByXpath.sendKeys(cityEle, ReadPropertyFile.read("cityName"));
			ByXpath.sendKeys(zipCodeEle, ReadPropertyFile.read("zip"));
			ByXpath.sendKeys(emailEle, ReadPropertyFile.read("customerEmail"));
			ByXpath.sendKeys(phoneNoEle, ReadPropertyFile.read("phoneNo"));
			log1.info("Accepting payment");
			ByXpath.click(checkAcceptPaymenyEle);
			log1.info("Switching on captcha.");
			captchaClick(captchaOnPaymentEle, 0);
			log1.info("Payment Done Successful.");
			// ByXpath.click(bookMyTripEle);
		} else
			throw new RuntimeException("TripExtras page is not avaialbe!");
	}

	public static void windowHandle() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!parentWindow.equals(childWindow)) {
				driver.close();
				driver.switchTo().window(childWindow);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				break;
			}
		}
	}

	public static void selectCulture(String culture) throws InterruptedException {
		log1.info("Selecting culture.");
		ByXpath.click(languageLnkEle);
		Thread.sleep(1000);
		ByXpath.click(languageDrpdwnEle);

		switch (culture) {
		case "MXN":
			log1.info("Selecting mexican culture.");
			ByXpath.click(languageMXNEle);
			break;
		case "US":
			log1.info("Selecting  US culture.");
			ByXpath.click(languageUSEle);
			break;
		}
	}

	public static void selectCurrency(String Currency) throws InterruptedException {
		log1.info("Selecting Currency.");
		ByXpath.click(languageLnkEle);
		ByXpath.click(currencyDrpdwnEle);

		switch (Currency) {
		case "USD":
			log1.info("Selecting USD Currency.");
			ByXpath.click(currencyUSDELe);
			break;
		case "MXND":
			log1.info("Selecting MXND Currency.");
			ByXpath.click(currencyMXNDEle);
			break;
		}
	}

	// ===========================================================================================

	public static void paxInfo() throws InterruptedException {
		if (ByXpath.isObjectAvailable(paxPageEle)) {
			log1.info("Filling pax info");
			ByXpath.sendKeys(fNameEle, ReadPropertyFile.read("first"));
			ByXpath.sendKeys(lNameEle, ReadPropertyFile.read("last"));
			ByXpath.drpdwnByText(monthDOBEle, ReadPropertyFile.read("month"));
			ByXpath.drpdwnByText(dayDOBEle, ReadPropertyFile.read("day"));
			ByXpath.drpdwnByText(yearDOBEle, ReadPropertyFile.read("year"));
			ByXpath.drpdwnByText(nationalityEle, ReadPropertyFile.read("country"));
			ByXpath.sendKeys(firstNameEle, ReadPropertyFile.read("firstName"));
			ByXpath.sendKeys(lastNameEle, ReadPropertyFile.read("lastName"));
			ByXpath.sendKeys(emailIDEle, ReadPropertyFile.read("email"));
			ByXpath.sendKeys(verifyEmailEle, ReadPropertyFile.read("verifyEmail"));
			// ByXpath.drpdwnByText(countryCodeEle,
			// ReadPropertyFile.read("countryCode"));
			ByXpath.sendKeys(phoneNumberEle, ReadPropertyFile.read("phoneNumber"));
			ByXpath.click(checkAcceptEle);
			log1.info("Submitting pax info page after filling all info.");
			ByXpath.click(submitOnPaxInfoEle);
		} else
			throw new RuntimeException("Pax page is not avaialbe!");
	}

	/*
	 * public static void joinVClub() throws NoSuchElementException,
	 * InterruptedException {
	 * if(ByXpath.isObjectAvailable(membershipSelectionPageEle)) {
	 * ByXpath.click(joinVClubEle); ByXpath.sendKeys(fNameStdELe,
	 * ReadPropertyFile.read("fnameStd")); ByXpath.sendKeys(lNameStdELe,
	 * ReadPropertyFile.read("lNameStd")); ByXpath.sendKeys(bDayStdEle,
	 * ReadPropertyFile.read("bDayStd")); ByXpath.drpdwnByText(countryStdEle,
	 * ReadPropertyFile.read("countryStd")); ByXpath.click(maleStdEle);
	 * ByXpath.sendKeys(emailIDStdEle, ReadPropertyFile.read("emailIDStd"));
	 * ByXpath.sendKeys(confrmEmailIDStdEle,
	 * ReadPropertyFile.read("emailIDStd")); ByXpath.sendKeys(pswdStdEle,
	 * ReadPropertyFile.read("pswdStd")); ByXpath.sendKeys(confrmPswdStdEle,
	 * ReadPropertyFile.read("pswdStd")); ByXpath.sendKeys(addrsStdEle,
	 * ReadPropertyFile.read("addrsStd")); ByXpath.sendKeys(postlCdeStdEle,
	 * ReadPropertyFile.read("postlCdeStd"));
	 * ByXpath.drpdwnByText(stateOfCntryStdEle,
	 * ReadPropertyFile.read("stateOfCntryStd"));
	 * ByXpath.drpdwnByText(cityOfStateStdEle,
	 * ReadPropertyFile.read("cityOfStateStd"));
	 * ByXpath.drpdwnByText(phoneStdEle, ReadPropertyFile.read("phoneStd"));
	 * ByXpath.click(chckBxStdEle); //ByXpath.click(createAcntStdEle);
	 * ByXpath.sendKeys(cardNoStdEle, ReadPropertyFile.read("cardNoStd"));
	 * 
	 * 
	 * } }
	 */

	public static void fillDetails(String fill, String invalidValue) throws InterruptedException {

		HashMap<String, String> m = new HashMap<>();

		m.put("fNameStd", ReadPropertyFile.read("fNameStd"));
		m.put("lNameStd", ReadPropertyFile.read("lNameStd"));
		m.put("bDayStd", ReadPropertyFile.read("bDayStd"));
		m.put("countryStd", ReadPropertyFile.read("countryStd"));
		m.put("emailIDStd", ReadPropertyFile.read("emailIDStd"));
		m.put("confirmEmailIDStd", ReadPropertyFile.read("confirmEmailIDStd"));
		m.put("pswdStd", ReadPropertyFile.read("pswdStd"));
		m.put("confrmPasswdStd", ReadPropertyFile.read("confrmPasswdStd"));
		m.put("addrsStd", ReadPropertyFile.read("addrsStd"));
		m.put("postlCdeStd", ReadPropertyFile.read("postlCdeStd"));
		m.put("stateOfCntryStd", ReadPropertyFile.read("stateOfCntryStd"));
		m.put("cityOfStateStd", ReadPropertyFile.read("cityOfStateStd"));
		m.put("phoneStd", ReadPropertyFile.read("phoneStd"));
		m.put("cardNoStd", ReadPropertyFile.read("cardNoStd"));
		if (!invalidValue.equals(""))
			m.replace(fill, invalidValue);

		ByXpath.sendKeys(fNameStdELe, m.get("fNameStd"));
		ByXpath.sendKeys(lNameStdEle, m.get("lNameStd"));
		ByXpath.sendKeys(bDayStdEle, m.get("bDayStd"));
		ByXpath.drpdwnByText(countryStdEle, m.get("countryStd"));
		ByXpath.sendKeys(emailIDStdEle, m.get("emailIDStd"));
		ByXpath.sendKeys(confrmEmailIDStdEle, m.get("confirmEmailIDStd"));

		ByXpath.sendKeys(pswdStdEle, m.get("pswdStd"));
		ByXpath.sendKeys(confrmPswdStdEle, m.get("pswdStd"));

		ByXpath.sendKeys(addrsStdEle, m.get("addrsStd"));
		ByXpath.sendKeys(postlCdeStdEle, m.get("postlCdeStd"));
		ByXpath.drpdwnByText(stateOfCntryStdEle, m.get("stateOfCntryStd"));
		ByXpath.sendKeys(cityOfStateStdEle, m.get("cityOfStateStd"));
		ByXpath.sendKeys(phoneStdEle, m.get("phoneStd"));
		ByXpath.click(chckBxStdEle);
		ByXpath.click(createAcntStdEle);
	}

	public static void fillCardDetails(String fill, String invalidValue) throws InterruptedException {

		HashMap<String, String> m = new HashMap<>();

		m.put("fNameStd", ReadPropertyFile.read("fNameStd"));
		m.put("lNameStd", ReadPropertyFile.read("lNameStd"));
		m.put("bDayStd", ReadPropertyFile.read("bDayStd"));
		m.put("countryStd", ReadPropertyFile.read("countryStd"));
		m.put("emailIDStd", ReadPropertyFile.read("emailIDStd"));
		m.put("confirmEmailIDStd", ReadPropertyFile.read("confirmEmailIDStd"));
		m.put("pswdStd", ReadPropertyFile.read("pswdStd"));
		m.put("confrmPasswdStd", ReadPropertyFile.read("confrmPasswdStd"));
		m.put("addrsStd", ReadPropertyFile.read("addrsStd"));
		m.put("postlCdeStd", ReadPropertyFile.read("postlCdeStd"));
		m.put("stateOfCntryStd", ReadPropertyFile.read("stateOfCntryStd"));
		m.put("cityOfStateStd", ReadPropertyFile.read("cityOfStateStd"));
		m.put("phoneStd", ReadPropertyFile.read("phoneStd"));
		m.put("cardNoStd", ReadPropertyFile.read("cardNoStd"));
		m.put("monthStd", ReadPropertyFile.read("monthStd"));
		m.put("yearStd", ReadPropertyFile.read("yearStd"));
		m.put("cvvStd", ReadPropertyFile.read("cvvStd"));
		m.put("adrs1Std", ReadPropertyFile.read("adrs1Std"));
		m.put("countryCustStd", ReadPropertyFile.read("countryCustStd"));
		m.put("stateStd", ReadPropertyFile.read("stateStd"));
		m.put("cityStd", ReadPropertyFile.read("cityStd"));
		m.put("zipCodeStd", ReadPropertyFile.read("zipCodeStd"));
		m.put("emailStd", ReadPropertyFile.read("emailStd"));
		m.put("phoneNumberStd", ReadPropertyFile.read("phoneNumberStd"));
		if (!invalidValue.equals(""))
			m.replace(fill, invalidValue);

		ByXpath.sendKeys(fNameStdELe, m.get("fNameStd"));
		ByXpath.sendKeys(lNameStdEle, m.get("lNameStd"));
		ByXpath.sendKeys(bDayStdEle, m.get("bDayStd"));
		ByXpath.drpdwnByText(countryStdEle, m.get("countryStd"));
		ByXpath.sendKeys(emailIDStdEle, m.get("emailIDStd"));
		ByXpath.sendKeys(confrmEmailIDStdEle, m.get("confirmEmailIDStd"));
		ByXpath.sendKeys(pswdStdEle, m.get("pswdStd"));
		ByXpath.sendKeys(confrmPswdStdEle, m.get("pswdStd"));
		ByXpath.sendKeys(addrsStdEle, m.get("addrsStd"));
		ByXpath.sendKeys(postlCdeStdEle, m.get("postlCdeStd"));
		ByXpath.drpdwnByText(stateOfCntryStdEle, m.get("stateOfCntryStd"));
		ByXpath.sendKeys(cityOfStateStdEle, m.get("cityOfStateStd"));
		ByXpath.sendKeys(phoneStdEle, m.get("phoneStd"));
		ByXpath.click(chckBxStdEle);
		ByXpath.click(createAcntStdEle);
		ByXpath.sendKeys(cardNoStdEle, m.get("cardNoStd"));
		ByXpath.drpdwnByText(monthStdEle, m.get("monthStd"));
		ByXpath.drpdwnByText(yearStdEle, m.get("yearStd"));
		ByXpath.sendKeys(cvvStdEle, m.get("cvvStd"));
		ByXpath.click(usePrmryCustStdEle);
		ByXpath.sendKeys(adrs1StdEle, m.get("adrs1Std"));
		ByXpath.drpdwnByText(countryCustStdEle, m.get("countryCustStd"));
		log1.info("Selecting the state.");
		ByXpath.drpdwnByText(stateStdEle, m.get("stateStd"));
		ByXpath.sendKeys(cityStdEle, m.get("cityStd"));
		ByXpath.sendKeys(zipCodeStdEle, m.get("zipCodeStd"));
		ByXpath.sendKeys(emailStdEle, m.get("emailStd"));
		ByXpath.sendKeys(phoneNumberStdEle, m.get("phoneNumberStd"));
		ByXpath.click(acceptChckBxStdEle);
		captchaClick(reCaptchStdELe, 0);
		log1.info("submitting the card info.");
		for (;;) {
			if (!driver.findElement(By.xpath(buyMemberShipStdEle)).getAttribute("class").contains("disabled")) {
				Thread.sleep(500);
				break;
			} else
				Thread.sleep(500);
		}
		ByXpath.click(buyMemberShipStdEle);
	}

	public static void joinVClub() throws InterruptedException {
		if (ByXpath.isObjectAvailable(membershipSelectionPageEle)) {
			log1.info("Clicking for JoinVClub");
			ByXpath.click(joinVClubEle);
			Thread.sleep(1000);
			log1.info("Filling customer info.");
			ByXpath.sendKeys(fNameStdELe, ReadPropertyFile.read("fNameStd"));
			ByXpath.sendKeys(lNameStdEle, ReadPropertyFile.read("lNameStd"));
			ByXpath.sendKeys(bDayStdEle, ReadPropertyFile.read("bDayStd"));
			ByXpath.drpdwnByText(countryStdEle, ReadPropertyFile.read("countryStd"));
			ByXpath.click(maleStdEle);
			ByXpath.sendKeys(emailIDStdEle, ReadPropertyFile.read("emailIDStd"));
			ByXpath.sendKeys(confrmEmailIDStdEle, ReadPropertyFile.read("emailIDStd"));
			ByXpath.sendKeys(pswdStdEle, ReadPropertyFile.read("pswdStd"));
			ByXpath.sendKeys(confrmPswdStdEle, ReadPropertyFile.read("pswdStd"));
			log1.info("Filling address.");
			ByXpath.sendKeys(addrsStdEle, ReadPropertyFile.read("addrsStd"));
			ByXpath.sendKeys(postlCdeStdEle, ReadPropertyFile.read("postlCdeStd"));
			log1.info("Filling postal code.");
			ByXpath.drpdwnByText(stateOfCntryStdEle, ReadPropertyFile.read("stateOfCntryStd"));
			ByXpath.sendKeys(cityOfStateStdEle, ReadPropertyFile.read("cityOfStateStd"));
			ByXpath.sendKeys(phoneStdEle, ReadPropertyFile.read("phoneStd"));
			ByXpath.click(chckBxStdEle);

			// ByXpath.click(createAcntStdEle);
			ByXpath.sendKeys(cardNoStdEle, ReadPropertyFile.read("cardNoStd"));
			ByXpath.sendKeys(monthStdEle, ReadPropertyFile.read("monthStd"));
			ByXpath.sendKeys(yearStdEle, ReadPropertyFile.read("yearStd"));
			ByXpath.sendKeys(cvvStdEle, ReadPropertyFile.read("cvvStd"));
			ByXpath.click(usePrmryCustStdEle);
			ByXpath.sendKeys(adrs1StdEle, ReadPropertyFile.read("adrs1Std"));
			ByXpath.sendKeys(countryCustStdEle, ReadPropertyFile.read("countryCustStd"));
			ByXpath.sendKeys(stateStdEle, ReadPropertyFile.read("stateStd"));
			ByXpath.sendKeys(cityStdEle, ReadPropertyFile.read("cityStd"));
			ByXpath.sendKeys(zipCodeStdEle, ReadPropertyFile.read("zipCodeStd"));
			ByXpath.sendKeys(emailStdEle, ReadPropertyFile.read("emailStd"));
			ByXpath.sendKeys(cntryCodeCardStdEle, ReadPropertyFile.read("cntryCodeCardStd"));
			ByXpath.sendKeys(phoneNumberStdEle, ReadPropertyFile.read("phoneNumberStd"));
			ByXpath.click(acceptChckBxStdEle);
			captchaClick(reCaptchStdELe, 0);
			ByXpath.click(buyMemberShipStdEle);
		}
	}

}