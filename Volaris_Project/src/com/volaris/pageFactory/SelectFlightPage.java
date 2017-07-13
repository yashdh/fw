package com.volaris.pageFactory;

public interface SelectFlightPage {
	
	//*************Created by Amarnath**************//
	String fightPageEle = ".//*[@id='sortedAvailability0']/div";
	String departingFlightEle = ".//*[@id='sortedAvailability0']/div[1]/div[2]/a[1]/label/input";
	String nextButtonOnDepartingFlightEle = ".//*[@id='submit_search_button']";
	String returningFlightEle = ".//*[@id='sortedAvailability1']/div[1]/div[2]/a[1]/label/input";
	String comboPopupEle = ".//*[@id='modcont-combodeals']/button";
	String fightReturnPageEle = ".//*[@id='sortedAvailability1']/div";
	

}
