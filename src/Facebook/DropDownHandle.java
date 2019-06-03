package Facebook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("C:/Users/User/Desktop/BasicHTML.html");
		//Select&Deselct option 
		WebElement single = driver.findElement(By.name("Country"));
		Select dropdown1 = new Select(single);
		dropdown1.selectByIndex(4);
		Thread.sleep(1000);
		dropdown1.selectByValue("3");
		Thread.sleep(1000);
		dropdown1.selectByVisibleText("Japan");
		Thread.sleep(1000);
		
		WebElement multi = driver.findElement(By.name("Courses"));
		Select dropdown2 = new Select(multi);
		dropdown2.selectByIndex(3);
		Thread.sleep(1000);
		dropdown2.selectByVisibleText("Selenium");
		Thread.sleep(1000);
		dropdown2.selectByValue("3");
		Thread.sleep(1000);
		dropdown2.deselectByValue("4");
		Thread.sleep(1000);
		dropdown2.deselectByVisibleText("Selenium");
		Thread.sleep(1000);
		dropdown2.deselectAll();
		//GetOtpion, Print options
		List<WebElement> opt1 = dropdown1.getOptions();
		int count1=opt1.size();
		System.out.println(count1);
		for(int i = 0;i<count1;i++)
		{
			WebElement o1 = opt1.get(i);
			String text1 = o1.getText();
			System.out.println(text1);
		}
		
		List<WebElement> opt2 = dropdown2.getOptions();
		int count2 = opt2.size();
		System.out.println(count2);
		for(int j = 0;j<count2;j++)
		{
			WebElement o2 = opt2.get(j);
			String text2 = o2.getText();
			System.out.println(text2);
		}
				
	}

}
