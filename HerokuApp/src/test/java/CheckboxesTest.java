import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/*попробовать через тру или фолс????
 * сменить с мал буквы*/
public class CheckboxesTest {

    @Test
    public void checkboxetest(){

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().window().maximize();
        webDriver.get("https://the-internet.herokuapp.com/checkboxes");
        webDriver.findElement(By.cssSelector("[type=checkbox]")).click();

        SoftAssert softAssert = new SoftAssert();

        boolean isCheckbox = webDriver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        softAssert.assertTrue(isCheckbox);
        webDriver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).click();
        boolean isCheckbox1 = webDriver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")).isSelected();
        softAssert.assertTrue(isCheckbox1);

        softAssert.assertAll();
        webDriver.quit();

    }
}
