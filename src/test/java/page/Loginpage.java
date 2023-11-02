package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	WebDriver driver;
	
	By myaccountbutton=By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/button/button");
	By loginbutton=By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div/div/div[1]/a");
	By loginemail=By.xpath("//*[@id=\"emailAddress\"]");
	By loginpassword=By.xpath("//*[@id=\"password\"]");
	
	By loginclick=By.xpath("/html/body/div[4]/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/form/button");
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickbutton()
	{
		driver.findElement(myaccountbutton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(loginbutton).click();
	}
	
	public void login() throws IOException 
	{
		File f=new File("C:\\Users\\abina\\OneDrive\\Documents\\Login_project.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
			String mailid=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Email id is:"+mailid);
			
			String pswd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password: "+pswd);
			
			driver.findElement(loginemail).clear();
			driver.findElement(loginemail).sendKeys(mailid);
			
			driver.findElement(loginpassword).clear();
			driver.findElement(loginpassword).sendKeys(pswd);
			
			driver.findElement(loginclick).click();
			
			System.out.println("Login successfull");
			

		}
	}

}
