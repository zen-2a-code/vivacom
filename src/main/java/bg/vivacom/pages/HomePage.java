package bg.vivacom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePageObject {
    private By acceptCookiesBtnLocator = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCookiesBtn() {
        // cookie banner:
        // Even though the banner it’s not explicitly mentioned in the task, it’s part of making test robust and better
        // Showcase real-life scenario.
        click(acceptCookiesBtnLocator,5);
    }
}