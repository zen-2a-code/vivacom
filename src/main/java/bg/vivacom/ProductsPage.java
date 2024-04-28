package bg.vivacom;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProductsPage {
    private WebDriver driver;

    // SmartPhoneFilters
    private WebElement smartPhoneBrandAppleFitter;
    private WebElement smartPhoneBlueColorFilter;

    // Accessories Filters
    private WebElement accessoriesBrandAppleFilter;
    private WebElement accessoriesPriceAbove40Filter;

    // Products
    private WebElement productApple15Plus128;
    private WebElement productAppleCaseFineWoven15Plus;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void initializeAccessoriesFilters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.accessoriesBrandAppleFilter = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='filter-manufacturer']/label[2]/em")));
        this.accessoriesPriceAbove40Filter = this.driver.findElement(By.
                xpath("//div[@id='filter-price']/label[3]/em")); // TODO find better selector
    }

    public void initializeSmartPhoneFilters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.smartPhoneBrandAppleFitter = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='filter-manufacturer']/label[1]/em")));
        this.smartPhoneBlueColorFilter = this.driver.findElement(By.
                xpath("//div[@id='filter-colors.color']/label[2]/em")); // TODO find better selector
    }

    public void initializeProductApple15Plus128() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(StaleElementReferenceException.class);
        this.productApple15Plus128 = fluentWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h3[text()='APPLE IPHONE 15 PLUS 128GB+ADAPTER']")));
    }

    public void initializeProductAppleCase15plus() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(StaleElementReferenceException.class);
        this.productAppleCaseFineWoven15Plus = fluentWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h3[contains(text(), 'APPLE iPhone 15 Plus FineWoven Taupe')]")));


    }

    public void clickonCase15plusFineWoven() {
        initializeProductAppleCase15plus();
        //Not sophisticated, but it works. Some issues arise with elements disappearing due to filters.
        // Looking forward to feedback.
        initializeProductAppleCase15plus();
        this.productAppleCaseFineWoven15Plus.click();
    }

    public void clickSmartPhoneAppleBrandFitter() {
        this.smartPhoneBrandAppleFitter.click();
    }

    public void clickSmartPhoneBlueColorFilter() {

        this.smartPhoneBlueColorFilter.click();

    }

    public void clickApple15Plus128() {
        initializeProductApple15Plus128();
        // Not sophisticated, but it works. Some issues arise with elements disappearing due to filters.
        // Looking forward to feedback.
        initializeProductApple15Plus128();
        this.productApple15Plus128.click();
    }

    public void clickAccessoriesBrandAppleFilter() {
        accessoriesBrandAppleFilter.click();
    }

    public void clickAccessoriesPriceAbove40Filter() {
        accessoriesPriceAbove40Filter.click();
    }

}
