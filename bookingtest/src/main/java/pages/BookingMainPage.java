package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.GenerateDate;

public class BookingMainPage extends BookingAbstract {

    protected Actions builder;

    @FindBy(xpath = "//*[@id='ss']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='frm']//descendant::div[@class='xp__dates xp__group']")
    private WebElement checkInList;

    @FindBy(xpath = "//*[@id='xp__guests__toggle']")
    private WebElement adultsList;

    @FindBy(xpath = "//*[@class='sb-group__field sb-group__field-adults']" +
            "//descendant::span[@class='bui-stepper__display']")
    private WebElement adultsQuantity;

    @FindBy(xpath = "//*[@class='sb-group__field sb-group__field-adults']/" +
            "/descendant::button[@class='bui-button bui-button--secondary bui-stepper__add-button ']")
    private WebElement plusButtonAdults;

    @FindBy(xpath = "//*[@class='sb-group__field sb-group__field-rooms']//" +
            "descendant::span[@class='bui-stepper__display']")
    private WebElement roomsQuantity;

    @FindBy(xpath = "//*[@class='sb-group__field sb-group__field-rooms']//" +
            "descendant::button[@class='bui-button bui-button--secondary bui-stepper__add-button ']")
    private WebElement plusButtonRooms;

    @FindBy(xpath = "//*[@id='frm']//descendant::button[@data-sb-id='main']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='filter_price']//descendant::a[@data-id='pri-5']//span[@class!='filter_count']")
    private WebElement maxPrice;

    @FindBy(xpath = "//*[@id='sort_by']//descendant::a[contains(., 'owest')]")
    private WebElement sortPrice;

    @FindBy(xpath = "//*[@id='hotellist_inner'][1]//descendant:" +
            ":div[@class='bui-price-display__value prco-inline-block-maker-helper']")
    private WebElement topElement;


    public BookingMainPage(WebDriver driver) {
        super(driver);
        this.builder = new Actions(driver);
    }

    public void openMainPage(String baseUrl) {
        driver.get(baseUrl);
    }

    public void goToSearchResultsWebDriver(String city, int rooms, int adults, int startFrom, int endingDate) {
        searchField.click();
        searchField.sendKeys(city);
        checkInList.click();
        WebElement startDate = driver.findElement(By.xpath(GenerateDate.generateDateXpath(startFrom)));
        startDate.click();
        WebElement endDate = driver.findElement(By.xpath(GenerateDate.generateDateXpath(endingDate)));
        endDate.click();
        adultsList.click();
        String quan;
        for (quan = adultsQuantity.getText(); !quan.equals(String.valueOf(adults)); quan = adultsQuantity.getText()) {
            plusButtonAdults.click();
        }
        for (quan = roomsQuantity.getText(); !quan.equals(String.valueOf(rooms)); quan = roomsQuantity.getText()) {
            plusButtonRooms.click();
        }
        searchButton.click();
    }

    void goToElementBuilder(WebElement firstItem, WebElement secondItem) {
        builder.moveToElement(firstItem)
                .moveToElement(secondItem)
                .perform();
    }

    public int getExpectedSortingPrice() {
        String maxPriceExpected = maxPrice.getText();
        maxPriceExpected = maxPriceExpected.replaceAll("[^\\d.]", "");
        maxPrice.click();
        return Integer.parseInt(maxPriceExpected) / 7;
    }

    public int getActualSortingPrice() {
        sortPrice.click();
        String price = topElement.getText();
        price = price.replaceAll("[^\\d.]", "");
        return Integer.parseInt(price) / 7;
    }
}
