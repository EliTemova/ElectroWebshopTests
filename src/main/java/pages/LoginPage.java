package pages;

import helpers.Helpers;
import org.openqa.selenium.By;

public class LoginPage {

    By myAccountlink = By.xpath("//*[@id=\"menu-item-5294\"]/a");
    By regEmail = By.xpath("//input[@id='username']");
    By regPassword = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath(("//button[@name='login' and @value='Log in']"));

    public void login(String email, String password) {
        Helpers.findElement(myAccountlink).click();
        Helpers.findElement(regEmail).sendKeys(email);
        Helpers.findElement(regPassword).sendKeys(password);
        Helpers.findElement(loginBtn).click();

    }

}