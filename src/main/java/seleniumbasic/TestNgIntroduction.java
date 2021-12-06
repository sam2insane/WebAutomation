package seleniumbasic;

import org.testng.annotations.Test;

public class TestNgIntroduction extends TestBase {
    @Test
    public void searchForJavaBooksInEbay() {
        getDriver("chrome","https://www.ebay.com");

        sleepFor(5);
        searchInEbay("//input[@id=\"gh-ac\"]" , "java books");
        sleepFor(5);
        getElementFromXpath("//*[@id='gh-btn']");



    }
}
