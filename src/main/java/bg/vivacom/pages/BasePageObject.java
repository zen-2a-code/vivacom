package bg.vivacom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageObject {
    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Open page with given URL
     */
    protected void openURL(String url) {
        driver.get(url);
    }

    /**
     * Find and return an element using given locator
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // overloading doesn't work here and even if it worked will produce unexpected results
    // as both accept the same parameter

    /**
     * Find and return all elements using given locator
     */
    protected List<WebElement> findElements(By locator) {
        waitForVisibilityOf(locator, 15);
        return driver.findElements(locator);
    }

    /**
     * Click on an element with given locator and wait for the element to be visible
     * IF the waitSeconds are omitted there is no wait.
     */
    protected void click(By locator, int... waitSeconds) {
        if (waitSeconds != null && waitSeconds.length > 0) {
            waitForVisibilityOf(locator, waitSeconds[0]); // take the first item - the seconds
        }
        find(locator).click();
    }


    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private void waitFor(ExpectedCondition<WebElement> condition, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page - 2 attempts
     */
    protected void waitForVisibilityOf(By locator, int seconds) {
        int attempts = 1;

        // Using while loop instead of for loop to terminate the whole cycle instead of iteration if the
        // element is found.
        while (attempts <= 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), seconds);
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    protected void waitForElementToBeClickable(By locator, int seconds) {
        int attempts = 1;

        while (attempts <= 2) {
            try {
                waitFor(ExpectedConditions.elementToBeClickable(locator), seconds);
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /**
     * @param locator   The locator to find the element.
     * @param attribute The attribute to check.
     * @param text      The text to look for within the attribute's value.
     * @return true  If a button is disabled and false otherwise
     */
    protected boolean isElementAttributePresent(By locator, String attribute, String text) {
        waitForVisibilityOf(locator, 10);
        WebElement element = find(locator);
        String attributeValue = element.getAttribute(attribute);
        return attributeValue.contains(text);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // override to wait for a specific URL

    /**
     * @param expectedURL The URL that we expect to get
     * @param seconds     How long to wait before getting the actual URL
     * @return String - the current URL of the page
     */
    public String getCurrentUrl(String expectedURL, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(
                ExpectedConditions.urlToBe(expectedURL));
        return driver.getCurrentUrl();
    }
}
