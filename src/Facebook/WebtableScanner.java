package Facebook;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableScanner
{

	public static void main(String[] args) 
	{
		//http://learnselenium.techcanvass.com/handling-a-web-table-in-selenium-3-0/
				System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");	
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
				driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
				driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
				driver.findElement(By.id("ctl00_MainContent_login_button")).click();
				WebElement table = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']"));
				List<WebElement> row = table.findElements(By.tagName("tr"));
				System.out.println("Total rows: "+row.size());
				
				for(int rn=1; rn<= row.size() ; rn++)
				{
					List<WebElement> col = table.findElements(By.tagName("th"));
					System.out.println("Row: "+rn+" Coloms: "+col.size());
					for (int cn = 1; cn <= col.size(); cn++) 
						{
						if (rn==1) 
						{
							String xp = "//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]//th["+cn+"]";
							System.out.println(driver.findElement(By.xpath(xp)).getText());
						} else
						{
							String xp = "//table[@id='ctl00_MainContent_orderGrid']//tr["+rn+"]//td["+cn+"]";
							System.out.println(driver.findElement(By.xpath(xp)).getText());
						}
				}
								
						
		}
	
	}

}
