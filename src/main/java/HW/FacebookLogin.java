package HW;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLogin {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login_button;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement textbox;

    public void enterUsername(String username) {
        email.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void pressLoginButton() {
        this.login_button.click();
    }

    public void searchForName(String data) {
        searchBar.sendKeys(data);
        searchBar.click();
        textbox.clear();
    }

    public void clearExistingText() {
        textbox.clear();
    }

    public void clearExistingText(String newText){
        textbox.clear();
        textbox.sendKeys(newText);
    }


}

