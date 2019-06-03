package Facebook;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateUtilities {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@id='root']//span[text()='DEPARTURE']")).click();
		//Current Month,Year, date & name
		int currentMV = LocalDate.now().getMonthValue();
		System.out.println(currentMV);
		int curYear = LocalDate.now().getYear();
		System.out.println(curYear);
		String currentMN = LocalDate.now().getMonth().name();
		System.out.println(currentMN);
		int currentDate = LocalDate.now().getDayOfMonth();
		System.out.println(currentDate);
		//convert to lower case
		currentMN =currentMN.toLowerCase();
		System.out.println(currentMN);
		//Actual Name
		String actualCMN=currentMN.substring(0, 1).toUpperCase()+currentMN.substring(1);
		System.out.println(actualCMN);
		//
		//Expected Month
		String exMN = LocalDate.now().plusMonths(3).getMonth().name().toLowerCase();
		System.out.println(exMN);
		exMN = exMN.substring(0, 1).toUpperCase()+exMN.substring(1);
		System.out.println(exMN);
		int exMV = LocalDate.now().plusMonths(3).getMonthValue();
		System.out.println(exMV);
		int expDate=LocalDate.now().plusDays(2).getDayOfMonth();
		System.out.println(expDate);
		int expYear=LocalDate.now().plusYears(1).getYear();
		System.out.println(expYear);		
	}

}
