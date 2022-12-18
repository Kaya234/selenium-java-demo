package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertTrue;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void visit(String url) {
        driver.navigate().to(url);

    }

    public void type(By elementBy, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy)).sendKeys(text);

    }

    public void clickOn(By elementBy){
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy)).click();

    }

    public void clickContainText(String text){
        wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//span[text()= '" + text + "']")))
                .click();

    }

    public void clickContainTextDropdown(String option){
        wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//div[span[text()= '" + option + "']]")))
                .click();

    }

    public void assertTrueText( By elementBy, String text){
        String actualString = wait.until(ExpectedConditions.presenceOfElementLocated(elementBy))
                .getText();
        assertTrue(actualString.contains(text));

    }

    public void assertTrueEmpty(By elementBy){
        String actualString = wait.until(ExpectedConditions.presenceOfElementLocated(elementBy)).getText();
        assertTrue(actualString.isEmpty());

    }

     public void assertTrueToast(String text){
         String actualString = wait.until(ExpectedConditions
                         .presenceOfElementLocated(By.xpath("//p[text()= '" + text + "']")))
                 .getText();
        assertTrue(actualString.contains(text));

    }

     public void assertTrueSearchResult(String text){
         String actualString = wait.until(ExpectedConditions
                         .presenceOfElementLocated(By.xpath("//div[span[text()= '" + text + "']]")))
                 .getText();
         assertTrue(actualString.contains(text));

    }

     public void assertTrueList(By tableBy, By elementBy, String role){
         List<WebElement> rows = driver.findElements(tableBy);
         for (WebElement row : rows) {
             assertTrue(row.findElement(elementBy).getText().contains(role));

         }

    }

     public void autocomplete(By elementBy) throws InterruptedException {
         Thread.sleep(2000);
         driver.findElement(elementBy).click();

    }
}
