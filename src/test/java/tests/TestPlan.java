package tests;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestPlan extends TestBase {

    @Test(testName = "Log In Facebook",enabled = false)
    public static void userShouldBeAbleToLogin() {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.enterPassword();
        loginPage.enterEmail();
        loginPage.pressLogin();

    }


    @Test(testName = "SignUp")
    public static void userShouldBeAbleToSignUp() {
        HomePage homePage= PageFactory.initElements(driver, HomePage.class);
    homePage.clickSignup();
    homePage.enterFirstName();
    homePage.enterLastName();
    }

}


