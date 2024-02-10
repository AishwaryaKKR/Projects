package Tests;

import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pages.Booking;
import pages.Loginpage;
import pages.Registrationpage;
import pages.Scrnshts;
import pages.Verification;


public class  Sotc_Test 
{
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
	}
	
	@BeforeMethod
	public void url()
	{
		
		driver.get("https://www.sotc.in/");
		driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	}
	
	@Test(enabled=false)
//Registration
public void Regist() throws IOException
{
	Registrationpage ob=new Registrationpage(driver);
	ob.Createccount();
	ob.setvalues("Aishwarya", "Radhakrishnan", "kkraishwarya@gmail.com", "6282032010", "Aishu@123", "Aishu@123");
	ob.account();
	driver.navigate().refresh();
	
	
	
} 

	@Test
public void Login () throws Exception
	{
	Loginpage lp=new Loginpage(driver);
	
	
	
	lp.cookies();
	lp.click();
	
	
	String xl="D:\\pjt.xlsx";
	String sheet="sheet1";
	int rowcount=Loginpage.getRowCount(xl, sheet);
	for(int i=1;i<=rowcount;i++)
	{
		String email=Loginpage.getcell(xl, sheet, i, 0);
		System.out.println("emailid----"+email);
	    String password=Loginpage.getcell(xl, sheet, i, 1);
	    System.out.println("pass----"+password);
	lp.setvalues(email, password);
	lp.login();		

	
	}
}

	@Test(enabled=false)
public void verify()
{
	Verification v1=new Verification(driver);
	v1.titleverify();
	v1.logoverify();
	v1.Contentverify();
	//v1.linkvalidation();
	//v1.linkcount();
}

	
		
	
	@Test
	public void booking() throws Exception
	{
		Booking b1=new Booking(driver);
		b1.select();
		b1.windowhandling();
		
		b1.flightbooking();
		
	}
	

	@Test
	public void screenshotts() throws IOException
	{
		Scrnshts s1=new Scrnshts(driver);
		s1.scrnshots();
		//s1.elementscreensht();
	}

























}


	
	


	
	
	










	
	




	


