package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CustomLibraries.Functions;
import CustomLibraries.GMILLoginPage;

public class LoginAndLogoutFromGmail extends Functions{
	CustomLibraries.GMILLoginPage obj1;	
	
		
  @Test
  public void f() {
	  //this is my second 
	 
	obj1=  PageFactory.initElements(getdriver(), CustomLibraries.GMILLoginPage.class);
	  startBrowser();
	  waitForElement(10000);
	/*String abc=  getObjName(obj.getTextbox_Email());
	System.out.println(abc);*/
	  waitForElement(10000);
	  clearAndSendkeys(obj1.getTextbox_Email(), "amitoznarang1992");
	  click(obj1.getButton_next());
	  waitForElement(4000);
	  clearAndSendkeys(obj1.getTextbox_password(), "zotimasingh@987");
	  click(obj1.getButton_SignIn());
	  waitForElement(6000);
	/* verifyElementPresentOnPage(icon_account);
	  waitForElement(6000);*/
	  closeBrowser();
  }
}
