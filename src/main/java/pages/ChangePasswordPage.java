package pages;
import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static helpers.Helpers.driver;

public class ChangePasswordPage {
    By currentPasswordField = By.xpath("//*[@id=\"password_current\"]");
    By newPasswordField = By.xpath("//*[@id=\"password_1\"]");
    By confirmNewPassword = By.xpath("//*[@id=\"password_2\"]");
    String starPassword = "Novpasvord111";  // treba da se smeni za sekoe izvrsuvanje
    String novPassword = "Novpasvord222";   // treba da se smeni za sekoe izvrsuvanje

    public void changePassword() throws InterruptedException {

        Helpers.findElement(currentPasswordField).clear();
        Helpers.findElement(currentPasswordField).sendKeys(starPassword); //Vnesi go tekovniot password
        Helpers.findElement(newPasswordField).sendKeys(novPassword);      // vnesi nov password
        Helpers.findElement(confirmNewPassword).sendKeys(novPassword);    // potvrdi go noviot password
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;              //da skrolne nadolu do Save button
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(3000);
        Helpers.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/div/form/p[5]/button")).click();// klik na Save
    }
    public void logOut() {
        Helpers.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/nav/ul/li[7]/a")).click();
    }

    public void reLogin()  {

        String email = "eli.bajraktarova@gmail.com";
        Helpers.getDriver().get("https://electro.madrasthemes.com/");
        By myAccountlink = By.xpath("//*[@id=\"menu-item-5294\"]/a");
        By regEmail = By.xpath("//*[@id=\"username\"]");
        By regPassword = By.xpath("//input[@id='password']");
        By loginBtn = By.xpath(("//button[@name='login' and @value='Log in']"));

        Helpers.findElement(myAccountlink).click();
        Helpers.findElement(regEmail).sendKeys(email);
        Helpers.findElement(regPassword).sendKeys(novPassword);
        Helpers.findElement(loginBtn).click();
    }


}
