import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
public class Jabongg {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//login
		driver.get("https://www.jabong.com/customer/account/login/");
		driver.findElement(By.id("login-email")).sendKeys("akash@oovy.org");
		driver.findElement(By.id("login-pwd")).sendKeys("qwerty123");
		WebElement button=driver.findElement(By.id("btn-login"));
		button.click();
		driver.get("https://www.jabong.com/");
		
		
		//search product
		driver.findElement(By.id("search")).sendKeys("tshirt for boys");
		WebElement button2=driver.findElement(By.xpath("/html/body/div/div[3]/header/div[1]/div[2]/div/div/div[1]/span"));
		button2.click();
		
		//details of the product
		driver.get("https://www.jabong.com/find/tshirt-for-boys?tt=&rank=0");
		WebElement button3=driver.findElement(By.xpath("/html/body/section[1]/div/section/div/section/section[2]/div[1]/a/figure/img"));
		button3.click();
		
		//select size of the product and add to cart
		driver.get("https://www.jabong.com/yk-disney-grey-printed-round-neck-t-shirt-9915687.htm?pos=1");
		Select drpsize=new Select(driver.findElement(By.xpath("/html/body/section/section/div[2]/div[1]/div[2]/div/div[2]/div/div[4]/div/select")));
		drpsize.selectByVisibleText("2-3Y");
		WebElement button4=driver.findElement(By.xpath("/html/body/section/section/div[2]/div[1]/div[2]/div/div[3]/div/div/form/button"));
		button4.click();
		
		//view cart
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement button5=driver.findElement(By.xpath("/html/body/section/section/div[1]/div[1]/section/section/div[3]/div/div[3]/a"));
		button5.click();
		driver.get("https://www.jabong.com/cart/");
		
		//place order
		WebElement button6=driver.findElement(By.xpath("/html/body/section[1]/section/div/section[2]/div/div[2]/div[2]/a"));
		button6.click();
		driver.get("https://www.jabong.com/checkout/");
		
		//login again to place order
		driver.findElement(By.id("login-email")).sendKeys("akash@oovy.org");
		driver.findElement(By.id("login-pwd")).sendKeys("qwerty123");
		WebElement button7=driver.findElement(By.id("btn-login-checkout"));
		button7.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//proceed to pay
		WebElement button8=driver.findElement(By.xpath("/html/body/section/section/div/section[1]/div/section[2]/div[2]/section/div[2]/button"));
		button8.click();
	}
}