package tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class AdminSearchTests {

    public WebDriver driver;
    public LoginPage loginPage;
    public AdminPage adminPage;

    String VALID_S_USERNAME = "David.Morris";
    String VALID_S_NAME = "David Morris";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        loginPage.goToUrl();
        loginPage.login();
        adminPage.goToAdminPage();

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void DefaultState() throws InterruptedException {

        adminPage.checkDefaultInputValues();

    }

    //Username field
    @Test
    public void InvalidUsername() throws InterruptedException {
        adminPage.searchUsername("David");
        adminPage.clickSearch();
        adminPage.checkSearchToastMessage("No Records Found");
        adminPage.searchResult("No Records Found");

    }

    @Test
    public void ValidUsernameNoCapitals() throws InterruptedException {
        adminPage.searchUsername("david.morris");
        adminPage.clickSearch();
        adminPage.searchResult("(1) Record Found");

    }

    @Test
    public void ValidUsernameCapitals() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.clickSearch();
        adminPage.searchResult("(1) Record Found");

    }

    //User Role Dropdown
    @Test
    public void SelectOptionESS() throws InterruptedException {
        adminPage.selectOptionRole("ESS");
        adminPage.clickSearch();
        adminPage.checkSearchResultRole("ESS");

    }

    @Test
    public void SelectOptionAdmin() throws InterruptedException {
        adminPage.selectOptionRole("Admin");
        adminPage.clickSearch();
        adminPage.checkSearchResultRole("Admin");

    }

    //Employee Name autocomplete Field
    @Test
    public void NotUseAutocomplete() throws InterruptedException {
        adminPage.searchName(VALID_S_NAME);
        adminPage.clickSearch();

    }

    @Test
    public void UseAutocomplete() throws InterruptedException {
        adminPage.searchName(VALID_S_NAME);
        adminPage.nameAutocomplete();
        adminPage.clickSearch();
        adminPage.searchResult("(1) Record Found");
    }


    //Status Dropdown
    @Test
    public void SelectOptionEnabled() throws InterruptedException {
        adminPage.selectOptionStatus("Enabled");
        adminPage.clickSearch();
        adminPage.checkSearchResultStatus("Enabled");
    }

    @Test
    public void SelectOptionDisabled() throws InterruptedException {
        adminPage.selectOptionStatus("Disabled");
        adminPage.clickSearch();
        adminPage.checkSearchToastMessage("Invalid Parameter");
    }

    //Valid Search Combinations
    @Test
    public void UsernameRole() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.selectOptionRole("ESS");
        adminPage.clickSearch();
        adminPage.searchResult("(1) Record Found");
    }

    @Test
    public void UsernameRoleName() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.selectOptionRole("ESS");
        adminPage.searchName(VALID_S_NAME);
        adminPage.nameAutocomplete();
        adminPage.clickSearch();
        adminPage.searchResult("(1) Record Found");
    }

    @Test
    public void UsernameRoleNameStatus() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.selectOptionRole("ESS");
        adminPage.searchName(VALID_S_NAME);
        adminPage.nameAutocomplete();
        adminPage.selectOptionStatus("Enabled");
        adminPage.clickSearch();
        adminPage.searchResult("(1) Record Found");
    }

    //Invalid Search Combinations
    @Test
    public void OKusernameNOKrole() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.selectOptionRole("Admin");
        adminPage.clickSearch();
        adminPage.searchResult("No Records Found");
        adminPage.checkSearchToastMessage("No Records Found");

    }

    @Test
    public void OKusernameOKroleNOKname() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.selectOptionRole("ESS");
        adminPage.searchName("d");
        adminPage.nameAutocomplete();
        adminPage.selectOptionStatus("Enabled");
        adminPage.clickSearch();
        adminPage.searchResult("No Records Found");
        adminPage.checkSearchToastMessage("No Records Found");
    }

    @Test
    public void OKusernameOKroleOKnameNOKstatus() throws InterruptedException {
        adminPage.searchUsername(VALID_S_USERNAME);
        adminPage.selectOptionRole("ESS");
        adminPage.searchName(VALID_S_NAME);
        adminPage.nameAutocomplete();
        adminPage.selectOptionStatus("Disabled");
        adminPage.clickSearch();
        adminPage.checkSearchToastMessage("Invalid Parameter");
    }

}
