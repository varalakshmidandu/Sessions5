package learntestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest2 {

	
	WebDriver driver;
	By USERNAME = By.xpath("//*[@id=\"username\"]");
	By PASSWORD = By.xpath("//*[@id=\"password\"]");
	By LOGIN = By.xpath("/html/body/div/div/div/form/div[3]/button");
    By DASHBOARD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
    
    String userName = "demo@techfios.com";
    String passWord = "abc123";
    String expectedTitle = "Dashboard";
    
    @BeforeMethod
    public void initDrive() {

		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\dandu\\June22_Selenium\\Sessions5\\driver\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.get("https://www.techfios.com/billing/?ng=admin");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
    }
	
	@Test
	public void loginTest() {
	
		    driver.findElement(USERNAME).sendKeys(userName);
		    driver.findElement(PASSWORD).sendKeys(passWord);
		    driver.findElement(LOGIN).click();
		    Assert.assertEquals(driver.findElement(DASHBOARD).getText(), expectedTitle,"Page  not found"); 
		    
//		     Assert.assertEquals(driver.getTitle(),"Dashboard- iBilling","Page  not found"); 
//			 Assert.assertTrue(driver.findElement(DASHBOARD).isDisplayed(),"Page not found");
//			 Assert.assertTrue(driver.findElement(DASHBOARD).isDisplayed(),"abcdf");
	    
			}
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
	}
}
