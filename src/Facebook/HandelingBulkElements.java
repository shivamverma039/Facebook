package Facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelingBulkElements {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.istqb.in/");
		List<WebElement> link = driver.findElements(By.tagName("a"));
		int count = link.size();
		//Total link
		System.out.println("All links: " +count);
		//Text of all links
		for (int i=0;i<count;i++)
		{
			 WebElement n = link.get(i);
			 String out = n.getText();
			 System.out.println(out);
		}
		//Only Displayed Link
		for(int i=0;i<count;i++)
		{
			WebElement l = link.get(i);
			boolean flag = l.isDisplayed();
			if(flag)  //true
			{
				System.out.println(l.getText());
			}
			else
			{
				System.out.println("link is not displayed");
			}
		}
		
		
	}

}
