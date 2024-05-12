package bg.vivacom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCardPage extends BasePageObject {
    private String shoppingCardUrl = "https://www.vivacom.bg/online/bg/shop/shopping-cart";
    private By continueShoppingBtnLocator = By.linkText("Продължи с пазаруването");
    private By totalPriceElLocator = By.xpath("//span[starts-with(@class, 'e-care-home-big-bill-price-d')]");
    private By purchaseAsExistingClientBtnLocator = By.xpath("//button[text()='Поръчай като настоящ клиент']");
    private By purchaseAsNewClientBtnLocator = By.xpath("//button[text()='Поръчай като нов клиент']");
    private By tAndCCheckboxLocator = By.xpath("//div[@class='checkbox-with-link-label']/label");
    private By closeBtnLocator = By.xpath("//button[@class='btn-close'][@type='submit']");
    private By basketElTxtLocator = By.xpath("//div[@class='empty-shopping-cart']/p");

    // added for readability
    private By allItemsLocator = By.xpath("//button[@class='btn-close'][@type='submit']");

    // Product APPLE IPHONE 15 PLUS 128GB+ADAPTER
    private By productApple15Plus128Locator;


    public ShoppingCardPage(WebDriver driver) {
        super(driver);
    }

    public String getExpectedShoppingCardUrl() {
        return shoppingCardUrl;
    }

    public void clickContinueShoppingBtn() {
        click(continueShoppingBtnLocator, 10);
    }


    public double getTotalSum() {
//        System.out.println(this.totalPriceEl.getText());

        String totalSumString = find(this.totalPriceElLocator).getText().replaceAll("[^\\d.лв]", "");
        totalSumString = totalSumString.replace("лв.", "");
        double totalSum = Double.parseDouble(totalSumString);
        return totalSum;
    }

    public void removeLastAddedItemFromShoppingCard() {
        waitForVisibilityOf(this.closeBtnLocator, 20);
        click(this.closeBtnLocator, 15);
    }

    public void removeAllElements() {
        List<WebElement> allItems = findElements(this.allItemsLocator);

        // Not sure why I need to put the Thread to sleep. Tried with diffrent wait conditions - none worked. I will be
        // Happy to receive feedback of the correct method.

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while sleeping");
        }

        for (WebElement item : allItems) {

            this.removeLastAddedItemFromShoppingCard();
        }
    }

    public boolean isPurchaseAsExistingClientBtnDisabled() {
        return isElementAttributePresent(this.purchaseAsExistingClientBtnLocator, "class", "disable-elm");
    }

    public boolean isPurchaseAsNewClientBtnDisabled() {
        return isElementAttributePresent(this.purchaseAsNewClientBtnLocator, "class", "disable-elm");
    }


    public void clickTandCCheckbox() {
        click(this.tAndCCheckboxLocator, 10);
    }

    public WebElement getCheckboxTnCEl() {

        waitForVisibilityOf(this.tAndCCheckboxLocator, 15);
        return find(this.tAndCCheckboxLocator);
    }

    public String getEmptyBasketText() {
        waitForVisibilityOf(this.basketElTxtLocator, 20);
        WebElement basketEl = find(basketElTxtLocator);
        return basketEl.getText();
    }

    public String getCurrentUrl() {
        return getCurrentUrl(this.shoppingCardUrl, 10);
    }

}

