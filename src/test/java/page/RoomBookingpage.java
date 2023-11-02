package page;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoomBookingpage {
	WebDriver driver;
	
	By hotelbutton=By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]/div/div/p");
	By destination=By.xpath("//*[@id=\"hotels-destinationV8\"]");
	By locclick=By.xpath("//*[@id=\"723\"]/div/div");
	By checkindate=By.xpath("//*[@id=\"checkIn\"]");
	By thismonthnov=By.xpath("//*[@id=\"ibu_hotel_tools\"]/div/div/div[1]/div[1]/h3");
	By rightarrow=By.xpath("//*[@id=\"ibu_hotel_tools\"]/div/div/div[1]/span[2]");
	By fullmonthnov=By.xpath("//*[@id=\"ibu_hotel_tools\"]/div/div/div[1]/div[2]/div/ul/li/span");
	
	By thismonthdec=By.xpath("//*[@id=\"ibu_hotel_tools\"]/div/div/div[1]/div[1]/h3");
	By fullmonthdec=By.xpath("//*[@id=\"ibu_hotel_tools\"]/div/div/div[1]/div[1]/div/ul/li/span");
	
	By searchbutton=By.xpath("//*[@id=\"ibu_hotel_container\"]/section/article/div/div[1]/div[2]/div[2]/div/div/ul/li[4]/div");
	
	
	
	public RoomBookingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void hotelclick()
	{
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(hotelbutton).click();
		
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
	
	public void locationis()
	{
		driver.findElement(destination).click();
		driver.findElement(destination).sendKeys("Bali",Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(locclick).click();
		
	}
	
	public void goingdate()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.findElement(checkindate).click();
			
			while(true)
			{
				WebElement month=driver.findElement(thismonthnov);
				String month1=month.getText();
				
				if(month1.equals("Nov 2023"))
				{
					System.out.println(month1);
					break;
				}
				else
				{
					driver.findElement(rightarrow).click();
				}
			}
			
			List<WebElement> alldates1= driver.findElements(fullmonthnov);
			
			for(WebElement dateelement:alldates1)
			{
				String date=dateelement.getText();
				System.out.println(date);
				
				if(date.equals("19"))
				{
					dateelement.click();
					break;
				}
			}
	}
	
	public void checkoutdate()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			
			while(true)
			{
				WebElement montho=driver.findElement(thismonthdec);
				String monthx=montho.getText();
				
				if(monthx.equals("Dec 2023"))
				{
					System.out.println(monthx);
					break;
				}
				else
				{
					driver.findElement(rightarrow).click();
				}
			}
			
			List<WebElement> alldates2= driver.findElements(fullmonthdec);
			
			for(WebElement dateelement1:alldates2)
			{
				String date2=dateelement1.getText();
				System.out.println(date2);
				
				if(date2.equals("29"))
				{
					dateelement1.click();
					break;
				}
			}
	
	}
	
	public void searchclick()
	{
		driver.findElement(searchbutton).click();
		System.out.println("Rooms search successfull");
	}
	
}
