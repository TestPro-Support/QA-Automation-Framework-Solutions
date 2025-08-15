import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
//LUXON CODE TEST
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}