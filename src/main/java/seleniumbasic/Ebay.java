package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ebay {
    //get 5 text from ebay and store them in the SQL DATABASE.
    //insert query
    public static void main(String[] args) throws SQLException {
        WebDriver driver = TestBase.getDriver("chrome", "https://www.ebay.com");
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("java books");
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(Keys.ENTER);

        List<WebElement> bookList = driver.findElements(By.xpath("//h3[@class='s-item__title']"));
        ArrayList<String> arrayList = new ArrayList();

        for (int i = 0; i < 5; i++) {
            arrayList.add(bookList.get(i).getText());
        }

        driver.close();
        driver.quit();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebaybooks", "root", "89Beak92");
        Statement st = conn.createStatement();

        for (String s : arrayList) {
            try {
                String data = s.replace("'", "\\\'");
                String query = "INSERT INTO nameofbooks " + "VALUES('" + data + "')";
                System.out.println(query);
                st.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Closing the connections and statements");
        st.close();
        conn.close();
    }

}
