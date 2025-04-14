import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class DropdownTest {


    @Test

    public void dropdownTest (){

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().window().maximize();
        webDriver.get("https://the-internet.herokuapp.com/dropdown");
        webDriver.findElement(By.id("dropdown")).click();
        webDriver.findElement(By.xpath("//*[@id='dropdown']/option[3]")).click();
        webDriver.findElement(By.id("dropdown")).click();
        webDriver.findElement(By.xpath("//*[@id='dropdown']/option[2]")).click();

        SoftAssert softAssert = new SoftAssert();

        String messenge = webDriver.findElement(By.xpath("//*[@id='dropdown']/option[3]")).getText();
        softAssert.assertEquals(messenge,
                "option 2 было отмечено",
                "option 2 не выбранно");
        String messenge1 = webDriver.findElement(By.xpath("//*[@id='dropdown']/option[2]")).getText();
        softAssert.assertEquals(messenge1,
                "option 1 было отмечено",
                "option 1 не выбранно");

        softAssert.assertAll();

        webDriver.quit();


    }
}
