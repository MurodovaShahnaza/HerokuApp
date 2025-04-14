import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ARROW_UP;

/*Keys.ARROW_UP и Keys.ARROW_DOWN*/
public class InputsTest {

    @Test

    public void inputsTest () {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().window().maximize();
        webDriver.get("https://the-internet.herokuapp.com/inputs");
        webDriver.findElement(By.tagName("input")).sendKeys("5");

        SoftAssert softAssert = new SoftAssert();

        String messege = webDriver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(messege,
                "5",
                "Значение не оторразилось");

        webDriver.findElement(By.tagName("input")).sendKeys(ARROW_UP);

        String messege1 = webDriver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(messege1,
                "6",
                "Значение не повыселось");

        webDriver.findElement(By.tagName("input")).sendKeys(ARROW_DOWN);

        String messege2 = webDriver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(messege2,
                "5",
                "Значение не понизилось");

        webDriver.findElement(By.tagName("input")).sendKeys(ARROW_DOWN);

        String messege3 = webDriver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(messege3,
                "4",
                "Значение не понизилось");

        webDriver.findElement(By.tagName("input")).clear();
        webDriver.findElement(By.tagName("input")).sendKeys("А");

        String messege4 = webDriver.findElement(By.tagName("input")).getAttribute("value");
        softAssert.assertEquals(messege4,
                "А",
                "Значение не отобразилось");

        softAssert.assertAll();

        webDriver.quit();


    }
}
