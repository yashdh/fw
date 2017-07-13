package com.volaris.pageFactory;

public interface LoginPage {
	
	//  Created by Yashpal                    //
	boolean isMember = false;
	
	String loginPageEle = ".//*[@class='login-area']";

	String unameEle = ".//*[@id='vClubMember_username']";
	String passEle = ".//*[@id='vClubMember_password']";
	String agencyUserEle = ".//*[@id='volarisAgentLogin.Username']";
	String agencyPassEle= ".//*[@id='volarisAgentLogin.Password']";

	String capchaEle = ".//*[@id='recaptcha-anchor']";	
	String loginMemberSubmitEle = ".//*[@id='loginModalButton']";
	String loginAgencySubmitEle = ".//*[@id='loginAgencyButton']";
	String memberLogin = ".//*[@id='modcont-vclubformhome']/div/div[1]/div[1]/label/div";
	String agencyLogin = ".//*[@id='modcont-vclubformhome']/div/div[1]/div[2]/label/div";
	
	
	//*************************************************************************************//
	
	//   Created by Amarnath //
	
	
	
	//*************************************************************************************//

	
}
