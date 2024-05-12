package bg.vivacom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage extends BasePageObject {

    // Filters
    private By brandAppleFitterCheckboxLocator = By.xpath("//input[@class='f-APPLE']/following-sibling::em");
    private By blueColorCheckboxLocator = By.xpath("//input[@class='f-BLUE']/following-sibling::em");
    private By priceAbove40FilterCheckboxLocator = By.xpath("//input[@class='f-price-more-than-forty radio']/following-sibling::em");

    // Products
    private By productApple15Plus128Locator = By.xpath("//h3[text()='APPLE IPHONE 15 PLUS 128GB+ADAPTER']");
    private By productAppleCaseFineWoven15PlusLocator = By.xpath("//h3[contains(text(), 'APPLE iPhone 15 Plus FineWoven Taupe')]");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void clickonCase15plusFineWoven() {
        waitForElementToBeClickable(this.productAppleCaseFineWoven15PlusLocator, 20);
        click(this.productAppleCaseFineWoven15PlusLocator, 5);
    }

    public void clickAppleBrandFitterCheckbox() {
        click(this.brandAppleFitterCheckboxLocator, 15);
    }

    public void clickSBlueColorFilterCheckbox() {
        click(this.blueColorCheckboxLocator, 15);

    }

    public void clickApple15Plus128() {
        waitForVisibilityOf(this.productApple15Plus128Locator, 20);
        click(productApple15Plus128Locator, 20);
    }


    public void clickPriceAbove40FilterCheckbox() {
        click(priceAbove40FilterCheckboxLocator, 15);
    }

}
