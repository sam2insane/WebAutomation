package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumPractice2 {
    static WebDriver driver = SeleniumPractice1.getDriver("chrome");

    public static void main(String[] args) {
        driver.get("https://www.ebay.com");

        //     driver.findElement(By.id("gh-ac")).sendKeys("java books");
        // no difference in line 12 and 14&15

        WebElement element = driver.findElement(By.xpath("//*[@id='gh-ac']"));
      element.sendKeys("java books");

    //    WebElement element1 = driver.findElement(By.xpath("//*[@id='gh-btn']"));
        WebElement element1 =getElementFromXpath("//*[@id='gh-btn']");
        element1.click();
        SeleniumPractice1.sleepFor(5);

        WebElement element2 = driver.findElement(By.xpath("//input[@type = 'checkbox' and @aria-label='Box Set']"));
        System.out.println(element2.isSelected());
        System.out.println(element2.isEnabled());
        SeleniumPractice1.sleepFor(5);
        element2.click();

        SeleniumPractice1.sleepFor(5);

    }

    public static WebElement getElementFromXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }
    public static void sendKeyss ( String id, String value) {
        driver.findElement(By.xpath(id)).sendKeys(value);
    }
    //  WebElement element = driver.findElement(By.id("gh-ac"));
    //      element.sendKeys("java books");
    public static void searchInEbay (String xpath, String value) {
        driver.findElement(By.xpath(xpath)).click();
    }
}
