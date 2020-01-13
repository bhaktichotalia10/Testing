import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumWebDriver {
	private static String fileWithPath;
	
	public static void main(String[] args) throws InterruptedException, IOException{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
	//	DesiredCapabilities capabilities  = DesiredCapabilities.firefox();
	//	capabilities.setCapability("marionette", true);
		WebDriver driver = new ChromeDriver();
		
		//redirect to page
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("mobiles");
		
		//check box redirection
		driver.get("https://www.flipkart.com/search?q=mobiles&as=on&as-show=on&otracker=AS_Query_TrendingAutoSuggest_1_0_na_na_na&otracker1=AS_Query_TrendingAutoSuggest_1_0_na_na_na&as-pos=1&as-type=TRENDING&suggestionId=mobiles&requestId=0c6d0c9b-04f2-48ce-a47b-7f15e815097f&as-backfill=on");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement chkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div[1]/div/section[4]/div[2]/div/div[2]/div/div/label/div[2]"));
		chkbox.click();
				
		//radio button redirection
		driver.get("https://www.facebook.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement radio = driver.findElement(By.id("u_0_6"));
		radio.click();
		
		
		//link text redirection
		driver.get("https://www.facebook.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement linktext = driver.findElement(By.linkText("Sign Up"));
		linktext.click();
		
		
		//select option from drop down
		driver.get("https://www.facebook.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select drpCountry = new Select(driver.findElement(By.id("month")));
		drpCountry.selectByVisibleText("Oct");
		
		//taking a screenshot
		driver.get("https://www.facebook.com/");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/Users/ADMIN/Desktop/Testing/1.png"));
		
	}

}
