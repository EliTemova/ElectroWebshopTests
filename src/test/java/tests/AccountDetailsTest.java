package tests;
import helpers.Helpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static helpers.Helpers.driver;
public class AccountDetailsTest extends BaseTest{

    @Test(priority=1)
    public void logIn(){
        loginPage.login("eli.bajraktarova@gmail.com","Novpasvord111"); // pasvordot treba da se smeni vo noviot za sekoe izvrsuvanje
    }


    @Test(priority=2)
    public void accDetails() throws InterruptedException {
        accountDetailsPage.openAccountDetails();
        accountDetailsPage.ChangeDetails();
        accountDetailsPage.SaveDetails();

        //get message
        String expectedMessage= "Account details changed successfully.";
        Thread.sleep(3000);
        String actualMessage= driver.findElement(By. xpath("//*[@id=\"post-3854\"]/div/div/div/div/div")).getText();
        // potvrdi deka ja dava porakata
        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("Actual message is  :  " + actualMessage);
        System.out.println("Expected message is:  " + expectedMessage);

        // potvrdi deka se vraka na Dashborard ( ne se vraka ova e bag)
        String expectedUrl= "https://electro.madrasthemes.com/my-account/";
        String actualUrl = Helpers.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        System.out.println("Actual url is:   " + actualUrl);
        System.out.println("Expected url is: " + expectedUrl);

    }
}
