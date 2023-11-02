package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SignUppage {
WebDriver driver;

By myaccountbutton=By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/button/button");
By loginbutton=By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div/div/div[1]/a");
By createaccountbutton=By.xpath("/html/body/div[4]/div[2]/div/div/div/div/div[3]/div/div/a");

By firstname=By.xpath("//*[@id=\"firstName\"]");
By lastname=By.xpath("//*[@id=\"lastName\"]");
By email=By.xpath("//*[@id=\"email\"]");
By password=By.xpath("//*[@id=\"password\"]");

By signupbutton=By.xpath("/html/body/div[4]/div[2]/div/div/div/div/div[2]/div[1]/form/button");



	
	public SignUppage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clicksignup()
	{
		driver.findElement(myaccountbutton).click();
		driver.findElement(loginbutton).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)", "");
		driver.findElement(createaccountbutton).click();
			
	}
	
	
	public void filldetails(String fname,String lname,String mailid, String pswd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(email).sendKeys(mailid);
		
		driver.findElement(password).sendKeys(pswd);
		js.executeScript("window.scrollBy(0,100)", "");
	}
	
	public void signupfinalclick()
	{
		driver.findElement(signupbutton).click();
		System.out.println("Signup successful");
	}
	
}
