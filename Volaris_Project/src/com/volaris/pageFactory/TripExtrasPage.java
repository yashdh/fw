package com.volaris.pageFactory;

public interface TripExtrasPage {
	
	//*************Created by Amarnath**************//
	
	String tripExtrasEle = ".//*[@id='trip-extra-div']";
	
	String tripAssistanceEle = ".//*[@id='modal-protect-id']";
	String checkTripAssistanceEle = ".//*[@id='checkbox-extra-baggage checbox-baggage-amount']";
	String addTripAssistanceEle = ".//*[@id='modal-protecttrip']/div/div/div[2]/button";
	
	String volProtectionEle = ".//*[@id='modal-insurance-selectEdit']";
	String checkPersonalItemEle = ".//*[@id='modal-insurancePersonalItems']/div[2]/div[1]/div/table/tbody/tr/td/label/span[1]";
	String addToTripEle = ".//*[@id='modal-insurancePersonalItems']/div[2]/button";
	String noThnkPrsnItem = ".//*[@id='modal-insurancePersonalItems']/div[2]/a[3]";
	
	String hotelEle = ".//*[@id='modal-hotel-selectEdit']";
	String bookHotelEle = ".//*[@id='hotel-list']/div[1]/div[1]/div[2]/div[1]/div[3]/div/div[3]/button";
	String selectHotelEle = ".//*[@id='hotel-list']/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[3]/button";
	
	String hotelTextEle = ".//*[@id='hotel-div']/div[5]/h3";
	String closeHotelPageEle = ".//*[@id='modal-hotel']/div/div/div[1]/button";
	
	String activitiesEle = ".//*[@id='modal-actvities-selectEdit']";
	String selectActivitiesEle = ".//*[@id='activity-list']/div[1]/div[1]/div[2]/div[1]/div[3]/div/div[3]/button";	
	String incRegChildEle = ".//*[@id='activity-list']/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/a[1]";
	String decRegChildEle = ".//*[@id='activity-list']/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/a[2]";
	String incRegAdultEle = ".//*[@id='activity-list']/div[1]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/a[1]";
	String decRegAdultEle = ".//*[@id='activity-list']/div[1]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/a[2]";
	String bookActivitiesToTripEle = ".//*[@id='activity-list']/div[1]/div[2]/div[3]/div/button"; 
	
	String submitBtnTripExtrasEle = ".//*[@id='submit_extras_button']";
	String closePopupTripEle = ".//*[@id='tripAssistancePopupModal']/div[2]/div[2]/a";
	String loaderEle = ".//*[@id='system-loader']";
	String verifyActivityEle = ".//*[@id='activity-div']/div[7]/h3";
	String activityCloseEle = ".//*[@id='modal-activities']/div/div/div[1]/button";
	String withoutAssitanceEle = ".//*[@id='tripAssistancePopupModal']//a[text()='No, Thanks']";
}
