package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Scrnshts {
	public WebDriver driver;
	By scrnsht=By.xpath("//select[@id='residenceCountry']");


public Scrnshts(WebDriver driver)
	
	{
		this.driver=driver;
		
	}


public void elementscreensht() throws IOException

{
	WebElement element=driver.findElement(scrnsht);
	File src1=element.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src1,new File("./Screenshotts//Elementsscreenshot.png"));
}

public void scrnshots() throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src,new File("E:\\holiday.png"));
}













}
