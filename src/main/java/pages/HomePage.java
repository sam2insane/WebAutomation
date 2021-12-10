package pages;

import base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private  static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(xpath= "//a[@data-testid='open-registration-form-button']")
    private WebElement signup_button;
    @FindBy(xpath = "//input[@aria-label = 'First name']")
    private WebElement firstname;
    @FindBy(xpath =  "//input[@aria-label = 'Last name']")
    private WebElement lastname;

    public void clickSignup(){
        signup_button.click();
        ExtentTestManager.log("clicked on signup ",logger);
    }
    public void enterFirstName() {
        firstname.sendKeys("samian ");
        ExtentTestManager.log("entered first name ",logger);

    }
    public void enterLastName() {
        lastname.sendKeys("rahman");
        ExtentTestManager.log("entered last name ",logger);

    }

}

