import createdriver.Driver;
import org.junit.Assert;
import pages.findbypages.BookingMainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class BookingSteps {

    protected WebDriver driver;
    private static final String BOOKING_URL = "https://www.booking.com/";
    BookingMainPage bookingMainPage;

    @Before
    public void startBrowser() {
        driver = Driver.getWebdriver();
        Driver.setTiemout();
        Driver.maximize();
        bookingMainPage = new BookingMainPage(driver);
    }

    @Test
    public void parisTest() {
        bookingMainPage.openMainPage(BOOKING_URL);
        bookingMainPage.goToSearchResultsWebDriver("Paris", 2, 0, 4, 3, 10);
        int expected = bookingMainPage.getMaxFilterPrice();
        int actual = bookingMainPage.getActualMinSortingPrice(7);
        Assert.assertTrue(expected < actual || expected == actual);
    }

    @Test
    public void moscowTest() {
        bookingMainPage.openMainPage(BOOKING_URL);
        bookingMainPage.goToElementBuilder("Moscow", 2, 0, 4, 10, 15);
        int expected = bookingMainPage.getMinFilterPrice();
        int actual = bookingMainPage.getActualTopElementPrice(5);
        Assert.assertTrue(expected > actual);
    }

    @Test
    public void osloTest() throws InterruptedException {
        bookingMainPage.openMainPage(BOOKING_URL);
        bookingMainPage.goToSearchResultsWebDriver("Oslo", 1, 2, 2, 1, 2);
        bookingMainPage.filterHotelsByStars();
        String expected = "rgba(255, 0, 0, 1)";
        assertEquals("Color isn't red", expected, bookingMainPage.getColorOfAddress());
    }

    @After
    public void stopBrowser() {
        Driver.closeDriver();
    }
}
