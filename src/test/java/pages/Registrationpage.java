package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registrationpage {
	WebDriver driver;

	By login=By.xpath("//a[@id='loginRegisterDropdown']");
	By register =By.linkText("Register");
	By title=By.xpath("//*[@id=\"regTitle\"]");
	By firstname=By.id("registerFName");
	By lastname=By.id("registerLName");
	By email=By.id("registerEmailId");
	By mobno=By.id("registerMobileNo");
	By passwrd=By.id("registerPwd");
	By confrmpaswrd=By.id("registerConfirmPwd");
	By registerbutton=By.id("registerButton");
	By exit=By.xpath("//body/div[@id='header']/div[@id='headercontainer']/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]/span[1]");
	
	
	
		
public Registrationpage (WebDriver driver)
{
	this.driver=driver;
}

public void Createccount()
{
	driver.findElement(login).click();
	driver.findElement(register).click();

}
public void setvalues(String Firstname,String Lastname,String Email,String Mobno,String Password,String Confrmpassword)

{
	
	driver.findElement(title).click();
	
	driver.findElement(firstname).sendKeys(Firstname);
	driver.findElement(lastname).sendKeys(Lastname);
	driver.findElement(email).sendKeys(Email);
	driver.findElement(mobno).sendKeys(Mobno);
	driver.findElement(passwrd).sendKeys(Password);
	driver.findElement(confrmpaswrd).sendKeys(Confrmpassword);
	
	
}
public void account()
{

	driver.findElement(registerbutton).click();
	driver.findElement(exit).click();
	
	
}
}

