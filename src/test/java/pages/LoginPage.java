package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    //Login
    static String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    static By LOGIN_BUTTON = By.cssSelector(".oxd-button");
    static By USERNAME_TEXTBOX = By.name("username");
    static By PASSWORD_TEXTBOX = By.name("password");
    static By PAGE_TITLE = By.className("oxd-text--h6");

    //Login errors
    static By ERROR_LOGIN = By.cssSelector(".oxd-alert-content-text");
    static By ERROR_USERNAME_INPUT = By.xpath("//form/div[1]/div/span");
    static By ERROR_PASSWORD_INPUT = By.xpath("//form/div[2]/div/span");

    //Reset password
    static By RESET_BUTTON = By.cssSelector(".orangehrm-login-forgot-header");
    static By RESET_TEXTBOX = By.cssSelector(".oxd-input");
    static By RESET_BUTTON_SUBMIT = By.cssSelector(".oxd-button--secondary");
    static By RESET_BUTTON_CANCEL = By.cssSelector(".oxd-button--ghost");
    static By RESET_ERROR_USERNAME_INPUT = By.cssSelector(".oxd-input-group > .oxd-text");
    static By RESET_SUCCESS_INFO = By.cssSelector(".oxd-text--h6");
    static By LOGIN_PAGE_TITLE = By.cssSelector(".orangehrm-login-title");

    //Logout
    static By PROFILE_DROPDOWN = By.cssSelector(".oxd-userdropdown-tab");
    static By LOGOUT_BUTTON = By.cssSelector(":nth-child(4) > .oxd-userdropdown-link");


    public void goToUrl() {
        visit(URL);

    }

    public void login() {
        type(USERNAME_TEXTBOX, "Admin");
        type(PASSWORD_TEXTBOX, "admin123");
        clickOn(LOGIN_BUTTON);

    }

    public void enterUsername(String username) {
        type(USERNAME_TEXTBOX, username);

    }

    public void enterPassword(String password) {
        type(PASSWORD_TEXTBOX, password);

    }

    public void clickLogin() {
        clickOn(LOGIN_BUTTON);

    }

    public void checkValidLogin() {
        assertTrueText( PAGE_TITLE, "Dashboard");

    }

    public void checkInvalidLoginError() {
        assertTrueText( ERROR_LOGIN, "Invalid credentials");

    }

    public void checkInputErrorUsername() {
        assertTrueText( ERROR_USERNAME_INPUT, "Required");

    }

    public void checkInputErrorPassword() {
        assertTrueText( ERROR_PASSWORD_INPUT, "Required");

    }

    public void resetEnterUsername(String username) {
        type(RESET_TEXTBOX, username);

    }

    public void clickReset() {
        clickOn(RESET_BUTTON);

    }

    public void clickResetSubmit() {
        clickOn(RESET_BUTTON_SUBMIT);

    }

    public void clickResetCancel() {
        clickOn(RESET_BUTTON_CANCEL);

    }

    public void checkResetInputError() {
        assertTrueText( RESET_ERROR_USERNAME_INPUT, "Required");

    }

    public void checkResetSuccessInfo() {
        assertTrueText( RESET_SUCCESS_INFO, "Reset Password link sent successfully");

    }

    public void checkReturnToLoginPage() {
        assertTrueText( LOGIN_PAGE_TITLE, "Login");

    }

    public void logout() {
        clickOn(PROFILE_DROPDOWN);
        clickOn(LOGOUT_BUTTON);

    }

    public void checkEmptyInputs() {
        assertTrueEmpty(USERNAME_TEXTBOX);
        assertTrueEmpty(PASSWORD_TEXTBOX);

    }

}