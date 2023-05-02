import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {

    static ChromeOptions options = new ChromeOptions();
    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {
        // Simple comment

//      Added ChromeOptions argument below to fix websocket error
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        Thread.sleep(2000);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public static void LoginInvalidEmail() {
        //Login Not Existing Email:
        //Precondition: Chrome browser should be opened DONE
        // declare driver
        //Step1. Open koel login page DONE
        // tell driver to load koel page
        //Step2. Enter Not Existing email
        // find email field
        // click into email field
        // enter invalid email inside email field
        //Step3. Enter Correct password
        // find password field
        // click into password field
        // enter anything
        //Step4. Click Login button
        // find the login button
        // click the login button
        //Expected result: User should stay on login page
        // assert the present of email field

//      Added ChromeOptions argument below to fix websocket error

        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //Step2. Enter Not Existing email
        // find email field
        // click into email field
        // enter invalid email inside email field
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("cucaracha@class.com");

        //Step3. Enter Correct password
        // find password field
        // click into password field
        // enter anything
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("ayCaramba");

        //Step4. Click Login button
        // find the login button
        // click the login button
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        //Expected result: User should stay on login page
        // assert the present of email field
        Assert.assertTrue(emailField.isDisplayed());
        driver.quit();
    }

    @Test
    public static void LoginValidEmailPasswordTest() throws InterruptedException {
        // Precondition: Chrome browser should be opened DONE
        //Step1. Open koel login page DONE
        //Step2. Enter Existing username
        //Step3. Enter Correct password
        //Step4. Click Login button
        //Expected result: User should be directed to the home page

//      Added ChromeOptions argument below to fix websocket error
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        //Step3. Enter Correct password
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        //Step4. Click Login button
        WebElement loginField = driver.findElement(By.cssSelector("[type='submit'"));
        loginField.click();

        //Expected result: User should be directed to the home page
        Thread.sleep(2000);
        WebElement avatar = driver.findElement(By.className("avatar"));
        Assert.assertTrue(avatar.isDisplayed());

        driver.quit();
    }
}