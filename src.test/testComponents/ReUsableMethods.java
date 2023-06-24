package testComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ReUsableMethods {
	
	public ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		   //Driver setup
		
	    driver= new ChromeDriver() ;
		
		//Invoking Browser 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://demoqa.com/login");
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("sas");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rideca@1");
		
		//run javascript code
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//button[@id='login']")).click();
		Thread.sleep(3000);
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//button[@id='gotoStore']")).click();
	}
	
	public String getScreenshot(String testcaseName,ChromeDriver driver ) throws IOException  
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//destination file path at project level
		File dest = new File(System.getProperty("user.dir")+ "//reports//" + testcaseName + ".png");
		
		FileHandler.copy(source,dest);
		
	    //Copy path return as string
		return System.getProperty("user.dir")+ "//reports//" + testcaseName + ".png";
	}
	
	@AfterMethod
	public void closingMethod()
	{
		driver.quit();
	}

	

}
