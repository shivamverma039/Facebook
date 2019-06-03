package Facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableDataPrint
{

	public static void main(String[] args)
	{
		//http://learnselenium.techcanvass.com/handling-a-web-table-in-selenium-3-0/
		System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		//First get the entire html table and store this in a variable ‘webtable’ of type web element.
		WebElement table = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']"));
		//Get all the rows with tag name ‘tr’ and store all the elements in a list of web elements
		//Now all the elements with tag ‘tr’ are stored in ‘rows’ list.
		List<WebElement> row = table.findElements(By.tagName("tr"));
		System.out.println("Total rows: "+row.size());
		
		for(int rn=1; rn<= row.size() ; rn++)
		{
			//Get the number of columns. Here we have used “tagName” of columns – “th”. Please note that this represents the heading row only.
			List<WebElement> col = table.findElements(By.tagName("th"));
			//System.out.println("Total col: "+col.size());
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

