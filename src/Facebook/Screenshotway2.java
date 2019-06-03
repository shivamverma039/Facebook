package Facebook;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.io.Files;

public class Screenshotway2 {

	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	//using Event firing webdriver class
	EventFiringWebDriver efw= new EventFiringWebDriver(driver);
	File srcfile=efw.getScreenshotAs(OutputType.FILE);
	File destfile = new File("./Screenshot/Google.png");
	try 
	{
		Files.copy(srcfile, destfile);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	}

}
