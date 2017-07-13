package com.volaris.pageFactory;

public interface PaymentPage {

	// ***********************Created by Yashpal**********************//

	String pagePaymentEle = ".//*[@class='paymentOptionContainer']";
	String creditDebitCardEle = ".//*[@id='main-content']//a[text()='Credit / Debit Card']";
	String cardNumberEle = ".//*[@id='credit-card-js-credit-card-numberId0']";
	String monthEle = ".//*[@id='credit-card-cc-month0']";
	String yearEle = ".//*[@id='credit-card-cc-year0']";
	String cvvEle = ".//*[@id='credit-card-cvv-code0']";
	String additionalCardEle=".//*[@id='single-creditcard-additional']";
	String customerInfoEle=".//*[@id='frmMultiCreditCard']/div[1]/div/div[3]/div[1]/label/span";
	
	String fnameCustEle=".//*[@id='credit-card-cc-firstname0']";
	String lnameCustEle=".//*[@id='credit-card-cc-lastname0']";
	String addressEle=".//*[@id='credit-card-address0']";	
	String countryEle=".//*[@id='volarisCreditCard_credit-card-Country0']";
	String stateTextEle=".//*[@id='credit-card-StateTextBox0']";	
	String cityEle=".//*[@id='js-citycode0']";
	String zipCodeEle=".//*[@id='js-zipcode0']";
	String emailEle=".//*[@id='js-email0']";
	// ***************************************************************//
	
	
	// ***********************Created by Amar Nath**********************//
	
	String stateDropDownEle=".//*[@id='credit-card-StateDropDown0']";
	String countryDropdownEle = "//*[@id='frmMultiCreditCard']/div[1]//*[@id='dropdownMenu1']";
	String phoneNoEle = ".//*[@id='js-phone0']";
	String checkAcceptPaymenyEle = ".//*[@id='screen-reader-termsconditions']";
	String captchaOnPaymentEle = ".//*[@id='recaptcha-anchor-label']";
	String bookMyTripEle = ".//*[@id='submit_payment_button']";
	

}
