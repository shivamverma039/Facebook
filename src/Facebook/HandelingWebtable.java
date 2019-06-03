package Facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelingWebtable
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		//total row
		String rowxpath = "//table[@id='ctl00_MainContent_orderGrid']//tr";
		List<WebElement> rows = driver.findElements(By.xpath(rowxpath));
		System.out.println("Total rows= "+rows.size());
		//total column in each row except 1st row
		for(int i=1;i<=rows.size();i++)
		{
		String columnxpath = "//table[@id='ctl00_MainContent_orderGrid']//tr["+i+"]//td";
		List<WebElement> colums = driver.findElements(By.xpath(columnxpath));
		System.out.println("Row= "+i+" columns: "+colums.size());
		}
		
		
	}
}
