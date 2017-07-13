package com.volaris.pageFactory;

public interface CustomerPage {
		
	//*************Created by Amarnath**************//	
	String customerPageEle = ".//*[@id='passengers-div']/div/div[2]";
	String continueCustomerPageEle = ".//*[@id='submit_bundle_button']";
	String bagTextIntnlEle = ".//*[@id='USBaggageModal']/div[1]/h3";
	
	String selectBagPopupEle = ".//*[@id='USBaggageModal']/div[2]/div/div/button[2]";
	String seatPagePopupTextEle = ".//*[@id='modal-initialseat']/div[1]/h4";
	String seatPageTextEle = ".//*[@id='sticky-wrapper']/div/div/div[1]/div[1]/h1";

}
