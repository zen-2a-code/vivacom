package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;

    private WebElement acceptCookiesBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        // cookie banner:
        // Even though the banner it’s not explicitly mentioned in the task, it’s part of making test robust and better
        // Showcase real-life scenario.
        this.acceptCookiesBtn = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));

    }

    public void clickCookiesBtn(){
        this.acceptCookiesBtn.click();
    }
}