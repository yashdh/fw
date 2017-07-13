package com.volaris.pageFactory;

import commonClassesReusable.ReadPropertyFile;

public interface HomePage {

	// Created by Yashpal //
	String xpathStart = ".//*[@id='MX']//a[text()='";
	String xpathEnd = "']";
	boolean defaultDate = true;
	String homeEle = ".//*[@id='home']";
	String sourceEle = ".//*[@id='input_origin']";
	String destinationEle = ".//*[@id='input_destination']";
	String roundTripEle = ".//*[@id='selDestinFlight']/div[1]/div/button";
	String roundTripDropdownEle = ".//*[@id='ulTrips']/li[1]/a";
	String oneWayDropdownEle = ".//*[@id='ulTrips']/li[2]/a";
	String nearByAirportsEle = ".//*[@id='selDestinFlight']/p/span/label/span";
	String flyListEle = ".//*[@id='btn_origen']";
	String cityFromEle = xpathStart + ReadPropertyFile.read("fromCity") + xpathEnd;
	String cityToEle = xpathStart + ReadPropertyFile.read("toCity") + xpathEnd;
	
	String xpathIntnlStart = ".//*[@id='US']//a[text()='";
	String xpathIntnlEnd = "']";
	
	String cityFromIntnlEle = xpathIntnlStart + ReadPropertyFile.read("fromCityIntnl") + xpathIntnlEnd;
	String cityToIntnlEle = xpathIntnlStart + ReadPropertyFile.read("toCityIntnl") + xpathIntnlEnd;
	String usaTabEle = ".//*[@id='liCity1']/a";

	// --Select Dates button
	String selectDateEle = ".//*[@id='SelectDateTab']";
	
	// -------------------------

	String datePickerFromEle = ".//*[@id='aFromDate']";
	String datePickerToEle = ".//*[@id='aToDate']";
	String fromDateEle = ".//*[@id='datepickerLowFare']//td[@data-month='" + ReadPropertyFile.read("fromDateMonth")
			+ "' and @data-year='" + ReadPropertyFile.read("fromDateYear") + "']//a[text()='"
			+ ReadPropertyFile.read("fromDateDay") + "']";
	String toDateEle = ".//*[@id='datepickerLowFare']//td[@data-month='" + ReadPropertyFile.read("toDateMonth")
			+ "' and @data-year='" + ReadPropertyFile.read("toDateYear") + "']//a[text()='"
			+ ReadPropertyFile.read("toDateDay") + "']";

	// --Select Pax button
	String selectPaxEle = ".//*[@id='SelectPaxTab']";
	// -------------------------

	String adultEle = ".//*[@id='txtAdultValue']";
	String minorEle = ".//*[@id='txtMinorValue']";
	String infantsEle = ".//*[@id='txtInfantValue']";
	
	String btnNextPassanger = ".//*[@id='btnPassenger']";
	String paxDivEle  = ".//*[@id='divSelectPassenger']";
	String dateDivEle  =".//*[@id='SelectDateTab']";
	String searchFlightButtonEle = ".//*[@id='btnSearchFlight']";

	// --Login/Signup button

	String loginSignUpBtnEle = ".//*[@id='signin-div']/a[2]/span[2]";
	String loginLnkEle = ".//a[starts-with(text(),'Login')]";

	// After sign in
	String myAccountEle = ".//*[@id='account']/button";
	String agentAcntLogoutEle = ".//*[@id='bs-log']/ul/li[4]/a";
	String vClubAcntlogoutEle = ".//*[@class='bgHeader']/div[1]/div[1]/div[1]/div/div[1]/div/ul/li[5]/a[@id='member-logout']";
	//String vClubAcntlogoutEle = ".//*[@id='member-logout']";
	String languageLnkEle = ".//*[@id='UlLanguageShowTrigger']";
	String languageDrpdwnEle = ".//*[@id='ulLanguageShow']/li[1]/div/button";
	
	

	// *************************************************************************************//
	
	
	//********** Created by Amar Nath********** //
	
	String languageMXNEle = ".//*[@id='ulLanguageShowDiv']/ul/li[1]/div/ul/li[1]/a";
	String languageUSEle = ".//*[@id='ulLanguageShowDiv']/ul/li[1]/div/ul/li[2]/a";
	String currencyDrpdwnEle = ".//*[@id='ulLanguageShow']/li[2]/div/button";	
	String currencyUSDELe = ".//*[@id='ulLanguageShowDiv']/ul/li[2]/div/ul/li[1]/a";
	String currencyMXNDEle = ".//*[@id='ulLanguageShowDiv']/ul/li[2]/div/ul/li[2]/a";

}
