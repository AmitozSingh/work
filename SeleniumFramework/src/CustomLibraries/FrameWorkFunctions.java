package CustomLibraries;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;











import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class FrameWorkFunctions {
	WebDriver driver = null;
	private Map<String, String> cache;
	 private static String passText = "PASS: ";
	  private static String failText = "FAIL: ";
	  private static String verificationHighlightColor = "magenta";
	  protected static Map<String, String> objMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
	
	public void  startBrowser()
	{
		String TestFile = "C:\\Users\\TATA-OMNI\\workspace\\Config\\config.txt";
		try {
			FileReader FR=new FileReader(TestFile);
			BufferedReader BR=new BufferedReader(FR);
			String Content ="";
			String URL="";
			String bwsr="";
			
			try {
				while((Content=BR.readLine())!=null)
				{
					if((Content.contains("testUrl"))&&(!Content.startsWith("#")))
					{
						 String URLtemp[]=Content.split("=");
						 URL=URLtemp[1].trim();
						 }
					else if((Content.contains("browser"))&&(!Content.startsWith("#")))
						
					{
						 String browsertemp[]=Content.split("=");
						 bwsr=browsertemp[1].trim().toLowerCase();	
					}
				}
				System.out.println(URL);
				System.out.println(bwsr);
				
				
				if(bwsr.equalsIgnoreCase("firefox"))
				{
					 driver=new FirefoxDriver();
					 driver.manage().deleteAllCookies();
					 driver.manage().window().maximize();
					 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
				else if(bwsr.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\TATA-OMNI\\workspace\\Chrome Driver\\chromedriver.exe");
					driver=new ChromeDriver();
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
				
				driver.get(URL);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public WebDriver getdriver()
	{
		
			return driver;
			
	}
	public void logReport(String message)
	{
		Reporter.log(message);
	}

	public void click(By Element)
	{
		getdriver().findElement(Element).click();
	}
	public void clearAndSendkeys(By Element,String data)
	{
		getdriver().findElement(Element).clear();
		getdriver().findElement(Element).sendKeys(data);
	}
	
	public void  cacheObjRepository()
	
	{  String key = "";
		String value = "";
		try {
			
			Class <ObjectRepository> classobj=ObjectRepository.class;
			Field[] fields=classobj.getFields();
			for(int i=0;i<fields.length;i++)
			{
				 key = fields[i].get(this).toString();
				 value = fields[i].getName();
			
			if(objMap.containsKey(key))
			{
				value=value+"|"+(String)objMap.get(key);
			}
			 objMap.put(key, value);
		        cache.put(key, value);
			
			}
			
			
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
			// TODO: handle exception
		}
		
	}
	
	/*public void verifyElementPresentOnPage(By locator)
	{
		try {
			WebElement element=getdriver().findElement(locator);
			if(element.isDisplayed())
			{
				 logReport(passText + "verifyElementPresentOnPage: Element found. Element-> " + getObjName(locator));
			}
			else
				{
				 logReport(failText + "verifyElementPresentOnPage: Element NOT found. Element-> " + getObjName(locator));
				}
			
			
		} catch (Exception e1) {
			logReport(failText + "verifyElementPresentOnPage: Element NOT found. Element-> " + getObjName(locator));
		}
		
		
	}*/
	
	 @BeforeSuite(alwaysRun=true)
	  public void bootCTM()
	  {
	    
	    cacheObjRepository();
	  }
	 
	public void closeBrowser()
	{
		getdriver().close();
	}
	
	 public String getObjName(By locator)
	  {
		 return (String)objMap.get(locator.toString());
		 
	  }
}


