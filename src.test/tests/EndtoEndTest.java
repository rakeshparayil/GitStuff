package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class EndtoEndTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Invoking driver
		 driver = new ChromeDriver();
		
		//Invoking browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoqa.com/login");
		
		//Logging in
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("sas");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rideca@1");
		
	
		//run javascript code to scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");

		
		driver.findElement(By.xpath("//button[@id='login']")).click();
		
		//Now in profile page scroll down and click the button to go to bookstore page
		Thread.sleep(5000);
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//button[@id='gotoStore']")).click();
		
		//On bookstore page collect all titles to a list of webelement
		List<WebElement> links = driver.findElements(By.cssSelector("a[href*='/books']"));
	
		
		//Using javastrem to find title 'Git Pocket Guide'
		WebElement book =links.stream().filter(l->l.getText()
				.equals("Git Pocket Guide")).findFirst().orElse(null);
		book.click();
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("(//button[normalize-space()='Add To Your Collection'])")).click();
		
		/*Alert alert = driver.switchTo().alert();
		String alerttext =  alert.getText();
		System.out.println(alerttext);
		Thread.sleep(3000);
		alert.accept();*/
		driver.navigate().to("https://demoqa.com/profile");
		
		

        

		
		
		
		

		

		
		
	}

}
