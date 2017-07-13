package com.volaris.pageFactory;

public interface PaxInfoPage {

	// *************Created by Amarnath**************//
	String startXpath = ".//*[@id='volarisPassengers_";
	
	
	
	String paxPageEle = ".//*[@id='passengerForm']";
	String fNameEle = ".//*[@id='volarisPassengers_0__Name_First']";
	String lNameEle = ".//*[@id='volarisPassengers_0__Name_Last']";
	String monthDOBEle = ".//*[@id='volarisPassengers_0__month']";
	String dayDOBEle = ".//*[@id='volarisPassengers_0__day']";
	String yearDOBEle = ".//*[@id='volarisPassengers_0__year']";
	String nationalityEle = ".//*[@id='volarisPassengers_0__Info_Nationality']";
	String maleEle = ".//*[@id='volarisPassengers_0__Info_Gender_Male']";
	String femaleEle = ".//*[@id='volarisPassengers_0__Info_Gender_Female']";
	
	//***********************************************************************//
	String endFNameEle = "__Name_First']";
	String endLNameEle = "__Name_Last']";
	String endMonthEle = "__month']";
	String endDayEle = "__day']";
	String endYearEle = "__year']";
	String endNationalEle = "__Info_Nationality']";
	String endMaleEle = "__Male']";
	String endFemaleEle = "__Female']";
	String endInfantNationality = "__Nationality']";


	
	//**********************************************************************//
	String checkFirstPaxEle = ".//*[@id='passengerForm']/div[2]/div/div/div/label[1]/span";
	String firstNameEle = ".//*[@id='volarisContact_Name_First']";
	String lastNameEle = ".//*[@id='volarisContact_Name_Last']";
	String emailIDEle = ".//*[@id='volarisContact_EmailAddress']";
	String verifyEmailEle = ".//*[@id='volarisContact_VerifyEmailAddress']";
	String countryCodeEle = ".//*[@id='dropdownMenu1']";
	String usContryCodeEle = ".//*[@id='dropdownMenu1']/following-sibling::ul/li[2]";
	String mxnContryCodeEle = ".//*[@id='dropdownMenu1']/following-sibling::ul/li[1]";
	String phoneNumberEle = ".//*[@id='volarisContact_HomePhone']";
	String checkAcceptEle = ".//*[@id='passengerForm']/div[2]/div/div/div/div/label[1]/span";
	String submitOnPaxInfoEle = ".//*[@id='submit_passenger_button']";
	String passangerCountEle = ".//*[@id='passengerForm']/div[1]/div[contains(@class,'passenger-information')]";
	
	
	
	
	
	
	
	
	
}
