package Facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PrintcompanyNameISTQB {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.istqb.in/");	
		//actionClass
		Actions act = new Actions(driver);
		//move to about us
		WebElement abt = driver.findElement(By.xpath("//div[@id='tmMainMenu']//a[text()='ABOUT US']"));
		act.moveToElement(abt).perform();
		driver.findElement(By.xpath("//a[text()='ABOUT US']/following-sibling::div//a[text()='AFFILIATED COMPANIES']")).click();
		List<WebElement> alpha = driver.findElements(By.xpath("//div[@id='tmTopD']//li"));
		for (int i = 1; i <= alpha.size(); i++) 
		{
			System.out.println("Alphabet No.: "+i);
			WebElement ele = driver.findElement(By.xpath("//div[@id='tmTopD']//li["+i+"]/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			List<WebElement> alllinks = driver.findElements(By.xpath("//div[@id='tmMainBody']//a"));
			for (int j = 0; j < alllinks.size(); j++)
			{

				WebElement link = alllinks.get(j);
				boolean flag = link.isDisplayed();
				if (flag) 
				{
				System.out.println(link.getText());	
				} else 
				{

				}					
				
			}
			
		}
		
	}

}
