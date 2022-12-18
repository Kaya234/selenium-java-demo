package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    public WebDriver driver;
    public LoginPage loginPage;

    static String VALID_NAME = "Admin";
    static String VALID_PASSWORD = "admin123";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        loginPage.goToUrl();

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }

    @Test
    public void WithoutCredentials() throws InterruptedException {
        loginPage.clickLogin();
        loginPage.checkInputErrorUsername();
        loginPage.checkInputErrorPassword();

    }

    @Test
    public void WithoutUsername() throws InterruptedException {
        loginPage.enterUsername(VALID_NAME);
        loginPage.clickLogin();
        loginPage.checkInputErrorPassword();

    }

    @Test
    public void WithoutPassword() throws InterruptedException {
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLogin();
        loginPage.checkInputErrorUsername();

    }

    @Test
    public void ValidCredentials() throws InterruptedException {
        loginPage.enterUsername(VALID_NAME);
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLogin();
        loginPage.checkValidLogin();

    }

    @Test
    public void InvalidUsername() throws InterruptedException {
        loginPage.enterUsername("admi");
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLogin();
        loginPage.checkInvalidLoginError();

    }

    @Test
    public void InvalidPassword() throws InterruptedException {
        loginPage.enterUsername(VALID_PASSWORD);
        loginPage.enterPassword("Admin123");
        loginPage.clickLogin();
        loginPage.checkInvalidLoginError();

    }


    //Forgotten Password
    @Test
    public void clickResetWithoutUsername() throws InterruptedException {
        loginPage.clickReset();
        loginPage.clickResetSubmit();
        loginPage.checkResetInputError();

    }

    @Test
    public void clickResetWithUsername() throws InterruptedException {
        loginPage.clickReset();
        loginPage.resetEnterUsername(VALID_NAME);
        loginPage.clickResetSubmit();
        loginPage.checkResetSuccessInfo();

    }

    @Test
    public void clickCancel() throws InterruptedException {
        loginPage.clickReset();
        loginPage.clickResetCancel();
        loginPage.checkReturnToLoginPage();

    }

    //Logout
    @Test
    public void logoutLoginInputsEmpty() throws InterruptedException {
        loginPage.login();
        loginPage.logout();
        loginPage.checkEmptyInputs();

    }

}







