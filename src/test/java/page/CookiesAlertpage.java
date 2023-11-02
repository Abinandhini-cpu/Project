package page;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesAlertpage {
	WebDriver driver;
	By cookie=By.xpath("/html/body/div[4]/div[2]/div/div/footer/div[2]/span");
	
	public CookiesAlertpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void handle()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(cookie).click();
	}

}
