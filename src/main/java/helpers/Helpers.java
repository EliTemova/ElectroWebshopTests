package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Helpers {

    public static WebDriver driver;
    private static WebDriverWait webDriverWait;


    public static void initialiseWebDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }


}
