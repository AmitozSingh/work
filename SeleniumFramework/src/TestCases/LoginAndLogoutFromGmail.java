package TestCases;

import org.testng.annotations.Test;

import CustomLibraries.Functions;

public class LoginAndLogoutFromGmail extends Functions{
  @Test
  public void f() {
	  
	  /*startBrowser();
	  waitForElement(10000);*/
	  getObjName();
	  waitForElement(10000);
	  clearAndSendkeys(textbox_Email, "amitoznarang1992");
	  click(button_next);
	  waitForElement(4000);
	  clearAndSendkeys(textbox_password, "");
	  click(button_SignIn);
	  waitForElement(6000);
	/*  getObjName(icon_account);
	  verifyElementPresentOnPage(icon_account);*/
	  waitForElement(6000);
	  closeBrowser();
  }
}
