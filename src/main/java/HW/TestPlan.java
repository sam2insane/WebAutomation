package HW;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestPlan extends TestBase {
    private static final String USER_NAME = "samianrahman@aol.com";
    private static final String PASSWORD = "89Beak928992";

    @Test(testName = "Log In Facebook")
    public static void LoginFacebook(){
        FacebookLogin facebookLogin = PageFactory.initElements(driver,FacebookLogin.class);
        facebookLogin.enterUsername(USER_NAME);
        facebookLogin.enterPassword(PASSWORD);
        facebookLogin.pressLoginButton();
        facebookLogin.searchForName("Tom");
        facebookLogin.clearExistingText();
        facebookLogin.searchForName("john");
    }

    }


