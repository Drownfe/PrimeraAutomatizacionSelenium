package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class NopCommerceAutomation2 {

	private WebDriver driver;
	By computersLinkLocator = By.linkText("Computers");
	By desktopPageLocator = By.xpath("//img[@src ='https://demo.nopcommerce.com/images/thumbs/0000002_desktops_450.jpg']");
	By addToCartButton1Locator = By.xpath("//button[@class='button-2 product-box-add-to-cart-button']");
	By titleLocator = By.xpath("//h1[contains(text(), 'Build your own computer')]");
	By ramLocator = By.xpath("//option[@value = 3]");
	By hddLocator = By.id("product_attribute_3_6");
	By softwareDeselectLocator = By.id("product_attribute_5_10");
	By softwareLocator = By.id("product_attribute_5_11");
	By addToCartButton2Locator = By.id("add-to-cart-button-1");
	By confirmationAlertLocator = By.id("bar-notification");
	By shoppingCartLocator = By.className("cart-label");
	By electronicsLinkLocator = By.linkText("Electronics");
	By cameraPhotoPageLocator = By.xpath("//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000006_camera-photo_450.jpeg\"]");
	By cameraSelectorLocator = By.linkText("Leica T Mirrorless Digital Camera");
	By addToCartButton3Locator = By.id("add-to-cart-button-16");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Before
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/webDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");	
	}
	
	@Test
	public void computerShop() throws InterruptedException {
		driver.findElement(computersLinkLocator).click();
		Thread.sleep(500);
		System.out.println("Going into Computers page");
		driver.findElement(desktopPageLocator).click();
		Thread.sleep(500);
		System.out.println("Going into Desktops page");
		driver.findElement(addToCartButton1Locator).click();
		Thread.sleep(500);
		System.out.println("Adding computer to shopping cart");
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		System.out.println("Scrolling down the window");
		driver.findElement(ramLocator).click();
		Thread.sleep(500);
		System.out.println("Adding RAM");
		driver.findElement(hddLocator).click();
		Thread.sleep(500);
		System.out.println("Adding HDD");
		driver.findElement(softwareDeselectLocator).click();
		Thread.sleep(500);
		System.out.println("Removing checkbox");
		driver.findElement(softwareLocator).click();
		Thread.sleep(500);
		System.out.println("Adding new software");	
		driver.findElement(addToCartButton2Locator).click();
		if(driver.findElement(confirmationAlertLocator).isEnabled()) {
			System.out.println("Verifying confirmation success");
			Thread.sleep(2000);
			((JavascriptExecutor)driver).executeScript("scroll(0,0)");
			Thread.sleep(2000);
			driver.findElement(shoppingCartLocator).click();
			System.out.println("Going into shopping cart");
			Thread.sleep(500);
			//COMPARACION DE OBJETOS ESCOGIDOS Y PRECIOS PENDIENTE
			driver.findElement(electronicsLinkLocator).click();
			Thread.sleep(500);
			System.out.println("Going into Electronics page");
			driver.findElement(cameraPhotoPageLocator).click();
			Thread.sleep(500);
			System.out.println("Going into Camera & Photo page");
			driver.findElement(cameraSelectorLocator).click();
			Thread.sleep(500);
			System.out.println("Selecting camera");
			driver.findElement(addToCartButton3Locator).click();
			Thread.sleep(500);
			System.out.println("Adding LEICA T MIRRORLESS camera to cart");
			Thread.sleep(4000);
			if(driver.findElement(confirmationAlertLocator).isEnabled()) {
				driver.findElement(shoppingCartLocator).click();
				System.out.println("Going into shopping cart");
				//COMPARACION DE OBJETOS ESCOGIDOS Y PRECIOS PENDIENTE
			}else {
				System.out.println("CONFIRMATION NOTIFICATION NOT FOUND");
			}	
		}else {
			System.out.println("CONFIRMATION NOTIFICATION NOT FOUND");
		}
	}
	
	/*@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();	
		}*/
}
