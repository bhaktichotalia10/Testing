import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class datadriven {

	public static void main(String[] args) throws IOException{
		try{
			FileInputStream fi = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Testing\\test.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sh = wb.getSheetAt(0);
			Row r = sh.getRow(0);
			Cell c = r.getCell(0);
			System.out.println(c);
			
			//Open the site using driver.get()
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			/*driver.get(c.toString());
			driver.findElement(By.name("q")).sendKeys("mobiles");*/
			
			/*//Write to the excel file from website
			driver.get("https://www.flipkart.com/search?q=mobiles&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
			String s = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
			System.out.println(s);*/
			
			//add data to the new row  
			int rowCount=0;
			Row newRow = sh.createRow(rowCount+1);
			
			//create a loop over the cell of newly created row
			for(int j = 0; j<r.getLastCellNum(); j++){
				//fill data in row
				Cell cell = newRow.createCell(j);
				cell.setCellValue("new data");
				//cell.setCellValue(s);
			}
			fi.close();
			FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\Testing\\test.xlsx");
			wb.write(outputStream);
			outputStream.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}