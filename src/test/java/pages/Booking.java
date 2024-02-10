package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class Booking {
	
	public WebDriver driver;
	By Indiaholidays=By.xpath("//header/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]");
	By international=By.xpath(" //header/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]");
	By eurail=By.xpath("//header/div[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]");
	By cruise=By.xpath("//header/nav[@id='']/div[1]/nav[1]/div[1]/ul[1]/li[5]/a[1]");
	By flight=By.xpath("//header/nav[@id='']/div[1]/nav[1]/div[1]/ul[1]/li[7]/a[1]");
	By cochin=By.xpath("//a[contains(text(),'Cochin, IN - Cochin International (COK)')]");
	By fromcity=By.id("input-search-from");
	By delhi=By.xpath("//a[contains(text(),'Delhi, IN - Indira Gandhi International (DEL)')]");
	By tocity=By.id("input-search-to");
	By departon=By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[1]/form/div[2]/div[2]/div/div[3]/div[1]/input[1]");
	By mnth=By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/div[1]");
	By nextarrw=By.xpath("//body/div[@id='ui-datepicker-div']/div[2]/div[1]/a[1]");
	By date=By.xpath("/html/body/div[11]/div[1]/table/tbody/tr/td/a");
	By returnon=By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[3]/div[2]/input[1]");
	By travellers=By.xpath("//button[@id='travellerDetail']");
	By adult=By.xpath("//body/div[@id='flight-home']/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]");
	By child=By.xpath("//body/div[@id='flight-home']/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[2]");
	By search=By.xpath("//button[@id='search-button']");
	By hotel=By.xpath("//header/div[1]/nav[1]/div[2]/ul[1]/li[7]/a[1]");
	
	
public Booking (WebDriver driver)
	
	{
		this.driver=driver;
		
	}


public void select() throws Exception
{
	driver.findElement(Indiaholidays).click();
	
	
	driver.findElement(international).click();
	driver.findElement(eurail).click();
	//Thread.sleep(3000);
	
	
}

public void windowhandling() throws Exception
{
	
	//driver.findElement(cruise).click();
	
	String parentwindow=driver.getWindowHandle();
	System.out.println("parent window title " +driver.getTitle());
	driver.findElement(cruise).click();
	//Thread.sleep(3000);


	Set<String> allwindowhandles=driver.getWindowHandles();
	for(String handle:allwindowhandles)
	{
		System.out.println(handle);
		
		if(!handle.equalsIgnoreCase(parentwindow))
		{
			driver.switchTo().window(handle);
			Thread.sleep(3000);
		
			
			driver.close();
			
		}
		
		driver.switchTo().window(parentwindow);

}
	
}

public void flightbooking() throws Exception
{
	
	driver.findElement(flight).click();
	
	driver.findElement(fromcity).sendKeys("COK");
	driver.findElement(cochin).click();
	Thread.sleep(3000);

	driver.findElement(tocity).sendKeys("DEL");
	driver.findElement(delhi).click();
	Thread.sleep(3000);
	
	driver.findElement(departon).click();

	while(true)
	{
		WebElement month=driver.findElement(mnth);
		String month1=month.getText();
		if(month1.equals("Feb 2024"))
		{
			System.out.println(month1);
			break;
		}
		else
		{
			driver.findElement(nextarrw).click();
			
		}
	}
	
	
	List<WebElement>alldates1=driver.findElements(date);
	for(WebElement dateelement:alldates1)
	{
		String date=dateelement.getText();
		System.out.println(date);
		if(date.equals("10"))
		{
			System.out.println(date);
			dateelement.click();
			System.out.println("date selected");
			break;		
		}
	}
	
	
	driver.findElement(returnon).click();

	List<WebElement>alldates2=driver.findElements(date);
	for(WebElement dateelement1:alldates2)
	{
		String date1=dateelement1.getText();
		System.out.println(date1);
		if(date1.equals("20"))
		{
			System.out.println(date1);
			dateelement1.click();
			System.out.println("date selected");
			break;		
		}
	}
	
	
	driver.findElement(travellers).click();
	driver.findElement(adult).click();
	driver.findElement(child).click();
	driver.findElement(travellers).click();
	driver.findElement(search).click();
	Thread.sleep(104000);
	driver.findElement(eurail);
}






}
