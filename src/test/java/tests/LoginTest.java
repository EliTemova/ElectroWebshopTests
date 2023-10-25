package tests;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test (priority=1)
    public void logIn(){

        loginPage.login("eli.bajraktarova@gmail.com","Novpasvord111"); // pasvordot treba da se smeni vo noviot za sekoe izvrsuvanje

        //potvrdi deka si logiran
        String expectedLogin = "My Account";
        String actualLogin = Helpers.findElement(By.xpath("//*[@id=\"post-3854\"]/header/h1")).getText();
        Assert.assertEquals(actualLogin,expectedLogin);
        System.out.println("Actual log in message is:   " + actualLogin);
        System.out.println("Expected log in message is: " + expectedLogin);

        //potvrdi deka si na my account\
        String expectedUrl= "https://electro.madrasthemes.com/my-account/";
        String actualUrl = Helpers.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        System.out.println("Actual url is:   " + actualUrl);
        System.out.println("Expected url is: " + expectedUrl);
    }



}
