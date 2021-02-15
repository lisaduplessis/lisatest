package Hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

    public class SaveAndDeleteTest {

        private WebDriver driver;

        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://hotel-test.equalexperts.io/");
            driver.manage().window().maximize();
        }

        @Test //add booking

        public void testSaveEntry(){
            driver.findElement(By.id("firstname")).sendKeys("JohnHotelBooking");
            driver.findElement(By.id("lastname")).sendKeys("Smith");
            driver.findElement(By.id("totalprice")).sendKeys("1500");
            driver.findElement(By.id("checkin")).sendKeys("2021-09-03");
            driver.findElement(By.id("checkout")).sendKeys("2021-09-05");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[7]/input")).click();
            driver.navigate().refresh();
        }

        @Test //delete booking

        public void testDeleteEntry(String firstname){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            By locator = By.xpath("//div[@class='row'][./div[1]/p[text()='" + firstname + "']]/div/input[@value='Delete']");
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }

        public static void main(String[] args){
            SaveAndDeleteTest test = new SaveAndDeleteTest();
            test.setUp();
            test.testSaveEntry();
            test.testDeleteEntry("JohnHotelBooking");
        }

    }

