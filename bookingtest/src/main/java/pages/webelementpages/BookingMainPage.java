package pages.webelementpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.findbypages.BookingAbstractPage;

import static utils.BookingUtilities.generateDateXpath;
import static utils.BookingUtilities.getPriceForNight;


public class BookingMainPage {


    private String searchFieldXpath = "//*[@id='ss']";

    private String checkInListXpath = "//*[@id='frm']//descendant::div[@class='xp__dates xp__group']";

    private String adultsListXpath = "//*[@id='xp__guests__toggle']";


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



}
