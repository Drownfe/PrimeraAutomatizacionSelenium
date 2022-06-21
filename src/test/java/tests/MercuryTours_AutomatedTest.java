package tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword\']");
	By registerButtomLocator = By.name("submit");
	
	By homePageLocator = By.xpath("//img[@src='images/hdr_findflight.gif']");
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInButtonLocator = By.name("submit");

	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/webDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");		
	}
	
	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("qualityAdmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			driver.findElement(signInButtonLocator).click();
		}else {
			System.err.println("Register page was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is qualityAdmin.",fonts.get(5).getText());
	}
	
	@Test
	public void signIn() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(homePageLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("qualityAdmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(registerButtomLocator).click();
		}else {
			System.err.println("Register page was not found");
		}
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Thank you for Loggin.",fonts.get(3).getText());
		
	}
}
