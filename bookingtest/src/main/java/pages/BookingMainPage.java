package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenerateDate;

public class BookingMainPage extends BookingAbstract {

    protected Actions builder;

    WebDriverWait wait = new WebDriverWait(driver,5);

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

    @FindBy(xpath = "//*[@class='sb-group__field sb-group-children ']//descendant::span[@class='bui-stepper__display']")
    private WebElement childrenQuantity;

    @FindBy(xpath = "//*[@class='sb-group__field sb-group-children ']" +
            "//descendant::button[@class='bui-button bui-button--secondary bui-stepper__add-button ']")
    private WebElement plusButtonChildren;

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

    @FindBy(xpath = "//*[@id='filter_price']//descendant::a[@data-id='pri-1']//span[@class!='filter_count']")
    private WebElement minPrice;

    @FindBy(xpath = "//*[@id='sort_by']//descendant::a[contains(., 'owest')]")
    private WebElement sortPrice;

    @FindBy(xpath = "(//*[@id='hotellist_inner'][1]//descendant:" +
            ":div[@class='bui-price-display__value prco-inline-block-maker-helper'])[1]")
    private WebElement topElement;

    @FindBy(xpath = "(//*[@id='hotellist_inner']//div[@class='sr_rooms_table_block clearfix '])" +
            "[1]//descendant::div[@class='bui-price-display__value prco-inline-block-maker-helper']")
    private WebElement tenElement;

    @FindBy(xpath = "//*[@id='b2searchresultsPage']/div[20]")
    private WebElement overlay;


    public BookingMainPage(WebDriver driver) {
        super(driver);
        this.builder = new Actions(driver);
    }

    public void openMainPage(String baseUrl) {
        driver.get(baseUrl);
    }

    public void goToSearchResultsWebDriver(String city, int rooms, int children, int adults,
                                           int startFrom, int endingDate) {
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
        for (quan = childrenQuantity.getText(); !quan.equals(String.valueOf(children)); quan = childrenQuantity.getText()) {
            plusButtonChildren.click();
        }
        for (quan = roomsQuantity.getText(); !quan.equals(String.valueOf(rooms)); quan = roomsQuantity.getText()) {
            plusButtonRooms.click();
        }
        searchButton.click();
    }

    public void goToElementBuilder(String city, int rooms, int children, int adults,
                                   int startFrom, int endingDate) {
        WebElement startDate = driver.findElement(By.xpath(GenerateDate.generateDateXpath(startFrom)));
        WebElement endDate = driver.findElement(By.xpath(GenerateDate.generateDateXpath(endingDate)));
        builder.moveToElement(searchField)
                .click()
                .sendKeys(city)
                .moveToElement(checkInList)
                .click()
                .moveToElement(startDate)
                .click()
                .moveToElement(endDate)
                .click()
                .moveToElement(adultsList)
                .click()
                .build()
                .perform();
        String quan;
        for (quan = adultsQuantity.getText(); !quan.equals(String.valueOf(adults)); quan = adultsQuantity.getText()) {
            builder.moveToElement(plusButtonAdults).click().build().perform();
        }
        for (quan = childrenQuantity.getText(); !quan.equals(String.valueOf(children)); quan = childrenQuantity.getText()) {
            builder.moveToElement(plusButtonChildren).click().build().perform();
        }
        for (quan = roomsQuantity.getText(); !quan.equals(String.valueOf(rooms)); quan = roomsQuantity.getText()) {
            builder.moveToElement(plusButtonRooms).click().build().perform();
        }
        builder.moveToElement(searchButton).click().build().perform();
    }

    public int getExpectedMaxFilterPrice() {
        String price = maxPrice.getText();
        maxPrice.click();
        return getPriceForNight(price, 1);
    }

    public int getActualMinSortingPrice(int interval) {
        sortPrice.click();
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        String price = topElement.getText();
        return getPriceForNight(price, interval);
    }

    public int getExpectedMinFilterPrice() {
        String price = minPrice.getText();
        minPrice.click();
        return getPriceForNight(price, 1);
    }

    public int getActualTopElementPrice(int interval) {
        wait.until(ExpectedConditions.invisibilityOf(overlay));
        String price = topElement.getText();
        return getPriceForNight(price, interval);
    }

    int getPriceForNight(String cost, int interval) {
        return Integer.parseInt(cost.replaceAll("[^\\d.]", "")) / interval;
    }
}
