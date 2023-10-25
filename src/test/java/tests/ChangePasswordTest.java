package tests;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static helpers.Helpers.driver;
public class ChangePasswordTest extends BaseTest {

    @Test(priority = 1)
    public void logIn() {
        loginPage.login("eli.bajraktarova@gmail.com", "Novpasvord111"); // pasvordot da se smeni vo noviot za sekoe izvrsuvanje
    }

    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 2)
    public void changeThePassword() throws InterruptedException {

        accountDetailsPage.openAccountDetails(); // otvoti ja account details  page
        changePasswordPage.changePassword();     // promeni go prasvordot

        String expectedMessage = "Account details changed successfully.";
        Thread.sleep(3000);
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"post-3854\"]/div/div/div/div/div")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);  // potvrdi deka ja dava porakata
        System.out.println("Expected message is:  " + expectedMessage);
        System.out.println("Actual message is  :  " + actualMessage);

        // potvrdi deka go vraka na Dashborard ( ne go vraka ova e bag)
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://electro.madrasthemes.com/my-account/";
        softAssert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Expected url is: " + expectedUrl);
        System.out.println("Actual url is:   " + actualUrl);

        softAssert.assertAll();
    }
    @Test(priority = 3)
            public void  logOutPage() throws InterruptedException {
        Thread.sleep(2000);
        changePasswordPage.logOut();

    }

    @Test(priority = 4)   // povtorno da se logira
    public void reLogin() throws InterruptedException {
        Thread.sleep(3000);
        changePasswordPage.reLogin();
        String expectedLogin = "My Account";
        String actualLogin = Helpers.findElement(By.xpath("//*[@id=\"post-3854\"]/header/h1")).getText();
        Assert.assertEquals(actualLogin, expectedLogin);
        System.out.println("Expected Page title is: " + expectedLogin);
        System.out.println("Actual Page title is:   " + actualLogin);

    }

}
