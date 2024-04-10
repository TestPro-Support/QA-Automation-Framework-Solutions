import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest {

    //Fluent interfaces example
    @Test
    public void loginValidEmailPassword () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@testpro.io").providePassword("te$t$tudent").clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    //    OR
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("").providePassword("te$t$tudent").clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}