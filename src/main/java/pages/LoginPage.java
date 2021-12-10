package pages;

import base.report.ExtentManager;
import base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private  static Logger logger = Logger.getLogger(LoginPage.class);
    @FindBy (id = "email")
    private WebElement email;


    @FindBy(id= "pass")
    private WebElement pass;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement login_button;

    public void enterEmail() {
        email.sendKeys("samianrahman@aol.com");
        ExtentTestManager.log("email entered",logger);
    }
    public void enterPassword() {
        pass.sendKeys("89Beak92@");
        ExtentTestManager.log("password entered",logger);
    }
    public void pressLogin() {
        login_button.click();
        ExtentTestManager.log("clicked on login button",logger);
    }
}


