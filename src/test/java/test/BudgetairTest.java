package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.CarRentalpage;
import page.ContentTitlepage;
import page.CookiesAlertpage;
import page.Jobspage;
import page.Loginpage;
import page.RoomBookingpage;
import page.SignUppage;

public class BudgetairTest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.budgetair.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1() throws IOException
	{
		ContentTitlepage obj=new ContentTitlepage(driver);
		obj.titleverification();
		obj.contentverification();
		
		CookiesAlertpage obj1=new CookiesAlertpage(driver);
		obj1.handle();
		driver.navigate().refresh();
		
		
		SignUppage obj2=new SignUppage(driver);
		obj2.clicksignup();
		obj2.filldetails("Abinandhini", "Abi","03abinandhinialbt18cs1@gmail.com", "Potato$321");
		obj2.signupfinalclick();
		
		
		Loginpage obj3=new Loginpage(driver);
		obj3.clickbutton();
		obj3.login();
		
		
	    RoomBookingpage obj4=new RoomBookingpage(driver);
		obj4.hotelclick();
		obj4.locationis();
		obj4.goingdate();
		obj4.checkoutdate();
		obj4.searchclick(); 
		
		
		Jobspage obj5=new Jobspage(driver);
		obj5.jobclick(); 
		
		CarRentalpage obj6=new CarRentalpage(driver);
		obj6.carrentalclick();
		obj6.details();
		obj6.dateandtime();
		obj6.searchclick();
		obj6.countrydropdown();
		
		
		
	}
	
	

}

