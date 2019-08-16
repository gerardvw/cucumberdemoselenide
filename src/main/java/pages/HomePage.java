package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.drivermanagers.DriverManager;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#search_query_top")
    private WebElement searchQuery;

    @FindBy(css = "#searchbox > button")
    private WebElement searchButton;

    @FindBy(css = "#center_column > ul > li")
    private List<WebElement> searchResults;

    @FindBy(css = "#list > a")
    private WebElement resultsInAList;

    private By searchQueryLocator = By.cssSelector("#search_query_top");
    private By searchResultLocator = By.cssSelector("#center_column > h1 > span.heading-counter");
    private By searchResultIsListLocator = By.cssSelector("ul[class='product_list row list']");
    private By searchResultItemNameLocator = By.cssSelector("h5[itemprop='name'] > a");
    private By searchResultItemAvailabilityLocator = By.cssSelector("span[class='availability'] > span");
    private By searchResultItemPriceLocator = By.cssSelector("span[itemprop='price']");
    private By searchResultItemtAddToCartLocator = By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default");

    @Override
    protected void waitUntilPageIsLoaded() {
        super.waitUntilPageIsLoaded();
        DriverManager.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(searchQueryLocator));
    }

    @Override
    protected String getRelativeUrl() {
        return "/index.php";
    }

    public void searchFor(String searchTerm) {
        searchQuery.sendKeys(searchTerm);
        searchButton.click();
        waitUntilPageIsLoaded();
        waitUntilSearchResultAvailable();
    }

    public void selectResultsInAList() {
        resultsInAList.click();
        waitUntilResultsInAList();
    }

    public boolean addToCartIsAvailable(int actualItemNumber) {
        return searchResults.get(actualItemNumber).findElement(searchResultItemtAddToCartLocator).isEnabled();
    }

    public int getItemNumberFromSearchResultList(String expectedDescription, String expectedAvailability, String expectedPrice) {
        int itemNumber = -1;

        for (WebElement item : searchResults) {
            itemNumber++;

            String actualDescription = item.findElement(searchResultItemNameLocator).getText();
            String actualAvailabiliy = item.findElement(searchResultItemAvailabilityLocator).getText();
            //Workaround for failing method getText
            String actualPrice = item.findElement(searchResultItemPriceLocator).getAttribute("innerText").replace("\t","").replace("\n","");

            if (actualDescription.equals(expectedDescription) && actualAvailabiliy.equals(expectedAvailability) && actualPrice.equals(expectedPrice)) {
                break;
            }
        }
        return itemNumber;
    }

    private void waitUntilResultsInAList() {
        DriverManager.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(searchResultIsListLocator));
    }

    private void waitUntilSearchResultAvailable() {
        DriverManager.getWebDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(searchResultLocator, "been found."));
    }
}
