import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class TyposTest {

    @Test

    public void typosTest() {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().window().maximize();
        webDriver.get("https://the-internet.herokuapp.com/typos");
        String messenge = webDriver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(messenge, "Sometimes you'll see a typo, other times you won't.", "Грамматическая ошибка допущенна");
        webDriver.quit();


    }
}
