package Testpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.thoughtworks.selenium.webdriven.Windows;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.*;

public class One {
	WebDriver driver;
	
	String exePath = new String("C:\\ETLHive\\chromedriver.exe");
	
	
	
	
	@BeforeSuite
	
	public void beforeSuite()
	{
		System.out.println("beforeSuite");
	}

	@BeforeTest
	public void beforeTest(){
		System.out.println("before test");
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("before Class");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("before Method");
		//driver = new FirefoxDriver();
	}
	
	@Test (enabled = false)
	//(priority=0)
	
	public void test(){
		System.out.println("test");
		driver = new ChromeDriver();
		//driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
		driver.get("http://www.zlti.com/");
		List <WebElement> we = driver.findElements(By.xpath("//*[@id='genesis-nav-primary']/div/ul/li[contains(@id,'menu-item-')]"));
		// = driver.findElements(By.xpath("//*[@id='genesis-nav-primary']descendant::/div/ul/li[contains(@id,'menu-item-')]"));
		for(WebElement e1:we){
		
		String expected="Some Text";
		//Assert.assertEquals(expected, e1.getText());//hard assert
		
		SoftAssert sa = new SoftAssert();//soft assert
		sa.assertEquals(e1.getText(), expected);
	
		System.out.println(e1.getText());
		sa.assertAll();
		}
		 
	//driver.get("https://github.com/");
	//	WebElement e= driver.findElement(By.xpath("//*[@id='user[password]']");
	
		
	}
	
	@Test (enabled = false)
	public void test2(){
		System.out.println("test2");
		
			//int i= 1/0;
		
			//throw new SkipException("skipped test test");
		driver = new ChromeDriver();
		//driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
		driver.get("https://github.com/login");
		WebElement u= driver.findElement(By.xpath("//*[@id='login_field']"));
		u.sendKeys("user1");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement e= driver.findElement(By.xpath("//*[@id='password']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		e.sendKeys("abcd");
		//*[@id="login"]/form/div[4]/input[3]
		WebElement e2 = driver.findElement(By.xpath("//*[@id='login']/form/div[4]/input[3]"));
		e2.click();
		driver.get("https://github.com/login");
		WebElement e3= driver.findElement(By.xpath("//*[@id='password']"));
		e3.sendKeys("zyawd");
		WebElement e4 = driver.findElement(By.xpath("//*[@id='login']/form/div[4]/input[3]"));
		e4.click();
		
	}
	
	@Test (enabled = false)
	public void autoittest() throws IOException{
		
		String path="C:\\ETLHive\\AutoITScript2.au3";
		driver.get("C:\\ETLHive\\HTMLTag.html");
	WebElement e=	driver.findElement(By.xpath("//*[@id='File1']"));
	//e.click();

	e.sendKeys("C:\\ETLHive\\TestFile.txt");//to upload file without AutoIT script
	
	//Runtime.getRuntime().exec(path); //to run AutoIT script
		//driver.quit();
		
	
	}
	@Test (enabled = true, groups="regression1")
	//@Test(groups="regression1")
	public void robottest() throws AWTException, IOException{
		driver.get("file:///C://ETLHive//HTMLTag.html");
		Robot r=new Robot();
		//to handle keyboard events
	/*	r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		
	//r.mouseMove(x, y);
	//r.delay(ms);
	//r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	//r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	JavascriptExecutor ex= (JavascriptExecutor) driver;
	//ex.executeScript("window.scrollBy(0,300)","");
	WebElement e=	driver.findElement(By.xpath("//*[@id='File1']"));
	//ex.executeScript("arguments(0).click()",'e');
	
		//WebElement e=	driver.findElement(By.xpath("//*[@id='File1']"));
		//e.click();

		//e.sendKeys("C:\\ETLHive\\TestFile.txt");
	//to tke screen shots 
	//File src=((TakesScreenshot)driver)
	
	}
	
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("after Method");
		//driver.close();
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("after class");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("after test");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("after suite");
	}
	
	
}
