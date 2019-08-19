package pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import util.properties.EnvironmentProperties;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#search_query_top")
    private SelenideElement searchQuery;

    @FindBy(css = "#searchbox > button")
    private SelenideElement searchButton;

    @FindBy(css = "#center_column > ul > li")
    private List<SelenideElement> searchResults;

    @FindBy(css = "#list > a")
    private SelenideElement resultsInAList;

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
        $(searchQueryLocator).waitUntil(Condition.appears, EnvironmentProperties.getTimeoutInMilliSeconds());
    }

    @Override
    protected String getRelativeUrl() {
        return "/index.php";
    }

    public void searchFor(String searchTerm) {
        searchQuery.setValue(searchTerm);
        searchButton.click();

        waitUntilPageIsLoaded();
        waitUntilSearchResultAvailable();
    }

    public void selectResultsInAList() {
        resultsInAList.click();
        waitUntilResultsInAList();
    }

    public boolean addToCartIsAvailable(int actualItemNumber) {
        return searchResults.get(actualItemNumber).$(searchResultItemtAddToCartLocator).isEnabled();
    }

    public int getItemNumberFromSearchResultList(String expectedDescription, String expectedAvailability, String expectedPrice) {
        int itemNumber = -1;

        for (SelenideElement item : searchResults) {
            itemNumber++;

            String actualDescription = item.$(searchResultItemNameLocator).getText();
            String actualAvailabiliy = item.$(searchResultItemAvailabilityLocator).getText();
            //Workaround for failing method getText
            String actualPrice = item.$(searchResultItemPriceLocator).getAttribute("innerText").replace("\t","").replace("\n","");

            if (actualDescription.equals(expectedDescription) && actualAvailabiliy.equals(expectedAvailability) && actualPrice.equals(expectedPrice)) {
                break;
            }
        }
        return itemNumber;
    }

    private void waitUntilResultsInAList() {
        $(searchResultIsListLocator).waitUntil(Condition.appears, 10000);
    }

    private void waitUntilSearchResultAvailable() {
        $(searchResultLocator).shouldHave(Condition.matchesText(".*been found."));
    }
}
