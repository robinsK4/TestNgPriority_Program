package testngPriorityPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority_Program {
	public static WebDriver driver;
	
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
	}
		
  @Test(priority=1)
  public void TitleTest() {
	  String Title = driver.getTitle();
	  System.out.println("Title of the Page is: "+Title);	  
  }
  
  @Test(priority=2)
  public void LogoTest(){
	  boolean flag = driver.findElement(By.xpath("//img[contains(@alt,'Mercury Tours')]")).isDisplayed();
	  System.out.println("Logo of page displayed:"+flag);
  }
  
  @Test(priority=3)
  public void LinkTest(){
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  int linkscount = links.size();
	  System.out.println("Total links is:"+linkscount);
	  for(int i=0;i<=linkscount-1;i++){
		  System.out.println("Link name is:"+links.get(i).getText());
	  }
	  
  }
  
  @Test(priority=4)
  public void Login(){
	  driver.findElement(By.name("userName")).sendKeys("mercury");
	  driver.findElement(By.name("password")).sendKeys("mercury");
	  driver.findElement(By.name("login")).click();
  }
  
  @AfterMethod
  public void TearDown(){
	  driver.close();
  }
  
  
  
  
  
  
}
