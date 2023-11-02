package page;

import org.openqa.selenium.WebDriver;

public class ContentTitlepage {
	WebDriver driver;
	
	public ContentTitlepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void titleverification()
	{
		String s=driver.getTitle();
		System.out.println("Actual Result:"+s);
		
		String s1="Cheap International & Domestic Flights | BudgetAir® India";
		if(s.equals(s1))
		{
			System.out.println("Title verification Pass");
		}
		else
		{
			System.out.println("Title verification Fail");
		}
	}
	
	public void contentverification()
	{
       String m=driver.getPageSource();
		
		String m1="My Account";
		
		if(m.contains(m1))
		{
			System.out.println("Content verification Pass");
		}
		else
		{
			System.out.println("Content verification Fail");
		}
	}
	

}
