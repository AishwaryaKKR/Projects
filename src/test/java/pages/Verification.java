package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verification {
	
	public WebDriver driver;
	By logo=By.xpath("//header/div[1]/div[1]/a[1]/img[1]");
	
	By Tagname=By.tagName("a");

public Verification (WebDriver driver)
	
	{
		this.driver=driver;
		
	}	
	
public void titleverify()
{
	
	String actualtitle=driver.getTitle();
	System.out.println("Actual title is:"+actualtitle);
	
	String exp= "SOTC - Best Tours and Travel Agency in India | Book Tour Packages Now!";

	if(actualtitle.equals(exp))
			{
		System.out.println("Title verification is passed");
		
			}
	else
	
	{
		System.out.println("Title verification is failed");
	}
}


public void logoverify()
{
	if(driver.findElement(logo).isDisplayed())
	{
		System.out.println("Logo is displayed");
	}
	else
	{
		System.out.println("Logo is not displayed");
	}
}
	
	public void Contentverify()
	{
		String content=driver.getPageSource();
		if(content.contains("Trending Indian Destinations"))
		{
			System.out.println("Content is pass");
			
		}
		else
		{
			System.out.println("Content is fail");
		}
	}
	
	
	
	
	public void linkvalidation()
	{
		List<WebElement> li=driver.findElements(Tagname);
		for(WebElement s:li)
		{
			String link=s.getAttribute("href");
			linkverify(link);
			
		}
			
	}
	
private void linkverify(String link)
{
		
		try {
			URL ob =new URL(link);
			HttpURLConnection con =(HttpURLConnection)ob.openConnection();
			con.connect();
		
		
		if(con.getResponseCode()==200)
		{
			System.out.println("valid----"+link);
		}
		else if(con.getResponseCode()==404)
		
		{
			System.out.println("brokenlink----"+link);
		}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		}

	
	
public void linkcount()
{
	List<WebElement> li = driver.findElements(Tagname);
	System.out.println("link count"+li.size());
	
	
	for (WebElement s:li)
	{
		String link = s.getAttribute("href");
		String text =s.getText();
		System.out.println(link+"----"+text);
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
}
















