package page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CarRentalpage {
	WebDriver driver;
	
	By carrentalbutton=By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div/div[1]/div/div/div/div[3]/div/div/p");
	By pickuplocation=By.xpath("//*[@id=\"pickupLocation\"]");
	By locationis=By.xpath("//*[@id=\"item-0-0\"]/span[2]");
	By returncheckbox=By.xpath("//*[@id=\"ct-checkbox\"]/div/div/label");
	
	By dropofflocation=By.xpath("//*[@id=\"returnLocation\"]");
	By tolocationis=By.xpath("//*[@id=\"item-1-0\"]");
	
	By  startdatebutton=By.xpath("//*[@id=\"ct-pickup-date\"]");
	By thismonth=By.xpath("//*[@id=\"ct-pickup-calendar\"]/div/div/div[2]/div/div/div[1]/div/p");
	By dateclick=By.xpath("//*[@id=\"day-20231125\"]");
	
	By pickuptimebutton=By.xpath("//*[@id=\"pickupTime\"]");
	
	By enddatebutton=By.xpath("//*[@id=\"ct-return-calendar\"]/div");
	By enddateclick=By.xpath("//*[@id=\"day-20231130\"]/span");
	
	By returntime=By.xpath("//*[@id=\"returnTime\"]");
	By timereturn=By.xpath("//*[@id=\"ct-return-timers\"]/ct-time-picker-custom/div/ul/li[22]");
	
	By searchbutton=By.xpath("//*[@id=\"searchCarsFormBtn-searchcars\"]");
	
	By dropdownbutton=By.xpath("//select[@id=\"residenceCode\"]");
	
	public CarRentalpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void carrentalclick()
	{
		driver.findElement(carrentalbutton).click();
		Set<String> windowHandles = driver.getWindowHandles();

	      for (String windowHandle : windowHandles)
	      {
	         driver.switchTo().window(windowHandle);
	         System.out.println("Title of the window: " + driver.getTitle());
	      }	
		
	}
	
	public void details()
	{
		driver.findElement(pickuplocation).click();
		driver.findElement(pickuplocation).sendKeys("Kochi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(locationis).click();
		
		driver.findElement(returncheckbox).click();
		
		driver.findElement(dropofflocation).click();
		driver.findElement(dropofflocation).sendKeys("Trivandrum");
	
		driver.findElement(tolocationis).click();
		
	}
	
	public void dateandtime()
	{
		driver.findElement(startdatebutton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(dateclick).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
		
		driver.findElement(enddatebutton).click();
		driver.findElement(enddateclick).click();
		
		driver.findElement(returntime).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(timereturn).click();
	}
	
	public void searchclick()
	{
		driver.findElement(searchbutton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Set<String> windowHandles = driver.getWindowHandles();

	      // Iterate through each window handle
	      for (String windowHandle : windowHandles)
	      {
	         // Switch to the desired window
	         driver.switchTo().window(windowHandle);
	         // Perform actions on the window
	         System.out.println("Title of the window: " + driver.getTitle());
	      }	
		
	}
	
	public void countrydropdown()
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(dropdownbutton).click();
		WebElement country=driver.findElement(By.xpath("//*[@id=\"residenceCode\"]"));
		Select c=new Select(country);
		c.selectByVisibleText("Hungary");
		System.out.println("Car search successful");
		
		
	}

}
