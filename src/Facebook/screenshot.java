package Facebook;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class screenshot
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/");
		// cast the WebDriver object to TakesScreenshot type.
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		 File dstfile = new File("./Screenshot/shivam.png");
		 try 
		 {
			Files.copy(srcfile, dstfile);			 
		 } 
		 catch (Exception e)
		 {
			e.printStackTrace();
		 }
		
		
	}

}