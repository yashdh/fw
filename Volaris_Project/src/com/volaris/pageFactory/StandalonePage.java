package com.volaris.pageFactory;

public interface StandalonePage {

    String vClubSignUpPageEle = ".//*[@id='frmVclubRegister']";
    String membershipSelectionPageEle = ".//*[@id='membership-selection']";
    // =======================new acnt create====================
    String joinVClubEle = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a";
    String fNameStdELe = ".//*[@id='vClubMembershipRegistration_Member_Name_First']";
    String fNameStdErrMsgEle = ".//*[@id='frmVclubRegister']/div[3]/span[1]/label[2]";
    String lNameStdELe = ".//*[@id='vClubMembershipRegistration_Member_Name_Last']";
    String lNameStdErrMsgEle = ".//*[@id='frmVclubRegister']/div[3]/span[2]/label[2]";
    String bDayStdEle = ".//*[@id='vClubMembershipRegistration_Member_DateOfBirth']";
    String countryStdEle = ".//*[@id='vClubMembershipRegistration_Nationality']";
    String maleStdEle = ".//*[@id='frmVclubRegister']/div[4]/fieldset/div/label[1]/span";
    String femaleStdEle = ".//*[@id='frmVclubRegister']/div[4]/fieldset/div/label[2]/span";
    String emailIDStdEle = ".//*[@id='vClubMembershipRegistration_Member_PersonalEmailAddress_EmailAddress']";
    String confrmEmailIDStdEle = ".//*[@id='vClubMembershipRegistration_ConfirmEmailAddress']";
    String pswdStdEle = ".//*[@id='vClubMembershipRegistration_Member_Password']";
    String confrmPswdStdEle = ".//*[@id='vClubMembershipRegistration_Member_NewPasswordConfirmation']";
    String addrsStdEle = ".//*[@id='vClubMembershipRegistration_Address1']";
    String addrsStdErrMsgEle = ".//*[@id='frmVclubRegister']/div[6]/span[1]/label[2]";
    String postlCdeStdEle = ".//*[@id='js-zipcode']";
    String postlCdeErrMsgEle = ".//*[@id='frmVclubRegister']/div[6]/span[2]/label[2]";
    String stateOfCntryStdEle = ".//*[@id='frmVclubRegisterStateDropDown']";
    String cityOfStateStdEle = ".//*[@id='js-citycode']";
    String cntryCodeStdEle = ".//*[@id='dropdownMenu1']";
    String phoneStdEle = ".//*[@id='js-phone']";
    String chckBxStdEle = ".//*[@id='screen-reader-termsconditions']";
    String termCndtEle = ".//*[@id='screen-reader-termsconditions']/a[1]";
    String prvcyPlcyEle = ".//*[@id='screen-reader-termsconditions']/a[2]";
    String createAcntStdEle = ".//*[@id='vclubSubmitButton']";
    String cardNoStdEle = ".//*[@id='credit-card-js-credit-card-numberId0']";
    String monthStdEle = ".//*[@id='credit-card-cc-month0']";
    String yearStdEle = ".//*[@id='credit-card-cc-year0']";
    String cvvStdEle = ".//*[@id='credit-card-cvv-code0']";
    String usePrmryCustStdEle = ".//*[@id='frmMultiCreditCard']/div/div[3]/div/div[1]/label/span";
    String firstNameStdEle = ".//*[@id='credit-card-cc-firstname0']";
    String lastNameStdEle = ".//*[@id='credit-card-cc-lastname0']";
    String adrs1StdEle = ".//*[@id='credit-card-address0']";
    String countryCustStdEle = ".//*[@id='volarisCreditCard_credit-card-Country0']";
    String stateStdEle = ".//*[@id='credit-card-StateTextBox0']";
    String cityStdEle = ".//*[@id='js-citycode0']";
    String zipCodeStdEle = ".//*[@id='js-zipcode0']";
    String emailStdEle = ".//*[@id='js-email0']";
    String cntryCodeCardStdEle = ".//*[@id='dropdownMenu1']";
    String phoneNumberStdEle = ".//*[@id='js-phone0']";
    String acceptChckBxStdEle = ".//*[@id='screen-reader-termsconditions']";
    String reCaptchStdELe = ".//*[@id='recaptcha-anchor']";
    String buyMemberShipStdEle = ".//*[@id='vclubSubmitPaymentButton']";

    
    // =======================Login====================
    String haveAlrdyAcntEle = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/a";

    // Error text-
    String fNameStdErrMsg = "[vClubMembershipRegistration.Member.Name.First:Rangelength_0_1]";
    String lNameStdErrMsg = "[vClubMembershipRegistration.Member.Name.Last:Rangelength_0_1]";
    String addrsStdErrMsg = "Only 50 characters allowed";
    String postlCdeErrMsg = "Only 20 characters allowed";

    String countryListEle = ".//*[@id='vClubMembershipRegistration_Nationality']/option";

}
