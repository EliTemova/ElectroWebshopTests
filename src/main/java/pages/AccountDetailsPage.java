package pages;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static helpers.Helpers.driver;

public class AccountDetailsPage {
    By firstName = By.xpath("//*[@id=\"account_first_name\"]");
    By lastName = By.xpath("//*[@id=\"account_last_name\"]");
    By displayName = By.xpath("//*[@id=\"account_display_name\"]");
    public void openAccountDetails() throws InterruptedException {
        Thread.sleep(3000);
        Helpers.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/nav/ul/li[6]/a")).click();
    }
    public void ChangeDetails() {
        Helpers.findElement(firstName).clear();
        String newFirstName = "Eli" + System.currentTimeMillis();
        Helpers.findElement(By.xpath("//*[@id=\"account_first_name\"]")).sendKeys(newFirstName);

        Helpers.findElement(lastName).clear();
        String newLastName = "Tem" + System.currentTimeMillis();
        Helpers.findElement(By.xpath("//*[@id=\"account_last_name\"]")).sendKeys(newLastName);

        Helpers.findElement(displayName).clear();
        String newDisplayName = "EliTem" + System.currentTimeMillis();
        Helpers.findElement(By.xpath("//*[@id=\"account_display_name\"]")).sendKeys(newDisplayName);
    }
    public void SaveDetails() throws InterruptedException {

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(3000);
        //click save changes
        Helpers.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/div/form/p[5]/button")).click();

    }

}