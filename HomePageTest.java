
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;



public class HomePageTest {



        WebDriver driver;

        @BeforeTest
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            // Assuming user is already logged in, navigate to the home page
            driver.get("https://sakshingp.github.io/assignment/home.html");
        }

        @Test
        public void testAmountColumnSorting() {
            WebElement amountHeader = driver.findElement(By.id("amount-header"));
            amountHeader.click();

            // Extracting amounts from the transaction table
            List<WebElement> amountElements = driver.findElements(By.xpath("//table[@id='transaction-table']/tbody/tr/td[5]"));
            List<Double> amounts = amountElements.stream()
                    .map(element -> Double.parseDouble(element.getText().replace("$", "")))
                    .collect(Collectors.toList());

            // Verify if the amounts are sorted in ascending order
            List<Double> sortedAmounts = new ArrayList<>(amounts);
            Collections.sort(sortedAmounts);

            // Add assertion to check if the amounts are sorted correctly

            assertEquals(amounts, sortedAmounts);
        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }






