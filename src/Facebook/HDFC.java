package Facebook;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFC {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");
		try 
		{
			driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Not Appeared");
		}
		
		driver.findElement(By.id("loginsubmit")).click();
		Set<String> session = driver.getWindowHandles();
		System.out.println("Toatl session:: "+session.size());
		Iterator<String> itr = session.iterator();
		String parentID = itr.next();
		System.out.println("PARENTid= "+parentID);
		String childID= itr.next();
		System.out.println("ChildId= "+childID);
		driver.switchTo().window(childID);
		String cont ="(//div[@class='pdtb25 text-center']/a)[1]";
//		driver.findElement(By.xpath(cont)).click();
		WebElement ele = driver.findElement(By.xpath(cont));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//table//input[@name='fldLoginUserId']")).sendKeys("Avinash");
		driver.findElement(By.xpath("//table//tr[6]//img")).click();				
	}

}
