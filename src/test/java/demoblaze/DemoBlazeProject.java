package demoblaze;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DemoBlazeProject {
	
	 WebDriver driver;
	 
 @BeforeClass
 public void setUp() {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\ermina\\eclipse-workspace\\CertificationProject\\webdriver\\chromedriver.exe");
     driver = new ChromeDriver();
 	
 	//ChromeOptions options = new ChromeOptions();
	//options.addArguments("--headless");
	//driver = new ChromeDriver(options);
	 
 }

 @Test(priority = 1)
 public void testLogin() throws InterruptedException {
     // Navigate to DemoBlaze website
     driver.get("https://www.demoblaze.com/");

     driver.manage().window().maximize();
     
     // Click on the "Log in" button in the navbar
     WebElement loginButton = driver.findElement(By.id("login2"));
     loginButton.click();

     // Enter username and password and click the "Log in" button
     Thread.sleep(1000);
     WebElement usernameField = driver.findElement(By.id("loginusername"));
     usernameField.sendKeys("ermina_test");
     WebElement passwordField = driver.findElement(By.id("loginpassword"));
     passwordField.sendKeys("ermina_test");
     WebElement loginModalButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
     loginModalButton.click();

     Thread.sleep(1000);
 }

 @Test(priority = 2)
 
 public void testAddToCart() throws InterruptedException  {
		  	      
	      // Navigate to the Phones category
	      WebElement phonesCategory = driver.findElement(By.xpath("//div[@id='contcont']//a[2]"));
	      phonesCategory.click();
	
	      // Click on a phone product and add it to the cart
	      WebElement phoneProduct = driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
	      phoneProduct.click();
	
	      Thread.sleep(1000);
	      WebElement addToCartButton = driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
	      addToCartButton.click();
	      Thread.sleep(1000);
	      // Wait for the "Product added" alert to appear
	      // Accept the "Product added" alert
	      Alert alert = driver.switchTo().alert();
	      // Prints text and closes alert
	     // System.out.println(alert.getText());
	      alert.accept(); // or alert.dismiss(); 
	    
}	          
		   
@Test(priority = 3)
    public void testPlaceOrder() throws InterruptedException {	     
	           
	     // Navigate to Cart and Place Order
	     // Click on the cart Menu
	    
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      WebElement cartButton = driver.findElement(By.cssSelector("#cartur"));
	      cartButton.click();
	
	      // Click on the checkout button
	      WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
	      checkoutButton.click();
	
	      // Fill out the form and submit it
	      WebElement nameField = driver.findElement(By.id("name"));
	      nameField.sendKeys("Ermina Test");
	
	      WebElement countryField = driver.findElement(By.id("country"));
	      countryField.sendKeys("United States");
	
	      WebElement cityField = driver.findElement(By.id("city"));
	      cityField.sendKeys("California");
	
	      WebElement cardField = driver.findElement(By.id("card"));
	      cardField.sendKeys("1234567890123456");
	
	      WebElement monthField = driver.findElement(By.id("month"));
	      monthField.sendKeys("01");
	
	      WebElement yearField = driver.findElement(By.id("year"));
	      yearField.sendKeys("2024");
	
	      WebElement purchaseButton = driver.findElement(By.xpath("//button[contains(text(),'Purchase')]"));
	      purchaseButton.click();
	      
	   // Wait for the order confirmation modal to appear
	      Thread.sleep(2000);
	      WebElement oKButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
	      oKButton.click();
	}
 
  
@AfterClass
  public void closeBrowser() {
	      // Close the browser
	     driver.quit();
     
	  }
}

