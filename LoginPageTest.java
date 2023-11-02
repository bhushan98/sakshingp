
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginPageTest {



        WebDriver driver;

        @BeforeTest
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://sakshingp.github.io/assignment/login.html");
        }

        @Test(priority = 1)
        public void testValidLogin() {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("validUsername");
            passwordField.sendKeys("validPassword");
            loginButton.click();

            // Add assertions for successful login
            Assert.assertEquals(driver.getTitle(), "Home Page Title");
        }

        @Test(priority = 2)
        public void testInvalidLogin() {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("invalidUsername");
            passwordField.sendKeys("invalidPassword");
            loginButton.click();

            // Add assertions for unsuccessful login
            Assert.assertEquals(driver.findElement(By.id("error-message")).getText(), "Invalid credentials. Please try again.");
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }

