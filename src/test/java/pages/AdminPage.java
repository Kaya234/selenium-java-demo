package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);

    }

    //Search function
    static By S_USERNAME_TEXTBOX = By.cssSelector(":nth-child(2) > .oxd-input");
    static By S_NAME_TEXTBOX = By.cssSelector(".oxd-autocomplete-text-input > input");
    static By S_NAME_AUTOCOMPLETE = By.cssSelector(".oxd-autocomplete-dropdown");
    static By SEARCH_BUTTON = By.cssSelector(".oxd-form-actions > .oxd-button--secondary");

    static By SEARCH_TABLE = By.cssSelector(".oxd-table-body");

    //User role dropdown
    static By S_ROLE_DROPDOWN =
            By.cssSelector(":nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-select-wrapper > .oxd-select-text");
    static By S_ROLE_TEXT =
            By.xpath("//div[2]/div[3]/div/div[2]/div/div/div[3]/div");

    //Status dropdown
    static By S_STATUS_DROPDOWN =
            By.cssSelector(":nth-child(4) > .oxd-input-group > :nth-child(2) > .oxd-select-wrapper > .oxd-select-text");
    static By S_STATUS_TEXT = By.xpath("//div[2]/div[3]/div/div[2]/div/div/div[5]/div");


    public void goToAdminPage() {
        clickContainText("Admin");

    }

    public void checkDefaultInputValues() {
        assertTrueEmpty(S_USERNAME_TEXTBOX);
        assertTrueText(S_ROLE_DROPDOWN, "Select");
        assertTrueEmpty(S_NAME_TEXTBOX);
        assertTrueText(S_STATUS_DROPDOWN, "Select");

    }

    public void searchUsername(String username) {
        type(S_USERNAME_TEXTBOX, username);

    }

    public void searchName(String name) {
        type(S_NAME_TEXTBOX, name);

    }

    public void nameAutocomplete() throws InterruptedException {
        autocomplete(S_NAME_AUTOCOMPLETE);

    }

    public void clickSearch() {
        clickOn(SEARCH_BUTTON);

    }

    public void searchResult(String message) {
        assertTrueSearchResult(message);

    }

    public void selectOptionRole(String option) {
        clickOn(S_ROLE_DROPDOWN);
        clickContainTextDropdown(option);

    }

    public void checkSearchResultRole(String role) {
        assertTrueList(SEARCH_TABLE, S_ROLE_TEXT, role);

    }

    public void selectOptionStatus(String option) {
        clickOn(S_STATUS_DROPDOWN);
        clickContainTextDropdown(option);

    }

    public void checkSearchResultStatus(String status) {
        assertTrueList(SEARCH_TABLE, S_STATUS_TEXT, status);

    }

    public void checkSearchToastMessage(String text) {
        assertTrueToast(text);

    }

}
