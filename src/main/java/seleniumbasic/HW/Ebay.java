package seleniumbasic.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seleniumbasic.DBUtils;
import seleniumbasic.TestBase;

import java.sql.*;
import java.util.ArrayList;

public class Ebay {
    //get 5 text from ebay and store them in the SQL DATABASE.
    //insert query
    public static void main(String[] args) throws Exception {
        WebDriver driver = TestBase.getDriver("chrome", "https://www.ebay.com");
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("java books");
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(Keys.ENTER);

        WebElement firstBook = driver.findElement(By.xpath("(//h3[@class=\"s-item__title\"])[1]"));

        String bookName = firstBook.getText();
        System.out.println("the name of the first book is" + bookName);

        WebElement secondBook = driver.findElement(By.xpath("(//h3[@class=\"s-item__title\"])[2]"));

        String secondBookName = secondBook.getText();
        System.out.println("the name of the second book is" + secondBookName);

        WebElement thirdBook = driver.findElement(By.xpath("(//h3[@class=\"s-item__title\"])[9]"));

        String thirdBookName = thirdBook.getText();
        System.out.println("the name of the third book is" + thirdBookName);

        WebElement fourthBook = driver.findElement(By.xpath("(//h3[@class=\"s-item__title\"])[8]"));

        String fourtBookName = fourthBook.getText();
        System.out.println("the name of the fourth book is" + fourtBookName);

        WebElement fifthBook = driver.findElement(By.xpath("(//h3[@class=\"s-item__title\"])[7]"));

        String fifthBookName = fifthBook.getText();
        System.out.println("the name of the fifth book is" + fifthBookName);


        final String var1=fifthBookName;

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebaybooks", "root", "89Beak92");
        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO nameofbooks " + "VALUES('" + var1 + "')");


    }


}
