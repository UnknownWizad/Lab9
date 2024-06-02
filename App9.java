import java.time.Duration; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait; 
 
public class App9 {  
    public static void main(String[] args) throws InterruptedException{ 
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe"); 
        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize(); 
        driver.get("https://www.amazon.com/"); 
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Search for an item
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys("acer laptop gaming");
        searchBox.submit();
        
        // Click on the first search result
        WebElement firstSearchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")));
        firstSearchResult.click();
        
        // Add the item to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartButton.click();
        
        // Navigate back to the homepage  
        driver.navigate().back();
        driver.navigate().back(); // Navigate back again to go to the homepage
        
        // Search for another item
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.clear();
        searchBox.sendKeys("headphones wireless");
        searchBox.submit();
        
        // Click on the first search result for headphones
        WebElement firstHeadphonesResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")));
        firstHeadphonesResult.click();
        
        // Wait for some time to observe the result
        Thread.sleep(10000); 
        
        driver.quit(); 
    } 
}
