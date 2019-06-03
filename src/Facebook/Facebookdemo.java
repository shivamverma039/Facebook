package Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebookdemo {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./src/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//WebElement untxtbx=driver.findElement(By.name("firstname"));
		//untxtbx.sendKeys("shivam");	
		//WebElement hehe=driver.findElement(By.name("lastname"));
		//hehe.sendKeys("Verma");
		driver.findElement(By.name("firstname")).sendKeys("Shivam");
		driver.findElement(By.name("lastname")).sendKeys("Verma");
		driver.findElement(By.name("reg_passwd__")).sendKeys("sjhfsakjhfsjhf");
	}

}
