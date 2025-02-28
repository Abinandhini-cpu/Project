package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Jobspage {
	WebDriver driver;
	
	By citiesbutton=By.xpath("//*[@id=\"app\"]/div[2]/div[4]/div/div/div[2]/div/div[6]/div/div[2]");
	By dubaiclick=By.xpath("//*[@id=\"app\"]/div[2]/div[4]/div/div/div[2]/div/div[7]/div/ul/li[1]/div/span[2]/a");
	
	public Jobspage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void jobclick()
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("window.scrollBy(0,10000)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.findElement(citiesbutton).click();
		 driver.findElement(dubaiclick).click();
		 System.out.println("Country search successfull");
		//Username == abinandhini and password == Test@123
		 
	}
	

}
