package CustomLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GMILLoginPage {
	WebDriver driver;
	
	GMILLoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(how=How.CSS,using="input#Email") private WebElement textbox_Email;
	@FindBy(how=How.CSS,using="input#next")private WebElement button_next;
	@FindBy(how=How.CSS,using="input#Passwd")private WebElement textbox_password;
	@FindBy(how=How.CSS,using="input#signIn")private WebElement button_SignIn;

	
	public WebElement getTextbox_Email() {
		return textbox_Email;
	}
	public WebElement getButton_next() {
		return button_next;
	}
	public WebElement getTextbox_password() {
		return textbox_password;
	}
	public WebElement getButton_SignIn() {
		return button_SignIn;
	}

	

}
