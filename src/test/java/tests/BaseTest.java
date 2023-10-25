package tests;

import helpers.Helpers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.AccountDetailsPage;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class BaseTest {
    LoginPage loginPage;
    ChangePasswordPage changePasswordPage;
    AccountDetailsPage accountDetailsPage;
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void setUp() {
        Helpers.initialiseWebDriver();
        Helpers.getDriver().manage().window().maximize();
        Helpers.getDriver().get("https://electro.madrasthemes.com/");
    }

    @BeforeTest
    public void initializePages() {
        loginPage = new LoginPage();
        changePasswordPage = new ChangePasswordPage();
        accountDetailsPage = new AccountDetailsPage();
    }

    @AfterClass
   public void close() throws InterruptedException {
        Thread.sleep(3000);
        Helpers.getDriver().quit();

    }
}

