package Facebook;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

public class HandlingMouseOperations {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		//Action class
		Actions act = new Actions(driver);
		//Mouse Over
		WebElement hf = driver.findElement(By.xpath("//span[text()='Home & Furniture']"));
		act.pause(500).perform();
		act.moveToElement(hf).perform();
		//Click
		WebElement painting = driver.findElement(By.xpath("//a[text()='Paintings']"));
		act.pause(500).perform();
		act.click(painting).perform();
		//Range Slider
		act.pause(2000).perform();
		WebElement rightslider = driver.findElement(By.xpath("//div[@class='_3G9WVX _2N3EuE']"));
		act.clickAndHold(rightslider).perform();
		act.moveByOffset((int) -60.3925, 0).perform();
		act.release(rightslider).perform();
		act.pause(2000).perform();
		WebElement leftslider = driver.findElement(By.xpath("//div[@class='_3G9WVX oVjMho']"));
		act.clickAndHold(leftslider).perform();;
		act.moveByOffset((int) 59.2025, 0).perform();
		act.release(leftslider).perform();
		act.pause(2000).perform();
		//checkbox selection
		String xp= "//img[contains(@src,'flixcart.com')]/ancestor::div/preceding-sibling::input";
		WebElement checkbox = driver.findElement(By.xpath(xp));
		boolean flag = checkbox.isSelected();
		System.out.println("Checkbox not selected= "+flag);
		act.click(checkbox).perform();
		//Keyboard keys
		WebElement searchbox = driver.findElement(By.name("q"));
		act.sendKeys(searchbox, "Samsung").perform();
		act.pause(2000).perform();
		act.sendKeys(searchbox, Keys.ARROW_DOWN).perform();
		act.sendKeys(searchbox,Keys.ARROW_DOWN).perform();
		act.sendKeys(searchbox,Keys.ENTER).perform();
   }
}