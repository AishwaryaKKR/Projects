package pages;




import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Loginpage {
	
	public WebDriver driver;
	
	By cookie=By.xpath("//*[@id=\"showCookeiPolicyCloce\"]");
	By signin=By.xpath("//a[@id='loginRegisterDropdown']");
	By log=By.id("mainLogIn");
	By email=By.id("loginId");
	By pass=By.id("tc_login_pass");
	By password=By.id("existloginPass");
	By login=By.id("loginButton");
	
	
	public Loginpage(WebDriver driver)
	
	{
		this.driver=driver;
		
	}
	public static int getRowCount(String xl,String sheet)
	{
		try
		
		{
			File f= new File(xl);
			FileInputStream fi=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			return wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e)
		{
			return 0;
		}
		
	}
	public static String getcell(String xl,String sheet,int r,int c)
	{
		try
		{
			File f =new File(xl);
			FileInputStream fi= new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFCell cell=(XSSFCell) wb.getSheet(sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				return cell.getRawValue(); //sendkeys support only String values
			}
		}
		catch (Exception e)
		{
			return "";
		}
		
	}
	

public void cookies()
{
	driver.findElement(cookie).click();
}
	
	public void setvalues(String Email,String Password)
	{
	
		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(Email);
		driver.findElement(pass).click();
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(Password);

		
	}
	
	

	public void click()
	{
		driver.findElement(signin).click();
		driver.findElement(log).click();
	}
	public void login()
	{
		driver.findElement(login).click();
		
	}
	
	
	
	
	
	}
	
	

	
	
	

	
	


