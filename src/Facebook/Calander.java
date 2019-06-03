package Facebook;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@id='root']//span[text()='DEPARTURE']")).click();
		//current Date, month & Year
		int currentDate = LocalDate.now().getDayOfMonth();
		System.out.println("Current Date: "+currentDate);
		int currentMV=LocalDate.now().getMonthValue();
		System.out.println("Current Month Value: "+currentMV);
		int expMV=LocalDate.now().plusMonths(3).getMonthValue();
		System.out.println("Expected Month: "+expMV);
		int expDate = LocalDate.now().plusDays(16).getDayOfMonth();
		System.out.println("Expected Date: "+expDate);
		String expMN = LocalDate.now().plusMonths(5).getMonth().name().toLowerCase();
		expMN=expMN.substring(0,1).toUpperCase()+expMN.substring(1);
		System.out.println("Expected Month: "+expMN);
		for (int i = currentMV; i < expMV ; i++)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}	
		Thread.sleep(1000);
		String xp = "//div[starts-with(text(),'"+expMN+"')]/ancestor::div/following-sibling::div//p[text()='"+expDate+"']";
		driver.findElement(By.xpath(xp)).click();
	}

}
