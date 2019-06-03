package Facebook;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandeling {

	public static void main(String[] args) throws InterruptedException
	{
	 System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://shivam-verma/login.do");
	 driver.findElement(By.name("username")).sendKeys("admin");
	 driver.findElement(By.name("pwd")).sendKeys("manager");
	 driver.findElement(By.id("loginButton")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//span[text()='Help & Support']")).click();
	 driver.findElement(By.xpath("//div[contains(text(),'User Guide')]")).click();
	 //Getting session id
	 Set<String> session = driver.getWindowHandles();
	 System.out.println(session.getClass().getSimpleName());
	 System.out.println("Toatl session:: "+session.size());
	 System.out.println("session Id:: "+session);
	 Iterator<String> itr = session.iterator();
	 String parentId = itr.next();
	 System.out.println("Parent id: "+parentId);
	 String childId = itr.next();
	//switching to windows
	 driver.switchTo().window(childId);
	 System.out.println("Child id: "+childId);
	 Thread.sleep(500);
	 driver.findElement(By.xpath("//a[text()='User Management']")).click();
	 Thread.sleep(500);
	 driver.switchTo().window(parentId);
	 driver.findElement(By.id("logoutLink"));
	 Thread.sleep(500);
	 //driver.close();
	 //driver.quit();	
	 

	}

}
