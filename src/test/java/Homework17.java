import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
        @Test
        public void addSongToPlaylist() throws InterruptedException {

            String newSongAddedNotificationText = "Added 1 song into";

            navigateToPage();
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();
            Thread.sleep(2000);
            searchSong("Pluto");
            clickViewAllBtn();
            selectFirstSongResult();
            clickAddToBtn();
            choosePlaylist();
            Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
        }

        public void searchSong(String name) throws InterruptedException {
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
            searchField.sendKeys(name);
            Thread.sleep(2000);
        }
        public void clickViewAllBtn() throws InterruptedException {
            WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
            viewAll.click();
            Thread.sleep(2000);
        }
        public void selectFirstSongResult() throws InterruptedException {
            WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
            firstSong.click();
            Thread.sleep(2000);
        }
        public void clickAddToBtn() throws InterruptedException {
            WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
            addToButton.click();
            Thread.sleep(2000);
        }
        public void choosePlaylist () throws InterruptedException {
//            We created a playlist named "Test Pro Playlist"
            WebElement playlist = driver.findElement(By.xpath(String.format("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]")));
            playlist.click();
            Thread.sleep(2000);
        }
        public String getNotificationText() {
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            System.out.println(notification.getText()+ "---Text");
            return notification.getText();
        }
    }