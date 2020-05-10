package pages.findbypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingResultsPage extends BookingAbstractPage {

    @FindBy(xpath = "//*[@id='filter_price']//descendant::a[@data-id='pri-5']//span[@class!='filter_count']")
    private WebElement maxPrice;

    @FindBy(xpath = "//*[@id='filter_price']//descendant::a[@data-id='pri-1']//span[@class!='filter_count']")
    private WebElement minPrice;

    @FindBy(xpath = "//*[@id='sort_by']//descendant::a[contains(., 'owest')]")
    private WebElement sortPrice;

    @FindBy(xpath = "(//*[@id='hotellist_inner']//descendant::" +
            "div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper'])[1]")
    private WebElement topElement;

    @FindBy(xpath = "(//*[@id='hotellist_inner']//div[@class='sr_rooms_table_block clearfix '])" +
            "[10]//descendant::div[@class='bui-price-display__value " +
            "prco-text-nowrap-helper prco-inline-block-maker-helper'']")
    private WebElement tenElement;

    @FindBy(xpath = "//*[@id='b2searchresultsPage']/div[20]")
    private WebElement overlay;

    @FindBy(xpath = "//*[@id='filter_class']//descendant::span[contains(., '3 stars')]")
    private WebElement threeStars;

    @FindBy(xpath = "//*[@id='filter_class']//descendant::span[contains(., '4 stars')]")
    private WebElement fourStars;

    @FindBy(xpath = "(//*[@id='hotellist_inner']//a[@class='hotel_name_link url'])[10]//span[@data-et-click]")
    private WebElement address;

    public BookingResultsPage(WebDriver driver) {
        super(driver);
    }
}
