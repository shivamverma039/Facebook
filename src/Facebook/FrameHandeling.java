package Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandeling {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/");	
		//need to switch on frame
		driver.switchTo().frame("packageListFrame");
		String xp = "//ul[@title='Packages']//a[text()='com.thoughtworks.selenium']";
		driver.findElement(By.xpath(xp)).click();
		//switch again to default frame 
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("DefaultSelenium")).click();
		//switch to frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("WebDriverBackedSelenium")).click();
		System.out.println("Shivam");
	}

}
