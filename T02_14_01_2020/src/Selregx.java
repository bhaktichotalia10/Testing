import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selregx {

	public static void main(String[] args) {
		//String regex
		String regx = "newWorldOrder2020vinmar";
		if(regx.matches("new[A-Z]....[A-Z]....202[0-9].*")){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}
				
		// regex for website inspect
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String regx1 = "u_0_6";
		if(regx1.matches("[a-z]_[0-9].*")){
			WebElement radio = driver.findElement(By.id(regx1));
			radio.click();
		}
		else{
			System.out.println("Radio not found");
		}
		
		//search on google
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement we = driver.findElement(By.xpath("//*[@id='gbqfb']"));
		we.sendKeys("not able to see sponsored linked on google search");
		driver.findElement(By.xpath("//*[@id='gbqfb']")).click();
		List<WebElement> allElements = driver.findElements(By.xpath("//h3/a"));
		for(WebElement element : allElements){
			allElements.size();
			System.out.println(element.getText());
		}		
	}

}
