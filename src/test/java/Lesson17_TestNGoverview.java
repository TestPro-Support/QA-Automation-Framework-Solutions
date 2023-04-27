import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Lesson17_TestNGoverview extends BaseTest {
    @Test
    public static void LoginEmptyEmailPasswordTest() {

        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }
    @Test
    public static void LoginValidEmailValidPasswordTest()   {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //Added ChromeOptions argument below to fix websocket error
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit'"));
        loginButton.click();

        WebElement avatar = driver.findElement(By.cssSelector("[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());

        driver.quit();

    }

    //(enabled = false, description = "Test skipped because of open issue JIRA-757")

}





