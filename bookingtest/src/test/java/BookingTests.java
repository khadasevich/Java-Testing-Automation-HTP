import org.junit.Assert;
import pages.BookingMainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BookingTests {

    protected WebDriver driver;
    private static final String BOOKING_URL = "https://www.booking.com/";
    private static final String cityOne = "Paris";
    BookingMainPage bookingMainPage;

    @Before
    public void startBrowser() {
        String pathToDriver = BookingTests.class.getClassLoader().getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        bookingMainPage = new BookingMainPage(driver);
    }

    @Test
    public void lowestPriceSortingTest() {
        bookingMainPage.openMainPage(BOOKING_URL);
        bookingMainPage.goToSearchResultsWebDriver(cityOne, 2, 4, 3, 10);
        int expected = bookingMainPage.getExpectedSortingPrice();
        int actual = bookingMainPage.getActualSortingPrice();
        Assert.assertTrue(expected > actual || expected == actual);
    }

    @After
    public void stopBrowser() {
        driver.close();
        driver.quit();
    }
}
